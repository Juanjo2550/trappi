package com.epn.trappi.models.rrhh.listas;

import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.models.rrhh.Fecha;
import com.epn.trappi.models.rrhh.Hora;
import com.epn.trappi.models.rrhh.juanjo.Asistencia;
import com.epn.trappi.models.rrhh.juanjo.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class ListaAsistencias implements Lista<Asistencia>{
    private final Connection connection = Objects.requireNonNull(DataBaseConnection.getInstance()).getConnection();

    @Override
    public void agregar(Asistencia nuevaAsistencia) {
        if (nuevaAsistencia.getHoraFin() == null) {
            this.agregarEntrada(nuevaAsistencia);
        } else {
            this.registrarSalida(nuevaAsistencia);
        }
    }

    private void agregarEntrada(Asistencia nuevaAsistencia) {
        String sql = "INSERT INTO dbo.ASISTENCIA (IDREGASIS, IDEMP, FECHAREGASIS, OBSASIS, HORAINGRESO) VALUES ("
                + (this.obtenerTodos().length + 1) + ","
                + new ListaEmpleados().buscarUno(nuevaAsistencia.getEmpleado().getCedula()).getId() + ","
                + "'" + nuevaAsistencia.getFecha().toString() + "',"
                + "'" + nuevaAsistencia.getObservaciones() + "',"
                + "'" + nuevaAsistencia.getHoraInicio().toString() + "');";
        try {
            PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public void registrarSalida(Asistencia asistencia) {
        String sql = "UPDATE dbo.ASISTENCIA SET HORASALIDA="
                + "'" + asistencia.getHoraFin().toString() + "' "
                + "WHERE IDEMP=" + asistencia.getEmpleado().getId() + " AND FECHAREGASIS="
                + "'" + asistencia.getFecha().toString() + "' AND HORAINGRESO="
                + "'" + asistencia.getHoraInicio().toString() + "';";
        System.out.println(sql);
        try {
            PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
            System.out.println("No se encuentra registrado el inicio de jornada");
        }
    }

    @Override
    public Boolean eliminar(String cedula) {
        return false;
    }

    @Override
    public Asistencia buscarUno(String parametro) {
//        throw new NotImplementedException();
        return null;
    }

    public Asistencia buscarUno(String cedula, Fecha fecha) throws Exception {
        Asistencia asistencia = null;
        ListaEmpleados l1 = new ListaEmpleados();
        Empleado empleado = l1.buscarUno(cedula);
        String sql =
                "SELECT * FROM dbo.ASISTENCIA WHERE IDEMP = "
                + empleado.getId() + " AND FECHAREGASIS ="
                + "'" + fecha.toString() + "';";
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String unformattedDate = resultSet.getDate(3).toString();
                String[] formattedDate = unformattedDate.split("-");
                if(resultSet.getTime(5) == null) {
                    asistencia = new Asistencia(
                            empleado,
                            new Hora(resultSet.getTime(6).getHours(),resultSet.getTime(6).getMinutes(), resultSet.getTime(6).getSeconds()),
                            new Fecha(Integer.parseInt(formattedDate[2]), Integer.parseInt(formattedDate[1]), Integer.parseInt(formattedDate[0])),
                            resultSet.getString(4)
                    );
                } else {
                    asistencia = new Asistencia(
                            empleado,
                            new Hora(resultSet.getTime(6).getHours(),resultSet.getTime(6).getMinutes(), resultSet.getTime(6).getSeconds()),
                            new Hora(resultSet.getTime(5).getHours(),resultSet.getTime(5).getMinutes(), resultSet.getTime(5).getSeconds()),
                            new Fecha(Integer.parseInt(formattedDate[2]), Integer.parseInt(formattedDate[1]), Integer.parseInt(formattedDate[0])),
                            resultSet.getString(4)
                    );
                }
            }
        } catch (SQLException e){
            System.out.println(e.toString());
        }

        if (asistencia != null) {
            return asistencia;
        } else {
            throw new Exception("No se han encontrado Asistencias");
        }
    }

    @Override
    public Asistencia[] obtenerTodos() {
        ArrayList<Asistencia> asistencia = new ArrayList<>();
        ListaEmpleados l1 = new ListaEmpleados();
        Empleado[] empleados = l1.obtenerTodos();
        String sql = "SELECT * FROM dbo.ASISTENCIA";
        try{
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String unformattedDate = resultSet.getDate(3).toString();
                String[] formattedDate = unformattedDate.split("-");
                Empleado currentEmpleado = null;
                for (Empleado emp : empleados) {
                    if (emp.getId() == resultSet.getInt(2)){
                        currentEmpleado = emp;
                    }
                }
                if(resultSet.getTime(5) == null) {
                    asistencia.add(new Asistencia(
                            currentEmpleado,
                            new Hora(resultSet.getTime(6).getHours(),resultSet.getTime(6).getMinutes(), resultSet.getTime(6).getSeconds()),
                            new Fecha(Integer.parseInt(formattedDate[2]), Integer.parseInt(formattedDate[1]), Integer.parseInt(formattedDate[0])),
                            resultSet.getString(4)
                    ));
                } else {
                    asistencia.add(new Asistencia(
                            currentEmpleado,
                            new Hora(resultSet.getTime(6).getHours(),resultSet.getTime(6).getMinutes(), resultSet.getTime(6).getSeconds()),
                            new Hora(resultSet.getTime(5).getHours(),resultSet.getTime(5).getMinutes(), resultSet.getTime(5).getSeconds()),
                            new Fecha(Integer.parseInt(formattedDate[2]), Integer.parseInt(formattedDate[1]), Integer.parseInt(formattedDate[0])),
                            resultSet.getString(4)
                    ));
                }
            }
        } catch (SQLException e){
            System.out.println(e.toString());
        }

        Asistencia[] asistencias = new Asistencia[asistencia.size()];
        asistencias = asistencia.toArray(asistencias);
        return asistencias;
    }

    public Asistencia[] obtenerTodos(String cedula) throws Exception {
        ArrayList<Asistencia> asistencia = new ArrayList<>();
        ListaEmpleados l1 = new ListaEmpleados();
        Empleado empleado = l1.buscarUno(cedula);
        String sql =
                "SELECT * FROM dbo.ASISTENCIA WHERE IDEMP = "
                        + empleado.getId() + ";";
        try{
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String unformattedDate = resultSet.getDate(3).toString();
                String[] formattedDate = unformattedDate.split("-");
                if(resultSet.getTime(5) == null) {
                    asistencia.add(new Asistencia(
                            empleado,
                            new Hora(resultSet.getTime(6).getHours(),resultSet.getTime(6).getMinutes(), resultSet.getTime(6).getSeconds()),
                            new Fecha(Integer.parseInt(formattedDate[2]), Integer.parseInt(formattedDate[1]), Integer.parseInt(formattedDate[0])),
                            resultSet.getString(4)
                    ));
                } else {
                    asistencia.add(new Asistencia(
                            empleado,
                            new Hora(resultSet.getTime(6).getHours(),resultSet.getTime(6).getMinutes(), resultSet.getTime(6).getSeconds()),
                            new Hora(resultSet.getTime(5).getHours(),resultSet.getTime(5).getMinutes(), resultSet.getTime(5).getSeconds()),
                            new Fecha(Integer.parseInt(formattedDate[2]), Integer.parseInt(formattedDate[1]), Integer.parseInt(formattedDate[0])),
                            resultSet.getString(4)
                    ));
                }
            }
        } catch (SQLException e){
            System.out.println(e.toString());
        }

        if (!asistencia.isEmpty()) {
            Asistencia[] asistencias = new Asistencia[asistencia.size()];
            asistencias = asistencia.toArray(asistencias);
            return asistencias;
        } else {
            throw new Exception("No se han encontrado Asistencias");
        }
    }

    public static void main(String args[]) throws SQLException {
        ListaAsistencias l1 = new ListaAsistencias();
        try {
            Asistencia a = new Asistencia(new ListaEmpleados().buscarUno("1722951165"), new Hora(), new Fecha(), "N/A");
            l1.agregar(a);
//            System.out.println(l1.obtenerTodos("1722951165").length);
//            System.out.print(l1.buscarUno("1722951165", new Fecha(02, 03, 2021)).getEmpleado().getNombres());
            a.setHoraFin(new Hora());
            l1.registrarSalida(a);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
