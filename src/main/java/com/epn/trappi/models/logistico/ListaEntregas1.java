package com.epn.trappi.models.logistico;

import java.util.ArrayList;

import com.epn.trappi.models.logistico.Entrega;

public class ListaEntregas1 {
    private ArrayList<Entrega> entregas;

    public ListaEntregas1() {
        entregas= new ArrayList<Entrega>();
        String [] fcids= new String [10];
        fcids [0]= "";
        fcids [1]= "";
        fcids [2]= "";
        fcids [3]= "";
        fcids [4]= "";
        fcids [6]= "";
        fcids [7]= "";
        fcids [8]= "";
        fcids [9]= "";
        
        for (int i=0; i<10; i++){
           Entrega v= new Entrega(new Posicion (fcids[i]));
           entregas.add(v);
       } 
        
    }
    
    public void aniadirEntrega(Entrega nuevo){
        entregas.add(nuevo);
    }
}