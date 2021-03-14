package com.epn.trappi.models.logistico;

import com.epn.trappi.gui.logistico.*;
import com.epn.trappi.models.logistico.Vehiculo;

public class EnEspera extends Estado{

    private static String nomestado ="En Espera";
    private boolean accidentado=false;
     

    public EnEspera(Vehiculo vehiculo) {
        super(vehiculo);
    }
    
    public EnEspera(String estado){
        super(estado);
    }
    
    public EnEspera(){
        
    }
    
    @Override
    public String cambiarEstado() {
        //Si llamamos a este metodo es porque finalizo la entrega
        if(accidentado){
            vehiculo.setEstado(new Inhabilitado(vehiculo));
            return "El vehículo se accidentó.";
        }else{
            vehiculo.setEstado(new Habilitado(vehiculo));
            return "Entrega Finalizada";
        }
    }
    
    public boolean sufrioAccidente(){
        return accidentado = true;
    }
    
    @Override
    public String toString(){
        return nomestado;
    }    
}