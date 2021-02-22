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
public abstract class Estado {
    
    Vehiculo vehiculo;
 

    Estado(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    //public abstract void verificarVehiculo();
    
    public abstract String enEntrega();
    public abstract String enMantenimiento();
    public abstract String enAccidente();
    public abstract String enPicoPlaca();
    
}
