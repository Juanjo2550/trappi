/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.rrhh;

/**
 *
 * @author diego
 */
public class RegistroAsistencia {
   private Hora horaInicio;
   private Hora horaSalida;
   private Fecha fecha;

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public void setHoraInicio(Hora horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraSalida(Hora horaSalida) {
        this.horaSalida = horaSalida;
    }
   
   public RegistroAsistencia registrar(){
       RegistroAsistencia nuevo = new RegistroAsistencia();
       return nuevo;
   }
}
