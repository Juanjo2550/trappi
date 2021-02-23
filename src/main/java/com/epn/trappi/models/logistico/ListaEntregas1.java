package com.epn.trappi.models.logistico;

import java.util.ArrayList;




import com.epn.trappi.models.logistico.Entrega;

public class ListaEntregas1 {
    public ArrayList<Entrega> entregas;

    public ListaEntregas1() {
        //Lista de Datos Entregas Quemadas
        entregas= new ArrayList<Entrega>();
        String [] fcids= new String [10];
        fcids [0]= "Universidad Central del Ecuador";
        fcids [1]= "Megamaxi 6 de Diciembre";
        fcids [2]= "Pontificia Universidad Católica del Ecuador";
        fcids [3]= "Plaza Grande";
        fcids [4]= "Quicentro Sur";
        //fcids [6]= "";
        //fcids [7]= "";
        //fcids [8]= "";
        //fcids [9]= "";
        
        for (int i=0; i<10; i++){
           Entrega v= new Entrega(new Posicion (fcids[i]));
           entregas.add(v);
       } 
        
    }
    
 
}