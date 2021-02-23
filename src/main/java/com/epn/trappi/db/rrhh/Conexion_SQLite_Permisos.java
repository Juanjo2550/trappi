/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.db.rrhh;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author stali
 */
public class Conexion_SQLite_Permisos {
    public static Connection connect() {
            Connection conn = null;
            try {
                if(conn == null) {
                    String projectPath = System.getProperty("user.dir");
                    // db parameters
                    String direccion = "jdbc:sqlite:" + projectPath + "/src/main/java/com/epn/trappi/db/rrhh/permisos.db";
                    //crear la conexion a la base de datos
                    conn = DriverManager.getConnection(direccion);
                    System.out.println("La conexión se ha establecido con exito.");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return conn;
    }
}
