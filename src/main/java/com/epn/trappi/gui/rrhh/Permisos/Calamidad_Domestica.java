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
public class Calamidad_Domestica extends Permiso{

   
    public Calamidad_Domestica(int IDPERM, int IDEMP, int NUMDIASPERM, String VALORPAGARPERM, String COMENTPERM, String FECHAINICIOPERM,
            String FECHAFINPERM, String ESTADOPERM, String TIPOPERM) {
        super(IDPERM, IDEMP, NUMDIASPERM, VALORPAGARPERM, COMENTPERM, FECHAINICIOPERM, FECHAFINPERM, 
                ESTADOPERM, TIPOPERM);
    }

    public void Calcular_Afectacion_Sueldo() {
       
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

    @Override
    public void RegistrarPermiso() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
   
    
}
