package control;

import dao.VentaDAO;
import dominio.Pedido;
import dominio.Producto;
import dominio.Venta;
import interfaces.IVentaDAO;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import util.DBConector;
import util.enums.EstadoVentas;
import vista.FrmPrincipal;
import vista.FrmRevisarVentas;
import vista.FrmSeleccionarDosFechas;

/**
 *
 * @author Samuel Vega
 */
public class ControlVentas {
    private static ControlVentas instancia;
    
    private FrmPrincipal main;
    private FrmRevisarVentas frmRevisarVentas;
    private FrmSeleccionarDosFechas frmSeleccionarFechas;
    
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
    
    public List<Venta> obtenerVentas(){
        IVentaDAO ventas = new VentaDAO(new DBConector().getEM());
        return ventas.obtenerVentas();
    }
    
    public List<Venta> obtenerVentasFiltro(Calendar fechaInicio, Calendar fechaFin) {
        IVentaDAO ventas = new VentaDAO(new DBConector().getEM());
        return ventas.obtenVentasEntreFechas(fechaInicio, fechaFin);
    }
    
    public void mostrarSelectorFechas(){
        if(this.frmSeleccionarFechas == null) {
            this.frmSeleccionarFechas = new FrmSeleccionarDosFechas();
        }
        
        this.frmSeleccionarFechas.setVisible(true);
    }

    public void mostrarRevisarVentas(){
        if(this.frmRevisarVentas == null) {
            this.frmRevisarVentas = new FrmRevisarVentas();
        }
        
       frmRevisarVentas.setVisible(true);
    }

    public void actualizarPeriodoVentas(Calendar fechaInicio, Calendar fechaFinal) {
        this.frmRevisarVentas.setPeriodo(fechaInicio, fechaFinal);
    }
}
