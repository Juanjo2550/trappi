/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epn.trappi.db.rrhh;

import com.epn.trappi.models.rrhh.Empleado;
import com.epn.trappi.models.rrhh.Fecha;
import com.epn.trappi.models.rrhh.RolPagos;
import com.epn.trappi.models.rrhh.RolesPagos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 
 * @author Juan Jaramillo <juanjodev02 at juan.jaramillo02@epn.edu.ec>
 */
public class RolPagosDb {

    public ArrayList<RolPagos> selectAll() {
        String sql = "SELECT * FROM rolpagos";
        ArrayList<RolPagos> tempRoles = new ArrayList<RolPagos>();
        try {
            Connection conn;
            conn = Connect.connect("juanjo.db");
            Statement stmt  = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                tempRoles.add(new RolPagos(
                        new Fecha(Integer.parseInt(rs.getString("dia")), Integer.parseInt(rs.getString("mes")), Integer.parseInt(rs.getString("ano"))),
                        new EmpleadoDb().selectOne(rs.getString("cedula")),
                        Integer.parseInt(rs.getString("valor")),
                        rs.getInt("numero")
                ));
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tempRoles;
    }
      
    public RolPagos getOne (String cedulaEmpleado) {
        String sql = "SELECT * FROM rolpagos WHERE cedula = ?";
        try{
            Connection conn;
            conn = Connect.connect("juanjo.db");
            PreparedStatement pstmt  = conn.prepareStatement(sql);
            pstmt.setString(1, cedulaEmpleado);
            ResultSet rs = pstmt.executeQuery();
            return new RolPagos(
                        new Fecha(Integer.parseInt(rs.getString("dia")), Integer.parseInt(rs.getString("mes")), Integer.parseInt(rs.getString("ano"))),
                        new EmpleadoDb().selectOne(rs.getString("cedula")),
                        Integer.parseInt(rs.getString("valor")),
                        rs.getInt("numero")
                );
            
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return new RolPagos();
    }
    
    
    public ArrayList<RolPagos> getByCedula (String cedulaEmpleado) {
        String sql = "SELECT * FROM rolpagos WHERE cedula = ?";
        ArrayList<RolPagos> tempRoles = new ArrayList<RolPagos>();
        try{
            Connection conn;
            conn = Connect.connect("juanjo.db");
            PreparedStatement pstmt  = conn.prepareStatement(sql);
            pstmt.setString(1, cedulaEmpleado);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                tempRoles.add(new RolPagos(
                            new Fecha(Integer.parseInt(rs.getString("dia")), Integer.parseInt(rs.getString("mes")), Integer.parseInt(rs.getString("ano"))),
                            new EmpleadoDb().selectOne(rs.getString("cedula")),
                            Integer.parseInt(rs.getString("valor")),
                            rs.getInt("numero")
                    ));
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return tempRoles;
    }
    
    public boolean addOne(RolPagos nuevoRolDePago) {
        String sql = "INSERT INTO rolpagos(cedula,valor, numero, dia, mes, ano) VALUES(?,?,?,?,?,?)";
        try (Connection conn = Connect.connect("juanjo.db");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nuevoRolDePago.getEmpleado().getCedula());
            pstmt.setString(2, nuevoRolDePago.getValor() + "");
            pstmt.setInt(3, nuevoRolDePago.getNumero());
            pstmt.setString(4, nuevoRolDePago.getFecha().getDia() + "");
            pstmt.setString(5, nuevoRolDePago.getFecha().getMes() + "");
            pstmt.setString(6, nuevoRolDePago.getFecha().getAño()+ "");
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
}