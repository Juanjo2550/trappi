/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.logistico;

import com.epn.trappi.gui.logistico.*;
import com.epn.trappi.models.logistico.Vehiculo;

/**
 *
 * @author cristhian.munoz
 */
public class Inhabilitado extends Estado{

    private boolean estado; 
    private static String nomestado ="Inhabilitado";  

    public Inhabilitado(Vehiculo vehiculo) {
        super( vehiculo);
    }
    public Inhabilitado(){
        
    }

    @Override
    public String cambiarEstado() {
        vehiculo.actualizarEstado(new Habilitado(vehiculo));
        return "Vehículo Habilitado";
    }
    
    @Override
    public String toString(){
        return nomestado;
    }
}