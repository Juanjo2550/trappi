/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.proveedores;

import com.epn.trappi.db.proveedores.ProveedoresDb;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Peterca
 */
public class MainProveedores {

    public static void main(String args[]) {
        ProveedoresDb db = new ProveedoresDb();

        List<Producto> prod = db.getProductos();

        prod.forEach(p -> {
            System.out.println(p.getNombre()+";"+p.getPrecio()+";"+p.getProveeedor().getRuc());
        });
    }
}
