/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.rrhh.Permisos;

import com.epn.trappi.models.rrhh.Fecha;
import com.epn.trappi.gui.rrhh.Gestor_Permiso;
import com.epn.trappi.models.rrhh.juanjo.Empleado;

/**
 *
 * @author stali
 */
public class Calamidad_Domestica extends Permiso{

    public Calamidad_Domestica(Empleado empleado, int NUMDIASPERM, String VALORPAGARPERM, String COMENTPERM, String FECHAINICIOPERM, String FECHAFINPERM, String ESTADOPERM) {
        super(empleado, NUMDIASPERM, VALORPAGARPERM, COMENTPERM, FECHAINICIOPERM, FECHAFINPERM, ESTADOPERM);
    }


 /*    
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
*/

    public Calamidad_Domestica() {
    }



    @Override
    public int calcularNumeroDias(String tipoPermiso, char sexo) {
        
        int numeroDias = NUMDIASPERM;
        //this.tipoPermiso = TipoPermiso;
        
         if("Nacimiento Hijo (Parto Normal)".equals(tipoPermiso)){
             if ("M".equals(sexo)){
                 numeroDias = 10;
             }
             else{
                 numeroDias = 90;
             }
           
        }
         if("Nacimiento Hijo (Parto Cesarea)".equals(tipoPermiso)){
           if ("M".equals(sexo)){
                 numeroDias = 15;
             }
             else{
                 numeroDias = 90;
             }
        }
        if("muerte de padres, hermanos, hijos, cónyuge".equals(tipoPermiso)){
           numeroDias = 3;
        }
        if("muerte de nietos, padres del cónyuge o hermanos de la pareja".equals(tipoPermiso)){
            numeroDias = 2;
        }
        if("enfermedad de hijos o conyuge".equals(tipoPermiso)){
            numeroDias =8;
        }
        if("enfermedad de padres o hermanos".equals(tipoPermiso)){
            numeroDias = 2;
        }
        return numeroDias;
    }

    @Override
    public double calcularProporcionalPagar(double sueldo, int numeroDias) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

        
    }


  
   
    

