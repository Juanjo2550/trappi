/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi;

import com.epn.trappi.gui.financiero.DashboardFinanciero;
import com.epn.trappi.gui.logistico.Logistico_GUI;
import com.epn.trappi.gui.proveedores.Principal;
import com.epn.trappi.gui.rrhh.PANTALLA_PRINCIPAL;
import com.epn.trappi.models.logistico.ControlDisponibilidad;
import com.epn.trappi.models.rrhh.juanjo.ControlAsistencias;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author David Morales
 */
public class Menu_Trappi extends javax.swing.JFrame {

    //NO TOCAR ESTO!!!!
    private ControlAsistencias controlAsistencias = new ControlAsistencias();
    private Logistico_GUI logistico;
    private PANTALLA_PRINCIPAL rrhh;
    ControlDisponibilidad controlDisponibilidad;

    /**
     * Creates new form Menu_Trappi
     */
    public Menu_Trappi() {
        initComponents();
        this.setTitle("Menu Principal Trappi");
        try {
            this.controlDisponibilidad = ControlDisponibilidad.getInstance();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        controlAsistencias.events.suscribe("nuevo_empleado", controlDisponibilidad);
        controlAsistencias.events.suscribe("salida_empleado", controlDisponibilidad);
        this.logistico = new Logistico_GUI(controlDisponibilidad, this);
        this.rrhh = new PANTALLA_PRINCIPAL(controlAsistencias, this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPEncabezado = new javax.swing.JPanel();
        jLabNombreContribuyente1 = new javax.swing.JLabel();
        jPMod = new javax.swing.JPanel();
        jtbCerrarSesion = new javax.swing.JButton();
        jbtLogístico = new javax.swing.JButton();
        jbtFinanciero = new javax.swing.JButton();
        jbtProveedores = new javax.swing.JButton();
        Recursosboton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPEncabezado.setBackground(new java.awt.Color(61, 57, 57));

        jLabNombreContribuyente1.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabNombreContribuyente1.setForeground(new java.awt.Color(240, 240, 241));
        jLabNombreContribuyente1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabNombreContribuyente1.setText("Trappi");

        javax.swing.GroupLayout jPEncabezadoLayout = new javax.swing.GroupLayout(jPEncabezado);
        jPEncabezado.setLayout(jPEncabezadoLayout);
        jPEncabezadoLayout.setHorizontalGroup(
            jPEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEncabezadoLayout.createSequentialGroup()
                .addGap(530, 530, 530)
                .addComponent(jLabNombreContribuyente1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addGap(540, 540, 540))
        );
        jPEncabezadoLayout.setVerticalGroup(
            jPEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPEncabezadoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabNombreContribuyente1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPMod.setBackground(new java.awt.Color(51, 51, 51));
        jPMod.setForeground(new java.awt.Color(51, 51, 51));
        jPMod.setMaximumSize(new java.awt.Dimension(300, 200));
        jPMod.setPreferredSize(new java.awt.Dimension(300, 280));

        jtbCerrarSesion.setBackground(new java.awt.Color(255, 210, 28));
        jtbCerrarSesion.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jtbCerrarSesion.setForeground(new java.awt.Color(51, 51, 51));
        jtbCerrarSesion.setText("Cerrar Sesión ");
        jtbCerrarSesion.setBorderPainted(false);
        jtbCerrarSesion.setFocusPainted(false);
        jtbCerrarSesion.setMaximumSize(new java.awt.Dimension(110, 50));
        jtbCerrarSesion.setMinimumSize(new java.awt.Dimension(110, 50));
        jtbCerrarSesion.setPreferredSize(new java.awt.Dimension(110, 50));
        jtbCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbCerrarSesionMouseClicked(evt);
            }
        });
        jtbCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbCerrarSesionActionPerformed(evt);
            }
        });

        jbtLogístico.setBackground(new java.awt.Color(255, 210, 28));
        jbtLogístico.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbtLogístico.setForeground(new java.awt.Color(51, 51, 51));
        jbtLogístico.setText("Logístico");
        jbtLogístico.setBorderPainted(false);
        jbtLogístico.setFocusPainted(false);
        jbtLogístico.setMaximumSize(new java.awt.Dimension(110, 50));
        jbtLogístico.setMinimumSize(new java.awt.Dimension(110, 50));
        jbtLogístico.setPreferredSize(new java.awt.Dimension(110, 50));
        jbtLogístico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtLogísticoActionPerformed(evt);
            }
        });

        jbtFinanciero.setBackground(new java.awt.Color(255, 210, 28));
        jbtFinanciero.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbtFinanciero.setForeground(new java.awt.Color(51, 51, 51));
        jbtFinanciero.setText("Financiero");
        jbtFinanciero.setBorderPainted(false);
        jbtFinanciero.setFocusPainted(false);
        jbtFinanciero.setMaximumSize(new java.awt.Dimension(110, 50));
        jbtFinanciero.setMinimumSize(new java.awt.Dimension(110, 50));
        jbtFinanciero.setPreferredSize(new java.awt.Dimension(110, 50));
        jbtFinanciero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtFinancieroActionPerformed(evt);
            }
        });

        jbtProveedores.setBackground(new java.awt.Color(255, 210, 28));
        jbtProveedores.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbtProveedores.setForeground(new java.awt.Color(51, 51, 51));
        jbtProveedores.setText("Proveedores");
        jbtProveedores.setBorderPainted(false);
        jbtProveedores.setFocusPainted(false);
        jbtProveedores.setMaximumSize(new java.awt.Dimension(110, 50));
        jbtProveedores.setMinimumSize(new java.awt.Dimension(110, 50));
        jbtProveedores.setPreferredSize(new java.awt.Dimension(110, 50));
        jbtProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtProveedoresMouseClicked(evt);
            }
        });
        jbtProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtProveedoresActionPerformed(evt);
            }
        });

        Recursosboton.setBackground(new java.awt.Color(255, 210, 28));
        Recursosboton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Recursosboton.setForeground(new java.awt.Color(51, 51, 51));
        Recursosboton.setText("RRHH");
        Recursosboton.setBorderPainted(false);
        Recursosboton.setFocusPainted(false);
        Recursosboton.setMaximumSize(new java.awt.Dimension(110, 50));
        Recursosboton.setMinimumSize(new java.awt.Dimension(110, 50));
        Recursosboton.setPreferredSize(new java.awt.Dimension(110, 50));
        Recursosboton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RecursosbotonMouseClicked(evt);
            }
        });
        Recursosboton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecursosbotonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Autores: GR1ISW-ISWR514, Escuela Politécnica Nacional 2020-B");

        javax.swing.GroupLayout jPModLayout = new javax.swing.GroupLayout(jPMod);
        jPMod.setLayout(jPModLayout);
        jPModLayout.setHorizontalGroup(
            jPModLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPModLayout.createSequentialGroup()
                .addGap(0, 525, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 310, Short.MAX_VALUE)
                .addComponent(jtbCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPModLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPModLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtFinanciero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Recursosboton, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPModLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtLogístico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPModLayout.setVerticalGroup(
            jPModLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPModLayout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addGroup(jPModLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtProveedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtFinanciero, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPModLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtLogístico, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Recursosboton, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
                .addGroup(jPModLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtbCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPEncabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPMod, javax.swing.GroupLayout.DEFAULT_SIZE, 1400, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPMod, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtLogísticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtLogísticoActionPerformed
            this.setVisible(false);
            logistico.setVisible(true);
    }//GEN-LAST:event_jbtLogísticoActionPerformed

    private void jbtFinancieroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtFinancieroActionPerformed
        DashboardFinanciero financiero = new DashboardFinanciero();
        financiero.setExtendedState(financiero.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        financiero.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jbtFinancieroActionPerformed

    private void RecursosbotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecursosbotonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RecursosbotonActionPerformed

    private void RecursosbotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RecursosbotonMouseClicked
//        PANTALLA_PRINCIPAL rrhh = new PANTALLA_PRINCIPAL(controlAsistencias, this);
//        rrhh.setExtendedState(rrhh.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        this.setVisible(false);
        rrhh.setVisible(true);
    }//GEN-LAST:event_RecursosbotonMouseClicked

    private void jbtProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtProveedoresActionPerformed

    }//GEN-LAST:event_jbtProveedoresActionPerformed

    private void jbtProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtProveedoresMouseClicked
        // TODO add your handling code here:
        try {
            Principal proveedores = new Principal();
            proveedores.setExtendedState(proveedores.getExtendedState() | JFrame.MAXIMIZED_BOTH);
            proveedores.setVisible(true);
            this.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(Menu_Trappi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtProveedoresMouseClicked

    private void jtbCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbCerrarSesionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbCerrarSesionActionPerformed

    private void jtbCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbCerrarSesionMouseClicked
        // TODO add your handling code here:
        Main_Trappi main = new Main_Trappi();
        main.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jtbCerrarSesionMouseClicked

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
            java.util.logging.Logger.getLogger(Menu_Trappi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Trappi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Trappi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Trappi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Trappi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Recursosboton;
    private javax.swing.JLabel jLabNombreContribuyente1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPEncabezado;
    private javax.swing.JPanel jPMod;
    private javax.swing.JButton jbtFinanciero;
    private javax.swing.JButton jbtLogístico;
    private javax.swing.JButton jbtProveedores;
    private javax.swing.JButton jtbCerrarSesion;
    // End of variables declaration//GEN-END:variables
}
