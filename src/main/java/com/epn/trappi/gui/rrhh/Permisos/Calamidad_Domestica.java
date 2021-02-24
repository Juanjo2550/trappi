/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.rrhh.Permisos;

import com.epn.trappi.models.rrhh.Fecha;
import com.epn.trappi.gui.rrhh.Gestor_Permiso;

/**
 *
 * @author stali
 */
public class Calamidad_Domestica implements Permiso{

    public Calamidad_Domestica() {
    }
   
    public Fecha fechaInicio;
       public int numeroDias;
    public Fecha fechaFin;
    public String tipoPermiso;

    public Fecha getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Fecha fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public int getNumeroDias() {
        return numeroDias;
    }

    public void setNumeroDias(int numeroDias) {
        this.numeroDias = numeroDias;
    }

    public Fecha getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Fecha fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getTipoPermiso() {
        return tipoPermiso;
    }

    public void setTipoPermiso(String tipoPermiso) {
        this.tipoPermiso = tipoPermiso;
    }
    

    

    public void Calcular_Afectacion_Sueldo() {
       
    }

     
    public int Calcular_Numero_Dias_Permiso(String TipoPermiso) {
        this.tipoPermiso = TipoPermiso;
        if("muerte de padres, hermanos, hijos, cónyuge".equals(TipoPermiso)){
            this.numeroDias = 3;
        }
        if("muerte de nietos, padres del cónyuge o hermanos de la pareja".equals(TipoPermiso)){
            this.numeroDias = 2;
        }
        if("enfermedad de hijos o conyuge".equals(TipoPermiso)){
            this.numeroDias =8;
        }
        if("enfermedad de padres o hermanos".equals(TipoPermiso)){
            this.numeroDias = 2;
        }
        return this.numeroDias;
    }

  
   
    
}
