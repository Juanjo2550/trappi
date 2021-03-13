
package com.epn.trappi.gui.logistico;

import com.epn.trappi.gui.logistico.Logistico_GUI.RoundedBorder;
import com.epn.trappi.models.logistico.*;
import com.epn.trappi.models.logistico.servicios.Consultable;
import com.epn.trappi.models.logistico.servicios.ServicioDb;
import com.epn.trappi.models.logistico.servicios.ServicioDbEntrega;
import com.epn.trappi.models.logistico.servicios.ServicioDbVehiculo;
import com.epn.trappi.models.logistico.servicios.Unible;
import static com.epn.trappi.models.logistico.servicios.ServicioVerificacion.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Alexander
 */
public class ListasVehiculos extends javax.swing.JPanel {
    Consultable consultable;
    Unible unible;
    ListaVehiculos vehiculos;
    Usos_ViewHandler historial;
    public ListasVehiculos() {
        initComponents();
        historial = new Usos_ViewHandler();
        vehiculos = new ListaVehiculos();
        tablaListaVehiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    llenarHistorialDeUsos(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(ListasVehiculos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ListasVehiculos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        this.btnBuscarVehiculo.setBorder(new RoundedBorder(24));
    }
    private void llenarHistorialDeUsos(java.awt.event.MouseEvent evt) throws SQLException, Exception {                                             

        historial.reiniciarEstado();
        int fila = tablaListaVehiculos.getSelectedRow();
        String matricula = (String)tablaListaVehiculos.getValueAt(fila, 1); //OBTENEMOS EL VALOR DE LA MATRICULA
        
        //Obtenemos las entregas que se hayan hecho con ese vehiculo
        ServicioDb servicioDB = new ServicioDbEntrega();
        ArrayList<Entrega> entregas_por_vehiculo = servicioDB.obtenerElementosPorFiltro(ServicioDbEntrega.MATRICULA, matricula).getDatos();
        if(entregas_por_vehiculo.isEmpty()){
            JOptionPane.showMessageDialog(null,"El vehículo seleccionado aún no a sido utilizado en una entrega");
            this.panelHistorial.setVisible(false);
            this.panelHistorial.setVisible(true);
            return;
        }
        //Llenamos el historial con estos datos
        
        historial.llenar(entregas_por_vehiculo);
        Component lista = historial.obtenerListView();
        this.panelHistorial.add(lista);
        //this.panelHistorial.setPreferredSize(lista.getPreferredSize());
        this.panelHistorial.setVisible(false);
        this.panelHistorial.setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbBusquedaVehiculos = new javax.swing.JComboBox<>();
        txtBusquedaVehiculos = new javax.swing.JTextField();
        btnBuscarVehiculo = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        campoRegistros = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaListaVehiculos = new javax.swing.JTable();
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
        jLabel1.setText("Lista de vehículos");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(219, 223, 228), 1, true));
        jPanel2.setForeground(new java.awt.Color(61, 57, 57));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Filtros de búsqueda");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(61, 57, 57));
        jLabel6.setText("Atributo de búsqueda:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 30));

        cmbBusquedaVehiculos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBusquedaVehiculos.setForeground(new java.awt.Color(61, 57, 57));
        cmbBusquedaVehiculos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Matrícula", "Tipo de Vehículo", "Estado", "Kilometraje", "ID Vehículo" }));
        cmbBusquedaVehiculos.setBorder(null);
        jPanel2.add(cmbBusquedaVehiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 140, 30));

        txtBusquedaVehiculos.setFont(new java.awt.Font("Segoe UI Semibold", 2, 14)); // NOI18N
        txtBusquedaVehiculos.setForeground(new java.awt.Color(153, 153, 153));
        txtBusquedaVehiculos.setText("Ingrese el valor de la columna que desea filtrar");
        txtBusquedaVehiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBusquedaVehiculosMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtBusquedaVehiculosMouseExited(evt);
            }
        });
        jPanel2.add(txtBusquedaVehiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 370, 30));

        btnBuscarVehiculo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N
        btnBuscarVehiculo.setForeground(new java.awt.Color(61, 57, 57));
        btnBuscarVehiculo.setText("Buscar");
        btnBuscarVehiculo.setContentAreaFilled(false);
        btnBuscarVehiculo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnBuscarVehiculoMouseMoved(evt);
            }
        });
        btnBuscarVehiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBuscarVehiculoMouseExited(evt);
            }
        });
        btnBuscarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarVehiculoActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscarVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 70, 110, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(61, 57, 57));
        jLabel7.setText("Limitar la cantidad de registros:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, -1, 30));

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
        jPanel2.add(campoRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 120, 240, 30));

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

        jPanel1.setBackground(new java.awt.Color(19, 155, 151));
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
                        new java.net.URL("https://i.ibb.co/2sgYHq3/dos-autos-en-linea.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        jLabel8.setText("  Vehículos");
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 14, 170, 30));

        jPanel6.setBackground(new java.awt.Color(19, 155, 151));
        jPanel6.setPreferredSize(new java.awt.Dimension(970, 5));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, -1));

        jPanel4.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 50));

        tablaListaVehiculos.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        tablaListaVehiculos.setForeground(new java.awt.Color(61, 57, 57));
        tablaListaVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Matrícula", "Estado", "Tipo", "Kilometraje"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaListaVehiculos.setFocusable(false);
        tablaListaVehiculos.setGridColor(new java.awt.Color(153, 153, 153));
        tablaListaVehiculos.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tablaListaVehiculos.setOpaque(false);
        tablaListaVehiculos.setRowHeight(30);
        tablaListaVehiculos.setSelectionBackground(new java.awt.Color(61, 57, 57));
        tablaListaVehiculos.setShowVerticalLines(false);
        tablaListaVehiculos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaListaVehiculos);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 520, 390));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 223, 228)));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setBorder(null);

        panelHistorial.setBackground(new java.awt.Color(255, 255, 255));
        panelHistorial.setLayout(new javax.swing.BoxLayout(panelHistorial, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane3.setViewportView(panelHistorial);

        jPanel5.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 370));

        jPanel9.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 290, 390));

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
        jLabel9.setText("  Historial de uso del vehículo");
        jPanel10.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 14, 240, 30));

        jPanel11.setBackground(new java.awt.Color(96, 97, 101));
        jPanel11.setPreferredSize(new java.awt.Dimension(270, 5));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel10.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, -1));

        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE))
                .addContainerGap(88, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarVehiculoActionPerformed
        int opcion = cmbBusquedaVehiculos.getSelectedIndex();
        String campo_busqueda = txtBusquedaVehiculos.getText();
        ServicioDb servicioDB = new ServicioDbVehiculo();
        try{
        switch (opcion){
            case 0:
                vehiculos.setVehiculos(servicioDB.obtenerElementos().getDatos());
                break;
            case 1:
                strErrores+=verificarMatricula(campo_busqueda);
                if(!strErrores.equals(""))
                {
                    strErrores="Errores existentes:\n"+strErrores;
                    JOptionPane.showMessageDialog(null, strErrores , "Error al Buscar el Vehículo" , JOptionPane.ERROR_MESSAGE);
                    strErrores="";
                    return;
                }else {
                    vehiculos.setVehiculos(servicioDB.obtenerElementosPorFiltro(ServicioDbVehiculo.MATRICULA,campo_busqueda).getDatos());
                    break;
                }
            case 2:
                strErrores+=verificarTipo(campo_busqueda);
                if(!strErrores.equals(""))
                {
                    strErrores="Errores existentes:\n"+strErrores;
                    JOptionPane.showMessageDialog(null, strErrores , "Error al Buscar por Tipo" , JOptionPane.ERROR_MESSAGE);
                    strErrores="";
                    return;
                }else {
                vehiculos.setVehiculos(servicioDB.obtenerElementosPorFiltro(ServicioDbVehiculo.TIPO,campo_busqueda).getDatos());
                break;
                }
            case 3:
                strErrores+=verificarEstado(campo_busqueda);
                if(!strErrores.equals(""))
                {
                    strErrores="Errores existentes:\n"+strErrores;
                    JOptionPane.showMessageDialog(null, strErrores , "Error al Buscar por Estado" , JOptionPane.ERROR_MESSAGE);
                    strErrores="";
                    return;
                }else {
                vehiculos.setVehiculos(servicioDB.obtenerElementosPorFiltro(ServicioDbVehiculo.ESTADO,campo_busqueda).getDatos());
                break;
                }
            case 4:
                strErrores+=verificarKilometraje(campo_busqueda);
                if(!strErrores.equals(""))
                {
                    strErrores="Errores existentes:\n"+strErrores;
                    JOptionPane.showMessageDialog(null, strErrores , "Error al Buscar por Kilometraje" , JOptionPane.ERROR_MESSAGE);
                    strErrores="";
                    return;
                }else {
                vehiculos.setVehiculos(servicioDB.obtenerElementosPorFiltro(ServicioDbVehiculo.KILOMETRAJE,campo_busqueda).getDatos());
                break;
                }
            case 5:
                strErrores+=verificarID(campo_busqueda);
                if(!strErrores.equals(""))
                {
                    strErrores="Errores existentes:\n"+strErrores;
                    JOptionPane.showMessageDialog(null, strErrores , "Error al Buscar por ID" , JOptionPane.ERROR_MESSAGE);
                    strErrores="";
                    return;
                }else {
                vehiculos.setVehiculos(servicioDB.obtenerElementosPorFiltro(ServicioDbVehiculo.ID_VEHICULO,campo_busqueda).getDatos());
                break;
                }
        }
        int numero_registros=0;
        String numero = campoRegistros.getText();
        if(numero.length()!=0){
        try{
            //Si el numero de registros solicitados es mayor que los actuales entonces se considera el ultimo 
            numero_registros=Integer.parseInt(numero);
            if(numero_registros>vehiculos.getVehiculos().size()){
                numero_registros=vehiculos.getVehiculos().size();
            }
            ArrayList<Vehiculo> lista = new ArrayList<>();
            for(int puntero=0;puntero<numero_registros;puntero++){
                lista.add(vehiculos.getVehiculos().get(puntero));
            }
            vehiculos.setVehiculos(lista);
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Ingrese un valor entero para el número de registros");
        }
        }
        this.tablaListaVehiculos.setModel(vehiculos.mostrarLista());
        }catch (SQLException e){
                JOptionPane.showMessageDialog(null,"Base de datos fuera de servicio");
                }
    }//GEN-LAST:event_btnBuscarVehiculoActionPerformed

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

    private void txtBusquedaVehiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBusquedaVehiculosMouseClicked
        txtBusquedaVehiculos.setText("");
        txtBusquedaVehiculos.setForeground(new Color(0,0,0));
        txtBusquedaVehiculos.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
    }//GEN-LAST:event_txtBusquedaVehiculosMouseClicked

    private void txtBusquedaVehiculosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBusquedaVehiculosMouseExited
        if (txtBusquedaVehiculos.getText().length()==0){
            txtBusquedaVehiculos.setForeground(new Color(153,153,153));
            txtBusquedaVehiculos.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 14));
            txtBusquedaVehiculos.setText("Ingrese el valor de la columna que desea filtrar");
        }
    }//GEN-LAST:event_txtBusquedaVehiculosMouseExited

    private void btnBuscarVehiculoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarVehiculoMouseMoved
        Color c = new Color(19,155,151);
        this.btnBuscarVehiculo.setForeground(c);
    }//GEN-LAST:event_btnBuscarVehiculoMouseMoved

    private void btnBuscarVehiculoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarVehiculoMouseExited
        Color c = new Color(61,57,57);
        this.btnBuscarVehiculo.setForeground(c);
    }//GEN-LAST:event_btnBuscarVehiculoMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarVehiculo;
    private javax.swing.JTextField campoRegistros;
    private javax.swing.JComboBox<String> cmbBusquedaVehiculos;
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
    private javax.swing.JTable tablaListaVehiculos;
    private javax.swing.JTextField txtBusquedaVehiculos;
    // End of variables declaration//GEN-END:variables
    private String strErrores="";
}
