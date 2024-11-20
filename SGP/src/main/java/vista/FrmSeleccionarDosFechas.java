package vista;

import com.toedter.calendar.JDateChooser;
import control.ControlPedidos;
import control.ControlVentas;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class FrmSeleccionarDosFechas extends javax.swing.JFrame {
    private ControlPedidos cPedidos = ControlPedidos.getInstance();
    private ControlVentas cVentas = ControlVentas.getInstance();
    private JDateChooser dateChooserInicio;
    private JDateChooser dateChooserFin;
    private int redireccionVentana;

    public FrmSeleccionarDosFechas() {
        initComponents();
    }
    
    public FrmSeleccionarDosFechas(int seleccion){
        this.redireccionVentana = seleccion;
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

                if(this.redireccionVentana == 1){  
                cPedidos.mostrarRevisarPedidos(fechaInicio, fechaFin);
                }
                
                else if(this.redireccionVentana == 2){ 
                cVentas.mostrarRevisarVentas(fechaInicio, fechaFin);
                }
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "La fecha de inicio debe ser anterior a la fecha de fin. Por favor, selecciona fechas válidas.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona ambas fechas.");
        }
    }
    


}
