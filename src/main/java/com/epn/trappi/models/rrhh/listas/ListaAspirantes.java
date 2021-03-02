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
    ArrayList <Aspirante> listaAspirantes;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    DataBaseConnection dbInstance = DataBaseConnection.getInstance();
    Connection conn = dbInstance.getConnection();
    
    public ListaAspirantes() {
       // this.listaAspirantes = new ArrayList<>();
    }
    
    public void agregar(String nombre, String apellidos, String cedula, String telefono, String cargo){
        
        
    }

//    public ArrayList<Aspirante> getListaAspirantes() {
//        return listaAspirantes;
//    }
    
    
    //obtener Todos accede a la base de datos para obtenere toda la info del Aspirante
    @Override
    public Aspirante[] obtenerTodos(){
        listaAspirantes = new ArrayList<>();
        
       // ListaAspirantes listaTemp = new ListaAspirantes();
       //this.listaAspirantes.clear();
        try {
            String query = "SELECT * FROM ASPIRANTE";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            
            while(rs.next()){
               //System.out.println("El id del aspirante es " + rs.getInt("ID_ASP") + " la cedula es " + rs.getString("CEDULAASP"));
               listaAspirantes.add(new Aspirante(rs.getString("NOMBREASP"),rs.getString("APELLIDOASP"),rs.getString("CEDULAASP"),
                rs.getString("TELEFONOASP"), rs.getString("CARGOASP")));
            }
            System.out.println("Consulta se hizo con exito");
           
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
       Aspirante[] aspirantes = new Aspirante[listaAspirantes.size()];
       aspirantes = listaAspirantes.toArray(aspirantes);
       return aspirantes;
    }

    @Override
    public void agregar(Aspirante nuevoAsp) {
        
        try {  
            int idAsp = obtenerTodos().length + 1;
            String query = "INSERT INTO ASPIRANTE ( ID_ASP, NOMBREASP, APELLIDOASP, CEDULAASP, TELEFONOASP, CARGOASP) VALUES (?, ?, ?, ?, ?, ?)";
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, idAsp);
            pstm.setString(2, nuevoAsp.getNombre());
            pstm.setString(3, nuevoAsp.getApellidos());
            pstm.setString(4, nuevoAsp.getCedula());
            pstm.setString(5, nuevoAsp.getTelefono());
            pstm.setString(6, nuevoAsp.getCargoAspirante());
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
        
    }

    @Override
    public Boolean eliminar(String parametro) {
        return false; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Aspirante buscarUno(String parametro) {
        return null; //To change body of generated methods, choose Tools | Templates.
    }


    
}
