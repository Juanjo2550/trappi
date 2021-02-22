/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.logistico;

import com.epn.trappi.gui.logistico.*;

/**
 *
 * @author cristhian.munoz
 */
public class Habilitado implements Estado{
    
    private boolean estado; 
    private static String nomestado ="Habilitado"; 

    @Override
    public void  verificarVehiculo() {
        
        
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public static String getNomestado() {
        return nomestado;
    }
    
    
    
    
}
