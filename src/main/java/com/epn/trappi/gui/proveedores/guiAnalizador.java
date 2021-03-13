/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.proveedores;

import com.epn.trappi.models.proveedores.AnalizadorDeInventario;
import com.epn.trappi.models.proveedores.Bien;
import com.epn.trappi.models.proveedores.Inventario;
import com.epn.trappi.models.proveedores.ListaDeCompras;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author CRISTIAN
 */
public class guiAnalizador extends javax.swing.JPanel {

    private Inventario inventario;
    private AnalizadorDeInventario analizador;
/**
     * Creates new form guiAnalizador
     */
    private JPanel verTodo;
    private ListaDeCompras solicitud;
    
    public guiAnalizador(JPanel verTodo) throws IOException {
        initComponents();
        this.inventario = new Inventario();
        this.analizador = new AnalizadorDeInventario();
        this.verTodo=verTodo;
        analizador.mostrarGrafica(jPanel1);
        this.solicitud=analizador.analizarStock();
        if(solicitud.getCompras().size()==0){
            btnNuevo7.setEnabled(false);
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

        jPanel1 = new javax.swing.JPanel();
        btnNuevo7 = new javax.swing.JButton();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        btnNuevo7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNuevo7.setText("Generar solicitud de compra");
        btnNuevo7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(324, Short.MAX_VALUE)
                .addComponent(btnNuevo7)
                .addGap(66, 66, 66))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(219, Short.MAX_VALUE)
                .addComponent(btnNuevo7)
                .addGap(56, 56, 56))
        );

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevo7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo7ActionPerformed
        // TODO add your handling code here:
       new CambiaPanel(verTodo, new guiDescripcionCompra(solicitud));
    }//GEN-LAST:event_btnNuevo7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNuevo7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
