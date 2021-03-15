package com.epn.trappi.models.logistico;

public class Ruta {
    
    public Posicion origen;
    public Posicion destino;
    public Ruta() {
    }

    
    public void definirRuta(Posicion origen,Posicion destino){
        this.origen=origen;
        this.destino=destino;
    }
    
}