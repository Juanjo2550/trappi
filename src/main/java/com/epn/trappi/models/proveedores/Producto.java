package com.epn.trappi.models.proveedores;

import com.epn.trappi.db.proveedores.ProveedoresDb;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Producto extends Bien {

    private final ProveedoresDb db = new ProveedoresDb();

    public Producto(String nombre, double precio, Proveedor proveeedor) {
        super(nombre, precio, proveeedor);
    }

    @Override
    public void registrar() {
        Producto prod = new Producto(nombre, precio, proveeedor);
        db.setProductos(prod);
    }

    @Override
    public void actualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
