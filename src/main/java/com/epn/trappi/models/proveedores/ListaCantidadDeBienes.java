package com.epn.trappi.models.proveedores;

import com.epn.trappi.db.proveedores.ProveedoresDb;
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

    private ArrayList<CantidadDeBien> listaCantidadDeBienes;
    private ProveedoresDb db = new ProveedoresDb();

    public ListaCantidadDeBienes(){
        listaCantidadDeBienes= new ArrayList<CantidadDeBien>();
    }
    
    public ArrayList<CantidadDeBien> getListaCantidadDeBienes() {
        return listaCantidadDeBienes;
    }

    public ArrayList<CantidadDeBien> getListaCantidadDeBienesDb() {
        return db.getListaCantidadBienes();
    }

    public void setListaCantidadDeBienes(ArrayList<CantidadDeBien> listaCantidadDeBienes) {
        this.listaCantidadDeBienes = listaCantidadDeBienes;
    }

    //recibimos el bien y la cantidad y se hace el objeto CantidadDeBien
    public void añadirBien(Bien bien, int cantidadDelNuevoBien) {
        CantidadDeBien nuevoBien = new CantidadDeBien(bien, cantidadDelNuevoBien);
        listaCantidadDeBienes.add(nuevoBien);
    }

    //tomo un objeto cantidad de bien, es decir debe ingresarse 
    public void quitarBien(Bien bienARetirar) {
        for (CantidadDeBien cantidadBien : listaCantidadDeBienes) {
            if (cantidadBien.getBien() == bienARetirar) {
                listaCantidadDeBienes.remove(cantidadBien);
            }
        }
    }

}
