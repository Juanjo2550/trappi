package com.epn.trappi.models.rrhh.listas;

import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.models.rrhh.juanjo.Administrativo;
import com.epn.trappi.models.rrhh.juanjo.Asistencia;
import com.epn.trappi.models.rrhh.juanjo.Conductor;
import com.epn.trappi.models.rrhh.juanjo.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class ListaEmpleados implements Lista<Empleado> {
    private final Connection connection = Objects.requireNonNull(DataBaseConnection.getInstance()).getConnection();

    public void agregar(Empleado nuevoEmpleado) {
        String insertSql;
        if (nuevoEmpleado instanceof Conductor) {
            insertSql = "INSERT INTO dbo.EMPLEADO(IDEMP, NOMBREEMP, APELLIDOEMP, CEDULAEMP, CARGOEMP, DEPARTAMENTOEMP, CUENTABANCARIAEMP, BANCOEMP, ESTADOEMP, TIPOEMP, SUELDOEMP, SEXOEMP) " +
                    "VALUES (" +
                    (this.obtenerTodos().length + 1) + "," +
                    "'" + nuevoEmpleado.getNombres() + "' ," +
                    "'" + nuevoEmpleado.getApellidos() + "' ," +
                    "'" + nuevoEmpleado.getCedula() + "' ," +
                    "'" + nuevoEmpleado.getCargo() + "' ," +
                    "'" + nuevoEmpleado.getDepartamento() + "' ," +
                    "'" + nuevoEmpleado.getCuentaBancaria() + "' ," +
                    "'" + nuevoEmpleado.getBanco() + "' ," +
                    "'" + nuevoEmpleado.getEstado() + "'," +
                    "'conductor',"+
                    "'" + nuevoEmpleado.getSueldo() + "'," +
                    "'" + nuevoEmpleado.getSexo() + "');";
        } else {
            insertSql = "INSERT INTO dbo.EMPLEADO(IDEMP, NOMBREEMP, APELLIDOEMP, CEDULAEMP, CARGOEMP, DEPARTAMENTOEMP, CUENTABANCARIAEMP, BANCOEMP, ESTADOEMP, TIPOEMP, SUELDOEMP, SEXOEMP) " +
                    "VALUES (" +
                    this.obtenerTodos().length + "," +
                    "'" + nuevoEmpleado.getNombres() + "' ," +
                    "'" + nuevoEmpleado.getApellidos() + "' ," +
                    "'" + nuevoEmpleado.getCedula() + "' ," +
                    "'" + nuevoEmpleado.getCargo() + "' ," +
                    "'" + nuevoEmpleado.getDepartamento() + "' ," +
                    "'" + nuevoEmpleado.getCuentaBancaria() + "' ," +
                    "'" + nuevoEmpleado.getBanco() + "' ," +
                    "'" + nuevoEmpleado.getEstado() + "'," +
                    "'administrativo',"+
                    "'" + nuevoEmpleado.getSueldo() + "'," +
                    "'" + nuevoEmpleado.getSexo() + "');";
        }
        ResultSet resultSet;
        try {
            PreparedStatement prepsInsertProduct = this.connection.prepareStatement(insertSql);
            prepsInsertProduct.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    public Boolean eliminar(String cedula){
        String sql = "DELETE FROM dbo.EMPLEADO WHERE CEDULAEMP='" + cedula + "';";
        boolean success = false;
        try {
            Statement createdStatment = this.connection.createStatement();
            createdStatment.executeQuery(sql);
            success = true;
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return success;
    }
    public Empleado buscarUno(String cedula){
        String sql = "SELECT * FROM dbo.EMPLEADO WHERE CEDULAEMP='" + cedula + "';";
        Empleado empleadoObtenido = null;
        try {
            Statement createdStatement = this.connection.createStatement();
            ResultSet resultSet = createdStatement.executeQuery(sql);
            String tipoEmpleado = resultSet.getString(10);
            if ("conductor".equalsIgnoreCase(tipoEmpleado)) {
                empleadoObtenido = new Conductor(
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        new Asistencia[]{},
                        resultSet.getString(11),
                        resultSet.getString(9),
                        resultSet.getString(12).charAt(0)
                );
            } else {
                empleadoObtenido = new Administrativo(
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        new Asistencia[]{},
                        resultSet.getString(11),
                        resultSet.getString(9),
                        resultSet.getString(12).charAt(0)
                );
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return empleadoObtenido;
    }
    public Empleado[] obtenerTodos(){
        String sql = "SELECT * FROM dbo.EMPLEADO";
        ArrayList<Empleado> empleados = new ArrayList<>();
        try {
            Statement createdStatment = this.connection.createStatement();
            ResultSet resultSet = createdStatment.executeQuery(sql);
            while(resultSet.next()) {
                if(resultSet.getString(10).equals("conductor")) {
                    empleados.add(new Conductor(
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getString(8),
                            new Asistencia[]{},
                            resultSet.getString(11),
                            resultSet.getString(9),
                            resultSet.getString(12).charAt(0)
                    ));
                } else {
                    empleados.add(new Administrativo(
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getString(8),
                            new Asistencia[]{},
                            resultSet.getString(11),
                            resultSet.getString(9),
                            resultSet.getString(12).charAt(0)
                    ));
                }

            }
        } catch (SQLException e){
            System.out.println(e.toString());
        }
        Empleado[] empleadosArray = new Empleado[empleados.size()];
        empleadosArray = empleados.toArray(empleadosArray);
        return empleadosArray;
    }

    public static void main(String args[]) throws SQLException {
        ListaEmpleados l1 = new ListaEmpleados();
//        l1.agregar(new Conductor(
//                "Alisson Dayana",
//                "Taco Almachi",
//                "1706496880",
//                "programador",
//                "RRHH",
//                "23573849390",
//                "Pichincha",
//                new Asistencia[]{},
//                "1500",
//                "Activo",
//                'F'
//        ));
        for (Empleado e : l1.obtenerTodos()) {
            System.out.println(e.getNombres());
        }
    }
}
