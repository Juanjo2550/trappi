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
    private Estado estado;
    private Posicion posicion;
    private String matricula;
    private String tipo;
    private double kilometraje;
    private FichaTecnica fichaTecnica;
    
    public void actualizarEstado(Estado estado){
        this.estado = estado;
    }
    public void actualizarFicha(){
        
    }
    public Posicion notificarPosicion(){
        return this.posicion;
    }
}
