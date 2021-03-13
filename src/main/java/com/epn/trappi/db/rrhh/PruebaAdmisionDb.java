package com.epn.trappi.db.rrhh;

import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.models.rrhh.contratacion.PruebaAdmision;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Javier Erazo
 */
public class PruebaAdmisionDb implements ModelDb <PruebaAdmision> {
    ArrayList <PruebaAdmision> listaPruebasAdmision;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    DataBaseConnection dbInstance = DataBaseConnection.getInstance();
    Connection conn = dbInstance.getConnection();

    @Override
    public PruebaAdmision[] obtenerTodos(){
        listaPruebasAdmision = new ArrayList<>();
        try {
            String query = "SELECT * FROM PRUEBAADMISION";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            
            while(rs.next()){
               listaPruebasAdmision.add(new PruebaAdmision(rs.getInt("PUNTAJEPRUEBA"), rs.getString("ACTITUDESPRUEBA"),
               rs.getString("APTITUDESPRUEBA")));
            }
            System.out.println("Consulta se hizo con exito");
           
        } catch (Exception e) {
            System.out.println("Error en consulta de Pruebas de Admision: " + e);
        }
        finally{
            try {
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();
                
            } catch (Exception e) {
                System.out.println("Error al cerrar rs y pstm: " + e);
            }
        }
       PruebaAdmision[] pruebasAdmision = new PruebaAdmision[listaPruebasAdmision.size()];
       pruebasAdmision = listaPruebasAdmision.toArray(pruebasAdmision);
       return pruebasAdmision;
    }
    
    //sgregar() permite registrar una PruebaAdmision con un Aspirante Asociado
    public void agregar(PruebaAdmision nuevaPruebaAdm, String cedulaAsp){
        try { 
            String query = "SELECT * FROM ASPIRANTE WHERE CEDULAASP = " + "'"+cedulaAsp+"'";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            int idAspirante = 0;
            while(rs.next()){
                idAspirante = rs.getInt("ID_ASP");
            }
            int idPrueba = obtenerTodos().length + 1;
            query = "INSERT INTO PRUEBAADMISION ( IDPRUEBA, ID_ASP, PUNTAJEPRUEBA, ACTITUDESPRUEBA, APTITUDESPRUEBA, APROBACIONPRUEBA) VALUES (?, ?, ?, ?, ?, ?)";
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, idPrueba);
            pstm.setInt(2, idAspirante);
            pstm.setInt(3, nuevaPruebaAdm.getPuntaje());
            pstm.setString(4, nuevaPruebaAdm.getActitudes());
            pstm.setString(5, nuevaPruebaAdm.getAptitudes());
            pstm.setString(6, nuevaPruebaAdm.getAprobacion());
            pstm.executeUpdate();
            System.out.println("La prueba de admision se registro con exito" + idAspirante + " cedula " + cedulaAsp);
            
        } catch (Exception e) {
            System.out.println("Error en insercion de Prueba Admision: " + e);
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
    public void agregar(PruebaAdmision nuevaPruebaAdm) {
        
        try { 
            
            int idPrueba = obtenerTodos().length + 1;
            String query = "INSERT INTO PRUEBAADMISION ( IDPRUEBA, PUNTAJEPRUEBA, ACTITUDESPRUEBA, APTITUDESPRUEBA, APROBACIONPRUEBA) VALUES (?, ?, ?, ?, ?)";
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, idPrueba);
            pstm.setInt(2, nuevaPruebaAdm.getPuntaje());
            pstm.setString(3, nuevaPruebaAdm.getActitudes());
            pstm.setString(4, nuevaPruebaAdm.getAptitudes());
            pstm.setString(5, nuevaPruebaAdm.getAprobacion());
            pstm.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error en insercion de Prueba Admision: " + e);
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
    public PruebaAdmision buscarUno(String cedulaAspirante) {
        PruebaAdmision prueba = null;
        try {
            String query = "SELECT * FROM ASPIRANTE JOIN PRUEBAADMISION on ASPIRANTE.ID_ASP = PRUEBAADMISION.ID_ASP WHERE CEDULAASP ='"+cedulaAspirante+"'";
           // System.out.println(query);
            pstm = conn.prepareStatement(query);
            //pstm.setString(0, cedulaAspirante);
            rs = pstm.executeQuery();
            rs.next();
            prueba = new PruebaAdmision(rs.getInt("PUNTAJEPRUEBA"), rs.getString("ACTITUDESPRUEBA"),
            rs.getString("APTITUDESPRUEBA"));
            
            System.out.println("Consulta Buscar una prueba se hizo con exito");
           
        } catch (Exception e) {
            System.out.println("Error en consulta de buscar una prueba (" + cedulaAspirante+"): " + e);
        }
        finally{
            try {
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();
                
            } catch (Exception e) {
                System.out.println("Error al cerrar rs y pstm: " + e);
            }
        }
        return prueba;
    }


    
}
