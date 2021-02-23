/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epn.trappi.models.rrhh;

/**
 * 
 * @author Juan Jaramillo <juanjodev02 at juan.jaramillo02@epn.edu.ec>
 */
public abstract class Empleado {
    private String nombres;
    private String apellidos;
    private Integer cedula;
    private String cargo;
    private String departamento;
    private String cuentaBancaria;
    private String banco; //TODO decidir si se saca a banco como una clase
    private RegistroAsistencia asistencia;
    private Sueldo sueldo; //TODO implementar la clase Sueldo
    private String estado;
    
    public Empleado () {
        
    }

    public Empleado(String nombres, String apellidos, Integer cedula, String cargo, String departamento, String cuentaBancaria, String banco, RegistroAsistencia asistencia, Sueldo sueldo, String estado) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.cargo = cargo;
        this.departamento = departamento;
        this.cuentaBancaria = cuentaBancaria;
        this.banco = banco;
        this.asistencia = asistencia;
        this.sueldo = sueldo;
        this.estado = estado;
    }
       
    private String obtenerCargo() {
        return this.cargo;
    }
    
    private String obtenerBanco() {
        return this.banco;
    }
    
    private String obtenerCuentaBancaria() {
        return this.cuentaBancaria;
    }
    
    private Boolean registrarAsistencia () {
        //TODO considerar si se debe registrar la asistencia desde la clase Empleado
        RegistroAsistencia.registrar();
        return true;
    }
    
    private Boolean solicitarPermiso() {
        return true;
    }

    public Integer getCedula() {
        return cedula;
    }
}
