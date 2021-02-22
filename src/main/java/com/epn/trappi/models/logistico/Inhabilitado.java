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
    private static String nomestado ="InHabilitado";  

    public Inhabilitado(Vehiculo vehiculo) {
        super( vehiculo);
    }

    @Override
    public String enEntrega() {
        return null;
    }
    
    @Override
    public String enMantenimiento() {
        vehiculo.actualizarEstado(new EnEspera(vehiculo));
        return "Se mando a Mantenimeinto";
    }

    @Override
    public String enAccidente() {
        return null;
    }

    @Override
    public String enPicoPlaca() {
        vehiculo.actualizarEstado(new Habilitado(vehiculo));
        return "No hay restricción Vehicular";
    }
    
    
    
    
    
    
    
}
