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
    public ArrayList<Vehiculo> vehiculos;
    
    public ListaVehiculos(){
        vehiculos = new ArrayList<Vehiculo>();
       for (int i=0; i<5; i++){
           Vehiculo v= new Vehiculo(123+i);
           vehiculos.add(v);
       } 
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    
    public void agregarVehiculo(Vehiculo vehiculo){
        vehiculos.add(vehiculo);
    }
    public void eliminarVehiculo(Vehiculo vehiculo){
        
    }
}
