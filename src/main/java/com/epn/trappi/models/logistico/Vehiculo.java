/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.logistico;

/**
 *
 * @author Erick
 */
public class Vehiculo {
    private Habilitado estado;
    private Posicion posicion;
    private int matricula;
    private String tipo;
    private double kilometraje;
    private FichaTecnica fichaTecnica;
    
    public Vehiculo(Habilitado estado, int matricula){
        estado.setEstado(true);
        this.matricula = matricula;
    }

    public int getMatricula() {
        return matricula;
    }
    
    
    
    public void actualizarEstado(Habilitado estado){
        this.estado = estado;
    }
    public void actualizarFicha(){
        
    }
    public Posicion notificarPosicion(){
        return this.posicion;
    }
}
