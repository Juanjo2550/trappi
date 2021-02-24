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

    private ListaCantidadDeBienes listaCantidadDeBienes;
    private AnalizadorDeInventario analizador = new AnalizadorDeInventario();

    private ProveedoresDb db = new ProveedoresDb();
    public Inventario() {
        this.listaCantidadDeBienes = new ListaCantidadDeBienes();
        this.listaCantidadDeBienes.setListaCantidadDeBienes(listaCantidadDeBienes.getListaCantidadDeBienesDb());
    }

    public ListaCantidadDeBienes getListaCantidadDeBienes() {
        return listaCantidadDeBienes;
    }

    public void setListaCantidadDeBienes(ListaCantidadDeBienes listaDeBienes) {
        this.listaCantidadDeBienes = listaDeBienes;
    }

    //recibe una cantidad de un producto y verifica que exista esa cantidad o sea igual a la existente
    public boolean verificarStock(int cantidadAVerificar, Bien bienAVerificar) {
        for (CantidadDeBien cantidadBien : listaCantidadDeBienes.getListaCantidadDeBienes()) {
            if (cantidadBien.getBien() == bienAVerificar) {
                return cantidadBien.getCantidad() <= cantidadAVerificar;
            }
        }
        return false;
    }

    public void aumentarStockDb(CantidadDeBien cantidadBien) {
        try {
            ArrayList<CantidadDeBien> a = new ArrayList<>();
            a=db.getInventarioDb();
            for (int i=0;i<a.size();i++) {
                if(a.get(i).getBien().getNombre().equals(cantidadBien.getBien().getNombre())){
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
        for (CantidadDeBien cantidadBien : listaCantidadDeBienes.getListaCantidadDeBienes()) {
            if (cantidadBien.getBien() == bienAAumentar) {
                ArrayList<CantidadDeBien> aux = listaCantidadDeBienes.getListaCantidadDeBienes();
                int indice = aux.indexOf(cantidadBien);
                cantidadBien.aumentarCantidad(cantidadDeProductosNuevos);
                aux.set(indice, cantidadBien);
                listaCantidadDeBienes.setListaCantidadDeBienes(aux);
            }
        }
        analizador.analizarStock();
    }

    //el parámetro es la cantidad de productos a disminuir a la cantidad existente y el bien
    public void disminuirStock(int cantidadDeProductosRetirados, Bien bienADisminuir) {
        for (CantidadDeBien cantidadBien : listaCantidadDeBienes.getListaCantidadDeBienes()) {
            if (cantidadBien.getBien() == bienADisminuir) {
                ArrayList<CantidadDeBien> aux = listaCantidadDeBienes.getListaCantidadDeBienes();
                int indice = aux.indexOf(cantidadBien);
                cantidadBien.disminuirCantidad(cantidadDeProductosRetirados);
                aux.set(indice, cantidadBien);
                listaCantidadDeBienes.setListaCantidadDeBienes(aux);
            }
        }
        analizador.analizarStock();
    }
}
