
package com.epn.trappi.gui.ecommerce.entidadBancaria;

import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.gui.ecommerce.Interfaces.Inicio;
import com.epn.trappi.gui.ecommerce.Interfaces.Registrar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Bryan
 */
public class Cuenta {
    
    public String NumeroCuenta;
    public String CedulaPropietario;
    public Double fondo;
    
    DataBaseConnection dbInstance = DataBaseConnection.getInstance();
    Connection connection = dbInstance.getConnection();
    
    public void acreditar(Double valor){
        this.fondo=this.fondo+valor;
    }
    
    public void debitar(Double valor){
        this.fondo=this.fondo-valor;
        
        try {
            String sql = "exec debitar_pago '"+NumeroCuenta+"' ,"+this.fondo;
           
            PreparedStatement prepsInsertProduct = connection.prepareStatement(sql);
            prepsInsertProduct.execute();
            JOptionPane.showMessageDialog(null,"exito");
            Inicio inicio=new Inicio();
            inicio.setVisible(true);
            
        } catch (SQLException ex) {
            Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
        
        
    }
    

