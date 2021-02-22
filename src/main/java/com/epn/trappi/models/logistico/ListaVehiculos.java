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
public class ListaVehiculos {
    private ArrayList<Vehiculo> vehiculos;
    
    public void agregarVehiculo(Vehiculo vehiculo){
        vehiculos.add(vehiculo);
    }
    public void eliminarVehiculo(Vehiculo vehiculo){
        
    }
}
