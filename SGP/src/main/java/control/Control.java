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
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import util.Conversiones;
import vista.DlgAgregarProducto;
import vista.FrmPrincipal;
import vista.FrmRealizarPedido;
import vista.FrmRevisarPedidos;
import vista.FrmSeleccionarFechas;

/**
 *
 * @author Samuel Vega
 */
public class Control {
    private static Control instancia;
    
    private FrmPrincipal main;
    private FrmRealizarPedido frmRealizarPedido;
    private DlgAgregarProducto dlgAgregarProducto;
    private FrmRevisarPedidos frmRevisarPedidos;
    private FrmSeleccionarFechas frmSeleccionarFechas;
    
    private List<Pedido> lpedidos;
    private List<Producto> productosPedidos;
    
    private Control() {
        this.productosPedidos = new ArrayList<>();
    }
    
    public static Control getInstance() {
        if(instancia == null) {
            instancia = new Control();
        }
        return instancia;
    }
    
    public void mostrarRealizarPedido() {
        if(this.frmRealizarPedido == null) {
            this.frmRealizarPedido = new FrmRealizarPedido();
        }
        
        this.productosPedidos.clear();
        this.actualizarRealizarPedido();
        this.frmRealizarPedido.setVisible(true);
        
    }
    
    public void actualizarRealizarPedido() {
        Conversiones con = new Conversiones();
        
        this.frmRealizarPedido.despliegaTabla(con.productosPedidoModel(productosPedidos));
        this.frmRealizarPedido.actualizarPrecioTotal(this.obtenerPrecioTotal());
    }
    
    public void mostrarAgregarProducto(Frame frame) {
        IProductoDAO productos = new ProductoDAO();
        List<Producto> listaProductos = productos.obtenerProductos();
        
        this.dlgAgregarProducto = new DlgAgregarProducto(frame, false, listaProductos);
        this.dlgAgregarProducto.setVisible(true);
    }
    
    public void agregarProducto(Producto producto) {
        this.productosPedidos.add(producto);
    }

    public void mostrarVentanaPrincipal() {
        DefaultListModel pedidosActuales = new DefaultListModel<>();
        
        obtenerDatosPedidos();
        
        for (Pedido pedido : lpedidos) {
            if(pedido.esActual())
                pedidosActuales.addElement(pedido.toString());
        }
        
        if(this.main == null) {
            this.main = new FrmPrincipal();
        }
        
        this.main.setListPedidos(pedidosActuales);
        this.main.setVisible(true);
    }
    
    public float obtenerPrecioTotal() {
        float precioTotal = 0.0f;
        
        for (Producto producto : productosPedidos) {
            precioTotal += producto.getPrecio();
        }
        
        return precioTotal;
    }
    
    public boolean obtenerDatosPedidos() {
        IPedidoDAO pedidos = new PedidoDAO();
        
        lpedidos = pedidos.obtenerPedidos();
        
        if(lpedidos.isEmpty()) {
            System.out.println("No hay pedidos.");
            return false;
        }
        
        return true;
    }
    
    
    
    public Cliente buscarCliente(String telefono) {
        IClienteDAO clientes = new ClienteDAO();
        
        return clientes.obten(telefono);
    }
    
    
    
    
    public List<Pedido> obtenerPedidos(){
        IPedidoDAO pedidos = new PedidoDAO();
        return pedidos.obtenerPedidos();
    }
    
    public void mostrarSelectorFechas(){
        frmSeleccionarFechas.setVisible(true);
    }
}
