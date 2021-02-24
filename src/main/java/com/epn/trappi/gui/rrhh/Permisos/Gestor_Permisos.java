/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.rrhh.Permisos;

import com.epn.trappi.db.rrhh.Conexion_SQLite_Permisos;
import com.epn.trappi.models.rrhh.Empleado;
import com.epn.trappi.models.rrhh.Fecha;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author stali
 */
public class Gestor_Permisos {
    public double afectacionSueldo;
    public String nombre_empleado;
    public String CI;
    public String descripcion;
    public String fechaInicio;
   public String fechaFin;
   public String TipoPermiso;
   public String estado;

    public Gestor_Permisos(double afectacionSueldo, String nombre_empleado, String CI, 
            String descripcion, String fechaInicio, String fechaFin,String TipoPermiso,String estado) {
        this.afectacionSueldo = afectacionSueldo;
        this.nombre_empleado = nombre_empleado;
        this.CI = CI;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.TipoPermiso=TipoPermiso;
        this.estado=estado;
    }

 
    

   
    public void calcular_Afectacion_Permiso(){
        
    }
    public void aprobar_Permiso(){
        
    } 
    public boolean registrar_Permiso(){
     
        String sql = "INSERT INTO permiso (cedula, nombre, Tipo_Permiso,fecha_inicio,fecha_fin,"
                + "estado, descripcion, afectacion_sueldo) VALUES(?)";

        try (Connection conn = Conexion_SQLite_Permisos.connect("permisos.db");
             PreparedStatement registro = conn.prepareStatement(sql)) {
            registro.setInt(1, Integer.parseInt(CI));
            registro.setString(2, nombre_empleado);
            registro.setString(3, TipoPermiso);
            registro.setString(4, fechaInicio);
            registro.setString(5, fechaFin);
            registro.setString(6, estado);
            registro.setString(7, descripcion);
            registro.setDouble(8, afectacionSueldo);
            registro.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
        
    }
        
    
}
