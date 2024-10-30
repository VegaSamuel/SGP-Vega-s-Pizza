package vista;

import com.toedter.calendar.JDateChooser;
import control.Control;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

public class FrmSeleccionarDosFechas extends javax.swing.JFrame {
    private Control c = Control.getInstance();
    private JDateChooser dateChooserInicio;
    private JDateChooser dateChooserFin;

    public FrmSeleccionarDosFechas() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Seleccionar Fechas");

        dateChooserInicio = new JDateChooser();
        dateChooserInicio.setDateFormatString("yyyy-MM-dd");

        dateChooserFin = new JDateChooser();
        dateChooserFin.setDateFormatString("yyyy-MM-dd");

        javax.swing.JButton btnConfirmar = new javax.swing.JButton("Confirmar Fechas");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarFechas();
                dateChooserInicio.setDate(null);
                dateChooserFin.setDate(null);
            }
        });

        setLayout(new java.awt.FlowLayout());
        add(dateChooserInicio);
        add(dateChooserFin);
        add(btnConfirmar);

        pack();
        setLocationRelativeTo(null);
    }

private void confirmarFechas() {
    Calendar fechaInicio = dateChooserInicio.getCalendar();
    Calendar fechaFin = dateChooserFin.getCalendar();

    if (fechaInicio != null && fechaFin != null) {
        if (fechaInicio.before(fechaFin)) {
            
            c.actualizarPeriodoPedidos(fechaInicio, fechaFin);  // Convertir Calendar a Date
            c.mostrarRevisarPedidos();
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "La fecha de inicio debe ser anterior a la fecha de fin. Por favor, selecciona fechas válidas.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, selecciona ambas fechas.");
    }
}

}
