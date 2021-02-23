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
public class Sueldo {
    private double valor;
    private double descuentos;

    public double getValor() {
        return valor;
    }

    public double getDescuentos() {
        return descuentos;
    }

    public Sueldo(double valor, double descuentos) {
        this.valor = valor;
        this.descuentos = descuentos;
    }
    
    public double calcularValor() {
        return valor;
    }
}
