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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1366, 768));

        jPanel1.setBackground(new java.awt.Color(61, 57, 57));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LOGOtrappi.jpeg"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton4.setBackground(new java.awt.Color(255, 210, 28));
        jButton4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Salir");
        jButton4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton4.setBorderPainted(false);
        jButton4.setPreferredSize(new java.awt.Dimension(50, 29));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 923, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(61, 57, 57));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("RECURSOS HUMANOS");

        jPanel3.setBackground(new java.awt.Color(61, 57, 57));

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

        jButton5.setBackground(new java.awt.Color(255, 210, 28));
        jButton5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Lista de Roles por Empleado");
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1002, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

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
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEmpleados;
    // End of variables declaration//GEN-END:variables
}
