package com.epn.trappi.models.logistico;

import com.epn.trappi.gui.logistico.*;
import com.epn.trappi.models.logistico.Vehiculo;

public class Habilitado extends Estado{
    
    private static String nomestado ="Habilitado"; 
    
    public Habilitado(Vehiculo vehiculo) {
        super( vehiculo);
    }
    public Habilitado(){
        
    }
    @Override
    public String cambiarEstado() {
        if(darMantenimiento()){
            vehiculo.actualizarEstado(new Inhabilitado(vehiculo));
            return "En Mantenimiento";
        }else{
            vehiculo.actualizarEstado(new EnEspera(vehiculo));
            return "Entrega en Curso";
        }
    }

    public boolean darMantenimiento(){
        return true;
    }
    
    @Override
    public String toString(){
        return nomestado;
    }    
}