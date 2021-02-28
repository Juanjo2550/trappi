/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.rrhh.diego;

import com.epn.trappi.models.rrhh.Fecha;
import com.epn.trappi.models.rrhh.juanjo.Empleado;

/**
 *
 * @author diego
 */
public class SolicitudDePago {

    Fecha fechaSolicitud;
    String estado;
    Empleado empleadoAPagar;

    public void autorizarSolicitud(String estado) {
        if(this.estado.equalsIgnoreCase(estado)){
            System.out.print("Pendiente");
        }
    }

    public void solicitarPago(String cedula, String cuenta) {

    }

    public Fecha getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Fecha fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
