package vista;

import control.ControlPedidos;
import control.ControlVentanas;
import control.ControlVentas;
import dominio.Pedido;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import util.enums.EstadoPedidos;
import util.enums.Operaciones;
import util.enums.TipoPago;

/**
 * Ventana principal
 *
 * @author Samuel Vega
 */
public class FrmPrincipal extends javax.swing.JFrame {

    ControlVentanas cVentanas = ControlVentanas.getInstance();
    ControlPedidos cPedidos = ControlPedidos.getInstance();
    ControlVentas cVentas = ControlVentas.getInstance();

    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
        centraVentana();
    }

    private void centraVentana() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        Dimension frameSize = getSize();

        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }

        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }

        setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    }

    /**
     * Agrega los pedidos actuales a la lista de pedidos.
     *
     * @param pedidos Lista de pedidos actuales.
     */
    public void setListPedidos(ListModel<Pedido> pedidos) {
        this.listPedidos.setModel(pedidos);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jMenu1 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listPedidos = new javax.swing.JList<>();
        btnRealizarPedido = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btnRevisarPedido = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        btnRegistrarVenta = new javax.swing.JButton();
        btnEnviarPedido = new javax.swing.JButton();
        btnRevisarVentas = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        menuClientes = new javax.swing.JMenu();
        clientesAgregar = new javax.swing.JMenuItem();
        clientesRevisar = new javax.swing.JMenuItem();
        menuProductos = new javax.swing.JMenu();
        productosAgregar = new javax.swing.JMenuItem();
        productosModificar = new javax.swing.JMenuItem();
        productosEliminar = new javax.swing.JMenuItem();
        productosRevisar = new javax.swing.JMenuItem();
        menuPromociones = new javax.swing.JMenu();
        promocionesAgregar = new javax.swing.JMenuItem();
        promocionesModificar = new javax.swing.JMenuItem();
        promocionesEliminar = new javax.swing.JMenuItem();
        promocionesRevisar = new javax.swing.JMenuItem();
        menuInventario = new javax.swing.JMenu();

        jLabel1.setText("jLabel1");

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Gestión de Pedidos - Vega's Pizza");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(220, 230, 250));

        listPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listPedidosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listPedidos);

        btnRealizarPedido.setText("Realizar Pedido");
        btnRealizarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarPedidoActionPerformed(evt);
            }
        });

        btn_cancelar.setText("Cancelar Pedido");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        btnRevisarPedido.setText("Revisar Pedidos");
        btnRevisarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRevisarPedidoActionPerformed(evt);
            }
        });

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo2.png"))); // NOI18N

        btnRegistrarVenta.setText("Registrar venta");
        btnRegistrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarVentaActionPerformed(evt);
            }
        });

        btnEnviarPedido.setText("Enviar Pedido");
        btnEnviarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarPedido(evt);
            }
        });

        btnRevisarVentas.setText("Revisar Ventas");
        btnRevisarVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRevisarVentasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRealizarPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRevisarVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRevisarPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRegistrarVenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEnviarPedido))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnviarPedido)
                    .addComponent(btnRegistrarVenta))
                .addGap(20, 37, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btnRealizarPedido)
                .addGap(49, 49, 49)
                .addComponent(btn_cancelar)
                .addGap(63, 63, 63)
                .addComponent(btnRevisarPedido)
                .addGap(53, 53, 53)
                .addComponent(btnRevisarVentas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLogo)
                .addGap(53, 53, 53))
        );

        menuClientes.setText("Clientes");

        clientesAgregar.setText("Agregar");
        clientesAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientesAgregarActionPerformed(evt);
            }
        });
        menuClientes.add(clientesAgregar);

        clientesRevisar.setText("Revisar");
        clientesRevisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientesRevisarActionPerformed(evt);
            }
        });
        menuClientes.add(clientesRevisar);

        menuBar.add(menuClientes);

        menuProductos.setText("Productos");

        productosAgregar.setText("Agregar");
        menuProductos.add(productosAgregar);

        productosModificar.setText("Modificar");
        menuProductos.add(productosModificar);

        productosEliminar.setText("Eliminar");
        menuProductos.add(productosEliminar);

        productosRevisar.setText("Revisar");
        menuProductos.add(productosRevisar);

        menuBar.add(menuProductos);

        menuPromociones.setText("Promociones");

        promocionesAgregar.setText("Agregar");
        menuPromociones.add(promocionesAgregar);

        promocionesModificar.setText("Modificar");
        menuPromociones.add(promocionesModificar);

        promocionesEliminar.setText("Eliminar");
        menuPromociones.add(promocionesEliminar);

        promocionesRevisar.setText("Revisar");
        menuPromociones.add(promocionesRevisar);

        menuBar.add(menuPromociones);

        menuInventario.setText("Inventario");
        menuBar.add(menuInventario);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRealizarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarPedidoActionPerformed
        cVentanas.mostrarRealizarPedido();
        dispose();
    }//GEN-LAST:event_btnRealizarPedidoActionPerformed

    private void btnRevisarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRevisarPedidoActionPerformed
        dispose();
        cVentanas.mostrarRevisarPedidos();
    }//GEN-LAST:event_btnRevisarPedidoActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        if(this.listPedidos.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(this, "No hay ningún pedido seleccionado, por favor, seleccione uno", "Seleccione un pedido", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        long idPedido = this.listPedidos.getSelectedValue().getId();

        cPedidos.cancelarPedido(idPedido);
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btnEnviarPedido(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarPedido
        if(this.listPedidos.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(this, "No hay ningún pedido seleccionado, por favor, seleccione uno", "Seleccione un pedido", JOptionPane.ERROR_MESSAGE);
            return;
        }else if(this.listPedidos.getSelectedValue().getEstado().equals(EstadoPedidos.ENVIADO)) {
            JOptionPane.showMessageDialog(this, "El pedido que seleccionó ya ha sido enviado", "Pedido ya enviado", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        Pedido pedido = this.listPedidos.getSelectedValue();
        
        cPedidos.enviarPedido(pedido.getId());
        
        if(pedido.getTipoPago().equals(TipoPago.TRANSFERENCIA)) {
            cPedidos.registrarVentaPedido(pedido.getId());
        }
    }//GEN-LAST:event_btnEnviarPedido

    private void btnRegistrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarVentaActionPerformed
        if(this.listPedidos.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(this, "No hay ningún pedido seleccionado, por favor, seleccione uno", "Seleccione un pedido", JOptionPane.ERROR_MESSAGE);
            return;
        }else if(!this.listPedidos.getSelectedValue().getEstado().equals(EstadoPedidos.ENVIADO)) {
            JOptionPane.showMessageDialog(this, "El pedido que seleccionó no ha sido enviado, por lo que no puede ser una venta aún", "Pedido no enviado!!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Pedido pedido = this.listPedidos.getSelectedValue();
        
        Object[] botones = {"Regresar", "Registar"};
        
        int resp = JOptionPane.showOptionDialog(this, "¿Seguro que quiere registrar la venta del pedido " + pedido.getId() + "?", "Confirmación sobre registro de pedido", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, botones, botones[0]);
        
        if(resp == 1) {
            cPedidos.registrarVentaPedido(pedido.getId());
        }
    }//GEN-LAST:event_btnRegistrarVentaActionPerformed

    private void listPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listPedidosMouseClicked
        Pedido pedido = this.listPedidos.getSelectedValue();
        
        if(pedido.getTipoPago().equals(TipoPago.TRANSFERENCIA)) {
            this.btnRegistrarVenta.setEnabled(false);
        }else {
            this.btnRegistrarVenta.setEnabled(true);
        }
    }//GEN-LAST:event_listPedidosMouseClicked

    private void btnRevisarVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRevisarVentasActionPerformed
        dispose();
        cVentas.mostrarRevisarVentas();
    }//GEN-LAST:event_btnRevisarVentasActionPerformed

    private void clientesRevisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientesRevisarActionPerformed
        dispose();
        cVentanas.mostrarRevisarClientes();
    }//GEN-LAST:event_clientesRevisarActionPerformed

    private void clientesAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientesAgregarActionPerformed
        dispose();
        cVentanas.mostrarAgregarClientes(this, null, Operaciones.AGREGAR);
    }//GEN-LAST:event_clientesAgregarActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviarPedido;
    private javax.swing.JButton btnRealizarPedido;
    private javax.swing.JButton btnRegistrarVenta;
    private javax.swing.JButton btnRevisarPedido;
    private javax.swing.JButton btnRevisarVentas;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JMenuItem clientesAgregar;
    private javax.swing.JMenuItem clientesRevisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JList<Pedido> listPedidos;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuClientes;
    private javax.swing.JMenu menuInventario;
    private javax.swing.JMenu menuProductos;
    private javax.swing.JMenu menuPromociones;
    private javax.swing.JMenuItem productosAgregar;
    private javax.swing.JMenuItem productosEliminar;
    private javax.swing.JMenuItem productosModificar;
    private javax.swing.JMenuItem productosRevisar;
    private javax.swing.JMenuItem promocionesAgregar;
    private javax.swing.JMenuItem promocionesEliminar;
    private javax.swing.JMenuItem promocionesModificar;
    private javax.swing.JMenuItem promocionesRevisar;
    // End of variables declaration//GEN-END:variables

}
