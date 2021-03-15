
package com.epn.trappi.db.ecommerce;

import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.gui.ecommerce.Ecommerce.Factura;
import com.epn.trappi.gui.ecommerce.Ecommerce.Main;
import com.epn.trappi.gui.ecommerce.Interfaces.Banco.JFBancoInicio;
import com.epn.trappi.gui.ecommerce.Interfaces.DevolucionEcommerce;
import com.epn.trappi.gui.ecommerce.Interfaces.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
            
           
            String sql = "exec factura_insert "+ idAletorio+","+Integer.parseInt(idcl)+","+idAletorio+","+subtotal+","+impuestos+","+total+", '"+dicl+"'"; 
           
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
            String sql = "Select MAX(IDFACTURA) from FACTURAS";
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
    
    
    
    public ArrayList<String[]> obtenerfacturas(){
        ArrayList<String[]> listaf=new ArrayList<>();
        try {
            
            Statement statement = connection.createStatement();
            String Sql="SELECT NUMEROFACTURA, TOTAL, IMPUESTOS, ESTADODEVOLUCION "
                    + "FROM FACTURAS F, CLIENTES C "
                    + "WHERE F.IDCLIENTE=C.IDCLIENTE AND C.CEDULA2="+Main.cliente.Cedula
                    + " ORDER BY NUMEROFACTURA;";
            ResultSet resultSet = statement.executeQuery(Sql);
            while(resultSet.next()){
                String[] factura= new String[4];
                factura[0]=resultSet.getString("NUMEROFACTURA");
                factura[1]=resultSet.getString("TOTAL");
                factura[2]=resultSet.getString("IMPUESTOS");
                factura[3]=resultSet.getString("ESTADODEVOLUCION");
            listaf.add(factura);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DevolucionEcommerce.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaf;
    }
    
    
}
