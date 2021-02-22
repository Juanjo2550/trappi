package com.epn.trappi.models.logistico;

public class Entrega {
    private boolean estado;
    private Posicion destino;

    public Entrega() {
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Posicion getDestino() {
        return destino;
    }

    public void setDestino(Posicion destino) {
        this.destino = destino;
    }
    
    public void actualizarEstado(){
        
    }
    
    public void confirmarEntrega(){
        
    }
}