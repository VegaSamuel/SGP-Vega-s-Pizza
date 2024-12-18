package util.tablesButtons;

import control.ControlPedidos;
import control.ControlVentanas;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author Samuel Vega
 */
public class PersonalizarEditor extends DefaultCellEditor {
    private ControlPedidos cPedidos = ControlPedidos.getInstance();
    private ControlVentanas cVentanas = ControlVentanas.getInstance();
    private JButton boton;
    private String nombreBoton;
    private boolean clicked;
    private int fila;
    
    public PersonalizarEditor(JCheckBox cb) {
        super(cb);
        boton = new JButton();
        boton.setOpaque(true);
        
        boton.addActionListener(e -> {
            cVentanas.mostrarPersonalizarProducto();
            cPedidos.setFilaPersonalizar(fila);
        });
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        nombreBoton = (value == null) ? "" : value.toString();
        
        boton.setText(nombreBoton);
        fila = row;
        clicked = true;
        return boton;
    }
    
    @Override
    public Object getCellEditorValue() {
        return nombreBoton;
    }
    
    @Override
    public boolean stopCellEditing() {
        clicked = false;
        return super.stopCellEditing();
    }
}