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
public class CompraDeServicio extends Compra{
    
    public CompraDeServicio(Inventario inventario, ListaDeBienes listaBienesAComprar, String estado) {
        super(inventario, listaBienesAComprar, estado);
        comprar();
    }
    
    @Override
    public void comprar(){
        if(solicitarAutorizacion(listaBienesAComprar.getListaBienes().get(0).getProveeedor(),montoTotal)){
            for (Bien cantidadBien : listaBienesAComprar.getListaBienes()){
                //asumimos que las compras se han entregado
                setEstado("Entregado");
                registrarCompra(cantidadBien.getNombre()
                        ,cantidadBien.getProveeedor().getRuc(),cantidadBien.getCantidad(),estado,montoTotal,this.fecha);
            }
        }
    }
}
