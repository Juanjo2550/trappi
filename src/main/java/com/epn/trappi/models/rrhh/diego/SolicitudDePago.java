/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.rrhh.diego;

import com.epn.trappi.models.rrhh.Fecha;
import com.epn.trappi.models.rrhh.juanjo.Empleado;
import com.epn.trappi.models.rrhh.juanjo.RolDePagos;

/**
 *
 * @author diego
 */
public class SolicitudDePago {

    Fecha fechaSolicitud;
    String estado;
    Empleado empleadoAPagar;
    RolDePagos rol;
    double montoTotal;
    public boolean autorizarSolicitud(SolicitudDePago a, boolean autoriza) {
        if(autoriza == true){
            this.estado = "Autorizado";
            System.out.print("Psgo autorizado");
            return true;
        }
        else{
            this.estado = "Rechazado";
            System.out.print("No se autorizo el pago");
            return false;
        }
    }
        //esto es comentado para solucionar los errores 
    /*public void solicitarPago(Pago nuevoPago, SolicitudDePago p, boolean autoriza) {
        if(autorizarSolicitud(p,autoriza)){
            
            nuevoPago=new Pago(this.empleadoAPagar.getCuentaBancaria(),this.rol.getTotal());
            nuevoPago.realizarPago();
        }

    }*/

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
