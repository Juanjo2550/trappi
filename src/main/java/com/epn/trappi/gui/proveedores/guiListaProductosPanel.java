/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.proveedores;

import com.epn.trappi.db.proveedores.ProveedoresDb;
import com.epn.trappi.models.proveedores.ListaProveedores;
import com.epn.trappi.models.proveedores.Producto;
import com.epn.trappi.models.proveedores.Proveedor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Peterca
 */
public class guiListaProductosPanel extends javax.swing.JPanel {

    DefaultTableModel modelo;
    private final ProveedoresDb db = new ProveedoresDb();
    public ArrayList seleccionados = new ArrayList();

    ListaProveedores listaProveedores = new ListaProveedores();

    /**
     * Creates new form guiListaProductosPanel
     */
    public guiListaProductosPanel() {
        initComponents();
        seleccionados = (ArrayList) db.getProductos();
        cargarProductos();
        cargarProveedor();
    }

    private void cargarProveedor() {
        listaProveedores.getListaDeProveedores().forEach(prov -> {
            cmbProveedores.addItem(prov.getRazonSocial());
        });
    }

    private void cargarProductos() {
        String[] titulos = {"Nombre Producto", "Precio unitario", "Proveedor"};
        String[] fila = new String[3];
        modelo = new DefaultTableModel(null, titulos);
        //Aquí cambie algo para que sirva, puse este iterador y luego castee la clase producto
        for (Iterator it = seleccionados.iterator(); it.hasNext();) {
            Producto producto = (Producto) it.next();
            fila[0] = producto.getNombre();
            fila[1] = "" + producto.getPrecio();
            fila[2] = "" + producto.getProveeedor().getRazonSocial();
            modelo.addRow(fila);
        }
        jtbProductos.setModel(modelo);
    }

    private void mostrarProducto(String nombre, String precio, String proveedor) {
        txtNombre.setText(nombre);
        txtPrecio.setText(precio);
        cmbProveedores.setSelectedItem(proveedor);
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
        txtNombreProducto = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbProductos = new javax.swing.JTable();
        cmbProveedores = new javax.swing.JComboBox<>();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        PanelVerTodos.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Nombre del producto:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Nombre:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Precio:");

        txtNombreProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreProductoKeyTyped(evt);
            }
        });

        txtPrecio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("Proveedor:");

        btnActualizar.setBackground(new java.awt.Color(38, 112, 171));
        btnActualizar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(240, 240, 241));
        btnActualizar.setText("Actualizar");
        btnActualizar.setBorderPainted(false);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(38, 112, 171));
        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(240, 240, 241));
        btnBuscar.setBorderPainted(false);
        btnBuscar.setLabel("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jtbProductos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtbProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre del Producto", "Precio", "Proveedor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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

        cmbProveedores.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cmbProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProveedoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelVerTodosLayout = new javax.swing.GroupLayout(PanelVerTodos);
        PanelVerTodos.setLayout(PanelVerTodosLayout);
        PanelVerTodosLayout.setHorizontalGroup(
            PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelVerTodosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre)
                    .addComponent(txtPrecio)
                    .addGroup(PanelVerTodosLayout.createSequentialGroup()
                        .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel13)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelVerTodosLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(112, 112, 112))
                    .addGroup(PanelVerTodosLayout.createSequentialGroup()
                        .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cmbProveedores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        PanelVerTodosLayout.setVerticalGroup(
            PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelVerTodosLayout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(9, 9, 9)
                .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addGap(6, 6, 6)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(6, 6, 6)
                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(cmbProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnActualizar)
                .addContainerGap())
        );

        add(PanelVerTodos);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void txtPrecioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyPressed

    }//GEN-LAST:event_txtPrecioKeyPressed

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped

    }//GEN-LAST:event_txtPrecioKeyTyped

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed

    }//GEN-LAST:event_txtNombreKeyPressed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped

    }//GEN-LAST:event_txtNombreKeyTyped

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        String nombre = txtNombre.getText();
        String precio = txtPrecio.getText();

        try {
            if (nombre.length() >= 1) {
                if (Double.parseDouble(precio) >= 0) {
                    Proveedor proveedor;
                    proveedor = db.obtenerProveedorRuc((String) cmbProveedores.getSelectedItem());
                    db.actualizarBien(db.getIdBien(nombre), nombre, Double.parseDouble(precio), proveedor.getRuc());
                    JOptionPane.showMessageDialog(null, "Producto Actualizado", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    
                    seleccionados = (ArrayList) db.getProductos();
                    cargarProductos();

                    txtNombre.setText("");
                    txtPrecio.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Precio Incorrecto", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Nombre Incorrecto", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error no se pudo Actualizar el Producto", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String producto = txtNombreProducto.getText();
        try {
            if (producto.length() >= 1) {
                seleccionados = (ArrayList) db.buscarProductos(producto);
                cargarProductos();
            } else {
                cargarProductos();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Proveedor no encontrado", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jtbProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbProductosMouseClicked
        int row = jtbProductos.rowAtPoint(evt.getPoint());
        int col = jtbProductos.columnAtPoint(evt.getPoint());
        if (row >= 0 && col >= 0) {
            mostrarProducto(modelo.getValueAt(row, 0).toString(), modelo.getValueAt(row, 1).toString(), modelo.getValueAt(row, 2).toString());
        }
    }//GEN-LAST:event_jtbProductosMouseClicked

    private void txtNombreProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProductoKeyTyped
        // TODO add your handling code here:
        String producto = txtNombreProducto.getText();
        try {
            if (producto.length() >= 1) {
                seleccionados = (ArrayList) db.buscarProductos(producto);
                cargarProductos();
            } else {
                cargarProductos();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Proveedor no encontrado", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_txtNombreProductoKeyTyped

    private void cmbProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProveedoresActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cmbProveedoresActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelVerTodos;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> cmbProveedores;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbProductos;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}