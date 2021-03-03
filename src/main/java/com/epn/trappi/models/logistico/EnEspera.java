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
public class EnEspera extends Estado{

    //private boolean estado; 
    private static String nomestado ="En Espera"; 

    public EnEspera(Vehiculo vehiculo) {
        super(vehiculo);
    }
    public EnEspera(String estado){
        super(estado);
    }

    @Override
    public String enEntrega() {
        //Si llamamos a este metodo es porque finalizo la entrega
        vehiculo.actualizarEstado(new Habilitado(vehiculo));
        return "Entrega Finalizada";
    }
    
    @Override
    public String enMantenimiento() {
        //Si llamamos a este metodo es porque finalizo el mantenimiento
        vehiculo.actualizarEstado(new Habilitado(vehiculo));
        return "Se mando a Mantenimeinto";
    }

    @Override
    public String enAccidente() {
        //Si llamamos a este metodo es porque finalizo el mantenimiento
        vehiculo.actualizarEstado(new Inhabilitado(vehiculo));
        return "Tuvo un Accidente";
    }

    @Override
    public String enPicoPlaca() {
        return null;
    }
    @Override
    public String toString(){
        return super.estado;
    }
    
    
    
    
    
}
