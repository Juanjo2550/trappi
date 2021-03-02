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
public class ListaDeBienes {

    private ArrayList<Bien> listaBienes;
    private ProveedoresDb db = new ProveedoresDb();

    public ListaDeBienes(ArrayList<Bien> listaCantidadDeBienes) {
        this.listaBienes = listaCantidadDeBienes;
    }

    
    public ListaDeBienes(){
        listaBienes= new ArrayList<Bien>();
    }
    
    public ArrayList<Bien> getListaBienes() {
        return listaBienes;
    }
    /*
    public ArrayList<Bien> getListaDeBienesDb() {
        return db.g();
    }

    public ArrayList<Bien> getListaCantidadDeBienesDbCompra() {
        return db.getListaCantidadBienesCompra();
    }
    */
    public void setListaBienes(ArrayList<Bien> listaBienes) {
        this.listaBienes = listaBienes;
    }

    //recibimos el bien y la cantidad y se hace el objeto CantidadDeBien
    public void añadirBien(Bien nuevoBien) {
        listaBienes.add(nuevoBien);
    }

    //tomo un objeto cantidad de bien, es decir debe ingresarse 
    public void quitarBien(Bien bienARetirar) {
        for (Bien aux : listaBienes) {
            if (aux == bienARetirar) {
                listaBienes.remove(aux);
            }
        }
    }

    @Override
    public String toString() {
        String retorno="";
        for (Bien aux : listaBienes) {
            retorno+=aux.toString()+aux.getCantidad();
        }
        return retorno;
    }
    
    

}
