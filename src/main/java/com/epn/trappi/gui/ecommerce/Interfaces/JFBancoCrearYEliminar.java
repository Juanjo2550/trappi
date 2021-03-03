/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.ecommerce.Interfaces;

import com.epn.trappi.db.connection.DataBaseConnection;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andres
 */
public class JFBancoCrearYEliminar extends javax.swing.JFrame {

    public JFBancoCrearYEliminar() {
        initComponents();
        this.setSize(1024, 700);
        this.setLocationRelativeTo(null);
        jLabelBolivariano.setVisible(false);
        jLabelPacifico.setVisible(false);
        jLabelPichincha.setVisible(false);
        jLabelGuayaquil.setVisible(false);
        jPanelCrearCuenta.setVisible(false);
        jPanelEliminarCuenta.setVisible(false);
        try {
            llenartablaClientes();
        } catch (SQLException ex) {
            Logger.getLogger(JFBancoCrearYEliminar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int devolverIDBanco(){
        if(jLabelPichincha.isVisible()){
            return 1;
        }
        else if(jLabelGuayaquil.isVisible()){
            return 3;
        }
        else if(jLabelPacifico.isVisible()){
            return 2;
        }
        else{
            return 4;
        }
    }

    public void llenartabla(JTable jtable)throws SQLException{
        DefaultTableModel tb = (DefaultTableModel) jtable.getModel();
        int a = jtable.getRowCount()-1;
        for (int i = a; i >= 0; i--) {          
            tb.removeRow(tb.getRowCount()-1);
        }
        int num= devolverIDBanco();
        DataBaseConnection dbInstance = DataBaseConnection.getInstance();
        Connection connection = dbInstance.getConnection();
        Statement statement = connection.createStatement();
        String sql = "SELECT C.NOMBRECLIE, C.CEDULA2, CB.NUMERODECUENTA, B.NOMBREBAN \n" +
                        "FROM CUENTABANCARIA CB, CLIENTES C, BANCO B \n" +
                    "where CB.IDCLIENTE = C.IDCLIENTE AND B.IDBANCO=CB.IDBANCO AND CB.IDBANCO="+num+";";
        ResultSet resultSet = statement.executeQuery(sql);
        DefaultTableModel cuentas = (DefaultTableModel) jtable.getModel();
        String[] aux=new String[4];
        while (resultSet.next()) {
            aux[0]=resultSet.getString(1);
            aux[1]=resultSet.getString(2);
            aux[2]=resultSet.getString(3);
            aux[3]=resultSet.getString(4);
            cuentas.addRow(aux);
        }
    }
    
    public void llenartablaClientes() throws SQLException{
        DataBaseConnection dbInstance = DataBaseConnection.getInstance();
        Connection connection = dbInstance.getConnection();
        Statement statement = connection.createStatement();
        String sql = "SELECT IDCLIENTE, NOMBRECLIE, CEDULA2 From CLIENTES;";
        ResultSet resultSet = statement.executeQuery(sql);
        DefaultTableModel clientes = (DefaultTableModel) jTableClientes.getModel();
        String[] aux=new String[3];
        while (resultSet.next()) {
            aux[0]=resultSet.getString(1);
            aux[1]=resultSet.getString(2);
            aux[2]=resultSet.getString(3);
            clientes.addRow(aux);
        }
    }
    
    public int ultimoIDcuentas() throws SQLException{
        DataBaseConnection dbInstance = DataBaseConnection.getInstance();
        Connection connection = dbInstance.getConnection();
        Statement statement = connection.createStatement();
        String sql = "SELECT IDCUENTABANCARIA FROM CUENTABANCARIA;";
        ResultSet resultSet = statement.executeQuery(sql);
        int aux=1;
        while(resultSet.next()){
            aux++;
        }
        return aux;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelPacifico = new javax.swing.JLabel();
        jLabelPichincha = new javax.swing.JLabel();
        jLabelGuayaquil = new javax.swing.JLabel();
        jLabelBolivariano = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButtonCrearCu = new javax.swing.JButton();
        jButtonIngresarCu = new javax.swing.JButton();
        jButtonEliminarCu = new javax.swing.JButton();
        jButtonMostrarCu = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanelCrearCuenta = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldNroCrear = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButtonCrearCuenta = new javax.swing.JButton();
        jButtonCancelarCreacion = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldNombresCrear = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldCedulaCrear = new javax.swing.JTextField();
        jPanelEliminarCuenta = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jButtonEliminarCuenta = new javax.swing.JButton();
        jButtonCancelarEliminar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableEliminarCuenta = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldNroCuentaEliminar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelPacifico.setIcon(new javax.swing.ImageIcon("C:\\Users\\Christian\\Documents\\GitHub\\trappi\\src\\main\\resources\\contents\\Imagenes\\BancoPacifico.png")); // NOI18N
        jPanel1.add(jLabelPacifico, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, -1));

        jLabelPichincha.setIcon(new javax.swing.ImageIcon("C:\\Users\\Christian\\Documents\\GitHub\\trappi\\src\\main\\resources\\contents\\Imagenes\\BancoPichincha.png")); // NOI18N
        jPanel1.add(jLabelPichincha, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, -1));

        jLabelGuayaquil.setIcon(new javax.swing.ImageIcon("C:\\Users\\Christian\\Documents\\GitHub\\trappi\\src\\main\\resources\\contents\\Imagenes\\BancoGuayaquil.jpg")); // NOI18N
        jPanel1.add(jLabelGuayaquil, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, -1, -1));

        jLabelBolivariano.setIcon(new javax.swing.ImageIcon("C:\\Users\\Christian\\Documents\\GitHub\\trappi\\src\\main\\resources\\contents\\Imagenes\\BancoBolivariano.png")); // NOI18N
        jPanel1.add(jLabelBolivariano, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, -1, -1));

        jButtonCrearCu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonCrearCu.setText("Crear Cuenta");
        jButtonCrearCu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearCuActionPerformed(evt);
            }
        });

        jButtonIngresarCu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonIngresarCu.setText("Ingresar Cuenta");
        jButtonIngresarCu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIngresarCuActionPerformed(evt);
            }
        });

        jButtonEliminarCu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonEliminarCu.setText("Eliminar Cuenta");
        jButtonEliminarCu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarCuActionPerformed(evt);
            }
        });

        jButtonMostrarCu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonMostrarCu.setText("Mostrar Cuentas");
        jButtonMostrarCu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMostrarCuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonMostrarCu)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButtonCrearCu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonIngresarCu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonEliminarCu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(54, 54, 54))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jButtonMostrarCu)
                .addGap(68, 68, 68)
                .addComponent(jButtonCrearCu)
                .addGap(68, 68, 68)
                .addComponent(jButtonIngresarCu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(jButtonEliminarCu)
                .addGap(30, 30, 30))
        );

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("Crear Cuenta");

        jLabel8.setText("Nro. Cuenta:");

        jButtonCrearCuenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonCrearCuenta.setText("Crear");
        jButtonCrearCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearCuentaActionPerformed(evt);
            }
        });

        jButtonCancelarCreacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonCancelarCreacion.setText("Cancelar");
        jButtonCancelarCreacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarCreacionActionPerformed(evt);
            }
        });

        jTableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Cliente", "Nombres", "Cedula"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableClientes);

        jLabel1.setText("Seleccione el Cliente al que se desea crear una cuenta e ingrese un numero de cuenta");

        jLabel9.setText("Nombres:");

        jTextFieldNombresCrear.setEditable(false);
        jTextFieldNombresCrear.setBackground(new java.awt.Color(204, 204, 204));

        jLabel10.setText("Cédula:");

        jTextFieldCedulaCrear.setEditable(false);
        jTextFieldCedulaCrear.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanelCrearCuentaLayout = new javax.swing.GroupLayout(jPanelCrearCuenta);
        jPanelCrearCuenta.setLayout(jPanelCrearCuentaLayout);
        jPanelCrearCuentaLayout.setHorizontalGroup(
            jPanelCrearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCrearCuentaLayout.createSequentialGroup()
                .addGroup(jPanelCrearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCrearCuentaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelCrearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCrearCuentaLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(30, 30, 30))))
                    .addGroup(jPanelCrearCuentaLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanelCrearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelCrearCuentaLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanelCrearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanelCrearCuentaLayout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextFieldCedulaCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCrearCuentaLayout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextFieldNombresCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCrearCuentaLayout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(47, 47, 47)
                                        .addComponent(jTextFieldNroCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCrearCuentaLayout.createSequentialGroup()
                                .addComponent(jButtonCrearCuenta)
                                .addGap(143, 143, 143)
                                .addComponent(jButtonCancelarCreacion))))
                    .addGroup(jPanelCrearCuentaLayout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel5)))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        jPanelCrearCuentaLayout.setVerticalGroup(
            jPanelCrearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCrearCuentaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(1, 1, 1)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelCrearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldNombresCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCrearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldCedulaCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCrearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldNroCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCrearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelarCreacion)
                    .addComponent(jButtonCrearCuenta))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        jPanel3.add(jPanelCrearCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 24, 600, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel12.setText("Eliminar Cuenta");

        jButtonEliminarCuenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonEliminarCuenta.setText("Eliminar");
        jButtonEliminarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarCuentaActionPerformed(evt);
            }
        });

        jButtonCancelarEliminar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonCancelarEliminar.setText("Cancelar");
        jButtonCancelarEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarEliminarActionPerformed(evt);
            }
        });

        jTableEliminarCuenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombres", "Cedula", "Nro. Cuenta", "Entidad"
            }
        ));
        jTableEliminarCuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEliminarCuentaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableEliminarCuenta);

        jLabel2.setText("Seleccione la cuenta que desee ser eliminada y pulse Eliminar");

        jLabel3.setText("Nro. Cuenta:");

        jTextFieldNroCuentaEliminar.setEditable(false);
        jTextFieldNroCuentaEliminar.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanelEliminarCuentaLayout = new javax.swing.GroupLayout(jPanelEliminarCuenta);
        jPanelEliminarCuenta.setLayout(jPanelEliminarCuentaLayout);
        jPanelEliminarCuentaLayout.setHorizontalGroup(
            jPanelEliminarCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEliminarCuentaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonEliminarCuenta)
                .addGap(118, 118, 118)
                .addComponent(jButtonCancelarEliminar)
                .addGap(193, 193, 193))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEliminarCuentaLayout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
            .addGroup(jPanelEliminarCuentaLayout.createSequentialGroup()
                .addGroup(jPanelEliminarCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEliminarCuentaLayout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(jLabel12))
                    .addGroup(jPanelEliminarCuentaLayout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(jLabel2))
                    .addGroup(jPanelEliminarCuentaLayout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jLabel3)
                        .addGap(27, 27, 27)
                        .addComponent(jTextFieldNroCuentaEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelEliminarCuentaLayout.setVerticalGroup(
            jPanelEliminarCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEliminarCuentaLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelEliminarCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNroCuentaEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(29, 29, 29)
                .addGroup(jPanelEliminarCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEliminarCuenta)
                    .addComponent(jButtonCancelarEliminar))
                .addGap(41, 41, 41))
        );

        jPanel3.add(jPanelEliminarCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(45, 45, 45))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(57, 57, 57))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCrearCuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearCuActionPerformed
        jPanelCrearCuenta.setVisible(true);
        jPanelEliminarCuenta.setVisible(false);
    }//GEN-LAST:event_jButtonCrearCuActionPerformed

    private void jButtonIngresarCuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIngresarCuActionPerformed
        try {
            JFBancoIngresarYMostrar jfciym= new JFBancoIngresarYMostrar();
            if(jLabelPichincha.isVisible()){
                jfciym.jLabelPichincha.setVisible(true);
                jfciym.jPanel1.setBackground(Color.yellow);
            }
            else if(jLabelGuayaquil.isVisible()){
                jfciym.jLabelGuayaquil.setVisible(true);
                jfciym.jPanel1.setBackground(Color.cyan);
            }
            else if(jLabelPacifico.isVisible()){
                jfciym.jLabelPacifico.setVisible(true);
                jfciym.jPanel1.setBackground(Color.cyan);
            }
            else{
                jfciym.jLabelBolivariano.setVisible(true);
                jfciym.jPanel1.setBackground(Color.green);
            }
            jfciym.llenartabla(jfciym.jTableIngresarACuenta);
            jfciym.jPanelIngresarCuenta.setVisible(true);
            jfciym.jPanelIngresar.setVisible(true);
            this.setVisible(false);
            jfciym.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(JFBancoCrearYEliminar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonIngresarCuActionPerformed

    private void jButtonEliminarCuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarCuActionPerformed
        jPanelCrearCuenta.setVisible(false);
        try {
            llenartabla(jTableEliminarCuenta);
        } catch (SQLException ex) {
            Logger.getLogger(JFBancoCrearYEliminar.class.getName()).log(Level.SEVERE, null, ex);
        }
        jPanelEliminarCuenta.setVisible(true);
    }//GEN-LAST:event_jButtonEliminarCuActionPerformed

    private void jButtonCrearCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearCuentaActionPerformed
        try {
            DefaultTableModel modelo = (DefaultTableModel) jTableClientes.getModel();
            int num=jTableClientes.getSelectedRow();
            String idCuenta=Integer.toString(ultimoIDcuentas());
            String idCliente=(String)modelo.getValueAt(num, 0);
            String idBanco= Integer.toString(devolverIDBanco());
            String nroCuenta= jTextFieldNroCrear.getText();
            String fondos= "0";
            String fechaApertura=Calendar.YEAR+"-"+Calendar.MONTH+"-"+Calendar.DATE;
            DataBaseConnection dbInstance = DataBaseConnection.getInstance();
            Connection connection = dbInstance.getConnection();
            String sql = "exec cuenta_insert "+idCuenta+","+idCliente+","+idBanco+
                    ",'"+nroCuenta+"','"+fondos+"','"+fechaApertura+"' ;";
            PreparedStatement prepsInsertCuenta = connection.prepareStatement(sql);
            prepsInsertCuenta.execute();
            JOptionPane.showMessageDialog(null, "Cuenta creada correctamente");
        } catch (SQLException ex) {
            Logger.getLogger(JFBancoCrearYEliminar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonCrearCuentaActionPerformed

    private void jButtonEliminarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarCuentaActionPerformed
        int opcion=JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar la cuenta?", "Eliminar Cuenta", JOptionPane.YES_NO_OPTION);
        if(opcion==0){
            try {
                String numCuenta=jTextFieldNroCuentaEliminar.getText();
                DataBaseConnection dbInstance = DataBaseConnection.getInstance();
                Connection connection = dbInstance.getConnection();
                String sql = "DELETE from CUENTABANCARIA WHERE NUMERODECUENTA='"+numCuenta+"';";
                PreparedStatement prepsDeleteCuenta = connection.prepareStatement(sql);
                prepsDeleteCuenta.execute();
                JOptionPane.showMessageDialog(null, "Cuenta eliminada correctamente");
                llenartabla(jTableEliminarCuenta);
            } catch (SQLException ex) {
                Logger.getLogger(JFBancoCrearYEliminar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            return;
        }
    }//GEN-LAST:event_jButtonEliminarCuentaActionPerformed

    private void jButtonMostrarCuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMostrarCuActionPerformed
        try {
            JFBancoIngresarYMostrar jfciym= new JFBancoIngresarYMostrar();
            if(jLabelPichincha.isVisible()){
                jfciym.jLabelPichincha.setVisible(true);
                jfciym.jPanel1.setBackground(Color.yellow);
            }
            else if(jLabelGuayaquil.isVisible()){
                jfciym.jLabelGuayaquil.setVisible(true);
                jfciym.jPanel1.setBackground(Color.cyan);
            }
            else if(jLabelPacifico.isVisible()){
                jfciym.jLabelPacifico.setVisible(true);
                jfciym.jPanel1.setBackground(Color.cyan);
            }
            else{
                jfciym.jLabelBolivariano.setVisible(true);
                jfciym.jPanel1.setBackground(Color.green);
            }
            jfciym.llenartabla(jfciym.jTableCuentasCreadas);
            jfciym.jPanelCuentas.setVisible(true);
            this.setVisible(false);
            jfciym.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(JFBancoCrearYEliminar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonMostrarCuActionPerformed

    private void jButtonCancelarEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarEliminarActionPerformed
        jPanelEliminarCuenta.setVisible(false);
    }//GEN-LAST:event_jButtonCancelarEliminarActionPerformed

    private void jButtonCancelarCreacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarCreacionActionPerformed
        jTextFieldCedulaCrear.setText("");
        jTextFieldNombresCrear.setText("");
        jTextFieldNroCrear.setText("");
        jPanelCrearCuenta.setVisible(false);
    }//GEN-LAST:event_jButtonCancelarCreacionActionPerformed

    private void jTableClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClientesMouseClicked
        DefaultTableModel modelo = (DefaultTableModel) jTableClientes.getModel();
        int num=jTableClientes.getSelectedRow();
        jTextFieldNombresCrear.setText((String)modelo.getValueAt(num, 1));
        jTextFieldCedulaCrear.setText((String)modelo.getValueAt(num, 2));
    }//GEN-LAST:event_jTableClientesMouseClicked

    private void jTableEliminarCuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEliminarCuentaMouseClicked
        DefaultTableModel modelo = (DefaultTableModel) jTableEliminarCuenta.getModel();
        int num = jTableEliminarCuenta.getSelectedRow();
        jTextFieldNroCuentaEliminar.setText((String)modelo.getValueAt(num, 2));
    }//GEN-LAST:event_jTableEliminarCuentaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFBancoCrearYEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFBancoCrearYEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFBancoCrearYEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFBancoCrearYEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFBancoCrearYEliminar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelarCreacion;
    private javax.swing.JButton jButtonCancelarEliminar;
    private javax.swing.JButton jButtonCrearCu;
    private javax.swing.JButton jButtonCrearCuenta;
    private javax.swing.JButton jButtonEliminarCu;
    private javax.swing.JButton jButtonEliminarCuenta;
    private javax.swing.JButton jButtonIngresarCu;
    private javax.swing.JButton jButtonMostrarCu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JLabel jLabelBolivariano;
    public javax.swing.JLabel jLabelGuayaquil;
    public javax.swing.JLabel jLabelPacifico;
    public javax.swing.JLabel jLabelPichincha;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanelCrearCuenta;
    public javax.swing.JPanel jPanelEliminarCuenta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTable jTableClientes;
    public javax.swing.JTable jTableEliminarCuenta;
    private javax.swing.JTextField jTextFieldCedulaCrear;
    private javax.swing.JTextField jTextFieldNombresCrear;
    private javax.swing.JTextField jTextFieldNroCrear;
    private javax.swing.JTextField jTextFieldNroCuentaEliminar;
    // End of variables declaration//GEN-END:variables
}
