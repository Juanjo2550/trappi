/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epn.trappi.gui.rrhh.Permisos;

import com.epn.trappi.models.rrhh.juanjo.*;
import com.epn.trappi.models.rrhh.Sueldo;

/**
 * 
 * @author Juan Jaramillo <juanjodev02 at juan.jaramillo02@epn.edu.ec>
 */
public abstract class Permiso {
   private int IDPERM;
 //  private int IDEMP;
   private int NUMDIASPERM;
   private String VALORPAGARPERM;
   private String COMENTPERM;
   private String FECHAINICIOPERM;
   private String FECHAFINPERM;
   private String ESTADOPERM;
   
   private Empleado empleado;

    public Permiso(Empleado empleado, int NUMDIASPERM, String VALORPAGARPERM, String COMENTPERM, String FECHAINICIOPERM, String FECHAFINPERM, String ESTADOPERM) {
        this.NUMDIASPERM = NUMDIASPERM;
        this.VALORPAGARPERM = VALORPAGARPERM;
        this.COMENTPERM = COMENTPERM;
        this.FECHAINICIOPERM = FECHAINICIOPERM;
        this.FECHAFINPERM = FECHAFINPERM;
        this.ESTADOPERM = ESTADOPERM;
        this.empleado = empleado;
    }



    


    public abstract void RegistrarPermiso();

    public int getIDPERM() {
        return IDPERM;
    }
    public Empleado getEmpleado() {
        return empleado;
    }


    public int getNUMDIASPERM() {
        return NUMDIASPERM;
    }

    public String getVALORPAGARPERM() {
        return VALORPAGARPERM;
    }

    public String getCOMENTPERM() {
        return COMENTPERM;
    }

    public String getFECHAINICIOPERM() {
        return FECHAINICIOPERM;
    }

    public String getFECHAFINPERM() {
        return FECHAFINPERM;
    }

    public String getESTADOPERM() {
        return ESTADOPERM;
    }


}
