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
public class ListaProveedores {

    private final ProveedoresDb db = new ProveedoresDb();
    private ArrayList<Proveedor> listaDeProveedores = new ArrayList<Proveedor>();

    public ArrayList<Proveedor> getListaDeProveedores() {
        listaDeProveedores = (ArrayList) db.getProveedores();
        return listaDeProveedores;
    }

    public void setListaDeProveedores(ArrayList<Proveedor> listaDeProveedores) {
        this.listaDeProveedores = listaDeProveedores;
    }

    public void añadirProveedor(Proveedor prov) {
        db.setProveedores(prov);
    }

    public void quitarProveedor(Proveedor prov) {
        this.listaDeProveedores.remove(prov);
    }
}
