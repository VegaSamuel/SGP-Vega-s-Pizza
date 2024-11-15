/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import control.ControlPedidos;
import dominio.Cliente;
import dominio.Pedido;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Juan Sánchez
 */
public class FrmRevisarPedidos extends javax.swing.JFrame {

    ControlPedidos c = ControlPedidos.getInstance();
    private DefaultTableModel tableModel;

    /**
     * Creates new form FrmRevisarPedidos
     */
    public FrmRevisarPedidos() {
        initComponents();
        crearTabla();
    }

    public FrmRevisarPedidos(Calendar fechaInicio, Calendar fechaFinal) {
        initComponents();
        crearTablaFiltro(fechaInicio, fechaFinal);
    }

    public void setPeriodo(Calendar fechaInicio, Calendar fechaFinal) {
        crearTablaFiltro(fechaInicio, fechaFinal);
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPedidos = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();
        btnFiltro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Revisar Pedidos - SGP");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(220, 230, 250));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pedidos");

        tblPedidos.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPedidos.setEnabled(false);
        jScrollPane1.setViewportView(tblPedidos);

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnFiltro.setText("Filtros");
        btnFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnRegresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFiltro))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(20, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnFiltro))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltroActionPerformed
        c.mostrarSelectorFechas();
    }//GEN-LAST:event_btnFiltroActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        crearTabla();
        c.mostrarVentanaPrincipal();
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        c.mostrarVentanaPrincipal();
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltro;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPedidos;
    // End of variables declaration//GEN-END:variables
    public void crearTabla() {

        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"ID", "Descripción", "Estado", "Costo", "Nombre del cliente", "Dirección", "Fecha Compra", "Tipo Pago"});

        this.tblPedidos.setModel(tableModel);

        List<Pedido> pedidos = c.obtenerPedidos();

        for (Pedido pedido : pedidos) {
            Calendar fecha = pedido.getFecha();

            int anio = fecha.get(Calendar.YEAR);
            int mes = fecha.get(Calendar.MONTH) + 1;
            int dia = fecha.get(Calendar.DAY_OF_MONTH);

            String fechaFormateada = anio + "-" + (mes < 10 ? "0" + mes : mes) + "-" + (dia < 10 ? "0" + dia : dia);

            Cliente cliente = pedido.getCliente();
            String nombreCliente = cliente.getNombres() + " " + cliente.getApellidoPaterno();
            String direccionCliente = cliente.getDireccion();

            tableModel.addRow(new Object[]{
                pedido.getId(),
                pedido.getDescripcion(),
                pedido.getEstado(),
                "$ " + String.format("%.2f", pedido.getCosto()),
                nombreCliente,
                direccionCliente,
                fechaFormateada,
                pedido.getTipoPago()
            });
        }

        ajustarColumnas();
    }

    public void crearTablaFiltro(Calendar fechaInicio, Calendar fechaFin) {
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"ID", "Descripción", "Estado", "Costo", "Nombre del cliente", "Dirección", "Fecha Compra", "Tipo Pago"});

        this.tblPedidos.setModel(tableModel);

        List<Pedido> pedidos = c.obtenerPedidosFiltro(fechaInicio, fechaFin);

        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

        for (Pedido pedido : pedidos) {
            Cliente cliente = pedido.getCliente();
            String nombreCliente = cliente.getNombres() + " " + cliente.getApellidoPaterno();
            String direccionCliente = cliente.getDireccion();

            tableModel.addRow(new Object[]{
                pedido.getId(),
                pedido.getDescripcion(),
                pedido.getEstado(),
                "$ " + String.format("%.2f", pedido.getCosto()),
                nombreCliente,
                direccionCliente,
                formatoFecha.format(pedido.getFecha().getTime()),
                pedido.getTipoPago()
            });
        }
        
        ajustarColumnas();
    }

    private void ajustarColumnas() {
       
        TableColumnModel columnModel = tblPedidos.getColumnModel();

        columnModel.getColumn(7).setPreferredWidth(65);  
        columnModel.getColumn(6).setPreferredWidth(50);  
        columnModel.getColumn(5).setPreferredWidth(300);  
        columnModel.getColumn(3).setPreferredWidth(35); 
        columnModel.getColumn(2).setPreferredWidth(45); 
        columnModel.getColumn(1).setPreferredWidth(150); 
        columnModel.getColumn(0).setPreferredWidth(35); 

        tblPedidos.revalidate();
        tblPedidos.repaint();
    }

}
