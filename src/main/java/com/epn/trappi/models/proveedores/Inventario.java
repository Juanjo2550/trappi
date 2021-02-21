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

    private ListaBienes listaDeBienes;

    public ListaBienes getListaDeBienes() {
        return listaDeBienes;
    }

    public void setListaDeBienes(ListaBienes listaDeBienes) {
        this.listaDeBienes = listaDeBienes;
    }

    public Inventario(ListaBienes listaDeBienes) {
        this.listaDeBienes = listaDeBienes;
    }

    public boolean verificarStock() {
        return false;
    }

    public void aumentarStock() {
    }

    public void disminuirStock() {

    }
}
