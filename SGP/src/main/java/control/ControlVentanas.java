package control;

import dominio.Pedido;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import util.Conversiones;
import vista.FrmPrincipal;
import vista.FrmRealizarPedido;

/**
 * Esta clase lleva el control de las ventanas del sistema.
 * @author Samuel Vega
 */
public class ControlVentanas {
    // Instancia única de la clase
    private static ControlVentanas instancia;
    
    // Declaración de ventanas
    private FrmPrincipal main;
    private FrmRealizarPedido frmRealizarPedido;
    
    private ControlVentanas() { }
    
    /**
     * Crea una instancia de la clase si es que no la hay y devuelve una que ya este creada.
     * @return Instancia de la clase.
     */
    public static ControlVentanas getInstance() {
        if(instancia == null) {
            instancia = new ControlVentanas();
        }
        return instancia;
    }
    
    /**
     * Muestra la ventana principal del sistema.
     */
    public void mostrarVentanaPrincipal() {
        DefaultListModel pedidosActuales = new DefaultListModel<>();
        
        for (Pedido pedido : ControlPedidos.getInstance().obtenerDatosPedidos()) {
            if(pedido.esActual())
                pedidosActuales.addElement(pedido);
        }
        
        // Si no esta inicializada la ventana, la inicializa
        if(this.main == null) {
            this.main = new FrmPrincipal();
        }
        
        this.main.setListPedidos(pedidosActuales);
        this.main.setVisible(true);
    }
    
    /**
     * Muestra la ventana de realizar pedido.
     */
    public void mostrarRealizarPedido() {
        // Si no esta inicializada aún, la inicializa
        if(this.frmRealizarPedido == null) {
            this.frmRealizarPedido = new FrmRealizarPedido();
        }
        
        // Cada que se abre la ventana, se resetean los valores
        ControlPedidos.getInstance().limpiarDatosPedido();
        this.actualizarRealizarPedido();
        this.frmRealizarPedido.setVisible(true);
    }
    
    /**
     * Actualiza la ventana actual de realizar pedido.
     * Se usa normalmente cuando se realiza una operación que realiza cambios en esta ventana.
     */
    public void actualizarRealizarPedido() {
        Conversiones con = new Conversiones();
        
        this.frmRealizarPedido.despliegaTabla(con.productosPedidoModel(
                ControlPedidos.getInstance().obtenerProductosPedidos(), 
                ControlPedidos.getInstance().obtenerCantidadesPorProducto()));
        
        ControlPedidos.getInstance().setCostoTotal(ControlPedidos.getInstance().getCostoTotal() + ControlPedidos.getInstance().obtenerPrecioProductosTotal());
        this.frmRealizarPedido.actualizarPrecioEnvio(ControlPedidos.getInstance().obtenerCostoEnvio());
        this.frmRealizarPedido.actualizaCostoTotal(ControlPedidos.getInstance().obtenerCostoTotal());
        this.frmRealizarPedido.actualizarPrecioTotal(ControlPedidos.getInstance().obtenerPrecioProductosTotal());
    }
    
    
    
    /**
     * Agrega el costo de envío calculado a la ventana de realizar pedido.
     * @param costoEnvio Costo del envío calculado.
     * @param costoTotal Costo total juntando el envío.
     */
    public void agregarCostoEnvio(float costoEnvio, float costoTotal) {
        // Actualiza el precio de envío en la ventana de Realizar Pedido.
        this.frmRealizarPedido.actualizarPrecioEnvio(costoEnvio);
        // Actualiza el costo total en la ventana de Realizar Pedido, agregando el envío.
        this.frmRealizarPedido.actualizaCostoTotal(costoTotal);
        // Informa que el agregado fue exitoso.
        JOptionPane.showMessageDialog(frmRealizarPedido, "Se agregó correctamente el costo de envío al pedido.", "Agregado exitoso", JOptionPane.PLAIN_MESSAGE);
    }
    
    //Getters
    public FrmPrincipal getMain() {
        return this.main;
    }
    
    public FrmRealizarPedido getRealizarPedido() {
        return this.frmRealizarPedido;
    }
}
