package vista.menu;

import control.ControlClientes;
import control.ControlVentanas;
import dominio.Cliente;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import util.enums.Operaciones;

/**
 * Diálogo de operaciones con el cliente.
 * @author Samuel Vega
 */
public class DlgClientes extends javax.swing.JDialog {
    private final Operaciones operacion;
    private final ControlClientes cClientes = ControlClientes.getInstance();
    private Cliente cliente;
    
    public DlgClientes(java.awt.Frame parent, boolean modal, Operaciones operacion, Cliente cliente) {
        super(parent, modal);
        initComponents();
        
        this.operacion = operacion;
        this.cliente = cliente;
        
        if(this.operacion.equals(Operaciones.AGREGAR)) {
            this.btnRealizar.setText("Agregar");
        }else {
            this.txtTelefono.setText(cliente.getTelefono());
            this.txtNombre.setText(cliente.getNombres());
            this.txtApellidoPaterno.setText(cliente.getApellidoPaterno());
            this.txtApellidoMaterno.setText(cliente.getApellidoMaterno());
            this.txtDireccion.setText(cliente.getDireccion());
        }
            
        if(this.operacion.equals(Operaciones.MODIFICAR)) {
            this.btnRealizar.setText("Modificar");
        }
        
        if(this.operacion.equals(Operaciones.ELIMINAR)) {
            this.txtTelefono.setEditable(false);
            this.txtNombre.setEditable(false);
            this.txtApellidoPaterno.setEditable(false);
            this.txtApellidoMaterno.setEditable(false);
            this.txtDireccion.setEditable(false);
            
            this.btnRealizar.setText("Eliminar");
        }
        
        this.centraCuadroDialogo(parent);
    }
    
    /**
     * 
     * @param parent 
     */
    private void centraCuadroDialogo(java.awt.Frame parent){
        Dimension frameSize = parent.getSize();
        Point loc = parent.getLocation();
        
        Dimension dlgSize = getPreferredSize();
        
        setLocation( (frameSize.width - dlgSize.width) / 2 + loc.x,
                     (frameSize.height - dlgSize.height) / 2 + loc.y);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellidoPaterno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtApellidoMaterno = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        btnRealizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Teléfono del cliente:");

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nombre(s):");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Apellido P:");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Apellido M:");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Dirección:");

        btnRealizar.setText("Realizar");
        btnRealizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(425, 425, 425))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4)
                                        .addGap(33, 33, 33))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(21, 21, 21))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRealizar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRealizar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        boolean limite = this.txtTelefono.getText().length() >= 10;
        char c = evt.getKeyChar();

        if(!Character.isDigit(c) && evt.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
            JOptionPane.showMessageDialog(this, "Para el número solo se pueden ingresar números", "Formato no valido", JOptionPane.INFORMATION_MESSAGE);
            evt.consume();
        }else if(limite) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
        ControlVentanas.getInstance().mostrarRevisarClientes();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRealizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarActionPerformed
        if(this.operacion.equals(Operaciones.AGREGAR)) {
            Cliente nCliente = new Cliente();
            
            nCliente.setTelefono(this.txtTelefono.getText());
            nCliente.setNombres(this.txtNombre.getText());
            nCliente.setApellidoPaterno(this.txtApellidoPaterno.getText());
            nCliente.setApellidoMaterno(this.txtApellidoMaterno.getText());
            nCliente.setDireccion(this.txtDireccion.getText());
            
            cClientes.agregarCliente(nCliente);
            JOptionPane.showMessageDialog(this, "Se agregó el cliente al sistema.", "Cliente agregado!", JOptionPane.INFORMATION_MESSAGE);
        }
        
        if(this.operacion.equals(Operaciones.MODIFICAR)) {
            cliente.setTelefono(this.txtTelefono.getText());
            cliente.setNombres(this.txtNombre.getText());
            cliente.setApellidoPaterno(this.txtApellidoPaterno.getText());
            cliente.setApellidoMaterno(this.txtApellidoMaterno.getText());
            cliente.setDireccion(this.txtDireccion.getText());
            
            cClientes.modificarCliente(cliente);
            JOptionPane.showMessageDialog(this, "Se modificó el cliente en el sistema.", "Cliente modificado!", JOptionPane.INFORMATION_MESSAGE);
        }
        
        if(this.operacion.equals(Operaciones.ELIMINAR)) {
            cClientes.elimnarCliente(cliente.getId());
            JOptionPane.showMessageDialog(this, "Se eliminó el cliente del sistema.", "Cliente eliminado!", JOptionPane.INFORMATION_MESSAGE);
        }
        
        dispose();
        ControlVentanas.getInstance().mostrarRevisarClientes();
    }//GEN-LAST:event_btnRealizarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRealizar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
