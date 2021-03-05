package com.epn.trappi.models.rrhh.listas;

import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.models.rrhh.Fecha;
import com.epn.trappi.models.rrhh.contratacion.Contrato;
import com.epn.trappi.models.rrhh.contratacion.PruebaAdmision;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Javier Erazo
 */
public class ListaContratos implements Lista<Contrato> {
    ArrayList <Contrato> listaContratos;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    DataBaseConnection dbInstance = DataBaseConnection.getInstance();
    Connection conn = dbInstance.getConnection();
    
    @Override
    public void agregar(Contrato newContrato) {
        try{
            int idContrato = obtenerTodos().length + 1;
            String query = "INSERT INTO CONTRATO (IDCONTRATO, FECHAINICIO, FECHAFIN, TIPOCONTRATO, REQCONTRATO, SUELDO) VALUES (?, ?, ?, ?, ?, ?)";
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, idContrato);
            pstm.setString(2, newContrato.getFechaInicio().toString());
            pstm.setString(3, newContrato.getFechaFin().toString());
            pstm.setString(4, newContrato.getTipo());
            pstm.setString(5, "SI");
            pstm.setString(6, newContrato.getSueldo());
             pstm.executeUpdate();

        } catch(Exception e){
            System.out.println("Error en insercion de Contrato: " + e);
        }
    }
    
    //Agregar un contrato con la cedula de un empleado asociado
    public void agregar(Contrato newContrato, String cedulaEmp){
        try{
            String query = "SELECT IDEMP FROM EMPLEADO WHERE CEDULAEMP = '" + cedulaEmp +"'";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            int idEmp = 0;
            rs.next();
            idEmp = rs.getInt("IDEMP");
            
            int idContrato = obtenerTodos().length + 1;
            query = "INSERT INTO CONTRATO (IDCONTRATO, IDEMP, FECHAINICIO, FECHAFIN, TIPOCONTRATO, REQCONTRATO, SUELDO) VALUES (?, ?, ?, ?, ?, ?, ?)";
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, idContrato);
            pstm.setInt(2, idEmp);
            pstm.setString(3, newContrato.getFechaInicio().toString());
            pstm.setString(4, newContrato.getFechaFin().toString());
            pstm.setString(5, newContrato.getTipo());
            pstm.setString(6, "SI");
            pstm.setString(7, newContrato.getSueldo());
             pstm.executeUpdate();
            System.out.println("El contrato se registro con exito" + idContrato + " CEDULA:  " + cedulaEmp);
            
            
        } catch(Exception e){
            System.out.println("Error en insercion de Contrato: " + e);
        }
    }

    @Override
    public Boolean eliminar(String parametro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Contrato buscarUno(String cedulaEmpleado) {
        Contrato contrato = null;
        try {
            String query = "SELECT * FROM EMPLEADO JOIN CONTRATO ON EMPLEADO.IDEMP = CONTRATO.IDEMP WHERE CEDULAEMP ='"+cedulaEmpleado+"'";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            rs.next();
            
            String fechaInicioTemp = rs.getString("FECHAINICIO");
            String [] fechaInicioArr = fechaInicioTemp.split("-");
            String fechaFinTemp = rs.getString("FECHAFIN");
            String [] fechaFinArr = fechaFinTemp.split("-");
            Fecha fechaInicio = new Fecha(Integer.parseInt(fechaInicioArr[2]), Integer.parseInt(fechaInicioArr[1]), Integer.parseInt(fechaInicioArr[0]));
            Fecha fechaFin = new Fecha(Integer.parseInt(fechaFinArr[2]), Integer.parseInt(fechaFinArr[1]), Integer.parseInt(fechaFinArr[0]));

            contrato = new Contrato(String.valueOf(rs.getInt("IDCONTRATO")), fechaInicio, fechaFin,
            rs.getString("TIPOCONTRATO"),String.valueOf(rs.getDouble("SUELDO")));
            System.out.println("Consulta Buscar un contrato se hizo con exito"); 
        } catch (Exception e) {
            System.out.println("Error en consulta de buscar un contrato (" + cedulaEmpleado+"): " + e);
        }
        finally{
            try {
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();
                
            } catch (Exception e) {
                System.out.println("Error al cerrar rs y pstm: " + e);
            }
        }
        return contrato;
    }

    @Override
    public Contrato[] obtenerTodos() {
        listaContratos = new ArrayList<>();
        try {
            String query = "SELECT * FROM CONTRATO";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            
            while(rs.next()){
               String fechaInicioTemp = rs.getString("FECHAINICIO");
               String [] fechaInicioArr = fechaInicioTemp.split("-");
               String fechaFinTemp = rs.getString("FECHAFIN");
               String [] fechaFinArr = fechaFinTemp.split("-");
               Fecha fechaInicio = new Fecha(Integer.parseInt(fechaInicioArr[2]), Integer.parseInt(fechaInicioArr[1]), Integer.parseInt(fechaInicioArr[0]));
               Fecha fechaFin = new Fecha(Integer.parseInt(fechaFinArr[2]), Integer.parseInt(fechaFinArr[1]), Integer.parseInt(fechaFinArr[0]));
               
               listaContratos.add(new Contrato(String.valueOf(rs.getInt("IDCONTRATO")), fechaInicio, fechaFin,
               rs.getString("TIPOCONTRATO"),String.valueOf(rs.getDouble("SUELDO"))));
            }
            System.out.println("Consulta se hizo con exito");
           
        } catch (Exception e) {
            System.out.println("Error en consulta de Contratos: " + e);
        }
        finally{
            try {
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();
                
            } catch (Exception e) {
                System.out.println("Error al cerrar rs y pstm: " + e);
            }
        }
       Contrato[] contratos = new Contrato[listaContratos.size()];
       contratos = listaContratos.toArray(contratos);
       return contratos;
    }
    
}
