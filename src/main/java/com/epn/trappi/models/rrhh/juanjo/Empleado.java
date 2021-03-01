/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epn.trappi.models.rrhh.juanjo;

import com.epn.trappi.models.rrhh.Sueldo;

/**
 * 
 * @author Juan Jaramillo <juanjodev02 at juan.jaramillo02@epn.edu.ec>
 */
public abstract class Empleado {
    private int id;
    private String nombres;
    private String apellidos;
    private String cedula;
    private String cargo;
    private String departamento;
    private String cuentaBancaria;
    private String banco;
    private String sueldo;
    private String estado;
    private char sexo;

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
    }

    public abstract void notificarEntrada();
    public abstract void notificarSalida();
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
}
