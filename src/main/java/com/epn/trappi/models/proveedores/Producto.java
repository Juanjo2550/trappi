package com.epn.trappi.models.proveedores;

import com.epn.trappi.db.proveedores.ProveedoresDb;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Producto extends Bien {

    private final ProveedoresDb db = new ProveedoresDb();

    public Producto(String nombre, double precio, Proveedor proveeedor, int cantidad, String marca) {
        super(nombre, precio, proveeedor, cantidad, marca);
    }

    public Producto(String nombre, double precio, int cantidad, String marca) {
        super(nombre, precio, null, cantidad, marca);
    }
    
    public Producto(String nombre, double precio, Proveedor proveeedor) {
        super(nombre, precio, proveeedor);
    }

    public Producto(String nombre) {
        super(nombre);
    }

    @Override
    public void registrar() {
        Producto prod = new Producto(nombre, precio, proveeedor, cantidad, marca);
        try {
            db.setProductos(prod);
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
