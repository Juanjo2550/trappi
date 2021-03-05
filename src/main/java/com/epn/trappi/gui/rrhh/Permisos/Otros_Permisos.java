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
public class Otros_Permisos extends Permiso {

    public Otros_Permisos(Empleado empleado, int NUMDIASPERM, String VALORPAGARPERM, String COMENTPERM, String FECHAINICIOPERM, String FECHAFINPERM, String ESTADOPERM) {
        super(empleado, NUMDIASPERM, VALORPAGARPERM, COMENTPERM, FECHAINICIOPERM, FECHAFINPERM, ESTADOPERM);
    }

    public Otros_Permisos() {
    }

    public Otros_Permisos(int NUMDIASPERM, String VALORPAGARPERM, String FECHAINICIOPERM, String FECHAFINPERM) {
        super(NUMDIASPERM, VALORPAGARPERM, FECHAINICIOPERM, FECHAFINPERM);
    }

    
 

   

  /*  @Override
    public int Calcular_Numero_Dias_Permiso(String tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/





    @Override
    public int calcularNumeroDias(String tipoPermiso, char sexo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String calcularProporcionalPagar(double sueldo, int numeroDias) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
