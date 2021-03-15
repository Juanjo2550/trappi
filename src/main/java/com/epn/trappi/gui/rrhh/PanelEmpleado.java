/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.rrhh;

import com.epn.trappi.db.rrhh.EmpleadoDb;
import com.epn.trappi.models.rrhh.juanjo.Conductores;
import com.epn.trappi.models.rrhh.juanjo.ControlAsistencias;
import com.epn.trappi.models.rrhh.juanjo.Empleado;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juan Jaramillo <juanjodev02 at juan.jaramillo02@epn.edu.ec>
 */
public class PanelEmpleado extends javax.swing.JPanel {
    private EmpleadoDb empleados;
    public ContratacionPrincipal parent;
    
    ControlAsistencias controlAsistencias;
    /**
     * Creates new form PanelEmpleado
     */
    public PanelEmpleado(ContratacionPrincipal parentFrame) {
        this.controlAsistencias = new ControlAsistencias();
        initComponents();
        this.empleados = new EmpleadoDb();
        this.parent = parentFrame;
        fillTable();
    }
    
    
    public final void fillTable() {
        String col [] = {
            "Cedula",
            "Nombres",
            "Apellidos",
            "Cargo",
            "Departamento",
            "Tipo",
            "Banco",
            "Sueldo",
            "Estado",
            "Sexo"
        };
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        for(Empleado empleado : this.empleados.obtenerTodos()) {
            String tipo = "";
            if (empleado instanceof Conductores) {
                tipo = "Conductor";
            } else {
                tipo = "Administrativo";
            }
            
            Object [] row = {
                empleado.getCedula(),
                empleado.getNombres(),
                empleado.getApellidos(),
                empleado.getCargo(),
                empleado.getDepartamento(),
                tipo,
                empleado.getBanco(),
                empleado.getSueldo(),
                empleado.getEstado(),
                empleado.getSexo()
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 35)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(38, 35, 36));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Lista de Empleados");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1002, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tablaEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEmpleadosMouseClicked
        // TODO add your handling code here:
        int row = tablaEmpleados.getSelectedRow();
        String cedula = tablaEmpleados.getValueAt(row, 0).toString();
        DetalleEmpleadoGUI detalleGUI = new DetalleEmpleadoGUI(cedula, this.parent);
        detalleGUI.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_tablaEmpleadosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEmpleados;
    // End of variables declaration//GEN-END:variables
}
