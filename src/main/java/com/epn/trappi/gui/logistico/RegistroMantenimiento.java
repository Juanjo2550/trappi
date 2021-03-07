/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.logistico;

import com.epn.trappi.models.logistico.ListaMantenimientos;
import com.epn.trappi.models.logistico.servicios.Consultable;
import com.epn.trappi.models.logistico.servicios.ServicioDbMantenimiento;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alexander
 */
public class RegistroMantenimiento extends javax.swing.JPanel {

    ListaMantenimientos lista;
    public RegistroMantenimiento() {
        initComponents();
        lista = new ListaMantenimientos();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        campoMatricula = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMantenimientos = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Historial de mantenimientos");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(61, 57, 57), 1, true));
        jPanel2.setForeground(new java.awt.Color(61, 57, 57));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(61, 57, 57));
        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel7.setForeground(new java.awt.Color(61, 57, 57));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Búsqueda");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Filtros de búsqueda");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(61, 57, 57));
        jLabel14.setText("Matricula del vehículo:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 160, 30));

        campoMatricula.setFont(new java.awt.Font("Segoe UI Semibold", 2, 14)); // NOI18N
        campoMatricula.setForeground(new java.awt.Color(153, 153, 153));
        campoMatricula.setText("Ingrese la matrícula del vehiculo");
        campoMatricula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoMatriculaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                campoMatriculaMouseExited(evt);
            }
        });
        campoMatricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoMatriculaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoMatriculaKeyReleased(evt);
            }
        });
        jPanel2.add(campoMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 370, 30));

        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 63, 290, 30));

        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(96, 97, 101));

        tablaMantenimientos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 239, 239)));
        tablaMantenimientos.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        tablaMantenimientos.setForeground(new java.awt.Color(96, 97, 101));
        tablaMantenimientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", "", null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaMantenimientos.setGridColor(new java.awt.Color(239, 239, 239));
        tablaMantenimientos.setIntercellSpacing(new java.awt.Dimension(10, 4));
        tablaMantenimientos.setRowHeight(30);
        tablaMantenimientos.setSelectionBackground(new java.awt.Color(239, 239, 239));
        jScrollPane1.setViewportView(tablaMantenimientos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(426, 426, 426))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void campoMatriculaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoMatriculaMouseClicked
        campoMatricula.setText("");
        campoMatricula.setForeground(new Color(0,0,0));
        campoMatricula.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
    }//GEN-LAST:event_campoMatriculaMouseClicked

    private void campoMatriculaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoMatriculaMouseExited
        if (campoMatricula.getText().length()==0){
            campoMatricula.setForeground(new Color(153,153,153));
            campoMatricula.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 14));
            campoMatricula.setText("Ingrese la matrícula del vehiculo");
        }
    }//GEN-LAST:event_campoMatriculaMouseExited

    private void campoMatriculaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoMatriculaKeyPressed

    }//GEN-LAST:event_campoMatriculaKeyPressed

    private void campoMatriculaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoMatriculaKeyReleased

    }//GEN-LAST:event_campoMatriculaKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String matricula = campoMatricula.getText();
        try {
            Consultable consultable = new ServicioDbMantenimiento().obtenerElementosPorFiltro(ServicioDbMantenimiento.MATRICULA, matricula);
            lista.setMantenimientos(consultable.getDatos());
            DefaultTableModel modelo = lista.mostrarLista();
            tablaMantenimientos.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(RegistroMantenimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoMatricula;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaMantenimientos;
    // End of variables declaration//GEN-END:variables
}
