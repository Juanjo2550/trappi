/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.proveedores;

/**
 *
 * @author franc
 */
public class CompraDeProducto extends Compra {

    public CompraDeProducto(Inventario inventario, ListaCantidadDeBienes listaBienesAComprar, String estado) {
        super(inventario, listaBienesAComprar, estado);
    }
    
    @Override
    public void comprar(){
        if(solicitarAutorizacion(listaBienesAComprar.getListaCantidadDeBienes().get(0).getBien().getProveeedor(),calcularMontoTotal())){
            for (CantidadDeBien cantidadBien : listaBienesAComprar.getListaCantidadDeBienes()){
                inventario.aumentarStock(cantidadBien.getCantidad(), cantidadBien.getBien());
                //asumimos que las compras se han entregado
                setEstado("Entregado");
                registrarCompra(cantidadBien.getBien().getNombre()
                        ,cantidadBien.getBien().getProveeedor().getRuc(),cantidadBien.getCantidad(),estado);
            }
        }
    }
    
    
}
