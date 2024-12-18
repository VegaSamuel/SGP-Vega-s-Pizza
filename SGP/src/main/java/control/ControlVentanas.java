package control;

import dominio.Pedido;
import java.awt.Frame;
import java.util.Calendar;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import util.Conversiones;
import vista.DlgAgregarProducto;
import vista.DlgPersonalizarProducto;
import vista.FrmPrincipal;
import vista.FrmRealizarPedido;
import vista.FrmRevisarPedidos;

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
    private DlgAgregarProducto dlgAgregarProducto;
    private DlgPersonalizarProducto dlgPersonalizarProducto;
    private FrmRevisarPedidos frmRevisarPedidos;
    
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
        JOptionPane.showMessageDialog(this.frmRealizarPedido, "Se agregó correctamente el costo de envío al pedido.", "Agregado exitoso", JOptionPane.PLAIN_MESSAGE);
    }
    
    /**
     * Muestra el cuadro de diálogo para agregar productos al pedido.
     * @param frame Ventana que pide abrir el cuadro de diálogo.
     */
    public void mostrarAgregarProducto(Frame frame) {
        this.dlgAgregarProducto = new DlgAgregarProducto(frame, false, ControlPedidos.getInstance().obtenerListaProductos());
        this.dlgAgregarProducto.setVisible(true);
    }
    
    /**
     * Muestra el cuadro de diálogo para personalizar un pedido.
     */
    public void mostrarPersonalizarProducto() {
        // Si no hay ingredientes para agregar al pedido, se anuncia y se cancela la operación
        if(ControlPedidos.getInstance().obtenerListaIngredientes().isEmpty()) {
            JOptionPane.showMessageDialog(this.frmRealizarPedido, "No hay ingredientes que seleccionar.", "No hay ingredientes", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        this.dlgPersonalizarProducto = new DlgPersonalizarProducto(this.frmRealizarPedido, false, ControlPedidos.getInstance().obtenerListaIngredientes());
        this.dlgPersonalizarProducto.setVisible(true);
    }
    
    /**
     * Muestra la ventana de revisar pedidos.
     */
    public void mostrarRevisarPedidos(){
        if(this.frmRevisarPedidos == null) {
            this.frmRevisarPedidos = new FrmRevisarPedidos();
        }
        
        frmRevisarPedidos.crearTabla();
        frmRevisarPedidos.setVisible(true);
    }
    
     /**
     * Muestra la ventana de revisar pedidos con filtro.
     * @param fechaInicio
     * @param fechaFin
     */
    public void mostrarRevisarPedidos(Calendar fechaInicio, Calendar fechaFin){
        if(this.frmRevisarPedidos == null) {
            this.frmRevisarPedidos = new FrmRevisarPedidos();
        }
        
        frmRevisarPedidos.crearTabla(fechaInicio, fechaFin);
        frmRevisarPedidos.setVisible(true);
    }   
    
    /**
     * Actualiza el periodo seleccionado para mostrar en la tabla de pedidos.
     * @param fechaInicio Fecha de inicio para buscar pedidos.
     * @param fechaFinal Fecha final para buscar pedidos.
     */
    public void actualizarPeriodoPedidos(Calendar fechaInicio, Calendar fechaFinal) {
        this.frmRevisarPedidos.setPeriodo(fechaInicio, fechaFinal);
    }
    
    //Getters
    public FrmPrincipal getMain() {
        return this.main;
    }
    
    public FrmRealizarPedido getRealizarPedido() {
        return this.frmRealizarPedido;
    }
    
    public DlgAgregarProducto getAgregarProducto() {
        return this.dlgAgregarProducto;
    }
    
    public DlgPersonalizarProducto getPerzonalizarPedido() {
        return this.dlgPersonalizarProducto;
    }
    
    public FrmRevisarPedidos getRevisarPedidos() {
        return this.frmRevisarPedidos;
    }
}
