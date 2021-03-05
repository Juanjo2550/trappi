package com.epn.trappi.models.rrhh.listas;

import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.models.rrhh.Fecha;
import com.epn.trappi.models.rrhh.Hora;
import com.epn.trappi.models.rrhh.juanjo.Empleado;
import com.epn.trappi.models.rrhh.juanjo.Observacion;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class ListaObservaciones implements Lista<Observacion> {
    private final Connection connection = Objects.requireNonNull(DataBaseConnection.getInstance()).getConnection();

    @Override
    public void agregar(Observacion newObservacion) {
        String sql = "INSERT INTO dbo.OBSERVACIONES(IDOBS, IDEMP, TIPOOBS, DESCRIPOBS, FECHAOBS, DIFERENCIAHORAS) VALUES ("
                + (this.obtenerTodos().length + 1) + (",")
                + newObservacion.getEmpleado().getId() + ","
                + "'" + newObservacion.getTipo() + "',"
                + "'" + newObservacion.getDescripcion() + "',"
                + "'" + newObservacion.getFecha().toString() +"',"
                + newObservacion.getHorasImplicadas().getHora() + ");";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public Boolean eliminar(String parametro) {
        return false;
    }

    @Deprecated
    @Override
    public Observacion buscarUno(String parametro) {
        return null;
    }

    public Observacion[] obtenerTodos(String cedula, Fecha fecha) throws Exception {
        Empleado empleado = new ListaEmpleados().buscarUno(cedula);
        String sql = "SELECT * FROM dbo.OBSERVACIONES WHERE IDEMP = "
                + empleado.getId() + " AND FECHAOBS ="
                + "'" + fecha.toString() + "';";
        ArrayList<Observacion> observaciones = new ArrayList<>();
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String unformattedDate = resultSet.getDate(5).toString();
                String[] formattedDate = unformattedDate.split("-");
                observaciones.add(new Observacion(
                        empleado,
                        resultSet.getString(3),
                        resultSet.getString(4),
                        new Fecha(Integer.parseInt(formattedDate[2]), Integer.parseInt(formattedDate[1]), Integer.parseInt(formattedDate[0])),
                        new Hora(resultSet.getInt(6), 0, 0)
                        ));
            }
        } catch (SQLException e){
            System.out.println(e.toString());
        }
        if (observaciones.size() == 0) {
            throw new Exception("No se han encontrado observaciones");
        }
        Observacion [] observacionesArray = new Observacion[observaciones.size()];
        observacionesArray = observaciones.toArray(observacionesArray);
        return observacionesArray;
    }

    /**
     * Obtiene las observaciones de un empleado por mes
     * @param cedula
     * @param mes
     * @return
     * @throws Exception
     */
    public Observacion[] obtenerTodos(String cedula, int mes) throws Exception {
        Empleado empleado = new ListaEmpleados().buscarUno(cedula);
        String sql = "SELECT * FROM dbo.OBSERVACIONES WHERE IDEMP = "
                + empleado.getId() + " AND MONTH(FECHAOBS) =" + mes + ";";
        ArrayList<Observacion> observaciones = new ArrayList<>();
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String unformattedDate = resultSet.getDate(5).toString();
                String[] formattedDate = unformattedDate.split("-");
                observaciones.add(new Observacion(
                        empleado,
                        resultSet.getString(3),
                        resultSet.getString(4),
                        new Fecha(Integer.parseInt(formattedDate[2]), Integer.parseInt(formattedDate[1]), Integer.parseInt(formattedDate[0])),
                        new Hora(resultSet.getInt(6), 0, 0)
                ));
            }
        } catch (SQLException e){
            System.out.println(e.toString());
        }
//        if (observaciones.size() == 0) {
//            throw new Exception("No se han encontrado observaciones");
//        }
        Observacion [] observacionesArray = new Observacion[observaciones.size()];
        observacionesArray = observaciones.toArray(observacionesArray);
        return observacionesArray;
    }

    public Observacion[] obtenerTodos(String cedula) throws Exception {
        Empleado empleado = new ListaEmpleados().buscarUno(cedula);
        String sql = "SELECT * FROM dbo.OBSERVACIONES WHERE IDEMP = "
                + empleado.getId() + ";";
        ArrayList<Observacion> observaciones = new ArrayList<>();
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String unformattedDate = resultSet.getDate(5).toString();
                String[] formattedDate = unformattedDate.split("-");
                observaciones.add(new Observacion(
                        empleado,
                        resultSet.getString(3),
                        resultSet.getString(4),
                        new Fecha(Integer.parseInt(formattedDate[2]), Integer.parseInt(formattedDate[1]), Integer.parseInt(formattedDate[0])),
                        new Hora(resultSet.getInt(6), 0, 0)
                ));
            }
        } catch (SQLException e){
            System.out.println(e.toString());
        }
        if (observaciones.size() == 0) {
            throw new Exception("No se han encontrado observaciones");
        }
        Observacion [] observacionesArray = new Observacion[observaciones.size()];
        observacionesArray = observaciones.toArray(observacionesArray);
        return observacionesArray;
    }

    @Override
    public Observacion[] obtenerTodos() {
        String sql = "SELECT * FROM dbo.OBSERVACIONES";
        ArrayList<Observacion> observaciones = new ArrayList<>();
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String unformattedDate = resultSet.getDate(5).toString();
                String[] formattedDate = unformattedDate.split("-");
                observaciones.add(new Observacion(
                        new ListaEmpleados().buscarUno(resultSet.getInt(2)),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        new Fecha(Integer.parseInt(formattedDate[2]), Integer.parseInt(formattedDate[1]), Integer.parseInt(formattedDate[0])),
                        new Hora(resultSet.getInt(6), 0, 0)
                ));
            }
        } catch (SQLException e){
            System.out.println(e.toString());
        }
        if (observaciones.size() == 0) {
            return new Observacion[0];
        }
        Observacion [] observacionesArray = new Observacion[observaciones.size()];
        observacionesArray = observaciones.toArray(observacionesArray);
        return observacionesArray;
    }

    public static void main(String args[]) throws SQLException {
        ListaObservaciones l1 = new ListaObservaciones();
        try {
            l1.obtenerTodos("1722951165");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
