/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epn.trappi.db.rrhh;

import com.epn.trappi.models.rrhh.Fecha;
import com.epn.trappi.models.rrhh.juanjo.RolDePagos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * 
 * @author Juan Jaramillo <juanjodev02 at juan.jaramillo02@epn.edu.ec>
 */
public class RolPagosDb {

    public ArrayList<RolDePagos> selectAll() {
        String sql = "SELECT * FROM rolpagos";
        ArrayList<RolDePagos> tempRoles = new ArrayList<RolDePagos>();
        try {
            Connection conn;
            conn = Connect.connect("juanjo.db");
            Statement stmt  = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                tempRoles.add(new RolDePagos(
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
      
    public RolDePagos getOne (String cedulaEmpleado) {
        String sql = "SELECT * FROM rolpagos WHERE cedula = ?";
        try{
            Connection conn;
            conn = Connect.connect("juanjo.db");
            PreparedStatement pstmt  = conn.prepareStatement(sql);
            pstmt.setString(1, cedulaEmpleado);
            ResultSet rs = pstmt.executeQuery();
            return new RolDePagos(
                        new Fecha(Integer.parseInt(rs.getString("dia")), Integer.parseInt(rs.getString("mes")), Integer.parseInt(rs.getString("ano"))),
                        new EmpleadoDb().selectOne(rs.getString("cedula")),
                        Integer.parseInt(rs.getString("valor")),
                        rs.getInt("numero")
                );
            
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return new RolDePagos();
    }
    
    
    public ArrayList<RolDePagos> getByCedula (String cedulaEmpleado) {
        String sql = "SELECT * FROM rolpagos WHERE cedula = ?";
        ArrayList<RolDePagos> tempRoles = new ArrayList<RolDePagos>();
        try{
            Connection conn;
            conn = Connect.connect("juanjo.db");
            PreparedStatement pstmt  = conn.prepareStatement(sql);
            pstmt.setString(1, cedulaEmpleado);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                tempRoles.add(new RolDePagos(
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
    
    public boolean addOne(RolDePagos nuevoRolDePago) {
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
