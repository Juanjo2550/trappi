
package com.epn.trappi.db.ecommerce;
import com.epn.trappi.gui.ecommerce.Tarjetas.Tarjeta;
import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.gui.ecommerce.Ecommerce.Articulo;
import com.epn.trappi.gui.ecommerce.Ecommerce.CarritoDeCompras;
import com.epn.trappi.gui.ecommerce.Interfaces.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;


public class ListaCarrito {
    ArrayList<CarritoDeCompras> lista;
    DataBaseConnection dbInstance = DataBaseConnection.getInstance();
    Connection connection = dbInstance.getConnection();
    
    
    public String obtenerIdProducto(String nombre) 
    {
            String idProducto="";
            String sql = "SELECT IDENTIFICADORBIEN2 FROM BIEN WHERE NOMBREBIEN='"+nombre+"'";  
            
        try {
           Statement prepSelect=connection.createStatement();
           ResultSet resultSet = prepSelect.executeQuery(sql);
            
             while(resultSet.next())
             {
                idProducto=resultSet.getString("IDENTIFICADORBIEN2"); 
             }
            
        } catch (SQLException ex) {
            Logger.getLogger(ListaCarrito.class.getName()).log(Level.SEVERE, null, ex);
        }
          return idProducto;
    
    }
    
      
    
    
    public void registrar_detallecompra (CarritoDeCompras carro, String nombrecliente){
        int aux=iddetallefactura();
        Articulo articulo;
         String idProducto="";
        for (int i = 0; i <carro.Productos.size(); i++) {
            articulo=carro.Productos.get(i);
            String nombre = carro.Productos.get(i).nombre;
            idProducto=obtenerIdProducto(nombre);
    try{
            String sql = "exec detallefac_insert "+ aux+","+carro.factura.nFactura+",'"+nombrecliente+"',"+Integer.parseInt(idProducto)+","+articulo.precio+","+articulo.precio; 
           
            PreparedStatement prepsInsertProduct = connection.prepareStatement(sql);
            prepsInsertProduct.execute();
        } catch(SQLException ex){
          Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
           
        }
    aux=aux+1;
    }
    }
    
    
    
    public int iddetallefactura(){
        int numero=0;
        try {
            String id= "";
                       
            Statement statement = connection.createStatement();
            String sql = "Select top 1 IDDETALLEFACTURA from DETALLEFACTURA ORDER BY IDDETALLEFACTURA DESC";
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
