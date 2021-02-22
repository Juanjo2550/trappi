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
        ListaDeCompras solicitud = new ListaDeCompras(new ArrayList<Compra>());
        for (int i=0;i<inventario.getListaCantidadDeBienes().getListaCantidadDeBienes().size() ;i++) {
            if(inventario.getListaCantidadDeBienes().getListaCantidadDeBienes().get(i).getCantidad() <3){
                proveedor=false;
                for (int j=0;j<solicitud.getCompras().size() ;j++) {
                    if(inventario.getListaCantidadDeBienes().getListaCantidadDeBienes().get(i).getBien().getProveeedor().equals(
                       solicitud.getCompras().get(j).getListaCantidadDeBienes().getListaCantidadDeBienes().get(j).getBien().getProveeedor())){
                        solicitud.getCompras().get(j).getListaCantidadDeBienes().añadirBien(
                                inventario.getListaCantidadDeBienes().getListaCantidadDeBienes().get(i).getBien(), 10);
                        
                    }
                }
            }
        } 
    }
}
