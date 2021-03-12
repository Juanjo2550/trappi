package com.epn.trappi.db.rrhh;

import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.models.rrhh.contratacion.PruebaAdmision;
import com.epn.trappi.models.rrhh.contratacion.Aspirante;
import com.epn.trappi.models.rrhh.listas.Lista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Javier Erazo
 */
public class AspirantesDB implements ModelDb <Aspirante> {
    ArrayList <Aspirante> listaAspirantes;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    DataBaseConnection dbInstance = DataBaseConnection.getInstance();
    Connection conn = dbInstance.getConnection();
    
    public AspirantesDB() {
       // this.listaAspirantes = new ArrayList<>();
    }
    


    @Override
    public Aspirante[] obtenerTodos(){
        listaAspirantes = new ArrayList<>();
        try {
            String query = "SELECT * FROM ASPIRANTE";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            
            while(rs.next()){
               listaAspirantes.add(new Aspirante(rs.getString("NOMBREASP"),rs.getString("APELLIDOASP"),rs.getString("CEDULAASP"),
                rs.getString("TELEFONOASP"), rs.getString("CARGOASP")));
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
    public Aspirante buscarUno(String idAspirante) {
        Aspirante aspirante = null;
        try {
            String query = "SELECT * FROM ASPIRANTE WHERE ID_ASP = ?";
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, Integer.parseInt(idAspirante));
            rs = pstm.executeQuery();
            aspirante = new Aspirante(rs.getString("NOMBREASP"),rs.getString("APELLIDOASP"),rs.getString("CEDULAASP"),
            rs.getString("TELEFONOASP"), rs.getString("CARGOASP"));
            
            System.out.println("Consulta Buscar un aspirante se hizo con exito");
           
        } catch (Exception e) {
            System.out.println("Error en consulta de buscar un Aspirantes: " + e);
        }
        finally{
            try {
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();
                
            } catch (Exception e) {
                System.out.println("Error al cerrar rs y pstm: " + e);
            }
        }
        return aspirante;
    }

 
}
