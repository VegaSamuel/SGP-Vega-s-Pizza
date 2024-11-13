/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import control.ControlVentas;
import dominio.Cliente;
import dominio.Venta;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class FrmRevisarVentas extends javax.swing.JFrame {

    ControlVentas c = ControlVentas.getInstance();
    private DefaultTableModel tableModel;

    public FrmRevisarVentas() {
        initComponents();
        crearTabla();
    }

    public FrmRevisarVentas(Calendar fechaInicio, Calendar fechaFinal) {
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
        tblVentas = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ventas");

        tblVentas.setModel(new javax.swing.table.DefaultTableModel(
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
        tblVentas.setEnabled(false);
        jScrollPane1.setViewportView(tblVentas);

        jButton1.setText("Regresar");

        jButton2.setText("Filtros");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1203, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(15, Short.MAX_VALUE))
        );

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

 public void crearTabla() {

        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"ID Venta", "Descripción", "Nombre Cliente", "Fecha", "Costo", "Envío", "Importe Total", "Tipo de Pago"});

        this.tblVentas.setModel(tableModel);

        List<Venta> ventas = null;//= c.obtenerVentasFiltro(fechaInicio, fechaFin);IMPLEMENTAR EN EL CONTROL

        for (Venta venta : ventas) {
            Calendar fecha = venta.getObjetoPedido().getFecha();

            int anio = fecha.get(Calendar.YEAR);
            int mes = fecha.get(Calendar.MONTH) + 1;
            int dia = fecha.get(Calendar.DAY_OF_MONTH);

            String fechaFormateada = anio + "-" + (mes < 10 ? "0" + mes : mes) + "-" + (dia < 10 ? "0" + dia : dia);

            Cliente cliente = venta.getObjetoPedido().getCliente();
            String nombreCliente = cliente.getNombres() + " " + cliente.getApellidoPaterno();

            tableModel.addRow(new Object[]{
                venta.getId(),
                venta.getObjetoPedido().getDescripcion(),
                nombreCliente,
                fechaFormateada,
                "$ " + String.format("%.2f", venta.getObjetoPedido().getCosto()),
                "$ " + String.format("%.2f", venta.getObjetoPedido().getEnvio()),
                "$ " + String.format("%.2f", venta.getObjetoPedido().getCosto()),//PONER TOTAL
                venta.getObjetoPedido().getTipoPago()
            });
        }

        ajustarColumnas();
    }
 
    public void crearTablaFiltro(Calendar fechaInicio, Calendar fechaFin) {
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"ID Venta", "Descripción", "Nombre Cliente", "Fecha", "Costo", "Envío", "Importe Total", "Tipo de Pago"});

        this.tblVentas.setModel(tableModel);

        List<Venta> ventas = null;//= c.obtenerVentasFiltro(fechaInicio, fechaFin);IMPLEMENTAR EN EL CONTROL

        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

        for (Venta venta : ventas) {
            Cliente cliente = venta.getObjetoPedido().getCliente();
            String nombreCliente = cliente.getNombres() + " " + cliente.getApellidoPaterno();

            tableModel.addRow(new Object[]{
                venta.getId(),
                venta.getObjetoPedido().getDescripcion(),
                nombreCliente,
                formatoFecha.format(venta.getObjetoPedido().getFecha().getTime()),
                "$ " + String.format("%.2f", venta.getObjetoPedido().getCosto()),
                "$ " + String.format("%.2f", venta.getObjetoPedido().getEnvio()),
                "$ " + String.format("%.2f", venta.getObjetoPedido().getCosto()),//PONER TOTAL
                venta.getObjetoPedido().getTipoPago()
            });
        }

        ajustarColumnas();
    }
    
        private void ajustarColumnas() {
        TableColumnModel columnModel = tblVentas.getColumnModel();

        columnModel.getColumn(7).setPreferredWidth(65);
        columnModel.getColumn(6).setPreferredWidth(50);
        columnModel.getColumn(5).setPreferredWidth(35);
        columnModel.getColumn(4).setPreferredWidth(35);
        columnModel.getColumn(3).setPreferredWidth(50);
        columnModel.getColumn(2).setPreferredWidth(150);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(0).setPreferredWidth(35);

        tblVentas.revalidate();
        tblVentas.repaint();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVentas;
    // End of variables declaration//GEN-END:variables
}