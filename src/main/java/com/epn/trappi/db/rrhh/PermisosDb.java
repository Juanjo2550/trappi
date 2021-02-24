/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.db.rrhh;

import com.epn.trappi.gui.rrhh.Gestor_Permiso;
import com.epn.trappi.gui.rrhh.Permisos.Lista_Permisos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author stali
 */
public class PermisosDb {
    
    public Lista_Permisos selectAll(){
        String sql = "SELECT * FROM permiso";
        Lista_Permisos permiso_registrados = new Lista_Permisos();
        try {
            Connection conn = Conexion_SQLite_Permisos.connect("permisos.db");
            Statement stmt  = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            // loop through the result set
            while (rs.next()) {
                permiso_registrados.agregar(new Gestor_Permiso(
                rs.getInt("cedula"),
                rs.getString("nombre"),
                rs.getString("Tipo_Permiso"),
                rs.getString("fecha_inicio"),
                rs.getString("fecha_fin"),
                rs.getString("estado"),
                rs.getString("descripcion"),
                rs.getDouble("afectacion_sueldo") 
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return permiso_registrados;
    }
}

