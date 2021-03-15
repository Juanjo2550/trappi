/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.rrhh;


import com.epn.trappi.db.rrhh.AsistenciaDb;
import com.epn.trappi.models.rrhh.juanjo.Empleado;
import com.epn.trappi.models.rrhh.juanjo.RolDePagos;
import com.epn.trappi.db.rrhh.EmpleadoDb;
import com.epn.trappi.db.rrhh.ObservacionDb;
import com.epn.trappi.db.rrhh.RolDePagosDb;
import com.epn.trappi.models.logistico.Conductor;
import com.epn.trappi.models.logistico.ControlDisponibilidad;
import com.epn.trappi.models.rrhh.juanjo.Asistencia;
import com.epn.trappi.models.rrhh.juanjo.Observacion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author stali
 */
public class DetalleEmpleadoGUI extends javax.swing.JFrame {
    private Empleado empleado;
  
    private ContratacionPrincipal parentForm;
    /**
     * Creates new form Ejemplo_GUI
     */
    public DetalleEmpleadoGUI() {
        initComponents();
    }
    
    public DetalleEmpleadoGUI(String cedula, ContratacionPrincipal parentForm) {
        initComponents();
        this.jButton1.setEnabled(parentForm.getControlAsistencias().comprobarSiPuedoRegistrarUnaAsistencia(cedula));
        this.jButton2.setEnabled(parentForm.getControlAsistencias().comprobarSiPuedoRegistrarFinDeJornada(cedula));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.parentForm = parentForm;
        this.empleado = new EmpleadoDb().buscarUno(cedula);
        this.nombreEmpleado.setText(this.empleado.getNombres() + " " + this.empleado.getApellidos());
        this.cedulaTextField.setText(this.empleado.getCedula().toString());
        this.cargoTextField.setText(this.empleado.getCargo());
        this.departamentoTextField.setText(this.empleado.getDepartamento());
        this.cuentaBancariaTextField.setText(this.empleado.getCuentaBancaria());
        this.bancoTextField.setText(this.empleado.getBanco());
        this.estadoTextField.setText(this.empleado.getEstado());
        this.sexoTextiField.setText(this.empleado.getSexo() + "");
        this.jButton2.setEnabled(false);
        try {
            this.fillTable(cedula);
            fillAsistencias(cedula);
            fillObs(cedula);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public final void fillTable(String cedula) throws Exception {
        String col [] = {
            "Id",
            "Total",
            "Descuentos",
            "Fecha",
            "Estado"
        };
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        for(RolDePagos r : new RolDePagosDb().obtenerTodos(cedula)){
            Object [] row = {
                r.getNumero(),
                r.getTotal(),
                r.getDescuentos(),
                r.getFecha().toString(),
                r.getEstado()
            };
                   
            tableModel.addRow(row);
        }
        
        this.tabla.setModel(tableModel);
        this.tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.tabla.setDefaultEditor(Object.class, null);
        this.tabla.setRowSelectionAllowed(true);
        this.tabla.setColumnSelectionAllowed(false);
        this.tabla.getColumnModel().getColumn(0).setPreferredWidth(2);
    }
    
    public final void fillAsistencias(String cedula) throws Exception {
        String col [] = {
            "Fecha",
            "Hora de entrada",
            "Hora de salida"
        };
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        ArrayList<Object> row = new ArrayList<>();
        for (Asistencia as: new AsistenciaDb().obtenerTodos(cedula)){
            if(as.getHoraFin() != null) {
                row.add(as.getFecha().toString());
                row.add(as.getHoraInicio().getHora() + ":" + as.getHoraInicio().getMinutos() + ":" + as.getHoraInicio().getSegundos());
                row.add(as.getHoraFin().getHora() + ":" + as.getHoraFin().getMinutos() + ":" + as.getHoraFin().getSegundos());
                tableModel.addRow(row.toArray(col));
                row.clear();
            } else {
                row.add(as.getFecha().toString());
                row.add(as.getHoraInicio().getHora() + ":" + as.getHoraInicio().getMinutos() + ":" + as.getHoraInicio().getSegundos());
                row.add("N/A");
                tableModel.addRow(row.toArray(col));
                row.clear();
            }
        }
        
        this.asistenciasTabla.setModel(tableModel);
        this.asistenciasTabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.asistenciasTabla.setDefaultEditor(Object.class, null);
        this.asistenciasTabla.setRowSelectionAllowed(true);
        this.asistenciasTabla.setColumnSelectionAllowed(false);
        this.asistenciasTabla.getColumnModel().getColumn(0).setPreferredWidth(2);
    }
    
    public final void fillObs(String cedula) throws Exception {
        String col [] = {
            "Fecha",
            "Tipo"
        };
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        for (Observacion as: new ObservacionDb().obtenerTodos(cedula)){ 
            Object [] row = {
                as.getFecha().toString(),
                as.getTipo()
            };
            tableModel.addRow(row);
        }
        
        this.jTable1.setModel(tableModel);
        this.jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.jTable1.setDefaultEditor(Object.class, null);
        this.jTable1.setRowSelectionAllowed(true);
        this.jTable1.setColumnSelectionAllowed(false);
        this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(2);
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
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        s = new javax.swing.JLabel();
        cedulaLabel = new javax.swing.JLabel();
        cedulaTextField = new javax.swing.JTextField();
        cargoTextField = new javax.swing.JTextField();
        cargoLabel = new javax.swing.JLabel();
        cuentaBancariaTextField = new javax.swing.JTextField();
        cuentaBancariaLabel = new javax.swing.JLabel();
        departamentoTextField = new javax.swing.JTextField();
        departamentoLabel = new javax.swing.JLabel();
        bancoLabel = new javax.swing.JLabel();
        bancoTextField = new javax.swing.JTextField();
        estadoLabel = new javax.swing.JLabel();
        estadoTextField = new javax.swing.JTextField();
        sexoLabel = new javax.swing.JLabel();
        sexoTextiField = new javax.swing.JTextField();
        nombreEmpleado = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        s1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        asistenciasTabla = new javax.swing.JTable();
        s2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton4.setText("Volver");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LogoRRHH.PNG"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4)
                .addContainerGap(62, Short.MAX_VALUE))
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        s.setFont(new java.awt.Font("Tahoma", 1, 35)); // NOI18N
        s.setForeground(new java.awt.Color(38, 35, 36));
        s.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        s.setText("Observaciones");

        cedulaLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        cedulaLabel.setText("Cédula: ");

        cedulaTextField.setEnabled(false);

        cargoTextField.setEnabled(false);

        cargoLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        cargoLabel.setText("Cargo: ");

        cuentaBancariaTextField.setEnabled(false);

        cuentaBancariaLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        cuentaBancariaLabel.setText("Cuenta Bancaria: ");

        departamentoTextField.setEnabled(false);

        departamentoLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        departamentoLabel.setText("Departamento: ");

        bancoLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        bancoLabel.setText("Banco: ");

        bancoTextField.setEnabled(false);

        estadoLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        estadoLabel.setText("Estado: ");

        estadoTextField.setEnabled(false);

        sexoLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        sexoLabel.setText("Sexo: ");

        sexoTextiField.setEnabled(false);

        nombreEmpleado.setFont(new java.awt.Font("Tahoma", 1, 35)); // NOI18N
        nombreEmpleado.setForeground(new java.awt.Color(38, 35, 36));
        nombreEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreEmpleado.setText("Nombre");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabla);

        jButton1.setText("RegistrarAsistencia");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Registrar Salida");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        s1.setFont(new java.awt.Font("Tahoma", 1, 35)); // NOI18N
        s1.setForeground(new java.awt.Color(38, 35, 36));
        s1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        s1.setText("Roles de pago");

        asistenciasTabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(asistenciasTabla);

        s2.setFont(new java.awt.Font("Tahoma", 1, 35)); // NOI18N
        s2.setForeground(new java.awt.Color(38, 35, 36));
        s2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        s2.setText("Asistencias");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cuentaBancariaLabel)
                                .addComponent(cargoLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(departamentoLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(estadoLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(bancoLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(cedulaLabel)
                            .addComponent(sexoLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cedulaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sexoTextiField, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(estadoTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                .addComponent(bancoTextField)
                                .addComponent(cargoTextField)
                                .addComponent(departamentoTextField)
                                .addComponent(cuentaBancariaTextField))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(s1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(s))
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nombreEmpleado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(s2)
                .addGap(256, 256, 256))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreEmpleado)
                    .addComponent(s2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cedulaLabel)
                            .addComponent(cedulaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cargoLabel)
                            .addComponent(cargoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(departamentoLabel)
                            .addComponent(departamentoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cuentaBancariaLabel)
                            .addComponent(cuentaBancariaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bancoLabel)
                            .addComponent(bancoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(estadoLabel)
                            .addComponent(estadoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sexoLabel)
                            .addComponent(sexoTextiField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(s)
                    .addComponent(s1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.parentForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        this.empleado.notificarEntrada(this.parentForm.getControlAsistencias());
        JOptionPane.showMessageDialog(this, "El empleado ha registrado su asistencia correctamente");
        //Aqui se envia el empleado a la clase control disponibilidad de logistico
//        try {
//            ControlDisponibilidad control = ControlDisponibilidad.getInstance();
//            Conductor c = new Conductor();
//            c.setID(this.empleado.getId());
//            c.setEstado("Activo");
//            control.lc.aniadirConductor(c);
//        } catch (SQLException ex) {
//            //
//        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.empleado.notificarSalida(this.parentForm.getControlAsistencias());
        JOptionPane.showMessageDialog(this, "El empleado ha registrado su salida correctamente");
        //Aqui se retira el empleado a la clase control disponibilidad de logistico
//        try {
//            ControlDisponibilidad control = ControlDisponibilidad.getInstance();
//            Conductor c = new Conductor();
//            c.setID(this.empleado.getId());
//            control.lc.removerConductor(c);
//        } catch (SQLException ex) {
//            //
//        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(DetalleEmpleadoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetalleEmpleadoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetalleEmpleadoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetalleEmpleadoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetalleEmpleadoGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable asistenciasTabla;
    private javax.swing.JLabel bancoLabel;
    private javax.swing.JTextField bancoTextField;
    private javax.swing.JLabel cargoLabel;
    private javax.swing.JTextField cargoTextField;
    private javax.swing.JLabel cedulaLabel;
    private javax.swing.JTextField cedulaTextField;
    private javax.swing.JLabel cuentaBancariaLabel;
    private javax.swing.JTextField cuentaBancariaTextField;
    private javax.swing.JLabel departamentoLabel;
    private javax.swing.JTextField departamentoTextField;
    private javax.swing.JLabel estadoLabel;
    private javax.swing.JTextField estadoTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel nombreEmpleado;
    private javax.swing.JLabel s;
    private javax.swing.JLabel s1;
    private javax.swing.JLabel s2;
    private javax.swing.JLabel sexoLabel;
    private javax.swing.JTextField sexoTextiField;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
