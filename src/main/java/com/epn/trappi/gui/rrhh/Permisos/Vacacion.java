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
public class Vacacion implements Permiso{

    
    public Vacacion() {
    }
        public double proporcional;
    public Fecha fechaActual;
       public int numeroDias;
     public Fecha inicioAtividades;
    
    @Override
    public void Calcular_Afectacion_Sueldo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    @Override
    public int Calcular_Numero_Dias_Permiso(String tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
