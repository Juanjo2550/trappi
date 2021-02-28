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
public class Conductor extends Empleado {

    public Conductor(String nombres, String apellidos, String cedula, String cargo, String departamento, String cuentaBancaria, String banco, Asistencia[] asistencias, String sueldo, String estado, char sexo) {
        super(nombres, apellidos, cedula, cargo, departamento, cuentaBancaria, banco, asistencias, sueldo, estado, sexo);
    }

    @Override
    public void notificarEntrada() {

    }

    @Override
    public void notificarSalida() {

    }
}
