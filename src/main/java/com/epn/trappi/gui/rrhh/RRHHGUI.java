/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.rrhh;

import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.models.financiero.Pago;
import com.epn.trappi.models.rrhh.juanjo.RolDePagos;
import com.epn.trappi.db.rrhh.RolDePagosDb;
import com.epn.trappi.db.rrhh.SolicitudPagoDB;
import com.epn.trappi.models.rrhh.diego.SolicitudDePago;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author stali
 */
public class RRHHGUI extends javax.swing.JFrame {

    private final SolicitudPagoDB sp;

    private final RolDePagosDb roles;
    private final SolicitudDePago pagos;
    String cuenta;
    String total;
    String estado;
    int seleccion;

    /**
     * Creates new form Ejemplo_GUI
     */
    public RRHHGUI() {
        initComponents();
        this.roles = new RolDePagosDb();
        this.sp = new SolicitudPagoDB();
        this.pagos = new SolicitudDePago();
        inicioTable();
        this.jButton6.setEnabled(false);
    }

    public final void inicioTable() {
        String col[] = {
            "Número",
            "Nombre",
            "Apellido",
            "Cuenta",
            "Fecha",
            "Total",
            "Descuentos",
            "Estado"

        };
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        this.tablaEmpleados.setModel(tableModel);
        this.tablaEmpleados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.tablaEmpleados.setDefaultEditor(Object.class, null);
        this.tablaEmpleados.setRowSelectionAllowed(true);
        this.tablaEmpleados.setColumnSelectionAllowed(false);
        this.tablaEmpleados.getColumnModel().getColumn(0).setPreferredWidth(2);
    }

    public final void solicitudTable() throws Exception {

        String col[] = {
            "Cuenta",
            "Monto Total",};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        for (SolicitudDePago solicitud : this.pagos.SolicitarPago()) {
            Object[] row = {
                solicitud.getCuentaBancaria(),
                solicitud.getMontoTotal()

            };
            tableModel.addRow(row);
        }

        this.tablaEmpleados.setModel(tableModel);
        this.tablaEmpleados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.tablaEmpleados.setDefaultEditor(Object.class, null);
        this.tablaEmpleados.setRowSelectionAllowed(true);
        this.tablaEmpleados.setColumnSelectionAllowed(false);
        this.tablaEmpleados.getColumnModel().getColumn(0).setPreferredWidth(2);
    }

    public final void solicitudTable1(String cedula) throws Exception {

        String col[] = {
            
            "Numero de Cuenta",
            "Monto",
         

        };
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        for (SolicitudDePago solicitud : this.sp.obtenerTodos(cedula)) {
            Object[] row = {
           
                solicitud.getCuentaBancaria(),
                solicitud.getMontoTotal(),
           

            };
            tableModel.addRow(row);
        }

        this.tablaEmpleados.setModel(tableModel);
        this.tablaEmpleados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.tablaEmpleados.setDefaultEditor(Object.class, null);
        this.tablaEmpleados.setRowSelectionAllowed(true);
        this.tablaEmpleados.setColumnSelectionAllowed(false);
        this.tablaEmpleados.getColumnModel().getColumn(0).setPreferredWidth(2);
    }

    public final void fillTable() {

        String col[] = {
            "Número",
            "Cedula",
            "Nombre",
            "Apellido",
            "Cuenta",
            "Fecha",
            "Total",
            "Descuentos",
            "Estado"

        };
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        for (RolDePagos rol : this.roles.obtenerTodos()) {
            Object[] row = {
                rol.getNumero(),
                rol.getEmpleado().getCedula(),
                rol.getEmpleado().getNombres(),
                rol.getEmpleado().getApellidos(),
                rol.getEmpleado().getCuentaBancaria(),
                rol.getFecha(),
                rol.getTotal(),
                rol.getDescuentos(),
                rol.getEstado()
            };
            tableModel.addRow(row);
        }

        this.tablaEmpleados.setModel(tableModel);
        this.tablaEmpleados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.tablaEmpleados.setDefaultEditor(Object.class, null);
        this.tablaEmpleados.setRowSelectionAllowed(true);
        this.tablaEmpleados.setColumnSelectionAllowed(false);
        this.tablaEmpleados.getColumnModel().getColumn(0).setPreferredWidth(2);
    }

    boolean bandera = false;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1366, 768));

        jPanel2.setBackground(new java.awt.Color(61, 57, 57));

        jPanel3.setBackground(new java.awt.Color(61, 57, 57));

        jButton5.setBackground(new java.awt.Color(255, 210, 28));
        jButton5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Roles por Empleado");
        jButton5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton5.setBorderPainted(false);
        jButton5.setMaximumSize(new java.awt.Dimension(77, 29));
        jButton5.setMinimumSize(new java.awt.Dimension(77, 29));
        jButton5.setPreferredSize(new java.awt.Dimension(250, 29));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 210, 28));
        jButton3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Generar Roles");
        jButton3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton3.setBorderPainted(false);
        jButton3.setPreferredSize(new java.awt.Dimension(250, 29));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 36, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnVolver.setBackground(new java.awt.Color(255, 210, 28));
        btnVolver.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Volver");
        btnVolver.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnVolver.setBorderPainted(false);
        btnVolver.setPreferredSize(new java.awt.Dimension(250, 29));
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 210, 28));
        jButton6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Solicitar Pagos");
        jButton6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton6.setBorderPainted(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LogoRRHH.PNG"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 449, Short.MAX_VALUE)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 10)); // NOI18N

        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaEmpleados);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel3.setText("Seleccione una fila antes de continuar:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.setVisible(false);
        new PANTALLA_PRINCIPAL().setVisible(true);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        fillTable();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String cedulaSeleccionada = (String) this.tablaEmpleados.getValueAt(seleccion, 1);

        this.sp.actualizarEstado(cedulaSeleccionada);

        /*Pago pago = new Pago(cuenta, Double.parseDouble(total));
        System.out.println(cuenta);
        System.out.println(total);
        String cambioEstado = pago.realizarPago(pago);
        String query = "UPDATE ROLPAGOS SET ESTADOROL=" +"'"+ cambioEstado +"'"+ " WHERE ID_ROL=" +"'"+this.tablaEmpleados.getValueAt(seleccion, 0) +"';";
        try {
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }*/
        //SolicitudDePago  solicitud = new SolicitudDePago(estado,Double.parseDouble(total), cuenta);
        try {

            solicitudTable1(cedulaSeleccionada);
        } catch (Exception ex) {
            Logger.getLogger(RRHHGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void tablaEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEmpleadosMouseClicked

        seleccion = this.tablaEmpleados.rowAtPoint(evt.getPoint());
        cuenta = String.valueOf(tablaEmpleados.getValueAt(seleccion, 3));
        total = String.valueOf(tablaEmpleados.getValueAt(seleccion, 5));
        estado = String.valueOf(tablaEmpleados.getValueAt(seleccion, 7));
        this.jButton6.setEnabled(true);
        /*      Pago pago = new Pago(cuenta, Double.parseDouble(total));
        System.out.println(cuenta);
        System.out.println(total);
        String cambioEstado = pago.realizarPago(pago);
        String query = "UPDATE ROLPAGOS SET ESTADOROL=" +"'"+ cambioEstado +"'"+ " WHERE ID_ROL=" +"'"+this.tablaEmpleados.getValueAt(seleccion, 0) +"';";
        try {
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
         */

    }//GEN-LAST:event_tablaEmpleadosMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String cedulaSeleccionada = (String) this.tablaEmpleados.getValueAt(seleccion, 1);
        try {
            solicitudTable1(cedulaSeleccionada);
        } catch (Exception ex) {
            Logger.getLogger(RRHHGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RRHHGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RRHHGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RRHHGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RRHHGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RRHHGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolver;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEmpleados;
    // End of variables declaration//GEN-END:variables
}