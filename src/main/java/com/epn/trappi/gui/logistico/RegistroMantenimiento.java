/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.logistico;

import com.epn.trappi.models.logistico.ListaMantenimientos;
import com.epn.trappi.models.logistico.Mantenimiento;
import com.epn.trappi.models.logistico.SolicitudMantenimiento;
import com.epn.trappi.models.logistico.servicios.Consultable;
import com.epn.trappi.models.logistico.servicios.ServicioDb;
import com.epn.trappi.models.logistico.servicios.ServicioDbMantenimiento;
import com.epn.trappi.models.logistico.servicios.ServicioDbSolicitudMantenimiento;
import static com.epn.trappi.models.logistico.servicios.ServicioVerificacion.*;
import com.epn.trappi.models.logistico.servicios.Unible;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexander
 */
public class RegistroMantenimiento extends javax.swing.JPanel {
    //ATRIBUTOS
    ServicioDb servicioDB;
    Consultable consultable;
    Unible unible;
    ListaMantenimientos lista;
    Usos_ViewHandler historial;
    public RegistroMantenimiento() {
        initComponents();
        servicioDB = new ServicioDbMantenimiento();
        lista = new ListaMantenimientos();
        historial = new Usos_ViewHandler();
        this.btnBuscar.setBorder(new Logistico_GUI.RoundedBorder(24));
        tablaMantenimientos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    llenarHistorialDeSolicitudes(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(ListasVehiculos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ListasVehiculos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
        private void llenarHistorialDeSolicitudes(java.awt.event.MouseEvent evt) throws SQLException, Exception {                                             

        historial.reiniciarEstado();
        int fila = tablaMantenimientos.getSelectedRow();
        String id_mant = (String)tablaMantenimientos.getValueAt(fila, 0); //OBTENEMOS EL ID DEL MANTENIMIENTO
        
        //Obtenemos las entregas que se hayan hecho con ese vehiculo
        ServicioDb servicioM = new ServicioDbSolicitudMantenimiento();
        ArrayList<SolicitudMantenimiento> sol_por_mant = servicioM.obtenerElementosPorFiltro(ServicioDbSolicitudMantenimiento.ID_MANTENIMIENTO,id_mant).getDatos();
        if(sol_por_mant.isEmpty()){
            JOptionPane.showMessageDialog(null,"No existen solicitudes para este mantenimiento");
            this.panelHistorial.setVisible(false);
            this.panelHistorial.setVisible(true);
            return;
        }
        
        //Llenamos el historial con estos datos
        historial.llenar(sol_por_mant, new Solicitudes_ViewItem());
        Component lista_solicitudes = historial.obtenerListView();
        this.panelHistorial.add(lista_solicitudes);
        this.panelHistorial.setVisible(false);
        this.panelHistorial.setVisible(true);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbBusquedaMantenimientos = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        campoRegistros = new javax.swing.JTextField();
        txtBusqueda = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMantenimientos = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        panelHistorial = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(96, 97, 101));
        jLabel1.setText("Historial de mantenimientos");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(219, 223, 228), 1, true));
        jPanel2.setForeground(new java.awt.Color(61, 57, 57));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(219, 223, 228), 1, true));
        jPanel7.setForeground(new java.awt.Color(61, 57, 57));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(34, 45, 50));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(34, 45, 50));
        jLabel3.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("https://i.ibb.co/X4N1R0x/buscando-en-la-tierra.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        jLabel3.setText("  Búsqueda");
        jPanel7.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 14, 110, 30));

        jPanel1.setBackground(new java.awt.Color(60, 141, 188));
        jPanel1.setPreferredSize(new java.awt.Dimension(970, 5));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 970, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, -1));

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 50));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Filtros de búsqueda");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(61, 57, 57));
        jLabel6.setText("Atributo de búsqueda:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 40));

        cmbBusquedaMantenimientos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBusquedaMantenimientos.setForeground(new java.awt.Color(61, 57, 57));
        cmbBusquedaMantenimientos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Matrícula", "Id Mantenimiento", "Gasto" }));
        cmbBusquedaMantenimientos.setBorder(null);
        jPanel2.add(cmbBusquedaMantenimientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 140, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(61, 57, 57));
        jLabel7.setText("Limitar la cantidad de registros:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, -1, 30));

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
        jPanel2.add(campoRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 130, 210, 30));

        txtBusqueda.setFont(new java.awt.Font("Segoe UI Semibold", 2, 14)); // NOI18N
        txtBusqueda.setForeground(new java.awt.Color(153, 153, 153));
        txtBusqueda.setText("Ingrese el valor de la columna que desea filtrar");
        txtBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBusquedaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtBusquedaMouseExited(evt);
            }
        });
        jPanel2.add(txtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 370, 30));

        btnBuscar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(61, 57, 57));
        btnBuscar.setText("Buscar");
        btnBuscar.setContentAreaFilled(false);
        btnBuscar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnBuscarMouseMoved(evt);
            }
        });
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBuscarMouseExited(evt);
            }
        });
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 70, 100, 30));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 223, 228)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(219, 223, 228), 1, true));
        jPanel8.setForeground(new java.awt.Color(61, 57, 57));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setBackground(new java.awt.Color(34, 45, 50));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(34, 45, 50));
        jLabel8.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("https://i.ibb.co/wNY3L62/coche-con-rueda-de-repuesto.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        jLabel8.setText("  Mantenimientos");
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 14, 170, 30));

        jPanel6.setBackground(new java.awt.Color(60, 141, 188));
        jPanel6.setPreferredSize(new java.awt.Dimension(970, 5));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -5, 560, 10));

        jPanel4.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 50));

        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(96, 97, 101));

        tablaMantenimientos.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        tablaMantenimientos.setForeground(new java.awt.Color(61, 57, 57));
        tablaMantenimientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", "", null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
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
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaMantenimientos.setGridColor(new java.awt.Color(153, 153, 153));
        tablaMantenimientos.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tablaMantenimientos.setRowHeight(30);
        tablaMantenimientos.setSelectionBackground(new java.awt.Color(239, 239, 239));
        tablaMantenimientos.setShowVerticalLines(false);
        jScrollPane1.setViewportView(tablaMantenimientos);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 510, 380));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 223, 228)));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setBorder(null);

        panelHistorial.setBackground(new java.awt.Color(255, 255, 255));
        panelHistorial.setLayout(new javax.swing.BoxLayout(panelHistorial, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane3.setViewportView(panelHistorial);

        jPanel5.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 280, 350));

        jPanel9.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 300, 370));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(219, 223, 228), 1, true));
        jPanel10.setForeground(new java.awt.Color(61, 57, 57));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setBackground(new java.awt.Color(34, 45, 50));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(34, 45, 50));
        jLabel9.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("https://i.ibb.co/X8vKmgN/informe-medico.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        jLabel9.setText("  Solicitudes por mantenimiento");
        jPanel10.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 14, -1, 30));

        jPanel11.setBackground(new java.awt.Color(96, 97, 101));
        jPanel11.setPreferredSize(new java.awt.Dimension(270, 5));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel10.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, -1));

        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(103, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

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

    private void txtBusquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBusquedaMouseClicked
        txtBusqueda.setText("");
        txtBusqueda.setForeground(new Color(0,0,0));
        txtBusqueda.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
    }//GEN-LAST:event_txtBusquedaMouseClicked

    private void txtBusquedaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBusquedaMouseExited
        if (txtBusqueda.getText().length()==0){
            txtBusqueda.setForeground(new Color(153,153,153));
            txtBusqueda.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 14));
            txtBusqueda.setText("Ingrese el valor de la columna que desea filtrar");
        }
    }//GEN-LAST:event_txtBusquedaMouseExited

    private void btnBuscarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseMoved
        Color c = new Color(60,141,188);
        this.btnBuscar.setForeground(c);
    }//GEN-LAST:event_btnBuscarMouseMoved

    private void btnBuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseExited
        Color c = new Color(61,57,57);
        this.btnBuscar.setForeground(c);
    }//GEN-LAST:event_btnBuscarMouseExited

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        
        int opcion = cmbBusquedaMantenimientos.getSelectedIndex();
        String campo_busqueda = txtBusqueda.getText();
        try{
            switch (opcion){
                case 0:
                lista.setMantenimientos(servicioDB.obtenerElementos().getDatos());
                break;
                case 1:
                        strErrores+=verificarMatricula(campo_busqueda);
                    if(!strErrores.equals(""))
                    {
                        strErrores="Errores existentes:\n"+strErrores;
                        JOptionPane.showMessageDialog(null, strErrores , "Error al Buscar por Matricula" , JOptionPane.ERROR_MESSAGE);
                        strErrores="";
                        return;
                    }else {
                        lista.setMantenimientos(servicioDB.obtenerElementosPorFiltro(ServicioDbMantenimiento.MATRICULA,campo_busqueda).getDatos());
                        break;
                    }
                case 2:
                        strErrores+=verificarID(campo_busqueda);
                    if(!strErrores.equals(""))
                    {
                        strErrores="Errores existentes:\n"+strErrores;
                        JOptionPane.showMessageDialog(null, strErrores , "Error al Buscar por ID" , JOptionPane.ERROR_MESSAGE);
                        strErrores="";
                        return;
                    }else {
                        lista.setMantenimientos(servicioDB.obtenerElementosPorFiltro(ServicioDbMantenimiento.ID_MANTENIMIENTO,campo_busqueda).getDatos());
                        break;
                    }
                case 3:
                        strErrores+=verificarGasto(campo_busqueda);
                    if(!strErrores.equals(""))
                    {
                        strErrores="Errores existentes:\n"+strErrores;
                        JOptionPane.showMessageDialog(null, strErrores , "Error al Buscar por Gasto" , JOptionPane.ERROR_MESSAGE);
                        strErrores="";
                        return;
                    }else {
                    lista.setMantenimientos(servicioDB.obtenerElementosPorFiltro(ServicioDbMantenimiento.GASTO,campo_busqueda).getDatos());
                    break;
                    }
            }
            int numero_registros=0;
            String numero = campoRegistros.getText();
            if(numero.length()!=0){
                try{
                    //Si el numero de registros solicitados es mayor que los actuales entonces se considera el ultimo
                    numero_registros=Integer.parseInt(numero);
                    if(numero_registros>lista.getMantenimientos().size()){
                        numero_registros=lista.getMantenimientos().size();
                    }
                    ArrayList<Mantenimiento> registros = new ArrayList<>();
                    for(int puntero=0;puntero<numero_registros;puntero++){
                        registros.add(lista.getMantenimientos().get(puntero));
                    }
                    lista.setMantenimientos(registros);
                }catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null,"Ingrese un valor entero para el número de registros");
                }
            }
            this.tablaMantenimientos.setModel(lista.mostrarLista());
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Base de datos fuera de servicio");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JTextField campoRegistros;
    private javax.swing.JComboBox<String> cmbBusquedaMantenimientos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panelHistorial;
    private javax.swing.JTable tablaMantenimientos;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
    private String strErrores="";
}
