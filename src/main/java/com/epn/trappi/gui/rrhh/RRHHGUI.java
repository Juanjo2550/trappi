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
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
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
        configurarBotones(20);
        this.roles = new RolDePagosDb();
        this.sp = new SolicitudPagoDB();
        this.pagos = new SolicitudDePago();
        inicioTable();
        this.jButton6.setEnabled(false);
        this.setSize(1366, 768);
        this.setLocationRelativeTo(null);
    }

    public static class RoundedBorder implements Border {

        private int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
        }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }
    //configuracion de botones

    private void configurarBotones(int radio) {
        this.jButton6.setBorder(new RoundedBorder(24));
        this.jButton6.setBorderPainted(true);
        this.jButton6.setOpaque(false);
        this.jButton6.setContentAreaFilled(false);
        this.jButton6.setHorizontalAlignment(SwingConstants.CENTER);

        this.jButton5.setBorder(new RoundedBorder(24));
        this.jButton5.setBorderPainted(true);
        this.jButton5.setOpaque(false);
        this.jButton5.setContentAreaFilled(false);
        this.jButton5.setHorizontalAlignment(SwingConstants.CENTER);

        this.jButton3.setBorder(new RoundedBorder(24));
        this.jButton3.setBorderPainted(true);
        this.jButton3.setOpaque(false);
        this.jButton3.setContentAreaFilled(false);
        this.jButton3.setHorizontalAlignment(SwingConstants.CENTER);

        this.btnVolver.setBorder(new RoundedBorder(24));
        this.btnVolver.setBorderPainted(true);
        this.btnVolver.setOpaque(false);
        this.btnVolver.setContentAreaFilled(false);
        this.btnVolver.setHorizontalAlignment(SwingConstants.CENTER);

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
            "Monto",};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        for (SolicitudDePago solicitud : this.sp.obtenerTodos(cedula)) {
            Object[] row = {
                solicitud.getCuentaBancaria(),
                solicitud.getMontoTotal(),};
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
        jButton6 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1366, 768));

        jPanel2.setBackground(new java.awt.Color(61, 57, 57));

        jPanel3.setBackground(new java.awt.Color(61, 57, 57));

        jButton6.setBackground(new java.awt.Color(255, 210, 28));
        jButton6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Solicitar Pagos");
        jButton6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton6.setBorderPainted(false);
        jButton6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jButton6MouseMoved(evt);
            }
        });
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton6MouseExited(evt);
            }
        });
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
        jButton3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jButton3MouseMoved(evt);
            }
        });
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3MouseExited(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 210, 28));
        jButton5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Roles por Empleado");
        jButton5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton5.setBorderPainted(false);
        jButton5.setMaximumSize(new java.awt.Dimension(77, 29));
        jButton5.setMinimumSize(new java.awt.Dimension(77, 29));
        jButton5.setPreferredSize(new java.awt.Dimension(250, 29));
        jButton5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jButton5MouseMoved(evt);
            }
        });
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton5MouseExited(evt);
            }
        });
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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        btnVolver.setBackground(new java.awt.Color(255, 210, 28));
        btnVolver.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Regresar");
        btnVolver.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnVolver.setBorderPainted(false);
        btnVolver.setPreferredSize(new java.awt.Dimension(250, 29));
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LogoRRHH.PNG"))); // NOI18N

        jButton4.setBackground(new java.awt.Color(255, 210, 28));
        jButton4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Roles de Pago");
        jButton4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton4.setBorderPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(154, Short.MAX_VALUE))
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
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(95, Short.MAX_VALUE))
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
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseMoved
        Color c = new Color(255, 210, 28);
        this.jButton3.setForeground(c);
    }//GEN-LAST:event_jButton3MouseMoved

    private void jButton6MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseMoved
        Color c = new Color(255, 210, 28);
        this.jButton6.setForeground(c);
    }//GEN-LAST:event_jButton6MouseMoved

    private void jButton5MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseMoved
        Color c = new Color(255, 210, 28);
        this.jButton5.setForeground(c);
    }//GEN-LAST:event_jButton5MouseMoved

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
        Color c = new Color(255, 255, 255);
        this.jButton3.setForeground(c);
    }//GEN-LAST:event_jButton3MouseExited

    private void jButton6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseExited

        Color c = new Color(255, 255, 255);
        this.jButton6.setForeground(c);

    }//GEN-LAST:event_jButton6MouseExited

    private void jButton5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseExited
        Color c = new Color(255, 255, 255);
        this.jButton5.setForeground(c);
    }//GEN-LAST:event_jButton5MouseExited

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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEmpleados;
    // End of variables declaration//GEN-END:variables
}
