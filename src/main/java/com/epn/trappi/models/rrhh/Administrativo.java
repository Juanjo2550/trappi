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
public class Administrativo extends Empleado {

    public Administrativo() {
    }

    public Administrativo(String nombres, String apellidos, String cedula, String cargo, String departamento, String cuentaBancaria, String banco, ListaRegistrosAsistencias asistencias, Sueldo sueldo, String estado, char sexo) {
        super(nombres, apellidos, cedula, cargo, departamento, cuentaBancaria, banco, asistencias, sueldo, estado, sexo);
    }
}
