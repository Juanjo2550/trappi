package com.epn.trappi.models.proveedores;

import com.epn.trappi.db.proveedores.ProveedoresDb;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    private ListaDeBienes listDeBienes;
    private AnalizadorDeInventario analizador = new AnalizadorDeInventario();

    private ProveedoresDb db = new ProveedoresDb();
    
    public Inventario() {
        this.listDeBienes = new ListaDeBienes();
        this.listDeBienes.setListaBienes(listDeBienes.getListaCantidadDeBienesDb());
    }

    public ListaDeBienes getListDeBienes() {
        return listDeBienes;
    }

    public void setListDeBienes(ListaDeBienes listaDeBienes) {
        this.listDeBienes = listaDeBienes;
    }

    //recibe una cantidad de un producto y verifica que exista esa cantidad o sea igual a la existente
    public boolean verificarStock(int cantidadAVerificar, Bien bienAVerificar) {
        for (Bien cantidadBien : listDeBienes.getListaBienes()) {
            if (cantidadBien == bienAVerificar) {
                return cantidadBien.getCantidad() <= cantidadAVerificar;
            }
        }
        return false;
    }

    public void aumentarStockDb(Bien cantidadBien) {
        try {
            ArrayList<Bien> a = new ArrayList<>();
            a=db.getInventarioDb();
            for (int i=0;i<a.size();i++) {
                if(a.get(i).getNombre().equals(cantidadBien.getNombre())){
                    cantidadBien.setCantidad(a.get(i).getCantidad()+cantidadBien.getCantidad());
                    a.set(i, cantidadBien);                    
                }
            }
            db.setInventarioDb(a);
        } catch (IOException ex) {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    //el parámetro es la cantidad de productos nuevos para añadir a la cantidad existente y el bien
    public void aumentarStock(int cantidadDeProductosNuevos, Bien bienAAumentar) {
        for (CantidadDeBien cantidadBien : listDeBienes.getListaBienes()) {
            if (cantidadBien.getBien() == bienAAumentar) {
                ArrayList<CantidadDeBien> aux = listDeBienes.getListaBienes();
                int indice = aux.indexOf(cantidadBien);
                cantidadBien.aumentarCantidad(cantidadDeProductosNuevos);
                aux.set(indice, cantidadBien);
                listDeBienes.setListaBienes(aux);
            }
        }
        analizador.analizarStock();
    }

    //el parámetro es la cantidad de productos a disminuir a la cantidad existente y el bien
    public void disminuirStock(int cantidadDeProductosRetirados, Bien bienADisminuir) {
        for (CantidadDeBien cantidadBien : listDeBienes.getListaBienes()) {
            if (cantidadBien.getBien() == bienADisminuir) {
                ArrayList<CantidadDeBien> aux = listDeBienes.getListaBienes();
                int indice = aux.indexOf(cantidadBien);
                cantidadBien.disminuirCantidad(cantidadDeProductosRetirados);
                aux.set(indice, cantidadBien);
                listDeBienes.setListaBienes(aux);
            }
        }
        analizador.analizarStock();
    }
}
