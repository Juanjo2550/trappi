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
    public void agregar(Contrato newObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            String [] fechaFinArr = fechaInicioTemp.split("-");
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
               String [] fechaFinArr = fechaInicioTemp.split("-");
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
