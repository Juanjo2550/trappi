/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.rrhh.Permisos;

import com.epn.trappi.models.rrhh.Fecha;
import com.epn.trappi.models.rrhh.juanjo.Empleado;


/**
 *
 * @author stali
 */
public class Enfermedad extends Permiso {

    public Enfermedad(Empleado empleado, int NUMDIASPERM, String VALORPAGARPERM, String COMENTPERM, String FECHAINICIOPERM, String FECHAFINPERM, String ESTADOPERM) {
        super(empleado, NUMDIASPERM, VALORPAGARPERM, COMENTPERM, FECHAINICIOPERM, FECHAFINPERM, ESTADOPERM);
    }




       
  @Override
    public void RegistrarPermiso() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



 /*   @Override
    public int Calcular_Numero_Dias_Permiso(String tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}

