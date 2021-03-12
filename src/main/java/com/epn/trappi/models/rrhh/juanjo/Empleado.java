/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epn.trappi.models.rrhh.juanjo;



/**
 * 
 * @author Juan Jaramillo <juanjodev02 at juan.jaramillo02@epn.edu.ec>
 */
public abstract class Empleado {
    private final int id;
    private final String nombres;
    private final String apellidos;
    private final String cedula;
    private final String cargo;
    private final String departamento;
    private final String cuentaBancaria;
    private final String banco;
    private final String sueldo;
    private final String estado;
    private final char sexo;
    private final ControlAsistencias controlAsistencias;

    public Empleado(int id, String nombres, String apellidos, String cedula, String cargo, String departamento, String cuentaBancaria, String banco, String sueldo, String estado, char sexo) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.cargo = cargo;
        this.departamento = departamento;
        this.cuentaBancaria = cuentaBancaria;
        this.banco = banco;
        this.sueldo = sueldo;
        this.estado = estado;
        this.sexo = sexo;
        this.controlAsistencias = new ControlAsistencias();
    }

    public abstract void notificarEntrada();
    public abstract void notificarSalida();
    public abstract void guardar();
    public void SolicitarPermiso() {}

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCedula() {
        return cedula;
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

    public String getSueldo() {
        return sueldo;
    }

    public String getEstado() {
        return estado;
    }

    public char getSexo() {
        return sexo;
    }

    public int getId() {
        return id;
    }

    public ControlAsistencias getControlAsistencias() {
        return controlAsistencias;
    }
}
