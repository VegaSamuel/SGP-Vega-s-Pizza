package vista;

import control.ControlPedidos;
import control.ControlVentanas;
import dominio.Cliente;
import dominio.Pedido;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.GregorianCalendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.enums.EstadoPedidos;
import util.tablesButtons.PersonalizarRenderer;
import util.tablesButtons.PersonalizarEditor;
import util.enums.TipoPago;
import util.tablesButtons.CantidadEditor;
import util.tablesButtons.CantidadRenderer;

/**
 *
 * @author Samuel Vega
 */
public class FrmRealizarPedido extends javax.swing.JFrame {
    ControlPedidos cPedidos = ControlPedidos.getInstance();
    ControlVentanas cVentanas = ControlVentanas.getInstance();
    Cliente cliente;
    DefaultComboBoxModel<String> cbxPagos;
    
    /**
     * Creates new form FrmRealizarPedido
     */
    public FrmRealizarPedido() {
        this.cbxPagos = new DefaultComboBoxModel<>();
        
        this.cbxPagos.addElement(TipoPago.EFECTIVO.toString());
        this.cbxPagos.addElement(TipoPago.TRANSFERENCIA.toString());
        
        initComponents();
        
        centraVentana();
    }
    
    private void centraVentana(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        Dimension frameSize = getSize();
        
        if(frameSize.height > screenSize.height){
            frameSize.height = screenSize.height;
        }
        
        if(frameSize.width > screenSize.width){
            frameSize.width = screenSize.width;
        }
        
        setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
    }
    
    public void despliegaTabla(DefaultTableModel tabla){
        tblProductos = new javax.swing.JTable(tabla);
        
        tblProductos.getColumnModel().getColumn(0).setCellRenderer(new CantidadRenderer());
        tblProductos.getColumnModel().getColumn(0).setCellEditor(new CantidadEditor());
        
        tblProductos.getColumnModel().getColumn(3).setCellRenderer(new PersonalizarRenderer());
        tblProductos.getColumnModel().getColumn(3).setCellEditor(new PersonalizarEditor(new JCheckBox()));
        
        tblProductos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblProductos.setAutoscrolls(false);
        tblProductos.setAutoResizeMode(2);
        
        jScrollPane1.setViewportView(tblProductos);
    }
    
    public void actualizarPrecioTotal(float precio) {
        this.lblPrecioProducto.setText("$ " + String.format("%.2f", precio));
    }
    
    public void actualizarPrecioEnvio(float precioEnvio) {
        this.lblPrecioEnvio.setText("$ " + String.format("%.2f", precioEnvio));
    }
    
    public void actualizaCostoTotal(float costoTotal) {
        this.lblCostoTotal.setText("$ " + String.format("%.2f", costoTotal));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtApellidoPaterno = new javax.swing.JTextField();
        txtApellidoMaterno = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        cbxTipoPago = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        btnCalcularEnvio = new javax.swing.JButton();
        btnAnhadir = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        lblCostoTotal = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblPrecioProducto = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblPrecioEnvio = new javax.swing.JLabel();
        btnRealizarPedido = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Realizar Pedido - SGP");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(220, 230, 250));

        jPanel2.setBackground(new java.awt.Color(70, 130, 180));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Información del pedido");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Teléfono del cliente:");

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.setEnabled(false);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre(s):");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Apellido P:");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Apellido M:");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Dirección:");

        cbxTipoPago.setModel(cbxPagos);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tipo de Pago:");

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        tblProductos.setAutoscrolls(false);
        tblProductos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblProductos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblProductos);

        btnCalcularEnvio.setText("Calcular costo de envío");
        btnCalcularEnvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularEnvioActionPerformed(evt);
            }
        });

        btnAnhadir.setText("Añadir");
        btnAnhadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnhadirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxTipoPago, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel4)
                                                .addGap(33, 33, 33))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(jLabel6))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addComponent(jLabel7))
                                            .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(21, 21, 21)))))
                                .addGap(8, 8, 8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnAnhadir)
                                .addGap(112, 112, 112)
                                .addComponent(btnCalcularEnvio)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxTipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCalcularEnvio)
                        .addContainerGap(15, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAnhadir)
                        .addContainerGap())))
        );

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Total:");

        lblCostoTotal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblCostoTotal.setText("$ 0.00");

        jLabel8.setText("Producto(s): ");

        lblPrecioProducto.setText("$ 0.00");

        jLabel9.setText("Envío:");

        lblPrecioEnvio.setText("$ 0.00");

        btnRealizarPedido.setText("Realizar Pedido");
        btnRealizarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarPedidoActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblPrecioProducto))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(42, 42, 42)
                                        .addComponent(lblPrecioEnvio)))
                                .addGap(278, 278, 278)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCostoTotal)
                                    .addComponent(jLabel10))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnRegresar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRealizarPedido))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8)
                            .addComponent(lblPrecioProducto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCostoTotal)
                            .addComponent(jLabel9)
                            .addComponent(lblPrecioEnvio))
                        .addContainerGap(63, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRealizarPedido)
                            .addComponent(btnRegresar))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.txtTelefono.setText("");
        this.txtNombre.setText("");
        this.txtApellidoPaterno.setText("");
        this.txtApellidoMaterno.setText("");
        this.txtDireccion.setText("");
        this.btnBuscar.setEnabled(false);
        
        dispose();
        cVentanas.mostrarVentanaPrincipal();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        cliente = cPedidos.buscarCliente(txtTelefono.getText());
        
        if(cliente != null) {
            this.txtNombre.setText(cliente.getNombres());
            this.txtApellidoPaterno.setText(cliente.getApellidoPaterno());
            this.txtApellidoMaterno.setText(cliente.getApellidoMaterno());
            this.txtDireccion.setText(cliente.getDireccion());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAnhadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnhadirActionPerformed
        cVentanas.mostrarAgregarProducto(this);
    }//GEN-LAST:event_btnAnhadirActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.txtTelefono.setText("");
        this.txtNombre.setText("");
        this.txtApellidoPaterno.setText("");
        this.txtApellidoMaterno.setText("");
        this.txtDireccion.setText("");
        this.btnBuscar.setEnabled(false);
        
        cVentanas.mostrarVentanaPrincipal();
    }//GEN-LAST:event_formWindowClosed

    private void btnCalcularEnvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularEnvioActionPerformed
        if("".equalsIgnoreCase(this.txtDireccion.getText())) {
            JOptionPane.showMessageDialog(this, "No ha introducido ni una dirección para calcular el envío", "Error!!", JOptionPane.ERROR_MESSAGE);
        }else {
            try {
                cPedidos.calcularCostoEnvio(this.txtDireccion.getText());
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            } catch (InterruptedException ie) {
                System.out.println(ie.getMessage());
            }
        }
    }//GEN-LAST:event_btnCalcularEnvioActionPerformed

    private void txtTelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyReleased
        boolean limite = this.txtTelefono.getText().length() >= 10;
        
        if(limite) {
            this.btnBuscar.setEnabled(limite);
        }else {
            this.btnBuscar.setEnabled(limite);
        }
    }//GEN-LAST:event_txtTelefonoKeyReleased

    private void btnRealizarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarPedidoActionPerformed
        if(!this.validarCampos()) {
            return;
        }
        
        if(cliente == null) {
            cliente = new Cliente(
                this.txtNombre.getText(),
                this.txtApellidoPaterno.getText(),
                this.txtApellidoMaterno.getText(),
                this.txtDireccion.getText() + ", Ciudad Obregón",
                this.txtTelefono.getText()
            );
        }
        
        String descripcion = "";
        
        for (int i = 0; i < this.tblProductos.getRowCount(); i++) {
            descripcion += "x" + this.tblProductos.getModel().getValueAt(i, 0) + " "; 
            descripcion += (i == (this.tblProductos.getRowCount()-1)) ? this.tblProductos.getModel().getValueAt(i, 1) : this.tblProductos.getModel().getValueAt(i, 1) + ", \n";
        }
        
        Pedido pedido = new Pedido(
                descripcion,
                EstadoPedidos.COCINANDO,
                Float.valueOf(this.lblPrecioProducto.getText().replaceAll("\\$", "").trim()),
                Float.valueOf(this.lblPrecioEnvio.getText().replaceAll("\\$", "").trim()),
                cliente,
                new GregorianCalendar(), 
                TipoPago.valueOf(this.cbxTipoPago.getSelectedItem().toString())
            );
        
        cPedidos.realizarPedido(cliente, pedido);
        cVentanas.mostrarVentanaPrincipal();
        dispose();
    }//GEN-LAST:event_btnRealizarPedidoActionPerformed

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

    private boolean validarCampos() {
        if("".equalsIgnoreCase(this.txtTelefono.getText())) {
            JOptionPane.showMessageDialog(this, "Tiene que ingresar el número de teléfono", "Campo faltante!", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }else if("".equalsIgnoreCase(this.txtNombre.getText())) {
            JOptionPane.showMessageDialog(this, "Tiene que ingresar el nombre del cliente", "Campo faltante!", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }else if("".equalsIgnoreCase(this.txtApellidoPaterno.getText())) {
            JOptionPane.showMessageDialog(this, "Tiene que ingresar el apellido paterno del cliente", "Campo faltante!", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }else if("".equalsIgnoreCase(this.txtApellidoMaterno.getText())) {
            JOptionPane.showMessageDialog(this, "Tiene que ingresar el apellido materno del cliente", "Campo faltante!", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }else if("".equalsIgnoreCase(this.txtDireccion.getText())) {
            JOptionPane.showMessageDialog(this, "Tiene que ingresar la dirección del cliente", "Campo faltante", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }else if(this.tblProductos.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Tiene que haber productos en el pedido", "Productos a comprar!", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnhadir;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCalcularEnvio;
    private javax.swing.JButton btnRealizarPedido;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbxTipoPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCostoTotal;
    private javax.swing.JLabel lblPrecioEnvio;
    private javax.swing.JLabel lblPrecioProducto;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
