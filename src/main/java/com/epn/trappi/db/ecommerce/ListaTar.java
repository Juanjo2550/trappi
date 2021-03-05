
package com.epn.trappi.db.ecommerce;

import com.epn.trappi.gui.ecommerce.Tarjetas.Tarjeta;
import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.gui.ecommerce.Interfaces.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

public class ListaTar {
    ArrayList<Tarjeta> lista;
    DataBaseConnection dbInstance = DataBaseConnection.getInstance();
    Connection connection = dbInstance.getConnection();
    
    
    public void ingresar(){
    
    }
    
    public int idcuenta(String cedula){
        String cuenta="";
        int idcuenta=0;
        
        try{
            Statement statement = connection.createStatement();
            String sql = "EXEC CLienteCuenta_idcuenta '"+cedula+"'";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
              cuenta=resultSet.getString(1);
            }
            idcuenta=Integer.parseInt(cuenta);
            
       } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
            return idcuenta;
    }
    
    public int idtarjeta(){
        int numero=0;
        String id= "";
        try {
            
                       
            Statement statement = connection.createStatement();
            String sql = "Select TOP 1 IDTARJETA from TARJETAS ORDER BY IDTARJETA DESC ";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                 id= resultSet.getString(1);
            }
            numero=Integer.parseInt(id)+1;
            System.out.print("numero"+numero);
                        
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numero;
    }
    
    public void creartarjeta(String cedula,String cvv1, String numerotarjeta1, String tipo, String fecha){
       try {
            int numerotarjeta=(Integer.parseInt(numerotarjeta1));
            int cvv = Integer.parseInt(cvv1);
            int idAletorio = idtarjeta();
            
            String sql ="EXEC tarjeta_insert "+idAletorio+","+idcuenta(cedula)+","+numerotarjeta+","+cvv+",'"+fecha+"','"+tipo+"'"; 
            PreparedStatement prepsInsertProduct = connection.prepareStatement(sql);
            prepsInsertProduct.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
          }
       
   }
    
    public void modtarjeta(int numtarjeta, int cvv,String fecha, String tipo){
       try {          
            String sql ="EXEC trajeta_modificar "+numtarjeta+","+cvv+",'"+fecha+"','"+tipo+"'";
            PreparedStatement prepsInsertProduct = connection.prepareStatement(sql);
            prepsInsertProduct.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    public void borartarjeta(int numtarjeta){
       try {          
            String sql ="EXEC tarjeta_borrar "+numtarjeta;
            PreparedStatement prepsInsertProduct = connection.prepareStatement(sql);
            prepsInsertProduct.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
}
