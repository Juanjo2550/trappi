package com.epn.trappi.models.rrhh;

import com.epn.trappi.db.rrhh.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Javier Erazo
 */
public class ListaAspirantes {
    ArrayList <Aspirante> listaAspirantes;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    Connection conn = Connect.connect("javiere.db");
    public ListaAspirantes() {
        this.listaAspirantes = new ArrayList<>();
    }
    
    public Aspirante agregar(Aspirante aspNuevo){
        try {            
            String query = "INSERT INTO aspirante_prueba (nombre, apellido, telefono, cedula, actitudes, aptitudes, puntaje, cargo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, aspNuevo.getNombre());
            pstm.setString(2, aspNuevo.getApellidos());
            pstm.setString(3, aspNuevo.getTelefono());
            pstm.setString(4, aspNuevo.getCedula());
            pstm.setString(5, aspNuevo.getPrueba().getActitudes());
            pstm.setString(6, aspNuevo.getPrueba().getAptitudes());
            pstm.setInt(7, aspNuevo.getPrueba().getPuntaje());
            pstm.setString(8, aspNuevo.getCargoAspirante());
            pstm.executeUpdate();
            conn.close();
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
        listaAspirantes.add(aspNuevo);
        return aspNuevo;
        
    }

    public ArrayList<Aspirante> getListaAspirantes() {
        return listaAspirantes;
    }
    
    
    //selectAll accede a la base de datos para obtenere toda la info del Aspirante
    public ArrayList selectAll(){
        
        
        ListaAspirantes listaTemp = new ListaAspirantes();
        try {
            Connection conn = Connect.connect("javiere.db");
            String query = "SELECT * FROM aspirante_prueba";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                
                PruebaAdmision prueba = new PruebaAdmision(rs.getInt("puntaje"), rs.getString("aptitudes"), rs.getString("actitudes"));
                Aspirante aspirante = new Aspirante(rs.getString("nombre"),rs.getString("apellido"),rs.getString("cedula"),
                rs.getString("telefono"), rs.getString("cargo"),prueba);
                this.listaAspirantes.add(aspirante);
                
                
            }
            
            conn.close();
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
        return this.listaAspirantes;
    }
    
    
}
