package vista.menu;

import control.ControlClientes;
import control.ControlVentanas;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import util.enums.Operaciones;

/**
 *
 * @author Samuel Vega
 */
public class FrmClientes extends javax.swing.JFrame {
    private final ControlVentanas cVentanas = ControlVentanas.getInstance();
    private final ControlClientes cClientes = ControlClientes.getInstance();

    /**
     * Creates new form FrmClientes
     */
    public FrmClientes() {
        initComponents();
        
        btnEliminar.setVisible(false);
    }
    
    public void desplegarTabla(DefaultTableModel tabla) {
        tblClientes = new javax.swing.JTable(tabla);

        tblClientes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblClientes.setAutoscrolls(false);
        tblClientes.setAutoResizeMode(2);
        
        tblClientes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()) {
                    if(tblClientes.getSelectedRow() != -1) {
                        btnAgregar.setText("Modificar");
                        btnEliminar.setVisible(true);
                    }else {
                        btnAgregar.setText("Agregar");
                    }
                }
            }
        });
        
        jScrollPane1.setViewportView(tblClientes);
        this.ajustarColumnas();
    }
    
    private void ajustarColumnas() {
        TableColumnModel columnModel = tblClientes.getColumnModel();

        columnModel.getColumn(5).setPreferredWidth(180);
        columnModel.getColumn(4).setPreferredWidth(18);
        columnModel.getColumn(3).setPreferredWidth(25);
        columnModel.getColumn(2).setPreferredWidth(25);
        columnModel.getColumn(1).setPreferredWidth(50);
        columnModel.getColumn(0).setPreferredWidth(2);

        tblClientes.revalidate();
        tblClientes.repaint();
    }
    
    public void volverClientes() {
        this.btnEliminar.setVisible(false);
        this.btnAgregar.setText("Agregar");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Clientes - SGP Vega's Pizza");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblClientes);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnVolver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnVolver)
                    .addComponent(btnEliminar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        dispose();
        cVentanas.mostrarVentanaPrincipal();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        cVentanas.mostrarVentanaPrincipal();
    }//GEN-LAST:event_formWindowClosed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(tblClientes.getSelectedRow() == -1) {
            cVentanas.mostrarAgregarClientes(this, null, Operaciones.AGREGAR);
        }else {
            Long idCliente = (Long) tblClientes.getValueAt(tblClientes.getSelectedRow(), 0);
            cVentanas.mostrarAgregarClientes(this, cClientes.getCliente(idCliente), Operaciones.MODIFICAR);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(tblClientes.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "No se seleccionó un cliente al cual eliminar.\npor favor, seleccione uno.", "No ha seleccionado un cliente", JOptionPane.INFORMATION_MESSAGE);
        }else {
            Long idCliente = (Long) tblClientes.getValueAt(tblClientes.getSelectedRow(), 0);
            cVentanas.mostrarAgregarClientes(this, cClientes.getCliente(idCliente), Operaciones.ELIMINAR);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClientes;
    // End of variables declaration//GEN-END:variables
}
