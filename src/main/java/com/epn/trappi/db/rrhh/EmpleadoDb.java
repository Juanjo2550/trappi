package com.epn.trappi.db.rrhh;

import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.models.rrhh.juanjo.Administrativo;
import com.epn.trappi.models.rrhh.juanjo.Conductor;
import com.epn.trappi.models.rrhh.juanjo.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class EmpleadoDb implements ModelDb<Empleado> {
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
                    (this.obtenerTodos().length + 1) + "," +
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
        try {
            PreparedStatement prepsInsertProduct = this.connection.prepareStatement(insertSql);
            prepsInsertProduct.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    public Empleado buscarUno(String cedula){
        String sql = "SELECT * FROM dbo.EMPLEADO WHERE CEDULAEMP='" + cedula + "';";
        Empleado empleadoObtenido = null;
        try {
            Statement createdStatement = this.connection.createStatement();
            ResultSet resultSet = createdStatement.executeQuery(sql);
            while(resultSet.next()) {
                if (resultSet.getString(10).equals("conductor")) {
                    empleadoObtenido = new Conductor(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getString(8),
                            resultSet.getString(11),
                            resultSet.getString(9),
                            resultSet.getString(12).charAt(0)
                    );
                } else {
                    empleadoObtenido = new Administrativo(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getString(8),
                            resultSet.getString(11),
                            resultSet.getString(9),
                            resultSet.getString(12).charAt(0)
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
        return empleadoObtenido;
    }
    public Empleado buscarUno(int id){
        String sql = "SELECT * FROM dbo.EMPLEADO WHERE IDEMP=" + id + ";";
        Empleado empleadoObtenido = null;
        try {
            Statement createdStatement = this.connection.createStatement();
            ResultSet resultSet = createdStatement.executeQuery(sql);
            while(resultSet.next()) {
                if (resultSet.getString(10).equals("conductor")) {
                    empleadoObtenido = new Conductor(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getString(8),
                            resultSet.getString(11),
                            resultSet.getString(9),
                            resultSet.getString(12).charAt(0)
                    );
                } else {
                    empleadoObtenido = new Administrativo(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getString(8),
                            resultSet.getString(11),
                            resultSet.getString(9),
                            resultSet.getString(12).charAt(0)
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
        return empleadoObtenido;
    }
    public Empleado[] obtenerTodos(){
        String sql = "SELECT * FROM dbo.EMPLEADO";
        ArrayList<Empleado> empleados = new ArrayList<>();
        try {
            Statement createdStatement = this.connection.createStatement();
            ResultSet resultSet = createdStatement.executeQuery(sql);
            while(resultSet.next()) {
                if(resultSet.getString(10).equals("conductor")) {
                    empleados.add(new Conductor(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getString(8),
                            resultSet.getString(11),
                            resultSet.getString(9),
                            resultSet.getString(12).charAt(0)
                    ));
                } else {
                    empleados.add(new Administrativo(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getString(8),
                            resultSet.getString(11),
                            resultSet.getString(9),
                            resultSet.getString(12).charAt(0)
                    ));
                }

            }
        } catch (SQLException e){
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
        Empleado[] empleadosArray = new Empleado[empleados.size()];
        empleadosArray = empleados.toArray(empleadosArray);
        return empleadosArray;
    }

    public static void main(String args[]) throws SQLException {
        EmpleadoDb l1 = new EmpleadoDb();
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
        
//        System.out.println(l1.buscarUno("1722951165").toString());
    }
}
