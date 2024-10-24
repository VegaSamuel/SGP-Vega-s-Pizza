package control;

import dao.ClienteDAO;
import dao.PedidoDAO;
import dao.ProductoDAO;
import dominio.Cliente;
import dominio.Pedido;
import dominio.Producto;
import interfaces.IClienteDAO;
import interfaces.IPedidoDAO;
import interfaces.IProductoDAO;
import java.awt.Frame;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import util.CalculoEnvio;
import util.CalculoMetrosEnvio;
import util.Conversiones;
import vista.DlgAgregarProducto;
import vista.FrmPrincipal;
import vista.FrmRealizarPedido;
import vista.FrmRevisarPedidos;
import vista.FrmSeleccionarDosFechas;


/**
 * Clase que lleva el control de la aplicación.
 * @author Samuel Vega & Pedro Moya & Juan Sánchez
 */
public class Control {
    // Instancia única de la clase
    private static Control instancia;
    
    // Declaración de ventanas
    private FrmPrincipal main;
    private FrmRealizarPedido frmRealizarPedido;
    private DlgAgregarProducto dlgAgregarProducto;
    private FrmRevisarPedidos frmRevisarPedidos;
    private FrmSeleccionarDosFechas prueba;
    
    // Declaración de utilidades de los pedidos
    private List<Pedido> listaPedidos;
    private List<Producto> productosPedidos;
    private List<Integer> cantidadPorProducto;
    private float costoTotal;
    private float costoEnvio;
    
    /**
     * Constructor que inicializa ciertos atributos.
     */
    private Control() {
        this.productosPedidos = new ArrayList<>();
        this.cantidadPorProducto = new ArrayList<>();
    }
    
    /**
     * Crea una instancia de la clase si es que no la hay y devuelve una que ya este creada.
     * @return Instancia de la clase.
     */
    public static Control getInstance() {
        if(instancia == null) {
            instancia = new Control();
        }
        return instancia;
    }
    
    public void realizarPedido(Cliente cliente, Pedido pedido) {
        IClienteDAO clientes = new ClienteDAO();
        IPedidoDAO pedidos = new PedidoDAO();
        
        if(clientes.obten(cliente.getTelefono()) == null) {
            clientes.agregarCliente(cliente);
        }
        
        pedidos.agregarPedido(pedido);
        
        JOptionPane.showMessageDialog(frmRealizarPedido, "Se agregó correctamente el pedido.", "Agregado exitoso.", JOptionPane.PLAIN_MESSAGE);
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
        
        costoEnvio = envio.calcularCostoEnvio(metros.getDistanciaMetros(direccion));
        
        Object[] botones = {"Agregar", "Cancelar"};
        
        // Muestra el precio de envío y pregunta si el usuario quiere agregar el costo al pedido.
        int resp = JOptionPane.showOptionDialog(frmRealizarPedido, "¿Desea agregar el envío? \n envío: " + costoEnvio, "Costo de Envío Calculado", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, botones, botones[0]);
        
        // Si se agrega el costo
        if(resp == 0) {
            // Se agrega al costo total del pedido.
            this.costoTotal += costoEnvio;
            // Actualiza el precio de envío en la ventana de Realizar Pedido.
            this.frmRealizarPedido.actualizarPrecioEnvio(costoEnvio);
            // Actualiza el costo total en la ventana de Realizar Pedido, agregando el envío.
            this.frmRealizarPedido.actualizaCostoTotal(costoTotal);
            // Informa que el agregado fue exitoso.
            JOptionPane.showMessageDialog(frmRealizarPedido, "Se agregó correctamente el costo de envío al pedido.", "Agregado exitoso", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    public void mostrarRealizarPedido() {
        if(this.frmRealizarPedido == null) {
            this.frmRealizarPedido = new FrmRealizarPedido();
        }
        
        this.costoEnvio = 0.0f;
        this.productosPedidos.clear();
        this.actualizarRealizarPedido();
        this.frmRealizarPedido.setVisible(true);
    }
    
    public void actualizarRealizarPedido() {
        Conversiones con = new Conversiones();
        
        this.frmRealizarPedido.despliegaTabla(con.productosPedidoModel(productosPedidos, cantidadPorProducto));
        this.costoTotal += this.obtenerPrecioProductosTotal();
        this.frmRealizarPedido.actualizarPrecioEnvio(this.costoEnvio);
        this.frmRealizarPedido.actualizaCostoTotal(this.obtenerCostoTotal());
        this.frmRealizarPedido.actualizarPrecioTotal(this.obtenerPrecioProductosTotal());
    }
    
    public void mostrarAgregarProducto(Frame frame) {
        IProductoDAO productos = new ProductoDAO();
        List<Producto> listaProductos = productos.obtenerProductos();
        
        this.dlgAgregarProducto = new DlgAgregarProducto(frame, false, listaProductos);
        this.dlgAgregarProducto.setVisible(true);
    }
    
    public void agregarProducto(Producto producto) {
        this.cantidadPorProducto.add(1);
        this.productosPedidos.add(producto);
    }

    public void mostrarVentanaPrincipal() {
        DefaultListModel pedidosActuales = new DefaultListModel<>();
        
        obtenerDatosPedidos();
        
        for (Pedido pedido : listaPedidos) {
            if(pedido.esActual())
                pedidosActuales.addElement(pedido.toString());
        }
        
        if(this.main == null) {
            this.main = new FrmPrincipal();
        }
        
        this.main.setListPedidos(pedidosActuales);
        this.main.setVisible(true);
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
     * 
     * @return 
     */
    public float obtenerCostoTotal() {
        this.costoTotal = 0.0f;
        
        this.costoTotal += this.obtenerPrecioProductosTotal();
        this.costoTotal += this.costoEnvio;
        
        return this.costoTotal;
    }
    
    public boolean obtenerDatosPedidos() {
        IPedidoDAO pedidos = new PedidoDAO();
        
        listaPedidos = pedidos.obtenerPedidos();
        
        if(listaPedidos.isEmpty()) {
            System.out.println("No hay pedidos.");
            return false;
        }
        
        return true;
    }
    
    public Cliente buscarCliente(String telefono) {
        IClienteDAO clientes = new ClienteDAO();
        
        Cliente cliente = clientes.obten(telefono);
        
        if(cliente == null) {
            JOptionPane.showMessageDialog(this.frmRealizarPedido, "No se encontró un cliente con este teléfono: " + telefono + "\nUse el formulario para llenar sus datos y cuando realice el pedido se registrará en automático.", "No existe el cliente.", JOptionPane.ERROR_MESSAGE);
        }
        
        return cliente;
    }
    
    public void cancelarPedido(Long id){
        IPedidoDAO pedidos = new PedidoDAO();
        
        Object[] botones = {"Regresar", "Cancelar"};
        
        int resp = JOptionPane.showOptionDialog(this.main, "¿Seguro que quiere cancelar el pedido " + id + "?", "Confirmación sobre cancelación", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, botones, botones[0]);
        
        if(resp == 1) {
            pedidos.eliminarPedido(id);
            this.mostrarVentanaPrincipal();
        }
    }
    
    public List<Pedido> obtenerPedidos(){
        IPedidoDAO pedidos = new PedidoDAO();
        return pedidos.obtenerPedidos();
    }
    

    public List<Pedido> obtenerPedidosFiltro(Date fechaInicio, Date fechaFin){
        IPedidoDAO pedidos = new PedidoDAO();
        return pedidos.obtenerPedidosEntreFechas(fechaInicio, fechaFin);
    }
    
    public void mostrarSelectorFechas(){
        prueba = new FrmSeleccionarDosFechas();
        prueba.setVisible(true);
    }
    
    public void mostrarRevisarPedidos(){
        if(this.frmRevisarPedidos == null) {
            this.frmRevisarPedidos = new FrmRevisarPedidos();
        }
        
        frmRevisarPedidos.setVisible(true);
    }
    
    public void actualizarCantidadPedido(int cantidad, int index) {
        this.cantidadPorProducto.set(index, this.cantidadPorProducto.get(index) + cantidad);
        
        if(this.cantidadPorProducto.get(index) == 0) {
            this.productosPedidos.remove(index);
        }
    }
    
    public int obtenerCantidadPedido(int index) {
        if(this.cantidadPorProducto.isEmpty()) {
            return -1;
        }else {
            return this.cantidadPorProducto.get(index);
        }
    }
}
