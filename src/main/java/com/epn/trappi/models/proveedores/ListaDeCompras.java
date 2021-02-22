package com.epn.trappi.models.proveedores;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author franc
 */
public class ListaDeCompras {
    private ArrayList <Compra> compras;

    public ListaDeCompras(ArrayList<Compra> compras) {
        this.compras = compras;
    }

    public void comprar(Compra compra){
        compras.remove(compra);
    }
    
    public void añadirCompra(Compra compra){
        compras.add(compra);
    }
    
    public void retirarCompra(Compra compra){
        compras.remove(compra);
    }
    
    
    public ArrayList<Compra> getCompras() {
        return compras;
    }

    public void setCompras(ArrayList<Compra> compras) {
        this.compras = compras;
    }
    
}
