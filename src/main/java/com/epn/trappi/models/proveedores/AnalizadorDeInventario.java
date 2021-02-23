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

    public ListaDeCompras analizarStock() {
        boolean proveedor=false;
        inventario=new Inventario();
        ListaDeCompras solicitud = new ListaDeCompras(new ArrayList<Compra>());
        

        for(CantidadDeBien cantidadBien : inventario.getListaCantidadDeBienes().getListaCantidadDeBienes()){
            if(cantidadBien.getCantidad()<=10){
                proveedor=false;
                for(Compra compra: solicitud.getCompras()){
                    if(compra.getListaCantidadDeBienes().getListaCantidadDeBienes().get(0).getBien().getProveeedor().getRazonSocial().equalsIgnoreCase(
                            cantidadBien.getBien().getProveeedor().getRazonSocial())){    
                        proveedor=true;
                        compra.getListaCantidadDeBienes().añadirBien(cantidadBien.getBien(), 100);
                    }
                }           
                if(proveedor==false){
                    ListaCantidadDeBienes lista =  new ListaCantidadDeBienes();
                    lista.añadirBien(cantidadBien.getBien(), 100);
                    solicitud.añadirCompra(new CompraDeProducto(inventario, lista, "Pendiente"));
                }
            }
        }
       
        return solicitud;
    }
}
