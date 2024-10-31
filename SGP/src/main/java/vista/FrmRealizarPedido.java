package vista;

import control.Control;
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
import util.EstadoPedidos;
import util.tablesButtons.PersonalizarRenderer;
import util.tablesButtons.PersonalizarEditor;
import util.TipoPago;
import util.tablesButtons.CantidadEditor;
import util.tablesButtons.CantidadRenderer;

/**
 *
 * @author Samuel Vega
 */
public class FrmRealizarPedido extends javax.swing.JFrame {
    Control c = Control.getInstance();
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
        btnRegresar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        lblPrecioProducto = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblPrecioEnvio = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblCostoTotal = new javax.swing.JLabel();
        btnRealizarPedido = new javax.swing.JButton();

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

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setText("Información Pedido");

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

        jLabel3.setText("Nombre(s):");

        jLabel4.setText("Apellido P:");

        jLabel5.setText("Apellido M:");

        jLabel6.setText("Dirección:");

        cbxTipoPago.setModel(cbxPagos);

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
                                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel4)
                                                .addGap(56, 56, 56))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addComponent(jLabel7))
                                            .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5))))
                                .addGap(8, 8, 8)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAnhadir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCalcularEnvio)
                        .addGap(151, 151, 151))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCalcularEnvio)
                    .addComponent(btnAnhadir))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel8.setText("Producto(s): ");

        lblPrecioProducto.setText("$ 0.00");

        jLabel9.setText("Envío:");

        lblPrecioEnvio.setText("$ 0.00");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Total:");

        lblCostoTotal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblCostoTotal.setText("$ 0.00");

        btnRealizarPedido.setText("Realizar Pedido");
        btnRealizarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarPedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRealizarPedido))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPrecioProducto)
                            .addComponent(lblPrecioEnvio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCostoTotal)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(12, 12, 12)))
                        .addGap(50, 50, 50)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblPrecioProducto)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblPrecioEnvio)
                    .addComponent(lblCostoTotal))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnRealizarPedido))
                .addContainerGap())
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
        c.mostrarVentanaPrincipal();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        cliente = c.buscarCliente(txtTelefono.getText());
        
        if(cliente != null) {
            this.txtNombre.setText(cliente.getNombres());
            this.txtApellidoPaterno.setText(cliente.getApellidoPaterno());
            this.txtApellidoMaterno.setText(cliente.getApellidoMaterno());
            this.txtDireccion.setText(cliente.getDireccion());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAnhadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnhadirActionPerformed
        c.mostrarAgregarProducto(this);
    }//GEN-LAST:event_btnAnhadirActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.txtTelefono.setText("");
        this.txtNombre.setText("");
        this.txtApellidoPaterno.setText("");
        this.txtApellidoMaterno.setText("");
        this.txtDireccion.setText("");
        this.btnBuscar.setEnabled(false);
        
        c.mostrarVentanaPrincipal();
    }//GEN-LAST:event_formWindowClosed

    private void btnCalcularEnvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularEnvioActionPerformed
        if("".equalsIgnoreCase(this.txtDireccion.getText())) {
            JOptionPane.showMessageDialog(this, "No ha introducido ni una dirección para calcular el envío", "Error!!", JOptionPane.ERROR_MESSAGE);
        }else {
            try {
                c.calcularCostoEnvio(this.txtDireccion.getText());
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
            descripcion += "x" + this.tblProductos.getModel().getValueAt(i, 0) + " " + this.tblProductos.getModel().getValueAt(i, 1) + ", \n"; 
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
        
        c.realizarPedido(cliente, pedido);
        c.mostrarVentanaPrincipal();
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
