package control;

import dao.ClienteDAO;
import dao.IngredienteDAO;
import dao.PedidoDAO;
import dao.ProductoDAO;
import dao.VentaDAO;
import dominio.Cliente;
import dominio.Ingrediente;
import dominio.Pedido;
import dominio.Producto;
import interfaces.IClienteDAO;
import interfaces.IIngredienteDAO;
import interfaces.IPedidoDAO;
import interfaces.IProductoDAO;
import interfaces.IVentaDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import util.CalculoEnvio;
import util.CalculoMetrosEnvio;
import util.DBConector;
import util.enums.EstadoPedidos;
import vista.FrmRevisarPedidos;
import vista.FrmSeleccionarDosFechas;

/**
 * Clase que lleva el control de los pedidos en la aplicación.
 * @author Samuel Vega & Pedro Moya & Juan Sánchez
 */
public class ControlPedidos {
    // Instancia única de la clase
    private static ControlPedidos instancia;
    
    private FrmRevisarPedidos frmRevisarPedidos;
    private FrmSeleccionarDosFechas frmSeleccionarFechas;
    
    // Declaración de utilidades de los pedidos
    private List<Pedido> listaPedidos;
    private List<Producto> productosPedidos;
    private List<Integer> cantidadPorProducto;
    private float costoTotal;
    private float costoEnvio;
    
    // Objetos de control
    private ControlVentas cVentas = ControlVentas.getInstance();
    
    /**
     * Constructor que inicializa ciertos atributos.
     */
    private ControlPedidos() {
        this.productosPedidos = new ArrayList<>();
        this.cantidadPorProducto = new ArrayList<>();
        
        this.cVentas = ControlVentas.getInstance();
    }
    
    /**
     * Crea una instancia de la clase si es que no la hay y devuelve una que ya este creada.
     * @return Instancia de la clase.
     */
    public static ControlPedidos getInstance() {
        if(instancia == null) {
            instancia = new ControlPedidos();
        }
        return instancia;
    }
    
    /**
     * Realiza un pedido que haya pedido un cliente y lo registra.
     * @param cliente Cliente que pidió el pedido.
     * @param pedido Pedido que pidió.
     */
    public void realizarPedido(Cliente cliente, Pedido pedido) {
        IClienteDAO clientes = new ClienteDAO(new DBConector().getEM());
        IPedidoDAO pedidos = new PedidoDAO(new DBConector().getEM());
        
        if(clientes.obten(cliente.getTelefono()) == null) {
            clientes = new ClienteDAO(new DBConector().getEM());
            clientes.agregarCliente(cliente);
        }
        
        pedidos.agregarPedido(pedido);
        cVentas.registrarVenta(pedido, productosPedidos, cantidadPorProducto);
        
        JOptionPane.showMessageDialog(ControlVentanas.getInstance().getRealizarPedido(), "Se agregó correctamente el pedido.", "Agregado exitoso.", JOptionPane.PLAIN_MESSAGE);
    }
    
    /**
     * Calcula el costo de envío según la dirección que se le otorga en el parámetro.
     * @param direccion Dirección del cliente en un formato que contenga la calle, el número de casa y la colonia como mínimo.
     * @throws IOException Si hay un error de entrada/salida.
     * @throws InterruptedException Si se interrumpe el proceso.
     */
    public void calcularCostoEnvio(String direccion) throws IOException, InterruptedException {
        // Se le agrega Ciudad Obregón porque la sucursal solo esta en Obregón.
        direccion += ", Ciudad Obregón";
        // Calcula los metros desde la sucursal hasta la dirección del cliente.
        CalculoMetrosEnvio metros = new CalculoMetrosEnvio();
        // Calcula el costo según una tarifa definida por la empresa.
        CalculoEnvio envio = new CalculoEnvio();
        
        int metrosEnvio = metros.getDistanciaMetros(direccion);
        double kilometrosEnvio = metrosEnvio / 1000.0;
        
        String distancia = String.format("%.1f km", kilometrosEnvio);
        
        costoEnvio = envio.calcularCostoEnvio(metrosEnvio);
        
        Object[] botones = {"Agregar", "Cancelar"};
        
        // Muestra el precio de envío y pregunta si el usuario quiere agregar el costo al pedido.
        int resp = JOptionPane.showOptionDialog(ControlVentanas.getInstance().getRealizarPedido(), "¿Desea agregar el envío? \n kilometros: " +  distancia + " \n envío: $ " + costoEnvio, "Costo de Envío Calculado", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, botones, botones[0]);
        
        // Si se agrega el costo
        if(resp == 0) {
            // Se agrega al costo total del pedido.
            this.costoTotal += costoEnvio;
            // Agrega el envío a la ventana de realizar pedido.
            ControlVentanas.getInstance().agregarCostoEnvio(costoEnvio, costoTotal);
        }
    }
    
    /**
     * Limpia los datos del pedido cada que se cierra la ventana de realizar pedido.
     */
    public void limpiarDatosPedido() {
        this.costoTotal = 0.0f;
        this.costoEnvio = 0.0f;
        this.productosPedidos.clear();
    }
    
    /**
     * Regresa la lista de productos presentes en el pedido.
     * @return La lista de productos presentes en el pedido.
     */
    public List<Producto> obtenerProductosPedidos() {
        return this.productosPedidos;
    }
    
    /**
     * Regresa la lista de cantidades que tiene cada producto del pedido.
     * @return La lista de cantidades que tiene cada producto del pedido.
     */
    public List<Integer> obtenerCantidadesPorProducto() {
        return this.cantidadPorProducto;
    }
    
    // Getter & Setter: Costo Total
    public float getCostoTotal() {
        return costoTotal;
    }
    
    public void setCostoTotal(float costoTotal) {
        this.costoTotal = costoTotal;
    }
    
    /**
     * Regresa el costo de envío del pedido.
     * @return El costo de envío del pedido.
     */
    public float obtenerCostoEnvio() {
        return this.costoEnvio;
    }
    
    /**
     * Regresa la lista de productos en la base de datos.
     * @return La lista de productos en la base de datos.
     */
    public List<Producto> obtenerListaProductos() {
        IProductoDAO productos = new ProductoDAO(new DBConector().getEM());
        return productos.obtenerProductos();
    }
    
    /**
     * Regresa la lista de ingredientes en la base de datos.
     * @return La lista de ingredientes en la base de datos.
     */
    public List<Ingrediente> obtenerListaIngredientes() {
        IIngredienteDAO ingredientes = new IngredienteDAO(new DBConector().getEM());
        return ingredientes.obtenerIngredientes();
    }
    
    /**
     * Agrega un producto a la lista del pedido.
     * @param producto Producto a agregar al pedido.
     */
    public void agregarProducto(Producto producto) {
        // Cada que se agrega un producto, se agrega en una cantidad de uno.
        this.cantidadPorProducto.add(1);
        this.productosPedidos.add(producto);
    }
    
    /**
     * Agrega ingredientes al pedido, los que prefiera el cliente.
     * @param cantidad Cantidad de ingredientes que pidió.
     * @param extras Ingredientes que el cliente agregó.
     * @param fila Pedido al que le agregó los ingredientes.
     */
    public void agregarIngredientes(int cantidad, String extras, int fila) {
        // *Este costo extra es variable, recordar poner un campo donde poder cambiarlo a preferencia de la empresa
        float costoExtra = 15.0f * cantidad;
        
        // Agrega los extras al nombre del producto
        String descripcion = this.productosPedidos.get(fila).getNombre() + " " + extras;
        
        this.productosPedidos.get(fila).setNombre(descripcion);
        // Suma el precio de los extras al precio del pedido
        this.productosPedidos.get(fila).setPrecio(this.productosPedidos.get(fila).getPrecio() + costoExtra);
    }
    
    /**
     * Envía un pedido una vez que haya sido cocinado.
     * @param id ID del pedido a enviar.
     */
    public void enviarPedido(Long id) {
        IPedidoDAO pedidos = new PedidoDAO(new DBConector().getEM());
        
        Object[] botones = {"Regresar", "Enviar"};
        
        // Pide confirmación
        int resp = JOptionPane.showOptionDialog(ControlVentanas.getInstance().getMain(), "¿Seguro que quiere enviar el pedido " + id + "?", "Confirmación sobre envío de pedido", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, botones, botones[0]);
        
        if(resp == 1) {
            Pedido pedido = pedidos.obten(id);
            pedido.setEstado(EstadoPedidos.ENVIADO);
            
            pedidos = new PedidoDAO(new DBConector().getEM());
            
            pedidos.modificarPedido(pedido);
            ControlVentanas.getInstance().mostrarVentanaPrincipal();
        }
    }
    
    /**
     * Registra como venta un pedido que ya fue entregado.
     * @param id ID del pedido a registrar como venta.
     */
    public void registrarVentaPedido(Long id) {
        IPedidoDAO pedidos = new PedidoDAO(new DBConector().getEM());
        IVentaDAO ventas = new VentaDAO(new DBConector().getEM());
        
        Pedido pedido = pedidos.obten(id);
        pedido.setEstado(EstadoPedidos.PAGADO);
        
        pedidos = new PedidoDAO(new DBConector().getEM());
        
        pedidos.modificarPedido(pedido);
        
        // Modifica también las ventas que se relacionan con el pedido
        cVentas.verificarVenta(ventas.obtenVentasPedido(pedido));
        ControlVentanas.getInstance().mostrarVentanaPrincipal();
    }
    
    /**
     * Suma el precio de los productos del pedido.
     * @return Precio de los productos del pedido.
     */
    public float obtenerPrecioProductosTotal() {
        float precioTotal = 0.0f;
        
        for (int i = 0; i < productosPedidos.size(); i++) {
            precioTotal += (this.cantidadPorProducto.get(i) * this.productosPedidos.get(i).getPrecio());
        }
        
        return precioTotal;
    }
    
    /**
     * Calcula y regresa el costo total del pedido.
     * @return El costo total del pedido.
     */
    public float obtenerCostoTotal() {
        this.costoTotal = 0.0f;
        
        this.costoTotal += this.obtenerPrecioProductosTotal();
        this.costoTotal += this.costoEnvio;
        
        return this.costoTotal;
    }
    
    /**
     * Obtiene los pedidos desde la base de datos para la ventana principal.
     * @return Los pedidos desde la base de datos para la ventana principal.
     */
    public List<Pedido> obtenerDatosPedidos() {
        IPedidoDAO pedidos = new PedidoDAO(new DBConector().getEM());
        
        if(!pedidos.obtenerPedidos().isEmpty()) {
            pedidos = new PedidoDAO(new DBConector().getEM());
            return pedidos.obtenerPedidos();
        }
        
        return new ArrayList<>();
    }
    
    /**
     * En la ventana de realizar pedido se puede buscar un cliente por su teléfono.
     * @param telefono Teléfono del cliente que se quiere buscar.
     * @return Cliente con 
     */
    public Cliente buscarCliente(String telefono) {
        IClienteDAO clientes = new ClienteDAO(new DBConector().getEM());
        
        Cliente cliente = clientes.obten(telefono);
        
        if(cliente == null) {
            JOptionPane.showMessageDialog(ControlVentanas.getInstance().getRealizarPedido(), "No se encontró un cliente con este teléfono: " + telefono + "\nUse el formulario para llenar sus datos y cuando realice el pedido se registrará en automático.", "No existe el cliente.", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
        return cliente;
    }
    
    /**
     * Cancela el pedido del cliente que lo haya cancelado.
     * @param id ID del pedido a cancelar.
     */
    public void cancelarPedido(Long id){
        IPedidoDAO pedidos = new PedidoDAO(new DBConector().getEM());
        
        Object[] botones = {"Regresar", "Cancelar"};
        
        // Pide confirmación
        int resp = JOptionPane.showOptionDialog(ControlVentanas.getInstance().getMain(), "¿Seguro que quiere cancelar el pedido " + id + "?", "Confirmación sobre cancelación", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, botones, botones[0]);
        
        if(resp == 1) {
            // Elimina también las ventas relacionadas al pedido
            IVentaDAO ventas = new VentaDAO(new DBConector().getEM());
            cVentas.eliminarVenta(ventas.obtenVentasPedido(pedidos.obten(id)));
            
            // Elimina el pedido en la base de datos
            pedidos = new PedidoDAO(new DBConector().getEM());
            pedidos.eliminarPedido(id);
            ControlVentanas.getInstance().mostrarVentanaPrincipal();
        }
    }
    
    /**
     * Obtiene los pedidos desde la base de datos para ver la tabla de pedidos.
     * @return Los pedidos desde la base de datos para ver la tabla de pedidos.
     */
    public List<Pedido> obtenerPedidos(){
        IPedidoDAO pedidos = new PedidoDAO(new DBConector().getEM());
        return pedidos.obtenerPedidos();
    }
    
    /**
     * Obtiene los pedidos desde la base de datos en cierto rango de fechas.
     * @param fechaInicio Fecha de inicio para buscar pedidos.
     * @param fechaFin Fecha final para buscar pedidos.
     * @return Pedidos en el rango seleccionado.
     */
    public List<Pedido> obtenerPedidosFiltro(Calendar fechaInicio, Calendar fechaFin){
        IPedidoDAO pedidos = new PedidoDAO(new DBConector().getEM());
        return pedidos.obtenerPedidosEntreFechas(fechaInicio, fechaFin);
    }
    
    /**
     * Muestra el selector de fechas.
     */
    public void mostrarSelectorFechas(){
        if(this.frmSeleccionarFechas == null) {
            this.frmSeleccionarFechas = new FrmSeleccionarDosFechas(1);
        }
        
        this.frmSeleccionarFechas.setVisible(true);
    }
    
    /**
     * Actualiza la cantidad del pedido especificado.
     * @param cantidad Cantidad que agrega al pedido.
     * @param index Pedido al que agregarle cantidad.
     */
    public void actualizarCantidadPedido(int cantidad, int index) {
        this.cantidadPorProducto.set(index, this.cantidadPorProducto.get(index) + cantidad);
        
        // Si la cantidad llega a cero, remueve el pedido de la lista
        if(this.cantidadPorProducto.get(index) == 0) {
            this.productosPedidos.remove(index);
            this.cantidadPorProducto.remove(index);
        }
    }
    
    /**
     * Obtiene la cantidad del pedido especificado.
     * @param index Pedido del que se quiere recuperar la cantidad.
     * @return La cantidad del pedido especificado.
     */
    public int obtenerCantidadPedido(int index) {
        if(this.cantidadPorProducto.isEmpty()) {
            return -1;
        }else {
            return this.cantidadPorProducto.get(index);
        }
    }
    
    /**
     * Utilidad para dar a conocer el producto al que se quieren agregar los ingredientes.
     * @param fila Fila del producto que se quiere personalizar en la tabla.
     */
    public void setFilaPersonalizar(int fila) {
        ControlVentanas.getInstance().getPerzonalizarPedido().setFila(fila);
    }
}
