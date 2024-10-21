package vista;

import control.Control;
import dominio.Producto;
import java.awt.Dimension;
import java.awt.Point;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Samuel Vega
 */
public class DlgAgregarProducto extends javax.swing.JDialog {
    private DefaultListModel<String> modeloLista;
    private List<Producto> productos;
    private Control c = Control.getInstance();
    
    /**
     * Creates new form dlgAgregarProducto
     * @param parent
     * @param modal
     * @param productos
     */
    public DlgAgregarProducto(java.awt.Frame parent, boolean modal, List<Producto> productos) {
        super(parent, modal);
        this.productos = productos;
        this.txtBuscar = new JTextField();
        this.modeloLista = new DefaultListModel<>();
        this.listaProductos = new JList<>(modeloLista);
        
        initComponents();
        
        this.menu.add(this.panel);
        
        centraCuadroDialogo(parent);
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
     * Filtra los productos en existencia
     * @return Lista de productos disponibles
     */
    private List<Producto> filtrarProductos() {
        String texto = txtBuscar.getText().toLowerCase();
        List<Producto> productosFiltrados = productos.stream().filter(p -> p.getNombre().toLowerCase().contains(texto)).collect(Collectors.toList());
        return productosFiltrados;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaProductos = new javax.swing.JList<>();
        menu = new javax.swing.JPopupMenu();
        jLabel1 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();

        listaProductos.setModel(modeloLista);
        listaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaProductos);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );

        menu.setFocusable(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Producto");

        jLabel1.setText("Buscar producto:");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
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
                        .addComponent(txtBuscar)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 161, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(143, 143, 143))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregar)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        if(!"".equalsIgnoreCase(txtBuscar.getText())) {
            modeloLista.removeAllElements();
            for (Producto producto : filtrarProductos()) {
                modeloLista.addElement(producto.getNombre() + ", $ " + producto.getPrecio());
            }
            menu.show(txtBuscar, 0, txtBuscar.getHeight());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void listaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaProductosMouseClicked
        int coma = listaProductos.getSelectedValue().indexOf(",");
        txtBuscar.setText(listaProductos.getSelectedValue().substring(0, coma).trim());
    }//GEN-LAST:event_listaProductosMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Producto productoAgregado = null;
        
        for (Producto producto : productos) {
            if(producto.getNombre().equalsIgnoreCase(txtBuscar.getText())) {
                productoAgregado = producto;
                
                JOptionPane.showMessageDialog(this, "Se agregó correctamente el costo de envío al pedido.", "Agregado exitoso", JOptionPane.PLAIN_MESSAGE);
        
                c.agregarProducto(productoAgregado);
                c.actualizarRealizarPedido();
                dispose();
                return;
            }
        }
        
        JOptionPane.showMessageDialog(this, "No se encontró el producto: " + txtBuscar.getText() + "\nAsegurese de que el producto que eligió se haya puesto en la caja de texto.", "Error!!", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnAgregarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaProductos;
    private javax.swing.JPopupMenu menu;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
