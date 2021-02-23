/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epn.trappi.db.rrhh;

import java.sql.*;

import com.epn.trappi.models.rrhh.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 
 * @author Juan Jaramillo <juanjodev02 at juan.jaramillo02@epn.edu.ec>
 */
public class EmpleadoDb {
    public Map<Integer, ListaRegistrosAsistencias> asistenciasMock;

    public EmpleadoDb () {
        this.asistenciasMock = new HashMap<>();
        ListaRegistrosAsistencias l1 = new ListaRegistrosAsistencias();
        ListaRegistrosAsistencias l2 = new ListaRegistrosAsistencias();
        ListaRegistrosAsistencias l3 = new ListaRegistrosAsistencias();


        l1.añadirRegistroAsistencia(new RegistroAsistencia(new Hora(), new Fecha(), new Hora()));
        l1.añadirRegistroAsistencia(new RegistroAsistencia(new Hora(), new Fecha(), new Hora()));
        l1.añadirRegistroAsistencia(new RegistroAsistencia(new Hora(), new Fecha(), new Hora()));
        l1.añadirRegistroAsistencia(new RegistroAsistencia(new Hora(), new Fecha(), new Hora()));
        l1.añadirRegistroAsistencia(new RegistroAsistencia(new Hora(), new Fecha(), new Hora()));
        l1.añadirRegistroAsistencia(new RegistroAsistencia(new Hora(), new Fecha(), new Hora()));

        l2.añadirRegistroAsistencia(new RegistroAsistencia(new Hora(), new Fecha(), new Hora()));
        l2.añadirRegistroAsistencia(new RegistroAsistencia(new Hora(), new Fecha(), new Hora()));
        l2.añadirRegistroAsistencia(new RegistroAsistencia(new Hora(), new Fecha(), new Hora()));
        l2.añadirRegistroAsistencia(new RegistroAsistencia(new Hora(), new Fecha(), new Hora()));
        l2.añadirRegistroAsistencia(new RegistroAsistencia(new Hora(), new Fecha(), new Hora()));
        l2.añadirRegistroAsistencia(new RegistroAsistencia(new Hora(), new Fecha(), new Hora()));

        l3.añadirRegistroAsistencia(new RegistroAsistencia(new Hora(), new Fecha(), new Hora()));
        l3.añadirRegistroAsistencia(new RegistroAsistencia(new Hora(), new Fecha(), new Hora()));
        l3.añadirRegistroAsistencia(new RegistroAsistencia(new Hora(), new Fecha(), new Hora()));
        l3.añadirRegistroAsistencia(new RegistroAsistencia(new Hora(), new Fecha(), new Hora()));
        l3.añadirRegistroAsistencia(new RegistroAsistencia(new Hora(), new Fecha(), new Hora()));
        l3.añadirRegistroAsistencia(new RegistroAsistencia(new Hora(), new Fecha(), new Hora()));

        this.asistenciasMock.put(1, l1);
        this.asistenciasMock.put(2, l2);
        this.asistenciasMock.put(3, l3);
    }


    public ListaEmpleados selectAll(){
        String sql = "SELECT * FROM empleados";
        ListaEmpleados temEmpleados = new ListaEmpleados();
        try {
            Connection conn = Connect.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            // loop through the result set
            while (rs.next()) {
                temEmpleados.agregar(new Empleado(
                rs.getString("nombres"),
                rs.getString("apellidos"),
                rs.getInt("cedula"),
                rs.getString("cargo"),
                rs.getString("departamento"),
                rs.getString("cuentaBancaria"),
                rs.getString("banco"),
                asistenciasMock.get(ThreadLocalRandom.current().nextInt(1, 3 + 1)),
                new SueldoDb().obtenerPorEmpleado(rs.getInt("cedula")),
                rs.getString("estado"),
                rs.getString("sexo").charAt(0)
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return temEmpleados;
    }

    public boolean addOne(Empleado nuevoEmpleado, Sueldo sueldo) {
        String sql = "INSERT INTO empleados(cedula,nombres, apellidos, cargo, departamento, cuentaBancaria, banco, RegistroAsistencia, estado, sexo) VALUES(?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = Connect.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, nuevoEmpleado.getCedula());
            pstmt.setString(2, nuevoEmpleado.getNombres());
            pstmt.setString(3, nuevoEmpleado.getApellidos());
            pstmt.setString(4, nuevoEmpleado.getCargo());
            pstmt.setString(5, nuevoEmpleado.getDepartamento());
            pstmt.setString(6, nuevoEmpleado.getCuentaBancaria());
            pstmt.setString(7, nuevoEmpleado.getBanco());
            pstmt.setInt(8, ThreadLocalRandom.current().nextInt(1, 3 + 1));
            pstmt.setString(9, nuevoEmpleado.getEstado());
            pstmt.setString(10, nuevoEmpleado.getSexo() + "");
            pstmt.executeUpdate();
            new SueldoDb().addOne(nuevoEmpleado, sueldo);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
