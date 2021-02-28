/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.logistico;

import com.epn.trappi.db.connection.*;
import com.epn.trappi.models.logistico.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
/**
 *
 * @author Alexander
 */
public class ListasVehiculos extends javax.swing.JPanel {

    /**
     * Creates new form ListasVehiculos
     */
    public ListasVehiculos() {
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

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbBusquedaVehiculos = new javax.swing.JComboBox<>();
        btnEntregasRecientes = new javax.swing.JButton();
        txtBusquedaVehiculos = new javax.swing.JTextField();
        btnBuscarVehiculo = new javax.swing.JButton();
        btnEntregasDia = new javax.swing.JButton();
        btnEntregasMes = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbListaVehiculos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

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
        cmbBusquedaVehiculos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Matrícula", "Tipo de Vehículo" }));
        cmbBusquedaVehiculos.setBorder(null);
        jPanel2.add(cmbBusquedaVehiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 54, 140, 30));

        btnEntregasRecientes.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnEntregasRecientes.setForeground(new java.awt.Color(61, 57, 57));
        btnEntregasRecientes.setText("Mostrar las entregas más recientes");
        btnEntregasRecientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntregasRecientesActionPerformed(evt);
            }
        });
        jPanel2.add(btnEntregasRecientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, -1, -1));

        txtBusquedaVehiculos.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
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
        btnEntregasDia.setText("Mostrar entregas del día actual");
        jPanel2.add(btnEntregasDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        btnEntregasMes.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnEntregasMes.setForeground(new java.awt.Color(61, 57, 57));
        btnEntregasMes.setText("Mostrar entregas del mes actual");
        jPanel2.add(btnEntregasMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, -1, -1));

        tbListaVehiculos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tbListaVehiculos.setForeground(new java.awt.Color(61, 57, 57));
        tbListaVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
        tbListaVehiculos.setFocusable(false);
        tbListaVehiculos.setGridColor(new java.awt.Color(61, 57, 57));
        tbListaVehiculos.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbListaVehiculos.setOpaque(false);
        tbListaVehiculos.setRowHeight(25);
        tbListaVehiculos.setSelectionBackground(new java.awt.Color(61, 57, 57));
        tbListaVehiculos.getTableHeader().setReorderingAllowed(false);
        tbListaVehiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbListaVehiculosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbListaVehiculos);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 40));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(61, 57, 57));
        jLabel7.setText("Fecha: 15 de Frebrero del 2021 ");

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(61, 57, 57));
        jLabel8.setText("Conductor: Andrea Días");

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(61, 57, 57));
        jLabel9.setText("Destino: Megamaxi 6 de Diciembre");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/epn/trappi/images/logistico/user (2).png"))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(61, 57, 57));
        jLabel11.setText("Hora: 3PM");

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(61, 57, 57));
        jLabel12.setText("Factura de compra: 212412441");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel12))
                        .addContainerGap(57, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11))
                            .addComponent(jLabel9))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 310, 130));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(61, 57, 57));
        jLabel13.setText("Fecha: 15 de Frebrero del 2021 ");

        jLabel14.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(61, 57, 57));
        jLabel14.setText("Conductor: Andrea Días");

        jLabel15.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(61, 57, 57));
        jLabel15.setText("Destino: Megamaxi 6 de Diciembre");

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/epn/trappi/images/logistico/user (2).png"))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(61, 57, 57));
        jLabel17.setText("Hora: 3PM");

        jLabel18.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(61, 57, 57));
        jLabel18.setText("Factura de compra: 212412441");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel18))
                        .addContainerGap(57, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel17))
                            .addComponent(jLabel15))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18))
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addContainerGap())
        );

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

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
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(313, 313, 313)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(48, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntregasRecientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntregasRecientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEntregasRecientesActionPerformed

    private void btnBuscarVehiculoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarVehiculoMouseMoved


    }//GEN-LAST:event_btnBuscarVehiculoMouseMoved

    private void btnBuscarVehiculoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarVehiculoMouseExited

    }//GEN-LAST:event_btnBuscarVehiculoMouseExited

    private void tbListaVehiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbListaVehiculosMouseClicked
        try{
            int fila = tbListaVehiculos.getSelectedRow();
            String matricula = (String)tbListaVehiculos.getValueAt(fila, 0);
            
            String sql = "";
            DataBaseConnection dbInstance = DataBaseConnection.getInstance();
            Connection connection = dbInstance.getConnection();
            Statement statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println(resultSet);
            while (resultSet.next()) {

            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_tbListaVehiculosMouseClicked

    private void btnBuscarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarVehiculoActionPerformed
        // TODO add your handling code here:
        try{
            String parametro = (String)cmbBusquedaVehiculos.getSelectedItem();
            String texto = txtBusquedaVehiculos.getText().trim();
            
            if(texto.isBlank())
                JOptionPane.showMessageDialog(null, "Ingrese un valor para el parámetro");
            else{
                String sql = "";
                DefaultTableModel modelo = new DefaultTableModel();
                tbListaVehiculos.setModel(modelo);
                modelo.addColumn("Matricula");
                modelo.addColumn("Estado");
                modelo.addColumn("Tipo");
                modelo.addColumn("Kilometraje");
                Object[] filas = new Object[4];

                DataBaseConnection dbInstance = DataBaseConnection.getInstance();
                Connection connection = dbInstance.getConnection();
                Statement statement = connection.createStatement();

                switch(parametro){
                    case "Matrícula":
                        sql = "select * from VEHICULO where MATRICULA=\'" + texto + "\'";
                        break;
                    case "Tipo de Vehículo":
                        sql = "select * from VEHICULO where TIPOVEHICULO=\'" + texto + "\'";
                        break;
                }
                ResultSet resultSet = statement.executeQuery(sql);
                System.out.println(resultSet);
                while (resultSet.next()) {
                    filas[0]=(String)resultSet.getString(1).trim();
                    filas[1]=(String)resultSet.getString(2).trim();
                    filas[2]=(String)resultSet.getString(3).trim();
                    filas[3]=resultSet.getInt(4);
                    modelo.addRow(filas);
                }
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnBuscarVehiculoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarVehiculo;
    private javax.swing.JButton btnEntregasDia;
    private javax.swing.JButton btnEntregasMes;
    private javax.swing.JButton btnEntregasRecientes;
    private javax.swing.JComboBox<String> cmbBusquedaVehiculos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbListaVehiculos;
    private javax.swing.JTextField txtBusquedaVehiculos;
    // End of variables declaration//GEN-END:variables
}
