
package com.epn.trappi.gui.ecommerce.Interfaces;

import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.db.ecommerce.ListaCarrito;
import com.epn.trappi.db.ecommerce.ListaFacturas;
import com.epn.trappi.db.ecommerce.ListaTar;
import com.epn.trappi.gui.ecommerce.Ecommerce.Main;
import com.epn.trappi.gui.ecommerce.Ecommerce.Pago;
import static com.epn.trappi.gui.ecommerce.Interfaces.Comprar.carrito;

import com.epn.trappi.gui.ecommerce.Tarjetas.Tarjeta;
import com.epn.trappi.gui.ecommerce.entidadBancaria.Cuenta;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TarjetaUsuario extends javax.swing.JFrame {
        DataBaseConnection dbInstance = DataBaseConnection.getInstance();
        Connection connection = dbInstance.getConnection();
        

    
    public TarjetaUsuario() {
        initComponents();
        this.setSize(1300, 700);
      
        this.setLocationRelativeTo(null);
       
        llenartabla();

       
        
    }
    
    public int idsuario(){
        int numero=0;
        try {
            String id= "";
                       
            Statement statement = connection.createStatement();
            String sql = "Select CLIENTES.IDCLIENTE from CLIENTES, CUENTABANCARIA  "+
                         "WHERE CLIENTES.IDCLIENTE=CUENTABANCARIA.IDCLIENTE AND CLIENTES.CEDULA2="+Integer.parseInt(Main.cliente.Cedula);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                 id= resultSet.getString(1);
            }
            numero=Integer.parseInt(id);
                        
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numero;
    }
    
    
        
    public void llenartabla(){
       
       try{
            DefaultTableModel tarjeta = (DefaultTableModel) tablatarjetas.getModel();
            String[] aux=new String[4];
            Statement statement = connection.createStatement();
            String sql = "select NUMEROTARJETA, CVV, FECHADECADUCIDAD, TIPO from TARJETAS T, CUENTABANCARIA C "+
                         "where T.IDCUENTABANCARIA=C.IDCUENTABANCARIA and C.IDCLIENTE="+idsuario();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                 
                aux[0]=resultSet.getString("NUMEROTARJETA");
                aux[1]=resultSet.getString("CVV");
                aux[2]=resultSet.getString("TIPO");
                aux[3]=resultSet.getString("FECHADECADUCIDAD");
                tarjeta.addRow(aux);
            }
            tablatarjetas.setModel(tarjeta);
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
    public String[] tomarTarjeta()
    {   String[] aux=new String[4];
        DefaultTableModel modelo = (DefaultTableModel) tablatarjetas.getModel();
        aux[0]=((String)modelo.getValueAt(tablatarjetas.getSelectedRow(),0));
        aux[1]=((String)modelo.getValueAt(tablatarjetas.getSelectedRow(),1));
        aux[2]=((String)modelo.getValueAt(tablatarjetas.getSelectedRow(),2));
        aux[3]=((String)modelo.getValueAt(tablatarjetas.getSelectedRow(),3));
        return aux;
    }
   
    
 
    
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonSeleccionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablatarjetas = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        jLabel1.setText("Agregados:");

        jLabel2.setFont(new java.awt.Font("Sylfaen", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Metodo de Pago");

        jButtonSeleccionar.setText("Seleccionar");
        jButtonSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSeleccionarActionPerformed(evt);
            }
        });

        tablatarjetas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero Tarjeta", "CVV", "Tipo", "Fecha de caducidad"
            }
        ));
        tablatarjetas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablatarjetasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablatarjetas);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo_solotexto_resize.jpg"))); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/panelSuperiorComidasVariadasCortada.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 1044, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 6, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1039, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSeleccionar)
                .addGap(92, 92, 92))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(28, 28, 28)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButtonSeleccionar)
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablatarjetasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablatarjetasMouseClicked
    
    
    jButtonSeleccionar.setVisible(true);
    }//GEN-LAST:event_tablatarjetasMouseClicked

    private void jButtonSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSeleccionarActionPerformed
        Cuenta cuenta=new Cuenta();

        
        
        try{
            Statement statement = connection.createStatement();
            String sql = "SELECT NUMERODECUENTA, FONDOS FROM CUENTABANCARIA WHERE IDCLIENTE="+idsuario();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
              cuenta.fondo=Double.valueOf(resultSet.getString("FONDOS"));
              cuenta.NumeroCuenta=resultSet.getString("NUMERODECUENTA");
              cuenta.CedulaPropietario=Main.cliente.Cedula;
            }
            
       } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE,null, ex);
        }
        
        
        
        String datos[]=tomarTarjeta();
        if(datos[2].equals("Credito")){
        Main.tarcre.Tipo=datos[2];
        Main.tip=datos[2];
        Main.tarcre.CVV=datos[1];
        Main.tarcre.NumeroTarjeta=datos[0];
        Main.tarcre.Fechacaducidad=datos[3];
        
        Main.tarcre.cuenta=cuenta;
        
        }
        else{
        Main.tardeb.Tipo=datos[2];
        Main.tip=datos[2];
        Main.tardeb.CVV=datos[1];
        Main.tardeb.NumeroTarjeta=datos[0];
        Main.tardeb.Fechacaducidad=datos[3];
        Main.tardeb.cuenta=cuenta;
      
        }
        
        
        Pago pago = new Pago();
       
        
        
        if(pago.validarPago(Main.tarcre,Main.tardeb,Main.tip,carrito.factura.calcularTotal(),cuenta)==true){
              ListaFacturas lista=new ListaFacturas();
              int id=lista.generarfacturaDatabase(Main.cliente.Nombre,carrito.factura.calcularSubTotal(),carrito.factura.calcularImpuestos(),carrito.factura.calcularTotal());
              Comprar.carrito.factura.setNumeroFactura(id);
              ListaCarrito lista1=new ListaCarrito();
              lista1.registrar_detallecompra(Comprar.carrito, Main.cliente.Nombre);
              carrito.vaciarCarrito();             
                JOptionPane.showMessageDialog(rootPane,"Compra realizada con exito");
                this.setVisible(false);
        }
             else{
                 JOptionPane.showMessageDialog(rootPane,"Saldo insuficiente, no se puede realizar la compra");
             }
        
        

    }//GEN-LAST:event_jButtonSeleccionarActionPerformed

   
    
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
            java.util.logging.Logger.getLogger(TarjetaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TarjetaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TarjetaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TarjetaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new TarjetaUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonSeleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablatarjetas;
    // End of variables declaration//GEN-END:variables
}
