
package com.epn.trappi.gui.logistico;

import com.epn.trappi.models.logistico.Entrega;
import com.epn.trappi.models.logistico.ListaEntregas;
import com.epn.trappi.models.logistico.MapaGeografico;
import com.epn.trappi.models.logistico.Posicion;
import com.epn.trappi.models.logistico.Ruta;
import com.epn.trappi.models.logistico.Vehiculo;
import com.epn.trappi.models.logistico.servicios.Consultable;
import com.epn.trappi.models.logistico.servicios.ServicioDb;
import com.epn.trappi.models.logistico.servicios.ServicioDbEntrega;
import com.epn.trappi.models.logistico.servicios.ServicioDbVehiculo;
import com.epn.trappi.models.logistico.servicios.Unible;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Alexander
 */
public class Entregas_en_Curso extends javax.swing.JPanel {
    //ATRIBUTOS
    ListaEntregas entregas;
    ServicioDb servicio;
    Consultable consultable;
    Unible unible;
    MapaGeografico mapa_rutas;
    int bandera=1;
    public JTable tabla;
    //CONSTRUCTOR
    public Entregas_en_Curso() {
        initComponents();
        tabla = tablaEntregas;
        entregas = new ListaEntregas();
        mapa_rutas = new MapaGeografico();
        panelRutas.add(mapa_rutas.grafico());
        graficarRuta("La Carolina");
        tablaEntregas.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    mostrarRuta(evt);
                } catch (Exception ex) {
                    Logger.getLogger(ListasVehiculos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    //METODOS
    public void setContadores() throws SQLException{
        
        int num_entregas=0;
        int num_autos=0;
        int num_motos=0;
        int num_camiones=0;
        
        contadorEntregas.setText(String.valueOf(num_entregas));
        contadorAutos.setText(String.valueOf(num_autos));
        contadorMotos.setText(String.valueOf(num_motos));
        contadorCamiones.setText(String.valueOf(num_camiones));
        
        
        servicio = new ServicioDbEntrega();
        unible = new ServicioDbEntrega();
        
        ArrayList<Entrega> entregas_activas = servicio.obtenerElementosPorFiltro(ServicioDbEntrega.ESTADO,"En Curso").getDatos();
        num_entregas=entregas_activas.size();
        if(num_entregas<=0){
            JOptionPane.showMessageDialog(null,"Actualmente no existen entregas activas");
            return;
        }
        Consultable consultableV = new ServicioDbVehiculo().obtenerElementos();
        ArrayList<Vehiculo> vehiculos_activos = (ArrayList<Vehiculo>) unible.join(entregas_activas, consultableV);
        for(int i=0;i<vehiculos_activos.size();i++){
            if("Automovil".equalsIgnoreCase(vehiculos_activos.get(i).getTipo().trim())){
                num_autos=num_autos+1;
            }
            if("Motocicleta".equalsIgnoreCase(vehiculos_activos.get(i).getTipo().trim())){
                num_motos++;
            }
            if("Camion".equalsIgnoreCase(vehiculos_activos.get(i).getTipo().trim())){
                num_camiones++;
            }
        }
        
        contadorEntregas.setText(String.valueOf(num_entregas));
        contadorAutos.setText(String.valueOf(num_autos));
        contadorMotos.setText(String.valueOf(num_motos));
        contadorCamiones.setText(String.valueOf(num_camiones));
    }
    
    public void setTablaEntregas() throws SQLException{
        entregas = new ListaEntregas();
        servicio = new ServicioDbEntrega();
        entregas.setEntregas(servicio.obtenerElementosPorFiltro(ServicioDbEntrega.ESTADO,"En curso").getDatos());
        if(entregas.estaVacia()){
            this.tablaEntregas.removeAll();
            if (this.tablaEntregas.getRowCount() > 0) {
                for(int i = this.tablaEntregas.getRowCount() - 1; i > -1; i--) {
                    this.tablaEntregas.removeRowSelectionInterval(i,i);
                }
            }
            return;
        }
        this.tablaEntregas.setModel(entregas.mostrarLista());
        entregas = null;
        
    }
    
    public void graficarRuta(String destino){
        Ruta ruta = new Ruta();
        String origen="Escuela Politécnica Nacional";
        ruta.definirRuta(new Posicion(mapeoDirecciones(origen)),new Posicion(mapeoDirecciones(destino)));
        mapa_rutas.trazarRuta(ruta);
    }
    
    
    
    private void mostrarRuta(java.awt.event.MouseEvent evt) throws SQLException, Exception {  
        int fila = tablaEntregas.getSelectedRow();
        if(fila==-1){
            JOptionPane.showMessageDialog(null,"Click en el registro para mostrar la ruta que tomó el vehículo.");
            return;
        }
        String direccion = (String)tablaEntregas.getValueAt(fila, 6);
        if(direccion==null){
            return;
        }
        graficarRuta(direccion);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        contadorAutos = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        contadorMotos = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        contadorEntregas = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        contadorCamiones = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        panelTabla = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        botonMinimizar = new javax.swing.JLabel();
        PANELTABLA = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEntregas = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        panelRutas = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(965, 870));
        jPanel2.setMinimumSize(new java.awt.Dimension(965, 870));
        jPanel2.setPreferredSize(new java.awt.Dimension(965, 870));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMaximumSize(new java.awt.Dimension(965, 170));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 223, 228)));
        jPanel8.setMaximumSize(new java.awt.Dimension(965, 40));
        jPanel8.setMinimumSize(new java.awt.Dimension(965, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(96, 97, 101));
        jLabel6.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("https://i.ibb.co/5Wyf8T9/statistics.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        jLabel6.setText("  Resumen");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel6)
                .addContainerGap(837, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel3.add(jPanel8, gridBagConstraints);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 223, 228)));
        jPanel9.setMaximumSize(new java.awt.Dimension(965, 125));
        jPanel9.setMinimumSize(new java.awt.Dimension(965, 125));

        jPanel18.setBackground(new java.awt.Color(0, 166, 90));

        contadorAutos.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        contadorAutos.setForeground(new java.awt.Color(255, 255, 255));
        contadorAutos.setText("0");

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Automóviles en uso");

        jLabel9.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("https://i.ibb.co/N9xxcq9/coche.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        jLabel9.setText("jLabel7");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(contadorAutos, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contadorAutos)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel19.setBackground(new java.awt.Color(255, 210, 28));

        jLabel13.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("https://i.ibb.co/4VwYYCM/scooter.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        jLabel13.setText("jLabel7");

        jLabel14.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Motocicletas en uso");

        contadorMotos.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        contadorMotos.setForeground(new java.awt.Color(255, 255, 255));
        contadorMotos.setText("0");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(contadorMotos, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contadorMotos)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel20.setBackground(new java.awt.Color(60, 141, 188));

        jLabel10.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("https://i.ibb.co/h1Jb3sT/entregas.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        jLabel10.setText("jLabel7");

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Entregas activas");

        contadorEntregas.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        contadorEntregas.setForeground(new java.awt.Color(255, 255, 255));
        contadorEntregas.setText("0");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(contadorEntregas, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contadorEntregas)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel21.setBackground(new java.awt.Color(34, 45, 50));

        jLabel16.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("https://i.ibb.co/Vg73FYJ/camion-de-carga.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        jLabel16.setText("jLabel7");

        jLabel17.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Camiones en uso");

        contadorCamiones.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        contadorCamiones.setForeground(new java.awt.Color(255, 255, 255));
        contadorCamiones.setText("0");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(contadorCamiones, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contadorCamiones)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel3.add(jPanel9, gridBagConstraints);

        jPanel10.setBackground(new java.awt.Color(96, 97, 101));
        jPanel10.setMaximumSize(new java.awt.Dimension(965, 5));
        jPanel10.setMinimumSize(new java.awt.Dimension(965, 5));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 965, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel3.add(jPanel10, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel2.add(jPanel3, gridBagConstraints);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.setMaximumSize(new java.awt.Dimension(965, 40));
        jPanel4.setMinimumSize(new java.awt.Dimension(965, 40));
        jPanel4.setPreferredSize(new java.awt.Dimension(965, 40));
        jPanel4.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPanel2.add(jPanel4, gridBagConstraints);

        panelTabla.setBackground(new java.awt.Color(255, 255, 255));
        panelTabla.setMaximumSize(new java.awt.Dimension(965, 295));
        panelTabla.setMinimumSize(new java.awt.Dimension(965, 45));
        panelTabla.setLayout(new java.awt.GridBagLayout());

        jPanel11.setBackground(new java.awt.Color(96, 97, 101));
        jPanel11.setForeground(new java.awt.Color(255, 255, 255));
        jPanel11.setMaximumSize(new java.awt.Dimension(965, 5));
        jPanel11.setMinimumSize(new java.awt.Dimension(965, 5));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 965, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        panelTabla.add(jPanel11, gridBagConstraints);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 223, 228)));
        jPanel12.setMaximumSize(new java.awt.Dimension(965, 40));
        jPanel12.setMinimumSize(new java.awt.Dimension(965, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(96, 97, 101));
        jLabel3.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("https://i.ibb.co/Pgdz0TQ/paquete.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        jLabel3.setText("  Entregas");

        botonMinimizar.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("https://i.ibb.co/rfNW4BD/minimizar.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        botonMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonMinimizarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 794, Short.MAX_VALUE)
                .addComponent(botonMinimizar)
                .addGap(34, 34, 34))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
            .addComponent(botonMinimizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelTabla.add(jPanel12, gridBagConstraints);

        PANELTABLA.setBackground(new java.awt.Color(255, 255, 255));
        PANELTABLA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 223, 228)));
        PANELTABLA.setMaximumSize(new java.awt.Dimension(965, 245));
        PANELTABLA.setMinimumSize(new java.awt.Dimension(965, 245));
        PANELTABLA.setName(""); // NOI18N
        PANELTABLA.setPreferredSize(new java.awt.Dimension(965, 245));

        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(96, 97, 101));

        tablaEntregas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 239, 239)));
        tablaEntregas.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        tablaEntregas.setForeground(new java.awt.Color(96, 97, 101));
        tablaEntregas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", "", null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Entrega", "ID Empleado", "Matrícula", "Factura", "Estado", "Fecha", "Direccion"
            }
        ));
        tablaEntregas.setGridColor(new java.awt.Color(239, 239, 239));
        tablaEntregas.setIntercellSpacing(new java.awt.Dimension(10, 4));
        tablaEntregas.setRowHeight(30);
        tablaEntregas.setSelectionBackground(new java.awt.Color(239, 239, 239));
        jScrollPane1.setViewportView(tablaEntregas);

        javax.swing.GroupLayout PANELTABLALayout = new javax.swing.GroupLayout(PANELTABLA);
        PANELTABLA.setLayout(PANELTABLALayout);
        PANELTABLALayout.setHorizontalGroup(
            PANELTABLALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANELTABLALayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 902, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        PANELTABLALayout.setVerticalGroup(
            PANELTABLALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANELTABLALayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelTabla.add(PANELTABLA, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        jPanel2.add(panelTabla, gridBagConstraints);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setMaximumSize(new java.awt.Dimension(965, 40));
        jPanel6.setMinimumSize(new java.awt.Dimension(965, 40));
        jPanel6.setPreferredSize(new java.awt.Dimension(965, 40));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        jPanel2.add(jPanel6, gridBagConstraints);

        jPanel7.setBackground(new java.awt.Color(204, 204, 255));
        jPanel7.setMaximumSize(new java.awt.Dimension(965, 420));
        jPanel7.setLayout(new java.awt.GridBagLayout());

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 223, 228)));
        jPanel15.setMaximumSize(new java.awt.Dimension(965, 375));
        jPanel15.setMinimumSize(new java.awt.Dimension(965, 125));

        panelRutas.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(panelRutas, javax.swing.GroupLayout.PREFERRED_SIZE, 919, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRutas, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        jPanel7.add(jPanel15, gridBagConstraints);

        jPanel16.setBackground(new java.awt.Color(96, 97, 101));
        jPanel16.setMaximumSize(new java.awt.Dimension(965, 5));
        jPanel16.setMinimumSize(new java.awt.Dimension(965, 5));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 965, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel16, new java.awt.GridBagConstraints());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 223, 228)));
        jPanel5.setMaximumSize(new java.awt.Dimension(965, 40));
        jPanel5.setMinimumSize(new java.awt.Dimension(965, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(96, 97, 101));
        jLabel4.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("https://i.ibb.co/n1ZDzC0/rutas.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        jLabel4.setText("  Rutas");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel4)
                .addContainerGap(864, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel7.add(jPanel5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        jPanel2.add(jPanel7, gridBagConstraints);

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setMaximumSize(new java.awt.Dimension(965, 80));
        jPanel17.setMinimumSize(new java.awt.Dimension(965, 80));
        jPanel17.setPreferredSize(new java.awt.Dimension(965, 80));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(96, 97, 101));
        jLabel2.setText("Entregas activas");
        jPanel17.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 25, -1, 40));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel2.add(jPanel17, gridBagConstraints);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setMaximumSize(new java.awt.Dimension(965, 40));
        jPanel14.setMinimumSize(new java.awt.Dimension(965, 40));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        jPanel2.add(jPanel14, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 965, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 70, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMinimizarMouseClicked

        if(bandera==1){
            this.PANELTABLA.setVisible(false);
            this.panelTabla.setPreferredSize(new Dimension(965, 45));
            this.jPanel7.setPreferredSize(new Dimension(965, 420));
            this.jPanel15.setPreferredSize(new Dimension(965, 375));
            bandera=0;
        }else{
            this.PANELTABLA.setVisible(true);
            this.jPanel7.setPreferredSize(new Dimension(965, 170));
            this.jPanel15.setPreferredSize(new Dimension(965, 125));
            this.panelTabla.setPreferredSize(new Dimension(965, 295));
            bandera=1;
        }
    }//GEN-LAST:event_botonMinimizarMouseClicked

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PANELTABLA;
    private javax.swing.JLabel botonMinimizar;
    private javax.swing.JLabel contadorAutos;
    private javax.swing.JLabel contadorCamiones;
    private javax.swing.JLabel contadorEntregas;
    private javax.swing.JLabel contadorMotos;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelRutas;
    private javax.swing.JPanel panelTabla;
    private javax.swing.JTable tablaEntregas;
    // End of variables declaration//GEN-END:variables

    // Método que sustituye a la API de Pago de Geolocalización de Google que mapea direcciones a identificadores ID Place
    
    public String mapeoDirecciones(String direccion){
        String id_direccion;
        direccion=direccion.trim();
        if(direccion.equalsIgnoreCase("Quicentro Shopping Norte")){
            id_direccion="ChIJf3SFnYOa1ZEReimBvayqhDo";
        }
        else if(direccion.equalsIgnoreCase("Megamaxi 6 de Diciembre")){//Origen por defecto
            id_direccion="ChIJv4XVroGa1ZERW6s47_m15Fc";
        }
        else if(direccion.equalsIgnoreCase("Machachi")){
            id_direccion="ChIJ8-NbUVOp1ZERQ_4RA_KCF7Q";
        }
        else if(direccion.equalsIgnoreCase("Av. Mariscal Sucre y America")){
            id_direccion="EiJBdi4gTWFyaXNjYWwgU3VjcmUsIFF1aXRvLCBFY3VhZG9yIi4qLAoUChIJa2cI9H-Z1ZERfoS-V7ofc74SFAoSCZ98QgJAmtWREXJV71jhkblE";
        }
        else if(direccion.equalsIgnoreCase("Condado Shopping")){
            id_direccion="ChIJI2LWRIyP1ZERCRxMID6_kSw";
        }
        else if(direccion.equalsIgnoreCase("Escuela Politécnica Nacional")){
            id_direccion="ChIJS9QcfhCa1ZER1J6TZk8oigg";
        }
        else if(direccion.equalsIgnoreCase("El Triangulo")){
            id_direccion="ChIJ4UTIWQC91ZER6_j8BJeknOY";
        }
        else if(direccion.equalsIgnoreCase("El Jardin")){
            id_direccion="ChIJRxIaia6b1ZER4-H-P9Id2rY";
        }
        else if(direccion.equalsIgnoreCase("Pomasqui")){
            id_direccion="ChIJp5h0q5GI1ZERKiEqfaC8iiM";
        }
        else if(direccion.equalsIgnoreCase("Mitad del Mundo")){
            id_direccion="ChIJka2b-B6I1ZERuKmhAJtp4bI";
        }
        else if(direccion.equalsIgnoreCase("Calderon")){
            id_direccion="ChIJdeAgQuSO1ZER-hmx6QhcBQM";
        }
        else if(direccion.equalsIgnoreCase("El Eden")){
            id_direccion="ChIJ7U-v-PCP1ZERMVu21To13Eg";
        }
        else if(direccion.equalsIgnoreCase("La Kennedy")){
            id_direccion="ChIJBaXUzlaF1ZER7CYp0UJhQ5Q";
        }
        else if(direccion.equalsIgnoreCase("La Carolina")){
            id_direccion="ChIJod6C1nqa1ZER3Y_6o5VXk0M";
        }
        else if(direccion.equalsIgnoreCase("Tababela")){
            id_direccion="ChIJFxL5MyCN1ZERk2VOOkZf7AI";
        }
        else if(direccion.equalsIgnoreCase("Av El Inca y Mariana de Jesus")){
            id_direccion="EjtBdmVuaWRhIEVsIEluY2EgJiBBdmVuaWRhIE1hcmlhbmEgZGUgSmVzw7pzLCBRdWl0bywgRWN1YWRvciJmImQKFAoSCQ8KuCjXvNWRETI2jOUVDtguEhQKEgkPCrgo17zVkREyNozlFQ7YLhoUChIJXx1tjNu81ZERbNz2R57Zm0AaFAoSCTEQqtknvdWRETR4z-lkQcy1IgoNa_bM_xU29jrR";
        }
        else if(direccion.equalsIgnoreCase("Av. Teniente Hugo Ortiz y 5 de Junio")){
            id_direccion="EiRBdi4gVG50ZS4gSHVnbyBPcnRpeiwgUXVpdG8sIEVjdWFkb3IiLiosChQKEgkROp1n-5jVkRGzJIigi0bJZxIUChIJn3xCAkCa1ZERclXvWOGRuUQ";
        }
        else if(direccion.equalsIgnoreCase("Av Gral Rumiñahui y Nela Martinez")){
            id_direccion="EiRBdi4gR3JhbC4gUnVtacOxYWh1aSwgUXVpdG8sIEVjdWFkb3IiLiosChQKEglLXNsA9ZfVkRE1zP5x0260eRIUChIJn3xCAkCa1ZERclXvWOGRuUQ";
        }
        else{
            id_direccion="EiJBdi4gTWFyaXNjYWwgU3VjcmUsIFF1aXRvLCBFY3VhZG9yIi4qLAoUChIJa2cI9H-Z1ZERfoS-V7ofc74SFAoSCZ98QgJAmtWREXJV71jhkblE";//Destino por defecto - Machachi
        }
        return id_direccion;
    }
    
}
