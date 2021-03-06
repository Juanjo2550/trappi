/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.rrhh;

import com.epn.trappi.gui.rrhh.Permisos.Calamidad_Domestica;
import com.epn.trappi.models.rrhh.juanjo.Empleado;
import com.epn.trappi.models.rrhh.Fecha;
import com.epn.trappi.models.rrhh.TextPrompt;
import com.epn.trappi.db.connection.DataBaseConnection;



import com.epn.trappi.gui.rrhh.Permisos.Enfermedad;
import com.epn.trappi.gui.rrhh.Permisos.Nacimiento_Hijo;
import com.epn.trappi.gui.rrhh.Permisos.Otros_Permisos;
import com.epn.trappi.gui.rrhh.Permisos.Permiso;
import com.epn.trappi.models.rrhh.diego.SolicitudDePago;
import com.epn.trappi.models.rrhh.juanjo.Administrativo;
import com.epn.trappi.models.rrhh.juanjo.Conductor;
import com.epn.trappi.models.rrhh.listas.Lista;
import com.epn.trappi.models.rrhh.listas.ListaPermisos;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author stali
 */
public class Gestor_Permiso extends javax.swing.JFrame {
Calamidad_Domestica calamidad = new Calamidad_Domestica();
Permiso permission ;
Nacimiento_Hijo nacimiento = new Nacimiento_Hijo();
Otros_Permisos otro = new Otros_Permisos();
Enfermedad enfermedad = new Enfermedad();
Fecha fecha = new Fecha();
Connection connection = Objects.requireNonNull(DataBaseConnection.getInstance()).getConnection();

 ListaPermisos permisos = new ListaPermisos();
    
    /*
     * Creates new form Ejemplo_GUI
     */

    @Override
    public Dimension size() {
        return super.size(); //To change body of generated methods, choose Tools | Templates.
    }

    public Gestor_Permiso() {
        
        initComponents();
          obtenerNombre();
          listarPermisos();
        cmbnombreEmpleado.setEnabled(true);
        txtCedula.setEnabled(false);
        txtfechaFinPermiso.setEnabled(false);
        txtDescripcion.setEnabled(false);
        this.txtfechaInicioPermiso.setEnabled(false);
        btnGuardarPermiso.setEnabled(true);
        TextPrompt buscarProveedor = new TextPrompt("yyyy-MM-dd", txtfechaInicioPermiso);
        TextPrompt finpermiso = new TextPrompt("yyyy-MM-dd", txtfechaFinPermiso);
        TextPrompt diasPermiso = new TextPrompt("Ingrese el número de días", this.txtnumDias);
        TextPrompt descripcion = new TextPrompt("Ingrese la descripción del permiso", this.txtDescripcion);
        
    }

    private static String getTwoDecimals(double value){
      DecimalFormat df = new DecimalFormat("0.00"); 
      return df.format(value);
    }
    
       public String[] tipoPermiso(String tipo){
       String [] Permisos = new String [10];
       char sexoEmpleado = buscarUno().getSexo();
        if(tipo.equalsIgnoreCase("Calamidad Domestica")){
            this.cmbTipoPermiso.setEnabled(true);
            txtDescripcion.setEnabled(false);
            Permisos[0]= "Seleccione...";
       Permisos[1]="muerte de padres, hermanos, hijos, cónyuge";
       Permisos[2]="muerte de nietos, padres del cónyuge o hermanos de la pareja";
       Permisos[3]="enfermedad de hijos o conyuge";
       Permisos[4]="enfermedad de padres o hermanos";
    }
        if (tipo.equalsIgnoreCase("Enfermedad")){
           this.txtDescripcion.setEnabled(true);
           this.cmbTipoPermiso.setEnabled(false);
        }
        if (tipo.equalsIgnoreCase("Otros Permisos")){
           this.txtDescripcion.setEnabled(true);
           this.cmbTipoPermiso.setEnabled(false);
        }
        if (tipo.equalsIgnoreCase("Nacimiento Hijos")){
             this.cmbTipoPermiso.setEnabled(true);
            this.txtDescripcion.setEnabled(false);
            if("M".equalsIgnoreCase(String.valueOf(sexoEmpleado))){
                Permisos[0]= "Seleccione...";
            Permisos[1]="Nacimiento Hijo (Parto Normal)";
            Permisos[2]="Nacimiento Multiple o Parto Cesarea";
            Permisos[3]="Nacimiento Prematuro";
            Permisos[4]="Nacimiento con enfermedad degenerativa";
            }
            else{
                Permisos[0]= "Seleccione...";
            Permisos[1]="Nacimiento Hijo (Parto Normal)";
            Permisos[2]="Nacimiento Multiple o Parto Cesarea";
            
            }

        }
            return Permisos;
     }  
       

       
           
//metodo para obtener el nombre y apellido de la persona que quiere solicitar el permiso
     public void obtenerNombre(){
        String sql = "SELECT * FROM dbo.EMPLEADO";
        ArrayList<Empleado> empleados = new ArrayList<>();
        try {
        Statement createdStatment = connection.createStatement();
            ResultSet resultSet = createdStatment.executeQuery(sql);
             cmbnombreEmpleado.addItem("Seleccione...");
            while(resultSet.next()) {
                String nombre = resultSet.getString("NOMBREEMP");
                String apellido = resultSet.getString("APELLIDOEMP");
                String nombre_completo = nombre + "_" + apellido;
              cmbnombreEmpleado.addItem(nombre_completo);
            }
            
        } catch (SQLException e){
            System.out.println(e.toString());
        }
    }
     
     // este metodo se utiliza para mostrar los permisos en la tabla 
         private void listarPermisos(){
        Lista listaPermisos = new ListaPermisos();
        Permiso[] permisos = (Permiso[]) listaPermisos.obtenerTodos();

        DefaultTableModel model = (DefaultTableModel) tbllista.getModel();
        model.setRowCount(0);
        
        for (Permiso asp: permisos){
            Vector v = new Vector();

                v.add(asp.getEmpleado().getNombres() + " " + asp.getEmpleado().getApellidos());
                v.add(asp.getCOMENTPERM());
                v.add(asp.getFECHAINICIOPERM());
                v.add(asp.getFECHAFINPERM());
                v.add(asp.getNUMDIASPERM());
                v.add(asp.getVALORPAGARPERM());
                v.add(asp.getESTADOPERM());

                model.addRow(v); 

            tbllista.setModel(model);
        }
    }
    

  // este metodo se utiliza para obtener un empleado en especifico   
          public Empleado buscarUno(){
              Empleado empleadoObtenido = null;
          
              String nombre_Completo = (String) cmbnombreEmpleado.getSelectedItem();
          String[] partes = nombre_Completo.split("_");
          String nombreEmpleado = partes[0];
         
            String apellido = partes[1];   
        String sql = "SELECT * FROM dbo.EMPLEADO WHERE (NOMBREEMP='" + nombreEmpleado + "'" + "and APELLIDOEMP='" +apellido+ "')";
        
        try {
            Statement createdStatement = this.connection.createStatement();
            ResultSet resultSet = createdStatement.executeQuery(sql);
            while(resultSet.next()) {
                if (resultSet.getString(10).equals("conductor")) {
                    empleadoObtenido = new Conductor(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getString(8),
                            resultSet.getString(11),
                            resultSet.getString(9),
                            resultSet.getString(12).charAt(0)
                    );
                } else {
                    empleadoObtenido = new Administrativo(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getString(8),
                            resultSet.getString(11),
                            resultSet.getString(9),
                            resultSet.getString(12).charAt(0)
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }

          return empleadoObtenido;
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
            String FinPermiso= fecha.sumarDiasAFecha(fechaInicio, Integer.parseInt(txtnumDias.getText()));
            txtfechaFinPermiso.setText(FinPermiso);
        }
        else{
            JOptionPane.showMessageDialog(null, "Fecha Ingresada no Valida");
        }
        }catch(Exception e){
            
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        PanelAspirante = new javax.swing.JPanel();
        lblCedula = new javax.swing.JLabel();
        btnGuardarPermiso = new javax.swing.JButton();
        btnNuevoPermiso = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        lblfechaFinPermiso = new javax.swing.JLabel();
        txtfechaFinPermiso = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbllista = new javax.swing.JTable();
        cmbTipoPermiso = new javax.swing.JComboBox<>();
        lblnombreEmpleado1 = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        lblfechaInicioPermiso2 = new javax.swing.JLabel();
        txtvalorAPagar = new javax.swing.JTextField();
        cmbEstado = new javax.swing.JComboBox<>();
        lblfechaInicioPermiso3 = new javax.swing.JLabel();
        txtnumDias = new javax.swing.JTextField();
        lblfechaInicioPermiso4 = new javax.swing.JLabel();
        txtfechaInicioPermiso = new javax.swing.JTextField();
        lblfechaInicioPermiso6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
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
        jLabel2.setText("Gestor De Permisos");

        btnVolver.setBackground(new java.awt.Color(204, 153, 0));
        btnVolver.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(51, 51, 51));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("RECURSOS HUMANOS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(814, Short.MAX_VALUE)))
        );

        PanelAspirante.setBackground(new java.awt.Color(255, 255, 255));
        PanelAspirante.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCedula.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCedula.setText("Cedula:");
        PanelAspirante.add(lblCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, -1, -1));

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
        PanelAspirante.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, -1, -1));

        lblfechaFinPermiso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblfechaFinPermiso.setText("Fin de Permiso: ");
        PanelAspirante.add(lblfechaFinPermiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, -1, -1));

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
        PanelAspirante.add(txtfechaFinPermiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 290, 200, 28));

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
        PanelAspirante.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 180, 28));

        tbllista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre del Empleado", "Descripción", "Fecha Inicio", "Fecha  Fin", "Dias de Permiso", "Valor a Pagar", "Estado"
            }
        ));
        jScrollPane1.setViewportView(tbllista);

        PanelAspirante.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 860, 150));

        cmbTipoPermiso.setToolTipText("");
        cmbTipoPermiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoPermisoActionPerformed(evt);
            }
        });
        PanelAspirante.add(cmbTipoPermiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, 290, -1));

        lblnombreEmpleado1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblnombreEmpleado1.setText(" Empleado:");
        PanelAspirante.add(lblnombreEmpleado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        lblDescripcion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDescripcion.setText("Descripción");
        PanelAspirante.add(lblDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        lblfechaInicioPermiso2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblfechaInicioPermiso2.setText("Fecha Inicio: ");
        PanelAspirante.add(lblfechaInicioPermiso2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

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
        PanelAspirante.add(txtvalorAPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 240, 200, 28));

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aprobado", "Denegado" }));
        cmbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoActionPerformed(evt);
            }
        });
        PanelAspirante.add(cmbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 160, -1));

        lblfechaInicioPermiso3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblfechaInicioPermiso3.setText("Estado: ");
        PanelAspirante.add(lblfechaInicioPermiso3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        txtnumDias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumDiasActionPerformed(evt);
            }
        });
        txtnumDias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnumDiasKeyPressed(evt);
            }
        });
        PanelAspirante.add(txtnumDias, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 80, 30));

        lblfechaInicioPermiso4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblfechaInicioPermiso4.setText("Días de Permiso:");
        PanelAspirante.add(lblfechaInicioPermiso4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

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
        PanelAspirante.add(txtfechaInicioPermiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 200, 28));

        lblfechaInicioPermiso6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblfechaInicioPermiso6.setText("Valor a Pagar por Permiso: ");
        PanelAspirante.add(lblfechaInicioPermiso6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, -1, -1));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        PanelAspirante.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 710, 70));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Permiso:");
        PanelAspirante.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        cmbPermiso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "Calamidad Domestica", "Enfermedad", "Nacimiento Hijos", "Otros Permisos" }));
        cmbPermiso.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPermisoItemStateChanged(evt);
            }
        });
        cmbPermiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPermisoActionPerformed(evt);
            }
        });
        PanelAspirante.add(cmbPermiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 180, -1));

        btnValidarFecha.setText("Validar");
        btnValidarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidarFechaActionPerformed(evt);
            }
        });
        PanelAspirante.add(btnValidarFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, -1, -1));

        cmbnombreEmpleado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbnombreEmpleadoItemStateChanged(evt);
            }
        });
        cmbnombreEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbnombreEmpleadoActionPerformed(evt);
            }
        });
        PanelAspirante.add(cmbnombreEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 240, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelAspirante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelAspirante, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 12, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        PANTALLA_PRINCIPAL principal = new PANTALLA_PRINCIPAL();
        principal.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVolverActionPerformed

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
        this.txtnumDias.setText("");
        this.txtfechaInicioPermiso.setText("");
        this.txtfechaFinPermiso.setText("");
        this.cmbPermiso.setSelectedItem("Seleccione...");
        this.cmbTipoPermiso.setSelectedItem("Seleccione...");
        this.cmbnombreEmpleado.setSelectedItem("Seleccione...");
        this.txtCedula.setText("");
        cmbnombreEmpleado.setEnabled(true);
        txtCedula.setEnabled(false);
        txtfechaFinPermiso.setEnabled(true);
      
        btnGuardarPermiso.setEnabled(true);
    }//GEN-LAST:event_btnNuevoPermisoActionPerformed

    private void btnGuardarPermisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPermisoActionPerformed
  String tipoPermiso = (String) cmbPermiso.getSelectedItem();
   int numeroDias = Integer.parseInt(txtnumDias.getText());
   String valorPagar = txtvalorAPagar.getText();
   String descripcionPermiso = (String) cmbTipoPermiso.getSelectedItem();
   String descripcionPermisoEnferOtra = txtDescripcion.getText();
   String fechaInicio = txtfechaInicioPermiso.getText();
   String fechaFin = txtfechaFinPermiso.getText();
   String estado = (String)cmbEstado.getSelectedItem();
   Empleado id = buscarUno();

   
   if(tipoPermiso.equals("Calamidad Domestica")){
      
      permission= new Calamidad_Domestica(
              id,numeroDias, valorPagar,descripcionPermiso,fechaInicio,fechaFin,estado
      );    
      permisos.agregar(permission);
   }
   if(tipoPermiso.equals("Enfermedad")){
       permission = new Enfermedad(id,numeroDias, valorPagar,descripcionPermisoEnferOtra,fechaInicio,fechaFin,estado);
       permisos.agregar(permission);
   }
   if(tipoPermiso.equals("Nacimiento Hijos")){
       permission = new Nacimiento_Hijo(id,numeroDias, valorPagar,descripcionPermiso,fechaInicio,fechaFin,estado);
       permisos.agregar(permission);
   }
   if (tipoPermiso.equals("Otros Permisos")) {
       permission = new Otros_Permisos(id,numeroDias, valorPagar,descripcionPermisoEnferOtra,fechaInicio,fechaFin,estado);
       permisos.agregar(permission);
   }
   listarPermisos();
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
   
        
        
        
    }//GEN-LAST:event_cmbPermisoActionPerformed

    private void cmbTipoPermisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoPermisoActionPerformed
    String tipo_Permiso = this.cmbPermiso.getSelectedItem().toString();
    String tipoCalamidad = (String) cmbTipoPermiso.getSelectedItem();
    String tipoNacimiento = (String) cmbTipoPermiso.getSelectedItem();
    
    if("Calamidad Domestica".equalsIgnoreCase(tipo_Permiso)){
        int numeroDias = calamidad.calcularNumeroDias(tipoCalamidad,buscarUno().getSexo());
        txtnumDias.setText(Integer.toString(numeroDias));
    }
    if ("Nacimiento Hijos".equalsIgnoreCase(tipo_Permiso)){
        int numeroDias = nacimiento.calcularNumeroDias(tipoCalamidad,buscarUno().getSexo());
        txtnumDias.setText(Integer.toString(numeroDias));
    }
    
    
    }//GEN-LAST:event_cmbTipoPermisoActionPerformed

    private void btnValidarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidarFechaActionPerformed
    try {
        fechaInicio();
        this.txtfechaFinPermiso.setEnabled(false);
        this.cmbEstado.setEnabled(true);
        
    } catch (ParseException ex) {
        Logger.getLogger(Gestor_Permiso.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }//GEN-LAST:event_btnValidarFechaActionPerformed

    private void cmbnombreEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbnombreEmpleadoActionPerformed
        
        
    }//GEN-LAST:event_cmbnombreEmpleadoActionPerformed

    private void cmbPermisoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPermisoItemStateChanged
        if(evt.getStateChange()==ItemEvent.SELECTED){
            if(cmbPermiso.getSelectedIndex()>0){
                this.cmbTipoPermiso.setModel(new DefaultComboBoxModel(tipoPermiso(cmbPermiso.getSelectedItem().toString())));
            }
           
        }
    }//GEN-LAST:event_cmbPermisoItemStateChanged

    private void cmbnombreEmpleadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbnombreEmpleadoItemStateChanged
        if(evt.getStateChange()==ItemEvent.SELECTED){
            if(this.cmbnombreEmpleado.getSelectedIndex()>0){
                this.cmbPermiso.setEnabled(true);
                Empleado obtenerCedula = buscarUno();
                txtCedula.setText(obtenerCedula.getCedula());
                
                //this.cmbTipoPermiso.setModel(new DefaultComboBoxModel(tipoPermiso(cmbPermiso.getSelectedItem().toString())));
            }
            else{
                txtCedula.setText("");
                this.cmbPermiso.setEnabled(false);
                this.txtfechaInicioPermiso.setEnabled(false);
                this.txtfechaFinPermiso.setEditable(false);
                //this.txtnumDias.setEnabled(false);
                this.cmbEstado.setEnabled(false);
            }
        }
    }//GEN-LAST:event_cmbnombreEmpleadoItemStateChanged

    private void txtnumDiasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnumDiasKeyPressed
       try{
          String permiso = this.cmbPermiso.getSelectedItem().toString();
       double sueldoEmpleado = Double.parseDouble(buscarUno().getSueldo());
       
            int numeroDiasPermiso = Integer.parseInt(txtnumDias.getText());
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if("Enfermedad".equals(permiso)){
            String valorPago = enfermedad.calcularProporcionalPagar(sueldoEmpleado,numeroDiasPermiso);
            double valorPagoDosDecimales = Double.parseDouble(valorPago);
            String valorPagarString = getTwoDecimals(valorPagoDosDecimales);
           this.txtvalorAPagar.setText(valorPagarString);
           this.txtvalorAPagar.setEnabled(false);
            }
            if("Nacimiento Hijos".equals(permiso)){
            String valorPago = enfermedad.calcularProporcionalPagar(sueldoEmpleado,numeroDiasPermiso);
            double valorPagoDosDecimales = Double.parseDouble(valorPago);
            String valorPagarString = getTwoDecimals(valorPagoDosDecimales);
            
            
           this.txtvalorAPagar.setText(valorPagarString);
           this.txtvalorAPagar.setEnabled(false);
           
            }
            this.txtfechaInicioPermiso.setEnabled(true);
            
            
        } 
       }
       catch (Exception e){
           
       }
        
        
    }//GEN-LAST:event_txtnumDiasKeyPressed

    private void cmbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoActionPerformed
        
    }//GEN-LAST:event_cmbEstadoActionPerformed

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
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbPermiso;
    private javax.swing.JComboBox<String> cmbTipoPermiso;
    private javax.swing.JComboBox<String> cmbnombreEmpleado;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblfechaFinPermiso;
    private javax.swing.JLabel lblfechaInicioPermiso2;
    private javax.swing.JLabel lblfechaInicioPermiso3;
    private javax.swing.JLabel lblfechaInicioPermiso4;
    private javax.swing.JLabel lblfechaInicioPermiso6;
    private javax.swing.JLabel lblnombreEmpleado1;
    private javax.swing.JTable tbllista;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtfechaFinPermiso;
    private javax.swing.JTextField txtfechaInicioPermiso;
    private javax.swing.JTextField txtnumDias;
    private javax.swing.JTextField txtvalorAPagar;
    // End of variables declaration//GEN-END:variables

    private void clasefecha(int parseInt, int parseInt0, int parseInt1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
