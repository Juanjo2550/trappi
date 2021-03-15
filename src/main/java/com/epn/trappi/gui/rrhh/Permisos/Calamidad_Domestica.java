/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.rrhh.Permisos;

import com.epn.trappi.db.rrhh.Permiso_EmpleadoDb;
import com.epn.trappi.models.rrhh.Fecha;

import com.epn.trappi.models.rrhh.juanjo.Empleado;

/**
 *
 * @author stali
 */
public class Calamidad_Domestica extends Permiso{

    public Calamidad_Domestica(Empleado empleado, int NUMDIASPERM, String VALORPAGARPERM, String COMENTPERM,
            String FECHAINICIOPERM, String FECHAFINPERM, String ESTADOPERM) {
        super(empleado, NUMDIASPERM, VALORPAGARPERM, COMENTPERM, FECHAINICIOPERM, FECHAFINPERM, ESTADOPERM);
    }

    public Calamidad_Domestica(int NUMDIASPERM, String VALORPAGARPERM, String FECHAINICIOPERM, String FECHAFINPERM) {
        super(NUMDIASPERM, VALORPAGARPERM, FECHAINICIOPERM, FECHAFINPERM);
    }


 

    public Calamidad_Domestica() {
    }



    @Override
    public int calcularNumeroDias(String tipoPermiso, char sexo) {
        
        int numeroDias = NUMDIASPERM;
        //this.tipoPermiso = TipoPermiso;
        
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
    public String calcularProporcionalPagar(double sueldo, int numeroDias) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registrar() {
        new Permiso_EmpleadoDb().agregar(this);
    }


        
    }


  
   
    

