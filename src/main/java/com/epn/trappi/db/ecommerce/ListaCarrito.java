
package com.epn.trappi.db.ecommerce;
import com.epn.trappi.gui.ecommerce.Tarjetas.Tarjeta;
import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.gui.ecommerce.Ecommerce.CarritoDeCompras;
import com.epn.trappi.gui.ecommerce.Interfaces.Login;
import com.epn.trappi.models.proveedores.Bien;
import com.epn.trappi.models.proveedores.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ListaCarrito {
    ArrayList<CarritoDeCompras> lista;
    DataBaseConnection dbInstance = DataBaseConnection.getInstance();
    Connection connection = dbInstance.getConnection();
    
    
    public String obtenerIdProducto(String nombre) 
    {
            String idProducto="";
            String sql = "EXEC CarritoIdbien_Consulta '"+nombre+"'";  
            
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
        Producto articulo;
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
    
    
    public ArrayList<Bien> buscar(String nombreproducto){
        String nombre;
        int cantidad;
        String marca;
        double precio;
        ArrayList<Bien> listab = new ArrayList<>();
    try {       
            Statement statement = connection.createStatement();
            String sql = "SELECT NOMBREBIEN, MARCA, PRECIOBIEN, i.CANTIDADINVENTARIO FROM BIEN b join INVENTARIO i on b.IDENTIFICADORBIEN2=i.IDENTIFICADORBIEN2 where i.CANTIDADINVENTARIO>=1 AND b.NOMBREBIEN LIKE '%"+nombreproducto+"%'";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                
            nombre= resultSet.getString("NOMBREBIEN");
            marca=resultSet.getString("MARCA");
            precio=resultSet.getDouble("PRECIOBIEN");
            cantidad=resultSet.getInt("CANTIDADINVENTARIO");
            Bien bien=new Producto(nombre, precio, cantidad, marca);
            listab.add(bien);
            }
            
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    return listab;
    }
    
    
}
