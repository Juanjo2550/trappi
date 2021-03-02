package com.epn.trappi.models.proveedores;

import com.epn.trappi.db.proveedores.ProveedoresDb;
import java.io.IOException;
import java.sql.SQLException;
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

    private ListaDeBienes listaDeBienes;
    private AnalizadorDeInventario analizador = new AnalizadorDeInventario();

    private ProveedoresDb db = new ProveedoresDb();
    
    public Inventario() throws IOException {
        this.listaDeBienes = new ListaDeBienes();
        this.listaDeBienes = db.getInventarioDb();
    }

    public Inventario(ListaDeBienes listDeBienes) {
        this.listaDeBienes = listDeBienes;
    }

    public ListaDeBienes getListaDeBienes() {
        return listaDeBienes;
    }

    public void setListaDeBienes(ListaDeBienes listaDeBienes) {
        this.listaDeBienes = listaDeBienes;
    }

    //recibe una cantidad de un producto y verifica que exista esa cantidad o sea igual a la existente
    public boolean verificarStock(int cantidadAVerificar, Bien bienAVerificar) {
        for (Bien cantidadBien : listaDeBienes.getListaBienes()) {
            if (cantidadBien == bienAVerificar) {
                return cantidadBien.getCantidad() <= cantidadAVerificar;
            }
        }
        return false;
    }

    public void aumentarStock() {
        for (Bien bien : listaDeBienes.getListaBienes()) {
            try {
                db.actualizarStock(db.getIdBien(bien.getNombre()), bien.getCantidad());
            } catch (SQLException ex) {
                Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void disminuirStock() {
        
    }
    
    
    
    
    
    
    
    
    
    
    //el parámetro es la cantidad de productos nuevos para añadir a la cantidad existente y el bien
    public void aumentarStockotro(int cantidadDeProductosNuevos, Bien bienAAumentar) {
        /*for (CantidadDeBien cantidadBien : listaDeBienes.getListaBienes()) {
            if (cantidadBien.getBien() == bienAAumentar) {
                ArrayList<CantidadDeBien> aux = listaDeBienes.getListaBienes();
                int indice = aux.indexOf(cantidadBien);
                cantidadBien.aumentarCantidad(cantidadDeProductosNuevos);
                aux.set(indice, cantidadBien);
                listaDeBienes.setListaBienes(aux);
            }
        }
        analizador.analizarStock();*/
    }

    //el parámetro es la cantidad de productos a disminuir a la cantidad existente y el bien
    public void disminuirStockotro(int cantidadDeProductosRetirados, Bien bienADisminuir) {
        /*for (CantidadDeBien cantidadBien : listaDeBienes.getListaBienes()) {
            if (cantidadBien.getBien() == bienADisminuir) {
                ArrayList<CantidadDeBien> aux = listaDeBienes.getListaBienes();
                int indice = aux.indexOf(cantidadBien);
                cantidadBien.disminuirCantidad(cantidadDeProductosRetirados);
                aux.set(indice, cantidadBien);
                listaDeBienes.setListaBienes(aux);
            }
        }
        analizador.analizarStock();*/
    }
}
