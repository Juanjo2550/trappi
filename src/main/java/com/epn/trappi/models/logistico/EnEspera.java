package com.epn.trappi.models.logistico;

import com.epn.trappi.gui.logistico.*;
import com.epn.trappi.models.logistico.Vehiculo;

public class EnEspera extends Estado{

    private static String nomestado ="En Espera"; 
     

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
        if(sufrioAccidente()){
            vehiculo.actualizarEstado(new Inhabilitado(vehiculo));
            return "El vehículo se accidentó.";
        }else{
            vehiculo.actualizarEstado(new Habilitado(vehiculo));
            return "Entrega Finalizada";
        }
    }
    
    public boolean sufrioAccidente(){
        return true;
    }
    
    @Override
    public String toString(){
        return nomestado;
    }    
}