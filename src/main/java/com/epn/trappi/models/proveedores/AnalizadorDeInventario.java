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
        SolicitudDeCompras solicitud = new SolicitudDeCompras();
        for (int i=0;i<inventario.listaDeBienes.lista.size();i++) {
            if(inventario.listaCantidadDeBienes.lista.get(i).cantidad<3){
                proveedor=false;
                for (int i=0;i<solicitud.facturas;i++) {
                
                }
            }
        } 
    }
}
