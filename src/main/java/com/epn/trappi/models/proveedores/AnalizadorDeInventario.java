package com.epn.trappi.models.proveedores;

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
public class AnalizadorDeInventario {

    Inventario inventario;

    private void analizarStock() {
        boolean proveedor;
        ListaDeCompras solicitud = new ListaDeCompras();
        for (int i=0;i<inventario.getListaCantidadDeBienes().getlistaCantidadDeBienes.size ;i++) {
            if(inventario.getListaCantidadDeBienes().getlistaCantidadDeBienes.get(i).cantidad<3){
                proveedor=false;
                for (int j=0;j<solicitud.compras.size();j++) {
                    if(inventario.getListaCantidadDeBienes().getlistaCantidadDeBienes.get(i).bien.proveedor.equals(
                       solicitud.compras.get(j).listaCantidadDeBienes.))
                }
            }
        } 
    }
}
