/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epn.trappi.gui.rrhh.Permisos;

import com.epn.trappi.models.rrhh.juanjo.Empleado;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Nacimiento_Hijo extends Permiso {

    public Nacimiento_Hijo(Empleado empleado, int NUMDIASPERM, String VALORPAGARPERM, String COMENTPERM, String FECHAINICIOPERM, String FECHAFINPERM, String ESTADOPERM) {
        super(empleado, NUMDIASPERM, VALORPAGARPERM, COMENTPERM, FECHAINICIOPERM, FECHAFINPERM, ESTADOPERM);
    }
    
    

    @Override
    public int calcularNumeroDias(String tipoPermiso, char sexo) {
                int numeroDias = NUMDIASPERM;
        //this.tipoPermiso = TipoPermiso;
        
         if("Nacimiento Hijo (Parto Normal)".equals(tipoPermiso) ){
             System.out.println(sexo);
             if ("M".equalsIgnoreCase(String.valueOf(sexo) )){
                 numeroDias = 10;
             }
             else if ("F".equalsIgnoreCase(String.valueOf(sexo) )){
                 numeroDias = 90;
             }
           
        }
         if("Nacimiento Multiple o Parto Cesarea)".equals(tipoPermiso)){
           if ("M".equalsIgnoreCase(String.valueOf(sexo) )){
                 numeroDias = 15;
             }
           else if("F".equalsIgnoreCase(String.valueOf(sexo) )){
                 numeroDias = 90;
             }
        }
        if("Nacimiento Prematuro".equals(tipoPermiso)){
           numeroDias = 23;
        }
        if("Nacimiento con enfermedad degenerativa".equals(tipoPermiso)){
            numeroDias = 25;
        }
        
        return numeroDias;
    }

    @Override
    public String calcularProporcionalPagar(double sueldo, int numeroDias) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
