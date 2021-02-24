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
public class Empleado {
    private String nombres;
    private String apellidos;
    private String cedula;
    private String cargo;
    private String departamento;
    private String cuentaBancaria;
    private String banco; //TODO decidir si se saca a banco como una clase
    private ListaRegistrosAsistencias asistencias; //TODO: Preguntar si esto está bien
    private Sueldo sueldo; //TODO implementar la clase Sueldo
    private String estado;
    private char sexo;
    
    public Empleado () {
        
    }

    public Empleado(String nombres, String apellidos, String cedula, String cargo, String departamento, String cuentaBancaria, String banco, ListaRegistrosAsistencias asistencias, Sueldo sueldo, String estado, char sexo) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.cargo = cargo;
        this.departamento = departamento;
        this.cuentaBancaria = cuentaBancaria;
        this.banco = banco;
        this.asistencias = asistencias;
        this.sueldo = sueldo;
        this.estado = estado;
        this.sexo = sexo;
    }
    
    public Empleado(String nombres, String apellidos, String cedula, String cargo, String departamento, String cuentaBancaria, String banco, Sueldo sueldo, String estado, char sexo) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.cargo = cargo;
        this.departamento = departamento;
        this.cuentaBancaria = cuentaBancaria;
        this.banco = banco;
        this.asistencias = asistencias;
        this.sueldo = sueldo;
        this.estado = estado;
        this.sexo = sexo;
    }
    
    private Boolean registrarAsistencia () {
        //TODO considerar si se debe registrar la asistencia desde la clase Empleado
        RegistroAsistencia.registrar();
        return true;
    }
    
    private Boolean solicitarPermiso() {
        return true;
    }

    public String getCedula() {
        return this.cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCargo() {
        return cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getCuentaBancaria() {
        return cuentaBancaria;
    }

    public String getBanco() {
        return banco;
    }

    public ListaRegistrosAsistencias getAsistencias() {
        return asistencias;
    }

    public Sueldo getSueldo() {
        return sueldo;
    }

    public String getEstado() {
        return estado;
    }

    public char getSexo() {
        return sexo;
    }
}
