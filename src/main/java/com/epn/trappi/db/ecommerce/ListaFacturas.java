
package com.epn.trappi.db.ecommerce;

import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.gui.ecommerce.Ecommerce.Factura;
import com.epn.trappi.gui.ecommerce.Interfaces.Banco.JFBancoInicio;
import com.epn.trappi.gui.ecommerce.Interfaces.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListaFacturas {
    ArrayList<Factura> lista;
    DataBaseConnection dbInstance = DataBaseConnection.getInstance();
    Connection connection = dbInstance.getConnection();
    
    
    
    
    public int generarfacturaDatabase(String nombre,Double subtotal,Double impuestos,Double total){
        String idcl="";
          String dicl="";
          int idAletorio=0;
        try{
            
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM CLIENTES WHERE NOMBRECLIE='"+nombre+"'";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
              idcl=resultSet.getString("IDCLIENTE");
              dicl=resultSet.getString("DIRECCION");
            }  
            
       } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
      

        
        try{
            
            idAletorio = idfactura();
            String sql = "exec factura_insert "+ idAletorio+","+Integer.parseInt(idcl)+",'"+idAletorio+"',"+subtotal+","+impuestos+","+total+", '"+dicl+"'"; 
           
            PreparedStatement prepsInsertProduct = connection.prepareStatement(sql);
            prepsInsertProduct.execute();
        } catch(SQLException ex){
          Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
           
        }
        return idAletorio;
    }
    
    public void updatefacturaDatabase(int idfac,double subtotal  ,double impuestos, double total){
        try{
            
            String sql = "exec actualizar_factura"+idfac+","+subtotal+","+impuestos+","+total; 
            PreparedStatement prepsInsertProduct = connection.prepareStatement(sql);
            prepsInsertProduct.execute();
        } catch(SQLException ex){
            Logger.getLogger(JFBancoInicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int idfactura(){
        int numero=0;
        try {
            String id= "";
                       
            Statement statement = connection.createStatement();
            String sql = "Select TOP 1 IDFACTURA from FACTURAS ORDER BY IDFACTURA DESC";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                 id= resultSet.getString(1);
            }
            numero=Integer.parseInt(id)+1;
                        
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numero;
    }
    
    
    
}
