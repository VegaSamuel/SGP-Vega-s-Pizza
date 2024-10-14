package control;

import dao.PedidoDAO;
import dominio.Pedido;
import interfaces.IPedidoDAO;
import java.util.List;
import javax.swing.DefaultListModel;
import util.EstadoPedidos;
import vista.FrmPrincipal;
import vista.FrmRealizarPedido;

/**
 *
 * @author Samuel Vega
 */
public class Control {
    private FrmPrincipal main;
    private FrmRealizarPedido frmRealizarPedido;
    
    private List<Pedido> lpedidos;
    
    public boolean realizarPedido() {
        this.frmRealizarPedido = new FrmRealizarPedido();
        this.frmRealizarPedido.setVisible(true);
        
        
        
        return false;
    }

    public void mostrarVentanaPrincipal() {
        DefaultListModel pedidosActuales = new DefaultListModel<>();
        
        obtenerDatosPedidos();
        
        for (Pedido pedido : lpedidos) {
            if(esActual(pedido))
                pedidosActuales.addElement(pedido.toString());
        }
        
        System.out.println(pedidosActuales.getElementAt(0));
        
        this.main = new FrmPrincipal(pedidosActuales);
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
    
    private boolean esActual(Pedido pedido) {
        return (pedido.getEstado() == EstadoPedidos.COCINANDO) || (pedido.getEstado() == EstadoPedidos.ENVIADO);
    }
}
