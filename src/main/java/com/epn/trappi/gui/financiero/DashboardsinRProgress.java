
package com.epn.trappi.gui.financiero;

import com.epn.trappi.models.financiero.Analizador;

public class DashboardsinRProgress extends javax.swing.JFrame {
    Analizador analizador;
    public DashboardsinRProgress() {
        initComponents();
        this.panelGastos.setVisible(false);
        this.panelDashboard.setVisible(false);
      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelVerticalIzquierdo = new javax.swing.JPanel();
        btndashboardgastos = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btndashboardgeneral = new javax.swing.JPanel();
        lableGeneralDashboard = new javax.swing.JLabel();
        btndashboardingresos = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnDashboardSalir = new javax.swing.JPanel();
        labelDashboardSalir = new javax.swing.JLabel();
        panelHorizontalCabecera = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        panelDespliegue = new javax.swing.JPanel();
        panelDashboard = new javax.swing.JPanel();
        panelIngresos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        panelGastos = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelVerticalIzquierdo.setBackground(new java.awt.Color(51, 51, 51));
        panelVerticalIzquierdo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btndashboardgastos.setOpaque(false);
        btndashboardgastos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btndashboardgastosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btndashboardgastosMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btndashboardgastosMousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Semilight", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/epn/trappi/gui/financiero/imagenesFinanciero/icons8_receive_cash_32px.png"))); // NOI18N
        jLabel4.setText("Gastos");

        javax.swing.GroupLayout btndashboardgastosLayout = new javax.swing.GroupLayout(btndashboardgastos);
        btndashboardgastos.setLayout(btndashboardgastosLayout);
        btndashboardgastosLayout.setHorizontalGroup(
            btndashboardgastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btndashboardgastosLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        btndashboardgastosLayout.setVerticalGroup(
            btndashboardgastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelVerticalIzquierdo.add(btndashboardgastos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 180, 30));

        btndashboardgeneral.setOpaque(false);
        btndashboardgeneral.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btndashboardgeneralMouseMoved(evt);
            }
        });
        btndashboardgeneral.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btndashboardgeneralMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btndashboardgeneralMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btndashboardgeneralMousePressed(evt);
            }
        });

        lableGeneralDashboard.setBackground(new java.awt.Color(135, 139, 145));
        lableGeneralDashboard.setFont(new java.awt.Font("Segoe UI Semilight", 1, 12)); // NOI18N
        lableGeneralDashboard.setForeground(new java.awt.Color(255, 255, 255));
        lableGeneralDashboard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lableGeneralDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/epn/trappi/gui/financiero/imagenesFinanciero/icons8_increase_32px.png"))); // NOI18N
        lableGeneralDashboard.setText("Dashboard");

        javax.swing.GroupLayout btndashboardgeneralLayout = new javax.swing.GroupLayout(btndashboardgeneral);
        btndashboardgeneral.setLayout(btndashboardgeneralLayout);
        btndashboardgeneralLayout.setHorizontalGroup(
            btndashboardgeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btndashboardgeneralLayout.createSequentialGroup()
                .addComponent(lableGeneralDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        btndashboardgeneralLayout.setVerticalGroup(
            btndashboardgeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btndashboardgeneralLayout.createSequentialGroup()
                .addComponent(lableGeneralDashboard)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelVerticalIzquierdo.add(btndashboardgeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 180, 30));

        btndashboardingresos.setOpaque(false);
        btndashboardingresos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btndashboardingresosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btndashboardingresosMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btndashboardingresosMousePressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Semilight", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/epn/trappi/gui/financiero/imagenesFinanciero/icons8_money_pound_32px.png"))); // NOI18N
        jLabel6.setText("Ingresos");

        javax.swing.GroupLayout btndashboardingresosLayout = new javax.swing.GroupLayout(btndashboardingresos);
        btndashboardingresos.setLayout(btndashboardingresosLayout);
        btndashboardingresosLayout.setHorizontalGroup(
            btndashboardingresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btndashboardingresosLayout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        btndashboardingresosLayout.setVerticalGroup(
            btndashboardingresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btndashboardingresosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6))
        );

        panelVerticalIzquierdo.add(btndashboardingresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 180, 30));

        btnDashboardSalir.setOpaque(false);
        btnDashboardSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDashboardSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDashboardSalirMouseExited(evt);
            }
        });

        labelDashboardSalir.setFont(new java.awt.Font("Segoe UI Semilight", 1, 12)); // NOI18N
        labelDashboardSalir.setForeground(new java.awt.Color(255, 255, 255));
        labelDashboardSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDashboardSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/epn/trappi/gui/financiero/imagenesFinanciero/icons8_left_20px.png"))); // NOI18N
        labelDashboardSalir.setText("Salir");

        javax.swing.GroupLayout btnDashboardSalirLayout = new javax.swing.GroupLayout(btnDashboardSalir);
        btnDashboardSalir.setLayout(btnDashboardSalirLayout);
        btnDashboardSalirLayout.setHorizontalGroup(
            btnDashboardSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnDashboardSalirLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelDashboardSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnDashboardSalirLayout.setVerticalGroup(
            btnDashboardSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnDashboardSalirLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelDashboardSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelVerticalIzquierdo.add(btnDashboardSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 180, 30));

        jPanel1.add(panelVerticalIzquierdo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 180, 690));

        panelHorizontalCabecera.setBackground(new java.awt.Color(51, 51, 51));
        panelHorizontalCabecera.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LOGOtrappi.jpeg"))); // NOI18N
        panelHorizontalCabecera.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 90));

        jLabel8.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/epn/trappi/gui/financiero/imagenesFinanciero/LOGOtrappi.jpeg"))); // NOI18N
        panelHorizontalCabecera.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 90));

        jPanel1.add(panelHorizontalCabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 90));

        panelDespliegue.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout panelDashboardLayout = new javax.swing.GroupLayout(panelDashboard);
        panelDashboard.setLayout(panelDashboardLayout);
        panelDashboardLayout.setHorizontalGroup(
            panelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1190, Short.MAX_VALUE)
        );
        panelDashboardLayout.setVerticalGroup(
            panelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
        );

        panelDespliegue.add(panelDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 690));

        panelIngresos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        panelIngresos.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 890, 360));
        panelIngresos.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 40, -1));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        panelIngresos.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 40, -1));
        panelIngresos.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 140, 60, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel1.setText("Día:");
        panelIngresos.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel2.setText("Mes:");
        panelIngresos.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, 30, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel3.setText("Año:");
        panelIngresos.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 140, 40, 20));

        jButton1.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jButton1.setText("Consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelIngresos.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 140, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel5.setText("Ingresos del: ");
        panelIngresos.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, -1, -1));

        panelDespliegue.add(panelIngresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 690));

        panelGastos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        panelGastos.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 730, 460));

        jLabel11.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel11.setText("Gastos del: ");
        panelGastos.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel12.setText("Día:");
        panelGastos.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel13.setText("Mes:");
        panelGastos.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, 30, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel14.setText("Año:");
        panelGastos.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 120, 40, 20));
        panelGastos.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 40, -1));

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        panelGastos.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, 40, -1));
        panelGastos.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 120, 60, -1));

        jButton2.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jButton2.setText("Consultar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panelGastos.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 110, 90, 40));

        panelDespliegue.add(panelGastos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 690));

        jPanel1.add(panelDespliegue, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 1190, 690));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btndashboardgastosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndashboardgastosMouseEntered
        btndashboardgastos.setBackground(new java.awt.Color(135,139,145));
        btndashboardgastos.setOpaque(true);
    }//GEN-LAST:event_btndashboardgastosMouseEntered

    private void btndashboardgastosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndashboardgastosMouseExited
        this.btndashboardgastos.setBackground(new java.awt.Color(49,58,73));
        this.btndashboardgastos.setOpaque(false);
    }//GEN-LAST:event_btndashboardgastosMouseExited

    private void btndashboardgeneralMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndashboardgeneralMouseMoved

    }//GEN-LAST:event_btndashboardgeneralMouseMoved

    private void btndashboardgeneralMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndashboardgeneralMouseEntered
        btndashboardgeneral.setBackground(new java.awt.Color(135,139,145));
        btndashboardgeneral.setOpaque(true);
    }//GEN-LAST:event_btndashboardgeneralMouseEntered

    private void btndashboardgeneralMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndashboardgeneralMouseExited
        this.btndashboardgeneral.setBackground(new java.awt.Color(49,58,73));
        this.btndashboardgeneral.setOpaque(false);
    }//GEN-LAST:event_btndashboardgeneralMouseExited

    private void btndashboardgeneralMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndashboardgeneralMousePressed
        this.panelDashboard.setVisible(true);
        this.panelGastos.setVisible(false);
        this.panelIngresos.setVisible(false);
    }//GEN-LAST:event_btndashboardgeneralMousePressed

    private void btndashboardingresosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndashboardingresosMouseEntered
        btndashboardingresos.setBackground(new java.awt.Color(135,139,145));
        btndashboardingresos.setOpaque(true);
    }//GEN-LAST:event_btndashboardingresosMouseEntered

    private void btndashboardingresosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndashboardingresosMouseExited
        this.btndashboardingresos.setBackground(new java.awt.Color(49,58,73));
        this.btndashboardingresos.setOpaque(false);
    }//GEN-LAST:event_btndashboardingresosMouseExited

    private void btnDashboardSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDashboardSalirMouseEntered
        btnDashboardSalir.setBackground(new java.awt.Color(135,139,145));
        btnDashboardSalir.setOpaque(true);
    }//GEN-LAST:event_btnDashboardSalirMouseEntered

    private void btnDashboardSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDashboardSalirMouseExited
        this.btnDashboardSalir.setBackground(new java.awt.Color(49,58,73));
        this.btnDashboardSalir.setOpaque(false);
    }//GEN-LAST:event_btnDashboardSalirMouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btndashboardgastosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndashboardgastosMousePressed
        this.panelIngresos.setVisible(false);
        this.panelGastos.setVisible(true);
        this.panelDashboard.setVisible(false);
    }//GEN-LAST:event_btndashboardgastosMousePressed

    private void btndashboardingresosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndashboardingresosMousePressed
        this.panelIngresos.setVisible(true);
        this.panelGastos.setVisible(false);
        this.panelDashboard.setVisible(false);
    }//GEN-LAST:event_btndashboardingresosMousePressed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardsinRProgress().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnDashboardSalir;
    private javax.swing.JPanel btndashboardgastos;
    private javax.swing.JPanel btndashboardgeneral;
    private javax.swing.JPanel btndashboardingresos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel labelDashboardSalir;
    private javax.swing.JLabel lableGeneralDashboard;
    private javax.swing.JPanel panelDashboard;
    private javax.swing.JPanel panelDespliegue;
    private javax.swing.JPanel panelGastos;
    private javax.swing.JPanel panelHorizontalCabecera;
    private javax.swing.JPanel panelIngresos;
    private javax.swing.JPanel panelVerticalIzquierdo;
    // End of variables declaration//GEN-END:variables
}
