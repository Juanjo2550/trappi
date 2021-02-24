
package com.epn.trappi.models.logistico;

public class Vehiculo {
    private Estado estado;
    private Gps gps;
    private int matricula;
    private String tipo;
    private double kilometraje;
    private FichaTecnica fichaTecnica;
    
    public Vehiculo(int matricula){
        estado= new Habilitado(this);
        this.matricula = matricula;
    }

    public int getMatricula() {
        return matricula;
    }
    
    
    
    public void actualizarEstado(Estado estado){
        this.estado = estado;
    }
    public void actualizarFicha(){
        
    }
    public Posicion notificarPosicion(){
        return this.gps.posicion;
    }
    
    public boolean entregando(){
        return true;
    }
    
}
