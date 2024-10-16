
package vista;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class PruebaFrmSeleccionarFecha extends javax.swing.JFrame {

    private JDateChooser dateChooser;

    public PruebaFrmSeleccionarFecha() {
        initComponents();
    }

    
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE); // Para cerrar esta ventana sin afectar a la principal
        setTitle("Seleccionar Fecha");

        dateChooser = new JDateChooser();  // Crear el componente del calendario
        dateChooser.setDateFormatString("yyyy-MM-dd");  // Formato de fecha

        javax.swing.JButton btnConfirmar = new javax.swing.JButton("Confirmar Fecha");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarFecha();
            }
        });

        setLayout(new java.awt.FlowLayout());
        add(dateChooser);  
        add(btnConfirmar);  

        pack();  
    }

    private void confirmarFecha() {
        Date fechaSeleccionada = dateChooser.getDate();  
        if (fechaSeleccionada != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String fechaString = dateFormat.format(fechaSeleccionada);  
            JOptionPane.showMessageDialog(this, "Fecha seleccionada: " + fechaString);
         
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una fecha");
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PruebaFrmSeleccionarFecha().setVisible(true);
            }
        });
    }
}
