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
public class Habilitado extends Estado{
    
    private static String nomestado ="Habilitado"; 
    
    public Habilitado(Vehiculo vehiculo) {
        super( vehiculo);
    }
    public Habilitado(){
        
    }
    @Override
    public String enEntrega() {
        vehiculo.actualizarEstado(new EnEspera(vehiculo));
        return "En Curso";
    }
    
    @Override
    public String enMantenimiento() {
        vehiculo.actualizarEstado(new EnEspera(vehiculo));
        return "Mantenimiento";
    }

    @Override
    public String enAccidente() {
        vehiculo.actualizarEstado(new Inhabilitado(vehiculo));
        return "Ha sufrido un accidente";
    }

    @Override
    public String enPicoPlaca() {
        vehiculo.actualizarEstado(new Inhabilitado(vehiculo));
        return "Restricción Vehicular";
    }

    @Override
    public String toString(){
        return "Habilitado";
    }
    
    
}
