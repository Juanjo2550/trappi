/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.rrhh;


import com.epn.trappi.*;
import com.epn.trappi.db.rrhh.Connect;
import com.epn.trappi.gui.rrhh.Permisos.Calamidad_Domestica;
import com.epn.trappi.models.rrhh.Empleado;
import com.epn.trappi.models.rrhh.Fecha;
import com.epn.trappi.models.rrhh.ListaEmpleados;
import com.epn.trappi.models.rrhh.TextPrompt;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author stali
 */
public class Gestor_Permiso extends javax.swing.JFrame {
Calamidad_Domestica calamidad = new Calamidad_Domestica();
Fecha fecha = new Fecha();
    
    /*
     * Creates new form Ejemplo_GUI
     */

    

    public Gestor_Permiso() {
        
        initComponents();
        ListarEmpleado();
       
        
       
        cmbnombreEmpleado.setEnabled(true);
        txtCedula.setEnabled(true);
        txtfechaFinPermiso.setEnabled(true);
        
        btnGuardarPermiso.setEnabled(true);
        TextPrompt buscarProveedor = new TextPrompt("yyyy-MM-dd", txtfechaInicioPermiso);
    }
       public void tipoPermiso(){
        String PerCalamidad = (String) cmbPermiso.getSelectedItem();
        if("Calamidad Domestica".equals(PerCalamidad)){
       cmbTipoPermiso.addItem("Seleccione");
       cmbTipoPermiso.addItem("muerte de padres, hermanos, hijos, cónyuge");
       cmbTipoPermiso.addItem("muerte de nietos, padres del cónyuge o hermanos de la pareja");
       cmbTipoPermiso.addItem("enfermedad de hijos o conyuge");
       cmbTipoPermiso.addItem("enfermedad de padres o hermanos");
        }
    
    }
           
 
    
    public void  ListarEmpleado(){
        String sql = "SELECT nombres FROM empleados";
       // ListaEmpleados temEmpleados = new ListaEmpleados();
        try {
            Connection conn = Connect.connect("juanjo.db");
            Statement stmt  = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            // loop through the result set
            cmbnombreEmpleado.addItem("seleccione");
            while (rs.next()) {
                String nombre = rs.getString("nombres");
              cmbnombreEmpleado.addItem(nombre);
            }
           
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }   
    }
     
    public void  ObtenerCedula(){
        
        String sql = "SELECT cedula FROM empleados where nombres = '"+(String) cmbnombreEmpleado.getSelectedItem()+"'" ;
        
       // ListaEmpleados temEmpleados = new ListaEmpleados();
        try {
            Connection conn = Connect.connect("juanjo.db");
            Statement stmt  = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            // loop through the result set
            
                String CI = rs.getString("cedula");
                txtCedula.setText(CI);
                //txtCedula.setVisible(false);
           
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }   
    }
    
    public void  fechaInicio() throws ParseException{
        try{
             String dia;
        String mes;
        String anio;
        String fechaInicio = txtfechaInicioPermiso.getText();
        boolean res ;
        
        String[] arreglo  = fechaInicio.split("-");
        anio = arreglo[0];
        mes = arreglo[1];
        dia = arreglo[2];
       Fecha clasefecha = new Fecha(Integer.parseInt(dia), Integer.parseInt(mes), Integer.parseInt(anio));
        res= clasefecha.fechaCorrecta();
        if (res ==true){
            String FinPermiso= sumarDiasAFecha(fechaInicio, Integer.parseInt(txtnumDias.getText()));
            txtfechaFinPermiso.setText(FinPermiso);
        }
        else{
            JOptionPane.showMessageDialog(null, "Fecha Ingresada no Valida");
        }
        }catch(Exception e){
            
        }
        
    }
     public String sumarDiasAFecha(String fecha, int dias) {
        if(dias == 0){
            return fecha;
        }

        String[] f = fecha.split("-");
        Calendar calendar = Calendar.getInstance();
        //calendar.setTime(new Date(Integer.parseInt(f[0]), Integer.parseInt(f[1]), Integer.parseInt(f[2])));
        calendar.set(Integer.parseInt(f[0]), Integer.parseInt(f[1])-1, Integer.parseInt(f[2]));

        calendar.add(Calendar.DAY_OF_MONTH, dias);
        SimpleDateFormat fe = new SimpleDateFormat("YYYY-MM-dd");
        return fe.format(calendar.getTime());

    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        PanelAspirante = new javax.swing.JPanel();
        lblCedula = new javax.swing.JLabel();
        btnGuardarPermiso = new javax.swing.JButton();
        btnNuevoPermiso = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        lblfechaFinPermiso = new javax.swing.JLabel();
        txtfechaFinPermiso = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        cmbTipoPermiso = new javax.swing.JComboBox<>();
        lblnombreEmpleado1 = new javax.swing.JLabel();
        lblfechaInicioPermiso1 = new javax.swing.JLabel();
        lblfechaInicioPermiso2 = new javax.swing.JLabel();
        txtvalorAPagar = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        lblfechaInicioPermiso3 = new javax.swing.JLabel();
        txtnumDias = new javax.swing.JTextField();
        lblfechaInicioPermiso4 = new javax.swing.JLabel();
        lblfechaInicioPermiso5 = new javax.swing.JLabel();
        txtfechaInicioPermiso = new javax.swing.JTextField();
        lblfechaInicioPermiso6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        cmbPermiso = new javax.swing.JComboBox<>();
        btnValidarFecha = new javax.swing.JButton();
        cmbnombreEmpleado = new javax.swing.JComboBox<>();

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

        jButton5.setBackground(new java.awt.Color(204, 153, 0));
        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(51, 51, 51));
        jButton5.setText("Contratación");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
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
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        PanelAspirante.setBackground(new java.awt.Color(255, 255, 255));
        PanelAspirante.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCedula.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCedula.setText("Cedula:");
        PanelAspirante.add(lblCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, -1, -1));

        btnGuardarPermiso.setBackground(new java.awt.Color(0, 153, 153));
        btnGuardarPermiso.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnGuardarPermiso.setForeground(new java.awt.Color(240, 240, 241));
        btnGuardarPermiso.setText("Guardar");
        btnGuardarPermiso.setBorderPainted(false);
        btnGuardarPermiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarPermisoActionPerformed(evt);
            }
        });
        PanelAspirante.add(btnGuardarPermiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 11, -1, -1));

        btnNuevoPermiso.setBackground(new java.awt.Color(38, 112, 171));
        btnNuevoPermiso.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnNuevoPermiso.setForeground(new java.awt.Color(240, 240, 241));
        btnNuevoPermiso.setText("Nuevo");
        btnNuevoPermiso.setBorderPainted(false);
        btnNuevoPermiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoPermisoActionPerformed(evt);
            }
        });
        PanelAspirante.add(btnNuevoPermiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 99, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Tipo de Permiso: ");
        PanelAspirante.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, -1, -1));

        lblfechaFinPermiso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblfechaFinPermiso.setText("Fecha de Fin de Permiso: ");
        PanelAspirante.add(lblfechaFinPermiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, -1, -1));

        txtfechaFinPermiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfechaFinPermisoActionPerformed(evt);
            }
        });
        txtfechaFinPermiso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfechaFinPermisoKeyTyped(evt);
            }
        });
        PanelAspirante.add(txtfechaFinPermiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, 200, 28));

        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });
        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });
        PanelAspirante.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, 180, 28));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Cedula", "Nombre", "Tipo de Permiso", "Fecha Inicio", "Fecha  Fin", "Estado", "Dias de Permiso", "Valor a Pagar", ""
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        PanelAspirante.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 860, 420));

        cmbTipoPermiso.setToolTipText("");
        cmbTipoPermiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoPermisoActionPerformed(evt);
            }
        });
        PanelAspirante.add(cmbTipoPermiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, 240, -1));

        lblnombreEmpleado1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblnombreEmpleado1.setText("Nombre del Empleado:");
        PanelAspirante.add(lblnombreEmpleado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 65, -1, -1));

        lblfechaInicioPermiso1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblfechaInicioPermiso1.setText("Descripción");
        PanelAspirante.add(lblfechaInicioPermiso1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        lblfechaInicioPermiso2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblfechaInicioPermiso2.setText("Fecha Inicio: ");
        PanelAspirante.add(lblfechaInicioPermiso2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        txtvalorAPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtvalorAPagarActionPerformed(evt);
            }
        });
        txtvalorAPagar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtvalorAPagarKeyTyped(evt);
            }
        });
        PanelAspirante.add(txtvalorAPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 200, 28));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aprobado", "Denegado" }));
        PanelAspirante.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 160, -1));

        lblfechaInicioPermiso3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblfechaInicioPermiso3.setText("Estado: ");
        PanelAspirante.add(lblfechaInicioPermiso3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        txtnumDias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumDiasActionPerformed(evt);
            }
        });
        PanelAspirante.add(txtnumDias, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 80, 30));

        lblfechaInicioPermiso4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblfechaInicioPermiso4.setText("Número de dias de Permiso:");
        PanelAspirante.add(lblfechaInicioPermiso4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        lblfechaInicioPermiso5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblfechaInicioPermiso5.setText("Número de dias de Permiso:");
        PanelAspirante.add(lblfechaInicioPermiso5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        txtfechaInicioPermiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfechaInicioPermisoActionPerformed(evt);
            }
        });
        txtfechaInicioPermiso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfechaInicioPermisoKeyTyped(evt);
            }
        });
        PanelAspirante.add(txtfechaInicioPermiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 200, 28));

        lblfechaInicioPermiso6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblfechaInicioPermiso6.setText("Valor a Pagar por Permiso: ");
        PanelAspirante.add(lblfechaInicioPermiso6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        PanelAspirante.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 770, 70));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Permiso:");
        PanelAspirante.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 104, -1, -1));

        cmbPermiso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vacación", "Calamidad Domestica", "Enfermedad", "Nacimiento de Hijo" }));
        cmbPermiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPermisoActionPerformed(evt);
            }
        });
        PanelAspirante.add(cmbPermiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 180, -1));

        btnValidarFecha.setText("Validar");
        btnValidarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidarFechaActionPerformed(evt);
            }
        });
        PanelAspirante.add(btnValidarFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, -1, -1));

        cmbnombreEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbnombreEmpleadoActionPerformed(evt);
            }
        });
        PanelAspirante.add(cmbnombreEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 330, -1));

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
                        .addComponent(PanelAspirante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        new Gestor_Permiso().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVolverActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.setVisible(false);
        new ContratarAspirante().setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.setVisible(false);
        new Contratos().setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaKeyTyped

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void txtfechaFinPermisoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfechaFinPermisoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfechaFinPermisoKeyTyped

    private void txtfechaFinPermisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfechaFinPermisoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfechaFinPermisoActionPerformed

    private void btnNuevoPermisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoPermisoActionPerformed
      
        cmbnombreEmpleado.setEnabled(true);
        txtCedula.setEnabled(true);
        txtfechaFinPermiso.setEnabled(true);
      
        btnGuardarPermiso.setEnabled(true);
    }//GEN-LAST:event_btnNuevoPermisoActionPerformed

    private void btnGuardarPermisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPermisoActionPerformed

    }//GEN-LAST:event_btnGuardarPermisoActionPerformed

    private void txtvalorAPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtvalorAPagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtvalorAPagarActionPerformed

    private void txtvalorAPagarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtvalorAPagarKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtvalorAPagarKeyTyped

    private void txtnumDiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumDiasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumDiasActionPerformed

    private void txtfechaInicioPermisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfechaInicioPermisoActionPerformed
       
    }//GEN-LAST:event_txtfechaInicioPermisoActionPerformed

    private void txtfechaInicioPermisoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfechaInicioPermisoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfechaInicioPermisoKeyTyped

    private void cmbPermisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPermisoActionPerformed
        tipoPermiso();
    }//GEN-LAST:event_cmbPermisoActionPerformed

    private void cmbTipoPermisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoPermisoActionPerformed
    String tipoCalamidad = (String) cmbTipoPermiso.getSelectedItem();
    int numeroDias = calamidad.Calcular_Numero_Dias_Permiso(tipoCalamidad);
    txtnumDias.setText(Integer.toString(numeroDias));
    }//GEN-LAST:event_cmbTipoPermisoActionPerformed

    private void btnValidarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidarFechaActionPerformed
    try {
        fechaInicio();
        
    } catch (ParseException ex) {
        Logger.getLogger(Gestor_Permiso.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }//GEN-LAST:event_btnValidarFechaActionPerformed

    private void cmbnombreEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbnombreEmpleadoActionPerformed
        ObtenerCedula();
    }//GEN-LAST:event_cmbnombreEmpleadoActionPerformed

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
            java.util.logging.Logger.getLogger(Gestor_Permiso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gestor_Permiso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gestor_Permiso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gestor_Permiso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Gestor_Permiso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelAspirante;
    private javax.swing.JButton btnGuardarPermiso;
    private javax.swing.JButton btnNuevoPermiso;
    private javax.swing.JButton btnValidarFecha;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbPermiso;
    private javax.swing.JComboBox<String> cmbTipoPermiso;
    private javax.swing.JComboBox<String> cmbnombreEmpleado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblfechaFinPermiso;
    private javax.swing.JLabel lblfechaInicioPermiso1;
    private javax.swing.JLabel lblfechaInicioPermiso2;
    private javax.swing.JLabel lblfechaInicioPermiso3;
    private javax.swing.JLabel lblfechaInicioPermiso4;
    private javax.swing.JLabel lblfechaInicioPermiso5;
    private javax.swing.JLabel lblfechaInicioPermiso6;
    private javax.swing.JLabel lblnombreEmpleado1;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtfechaFinPermiso;
    private javax.swing.JTextField txtfechaInicioPermiso;
    private javax.swing.JTextField txtnumDias;
    private javax.swing.JTextField txtvalorAPagar;
    // End of variables declaration//GEN-END:variables

    private void clasefecha(int parseInt, int parseInt0, int parseInt1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
