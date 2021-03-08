
package com.epn.trappi.gui.logistico;
import com.epn.trappi.controladores.logistico.storedProcedures;
import com.epn.trappi.models.logistico.ControlDisponibilidad;
import com.epn.trappi.models.logistico.ListaVehiculos;
import com.epn.trappi.models.logistico.servicios.ServicioDb;
import com.epn.trappi.models.logistico.servicios.ServicioDbVehiculo;
import com.epn.trappi.models.rrhh.juanjo.Empleado;

import java.sql.SQLException;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import com.epn.trappi.models.rrhh.juanjo.ControlAsistencias;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;

public class PanelControlDisponibilidad extends javax.swing.JPanel {
    
    
    
    
    ControlDisponibilidad controlDisponibilidad;
    ControlAsistencias controlAsistencias;
    ListaVehiculos lista_vehiculos;
        
    public PanelControlDisponibilidad() {
        initComponents();
        controlDisponibilidad = ControlDisponibilidad.getInstance();
        controlAsistencias = new ControlAsistencias();
        controlAsistencias.events.suscribe("nuevo_empleado",controlDisponibilidad);
        controlAsistencias.events.suscribe("salida_empleado",controlDisponibilidad);
        lista_vehiculos = new ListaVehiculos();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTNombres = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableVerificarVehiculo = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1048, 660));

        jTNombres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre", "Edad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTNombres);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Conductores Disponibles");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Vehículos Disponibles");

        btnActualizar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        jTableVerificarVehiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Matricula"
            }
        ));
        jScrollPane4.setViewportView(jTableVerificarVehiculo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(97, 97, 97)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(403, 403, 403)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(286, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(205, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    public void llenarTablaVehiculos(){
        ServicioDb servicio = new ServicioDbVehiculo();
        try {
            lista_vehiculos.setVehiculos(servicio.obtenerElementosPorFiltro(ServicioDbVehiculo.ESTADO,"Habilitado").getDatos());
            DefaultTableModel modelo = lista_vehiculos.mostrarLista();
            jTableVerificarVehiculo.setModel(modelo);
            //jTableVerificarVehiculo.removeColumnSelectionInterval(WIDTH, WIDTH);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede mostrar la tabla de vehículos", "Error", PLAIN_MESSAGE);
        }
    }
    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        llenarTablaVehiculos();  
        /*
        tabla = "VEHICULO";
        columna = "ESTADO";
        valor = "Habilitado";
        try {
            DefaultTableModel modelo = instancia.consultarTablaColumna(tabla, columna, valor);
            this.jTableVerificarVehiculo.setModel(modelo);
            //Eliminar Tablas sin Importancia
                jTableVerificarVehiculo.removeColumn(jTableVerificarVehiculo.getColumnModel().getColumn(3));
                jTableVerificarVehiculo.removeColumn(jTableVerificarVehiculo.getColumnModel().getColumn(1));
            //Poner Nombres
            changeColumnNameVehiculo(0, "Matricula");
            changeColumnNameVehiculo(1, "Tipo de Vehiculo");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(PanelControlDisponibilidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ArrayList<Empleado> empleados = controlDisponibilidad.le;
        for (Empleado empleado : empleados) {
            JOptionPane.showMessageDialog(null, empleado.getNombres());
        }
        */
        
        /*
        //llenar tabla Empleado
        tabla = "EMPLEADO";
        columna = "TIPOEMP";
        valor = "conductor";
        try {
            DefaultTableModel modelo = instancia.consultarTablaColumna(tabla, columna, valor);
            this.jTNombres.setModel(modelo);
            jTNombres.removeColumn(jTNombres.getColumnModel().getColumn(11));
            jTNombres.removeColumn(jTNombres.getColumnModel().getColumn(10));
            jTNombres.removeColumn(jTNombres.getColumnModel().getColumn(9));
            jTNombres.removeColumn(jTNombres.getColumnModel().getColumn(7));
            jTNombres.removeColumn(jTNombres.getColumnModel().getColumn(6));
            jTNombres.removeColumn(jTNombres.getColumnModel().getColumn(5));
            jTNombres.removeColumn(jTNombres.getColumnModel().getColumn(4));
            jTNombres.removeColumn(jTNombres.getColumnModel().getColumn(3));
            jTNombres.removeColumn(jTNombres.getColumnModel().getColumn(2));
            jTNombres.removeColumn(jTNombres.getColumnModel().getColumn(0));
            //Poner Nombres
            changeColumnNameConductor(0, "Nombre");
            changeColumnNameConductor(1, "Estado");
            
        } catch (SQLException ex) {
            Logger.getLogger(panelControlDisponibilidad.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        
    }//GEN-LAST:event_btnActualizarActionPerformed
     public void changeColumnNameVehiculo(int __COLUMN__, String __NAME__){
        JTableHeader head = jTableVerificarVehiculo.getTableHeader();
        TableColumnModel tcm = head.getColumnModel();
        TableColumn tabCM = tcm.getColumn(__COLUMN__);
        tabCM.setHeaderValue(__NAME__);
        jTableVerificarVehiculo.repaint();
    }
     public void changeColumnNameConductor(int __COLUMN__, String __NAME__){
        JTableHeader head = jTNombres.getTableHeader();
        TableColumnModel tcm = head.getColumnModel();
        TableColumn tabCM = tcm.getColumn(__COLUMN__);
        tabCM.setHeaderValue(__NAME__);
        jTNombres.repaint();
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTNombres;
    private javax.swing.JTable jTableVerificarVehiculo;
    // End of variables declaration//GEN-END:variables
}
