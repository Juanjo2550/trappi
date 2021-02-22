/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.rrhh.Permisos;

import com.epn.trappi.models.rrhh.Fecha;

/**
 *
 * @author stali
 */
public class Calamidad_Domestica implements Permiso{

    public Calamidad_Domestica() {
    }
    public double proporcional;
    public Fecha fechaInicio;
       public int numeroDias;
    public Fecha fechaFin;

    @Override
    public void Calcular_Afectacion_Sueldo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Calcular_Numero_Dias_Permiso() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
