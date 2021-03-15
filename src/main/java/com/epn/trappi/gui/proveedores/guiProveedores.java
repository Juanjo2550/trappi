/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.proveedores;

import com.epn.trappi.models.proveedores.Proveedor;
import javax.swing.JOptionPane;

/**
 *
 * @author Peterca
 */
public class guiProveedores extends javax.swing.JPanel {

    /**
     * Creates new form guiProveedores
     */
    public guiProveedores() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelVerTodos = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtRUC = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtRazonSocial = new javax.swing.JTextField();
        txtNCuenta = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btnRegistrarProveedor = new javax.swing.JButton();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        PanelVerTodos.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("RUC:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Razón Social:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Dirección:");

        txtRUC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRUCActionPerformed(evt);
            }
        });
        txtRUC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRUCKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRUCKeyTyped(evt);
            }
        });

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDireccionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });

        txtRazonSocial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRazonSocialKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRazonSocialKeyTyped(evt);
            }
        });

        txtNCuenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNCuentaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNCuentaKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("Número de Cuenta:");

        btnRegistrarProveedor.setBackground(new java.awt.Color(38, 112, 171));
        btnRegistrarProveedor.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnRegistrarProveedor.setForeground(new java.awt.Color(240, 240, 241));
        btnRegistrarProveedor.setBorderPainted(false);
        btnRegistrarProveedor.setLabel("Registrar");
        btnRegistrarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelVerTodosLayout = new javax.swing.GroupLayout(PanelVerTodos);
        PanelVerTodos.setLayout(PanelVerTodosLayout);
        PanelVerTodosLayout.setHorizontalGroup(
            PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelVerTodosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRUC)
                    .addComponent(txtRazonSocial)
                    .addComponent(txtDireccion)
                    .addGroup(PanelVerTodosLayout.createSequentialGroup()
                        .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtNCuenta)
                    .addGroup(PanelVerTodosLayout.createSequentialGroup()
                        .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(btnRegistrarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 205, Short.MAX_VALUE))))
        );
        PanelVerTodosLayout.setVerticalGroup(
            PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelVerTodosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(6, 6, 6)
                .addComponent(txtRUC, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(6, 6, 6)
                .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(6, 6, 6)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtNCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegistrarProveedor)
                .addGap(155, 155, 155))
        );

        add(PanelVerTodos);
    }// </editor-fold>//GEN-END:initComponents

    private void txtRUCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRUCActionPerformed
    
    }//GEN-LAST:event_txtRUCActionPerformed

    private void txtRUCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRUCKeyPressed

    }//GEN-LAST:event_txtRUCKeyPressed

    private void txtRUCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRUCKeyTyped

    }//GEN-LAST:event_txtRUCKeyTyped

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed

    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtDireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyPressed

    }//GEN-LAST:event_txtDireccionKeyPressed

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped

    }//GEN-LAST:event_txtDireccionKeyTyped

    private void txtRazonSocialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazonSocialKeyPressed

    }//GEN-LAST:event_txtRazonSocialKeyPressed

    private void txtRazonSocialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazonSocialKeyTyped

    }//GEN-LAST:event_txtRazonSocialKeyTyped

    private void txtNCuentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNCuentaKeyPressed

    }//GEN-LAST:event_txtNCuentaKeyPressed

    private void txtNCuentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNCuentaKeyTyped

    }//GEN-LAST:event_txtNCuentaKeyTyped

    private void btnRegistrarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarProveedorActionPerformed
        // Atributos
        String ruc = txtRUC.getText();
        String razonSocial = txtRazonSocial.getText();
        String direccion = txtDireccion.getText();
        String n_Cuenta = txtNCuenta.getText();

        // Registro
        if (validarRazonSocial(razonSocial)) {
            try {
                if (validarDireccion(direccion)) {
                    new Proveedor(ruc, razonSocial, direccion, n_Cuenta).registrarProveedor();
                    JOptionPane.showMessageDialog(null, "Proveedor registrado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    txtRUC.setText("");
                    txtRazonSocial.setText("");
                    txtDireccion.setText("");
                    txtNCuenta.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Dirección Incorrecta", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Razon Social Incorrecta.", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarProveedorActionPerformed

    public static boolean validarRazonSocial(String razonSocial) {
        if (razonSocial.length() > 50 || razonSocial.trim().equals("")) {
            return false;
        }
        return razonSocial.matches("[ñÑÁÉÍÓÚáéíóúA-Za-z]+[[ ][ñÑÁÉÍÓÚáéíóúA-Za-z]+]*");
    }

    public static boolean validarDireccion(String direccion) {
        if (direccion.length() > 50 || direccion.trim().equals("")) {
            return false;
        }
        return direccion.matches("[[0-9]*[ ]]*[A-Za-zñÑÁÉÍÓÚáéíóú]+[0-9]*[[ ][A-Za-zñÑÁÉÍÓÚáéíóú]+[0-9]*]*");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelVerTodos;
    private javax.swing.JButton btnRegistrarProveedor;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNCuenta;
    private javax.swing.JTextField txtRUC;
    private javax.swing.JTextField txtRazonSocial;
    // End of variables declaration//GEN-END:variables
}
