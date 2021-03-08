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



    public void aumentarStock() {
        for (Bien bien : listaDeBienes.getListaBienes()) {
            try {
                db.actualizarStock(db.getIdBien(bien.getNombre()), bien.getCantidad());
            } catch (SQLException ex) {
                Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void disminuirStock(ArrayList<Bien> ListaADisminuir) {
        for (Bien bien : ListaADisminuir) {
            try {
                db.disminuirStock(db.getIdBien(bien.getNombre()), bien.getCantidad());
            } catch (SQLException ex) {
                Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }




}
