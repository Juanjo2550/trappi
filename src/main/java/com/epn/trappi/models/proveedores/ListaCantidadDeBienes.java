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
public class ListaCantidadDeBienes {

    private ArrayList<CantidadDeBien> listaCantidadDeBienes = new ArrayList<CantidadDeBien>();

    public ArrayList<CantidadDeBien> getListaCantidadDeBienes() {
        return listaCantidadDeBienes;
    }
    
    public ArrayList getlistaCantidadDeBienes(){
        return listaCantidadDeBienes;
    }
    
    public void añadirBien(Bien bien,int cantidadDelNuevoBien) {
        CantidadDeBien nuevoBien = new CantidadDeBien(bien, cantidadDelNuevoBien);
        listaCantidadDeBienes.add(nuevoBien);
    }

    //tomo un objeto cantidad de bien, es decir debe ingresarse 
    public void quitarBien(CantidadDeBien bienARetirar) {
        int indiceARetirar=listaCantidadDeBienes.indexOf(bienARetirar);
        listaCantidadDeBienes.remove(indiceARetirar);
    }
    
    
}
