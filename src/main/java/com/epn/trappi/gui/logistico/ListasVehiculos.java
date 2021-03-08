/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.logistico;

import com.epn.trappi.controladores.logistico.storedProcedures;
import com.epn.trappi.db.connection.*;
import com.epn.trappi.gui.logistico.Logistico_GUI.RoundedBorder;
import com.epn.trappi.models.logistico.*;
import com.epn.trappi.models.logistico.servicios.Consultable;
import com.epn.trappi.models.logistico.servicios.ServicioDb;
import com.epn.trappi.models.logistico.servicios.ServicioDbConductor;
import com.epn.trappi.models.logistico.servicios.ServicioDbEntrega;
import com.epn.trappi.models.logistico.servicios.ServicioDbVehiculo;
import com.epn.trappi.models.logistico.servicios.Unible;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Alexander
 */
public class ListasVehiculos extends javax.swing.JPanel {
    ServicioDb servicioDB;
    Consultable consultable;
    Unible unible;
    ListaVehiculos vehiculos;
    Usos_ViewHandler historial;
    public ListasVehiculos() {
        initComponents();
        historial = new Usos_ViewHandler();
        vehiculos = new ListaVehiculos();
        servicioDB = new ServicioDbVehiculo();
        tablaListaVehiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    llenarHistorialDeUsos(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(ListasVehiculos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ListasVehiculos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        this.btnBuscarVehiculo.setBorder(new RoundedBorder(24));
    }
    private void llenarHistorialDeUsos(java.awt.event.MouseEvent evt) throws SQLException, Exception {                                             

        historial.reiniciarEstado();
        int fila = tablaListaVehiculos.getSelectedRow();
        String matricula = (String)tablaListaVehiculos.getValueAt(fila, 1); //OBTENEMOS EL VALOR DE LA MATRICULA
        
        //Obtenemos las entregas que se hayan hecho con ese vehiculo
        servicioDB = new ServicioDbEntrega();
        ArrayList<Entrega> entregas_por_vehiculo = servicioDB.obtenerElementosPorFiltro(ServicioDbEntrega.MATRICULA, matricula).getDatos();
        //Llenamos el historial con estos datos
        historial.llenar(entregas_por_vehiculo);
        this.panelHistorial.add(historial.obtenerListView());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbBusquedaVehiculos = new javax.swing.JComboBox<>();
        txtBusquedaVehiculos = new javax.swing.JTextField();
        btnBuscarVehiculo = new javax.swing.JButton();
        btnEntregasDia = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        campoRegistros = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaListaVehiculos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        panelHistorial = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Lista de vehículos");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(61, 57, 57), 2, true));
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

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Filtros de búsqueda");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(61, 57, 57));
        jLabel6.setText("Atributo de búsqueda:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        cmbBusquedaVehiculos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBusquedaVehiculos.setForeground(new java.awt.Color(61, 57, 57));
        cmbBusquedaVehiculos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Matrícula", "Tipo de Vehículo", "Estado", "Kilometraje", "ID Vehículo" }));
        cmbBusquedaVehiculos.setBorder(null);
        jPanel2.add(cmbBusquedaVehiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 54, 140, 30));

        txtBusquedaVehiculos.setFont(new java.awt.Font("Segoe UI Semibold", 2, 14)); // NOI18N
        txtBusquedaVehiculos.setForeground(new java.awt.Color(153, 153, 153));
        txtBusquedaVehiculos.setText("Ingrese el valor de la columna que desea filtrar");
        txtBusquedaVehiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBusquedaVehiculosMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtBusquedaVehiculosMouseExited(evt);
            }
        });
        jPanel2.add(txtBusquedaVehiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 370, 30));

        btnBuscarVehiculo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N
        btnBuscarVehiculo.setForeground(new java.awt.Color(61, 57, 57));
        btnBuscarVehiculo.setText("Buscar");
        btnBuscarVehiculo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnBuscarVehiculoMouseMoved(evt);
            }
        });
        btnBuscarVehiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBuscarVehiculoMouseExited(evt);
            }
        });
        btnBuscarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarVehiculoActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscarVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 50, 100, 30));

        btnEntregasDia.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnEntregasDia.setForeground(new java.awt.Color(61, 57, 57));
        btnEntregasDia.setText("PENDIENTE");
        jPanel2.add(btnEntregasDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(61, 57, 57));
        jLabel7.setText("Limitar la cantidad de registros:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, -1, 30));

        campoRegistros.setFont(new java.awt.Font("Segoe UI Semibold", 2, 14)); // NOI18N
        campoRegistros.setForeground(new java.awt.Color(153, 153, 153));
        campoRegistros.setText("20");
        campoRegistros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoRegistrosMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                campoRegistrosMouseExited(evt);
            }
        });
        jPanel2.add(campoRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 110, 210, 30));

        tablaListaVehiculos.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        tablaListaVehiculos.setForeground(new java.awt.Color(61, 57, 57));
        tablaListaVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
                "Matrícula", "Estado", "Tipo", "Kilometraje"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaListaVehiculos.setFocusable(false);
        tablaListaVehiculos.setGridColor(new java.awt.Color(153, 153, 153));
        tablaListaVehiculos.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tablaListaVehiculos.setOpaque(false);
        tablaListaVehiculos.setRowHeight(30);
        tablaListaVehiculos.setSelectionBackground(new java.awt.Color(61, 57, 57));
        tablaListaVehiculos.setShowVerticalLines(false);
        tablaListaVehiculos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaListaVehiculos);

        jPanel3.setBackground(new java.awt.Color(255, 210, 28));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(61, 57, 57));
        jLabel5.setText("Historial de uso del vehículo");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelHistorial.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelHistorialLayout = new javax.swing.GroupLayout(panelHistorial);
        panelHistorial.setLayout(panelHistorialLayout);
        panelHistorialLayout.setHorizontalGroup(
            panelHistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
        );
        panelHistorialLayout.setVerticalGroup(
            panelHistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 348, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(panelHistorial);

        jPanel5.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 310, 350));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(426, 426, 426))
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)))
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(44, 44, 44)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(433, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(313, 313, 313)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(30, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarVehiculoActionPerformed
        int opcion = cmbBusquedaVehiculos.getSelectedIndex();
        String campo_busqueda = txtBusquedaVehiculos.getText();
        try{
        switch (opcion){
            case 0:
                vehiculos.setVehiculos(servicioDB.obtenerElementos().getDatos());
                break;
            case 1:
                vehiculos.setVehiculos(servicioDB.obtenerElementosPorFiltro(ServicioDbVehiculo.MATRICULA,campo_busqueda).getDatos());
                break;
            case 2:
                vehiculos.setVehiculos(servicioDB.obtenerElementosPorFiltro(ServicioDbVehiculo.TIPO,campo_busqueda).getDatos());
                break;
            case 3:
                vehiculos.setVehiculos(servicioDB.obtenerElementosPorFiltro(ServicioDbVehiculo.ESTADO,campo_busqueda).getDatos());
                break;
            case 4:
                vehiculos.setVehiculos(servicioDB.obtenerElementosPorFiltro(ServicioDbVehiculo.KILOMETRAJE,campo_busqueda).getDatos());
                break;
            case 5:
                vehiculos.setVehiculos(servicioDB.obtenerElementosPorFiltro(ServicioDbVehiculo.ID_VEHICULO,campo_busqueda).getDatos());
                break;
        }
        int numero_registros=0;
        String numero = campoRegistros.getText();
        if(numero.length()!=0){
        try{
            //Si el numero de registros solicitados es mayor que los actuales entonces se considera el ultimo 
            numero_registros=Integer.parseInt(numero);
            if(numero_registros>vehiculos.getVehiculos().size()){
                numero_registros=vehiculos.getVehiculos().size();
            }
            ArrayList<Vehiculo> lista = new ArrayList<>();
            for(int puntero=0;puntero<numero_registros;puntero++){
                lista.add(vehiculos.getVehiculos().get(puntero));
            }
            vehiculos.setVehiculos(lista);
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Ingrese un valor entero para el número de registros");
        }
        }
        this.tablaListaVehiculos.setModel(vehiculos.mostrarLista());
        }catch (SQLException e){
                JOptionPane.showMessageDialog(null,"Base de datos fuera de servicio");
                }
    }//GEN-LAST:event_btnBuscarVehiculoActionPerformed

    private void campoRegistrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoRegistrosMouseClicked
        campoRegistros.setText("");
        campoRegistros.setForeground(new Color(0,0,0));
        campoRegistros.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
    }//GEN-LAST:event_campoRegistrosMouseClicked

    private void campoRegistrosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoRegistrosMouseExited
        if (campoRegistros.getText().length()==0){
            campoRegistros.setForeground(new Color(153,153,153));
            campoRegistros.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 14));
            campoRegistros.setText("20");
        }
    }//GEN-LAST:event_campoRegistrosMouseExited

    private void txtBusquedaVehiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBusquedaVehiculosMouseClicked
        txtBusquedaVehiculos.setText("");
        txtBusquedaVehiculos.setForeground(new Color(0,0,0));
        txtBusquedaVehiculos.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
    }//GEN-LAST:event_txtBusquedaVehiculosMouseClicked

    private void txtBusquedaVehiculosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBusquedaVehiculosMouseExited
        if (txtBusquedaVehiculos.getText().length()==0){
            txtBusquedaVehiculos.setForeground(new Color(153,153,153));
            txtBusquedaVehiculos.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 14));
            txtBusquedaVehiculos.setText("Ingrese el valor de la columna que desea filtrar");
        }
    }//GEN-LAST:event_txtBusquedaVehiculosMouseExited

    private void btnBuscarVehiculoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarVehiculoMouseMoved
        Color c = new Color(255, 210, 28);
        this.btnBuscarVehiculo.setForeground(c);
    }//GEN-LAST:event_btnBuscarVehiculoMouseMoved

    private void btnBuscarVehiculoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarVehiculoMouseExited
        Color c = new Color(61,57,57);
        this.btnBuscarVehiculo.setForeground(c);
    }//GEN-LAST:event_btnBuscarVehiculoMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarVehiculo;
    private javax.swing.JButton btnEntregasDia;
    private javax.swing.JTextField campoRegistros;
    private javax.swing.JComboBox<String> cmbBusquedaVehiculos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panelHistorial;
    private javax.swing.JTable tablaListaVehiculos;
    private javax.swing.JTextField txtBusquedaVehiculos;
    // End of variables declaration//GEN-END:variables
}
