package com.epn.trappi.models.logistico;

import com.epn.trappi.gui.logistico.*;
import com.epn.trappi.models.logistico.Vehiculo;

public class Habilitado extends Estado{
    
    private static String nomestado ="Habilitado";
    private boolean enMantenimiento= false;
    
    public Habilitado(Vehiculo vehiculo) {
        super( vehiculo);
    }
    public Habilitado(){
        
    }
    @Override
    public String cambiarEstado() {
        if(enMantenimiento){
            vehiculo.setEstado(new Inhabilitado(vehiculo));
            return "En Mantenimiento";
        }else{
            vehiculo.setEstado(new EnEspera(vehiculo));
            return "Entrega en Curso";
        }
    }

    public boolean darMantenimiento(){
        return enMantenimiento=true;
    }
    
    @Override
    public String toString(){
        return nomestado;
    }    
}