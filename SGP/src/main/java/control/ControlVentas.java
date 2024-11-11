package control;

/**
 *
 * @author Samuel Vega
 */
public class ControlVentas {
    private static ControlVentas instancia;
    
    public ControlVentas() {
        
    }
    
    public static ControlVentas getInstance() {
        if(instancia != null) {
            instancia = new ControlVentas();
        }
        
        return instancia;
    }
    
    public void registrarVenta() {
        
    }
}
