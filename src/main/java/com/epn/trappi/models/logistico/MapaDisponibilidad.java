/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.logistico;

import java.util.ArrayList;

/**
 *
 * @author Erick
 */
public class MapaDisponibilidad {
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Conductor> conductores;

    public MapaDisponibilidad(ArrayList<Vehiculo> vehiculos, ArrayList<Conductor> conductores) {
        this.vehiculos = vehiculos;
        this.conductores = conductores;
    }
      
    public void actualizarMapaDisponibilidad(){
        
    }
    public void emparejar(){
    
    }
}