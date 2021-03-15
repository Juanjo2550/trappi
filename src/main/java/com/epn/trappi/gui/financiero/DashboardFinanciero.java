
package com.epn.trappi.gui.financiero;

import com.epn.trappi.Menu_Trappi;
import com.epn.trappi.db.financiero.FinancieroDb;
import com.epn.trappi.models.financiero.Analizador;
import com.epn.trappi.models.financiero.Devolucion;
import com.epn.trappi.models.financiero.Ingreso;
import com.epn.trappi.models.financiero.Pago;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class DashboardFinanciero extends javax.swing.JFrame {
    Analizador analizador;
    public DashboardFinanciero() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.panelGastos.setVisible(false);
        this.panelDashboard.setVisible(false);
        this.panelIngresos.setVisible(false);
        this.panelDevoluciones.setVisible(false);
        this.mostrarTablaIngresos();
      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelVerticalIzquierdo = new javax.swing.JPanel();
        btndashboarddevoluciones = new javax.swing.JPanel();
        labelDevoluciones = new javax.swing.JLabel();
        btndashboardingresos = new javax.swing.JPanel();
        labelIngresos = new javax.swing.JLabel();
        btnDashboardSalir = new javax.swing.JPanel();
        labelDashboardSalir = new javax.swing.JLabel();
        btndashboardgastos = new javax.swing.JPanel();
        labelGastos1 = new javax.swing.JLabel();
        btndashboardgeneral = new javax.swing.JPanel();
        lableGeneralDashboard = new javax.swing.JLabel();
        labelLogoFinanciero = new javax.swing.JLabel();
        panelDespliegue = new javax.swing.JPanel();
        panelDevoluciones = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtDiaDevolucion = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtMesDevolucion = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtAnioDevolucion = new javax.swing.JTextField();
        btnConsultarDevolucionesporFecha = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaDevoluciones = new javax.swing.JTable();
        panelDashboard = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        panelCircular = new javax.swing.JPanel();
        panelBarrasGastos = new javax.swing.JPanel();
        panelBarrasIngresos = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        labelIngresosTotales = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        labelGastosTotales = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        labelPresupuesto = new javax.swing.JLabel();
        panelBarrasDevoluciones = new javax.swing.JPanel();
        labelDevolucionesDashboard = new javax.swing.JLabel();
        labelDevolucionesTotal = new javax.swing.JLabel();
        panelIngresos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaIngresos = new javax.swing.JTable();
        txtDiaIngreso = new javax.swing.JTextField();
        txtMesIngreso = new javax.swing.JTextField();
        txtAnioIngreso = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnConsultarIngresosporFecha = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        panelGastos = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaGastos = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtDiaGasto = new javax.swing.JTextField();
        txtMesGasto = new javax.swing.JTextField();
        txtAnioGasto = new javax.swing.JTextField();
        btnConsultarGastosporFecha = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelVerticalIzquierdo.setBackground(new java.awt.Color(61, 57, 57));
        panelVerticalIzquierdo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btndashboarddevoluciones.setBackground(new java.awt.Color(255, 210, 28));
        btndashboarddevoluciones.setOpaque(false);
        btndashboarddevoluciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btndashboarddevolucionesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btndashboarddevolucionesMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btndashboarddevolucionesMousePressed(evt);
            }
        });
        btndashboarddevoluciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelDevoluciones.setBackground(new java.awt.Color(255, 210, 28));
        labelDevoluciones.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        labelDevoluciones.setForeground(new java.awt.Color(255, 255, 255));
        labelDevoluciones.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelDevoluciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/epn/trappi/gui/financiero/imagenesFinanciero/icons8_cash_in_hand_32px.png"))); // NOI18N
        labelDevoluciones.setText("Devoluciones");
        btndashboarddevoluciones.add(labelDevoluciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 150, 40));

        panelVerticalIzquierdo.add(btndashboarddevoluciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 150, 40));

        btndashboardingresos.setBackground(new java.awt.Color(255, 210, 28));
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
        btndashboardingresos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelIngresos.setBackground(new java.awt.Color(255, 210, 28));
        labelIngresos.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        labelIngresos.setForeground(new java.awt.Color(255, 255, 255));
        labelIngresos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelIngresos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/epn/trappi/gui/financiero/imagenesFinanciero/icons8_money_pound_32px.png"))); // NOI18N
        labelIngresos.setText("Ingresos");
        btndashboardingresos.add(labelIngresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 150, 41));

        panelVerticalIzquierdo.add(btndashboardingresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 160, 41));

        btnDashboardSalir.setOpaque(false);
        btnDashboardSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDashboardSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDashboardSalirMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnDashboardSalirMousePressed(evt);
            }
        });
        btnDashboardSalir.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelDashboardSalir.setBackground(new java.awt.Color(255, 210, 28));
        labelDashboardSalir.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        labelDashboardSalir.setForeground(new java.awt.Color(255, 255, 255));
        labelDashboardSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDashboardSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/epn/trappi/gui/financiero/imagenesFinanciero/icons8_left_20px.png"))); // NOI18N
        labelDashboardSalir.setText("Salir");
        btnDashboardSalir.add(labelDashboardSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 41));

        panelVerticalIzquierdo.add(btnDashboardSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 570, 140, 41));

        btndashboardgastos.setBackground(new java.awt.Color(255, 210, 28));
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
        btndashboardgastos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelGastos1.setBackground(new java.awt.Color(255, 210, 28));
        labelGastos1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        labelGastos1.setForeground(new java.awt.Color(255, 255, 255));
        labelGastos1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelGastos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/epn/trappi/gui/financiero/imagenesFinanciero/icons8_receive_cash_32px.png"))); // NOI18N
        labelGastos1.setText("Gastos");
        btndashboardgastos.add(labelGastos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 150, 40));

        panelVerticalIzquierdo.add(btndashboardgastos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 150, 40));

        btndashboardgeneral.setBackground(new java.awt.Color(255, 210, 28));
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
        btndashboardgeneral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lableGeneralDashboard.setBackground(new java.awt.Color(255, 210, 28));
        lableGeneralDashboard.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        lableGeneralDashboard.setForeground(new java.awt.Color(255, 255, 255));
        lableGeneralDashboard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lableGeneralDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/epn/trappi/gui/financiero/imagenesFinanciero/icons8_increase_32px.png"))); // NOI18N
        lableGeneralDashboard.setText("Dashboard");
        btndashboardgeneral.add(lableGeneralDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 160, 41));

        panelVerticalIzquierdo.add(btndashboardgeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 150, -1));

        labelLogoFinanciero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/epn/trappi/gui/financiero/imagenesFinanciero/log4-1fin.png"))); // NOI18N
        panelVerticalIzquierdo.add(labelLogoFinanciero, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 220, -1));

        jPanel1.add(panelVerticalIzquierdo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 260, 770));

        panelDespliegue.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelDevoluciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelDevolucionesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelDevolucionesMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelDevolucionesMousePressed(evt);
            }
        });
        panelDevoluciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(61, 57, 57));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("DEVOLUCIONES");
        panelDevoluciones.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1120, 48));
        panelDevoluciones.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1190, 10));

        jLabel20.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel20.setText("Devoluciones del: ");
        panelDevoluciones.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, -1, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel21.setText("Día:");
        panelDevoluciones.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, -1, -1));
        panelDevoluciones.add(txtDiaDevolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 40, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel22.setText("Mes:");
        panelDevoluciones.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, 40, -1));

        txtMesDevolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMesDevolucionActionPerformed(evt);
            }
        });
        panelDevoluciones.add(txtMesDevolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, 40, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel23.setText("Año:");
        panelDevoluciones.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 140, 35, 20));
        panelDevoluciones.add(txtAnioDevolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 140, 60, -1));

        btnConsultarDevolucionesporFecha.setBackground(new java.awt.Color(250, 250, 250));
        btnConsultarDevolucionesporFecha.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnConsultarDevolucionesporFecha.setText("Consultar");
        btnConsultarDevolucionesporFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnConsultarDevolucionesporFechaMousePressed(evt);
            }
        });
        btnConsultarDevolucionesporFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarDevolucionesporFechaActionPerformed(evt);
            }
        });
        panelDevoluciones.add(btnConsultarDevolucionesporFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 130, 100, -1));

        tablaDevoluciones.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tablaDevoluciones);

        panelDevoluciones.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 740, 360));

        panelDespliegue.add(panelDevoluciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 780));

        panelDashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(61, 57, 57));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("RESUMEN DE INGRESOS, GASTOS Y DEVOLUCIONES");
        panelDashboard.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1120, 48));
        panelDashboard.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1190, 10));

        javax.swing.GroupLayout panelCircularLayout = new javax.swing.GroupLayout(panelCircular);
        panelCircular.setLayout(panelCircularLayout);
        panelCircularLayout.setHorizontalGroup(
            panelCircularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 475, Short.MAX_VALUE)
        );
        panelCircularLayout.setVerticalGroup(
            panelCircularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        panelDashboard.add(panelCircular, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 460, 475, 250));

        javax.swing.GroupLayout panelBarrasGastosLayout = new javax.swing.GroupLayout(panelBarrasGastos);
        panelBarrasGastos.setLayout(panelBarrasGastosLayout);
        panelBarrasGastosLayout.setHorizontalGroup(
            panelBarrasGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 475, Short.MAX_VALUE)
        );
        panelBarrasGastosLayout.setVerticalGroup(
            panelBarrasGastosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        panelDashboard.add(panelBarrasGastos, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 170, 475, 250));

        javax.swing.GroupLayout panelBarrasIngresosLayout = new javax.swing.GroupLayout(panelBarrasIngresos);
        panelBarrasIngresos.setLayout(panelBarrasIngresosLayout);
        panelBarrasIngresosLayout.setHorizontalGroup(
            panelBarrasIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 475, Short.MAX_VALUE)
        );
        panelBarrasIngresosLayout.setVerticalGroup(
            panelBarrasIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        panelDashboard.add(panelBarrasIngresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 475, 250));

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("INGRESOS TOTALES:");
        panelDashboard.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 160, 32));

        labelIngresosTotales.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        labelIngresosTotales.setForeground(new java.awt.Color(0, 51, 255));
        labelIngresosTotales.setText("$450000.00");
        panelDashboard.add(labelIngresosTotales, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 130, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("GASTOS TOTALES");
        panelDashboard.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, -1, 30));

        labelGastosTotales.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        labelGastosTotales.setForeground(new java.awt.Color(255, 51, 51));
        labelGastosTotales.setText("$700000.00");
        panelDashboard.add(labelGastosTotales, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 120, 30));

        jLabel18.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("PRESUPUESTO");
        panelDashboard.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 80, 130, 50));

        labelPresupuesto.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        labelPresupuesto.setForeground(new java.awt.Color(0, 153, 51));
        labelPresupuesto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPresupuesto.setText("$300000.00");
        panelDashboard.add(labelPresupuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 90, 170, 30));

        javax.swing.GroupLayout panelBarrasDevolucionesLayout = new javax.swing.GroupLayout(panelBarrasDevoluciones);
        panelBarrasDevoluciones.setLayout(panelBarrasDevolucionesLayout);
        panelBarrasDevolucionesLayout.setHorizontalGroup(
            panelBarrasDevolucionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 475, Short.MAX_VALUE)
        );
        panelBarrasDevolucionesLayout.setVerticalGroup(
            panelBarrasDevolucionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        panelDashboard.add(panelBarrasDevoluciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 460, 475, 250));

        labelDevolucionesDashboard.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        labelDevolucionesDashboard.setForeground(new java.awt.Color(51, 51, 51));
        labelDevolucionesDashboard.setText("DEVOLUCIONES:");
        panelDashboard.add(labelDevolucionesDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, -1, 30));

        labelDevolucionesTotal.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        labelDevolucionesTotal.setForeground(new java.awt.Color(255, 51, 51));
        labelDevolucionesTotal.setText("$700000.00");
        panelDashboard.add(labelDevolucionesTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 90, 120, 30));

        panelDespliegue.add(panelDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 740));

        panelIngresos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaIngresos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaIngresos);

        panelIngresos.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 740, 360));
        panelIngresos.add(txtDiaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 40, -1));

        txtMesIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMesIngresoActionPerformed(evt);
            }
        });
        panelIngresos.add(txtMesIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, 40, -1));
        panelIngresos.add(txtAnioIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 140, 60, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel1.setText("Día:");
        panelIngresos.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel2.setText("Mes:");
        panelIngresos.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, 40, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel3.setText("Año:");
        panelIngresos.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 140, 35, 20));

        btnConsultarIngresosporFecha.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnConsultarIngresosporFecha.setText("Consultar");
        btnConsultarIngresosporFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnConsultarIngresosporFechaMousePressed(evt);
            }
        });
        btnConsultarIngresosporFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarIngresosporFechaActionPerformed(evt);
            }
        });
        panelIngresos.add(btnConsultarIngresosporFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 130, 100, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel5.setText("Ingresos del: ");
        panelIngresos.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("INGRESOS DE TRAPPI");
        panelIngresos.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1120, 48));
        panelIngresos.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1190, 10));

        panelDespliegue.add(panelIngresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 690));

        panelGastos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaGastos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tablaGastos);

        panelGastos.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 740, 360));

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel11.setText("Gastos del: ");
        panelGastos.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel12.setText("Día:");
        panelGastos.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel13.setText("Mes:");
        panelGastos.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, 40, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel14.setText("Año:");
        panelGastos.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 140, 35, 20));
        panelGastos.add(txtDiaGasto, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 40, -1));

        txtMesGasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMesGastoActionPerformed(evt);
            }
        });
        panelGastos.add(txtMesGasto, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, 40, -1));
        panelGastos.add(txtAnioGasto, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 140, 60, -1));

        btnConsultarGastosporFecha.setBackground(new java.awt.Color(250, 250, 250));
        btnConsultarGastosporFecha.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnConsultarGastosporFecha.setText("Consultar");
        btnConsultarGastosporFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnConsultarGastosporFechaMousePressed(evt);
            }
        });
        btnConsultarGastosporFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarGastosporFechaActionPerformed(evt);
            }
        });
        panelGastos.add(btnConsultarGastosporFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 130, 100, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("GASTOS DE TRAPPI");
        panelGastos.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 300, 48));
        panelGastos.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1190, 10));

        panelDespliegue.add(panelGastos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 690));

        jPanel1.add(panelDespliegue, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 1120, 780));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1360, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 769, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btndashboardgastosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndashboardgastosMouseEntered
        btndashboardgastos.setBackground(new java.awt.Color(255,210,28));
        btndashboardgastos.setOpaque(true);
    }//GEN-LAST:event_btndashboardgastosMouseEntered

    private void btndashboardgastosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndashboardgastosMouseExited
        this.btndashboardgastos.setBackground(new java.awt.Color(61,57,57));
        this.btndashboardgastos.setOpaque(false);
    }//GEN-LAST:event_btndashboardgastosMouseExited

    private void btndashboardgeneralMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndashboardgeneralMouseMoved

    }//GEN-LAST:event_btndashboardgeneralMouseMoved

    private void btndashboardgeneralMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndashboardgeneralMouseEntered
        btndashboardgeneral.setBackground(new java.awt.Color(255,210,28));
        btndashboardgeneral.setOpaque(true);
    }//GEN-LAST:event_btndashboardgeneralMouseEntered

    private void btndashboardgeneralMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndashboardgeneralMouseExited
        this.btndashboardgeneral.setBackground(new java.awt.Color(61,57,57));
       this.btndashboardgeneral.setBackground(new java.awt.Color(61,57,57));
        this.btndashboardgeneral.setOpaque(false); this.btndashboardgeneral.setOpaque(false);
    }//GEN-LAST:event_btndashboardgeneralMouseExited

    private void btndashboardgeneralMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndashboardgeneralMousePressed
        this.vaciarCampos();
        this.panelGastos.setVisible(false);
        this.panelIngresos.setVisible(false);
        this.panelDevoluciones.setVisible(false);
        this.mostrarGraficaDeBarras();
        this.mostrarGraficaCircular();
        this.mostrarValoresTotales();
        this.panelDashboard.setVisible(true);
    }//GEN-LAST:event_btndashboardgeneralMousePressed

    private void btndashboardingresosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndashboardingresosMouseEntered
        btndashboardingresos.setBackground(new java.awt.Color(255,210,28));
        btndashboardingresos.setOpaque(true);
    }//GEN-LAST:event_btndashboardingresosMouseEntered

    private void btndashboardingresosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndashboardingresosMouseExited
        this.btndashboardingresos.setBackground(new java.awt.Color(61,57,57));
        this.btndashboardingresos.setOpaque(false);
    }//GEN-LAST:event_btndashboardingresosMouseExited

    private void btnDashboardSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDashboardSalirMouseEntered
        btnDashboardSalir.setBackground(new java.awt.Color(255,210,28));
        btnDashboardSalir.setOpaque(true);
    }//GEN-LAST:event_btnDashboardSalirMouseEntered

    private void btnDashboardSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDashboardSalirMouseExited
        this.btnDashboardSalir.setBackground(new java.awt.Color(61,57,57));
        this.btnDashboardSalir.setOpaque(false);
    }//GEN-LAST:event_btnDashboardSalirMouseExited

    private void btnConsultarIngresosporFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarIngresosporFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConsultarIngresosporFechaActionPerformed

    private void txtMesIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMesIngresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMesIngresoActionPerformed

    private void txtMesGastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMesGastoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMesGastoActionPerformed

    private void btnConsultarGastosporFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarGastosporFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConsultarGastosporFechaActionPerformed

    private void btndashboardgastosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndashboardgastosMousePressed
        this.vaciarCampos();
        this.panelIngresos.setVisible(false);
        this.panelDashboard.setVisible(false);
        this.panelDevoluciones.setVisible(false);
        this.panelGastos.setVisible(true);
        this.mostrarTablaPagos();
    }//GEN-LAST:event_btndashboardgastosMousePressed

    private void btndashboardingresosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndashboardingresosMousePressed
        this.vaciarCampos();
        this.panelGastos.setVisible(false);
        this.panelDashboard.setVisible(false);
        this.panelDevoluciones.setVisible(false);
        this.panelIngresos.setVisible(true);
        this.mostrarTablaIngresos();
    }//GEN-LAST:event_btndashboardingresosMousePressed

    private void btnConsultarIngresosporFechaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultarIngresosporFechaMousePressed
        this.analizador=new Analizador();
        this.mostrarTablaIngresosporFecha(analizador.buscarIngresosPorFecha(Integer.parseInt(this.txtDiaIngreso.getText()), Integer.parseInt(this.txtMesIngreso.getText()), Integer.parseInt(this.txtAnioIngreso.getText())));
    }//GEN-LAST:event_btnConsultarIngresosporFechaMousePressed

    private void btnConsultarGastosporFechaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultarGastosporFechaMousePressed
        this.analizador=new Analizador();
        this.mostrarTablaPagosporFecha(this.analizador.buscarPagosPorFecha(Integer.parseInt(txtDiaGasto.getText()), Integer.parseInt(txtMesGasto.getText()), Integer.parseInt(txtAnioGasto.getText())));
    }//GEN-LAST:event_btnConsultarGastosporFechaMousePressed

    private void btndashboarddevolucionesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndashboarddevolucionesMouseEntered
        btndashboarddevoluciones.setBackground(new java.awt.Color(255,210,28));
        btndashboarddevoluciones.setOpaque(true);
    }//GEN-LAST:event_btndashboarddevolucionesMouseEntered

    private void btndashboarddevolucionesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndashboarddevolucionesMouseExited
       this.btndashboarddevoluciones.setBackground(new java.awt.Color(61,57,57));
       this.btndashboarddevoluciones.setOpaque(false);
    }//GEN-LAST:event_btndashboarddevolucionesMouseExited

    private void btndashboarddevolucionesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndashboarddevolucionesMousePressed
        this.vaciarCampos();
        this.panelGastos.setVisible(false);
        this.panelDashboard.setVisible(false);
        this.panelIngresos.setVisible(false);
        this.panelDevoluciones.setVisible(true);
        this.mostrarTablaDevoluciones();
    }//GEN-LAST:event_btndashboarddevolucionesMousePressed

    private void txtMesDevolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMesDevolucionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMesDevolucionActionPerformed

    private void btnConsultarDevolucionesporFechaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultarDevolucionesporFechaMousePressed
        Analizador analizado = new Analizador();
        this.mostrarDevolucionesPorFecha(analizado.buscarDevolucionesPorFecha(Integer.parseInt(txtDiaDevolucion.getText()), Integer.parseInt(txtMesDevolucion.getText()),Integer.parseInt(txtAnioDevolucion.getText())));
    }//GEN-LAST:event_btnConsultarDevolucionesporFechaMousePressed

    private void btnConsultarDevolucionesporFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarDevolucionesporFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConsultarDevolucionesporFechaActionPerformed

    private void panelDevolucionesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelDevolucionesMouseEntered
        
    }//GEN-LAST:event_panelDevolucionesMouseEntered

    private void panelDevolucionesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelDevolucionesMouseExited
        
    }//GEN-LAST:event_panelDevolucionesMouseExited

    private void panelDevolucionesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelDevolucionesMousePressed
        
    }//GEN-LAST:event_panelDevolucionesMousePressed

    private void btnDashboardSalirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDashboardSalirMousePressed
        this.setVisible(false);
        new Menu_Trappi().setVisible(true);
    }//GEN-LAST:event_btnDashboardSalirMousePressed

    public void mostrarTablaIngresos(){
        DefaultTableModel tab = null;
        DecimalFormat formatoDecimales = new DecimalFormat("#.00");
        String [] columnastabla = {"Nro. Factura", "Total", "Fecha"};
        String [] datos = new String[3];
        tab = new DefaultTableModel(null,columnastabla);
        FinancieroDb ingresosDb = new FinancieroDb();
        try{
            for(Ingreso ingreso:ingresosDb.consultarIngresosRegistrados()){
                System.out.println("Está entrando");
                datos[0] = String.valueOf(ingreso.getNroFactura());
                datos[1] = String.valueOf(formatoDecimales.format(ingreso.getTotal()));
                String fecha = String.valueOf(ingreso.getFechaIngreso().devolverDia())+'/'+String.valueOf(ingreso.getFechaIngreso().devolverMes())+'/'+String.valueOf(ingreso.getFechaIngreso().devolverAnio());
                datos[2] = fecha;
                tab.addRow(datos);
            
            }   
        
        }catch( Exception e){
            System.out.println(e);
            
        }

        this.tablaIngresos.setModel(tab);
    }
    public void mostrarTablaIngresosporFecha(ArrayList<Ingreso> ingresosporFecha){
        DefaultTableModel tab = null;
        DecimalFormat formatoDecimales = new DecimalFormat("#.00");
            String [] columnastabla = {"Nro. Factura", "Total", "Fecha"};
            String [] datos = new String[3];
            tab = new DefaultTableModel(null,columnastabla);
            for(Ingreso ingreso: ingresosporFecha){
            System.out.println("Está entrando");
            datos[0] = String.valueOf(ingreso.getNroFactura());
            datos[1] = String.valueOf(formatoDecimales.format(ingreso.getTotal()));
            String fecha = String.valueOf(ingreso.getFechaIngreso().devolverDia())+'/'+String.valueOf(ingreso.getFechaIngreso().devolverMes())+'/'+String.valueOf(ingreso.getFechaIngreso().devolverAnio());
            datos[2] = fecha;
            tab.addRow(datos);
            
            }
        this.tablaIngresos.setModel(tab);
    }
    
    public void mostrarTablaPagos(){
        DefaultTableModel tab = null;
        DecimalFormat formatoDecimales = new DecimalFormat("#.00");
        try{
            String [] columnastabla = {"Nro. Cuenta", "Monto", "Fecha"};
            String [] datos = new String[3];
            tab = new DefaultTableModel(null,columnastabla);
           ArrayList<Pago> pagosRegistrados = new ArrayList<Pago>();
           FinancieroDb pagosBd = new FinancieroDb();
           pagosRegistrados= pagosBd.consultarPagosRegistrados();
            for(Pago pago : pagosRegistrados){
                System.out.println("Está entrando");
                datos[0] = pago.getNroCuenta();
                datos[1] = String.valueOf(formatoDecimales.format(pago.getMonto()));
                String fecha = String.valueOf(pago.getFechadePago().devolverDia())+'/'+String.valueOf(pago.getFechadePago().devolverMes())+'/'+String.valueOf(pago.getFechadePago().devolverAnio());
                datos[2] = fecha;
                tab.addRow(datos);   
            }
        }catch( Exception e){
            System.out.println(e);
            
        }
        this.tablaGastos.setModel(tab);
    }
    public void mostrarTablaPagosporFecha(ArrayList<Pago> pagosporFecha){
        DefaultTableModel tab = null;
        DecimalFormat formatoDecimales = new DecimalFormat("#.00");
            String [] columnastabla = {"Nro. Cuenta", "Total", "Fecha"};
            String [] datos = new String[3];
            tab = new DefaultTableModel(null,columnastabla);
            for(Pago pago: pagosporFecha){
            System.out.println("Está entrando");
            datos[0] = pago.getNroCuenta();
            datos[1] = String.valueOf(formatoDecimales.format(pago.getMonto()));
            String fecha = String.valueOf(pago.getFechadePago().devolverDia())+'/'+String.valueOf(pago.getFechadePago().devolverMes())+'/'+String.valueOf(pago.getFechadePago().devolverAnio());
            datos[2] = fecha;
            tab.addRow(datos);
            
            }
        this.tablaGastos.setModel(tab);
    }
    public void mostrarTablaDevoluciones(){
        DefaultTableModel tab = null;
        DecimalFormat formatoDecimales = new DecimalFormat("#.00");
        String [] columnastabla = {"Nro. Factura", "Valor Devolucion", "Fecha"};
        String [] datos = new String[3];
        tab = new DefaultTableModel(null,columnastabla);

        try{
        FinancieroDb devolucionesDb = new FinancieroDb();
        for(Devolucion devolucion: devolucionesDb.consultarDevolucionesRegistradas()){
            System.out.println("Está entrando");
            datos[0] = String.valueOf(devolucion.getNroFactura());
            datos[1] = String.valueOf(formatoDecimales.format(devolucion.getValorDevolucion()));
            String fecha = String.valueOf(devolucion.getFechaDeDevolucion().devolverDia())+'/'+String.valueOf(devolucion.getFechaDeDevolucion().devolverMes())+'/'+String.valueOf(devolucion.getFechaDeDevolucion().devolverAnio());
            datos[2] = fecha;
            tab.addRow(datos);
        }
        
        }catch( Exception e){
            System.out.println(e);
            
        }

        this.tablaDevoluciones.setModel(tab);
    }
    public void mostrarDevolucionesPorFecha(ArrayList<Devolucion> devolucionesRegistradas){
        DefaultTableModel tab = null;
        DecimalFormat formatoDecimales = new DecimalFormat("#.00");
            String [] columnastabla = {"Nro. Factura", "Valor Devolucion", "Fecha"};
            String [] datos = new String[3];
            tab = new DefaultTableModel(null,columnastabla);
            for(Devolucion devolucion: devolucionesRegistradas){
            System.out.println("Está entrando");
            datos[0] = String.valueOf(devolucion.getNroFactura());
            datos[1] = String.valueOf(formatoDecimales.format(devolucion.getValorDevolucion()));
            String fecha = String.valueOf(devolucion.getFechaDeDevolucion().devolverDia())+'/'+String.valueOf(devolucion.getFechaDeDevolucion().devolverMes())+'/'+String.valueOf(devolucion.getFechaDeDevolucion().devolverAnio());
            datos[2] = fecha;
            tab.addRow(datos);
            
            }
        this.tablaDevoluciones.setModel(tab);
    }
    public void mostrarGraficaDeBarras(){
        DefaultCategoryDataset dts = new DefaultCategoryDataset();
        analizador=new Analizador();
        String[] mesesCalculados = this.analizador.calcularIntervaloMensualString();
        analizador.calcularIntervaloMensualInt();
        analizador.calcularIngresosporIntervalodeMeses();
        for(int i=0;i<5;i++){
            dts.setValue(analizador.calcularIngresosporIntervalodeMeses()[i], analizador.calcularIntervaloMensualString()[i], "");
        }
        
        JFreeChart jc = ChartFactory.createBarChart("Ingresos Mensuales","Meses","Cantidad Ingresos(USD)", dts, PlotOrientation.HORIZONTAL,true,true,false);
        ChartPanel cp = new ChartPanel(jc);
        cp.setBounds(270, 190, 475, 250);
        panelBarrasIngresos.setLayout(new java.awt.BorderLayout());
        panelBarrasIngresos.add(cp);
        panelBarrasIngresos.validate();
        
        DefaultCategoryDataset dts1 = new DefaultCategoryDataset();
        for(int i=0;i<5;i++){
            dts1.setValue(this.analizador.calcularPagosporIntervalodeMeses()[i], this.analizador.calcularIntervaloMensualString()[i], "");
        }
        JFreeChart jc1 = ChartFactory.createBarChart("Gastos Mensuales","Meses","Cantidad Gastos(USD)", dts1, PlotOrientation.HORIZONTAL,true,true,false);
        ChartPanel cp1 = new ChartPanel(jc1);
        cp1.setBounds(810, 190, 475, 250);
        panelBarrasGastos.setLayout(new java.awt.BorderLayout());
        panelBarrasGastos.add(cp1);
        panelBarrasGastos.validate();
        DefaultCategoryDataset dts3 = new DefaultCategoryDataset();
        for(int i=0;i<5;i++){
            dts3.setValue(this.analizador.calcularDevolucionesPorIntervaloDeMeses()[i], this.analizador.calcularIntervaloMensualString()[i], "");
        }
        JFreeChart jc3 = ChartFactory.createBarChart("Devoluciones Mensuales","Meses","Cantidad Devoluciones(USD)", dts3, PlotOrientation.HORIZONTAL,true,true,false);
        ChartPanel cp3 = new ChartPanel(jc3);
        cp3.setBounds(810, 190, 475, 250);
        panelBarrasDevoluciones.setLayout(new java.awt.BorderLayout());
        panelBarrasDevoluciones.add(cp3);
        panelBarrasDevoluciones.validate();
    }
    public void mostrarGraficaCircular(){
        DefaultPieDataset dts2 = new DefaultPieDataset();
        dts2.setValue("Gastos",this.analizador.getLibrodiario().calcularTotalPagos() );
        dts2.setValue("Ingresos", this.analizador.getLibrodiario().calcularTotalIngresos());
        dts2.setValue("Devoluciones", this.analizador.getLibrodiario().calcularTotalDevoluciones());
        JFreeChart jc2 = ChartFactory.createPieChart("Gastos vs. Ingresos vs. Devoluciones", dts2,true,true,false);
        ChartPanel cp2 = new ChartPanel(jc2);
        cp2.setBounds(270, 460, 475, 230);
        panelCircular.setLayout(new java.awt.BorderLayout());
        panelCircular.add(cp2);
        panelCircular.validate();
    }
    public void mostrarValoresTotales(){
        DecimalFormat formatoDecimales = new DecimalFormat("#.00");
        this.labelIngresosTotales.setText("$"+String.valueOf(formatoDecimales.format(this.analizador.getLibrodiario().calcularTotalIngresos())));
        this.labelGastosTotales.setText("$"+String.valueOf(formatoDecimales.format(this.analizador.getLibrodiario().calcularTotalPagos())));
        this.labelDevolucionesTotal.setText("$"+String.valueOf(formatoDecimales.format(this.analizador.getLibrodiario().calcularTotalDevoluciones())));
        this.labelPresupuesto.setText("$"+String.valueOf(formatoDecimales.format(this.analizador.getLibrodiario().calcularTotalIngresos()-this.analizador.getLibrodiario().calcularTotalPagos()-this.analizador.getLibrodiario().calcularTotalDevoluciones())));
    }
    public void vaciarCampos(){
        txtDiaGasto.setText("");
        txtMesGasto.setText("");
        txtAnioGasto.setText("");
        txtDiaIngreso.setText("");
        txtMesIngreso.setText("");
        txtAnioIngreso.setText("");
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardFinanciero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultarDevolucionesporFecha;
    private javax.swing.JButton btnConsultarGastosporFecha;
    private javax.swing.JButton btnConsultarIngresosporFecha;
    private javax.swing.JPanel btnDashboardSalir;
    private javax.swing.JPanel btndashboarddevoluciones;
    private javax.swing.JPanel btndashboardgastos;
    private javax.swing.JPanel btndashboardgeneral;
    private javax.swing.JPanel btndashboardingresos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel labelDashboardSalir;
    private javax.swing.JLabel labelDevoluciones;
    private javax.swing.JLabel labelDevolucionesDashboard;
    private javax.swing.JLabel labelDevolucionesTotal;
    private javax.swing.JLabel labelGastos1;
    private javax.swing.JLabel labelGastosTotales;
    private javax.swing.JLabel labelIngresos;
    private javax.swing.JLabel labelIngresosTotales;
    private javax.swing.JLabel labelLogoFinanciero;
    private javax.swing.JLabel labelPresupuesto;
    private javax.swing.JLabel lableGeneralDashboard;
    private javax.swing.JPanel panelBarrasDevoluciones;
    private javax.swing.JPanel panelBarrasGastos;
    private javax.swing.JPanel panelBarrasIngresos;
    private javax.swing.JPanel panelCircular;
    private javax.swing.JPanel panelDashboard;
    private javax.swing.JPanel panelDespliegue;
    private javax.swing.JPanel panelDevoluciones;
    private javax.swing.JPanel panelGastos;
    private javax.swing.JPanel panelIngresos;
    private javax.swing.JPanel panelVerticalIzquierdo;
    private javax.swing.JTable tablaDevoluciones;
    private javax.swing.JTable tablaGastos;
    private javax.swing.JTable tablaIngresos;
    private javax.swing.JTextField txtAnioDevolucion;
    private javax.swing.JTextField txtAnioGasto;
    private javax.swing.JTextField txtAnioIngreso;
    private javax.swing.JTextField txtDiaDevolucion;
    private javax.swing.JTextField txtDiaGasto;
    private javax.swing.JTextField txtDiaIngreso;
    private javax.swing.JTextField txtMesDevolucion;
    private javax.swing.JTextField txtMesGasto;
    private javax.swing.JTextField txtMesIngreso;
    // End of variables declaration//GEN-END:variables
}
