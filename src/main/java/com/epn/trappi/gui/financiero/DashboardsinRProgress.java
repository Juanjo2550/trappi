
package com.epn.trappi.gui.financiero;

import com.epn.trappi.models.financiero.Analizador;

public class DashboardsinRProgress extends javax.swing.JFrame {
    Analizador analizador;
    public DashboardsinRProgress() {
        initComponents();
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
        btnDashboardSalir = new javax.swing.JPanel();
        labelDashboardSalir = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panelHorizontalCabecera = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        panelDespliegue = new javax.swing.JPanel();
        panelIngresos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

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
        });

        javax.swing.GroupLayout btndashboardingresosLayout = new javax.swing.GroupLayout(btndashboardingresos);
        btndashboardingresos.setLayout(btndashboardingresosLayout);
        btndashboardingresosLayout.setHorizontalGroup(
            btndashboardingresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        btndashboardingresosLayout.setVerticalGroup(
            btndashboardingresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
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

        jLabel6.setFont(new java.awt.Font("Segoe UI Semilight", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/epn/trappi/gui/financiero/imagenesFinanciero/icons8_money_pound_32px.png"))); // NOI18N
        jLabel6.setText("Ingresos");
        panelVerticalIzquierdo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 180, -1));

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

        panelDespliegue.add(panelIngresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 690));

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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelDashboardSalir;
    private javax.swing.JLabel lableGeneralDashboard;
    private javax.swing.JPanel panelDespliegue;
    private javax.swing.JPanel panelHorizontalCabecera;
    private javax.swing.JPanel panelIngresos;
    private javax.swing.JPanel panelVerticalIzquierdo;
    // End of variables declaration//GEN-END:variables
}
