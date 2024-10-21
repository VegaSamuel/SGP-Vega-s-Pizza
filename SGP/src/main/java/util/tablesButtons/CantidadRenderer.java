package util.tablesButtons;

import control.Control;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Samuel Vega
 */
public class CantidadRenderer extends JPanel implements TableCellRenderer {
    private Control c = Control.getInstance();
    private JButton btnAumentar = new JButton("+");
    private JButton btnReducir = new JButton("-");
    private JLabel lblCantidad;
    int fila;
    
    public CantidadRenderer() {
        if(fila != -1) {
            lblCantidad = new JLabel(String.valueOf(c.obtenerCantidadPedido(fila)), SwingConstants.CENTER);
        }else {
            lblCantidad = new JLabel("1", SwingConstants.CENTER);
        }
        
        setLayout(new GridLayout(1, 1));
        add(btnReducir);
        add(lblCantidad);
        add(btnAumentar);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        fila = row;
        return this;
    }
    
}
