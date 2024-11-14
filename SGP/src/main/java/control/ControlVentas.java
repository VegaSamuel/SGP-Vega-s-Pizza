package control;

import dao.VentaDAO;
import dominio.Pedido;
import dominio.Producto;
import dominio.Venta;
import interfaces.IVentaDAO;
import java.util.List;
import javax.swing.JOptionPane;
import util.DBConector;
import util.enums.EstadoVentas;
import vista.FrmPrincipal;

/**
 *
 * @author Samuel Vega
 */


public class ControlVentas {
    private static ControlVentas instancia;
    private FrmPrincipal main;
    
    public ControlVentas() { }
    
    public static ControlVentas getInstance() {
        if(instancia == null) {
            instancia = new ControlVentas();
        }
        
        return instancia;
    }
    
    public void registrarVenta(Pedido pedido, List<Producto> productos, List<Integer> cantidades) {
        int cantidad_index = 0;
        
        for (Producto producto : productos) {
            IVentaDAO ventas = new VentaDAO(new DBConector().getEM());
            int cantidad = cantidades.get(cantidad_index);
            Venta nuevaVenta = new Venta(pedido, producto, cantidad, producto.getPrecio(), (cantidad * producto.getPrecio()), EstadoVentas.EN_PROCESO);
            
            ventas.agregarVenta(nuevaVenta);
            cantidad_index += 1;
        }
        
        JOptionPane.showMessageDialog(null, "Se registró correctamente la venta.", "Agregado exitoso.", JOptionPane.PLAIN_MESSAGE);
    }
    
    public void verificarVenta(List<Venta> lVentas) {
        for (Venta venta : lVentas) {
            IVentaDAO ventas = new VentaDAO(new DBConector().getEM());
            
            venta.setEstado(EstadoVentas.PAGADA);
            ventas.modificarVenta(venta);
        }
    }
    
    public void eliminarVenta(List<Venta> lVentas) {
        for (Venta venta : lVentas) {
            IVentaDAO ventas = new VentaDAO(new DBConector().getEM());
            ventas.eliminarVenta(venta.getId());
        }
    }
}
