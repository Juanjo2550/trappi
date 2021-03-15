/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.logistico;

import com.epn.trappi.gui.logistico.Logistico_GUI.RoundedBorder;
import com.epn.trappi.models.logistico.Estado;
import com.epn.trappi.models.logistico.Inhabilitado;
import com.epn.trappi.models.logistico.ListaMantenimientos;
import com.epn.trappi.models.logistico.ListaVehiculos;
import com.epn.trappi.models.logistico.Mantenimiento;
import com.epn.trappi.models.logistico.SolicitudMantenimiento;
import com.epn.trappi.models.logistico.Vehiculo;
import com.epn.trappi.models.logistico.servicios.ServicioDb;
import com.epn.trappi.models.logistico.servicios.ServicioDbMantenimiento;
import com.epn.trappi.models.logistico.servicios.ServicioDbSolicitudMantenimiento;
import com.epn.trappi.models.logistico.servicios.ServicioDbVehiculo;
import static com.epn.trappi.models.logistico.servicios.ServicioVerificacion.*;
import com.epn.trappi.models.proveedores.Bien;
import com.epn.trappi.models.proveedores.CompraDeServicio;
import com.epn.trappi.models.proveedores.ListaDeBienes;
import java.awt.Color;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alexander
 */
public class FichasTecnicas extends javax.swing.JPanel {
    //ATRIBUTOS
    ServicioDb servicioDB;
    ListaDeBienes bienes = new ListaDeBienes();
    //METODOS
    public FichasTecnicas() {
        initComponents();
        this.btnRegistrarMantenimiento.setBorder(new RoundedBorder(24));
        this.btnRegistrarSolicitud.setBorder(new RoundedBorder(24));
        bienes.cargarServicios();
        for (Bien aux : bienes.getListaBienes()) {
            comboServicios.addItem(aux.getNombre());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtMatriculaVehiculo = new javax.swing.JTextField();
        jTFidMantenimiento = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaDetallesMantenimiento = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableVerificarVehiculo = new javax.swing.JTable();
        btnVerificarVehiculo = new javax.swing.JButton();
        btnRegistrarMantenimiento = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtIdMantenimiento = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnRegistrarSolicitud = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jTFidSolicitud = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnVerificarMantenimiento = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTVerificarMantenimiento = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        comboServicios = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(96, 97, 101));
        jLabel1.setText("Registro de mantenimientos");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(219, 223, 228), 1, true));
        jPanel2.setForeground(new java.awt.Color(61, 57, 57));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Filtros de búsqueda");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        txtMatriculaVehiculo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMatriculaVehiculo.setForeground(new java.awt.Color(61, 57, 57));
        txtMatriculaVehiculo.setText("PBP-2432");
        txtMatriculaVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatriculaVehiculoActionPerformed(evt);
            }
        });
        jPanel2.add(txtMatriculaVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 180, 30));

        jTFidMantenimiento.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jTFidMantenimiento.setForeground(new java.awt.Color(61, 57, 57));
        jTFidMantenimiento.setText("123");
        jTFidMantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFidMantenimientoActionPerformed(evt);
            }
        });
        jPanel2.add(jTFidMantenimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 130, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(61, 57, 57));
        jLabel7.setText("ID Mantenimiento:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, -1, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(61, 57, 57));
        jLabel8.setText("Matrícula del vehículo:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 30));

        txaDetallesMantenimiento.setColumns(20);
        txaDetallesMantenimiento.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        txaDetallesMantenimiento.setForeground(new java.awt.Color(61, 57, 57));
        txaDetallesMantenimiento.setRows(5);
        jScrollPane1.setViewportView(txaDetallesMantenimiento);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, 460, 110));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(61, 57, 57));
        jLabel6.setText("Detalles del mantenimiento:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, -1, 30));

        jTableVerificarVehiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Matricula"
            }
        ));
        jScrollPane2.setViewportView(jTableVerificarVehiculo);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 360, 110));

        btnVerificarVehiculo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnVerificarVehiculo.setForeground(new java.awt.Color(61, 57, 57));
        btnVerificarVehiculo.setText("Verificar");
        btnVerificarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarVehiculoActionPerformed(evt);
            }
        });
        jPanel2.add(btnVerificarVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 180, 30));

        btnRegistrarMantenimiento.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnRegistrarMantenimiento.setForeground(new java.awt.Color(61, 57, 57));
        btnRegistrarMantenimiento.setText("Registrar");
        btnRegistrarMantenimiento.setContentAreaFilled(false);
        btnRegistrarMantenimiento.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnRegistrarMantenimientoMouseMoved(evt);
            }
        });
        btnRegistrarMantenimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegistrarMantenimientoMouseExited(evt);
            }
        });
        btnRegistrarMantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarMantenimientoActionPerformed(evt);
            }
        });
        jPanel2.add(btnRegistrarMantenimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 70, 150, 30));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(219, 223, 228), 1, true));
        jPanel9.setForeground(new java.awt.Color(61, 57, 57));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setBackground(new java.awt.Color(34, 45, 50));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(34, 45, 50));
        jLabel14.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("https://i.ibb.co/BtRLJgv/configuraciones.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        jLabel14.setText("  Registrar mantenimiento");
        jPanel9.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 14, 260, 30));

        jPanel10.setBackground(new java.awt.Color(60, 141, 188));
        jPanel10.setPreferredSize(new java.awt.Dimension(970, 5));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 970, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, -1));

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 50));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(219, 223, 228), 1, true));
        jPanel3.setForeground(new java.awt.Color(61, 57, 57));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Filtros de búsqueda");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        txtIdMantenimiento.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        txtIdMantenimiento.setForeground(new java.awt.Color(61, 57, 57));
        txtIdMantenimiento.setText("123");
        jPanel3.add(txtIdMantenimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 350, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(61, 57, 57));
        jLabel10.setText("ID Mantenimiento:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 30));

        btnRegistrarSolicitud.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnRegistrarSolicitud.setForeground(new java.awt.Color(61, 57, 57));
        btnRegistrarSolicitud.setText("Registrar");
        btnRegistrarSolicitud.setContentAreaFilled(false);
        btnRegistrarSolicitud.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnRegistrarSolicitudMouseMoved(evt);
            }
        });
        btnRegistrarSolicitud.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegistrarSolicitudMouseExited(evt);
            }
        });
        btnRegistrarSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarSolicitudActionPerformed(evt);
            }
        });
        jPanel3.add(btnRegistrarSolicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 240, 220, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(61, 57, 57));
        jLabel11.setText("ID solicitud:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 180, 100, 30));

        jTFidSolicitud.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jTFidSolicitud.setForeground(new java.awt.Color(61, 57, 57));
        jTFidSolicitud.setText("1");
        jPanel3.add(jTFidSolicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 180, 130, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(61, 57, 57));
        jLabel12.setText("Seleccione el servicio que necesita: ");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, 270, 20));

        btnVerificarMantenimiento.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnVerificarMantenimiento.setForeground(new java.awt.Color(61, 57, 57));
        btnVerificarMantenimiento.setText("Verificar");
        btnVerificarMantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarMantenimientoActionPerformed(evt);
            }
        });
        jPanel3.add(btnVerificarMantenimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 210, 30));

        jTVerificarMantenimiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Matricula"
            }
        ));
        jScrollPane3.setViewportView(jTVerificarMantenimiento);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 510, 120));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(219, 223, 228), 1, true));
        jPanel8.setForeground(new java.awt.Color(61, 57, 57));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setBackground(new java.awt.Color(34, 45, 50));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(34, 45, 50));
        jLabel13.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("https://i.ibb.co/Wc1gGwX/ruedas.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        jLabel13.setText("  Registrar solicitud de servicio");
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 260, 40));

        jPanel6.setBackground(new java.awt.Color(60, 141, 188));
        jPanel6.setPreferredSize(new java.awt.Dimension(970, 5));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 970, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, -1));

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 50));

        comboServicios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel3.add(comboServicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 270, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 10)); // NOI18N
        jLabel2.setText("(Asocie la solicitud a un mantenimiento existente)");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerificarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarVehiculoActionPerformed
        ListaVehiculos vehiculos = new ListaVehiculos();
        servicioDB = new ServicioDbVehiculo();
        String valor = txtMatriculaVehiculo.getText();
        
        strErrores+=verificarMatricula(valor);
                if(!strErrores.equals(""))
                {
                    strErrores="Errores existentes:\n"+strErrores;
                    JOptionPane.showMessageDialog(null, strErrores , "Error al Buscar el Vehículo" , JOptionPane.ERROR_MESSAGE);
                    strErrores="";
                    return;
                }else {
                        try {
                            vehiculos.setVehiculos(servicioDB.obtenerElementosPorFiltro(ServicioDbVehiculo.MATRICULA, valor).getDatos());
                            this.jTableVerificarVehiculo.setModel(vehiculos.mostrarLista());
                        } catch (SQLException ex) {
                            Logger.getLogger(FichasTecnicas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }
    }//GEN-LAST:event_btnVerificarVehiculoActionPerformed

    private void btnVerificarMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarMantenimientoActionPerformed
        ListaMantenimientos mantenimientos = new ListaMantenimientos();
        servicioDB = new ServicioDbMantenimiento();
        String valor = txtIdMantenimiento.getText();
        
        strErrores+=verificarID(valor);
                if(!strErrores.equals(""))
                {
                    strErrores="Errores existentes:\n"+strErrores;
                    JOptionPane.showMessageDialog(null, strErrores , "Error al Buscar el Mantenimiento" , JOptionPane.ERROR_MESSAGE);
                    strErrores="";
                    return;
                }else {
                        try {
                            mantenimientos.setMantenimientos(servicioDB.obtenerElementosPorFiltro(ServicioDbMantenimiento.ID_MANTENIMIENTO, valor).getDatos());
                            this.jTVerificarMantenimiento.setModel(mantenimientos.mostrarLista());
                        } catch (SQLException ex) {
                            Logger.getLogger(FichasTecnicas.class.getName()).log(Level.SEVERE, null, ex);
                        } 
                }
    }//GEN-LAST:event_btnVerificarMantenimientoActionPerformed
    
    private String getFechaSistema(){
        String fechaActual="";
        Calendar fecha = new GregorianCalendar();
        int anio = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minuto = fecha.get(Calendar.MINUTE);
        int segundo = fecha.get(Calendar.SECOND);
        return anio + "-" + mes + "-" + dia + " " + hora + ":" + minuto + ":" + segundo ;
        
    }
    
    private void btnRegistrarSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarSolicitudActionPerformed
        strErrores+=verificarID(jTFidSolicitud.getText());
        if(!strErrores.equals(""))
                {
                    strErrores="Errores existentes:\n"+strErrores;
                    JOptionPane.showMessageDialog(null, strErrores , "Formato de ID Solicitud incorrecto" , JOptionPane.ERROR_MESSAGE);
                    strErrores="";
                    return;
                }
        strErrores+=verificarID(txtIdMantenimiento.getText());
        if(!strErrores.equals(""))
                {
                    strErrores="Errores existentes:\n"+strErrores;
                    JOptionPane.showMessageDialog(null, strErrores , "Formato de ID Mantenimiento incorrecto" , JOptionPane.ERROR_MESSAGE);
                    strErrores="";
                    return;
                }
        ServicioDbSolicitudMantenimiento servicio = new ServicioDbSolicitudMantenimiento();
        String fechaSol = getFechaSistema(); 
        int numSolicitud = Integer.parseInt(jTFidSolicitud.getText());
        int idMantenimiento = Integer.parseInt(txtIdMantenimiento.getText());
        //Verificamos cual ID de Bien se usará
        int identificadorBien=1;
        int opcion = comboServicios.getSelectedIndex();
        switch(opcion){
            case 0:
                identificadorBien=8;
                break;
            case 1:
                identificadorBien=9;
                break;
            case 2:
                identificadorBien=14;
                break;
        }
        //Registramos la solicitud
        
        ListaDeBienes seleccionados=new ListaDeBienes();
        seleccionados.añadirBien(bienes.getListaBienes().get(comboServicios.getSelectedIndex()));
        CompraDeServicio compra = new CompraDeServicio(seleccionados ,"Entregado");
        boolean estadoSolicitud = compra.comprar();
        double gasto = compra.getMontoTotal();
        
        SolicitudMantenimiento solicitud = new SolicitudMantenimiento();
        solicitud.setId_Solicitud(numSolicitud);
        solicitud.setId_Bien(identificadorBien);
        solicitud.setId_Mantenimiento(idMantenimiento);
        //solicitud.setEstado("En espera");
        solicitud.setEstado(estadoSolicitud+"");
        solicitud.setFecha(fechaSol);
        try{
            servicio.insertar(solicitud);
            JOptionPane.showMessageDialog(null, "Solicitud de mantenimiento ingresado exitosamente!");
        }catch (SQLException x){
            
        }
        
    }//GEN-LAST:event_btnRegistrarSolicitudActionPerformed

    private void btnRegistrarMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarMantenimientoActionPerformed
        
        strErrores+=verificarMatricula(txtMatriculaVehiculo.getText());
        if(!strErrores.equals(""))
                {
                    strErrores="Errores existentes:\n"+strErrores;
                    JOptionPane.showMessageDialog(null, strErrores , "Matricula erronea" , JOptionPane.ERROR_MESSAGE);
                    strErrores="";
                    return;
                }
        strErrores+=verificarID(jTFidMantenimiento.getText());
        if(!strErrores.equals(""))
                {
                    strErrores="Errores existentes:\n"+strErrores;
                    JOptionPane.showMessageDialog(null, strErrores , "Formato de ID incorrecto" , JOptionPane.ERROR_MESSAGE);
                    strErrores="";
                    return;
                }
        Mantenimiento mantenimiento = new Mantenimiento(Integer.parseInt(jTFidMantenimiento.getText()),txtMatriculaVehiculo.getText(), txaDetallesMantenimiento.getText());
        try {
            servicioDB = new ServicioDbMantenimiento();
            servicioDB.insertar(mantenimiento);
            servicioDB = new ServicioDbVehiculo();
            ArrayList<Vehiculo> vehiculos = servicioDB.obtenerElementosPorFiltro(ServicioDbVehiculo.MATRICULA, txtMatriculaVehiculo.getText()).getDatos();
            Vehiculo vehiculo = vehiculos.get(0); //Como la matricula es unica entonces la lista tiene longitud 1
            vehiculo.setEstado(new Inhabilitado());
            servicioDB = new ServicioDbVehiculo();
            servicioDB.actualizar(vehiculo);
            JOptionPane.showMessageDialog(null, "Mantenimiento ingresado exitosamente!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Base de datos no disponible.");
        }
    }//GEN-LAST:event_btnRegistrarMantenimientoActionPerformed

    private void txtMatriculaVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatriculaVehiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatriculaVehiculoActionPerformed

    private void btnRegistrarMantenimientoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMantenimientoMouseMoved
        Color c = new Color(60,141,188);
        this.btnRegistrarMantenimiento.setForeground(c);
    }//GEN-LAST:event_btnRegistrarMantenimientoMouseMoved

    private void btnRegistrarMantenimientoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMantenimientoMouseExited
        Color c = new Color(61,57,57);
        this.btnRegistrarMantenimiento.setForeground(c);
    }//GEN-LAST:event_btnRegistrarMantenimientoMouseExited

    private void btnRegistrarSolicitudMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarSolicitudMouseMoved
        Color c = new Color(60,141,188);
        this.btnRegistrarSolicitud.setForeground(c);
    }//GEN-LAST:event_btnRegistrarSolicitudMouseMoved

    private void btnRegistrarSolicitudMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarSolicitudMouseExited
        Color c = new Color(61,57,57);
        this.btnRegistrarSolicitud.setForeground(c);
    }//GEN-LAST:event_btnRegistrarSolicitudMouseExited

    private void jTFidMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFidMantenimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFidMantenimientoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarMantenimiento;
    private javax.swing.JButton btnRegistrarSolicitud;
    private javax.swing.JButton btnVerificarMantenimiento;
    private javax.swing.JButton btnVerificarVehiculo;
    private javax.swing.JComboBox<String> comboServicios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTFidMantenimiento;
    private javax.swing.JTextField jTFidSolicitud;
    private javax.swing.JTable jTVerificarMantenimiento;
    private javax.swing.JTable jTableVerificarVehiculo;
    private javax.swing.JTextArea txaDetallesMantenimiento;
    private javax.swing.JTextField txtIdMantenimiento;
    private javax.swing.JTextField txtMatriculaVehiculo;
    // End of variables declaration//GEN-END:variables
    private String strErrores="";
}
