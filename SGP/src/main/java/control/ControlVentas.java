package control;

import dao.VentaDAO;
import dominio.Pedido;
import dominio.Producto;
import dominio.Venta;
import interfaces.IVentaDAO;
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
        if(instancia != null) {
            instancia = new ControlVentas();
        }
        
        return instancia;
    }
    
    public void registrarVenta(Pedido pedido) {
        IVentaDAO ventas = new VentaDAO(new DBConector().getEM());
        
        //Datos de relleno
        Venta ventaNueva = new Venta
        ( pedido,
          new Producto(),
          2,
          10f,
          20f,
          EstadoVentas.EN_PROCESO
        );
        
        ventas.agregarVenta(ventaNueva);
        JOptionPane.showMessageDialog(main, "Se registró correctamente la venta.", "Agregado exitoso.", JOptionPane.PLAIN_MESSAGE);
        
        
    }
}
