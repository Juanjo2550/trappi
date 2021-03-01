/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.rrhh;


import com.epn.trappi.*;
import com.epn.trappi.models.rrhh.contratacion.Aspirante;
import com.epn.trappi.models.rrhh.contratacion.Contratacion;
import com.epn.trappi.models.rrhh.RRHH;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author stali
 */
public class ContratarAspirante extends javax.swing.JFrame {

    /**
     * Creates new form Ejemplo_GUI
     */
    public ContratarAspirante() {
        initComponents();
       // ControladorPruebaAdmision controlador = new ControladorPruebaAdmision(16, "sociable colaborador amable", "adptable agil versatil");
       // ArrayList<Aspirante> aptos = controlador.obtenerAspirantesAptos();
//        DefaultTableModel model = (DefaultTableModel) jTableAspirantesAptos.getModel();
//        model.setRowCount(0);
//        
//        for (Aspirante asp: aptos){
//            Vector v = new Vector();
//            v.add(asp.getNombre());
//            v.add(asp.getApellidos());
//            v.add(asp.getTelefono());
//            v.add(asp.getCedula());
//            v.add(asp.getCargoAspirante());
//            v.add(asp.getPrueba().getPuntaje());
//            v.add(asp.getPrueba().getActitudes());
//            v.add(asp.getPrueba().getAptitudes());
//            
//            model.addRow(v);
//            jTableAspirantesAptos.setModel(model);
//        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrpCopiaCedula = new javax.swing.ButtonGroup();
        btnGrpCopiaTitulo = new javax.swing.ButtonGroup();
        btnGrpREvisionMedica = new javax.swing.ButtonGroup();
        btnGrpSexo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        PanelAspirante = new javax.swing.JPanel();
        jButRegCliente = new javax.swing.JButton();
        jButRegCliente2 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAspirantesAptos = new javax.swing.JTable();
        jTextContratoFechaInicio = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextContratoFechaFin = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jCmbContratoTipo = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel21 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel22 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel23 = new javax.swing.JLabel();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jLabel24 = new javax.swing.JLabel();
        jTextContratoCuenta = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jTextContratoBanco = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jTextContratoSueldo = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jTextContratoDepto = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jTextContratoCargo = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        rdbtFemenino = new javax.swing.JRadioButton();
        rdbtMasculino = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LOGOtrappi.jpeg"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton4.setText("Salir");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("RECURSOS HUMANOS");

        jButton1.setBackground(new java.awt.Color(204, 153, 0));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("Aspirantes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnVolver.setBackground(new java.awt.Color(204, 153, 0));
        btnVolver.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(51, 51, 51));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(204, 153, 0));
        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(51, 51, 51));
        jButton6.setText("Contratos");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(204, 153, 0));
        jButton7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(51, 51, 51));
        jButton7.setText("Contratación");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 153, 0));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setText("Empleados");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 346, Short.MAX_VALUE)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        PanelAspirante.setBackground(new java.awt.Color(255, 255, 255));
        PanelAspirante.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButRegCliente.setBackground(new java.awt.Color(0, 153, 153));
        jButRegCliente.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButRegCliente.setForeground(new java.awt.Color(240, 240, 241));
        jButRegCliente.setText("Contratar");
        jButRegCliente.setBorderPainted(false);
        jButRegCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButRegClienteActionPerformed(evt);
            }
        });
        PanelAspirante.add(jButRegCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, -1, -1));

        jButRegCliente2.setBackground(new java.awt.Color(38, 112, 171));
        jButRegCliente2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButRegCliente2.setForeground(new java.awt.Color(240, 240, 241));
        jButRegCliente2.setText("Nuevo");
        jButRegCliente2.setBorderPainted(false);
        jButRegCliente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButRegCliente2ActionPerformed(evt);
            }
        });
        PanelAspirante.add(jButRegCliente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 99, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Usted está a punto de contratar un nuevo empleado, a continuación se muestran los aspirantes que son aptos para ser contratados ");
        PanelAspirante.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jTableAspirantesAptos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellidos", "Teléfono", "Cédula", "Cargo", "Puntaje", "Actitudes", "Puntaje"
            }
        ));
        jScrollPane1.setViewportView(jTableAspirantesAptos);

        PanelAspirante.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 840, 290));

        jTextContratoFechaInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextContratoFechaInicioActionPerformed(evt);
            }
        });
        jTextContratoFechaInicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextContratoFechaInicioKeyTyped(evt);
            }
        });
        PanelAspirante.add(jTextContratoFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 110, 28));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Requisitos del Aspirante");
        PanelAspirante.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Tipo:");
        PanelAspirante.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jTextContratoFechaFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextContratoFechaFinActionPerformed(evt);
            }
        });
        jTextContratoFechaFin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextContratoFechaFinKeyTyped(evt);
            }
        });
        PanelAspirante.add(jTextContratoFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 110, 28));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Revisión Médica");
        PanelAspirante.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, -1, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Fecha Fin:");
        PanelAspirante.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jCmbContratoTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccionar--", "Fijo", "Temporal", "Temporada" }));
        jCmbContratoTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCmbContratoTipoActionPerformed(evt);
            }
        });
        PanelAspirante.add(jCmbContratoTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 110, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Datos Contrato");
        PanelAspirante.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, 20));

        btnGrpCopiaCedula.add(jRadioButton1);
        jRadioButton1.setText("No");
        PanelAspirante.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Fecha Inicio:");
        PanelAspirante.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        btnGrpCopiaCedula.add(jRadioButton2);
        jRadioButton2.setText("Si");
        PanelAspirante.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, -1, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Copia Cédula");
        PanelAspirante.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, -1, -1));

        btnGrpCopiaTitulo.add(jRadioButton3);
        jRadioButton3.setText("Si");
        PanelAspirante.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, -1, -1));

        btnGrpCopiaTitulo.add(jRadioButton4);
        jRadioButton4.setText("No");
        PanelAspirante.add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, -1, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Copia Título(s)");
        PanelAspirante.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, -1, -1));

        btnGrpREvisionMedica.add(jRadioButton5);
        jRadioButton5.setText("Si");
        PanelAspirante.add(jRadioButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, -1, -1));

        btnGrpREvisionMedica.add(jRadioButton6);
        jRadioButton6.setText("No");
        PanelAspirante.add(jRadioButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, -1, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("# Cuenta");
        PanelAspirante.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, -1, -1));

        jTextContratoCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextContratoCuentaActionPerformed(evt);
            }
        });
        jTextContratoCuenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextContratoCuentaKeyTyped(evt);
            }
        });
        PanelAspirante.add(jTextContratoCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 110, 28));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Banco");
        PanelAspirante.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 120, -1, -1));

        jTextContratoBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextContratoBancoActionPerformed(evt);
            }
        });
        jTextContratoBanco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextContratoBancoKeyTyped(evt);
            }
        });
        PanelAspirante.add(jTextContratoBanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 110, 110, 28));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("Sueldo($)");
        PanelAspirante.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, -1, -1));

        jTextContratoSueldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextContratoSueldoActionPerformed(evt);
            }
        });
        jTextContratoSueldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextContratoSueldoKeyTyped(evt);
            }
        });
        PanelAspirante.add(jTextContratoSueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 150, 110, 28));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("Depto.");
        PanelAspirante.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, -1, -1));

        jTextContratoDepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextContratoDeptoActionPerformed(evt);
            }
        });
        jTextContratoDepto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextContratoDeptoKeyTyped(evt);
            }
        });
        PanelAspirante.add(jTextContratoDepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 190, 110, 28));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("Cargo");
        PanelAspirante.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 160, -1, -1));

        jTextContratoCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextContratoCargoActionPerformed(evt);
            }
        });
        jTextContratoCargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextContratoCargoKeyTyped(evt);
            }
        });
        PanelAspirante.add(jTextContratoCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 150, 110, 28));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setText("Sexo");
        PanelAspirante.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 200, -1, -1));

        btnGrpSexo.add(rdbtFemenino);
        rdbtFemenino.setText("F");
        PanelAspirante.add(rdbtFemenino, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 200, -1, -1));

        btnGrpSexo.add(rdbtMasculino);
        rdbtMasculino.setText("M");
        rdbtMasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtMasculinoActionPerformed(evt);
            }
        });
        PanelAspirante.add(rdbtMasculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 200, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PanelAspirante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelAspirante, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        new RegistroAspirante().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.setVisible(false);
        new PANTALLA_PRINCIPAL().setVisible(true);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void jButRegCliente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButRegCliente2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButRegCliente2ActionPerformed

    private void jButRegClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButRegClienteActionPerformed
        //Obtenemos las datos del aspirante
        DefaultTableModel model = (DefaultTableModel) jTableAspirantesAptos.getModel();
        int selected = jTableAspirantesAptos.getSelectedRow();
        String nombre = (String) model.getValueAt(selected, 0);
        String apellido = (String) model.getValueAt(selected, 1);
        
        String cedula = (String) model.getValueAt(selected, 3);
        String cargo = (String) model.getValueAt(selected, 4);
        String depto = jTextContratoDepto.getText();
        String numCuenta = jTextContratoCuenta.getText();
        String banco = jTextContratoBanco.getText();
        String valorSueldo = jTextContratoSueldo.getText();
        rdbtMasculino.setActionCommand("M");
        rdbtFemenino.setActionCommand("F");
        char sexo = btnGrpSexo.getSelection().getActionCommand().charAt(0);
        
      // Contratacion contratacion = new Contratacion();
       //contratacion.registrarEmpleado(nombre, apellido, cedula, cargo, depto , numCuenta, banco, valorSueldo, sexo);
       
       RRHH rrhh = new RRHH();
       rrhh.contratarPersonal(nombre, apellido, cedula, cargo, depto, numCuenta, banco, valorSueldo, sexo);
       JOptionPane.showMessageDialog(null, "El empleado se ha registrado exitosamente");
               
    }//GEN-LAST:event_jButRegClienteActionPerformed

    private void jTextContratoFechaInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextContratoFechaInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextContratoFechaInicioActionPerformed

    private void jTextContratoFechaInicioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextContratoFechaInicioKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextContratoFechaInicioKeyTyped

    private void jTextContratoFechaFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextContratoFechaFinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextContratoFechaFinActionPerformed

    private void jTextContratoFechaFinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextContratoFechaFinKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextContratoFechaFinKeyTyped

    private void jCmbContratoTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCmbContratoTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCmbContratoTipoActionPerformed

    private void jTextContratoCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextContratoCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextContratoCuentaActionPerformed

    private void jTextContratoCuentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextContratoCuentaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextContratoCuentaKeyTyped

    private void jTextContratoBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextContratoBancoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextContratoBancoActionPerformed

    private void jTextContratoBancoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextContratoBancoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextContratoBancoKeyTyped

    private void jTextContratoSueldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextContratoSueldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextContratoSueldoActionPerformed

    private void jTextContratoSueldoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextContratoSueldoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextContratoSueldoKeyTyped

    private void jTextContratoDeptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextContratoDeptoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextContratoDeptoActionPerformed

    private void jTextContratoDeptoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextContratoDeptoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextContratoDeptoKeyTyped

    private void jTextContratoCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextContratoCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextContratoCargoActionPerformed

    private void jTextContratoCargoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextContratoCargoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextContratoCargoKeyTyped

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.setVisible(false);
        new Contratos().setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.setVisible(false);
        new ContratarAspirante().setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        new EmpleadoGui().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void rdbtMasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtMasculinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbtMasculinoActionPerformed

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
            java.util.logging.Logger.getLogger(ContratarAspirante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ContratarAspirante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ContratarAspirante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ContratarAspirante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ContratarAspirante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelAspirante;
    private javax.swing.ButtonGroup btnGrpCopiaCedula;
    private javax.swing.ButtonGroup btnGrpCopiaTitulo;
    private javax.swing.ButtonGroup btnGrpREvisionMedica;
    private javax.swing.ButtonGroup btnGrpSexo;
    private javax.swing.JButton btnVolver;
    private javax.swing.JButton jButRegCliente;
    private javax.swing.JButton jButRegCliente2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jCmbContratoTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAspirantesAptos;
    private javax.swing.JTextField jTextContratoBanco;
    private javax.swing.JTextField jTextContratoCargo;
    private javax.swing.JTextField jTextContratoCuenta;
    private javax.swing.JTextField jTextContratoDepto;
    private javax.swing.JTextField jTextContratoFechaFin;
    private javax.swing.JTextField jTextContratoFechaInicio;
    private javax.swing.JTextField jTextContratoSueldo;
    private javax.swing.JRadioButton rdbtFemenino;
    private javax.swing.JRadioButton rdbtMasculino;
    // End of variables declaration//GEN-END:variables
}
