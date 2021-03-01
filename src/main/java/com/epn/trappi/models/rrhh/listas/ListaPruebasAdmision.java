package com.epn.trappi.models.rrhh.listas;

import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.models.rrhh.contratacion.Aspirante;
import com.epn.trappi.models.rrhh.contratacion.PruebaAdmision;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Javier Erazo
 */
public class ListaPruebasAdmision implements Lista <PruebaAdmision> {
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
    public void agregar(PruebaAdmision nuevaPruebaAdm, String cedulaAsp){
        try { 
            String query = "SELECT * FROM ASPIRANTE WHERE CEDULAASP = " + cedulaAsp;
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            System.out.println("cedula  se obtuvo fue " + cedulaAsp);
            int idAspirante = 0;
            while(rs.next()){
                idAspirante = rs.getInt("ID_ASP");
            }
            System.out.println("id se obtuvo fue " + idAspirante);
//            int idPrueba = obtenerTodos().length + 1;
//            query = "INSERT INTO PRUEBAADMISION ( IDPRUEBA, ID_ASP, PUNTAJEPRUEBA, ACTITUDESPRUEBA, APTITUDESPRUEBA, APROBACIONPRUEBA) VALUES (?, ?, ?, ?, ?, ?)";
//            pstm = conn.prepareStatement(query);
//            pstm.setInt(1, idPrueba);
//            pstm.setInt(2, idAspirante);
//            pstm.setInt(3, nuevaPruebaAdm.getPuntaje());
//            pstm.setString(4, nuevaPruebaAdm.getActitudes());
//            pstm.setString(5, nuevaPruebaAdm.getAptitudes());
//            pstm.setString(6, nuevaPruebaAdm.getAprobacion());
//            pstm.executeUpdate();
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
            int idAsp = obtenerTodos().length + 1;
            String query = "INSERT INTO PRUEBAADMISION ( ID_ASP, NOMBREASP, APELLIDOASP, CEDULAASP, TELEFONOASP, CARGOASP) VALUES (?, ?, ?, ?, ?, ?)";
            pstm = conn.prepareStatement(query);
//            pstm.setInt(1, idAsp);
//            pstm.setString(2, nuevaPruebaAdm.getNombre());
//            pstm.setString(3, nuevaPruebaAdm.getApellidos());
//            pstm.setString(4, nuevaPruebaAdm.getCedula());
//            pstm.setString(5, nuevaPruebaAdm.getTelefono());
//            pstm.setString(6, nuevaPruebaAdm.getCargoAspirante());
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PruebaAdmision buscarUno(String parametro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
