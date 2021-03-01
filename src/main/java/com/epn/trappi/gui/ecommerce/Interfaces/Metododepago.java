
package com.epn.trappi.gui.ecommerce.Interfaces;

import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.gui.ecommerce.Ecommerce.Articulo;
import com.epn.trappi.gui.ecommerce.Ecommerce.Main;
import com.epn.trappi.gui.ecommerce.Tarjetas.Tarjeta;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.epn.trappi.gui.ecommerce.FormulariosTarjetas.FEdicionTarjeta;
import com.epn.trappi.gui.ecommerce.Tarjetas.TarjetaCredito;
import com.epn.trappi.gui.ecommerce.Tarjetas.TarjetaDebito;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Metododepago extends javax.swing.JFrame {
        DataBaseConnection dbInstance = DataBaseConnection.getInstance();
        Connection connection = dbInstance.getConnection();

    
    public Metododepago() {
        initComponents();
        this.setSize(1300, 700);
        jButtoneditarconfirmarcambios.setVisible(false);
        this.setLocationRelativeTo(null);
        llenardatos();
        llenartablat();
        jt.setText(Main.cliente.getNombre());
        jt.setEditable(false);
        
    }
    
    public void llenartabla(){
    DefaultTableModel tarjetas = (DefaultTableModel) tablatarjetas.getModel();
    Tarjeta tarjeta;
    String[] aux=new String[4];
        for (int i = 0; i < Main.cliente.tarjeta.size(); i++) {
       tarjeta=Main.cliente.tarjeta.get(i);
       tarjetas.addRow(aux);
        }
        tablatarjetas.setModel(tarjetas);
    }
    
    public void tomarTarjeta()
    {   String[] aux=new String[4];
        DefaultTableModel modelo = (DefaultTableModel) tablatarjetas.getModel();
        jTextFieldtarjeta.setText((String)modelo.getValueAt(tablatarjetas.getSelectedRow(),0));
        jTextFieldcvv.setText((String)modelo.getValueAt(tablatarjetas.getSelectedRow(),1));
        jTextFieldtipo.setText((String)modelo.getValueAt(tablatarjetas.getSelectedRow(),2));
        jTextFieldfecha.setText((String)modelo.getValueAt(tablatarjetas.getSelectedRow(),3));
        jTextFieldcvv.setEditable(false);
        jTextFieldfecha.setEditable(false);
        jTextFieldtarjeta.setEditable(false);
        jTextFieldtipo.setEditable(false);
    }
   public Tarjeta obtenertarjeta(){
        com.epn.trappi.gui.ecommerce.Tarjetas.TarjetaCredito tar=null;
        com.epn.trappi.gui.ecommerce.Tarjetas.TarjetaDebito tar1=null;
    for (int i = 0; i < Main.cliente.tarjeta.size(); i++) {
      
        }
    return tar;
   }
    
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldtarjeta = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldcvv = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldtipo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldfecha = new javax.swing.JTextField();
        jButtoneditar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablatarjetas = new javax.swing.JTable();
        jButtoneditar1 = new javax.swing.JButton();
        jButtoneditarconfirmarcambios = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jButton1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jButton1.setText("Cuenta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jButton2.setText("Comprar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jButton3.setText("Tarjetas");

        jButton4.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jButton4.setText("Salir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jt.setBackground(new java.awt.Color(0, 102, 102));
        jt.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jt, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 218, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(46, 46, 46))
        );

        jLabel1.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        jLabel1.setText("Agregados:");

        jLabel2.setFont(new java.awt.Font("Sylfaen", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Metodo de Pago");

        jLabel3.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        jLabel3.setText("Tarjeta");

        jLabel4.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        jLabel4.setText("Datos:");

        jTextFieldtarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldtarjetaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        jLabel5.setText("CVV");

        jLabel6.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        jLabel6.setText("Tipo");

        jLabel8.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        jLabel8.setText("Fecha de caducidad");

        jButtoneditar.setText("Registar");
        jButtoneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoneditarActionPerformed(evt);
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

        jButtoneditar1.setText("Editar");
        jButtoneditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoneditar1ActionPerformed(evt);
            }
        });

        jButtoneditarconfirmarcambios.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButtoneditarconfirmarcambios.setText("Confirmar cambios");
        jButtoneditarconfirmarcambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoneditarconfirmarcambiosActionPerformed(evt);
            }
        });

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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1039, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldtarjeta, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                            .addComponent(jTextFieldcvv)
                            .addComponent(jTextFieldtipo)
                            .addComponent(jTextFieldfecha))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jButtoneditarconfirmarcambios, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtoneditar1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtoneditar))
                        .addGap(228, 228, 228))))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldtarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextFieldcvv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldtipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(2, 2, 2)
                        .addComponent(jButtoneditar)
                        .addGap(209, 209, 209)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtoneditar1)
                            .addComponent(jButtoneditarconfirmarcambios))
                        .addContainerGap(85, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    CuentaCliente cuenta=new CuentaCliente();
    cuenta.setVisible(true);
    cuenta.nombretitulo(jt.getText());
    cuenta.llenardatroscl();
    this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    Login login=new Login();
    login.setVisible(true);
    this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    Comprar comprar=new Comprar();
    comprar.setVisible(true);
    comprar.nombretitulo(jt.getText());
    comprar.llenartabla();
    this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtoneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoneditarActionPerformed
    RegistrarMetododepago rmp=new RegistrarMetododepago();
    rmp.setVisible(true);
    this.setVisible(false);
    rmp.nombretitulo(jt.getText());
    rmp.llenardatos();
    }//GEN-LAST:event_jButtoneditarActionPerformed

    private void tablatarjetasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablatarjetasMouseClicked
    tomarTarjeta();
    }//GEN-LAST:event_tablatarjetasMouseClicked

    private void jButtoneditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoneditar1ActionPerformed
        jTextFieldcvv.setEditable(true);
        jTextFieldfecha.setEditable(true);
        jTextFieldtarjeta.setEditable(false);
        jTextFieldtipo.setEditable(true);  
        jButtoneditarconfirmarcambios.setVisible(true);
        
    }//GEN-LAST:event_jButtoneditar1ActionPerformed

    private void jButtoneditarconfirmarcambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoneditarconfirmarcambiosActionPerformed
                Inicio nuevo= new Inicio();
                nuevo.jt.setText(jt.getText());
                nuevo.setVisible(true);
                this.setVisible(false);
        
        /*FEdicionTarjeta fet=new FEdicionTarjeta(jTextFieldtarjeta.getText(),jTextFieldcvv.getText(),jTextFieldfecha.getText(), jTextFieldtipo.getText());
        if(jTextFieldtipo.getText().equals("Credito")){
        Main.cliente.editarTarjetaCredito(fet, (TarjetaCredito) obtenertarjeta());
        }
        else{
        Main.cliente.editarTarjetaDebito(fet, (TarjetaDebito) obtenertarjeta());
        }
        JOptionPane.showMessageDialog(null,"cambios realizados con exito");
        llenartabla();*/
        
    }//GEN-LAST:event_jButtoneditarconfirmarcambiosActionPerformed

    private void jTextFieldtarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldtarjetaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldtarjetaActionPerformed

    public void nombretitulo(String name){
     jt.setText(name);
        System.out.println(name);
    }
    public void llenardatos(){
        try {
            String tarjeta= "";
            String cvv ="";
            String tipo ="";
            String fecha ="";
                                   
            Statement statement = connection.createStatement();
            String sql = "select NUMEROTARJETA, CVV, FECHADECADUCIDAD,TIPO from TARJETAS T, CUENTABANCARIA C, CLIENTES L "+
                         "where T.IDCUENTABANCARIA=C.IDCUENTABANCARIA and C.IDCLIENTE=L.IDCLIENTE and L.NOMBRECLIE='"+jt.getText()+"'";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                 tarjeta= resultSet.getString("NUMEROTARJETA");
                 cvv =resultSet.getString("CVV");
                 fecha =resultSet.getString("FECHADECADUCIDAD");
                 tipo=resultSet.getString("TIPO");
            }
            System.out.println(tarjeta);
            jTextFieldtarjeta.setText(tarjeta);
            jTextFieldcvv.setText(cvv);
            jTextFieldtipo.setText(tipo);
            jTextFieldfecha.setText(fecha);
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void llenartablat(){
       
       try{
            DefaultTableModel tarjeta = (DefaultTableModel) tablatarjetas.getModel();
            String[] aux=new String[4];
            Statement statement = connection.createStatement();
            String sql = "select NUMEROTARJETA, CVV, FECHADECADUCIDAD, TIPO from TARJETAS T, CUENTABANCARIA C, CLIENTES L "+
                         "where T.IDCUENTABANCARIA=C.IDCUENTABANCARIA and C.IDCLIENTE=L.IDCLIENTE and L.NOMBRECLIE='"+jt.getText()+"'";
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
            java.util.logging.Logger.getLogger(Metododepago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Metododepago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Metododepago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Metododepago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Metododepago().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtoneditar;
    private javax.swing.JButton jButtoneditar1;
    private javax.swing.JButton jButtoneditarconfirmarcambios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldcvv;
    private javax.swing.JTextField jTextFieldfecha;
    private javax.swing.JTextField jTextFieldtarjeta;
    private javax.swing.JTextField jTextFieldtipo;
    private javax.swing.JTextField jt;
    private javax.swing.JTable tablatarjetas;
    // End of variables declaration//GEN-END:variables
}
