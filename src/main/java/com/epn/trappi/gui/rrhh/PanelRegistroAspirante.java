/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.rrhh;

import com.epn.trappi.db.rrhh.AspiranteDb;
import com.epn.trappi.db.rrhh.ModelDb;
import com.epn.trappi.db.rrhh.PruebaAdmisionDb;
import com.epn.trappi.models.rrhh.contratacion.Aspirante;
import com.epn.trappi.models.rrhh.contratacion.PruebaAdmision;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class PanelRegistroAspirante extends javax.swing.JPanel {

    private void listarAspirantes(){
        ModelDb listaAspirantes =  new AspiranteDb();
        Aspirante[] aspirantes = (Aspirante[]) listaAspirantes.obtenerTodos();
        PruebaAdmisionDb listaPruebas = new PruebaAdmisionDb();
        DefaultTableModel model = (DefaultTableModel) jTableAspirantes.getModel();
        model.setRowCount(0);
        
        for (Aspirante asp: aspirantes){
            Vector v = new Vector();
            PruebaAdmision prueba = new PruebaAdmision();
            prueba = listaPruebas.buscarUno(asp.getCedula());
            if (prueba != null){
                v.add(asp.getNombre());
                v.add(asp.getApellidos());
                v.add(asp.getTelefono());
                v.add(asp.getCedula());
                v.add(asp.getCargoAspirante());
                v.add(prueba.getAptitudes());
                v.add(prueba.getActitudes());
                v.add(prueba.getPuntaje());
                model.addRow(v); 
            } else {
                continue;
            }
            
            jTableAspirantes.setModel(model);
        }
    }
    public PanelRegistroAspirante() {
        initComponents();
        jTextActitudesAspirante.setEnabled(false);
        jTextCedulaAspirante.setEnabled(false);
        jTextCargoAspirante.setEnabled(false);
        jTextNombreAspirante.setEnabled(false);
        jTextPuntajeAspirante.setEnabled(false);
        jTextTelefonoAspirante.setEnabled(false);
        jTextApellidoAspirante.setEnabled(false);
        jTextAptitudesAspirante.setEnabled(false);
        jButGuardarAspirante.setEnabled(false);
        listarAspirantes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelAspirante = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jTextNombreAspirante = new javax.swing.JTextField();
        jButGuardarAspirante = new javax.swing.JButton();
        jButRegCliente2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextCedulaAspirante = new javax.swing.JTextField();
        jTextApellidoAspirante = new javax.swing.JTextField();
        jTextTelefonoAspirante = new javax.swing.JTextField();
        jTextPuntajeAspirante = new javax.swing.JTextField();
        jTextActitudesAspirante = new javax.swing.JTextField();
        jTextAptitudesAspirante = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAspirantes = new javax.swing.JTable();
        jTextCargoAspirante = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();

        PanelAspirante.setBackground(new java.awt.Color(255, 255, 255));
        PanelAspirante.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Nombre:");
        PanelAspirante.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 65, -1, -1));

        jTextNombreAspirante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNombreAspiranteActionPerformed(evt);
            }
        });
        jTextNombreAspirante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextNombreAspiranteKeyTyped(evt);
            }
        });
        PanelAspirante.add(jTextNombreAspirante, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 342, 28));

        jButGuardarAspirante.setBackground(new java.awt.Color(0, 153, 153));
        jButGuardarAspirante.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButGuardarAspirante.setForeground(new java.awt.Color(240, 240, 241));
        jButGuardarAspirante.setText("Guardar");
        jButGuardarAspirante.setBorderPainted(false);
        jButGuardarAspirante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButGuardarAspiranteActionPerformed(evt);
            }
        });
        PanelAspirante.add(jButGuardarAspirante, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 11, -1, -1));

        jButRegCliente2.setBackground(new java.awt.Color(38, 112, 171));
        jButRegCliente2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButRegCliente2.setForeground(new java.awt.Color(240, 240, 241));
        jButRegCliente2.setText("Nuevo");
        jButRegCliente2.setBorderPainted(false);
        jButRegCliente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButRegCliente2ActionPerformed(evt);
            }
        });
        PanelAspirante.add(jButRegCliente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 99, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Apellidos:");
        PanelAspirante.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 104, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Teléfono:");
        PanelAspirante.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 139, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Cédula:");
        PanelAspirante.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Puntaje:");
        PanelAspirante.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Actitudes:");
        PanelAspirante.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Aptitudes:");
        PanelAspirante.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, -1, -1));

        jTextCedulaAspirante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCedulaAspiranteActionPerformed(evt);
            }
        });
        jTextCedulaAspirante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextCedulaAspiranteKeyTyped(evt);
            }
        });
        PanelAspirante.add(jTextCedulaAspirante, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 140, 28));

        jTextApellidoAspirante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextApellidoAspiranteActionPerformed(evt);
            }
        });
        jTextApellidoAspirante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextApellidoAspiranteKeyTyped(evt);
            }
        });
        PanelAspirante.add(jTextApellidoAspirante, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 100, 342, 28));

        jTextTelefonoAspirante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextTelefonoAspiranteActionPerformed(evt);
            }
        });
        jTextTelefonoAspirante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextTelefonoAspiranteKeyTyped(evt);
            }
        });
        PanelAspirante.add(jTextTelefonoAspirante, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 130, 28));

        jTextPuntajeAspirante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextPuntajeAspiranteActionPerformed(evt);
            }
        });
        jTextPuntajeAspirante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextPuntajeAspiranteKeyTyped(evt);
            }
        });
        PanelAspirante.add(jTextPuntajeAspirante, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, 190, 28));

        jTextActitudesAspirante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextActitudesAspiranteActionPerformed(evt);
            }
        });
        jTextActitudesAspirante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextActitudesAspiranteKeyTyped(evt);
            }
        });
        PanelAspirante.add(jTextActitudesAspirante, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 440, 28));

        jTextAptitudesAspirante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextAptitudesAspiranteActionPerformed(evt);
            }
        });
        jTextAptitudesAspirante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextAptitudesAspiranteKeyTyped(evt);
            }
        });
        PanelAspirante.add(jTextAptitudesAspirante, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 440, 28));

        jTableAspirantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellidos", "Teléfono", "Cédula", "Cargo", "Aptitudes", "Actitudes", "Puntaje"
            }
        ));
        jScrollPane1.setViewportView(jTableAspirantes);

        PanelAspirante.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 950, 440));

        jTextCargoAspirante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCargoAspiranteActionPerformed(evt);
            }
        });
        jTextCargoAspirante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextCargoAspiranteKeyTyped(evt);
            }
        });
        PanelAspirante.add(jTextCargoAspirante, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 140, 170, 28));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Cargo:");
        PanelAspirante.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 140, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1012, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(PanelAspirante, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 743, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(PanelAspirante, javax.swing.GroupLayout.PREFERRED_SIZE, 731, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextNombreAspiranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNombreAspiranteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNombreAspiranteActionPerformed

    private void jTextNombreAspiranteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNombreAspiranteKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextNombreAspiranteKeyTyped

    private void jButGuardarAspiranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButGuardarAspiranteActionPerformed
        Aspirante aspirante = new Aspirante(jTextNombreAspirante.getText(), jTextApellidoAspirante.getText(), jTextCedulaAspirante.getText(),
            jTextTelefonoAspirante.getText(), jTextCargoAspirante.getText());
        PruebaAdmision prueba = new PruebaAdmision(Integer.parseInt(jTextPuntajeAspirante.getText()), jTextActitudesAspirante.getText(), jTextAptitudesAspirante.getText());
        aspirante.registrar();
        prueba.registrar(jTextCedulaAspirante.getText());
        listarAspirantes();
        JOptionPane.showMessageDialog(null, "Aspirante registrado con éxito");
    }//GEN-LAST:event_jButGuardarAspiranteActionPerformed

    private void jButRegCliente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButRegCliente2ActionPerformed
        jTextActitudesAspirante.setEnabled(true);
        jTextCedulaAspirante.setEnabled(true);
        jTextCargoAspirante.setEnabled(true);
        jTextNombreAspirante.setEnabled(true);
        jTextPuntajeAspirante.setEnabled(true);
        jTextTelefonoAspirante.setEnabled(true);
        jTextApellidoAspirante.setEnabled(true);
        jTextAptitudesAspirante.setEnabled(true);
        jButGuardarAspirante.setEnabled(true);
    }//GEN-LAST:event_jButRegCliente2ActionPerformed

    private void jTextCedulaAspiranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCedulaAspiranteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCedulaAspiranteActionPerformed

    private void jTextCedulaAspiranteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCedulaAspiranteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCedulaAspiranteKeyTyped

    private void jTextApellidoAspiranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextApellidoAspiranteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextApellidoAspiranteActionPerformed

    private void jTextApellidoAspiranteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextApellidoAspiranteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextApellidoAspiranteKeyTyped

    private void jTextTelefonoAspiranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextTelefonoAspiranteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTelefonoAspiranteActionPerformed

    private void jTextTelefonoAspiranteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextTelefonoAspiranteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTelefonoAspiranteKeyTyped

    private void jTextPuntajeAspiranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextPuntajeAspiranteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextPuntajeAspiranteActionPerformed

    private void jTextPuntajeAspiranteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPuntajeAspiranteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextPuntajeAspiranteKeyTyped

    private void jTextActitudesAspiranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextActitudesAspiranteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextActitudesAspiranteActionPerformed

    private void jTextActitudesAspiranteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextActitudesAspiranteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextActitudesAspiranteKeyTyped

    private void jTextAptitudesAspiranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextAptitudesAspiranteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextAptitudesAspiranteActionPerformed

    private void jTextAptitudesAspiranteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextAptitudesAspiranteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextAptitudesAspiranteKeyTyped

    private void jTextCargoAspiranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCargoAspiranteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCargoAspiranteActionPerformed

    private void jTextCargoAspiranteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCargoAspiranteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCargoAspiranteKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelAspirante;
    private javax.swing.JButton jButGuardarAspirante;
    private javax.swing.JButton jButRegCliente2;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAspirantes;
    private javax.swing.JTextField jTextActitudesAspirante;
    private javax.swing.JTextField jTextApellidoAspirante;
    private javax.swing.JTextField jTextAptitudesAspirante;
    private javax.swing.JTextField jTextCargoAspirante;
    private javax.swing.JTextField jTextCedulaAspirante;
    private javax.swing.JTextField jTextNombreAspirante;
    private javax.swing.JTextField jTextPuntajeAspirante;
    private javax.swing.JTextField jTextTelefonoAspirante;
    // End of variables declaration//GEN-END:variables
}