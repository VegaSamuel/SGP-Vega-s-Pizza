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
    private JLabel lblCantidad = new JLabel("1", SwingConstants.CENTER);

    public CantidadRenderer() {
        // Configura el layout y los botones
        setLayout(new GridLayout(1, 3)); // Aumenta el grid a 3 para incluir botones
        add(btnReducir);
        add(lblCantidad);
        add(btnAumentar);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        int cantidad = (int) value; // Obtén el valor actual de la celda (la cantidad)
        lblCantidad.setText(String.valueOf(cantidad)); // Actualiza la etiqueta con la cantidad correcta
        return this;
    }
}
