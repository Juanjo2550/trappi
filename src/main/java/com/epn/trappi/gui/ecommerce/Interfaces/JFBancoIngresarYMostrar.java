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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andres
 */
public class JFBancoIngresarYMostrar extends javax.swing.JFrame {

    public JFBancoIngresarYMostrar() {
        initComponents();
        this.setSize(1024, 700);
        this.setLocationRelativeTo(null);
        jLabelBolivariano.setVisible(false);
        jLabelPacifico.setVisible(false);
        jLabelPichincha.setVisible(false);
        jLabelGuayaquil.setVisible(false);
        jPanelMovimientosCuenta.setVisible(false);
        jPanelIngresarCuenta.setVisible(false);
        jPanelIngresar.setVisible(false);
        jPanelCuentas.setVisible(false);
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
        jPanelIngresarCuenta = new javax.swing.JPanel();
        jPanelMovimientosCuenta = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldNombreMovimientos = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jButtonAcreditar = new javax.swing.JButton();
        jTextFieldCantidadAAcreditar = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jTextFieldSaldoAcreditar = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jButtonDebitar = new javax.swing.JButton();
        jTextFieldCantidadADebitar = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jTextFieldSaldoDebitar = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jPanelIngresar = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jButtonIngresarCuenta = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableIngresarACuenta = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNroCuentaIngresar = new javax.swing.JTextField();
        jPanelCuentas = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCuentasCreadas = new javax.swing.JTable();
        jButton13 = new javax.swing.JButton();

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

        jPanelIngresarCuenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel16.setText("Bienvenido/a:");

        jTextFieldNombreMovimientos.setEditable(false);
        jTextFieldNombreMovimientos.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jTextFieldNombreMovimientos.setText("Aqui va nombre");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Cantidad:");

        jButtonAcreditar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonAcreditar.setText("Acreditar");
        jButtonAcreditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcreditarActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Saldo actual:");

        jTextFieldSaldoAcreditar.setEditable(false);
        jTextFieldSaldoAcreditar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldSaldoAcreditar.setText("Aqui va el saldo");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel25.setText("$");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(22, 22, 22)
                        .addComponent(jTextFieldSaldoAcreditar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel25)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonAcreditar)
                            .addComponent(jTextFieldCantidadAAcreditar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(131, 131, 131))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jTextFieldSaldoAcreditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addGap(46, 46, 46)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jTextFieldCantidadAAcreditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addComponent(jButtonAcreditar)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Acreditar", jPanel9);

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Cantidad:");

        jButtonDebitar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonDebitar.setText("Debitar");
        jButtonDebitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDebitarActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("Saldo actual:");

        jTextFieldSaldoDebitar.setEditable(false);
        jTextFieldSaldoDebitar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldSaldoDebitar.setText("Aqui va el saldo");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel27.setText("$");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(22, 22, 22)
                        .addComponent(jTextFieldSaldoDebitar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel27)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonDebitar)
                            .addComponent(jTextFieldCantidadADebitar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(131, 131, 131))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jTextFieldSaldoDebitar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addGap(45, 45, 45)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jTextFieldCantidadADebitar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addComponent(jButtonDebitar)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Debitar", jPanel10);

        jButton11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton11.setText("Salir");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMovimientosCuentaLayout = new javax.swing.GroupLayout(jPanelMovimientosCuenta);
        jPanelMovimientosCuenta.setLayout(jPanelMovimientosCuentaLayout);
        jPanelMovimientosCuentaLayout.setHorizontalGroup(
            jPanelMovimientosCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMovimientosCuentaLayout.createSequentialGroup()
                .addGroup(jPanelMovimientosCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMovimientosCuentaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelMovimientosCuentaLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldNombreMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelMovimientosCuentaLayout.setVerticalGroup(
            jPanelMovimientosCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMovimientosCuentaLayout.createSequentialGroup()
                .addGroup(jPanelMovimientosCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMovimientosCuentaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelMovimientosCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jTextFieldNombreMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelMovimientosCuentaLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jButton11)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelIngresarCuenta.add(jPanelMovimientosCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 530, 370));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel9.setText("Ingresar a Cuenta");

        jButtonIngresarCuenta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonIngresarCuenta.setText("Ingresar");
        jButtonIngresarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIngresarCuentaActionPerformed(evt);
            }
        });

        jTableIngresarACuenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombres", "Cedula", "Nro. Cuenta", "Entidad"
            }
        ));
        jTableIngresarACuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableIngresarACuentaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTableIngresarACuenta);

        jLabel3.setText("Seleccione la cuenta que desee ingresar y pulse Ingresar");

        jLabel4.setText("Nro. Cuenta:");

        jTextFieldNroCuentaIngresar.setEditable(false);
        jTextFieldNroCuentaIngresar.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanelIngresarLayout = new javax.swing.GroupLayout(jPanelIngresar);
        jPanelIngresar.setLayout(jPanelIngresarLayout);
        jPanelIngresarLayout.setHorizontalGroup(
            jPanelIngresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIngresarLayout.createSequentialGroup()
                .addGroup(jPanelIngresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelIngresarLayout.createSequentialGroup()
                        .addContainerGap(19, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelIngresarLayout.createSequentialGroup()
                        .addGroup(jPanelIngresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelIngresarLayout.createSequentialGroup()
                                .addGap(175, 175, 175)
                                .addComponent(jLabel9))
                            .addGroup(jPanelIngresarLayout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(jLabel3))
                            .addGroup(jPanelIngresarLayout.createSequentialGroup()
                                .addGap(212, 212, 212)
                                .addComponent(jButtonIngresarCuenta)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanelIngresarLayout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jLabel4)
                .addGap(27, 27, 27)
                .addComponent(jTextFieldNroCuentaIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelIngresarLayout.setVerticalGroup(
            jPanelIngresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIngresarLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanelIngresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNroCuentaIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonIngresarCuenta)
                .addContainerGap())
        );

        jPanelIngresarCuenta.add(jPanelIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 550, 400));

        jPanel3.add(jPanelIngresarCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 480));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Cuentas Creadas");

        jTableCuentasCreadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombres", "Cedula", "Nro. Cuenta", "Entidad"
            }
        ));
        jScrollPane2.setViewportView(jTableCuentasCreadas);

        jButton13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton13.setText("Cerrar");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCuentasLayout = new javax.swing.GroupLayout(jPanelCuentas);
        jPanelCuentas.setLayout(jPanelCuentasLayout);
        jPanelCuentasLayout.setHorizontalGroup(
            jPanelCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCuentasLayout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
            .addGroup(jPanelCuentasLayout.createSequentialGroup()
                .addGroup(jPanelCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCuentasLayout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(jLabel1))
                    .addGroup(jPanelCuentasLayout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelCuentasLayout.setVerticalGroup(
            jPanelCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCuentasLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanelCuentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 630, 430));

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
        JFBancoCrearYEliminar jfcye= new JFBancoCrearYEliminar();
        if(jLabelPichincha.isVisible()){
            jfcye.jLabelPichincha.setVisible(true);
            jfcye.jPanel1.setBackground(Color.yellow);
        }
        else if(jLabelGuayaquil.isVisible()){
            jfcye.jLabelGuayaquil.setVisible(true);
            jfcye.jPanel1.setBackground(Color.cyan);
        }
        else if(jLabelPacifico.isVisible()){
            jfcye.jLabelPacifico.setVisible(true);
            jfcye.jPanel1.setBackground(Color.cyan);
        }
        else{
            jfcye.jLabelBolivariano.setVisible(true);
            jfcye.jPanel1.setBackground(Color.green);
        }
        jfcye.jPanelCrearCuenta.setVisible(true);
        this.setVisible(false);
        jfcye.setVisible(true);
    }//GEN-LAST:event_jButtonCrearCuActionPerformed

    private void jButtonIngresarCuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIngresarCuActionPerformed
        jPanelIngresarCuenta.setVisible(true);
        jPanelIngresar.setVisible(true);
        try {
            llenartabla(jTableIngresarACuenta);
        } catch (SQLException ex) {
            Logger.getLogger(JFBancoIngresarYMostrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        jPanelMovimientosCuenta.setVisible(false);
        jPanelCuentas.setVisible(false);
    }//GEN-LAST:event_jButtonIngresarCuActionPerformed

    private void jButtonEliminarCuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarCuActionPerformed
        try {
            JFBancoCrearYEliminar jfcye= new JFBancoCrearYEliminar();
            if(jLabelPichincha.isVisible()){
                jfcye.jLabelPichincha.setVisible(true);
                jfcye.jPanel1.setBackground(Color.yellow);
            }
            else if(jLabelGuayaquil.isVisible()){
                jfcye.jLabelGuayaquil.setVisible(true);
                jfcye.jPanel1.setBackground(Color.cyan);
            }
            else if(jLabelPacifico.isVisible()){
                jfcye.jLabelPacifico.setVisible(true);
                jfcye.jPanel1.setBackground(Color.cyan);
            }
            else{
                jfcye.jLabelBolivariano.setVisible(true);
                jfcye.jPanel1.setBackground(Color.green);
            }
            jfcye.llenartabla(jfcye.jTableEliminarCuenta);
            jfcye.jPanelEliminarCuenta.setVisible(true);
            this.setVisible(false);
            jfcye.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(JFBancoIngresarYMostrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonEliminarCuActionPerformed

    private void jButtonMostrarCuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMostrarCuActionPerformed
        jPanelIngresarCuenta.setVisible(false);
        jPanelIngresar.setVisible(false);
        jPanelMovimientosCuenta.setVisible(false);
        try {
            llenartabla(jTableCuentasCreadas);
        } catch (SQLException ex) {
            Logger.getLogger(JFBancoIngresarYMostrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        jPanelCuentas.setVisible(true);
    }//GEN-LAST:event_jButtonMostrarCuActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        jPanelIngresar.setVisible(true);
        jTextFieldNroCuentaIngresar.setText("");
        jPanelMovimientosCuenta.setVisible(false);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButtonIngresarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIngresarCuentaActionPerformed
        try {
            jPanelIngresar.setVisible(false);
            String NroCuenta=jTextFieldNroCuentaIngresar.getText();
            DataBaseConnection dbInstance = DataBaseConnection.getInstance();
            Connection connection = dbInstance.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT C.NOMBRECLIE, CB.FONDOS FROM CUENTABANCARIA CB, CLIENTES C "
                    + "WHERE CB.IDCLIENTE=C.IDCLIENTE AND NUMERODECUENTA='"+NroCuenta+"';";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                jTextFieldNombreMovimientos.setText(resultSet.getString(1));
                jTextFieldSaldoAcreditar.setText(resultSet.getString(2));
                jTextFieldSaldoDebitar.setText(resultSet.getString(2));
            }
            jPanelMovimientosCuenta.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(JFBancoIngresarYMostrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonIngresarCuentaActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        jPanelCuentas.setVisible(false);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jTableIngresarACuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableIngresarACuentaMouseClicked
        DefaultTableModel modelo=(DefaultTableModel) jTableIngresarACuenta.getModel();
        int num= jTableIngresarACuenta.getSelectedRow();
        jTextFieldNroCuentaIngresar.setText((String) modelo.getValueAt(num, 2));
    }//GEN-LAST:event_jTableIngresarACuentaMouseClicked

    private void jButtonAcreditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAcreditarActionPerformed
        try {
            int fondos=Integer.parseInt(jTextFieldSaldoAcreditar.getText())+Integer.parseInt(jTextFieldCantidadAAcreditar.getText());
            DataBaseConnection dbInstance = DataBaseConnection.getInstance();
            Connection connection = dbInstance.getConnection();
            String NroCuenta=jTextFieldNroCuentaIngresar.getText();
            String sql ="Update CUENTABANCARIA SET FONDOS='"+fondos+"' where NUMERODECUENTA='"+NroCuenta+"';";
            PreparedStatement prepsAcreditar = connection.prepareStatement(sql);
            prepsAcreditar.execute();
            JOptionPane.showMessageDialog(null, "Fondos Acreditados Correctamente");
            Statement statement = connection.createStatement();
            sql = "SELECT FONDOS FROM CUENTABANCARIA"
                    + " WHERE NUMERODECUENTA='"+NroCuenta+"';";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                jTextFieldSaldoAcreditar.setText(resultSet.getString(1));
                jTextFieldSaldoDebitar.setText(resultSet.getString(1));
            }
            jTextFieldCantidadAAcreditar.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(JFBancoIngresarYMostrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonAcreditarActionPerformed

    private void jButtonDebitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDebitarActionPerformed
        try {
            int fondos=Integer.parseInt(jTextFieldSaldoDebitar.getText())-Integer.parseInt(jTextFieldCantidadADebitar.getText());
            DataBaseConnection dbInstance = DataBaseConnection.getInstance();
            Connection connection = dbInstance.getConnection();
            String NroCuenta=jTextFieldNroCuentaIngresar.getText();
            String sql ="Update CUENTABANCARIA SET FONDOS='"+fondos+"' where NUMERODECUENTA='"+NroCuenta+"';";
            PreparedStatement prepsAcreditar = connection.prepareStatement(sql);
            prepsAcreditar.execute();
            JOptionPane.showMessageDialog(null, "Fondos Debitados Correctamente");
            Statement statement = connection.createStatement();
            sql = "SELECT FONDOS FROM CUENTABANCARIA"
                    + " WHERE NUMERODECUENTA='"+NroCuenta+"';";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                jTextFieldSaldoAcreditar.setText(resultSet.getString(1));
                jTextFieldSaldoDebitar.setText(resultSet.getString(1));
            }
            jTextFieldCantidadADebitar.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(JFBancoIngresarYMostrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonDebitarActionPerformed

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
            java.util.logging.Logger.getLogger(JFBancoIngresarYMostrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFBancoIngresarYMostrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFBancoIngresarYMostrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFBancoIngresarYMostrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFBancoIngresarYMostrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButtonAcreditar;
    private javax.swing.JButton jButtonCrearCu;
    private javax.swing.JButton jButtonDebitar;
    private javax.swing.JButton jButtonEliminarCu;
    private javax.swing.JButton jButtonIngresarCu;
    private javax.swing.JButton jButtonIngresarCuenta;
    private javax.swing.JButton jButtonMostrarCu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JLabel jLabelBolivariano;
    public javax.swing.JLabel jLabelGuayaquil;
    public javax.swing.JLabel jLabelPacifico;
    public javax.swing.JLabel jLabelPichincha;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel9;
    public javax.swing.JPanel jPanelCuentas;
    public javax.swing.JPanel jPanelIngresar;
    public javax.swing.JPanel jPanelIngresarCuenta;
    private javax.swing.JPanel jPanelMovimientosCuenta;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JTable jTableCuentasCreadas;
    public javax.swing.JTable jTableIngresarACuenta;
    private javax.swing.JTextField jTextFieldCantidadAAcreditar;
    private javax.swing.JTextField jTextFieldCantidadADebitar;
    private javax.swing.JTextField jTextFieldNombreMovimientos;
    private javax.swing.JTextField jTextFieldNroCuentaIngresar;
    private javax.swing.JTextField jTextFieldSaldoAcreditar;
    private javax.swing.JTextField jTextFieldSaldoDebitar;
    // End of variables declaration//GEN-END:variables
}
