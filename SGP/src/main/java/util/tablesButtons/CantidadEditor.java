package util.tablesButtons;

import control.Control;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author Samuel Vega
 */
public class CantidadEditor extends AbstractCellEditor implements TableCellEditor {
    private Control c = Control.getInstance();
    private JPanel panel = new JPanel(new GridLayout(1, 2));
    private JButton btnAumentar = new JButton("+");
    private JButton btnReducir = new JButton("-");
    private JLabel lblCantidad = new JLabel(String.valueOf(1), SwingConstants.CENTER);
    private int cantidad;
    private int fila;
    
    public CantidadEditor() {
        panel.add(btnReducir);
        panel.add(lblCantidad);
        panel.add(btnAumentar);
        
        btnAumentar.addActionListener(e -> {
            cantidad++;
            lblCantidad.setText(String.valueOf(cantidad));
            c.actualizarCantidadPedido(+1, fila);
            c.actualizarRealizarPedido();
        });
        
        btnReducir.addActionListener(e -> {
            if(cantidad > -1) {
                cantidad--;
                lblCantidad.setText(String.valueOf(cantidad));
                c.actualizarCantidadPedido(-1, fila);
                c.actualizarRealizarPedido();
                fireEditingStopped();
            }
        });
    }

    @Override
    public Object getCellEditorValue() {
        return cantidad;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {    
        cantidad = (int) value;
        lblCantidad.setText(String.valueOf(cantidad));
        return panel;
    }
    
    public void setFila(int fila) {
        this.fila = fila;
    }
}
