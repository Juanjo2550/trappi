/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.rrhh.listas;

import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.models.rrhh.Fecha;
import com.epn.trappi.models.rrhh.diego.SolicitudDePago;
import com.epn.trappi.models.rrhh.juanjo.Empleado;
import com.epn.trappi.models.rrhh.juanjo.RolDePagos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

/**
 *
 * @author diego
 */
public class ListaSolicitudesPago implements Lista<SolicitudDePago> {
    private final Connection connection = Objects.requireNonNull(DataBaseConnection.getInstance()).getConnection();
    @Override
    public void agregar(SolicitudDePago newSolicitudDePago) {
                System.out.println("Generando Solicitud....");
        String sql = "INSERT INTO dbo.SOLICITUDPAGOROLES (IDSOLPAGO, ID_ROL, IDEMP, FECHASOLIC, ESTADOSOLIC) VALUES ("
                + (this.obtenerTodos().length + 1) + ","
                + "'" + newSolicitudDePago.getRol().getNumero() + "',"
                + "'" + newSolicitudDePago.getEmpleadoAPagar().getId() + "',"
                + "'" + newSolicitudDePago.getFechaSolicitud().toString() + "',"
                + "'" + newSolicitudDePago.getEstado() + "');";

        try {
            PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.execute();
        }catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public Boolean eliminar(String parametro) {
        return null;
    }

    @Override
    public SolicitudDePago buscarUno(String cedula) {
        return null;
             /*   Empleado empleado = new ListaEmpleados().buscarUno(cedula);
        String sql = "SELECT * FROM dbo.SOLICITUDPAGOROLES WHERE IDEMP=" + empleado.getId() + ";";
        RolDePagos solicitudes = null;
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                String unformattedDate = resultSet.getDate(3).toString();
                String[] formattedDate = unformattedDate.split("-");
                solicitudes = new SolicitudDePago(
                        resultSet.getInt(1),
                      
                        empleado,
                        new Fecha(Integer.parseInt(formattedDate[2]), Integer.parseInt(formattedDate[1]), Integer.parseInt(formattedDate[0])),
                        resultSet.getBigDecimal(4).doubleValue(),
                        resultSet.getBigDecimal(5).doubleValue(),
                        resultSet.getString(6)
                );
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return solicitudes;*/
    }

    @Override
    public SolicitudDePago[] obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
