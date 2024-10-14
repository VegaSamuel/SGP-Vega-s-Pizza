package control;

import vista.FrmPrincipal;
import vista.FrmRealizarPedido;

/**
 *
 * @author Samuel Vega
 */
public class Control {
    private FrmPrincipal main;
    private FrmRealizarPedido frmRealizarPedido;
    
    public boolean realizarPedido() {
        
        this.frmRealizarPedido = new FrmRealizarPedido();
        this.frmRealizarPedido.setVisible(true);
        
        return false;
    }

    public void mostrarVentanaPrincipal() {
        this.main = new FrmPrincipal();
        this.main.setVisible(true);
    }
    
    public boolean obtenerDatosPedidos() {
        
        
        return false;
    }
}
