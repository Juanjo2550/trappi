package com.epn.trappi.models.rrhh.listas;

import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.models.rrhh.contratacion.PruebaAdmision;
import com.epn.trappi.models.rrhh.contratacion.Aspirante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Javier Erazo
 */
public class ListaAspirantes implements Lista <Aspirante> {
    //ArrayList <Aspirante> listaAspirantes;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    //Connection conn = Connect.connect("javiere.db");
    DataBaseConnection dbInstance = DataBaseConnection.getInstance();
    Connection conn = dbInstance.getConnection();
    public ListaAspirantes() {
       // this.listaAspirantes = new ArrayList<>();
    }
    
    public void agregar(String nombre, String apellidos, String cedula, String telefono, String cargo){
        //Aspirante aspNuevo = new Aspirante(nombre, apellidos, cedula, telefono, cargo);
        //int idAsp = obtenerTodos().size() + 1;
        try {            
            String query = "INSERT INTO aspirante_prueba ( nombre, apellido, telefono, cedula) VALUES (?, ?, ?, ?, ?)";
            pstm = conn.prepareStatement(query);
            //pstm.setInt(1, idAsp);
            pstm.setString(2, nombre);
            pstm.setString(3, apellidos);
            pstm.setString(4, cedula);
            pstm.setString(5, telefono);
            pstm.setString(6, cargo);
            pstm.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error en insercion de Aspirante: " + e);
        }
        finally{
            try {
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();
                
            } catch (Exception e) {
                System.out.println("Error al cerrar rs y pstm: " + e);
            }
        }
        //listaAspirantes.add(aspNuevo);
       // return aspNuevo;
        
    }

//    public ArrayList<Aspirante> getListaAspirantes() {
//        return listaAspirantes;
//    }
    
    
    //obtener Todos accede a la base de datos para obtenere toda la info del Aspirante
    @Override
    public Aspirante[] obtenerTodos(){
        
        
       // ListaAspirantes listaTemp = new ListaAspirantes();
       //this.listaAspirantes.clear();
        try {
            //Connection conn = Connect.connect("javiere.db");
            String query = "SELECT * FROM ASPIRANTE";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            
            while(rs.next()){
//               listaAspirantes.add(new Aspirante(rs.getString("nombre"),rs.getString("apellido"),rs.getString("cedula"),
//                rs.getString("telefono"), rs.getString("cargo")));
            }
            
        } catch (Exception e) {
            System.out.println("Error en consulta de Aspirantes: " + e);
        }
        finally{
            try {
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();
                
            } catch (Exception e) {
                System.out.println("Error al cerrar rs y pstm: " + e);
            }
        }
       // return this.listaAspirantes;
       return null;
    }

    @Override
    public void agregar(Aspirante newObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean eliminar(String parametro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Aspirante buscarUno(String parametro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
