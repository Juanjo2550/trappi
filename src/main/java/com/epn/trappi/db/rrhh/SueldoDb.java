/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epn.trappi.db.rrhh;

import com.epn.trappi.models.rrhh.juanjo.Empleado;
import com.epn.trappi.models.rrhh.Sueldo;

import java.sql.*;

/**
 * 
 * @author Juan Jaramillo <juanjodev02 at juan.jaramillo02@epn.edu.ec>
 */
public class SueldoDb {
    public Sueldo obtenerPorEmpleado (String Cedulaempleado){
        String sql = "SELECT * FROM sueldos WHERE sueldos.cedulaEmpleado = ?";
        try {
            Connection conn = Connect.connect("juanjo.db");
            PreparedStatement pstmt  = conn.prepareStatement(sql);
            pstmt.setString(1, Cedulaempleado);
            ResultSet rs  = pstmt.executeQuery();
            return new Sueldo(Integer.parseInt(rs.getString("valor")), Integer.parseInt(rs.getString("descuentos")));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return new Sueldo(0,0);
    }

    public boolean addOne(Empleado empleado, Sueldo sueldo) {
        String sql = "INSERT INTO sueldos (cedulaEmpleado, valor, descuentos ) VALUES(?)";

        try (Connection conn = Connect.connect("juanjo.db");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, empleado.getCedula());
            pstmt.setString(2, sueldo.getValor() + "");
            pstmt.setString(3, sueldo.getDescuentos() + "");
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
