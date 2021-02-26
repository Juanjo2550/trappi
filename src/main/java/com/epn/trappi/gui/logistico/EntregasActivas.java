package com.epn.trappi.gui.logistico;
import com.epn.trappi.models.logistico.ListaConductores;
import com.epn.trappi.models.logistico.ListaEntregas1;
import com.epn.trappi.models.logistico.ListaVehiculos;
import com.epn.trappi.models.logistico.MapaGeografico;
import com.epn.trappi.models.logistico.Posicion;
import com.epn.trappi.models.logistico.Ruta;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

public class EntregasActivas extends javax.swing.JPanel {
    //ATRIBUTOS
    MapaGeografico mapa;
    public EntregasActivas() {
        initComponents();
        //MAPA GEOGRAFICO
        mapa = new MapaGeografico();
        this.panelDeRutas.add(mapa.grafico(),BorderLayout.CENTER);//añadimos la vista del mapa al panel de rutas
        //Llenado de tabla con datos quemados
        ListaVehiculos vehiculos = new ListaVehiculos();
        ListaConductores conductores = new ListaConductores();
        ListaEntregas1 entregas = new ListaEntregas1();      
        DefaultTableModel modelo = new DefaultTableModel();
        jTEntregasDatos.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12) {
        });
        jTEntregasDatos.getTableHeader().setOpaque(false);
        jTEntregasDatos.getTableHeader().setBackground(Color.BLACK);
        jTEntregasDatos.setModel(modelo);
        modelo.addColumn("ID_Entrega");
        modelo.addColumn("Cliente");
        modelo.addColumn("Conductor");
        modelo.addColumn("Vehiculo");
        modelo.addColumn("Destino");
        Object[] filas = new Object[5];
        String [] clientes= {"Christian Morán", "José Pallo", "Erick Mayorga", "Cristhian Muñoz", "Rommel Valdiviezo"};
        int idEntrega = 1;
        for(int i=0;i<5;i++){
            filas[0]=idEntrega;
            filas[1]=clientes[i];
            filas[2] = conductores.listaConductores.get(i).getNombre();
            filas[3] = vehiculos.vehiculos.get(i).getMatricula();
            filas[4] = entregas.entregas.get(i).getDestino();
            modelo.addRow(filas);
            idEntrega++;
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTEntregasDatos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        panelDeRutas = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPInformacionConductor = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTAInformacionConductor = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1043, 760));

        jTEntregasDatos.setBackground(new java.awt.Color(255, 210, 28));
        jTEntregasDatos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTEntregasDatos.setForeground(new java.awt.Color(255, 255, 255));
        jTEntregasDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID_Entrega", "Cliente", "Conductor", "Vehiculo", "Destino"
            }
        ));
        jTEntregasDatos.setFocusable(false);
        jTEntregasDatos.setGridColor(new java.awt.Color(61, 57, 57));
        jTEntregasDatos.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTEntregasDatos.setRowHeight(25);
        jTEntregasDatos.setSelectionBackground(new java.awt.Color(61, 57, 57));
        jTEntregasDatos.setShowVerticalLines(false);
        jTEntregasDatos.getTableHeader().setReorderingAllowed(false);
        jTEntregasDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTEntregasDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTEntregasDatos);
        if (jTEntregasDatos.getColumnModel().getColumnCount() > 0) {
            jTEntregasDatos.getColumnModel().getColumn(4).setMinWidth(10);
        }

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Entregas activas");

        panelDeRutas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelDeRutas.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Ruta");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Información asociada a la entrega:");

        jPInformacionConductor.setBackground(new java.awt.Color(61, 57, 57));
        jPInformacionConductor.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPInformacionConductorLayout = new javax.swing.GroupLayout(jPInformacionConductor);
        jPInformacionConductor.setLayout(jPInformacionConductorLayout);
        jPInformacionConductorLayout.setHorizontalGroup(
            jPInformacionConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPInformacionConductorLayout.setVerticalGroup(
            jPInformacionConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 174, Short.MAX_VALUE)
        );

        jTAInformacionConductor.setColumns(20);
        jTAInformacionConductor.setRows(5);
        jScrollPane2.setViewportView(jTAInformacionConductor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 952, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelDeRutas, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                            .addComponent(jPInformacionConductor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(459, 459, 459)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(324, 324, 324)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(114, 114, 114))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(35, 35, 35)
                        .addComponent(jPInformacionConductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelDeRutas, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTEntregasDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTEntregasDatosMouseClicked
        jTAInformacionConductor.setText("");
        int fila = jTEntregasDatos.getSelectedRow();
        String destino = (String)jTEntregasDatos.getValueAt(fila, 4);
        String nombreConductor = (String)jTEntregasDatos.getValueAt(fila,2);
        jTAInformacionConductor.setText("Nombre:\n" + nombreConductor + "\nDirección destino:\n" + destino);
        String id_origen = "ChIJf3SFnYOa1ZEReimBvayqhDo";//Asumimos que Trappi esta localizado en quicentro norte
        String id_destino = mapeoDireccionIdPlace(destino);
        Ruta ruta = new Ruta();
        ruta.definirRuta(new Posicion(id_origen),new Posicion(id_destino));
        mapa.trazarRuta(ruta);
    }//GEN-LAST:event_jTEntregasDatosMouseClicked
    private String mapeoDireccionIdPlace(String direccion){ //Solo para datos quemados
        
        String Id_destino="";
        switch(direccion){
            case "Universidad Central del Ecuador":
                Id_destino="ChIJwU1IVIya1ZER4jbEiWO6gdE";
                break;
            case "Megamaxi 6 de Diciembre":
                Id_destino="ChIJv4XVroGa1ZERW6s47_m15Fc";
                break;
            case "Pontificia Universidad Catolica del Ecuador":
                Id_destino="ChIJI3HFuBCa1ZER3ac3OdXcxHw";
                break;
            case "Plaza Grande":
                Id_destino="ChIJDxkPgoeZ1ZERXqNMH562TCk";
                break;
            case "Quicentro Sur":
                Id_destino="ChIJl6nxrKKY1ZERUPsT2Jl03BQ";
                break;
        }
        return Id_destino;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPInformacionConductor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTAInformacionConductor;
    private javax.swing.JTable jTEntregasDatos;
    private javax.swing.JPanel panelDeRutas;
    // End of variables declaration//GEN-END:variables
}
