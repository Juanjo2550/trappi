/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.db.rrhh;

import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.models.rrhh.Fecha;
import com.epn.trappi.models.rrhh.diego.SolicitudDePago;
import com.epn.trappi.models.rrhh.juanjo.RolDePagos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class SolicitudPagoDB implements ModelDb<SolicitudDePago> {

    ArrayList<SolicitudDePago> listaSolicitudDePago;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    ResultSet rs1 = null;
    DataBaseConnection dbInstance = DataBaseConnection.getInstance();
    Connection conn = dbInstance.getConnection();

    @Override
    public void agregar(SolicitudDePago newSolicitudDePago) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void agregar(SolicitudDePago nuevaSolicitudDePago, String cedulaEmp) {
        try {
            //String query = "SELECT * FROM EMPLEADO WHERE CEDULAEMP = " + "'" + cedulaEmp + "'";
            String query = "SELECT EMPLEADO.CEDULAEMP,ROLPAGOS.ID_ROL FROM EMPLEADO INNER JOIN ROLPAGOS ON EMPLEADO.IDEMP=ROLPAGOS.IDEMP WHERE CEDULAEMP =" + "'" + cedulaEmp + "'";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            RolDePagos rol= new RolDePagosDb().buscarUno(cedulaEmp);
           
            int idEmpleado = 0;
            
            while (rs.next()) {
                idEmpleado = rs.getInt("IDEMP");
                
            }
      
            int idSolicitud = obtenerTodos().length + 1;
            query = "INSERT INTO SOLICITUDPAGOROLES ( IDSOLPAGO, ID_ROL, IDEMP, FECHASOLIC, ESTADOSOLIC) VALUES (?, ?, ?, ?, ?)";
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, idSolicitud);
            pstm.setInt(2, rol.getNumero());
            pstm.setInt(3, idEmpleado);
            pstm.setString(4, nuevaSolicitudDePago.getFechaSolicitud().toString());
            pstm.setString(5, nuevaSolicitudDePago.getEstado());

            pstm.executeUpdate();
            System.out.println("La solicitud de pago se registro con exito" + idEmpleado + " cedula " + cedulaEmp);

        } catch (SQLException e) {
            System.out.println("Error en insercion de Solicitud de Pago: " + e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }

            } catch (SQLException e) {
                System.out.println("Error al cerrar rs y pstm: " + e);
            }
        }
    }

    @Override
    public SolicitudDePago buscarUno(String parametro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SolicitudDePago[] obtenerTodos() {
        listaSolicitudDePago = new ArrayList<>();
        try {
            String query = "SELECT * FROM SOLICITUDPAGOROLES";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();

            while (rs.next()) {
                String fechaTemp = rs.getString("FECHASOLIC");
                String[] fechaArr = fechaTemp.split("-");
                Fecha fecha = new Fecha(Integer.parseInt(fechaArr[2]), Integer.parseInt(fechaArr[1]), Integer.parseInt(fechaArr[0]));
                 listaSolicitudDePago.add(new SolicitudDePago(rs.getInt("IDSOLPAGO"), fecha,
               rs.getString("ESTADOSOLIC")));

            }
            System.out.println("Consulta se hizo con exito");

        } catch (SQLException e) {
            System.out.println("Error en consulta de Solicitudes de Pago: " + e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }

            } catch (SQLException e) {
                System.out.println("Error al cerrar rs y pstm: " + e);
            }
        }
        SolicitudDePago[] solicitudesDePago = new SolicitudDePago[listaSolicitudDePago.size()];
        solicitudesDePago = listaSolicitudDePago.toArray(solicitudesDePago);
        return solicitudesDePago;
    }

    public SolicitudDePago[] obtenerTodos(String cedulaEmp) {
        String sql = "SELECT EMPLEADO.CUENTABANCARIAEMP,ROLPAGOS.TOTALROL FROM EMPLEADO INNER JOIN ROLPAGOS ON EMPLEADO.IDEMP=ROLPAGOS.IDEMP WHERE CEDULAEMP =" + "'" + cedulaEmp + "'";
        ArrayList<SolicitudDePago> solicitudes = new ArrayList<>();
        
        SolicitudDePago [] solicitudesArray = new SolicitudDePago[solicitudes.size()];
        solicitudesArray = solicitudes.toArray(solicitudesArray);
        return solicitudesArray;
    }

    public static void main(String args[]) throws SQLException {
        SolicitudPagoDB l1 = new SolicitudPagoDB();
        try {
            SolicitudDePago a = new SolicitudDePago();
            l1.agregar(a, "1722951165");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
