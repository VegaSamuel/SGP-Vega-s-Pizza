package util.tablesButtons;

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
    private JPanel panel = new JPanel(new GridLayout(1, 2));
    private JButton btnAumentar = new JButton("+");
    private JButton btnReducir = new JButton("-");
    private JLabel lblCantidad = new JLabel("1", SwingConstants.CENTER);
    private int cantidad;
    
    public CantidadEditor() {
        panel.add(btnReducir);
        panel.add(lblCantidad);
        panel.add(btnAumentar);
        
        btnAumentar.addActionListener(e -> {
            cantidad++;
            lblCantidad.setText(String.valueOf(cantidad));
        });
        
        btnReducir.addActionListener(e -> {
            if(cantidad > -1) {
                cantidad--;
                lblCantidad.setText(String.valueOf(cantidad));
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
}
