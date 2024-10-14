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
import java.util.List;
import javax.swing.DefaultListModel;
import util.Conversiones;
import util.EstadoPedidos;
import vista.DlgAgregarProducto;
import vista.FrmPrincipal;
import vista.FrmRealizarPedido;

/**
 *
 * @author Samuel Vega
 */
public class Control {
    private FrmPrincipal main;
    private FrmRealizarPedido frmRealizarPedido;
    private DlgAgregarProducto dlgAgregarProducto;
    
    private List<Pedido> lpedidos;
    
    public boolean realizarPedido() {
        Conversiones con = new Conversiones();
        IProductoDAO productos = new ProductoDAO();
        
        this.frmRealizarPedido = new FrmRealizarPedido();
        this.frmRealizarPedido.setVisible(true);
        
        return false;
    }
    
    public boolean agregarProducto(Frame frame) {
        IProductoDAO productos = new ProductoDAO();
        List<Producto> listaProductos = productos.obtenerProductos();
        
        this.dlgAgregarProducto = new DlgAgregarProducto(frame, true, listaProductos);
        this.dlgAgregarProducto.setVisible(true);
        
        
        
        return false;
    }

    public void mostrarVentanaPrincipal() {
        DefaultListModel pedidosActuales = new DefaultListModel<>();
        
        obtenerDatosPedidos();
        
        for (Pedido pedido : lpedidos) {
            if(esActual(pedido))
                pedidosActuales.addElement(pedido.toString());
        }
        
        this.main = new FrmPrincipal();
        this.main.setListPedidos(pedidosActuales);
        this.main.setVisible(true);
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
    
    private boolean esActual(Pedido pedido) {
        return (pedido.getEstado() == EstadoPedidos.COCINANDO) || (pedido.getEstado() == EstadoPedidos.ENVIADO);
    }
}
