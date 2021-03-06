/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.proveedores;

import com.epn.trappi.models.proveedores.Bien;
import com.epn.trappi.models.proveedores.Inventario;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Peterca
 */
public class guiInventarioPanel extends javax.swing.JPanel {

    DefaultTableModel modelo;
    private Inventario inventario;

    /**
     * Creates new form guiListaProductosPanel
     */
    public guiInventarioPanel() throws IOException {
        this.inventario = new Inventario();
        initComponents();
        cargarInventario();
    }

    public void cargarInventario() {
        String[] titulos = {"Nombre Producto", "Marca","Precio unitario", "Proveedor", "Cantidad"};
        String[] fila = new String[5];
        modelo = new DefaultTableModel(null, titulos);
        for (Bien cantBien : inventario.getListaDeBienes().getListaBienes()) {
            fila[0] = cantBien.getNombre();
            fila[1] = "" + cantBien.getMarca();
            fila[2] = "" + cantBien.getPrecio();
            fila[3] = "" + cantBien.getProveeedor().getRazonSocial();
            fila[4] = "" + cantBien.getCantidad();
            modelo.addRow(fila);
        }
        jtbProductos.setModel(modelo);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbProductos = new javax.swing.JTable();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        PanelVerTodos.setBackground(new java.awt.Color(255, 255, 255));

        jtbProductos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtbProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre del prodcuto", "Precio", "Proveedor", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbProductos);

        javax.swing.GroupLayout PanelVerTodosLayout = new javax.swing.GroupLayout(PanelVerTodos);
        PanelVerTodos.setLayout(PanelVerTodosLayout);
        PanelVerTodosLayout.setHorizontalGroup(
            PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelVerTodosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelVerTodosLayout.setVerticalGroup(
            PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelVerTodosLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        add(PanelVerTodos);
    }// </editor-fold>//GEN-END:initComponents

    private void jtbProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbProductosMouseClicked

    }//GEN-LAST:event_jtbProductosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelVerTodos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbProductos;
    // End of variables declaration//GEN-END:variables
}
