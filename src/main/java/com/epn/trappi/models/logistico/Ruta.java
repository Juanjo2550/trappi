package com.epn.trappi.models.logistico;

public class Ruta {
    private double distancia;
    private double tiempoAproximado;

    public Ruta() {
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getTiempoAproximado() {
        return tiempoAproximado;
    }

    public void setTiempoAproximado(double tiempoAproximado) {
        this.tiempoAproximado = tiempoAproximado;
    }
    
    public void trazarRuta(Posicion posicion){
        
    }
}