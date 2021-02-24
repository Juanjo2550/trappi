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
public class RolPagos {
    private Fecha fecha;
    private Empleado empleado;
    private double valor;
    private int numero;

    public RolPagos() {}
    
    public RolPagos(Fecha fecha, Empleado empleado, double valor, int numero) {
        this.fecha = fecha;
        this.empleado = empleado;
        this.valor = valor;
        this.numero = numero;
    }
 
    public void mostrar() {
        //TODO Mostrar que?
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public double getValor() {
        return valor;
    }

    public int getNumero() {
        return numero;
    }
    
    
             
}
