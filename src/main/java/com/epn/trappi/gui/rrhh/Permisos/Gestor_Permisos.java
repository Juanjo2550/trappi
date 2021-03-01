/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.rrhh.Permisos;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

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


    public Gestor_Permisos(String CI,String nombre_empleado,String TipoPermiso, String fechaInicio, String fechaFin,   
            String descripcion,String estado, double afectacionSueldo) {
        this.afectacionSueldo = afectacionSueldo;
        this.nombre_empleado = nombre_empleado;
        this.CI = CI;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.TipoPermiso=TipoPermiso;
        this.estado=estado;
    }

    public double getAfectacionSueldo() {
        return afectacionSueldo;
    }

    public void setAfectacionSueldo(double afectacionSueldo) {
        this.afectacionSueldo = afectacionSueldo;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public String getCI() {
        return CI;
    }

    public void setCI(String CI) {
        this.CI = CI;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getTipoPermiso() {
        return TipoPermiso;
    }

    public void setTipoPermiso(String TipoPermiso) {
        this.TipoPermiso = TipoPermiso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void calcular_Afectacion_Permiso(){
        
    }
    public void aprobar_Permiso(){
        
    } 
    public boolean registrar_Permiso(){
     /*
        String sql = "INSERT INTO permiso (cedula,nombre,Tipo_Permiso,fecha_inicio,fecha_fin,estado,descripcion,afectacion_sueldo)" 
                + "VALUES(?,?,?,?,?,?,?,?);";
        
        try (Connection conn = Conexion_SQLite_Permisos.connect("permisos.db");
             PreparedStatement registro = conn.prepareStatement(sql)) {
            registro.setString(1, CI);
            registro.setString(2, nombre_empleado);
            registro.setString(3, TipoPermiso);
            registro.setString(4, fechaInicio);
            registro.setString(5, fechaFin);
            registro.setString(6, estado);
            registro.setString(7, descripcion);
            registro.setDouble(8, afectacionSueldo);
            registro.executeUpdate();
            JOptionPane.showMessageDialog(null, "El permiso se ha registrado con exito");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Algo ha fallado, intenta de nuevo");
            return false;
        }
        catch (java.lang.NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"Ingrese todos los campos");
            return false;
        }
        
        return true;
        */return false;
     /*
        String sql = "INSERT INTO permiso (cedula,nombre,Tipo_Permiso,fecha_inicio,fecha_fin,estado,descripcion,afectacion_sueldo)" 
                + "VALUES(?,?,?,?,?,?,?,?);";
        
        try (Connection conn = Conexion_SQLite_Permisos.connect("permisos.db");
             PreparedStatement registro = conn.prepareStatement(sql)) {
            registro.setString(1, CI);
            registro.setString(2, nombre_empleado);
            registro.setString(3, TipoPermiso);
            registro.setString(4, fechaInicio);
            registro.setString(5, fechaFin);
            registro.setString(6, estado);
            registro.setString(7, descripcion);
            registro.setDouble(8, afectacionSueldo);
            registro.executeUpdate();
            JOptionPane.showMessageDialog(null, "El permiso se ha registrado con exito");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Algo ha fallado, intenta de nuevo");
            return false;
        }
        catch (java.lang.NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"Ingrese todos los campos");
            return false;
        }
        
        return true;
        */    
    }
        
    
}
