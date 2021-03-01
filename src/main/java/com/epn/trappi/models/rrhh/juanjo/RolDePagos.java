/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epn.trappi.models.rrhh.juanjo;
import com.epn.trappi.models.rrhh.Fecha;
import com.epn.trappi.models.rrhh.contratacion.Contrato;

/**
 * 
 * @author Juan Jaramillo <juanjodev02 at juan.jaramillo02@epn.edu.ec>
 */
public class RolDePagos {
    private int numero;
    private Fecha fecha;
    private Contrato contrato;
    private double total;
    private double descuentos;
    private String estado;

    public RolDePagos(int numero, Fecha fecha, Contrato contrato, double total, double descuentos, String estado) {
        this.numero = numero;
        this.fecha = fecha;
        this.contrato = contrato;
        this.total = total;
        this.descuentos = descuentos;
        this.estado = estado;
    }

    private void calcularTotal() {

    }

    private void obtenerObservaciones () {

    }
}
