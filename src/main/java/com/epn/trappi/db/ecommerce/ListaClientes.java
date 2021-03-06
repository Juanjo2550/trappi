
package com.epn.trappi.db.ecommerce;

import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.gui.ecommerce.FormulariosCliente.FEdicionCliente;
import com.epn.trappi.gui.ecommerce.FormulariosCliente.FRegistroCliente;
import com.epn.trappi.gui.ecommerce.Interfaces.Inicio;
import com.epn.trappi.gui.ecommerce.Interfaces.Login;
import com.epn.trappi.gui.ecommerce.Interfaces.Registrar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.epn.trappi.gui.ecommerce.Ecommerce.Cliente;
import com.epn.trappi.gui.ecommerce.Ecommerce.Cliente;
import com.epn.trappi.gui.ecommerce.FormulariosTarjetas.FRegistroTarjeta;
import java.util.ArrayList;

public class ListaClientes {
    
    DataBaseConnection dbInstance = DataBaseConnection.getInstance();
    Connection connection = dbInstance.getConnection();
    ArrayList<Cliente> lista;
    
    
    
     public int idsuario(){
        int numero=0;
        try {
            String id= "";
                       
            Statement statement = connection.createStatement();
            String sql = "Select TOP 1 IDCLIENTE from CLIENTES ORDER BY IDCLIENTE DESC";
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
    
    public void ingresar(FRegistroCliente reg){
     String[] datos = reg.obtenerDatos();
       
       String Nombre = datos[0];
       String Correo = datos[1];
       String Fechadenacimiento=datos[2];
       String Celular = datos[3];
       String Direccion= datos[4];
       String Cedula=datos[5];
       String Contraseña=datos[6];
    try {
            int idAletorio = idsuario();
            String sql = "exec cliente_insert "+idAletorio+",'"+Nombre+"','"+Fechadenacimiento+
                    "','"+Celular+"','"+Direccion+"','"+Cedula+"','"+
                    Contraseña+"','"+Correo+"'"; 
           
            PreparedStatement prepsInsertProduct = connection.prepareStatement(sql);
            prepsInsertProduct.execute();
            JOptionPane.showMessageDialog(null,"exito");
            Inicio inicio=new Inicio();
            inicio.setVisible(true);
            
        } catch (SQLException ex) {
            Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    
    public void eliminar(String cedula){
    try {
            String sql = "EXEC cliente_borrar1 '"+cedula+"'";
            PreparedStatement prepsInsertProduct = connection.prepareStatement(sql);
            prepsInsertProduct.execute();
            JOptionPane.showMessageDialog(null,"eliminación exitosa");
        } catch (SQLException ex) {
            Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public boolean buscar(Cliente cliente1, String usuario, String contraseña){
          boolean on_off= false;
    try {   
          
            Statement statement = connection.createStatement();
            String sql = "EXEC cliente_consulta '"+usuario+"','"+contraseña+"'";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                on_off=true;
                cliente1.Nombre=resultSet.getString("NOMBRECLIE");
                cliente1.Cedula=resultSet.getString("CEDULA2");
                cliente1.Correo=resultSet.getString("CORREO");
                cliente1.Fechadenacimiento=resultSet.getString("FECHADENACIMIENTO");
                cliente1.Celular=resultSet.getString("CELULAR");
                cliente1.Direccion=resultSet.getString("DIRECCION");
                cliente1.Contraseña=resultSet.getString("CONTRASENA");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } 
    return on_off;
    }
    
    
    
    
    public void editar(FEdicionCliente editar){
     String[] datos = editar.obtenerDatos();
       
       String Nombre = datos[0];
       String Correo = datos[1];
       String Fechadenacimiento=datos[2];
       String Celular = datos[3];
       String Direccion= datos[4];
       String Cedula=datos[5];
       String Contraseña=datos[6];   
        
    try {
            String sql ="EXEC cliente_modificar '"+Nombre+"','"+Cedula+"','"+Fechadenacimiento+"','"+
                    Celular+"','"+Direccion+"','"+Contraseña+
                    "','"+Correo+"'";
            
            PreparedStatement prepsInsertProduct = connection.prepareStatement(sql);
            prepsInsertProduct.execute();
            JOptionPane.showMessageDialog(null,"cambios realizados con exito");
        } catch (SQLException ex) {
            Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    
    
    public void obtenerdatosdetarjetas(Cliente cliente){
        try {
            String tarjeta= "";
            String cvv ="";
            String tipo ="";
            String fecha ="";
                                   
            Statement statement = connection.createStatement();
            String sql = "EXEC tarjeta_Consulta '"+cliente.Cedula+"'";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                 tarjeta= resultSet.getString("NUMEROTARJETA");
                 cvv =resultSet.getString("CVV");
                 fecha =resultSet.getString("FECHADECADUCIDAD");
                 tipo=resultSet.getString("TIPO");
                 FRegistroTarjeta fr=new FRegistroTarjeta(tarjeta,cvv,fecha,tipo);
                 cliente.añadirTarjeta(fr);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
