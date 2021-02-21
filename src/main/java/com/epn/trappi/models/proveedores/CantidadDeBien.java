package com.epn.trappi.models.proveedores;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author franc
 */
public class CantidadDeBien {
    private Bien bien;
    private int cantidad;

    
    public CantidadDeBien(Bien bien, int cantidad) {
        this.bien = bien;
        this.cantidad = cantidad;
    }
    
    public Bien getBien() {
        return bien;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void aumentarCantidad(int cantidadAAumentar){
        cantidad-=cantidadAAumentar;
    }
    
    public void disminuirCantidad(int cantidadADisminuir){
        cantidad-=cantidadADisminuir;
    }
    
}
