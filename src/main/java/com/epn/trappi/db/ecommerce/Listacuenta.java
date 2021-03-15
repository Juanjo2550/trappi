
package com.epn.trappi.db.ecommerce;

import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.gui.ecommerce.Ecommerce.Main;
import com.epn.trappi.gui.ecommerce.Interfaces.Login;
import com.epn.trappi.gui.ecommerce.entidadBancaria.Cuenta;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Listacuenta {
Cuenta cuenta;
DataBaseConnection dbInstance = DataBaseConnection.getInstance();
    Connection connection = dbInstance.getConnection();

 public void obtenerdatoscuenta(Cuenta cuenta){
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

}
