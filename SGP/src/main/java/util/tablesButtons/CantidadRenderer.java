package util.tablesButtons;

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
    private JButton btnAumentar = new JButton("+");
    private JButton btnReducir = new JButton("-");
    private JLabel lblCantidad = new JLabel("1", SwingConstants.CENTER);
    
    public CantidadRenderer() {
        setLayout(new GridLayout(1, 2));
        add(btnReducir);
        add(lblCantidad);
        add(btnAumentar);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return this;
    }
    
}
