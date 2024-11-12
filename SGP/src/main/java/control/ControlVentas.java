package control;

import dao.VentaDAO;
import dominio.Pedido;
import dominio.Venta;
import interfaces.IVentaDAO;
import util.DBConector;

/**
 *
 * @author Samuel Vega
 */
public class ControlVentas {
    private static ControlVentas instancia;
    
    public ControlVentas() { }
    
    public static ControlVentas getInstance() {
        if(instancia != null) {
            instancia = new ControlVentas();
        }
        
        return instancia;
    }
    
    public void registrarVenta(Pedido pedido) {
        IVentaDAO ventas = new VentaDAO(new DBConector().getEM());
        Venta venta = null;
        
        
        
    }
}
