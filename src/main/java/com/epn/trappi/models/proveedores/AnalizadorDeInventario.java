package com.epn.trappi.models.proveedores;

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
public class AnalizadorDeInventario {

    Inventario inventario;

    public ListaDeCompras analizarStock() {
        try {
            boolean proveedor=false;
            inventario=new Inventario();
            ListaDeCompras solicitud = new ListaDeCompras(new ArrayList<Compra>());
            
            
            for(Bien cantidadBien : inventario.getListDeBienes().getListaBienes()){
                if(cantidadBien.getCantidad()<=10){
                    proveedor=false;
                    for(Compra compra: solicitud.getCompras()){
                        if(compra.getListaCantidadDeBienes().getListaBienes().get(0).getProveeedor().getRazonSocial().equalsIgnoreCase(
                                cantidadBien.getProveeedor().getRazonSocial())){
                            proveedor=true;
                            compra.getListaCantidadDeBienes().añadirBien(new Producto(
                                    cantidadBien.getNombre(), cantidadBien.getPrecio(), cantidadBien.getProveeedor(), 100, cantidadBien.getMarca()));
                        }
                    }
                    if(proveedor==false){
                        ListaDeBienes lista =  new ListaDeBienes();
                        lista.añadirBien(new Producto(
                                cantidadBien.getNombre(), cantidadBien.getPrecio(), cantidadBien.getProveeedor(), 100, cantidadBien.getMarca()));
                        solicitud.añadirCompra(new CompraDeProducto(inventario, lista, "Pendiente"));
                    }
                }
            }
            
            return solicitud;
        } catch (IOException ex) {
            Logger.getLogger(AnalizadorDeInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
