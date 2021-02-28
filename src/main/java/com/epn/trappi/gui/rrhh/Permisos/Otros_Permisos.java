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
public class Otros_Permisos extends Permiso {
    
    public Otros_Permisos(int IDPERM, int IDEMP, int NUMDIASPERM, String VALORPAGARPERM, String COMENTPERM, String FECHAINICIOPERM,
            String FECHAFINPERM, String ESTADOPERM, String TIPOPERM) {
        super(IDPERM, IDEMP, NUMDIASPERM, VALORPAGARPERM, COMENTPERM, FECHAINICIOPERM, FECHAFINPERM, 
                ESTADOPERM, TIPOPERM);
    }


   

  /*  @Override
    public int Calcular_Numero_Dias_Permiso(String tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/
    @Override
    public void RegistrarPermiso() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
