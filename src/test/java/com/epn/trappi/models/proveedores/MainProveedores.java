/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.proveedores;

import com.epn.trappi.db.proveedores.ProveedoresDb;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Peterca
 */
public class MainProveedores {

    public static void main(String args[]) {
        ProveedoresDb db = new ProveedoresDb();

        //Probando Listar Productos
        List<Producto> prod = db.getProductos();
        prod.forEach(p -> {
            System.out.println(p.getNombre() + ";" + p.getPrecio() + ";" + p.getProveeedor().getRuc());
        });

        //Probando Listar Proveedores
        ListaProveedores prov = new ListaProveedores();
        prov.getListaDeProveedores().forEach(pr -> {
            System.out.println(pr.getRuc() + ";" + pr.getRazonSocial() + ";" + pr.getDireccion() + ";" + pr.getCuenta());
        });

        //Probando Listar Servicios
        List<Servicio> serv = db.getServicios();
        serv.forEach(pr -> {
            System.out.println(pr.getNombre() + ";" + pr.getPrecio() + ";" + pr.getProveeedor().getRuc());
        });

        //Probando Listar ListaCantidadBien
        /*ListaCantidadDeBienes bienes = new ListaCantidadDeBienes();
        bienes.getListaCantidadDeBienesDb().forEach(bien -> {
            System.out.println(bien.getBien().getNombre() + ";" + bien.getCantidad());
        });*/

        Inventario inv = new Inventario();

        inv.getListaCantidadDeBienes().getListaCantidadDeBienes().forEach(bien -> {
            System.out.println(bien.getBien().getNombre() + ";" + bien.getCantidad());
        });

        //db.getListaCantidadBienes();
        /*//Probando agregar Producto
        Proveedor prove = new Proveedor("1772561566001", "Super Aqui", "Quito, Ecuador");
        Producto pro = new Producto("Doritos, picantes", 3.75, prove);
        db.setProductos(pro);
        
        //Probando agregar Proveedores
        Proveedor prove = new Proveedor("1772561566001", "Super Aqui", "Quito, Ecuador");
        db.setProveedores(prove);*/
    }
}