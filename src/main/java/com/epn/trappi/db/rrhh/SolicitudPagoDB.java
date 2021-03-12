/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.db.rrhh;

import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.models.financiero.Pago;
import com.epn.trappi.models.rrhh.Fecha;
import com.epn.trappi.models.rrhh.diego.SolicitudDePago;
import com.epn.trappi.models.rrhh.juanjo.Empleado;
import com.epn.trappi.models.rrhh.juanjo.RolDePagos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

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
            System.out.println("Guardando rol....");
            Empleado empleado = new EmpleadoDb().buscarUno(cedulaEmp);
            //String query = "SELECT * FROM EMPLEADO WHERE CEDULAEMP = " + "'" + cedulaEmp + "'";
            //String query = "SELECT EMPLEADO.CEDULAEMP,ROLPAGOS.ID_ROL FROM EMPLEADO INNER JOIN ROLPAGOS ON EMPLEADO.IDEMP=ROLPAGOS.IDEMP WHERE CEDULAEMP = " + "'" + cedulaEmp + "'";

            RolDePagos rol = new RolDePagosDb().buscarUno(cedulaEmp);
            String query = "SELECT * FROM dbo.ROLPAGOS WHERE IDEMP=" + empleado.getId() + "AND ESTADOROL='Pendiente';";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();

            int idSolicitud = obtenerTodos().length + 1;
            query = "INSERT INTO SOLICITUDPAGOROLES ( IDSOLPAGO, ID_ROL, IDEMP, FECHASOLIC, ESTADOSOLIC) VALUES (?, ?, ?, ?, ?)";
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, idSolicitud);
            pstm.setInt(2, rol.getNumero());
            pstm.setInt(3, empleado.getId());
            pstm.setString(4, nuevaSolicitudDePago.getFechaSolicitud().toString());
            pstm.setString(5, nuevaSolicitudDePago.getEstado());

            pstm.executeUpdate();
            System.out.println("La solicitud de pago se registro con exito " + empleado.getId() + " cedula " + cedulaEmp);

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

        ArrayList<SolicitudDePago> solicitudes = new ArrayList<>();
        try {

            String query = "SELECT EMPLEADO.CUENTABANCARIAEMP,ROLPAGOS.TOTALROL FROM EMPLEADO INNER JOIN ROLPAGOS ON EMPLEADO.IDEMP=ROLPAGOS.IDEMP WHERE CEDULAEMP =" + "'" + cedulaEmp + "'";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            System.out.println("Consulta se hizo con exito");
            while (rs.next()) {
                solicitudes.add(new SolicitudDePago(rs.getString("CUENTABANCARIAEMP"),
                        rs.getDouble("TOTALROL")));
            }
        } catch (SQLException e) {
            System.out.println("Error en consulta de Solicitudes de Pago: " + e);
        }
        SolicitudDePago[] solicitudesArray = new SolicitudDePago[solicitudes.size()];
        solicitudesArray = solicitudes.toArray(solicitudesArray);
        return solicitudesArray;
    }

    public void actualizarEstado(String cedulaEmp) {
        Empleado empleado = new EmpleadoDb().buscarUno(cedulaEmp);
        RolDePagos rol = new RolDePagosDb().buscarUno(cedulaEmp);
        Pago pago = new Pago(empleado.getCuentaBancaria(), rol.getTotal());
        System.out.println(empleado.getCuentaBancaria());
        System.out.println(rol.getTotal());
        String cambioEstado = pago.realizarPago(pago);
        try {
            String query = "UPDATE ROLPAGOS SET ESTADOROL=" + "'" + cambioEstado + "'" + " WHERE ID_ROL=" + "'" + rol.getNumero() + "';";
            //String query2 = "UPDATE SOLICITUDPAGOROLES SET ESTADOSOLIC=" + "'" + cambioEstado + "'" + " WHERE ID_ROL=" + "'" + rol.getNumero() + "';";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            //pstm=conn.prepareStatement(query2);
            //rs = pstm.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        try {
            // String query = "UPDATE ROLPAGOS SET ESTADOROL=" + "'" + cambioEstado + "'" + " WHERE ID_ROL=" + "'" + rol.getNumero() + "';";
            String query2 = "UPDATE SOLICITUDPAGOROLES SET ESTADOSOLIC=" + "'" + cambioEstado + "'" + " WHERE ID_ROL=" + "'" + rol.getNumero() + "';";
            //pstm = conn.prepareStatement(query);
            //rs = pstm.executeQuery();
            pstm = conn.prepareStatement(query2);
            rs = pstm.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public static void main(String args[]) throws SQLException {
        SolicitudPagoDB l1 = new SolicitudPagoDB();

        try {
            SolicitudDePago a = new SolicitudDePago(new Fecha(), "Pendiente");
            l1.agregar(a, "1725527356");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(Arrays.stream(l1.obtenerTodos("1725527356")).count());
            for (SolicitudDePago s : l1.obtenerTodos("1725527356")) {
                System.out.println(s.toString());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        l1.actualizarEstado("1725527356");
    }
}
