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
public class Inventario {

    private ListaCantidadDeBienes listaCantidadDeBienes;

    public ListaCantidadDeBienes getListaCantidadDeBienes() {
        return listaCantidadDeBienes;
    }

    public void setListaCantidadDeBienes(ListaCantidadDeBienes listaDeBienes) {
        this.listaCantidadDeBienes = listaDeBienes;
    }

    public Inventario(ListaCantidadDeBienes listaDeBienes) {
        this.listaCantidadDeBienes = listaDeBienes;
    }

    public boolean verificarStock() {
        return false;
    }

    public void aumentarStock() {
    }

    public void disminuirStock() {

    }
}
