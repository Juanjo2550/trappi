/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.proveedores;

import com.epn.trappi.db.proveedores.ProveedoresDb;
import com.epn.trappi.models.proveedores.ListaDeCompras;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Peterca
 */
public class guiComprasPanel extends javax.swing.JPanel {

    /**
     * Creates new form guiComprasPanel
     */
    DefaultTableModel modelo;
    private final ProveedoresDb db = new ProveedoresDb();

    private ListaDeCompras compras = new ListaDeCompras();
    ArrayList<String[]> listaCompras = new ArrayList<>();

    public guiComprasPanel() throws IOException {
        initComponents();
        jComboBox1.setSelectedIndex(2);
        jComboBox1.setEnabled(false);
        //compras = db.getCompras();

        try {
            listaCompras = db.obtenerCompras();
            compras.mostrarListaConDescripcion(jTable1, listaCompras);
        } catch (SQLException ex) {
            Logger.getLogger(guiComprasPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextFechCompNotaCred = new javax.swing.JTextField();
        jButRegFactCompNotaCred = new javax.swing.JButton();
        jIVA = new javax.swing.JLabel();
        jValor = new javax.swing.JLabel();
        jButRegFactCompNotaCred1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        PanelVerTodos.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Buscar Compra");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Compras");

        jTextFechCompNotaCred.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFechCompNotaCredActionPerformed(evt);
            }
        });
        jTextFechCompNotaCred.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFechCompNotaCredKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFechCompNotaCredKeyTyped(evt);
            }
        });

        jButRegFactCompNotaCred.setBackground(new java.awt.Color(38, 112, 171));
        jButRegFactCompNotaCred.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButRegFactCompNotaCred.setForeground(new java.awt.Color(240, 240, 241));
        jButRegFactCompNotaCred.setText("Actualizar estado");
        jButRegFactCompNotaCred.setBorderPainted(false);
        jButRegFactCompNotaCred.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButRegFactCompNotaCredActionPerformed(evt);
            }
        });

        jIVA.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jValor.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jButRegFactCompNotaCred1.setBackground(new java.awt.Color(38, 112, 171));
        jButRegFactCompNotaCred1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButRegFactCompNotaCred1.setForeground(new java.awt.Color(240, 240, 241));
        jButRegFactCompNotaCred1.setText("Buscar");
        jButRegFactCompNotaCred1.setBorderPainted(false);
        jButRegFactCompNotaCred1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButRegFactCompNotaCred1ActionPerformed(evt);
            }
        });

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Estado");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Detalle de Compra");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Entregado", "Pendiente", " " }));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 902, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel11))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(jLabel10)))
                        .addGap(68, 68, 68)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 61, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelVerTodosLayout = new javax.swing.GroupLayout(PanelVerTodos);
        PanelVerTodos.setLayout(PanelVerTodosLayout);
        PanelVerTodosLayout.setHorizontalGroup(
            PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelVerTodosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelVerTodosLayout.createSequentialGroup()
                        .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(PanelVerTodosLayout.createSequentialGroup()
                                .addComponent(jTextFechCompNotaCred, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(jButRegFactCompNotaCred1)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelVerTodosLayout.createSequentialGroup()
                        .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jButRegFactCompNotaCred, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelVerTodosLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jValor, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        PanelVerTodosLayout.setVerticalGroup(
            PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelVerTodosLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel8)
                .addGap(8, 8, 8)
                .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFechCompNotaCred, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButRegFactCompNotaCred1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelVerTodosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jValor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))
                    .addGroup(PanelVerTodosLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jButRegFactCompNotaCred)
                .addGap(23, 23, 23))
        );

        add(PanelVerTodos);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFechCompNotaCredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFechCompNotaCredActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFechCompNotaCredActionPerformed

    private void jTextFechCompNotaCredKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFechCompNotaCredKeyPressed

    }//GEN-LAST:event_jTextFechCompNotaCredKeyPressed

    private void jTextFechCompNotaCredKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFechCompNotaCredKeyTyped

    }//GEN-LAST:event_jTextFechCompNotaCredKeyTyped

    private void jButRegFactCompNotaCred1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButRegFactCompNotaCred1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButRegFactCompNotaCred1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int id = Integer.parseInt(jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0).toString());
        String estado = jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 2).toString();
        String monto = jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 3).toString();
        String fecha = jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 1).toString();

        //int identificador, String estado, String monto, String fecha
        compras.getCompra(id, estado, monto, fecha);
        if (estado.equalsIgnoreCase("Entregado")) {
            jComboBox1.setSelectedIndex(0);
            jComboBox1.setEnabled(false);
        } else {
            jComboBox1.setSelectedIndex(1);
            jComboBox1.setEnabled(true);
        }
        compras.mostrarLista(jTable2);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButRegFactCompNotaCredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButRegFactCompNotaCredActionPerformed
        if (compras.obtenerCompra(Integer.parseInt(jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0).toString())).cambiarEstado()) {
            JOptionPane.showMessageDialog(null, "Compra Actualizada");
            compras.mostrarListaConDescripcion(jTable1, listaCompras);
        } else {
            JOptionPane.showMessageDialog(null, "La compra no ha podido ser actualizada");
        }
    }//GEN-LAST:event_jButRegFactCompNotaCredActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelVerTodos;
    private javax.swing.JButton jButRegFactCompNotaCred;
    private javax.swing.JButton jButRegFactCompNotaCred1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jIVA;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextFechCompNotaCred;
    private javax.swing.JLabel jValor;
    // End of variables declaration//GEN-END:variables
}
