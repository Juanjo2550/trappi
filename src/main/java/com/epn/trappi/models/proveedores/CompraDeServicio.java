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

    public CompraDeServicio(ListaDeBienes listaBienesAComprar, String estado) {
        super(listaBienesAComprar, estado);
    }
    
    @Override
    public void comprar(){
        if(solicitarAutorizacion(listaBienesAComprar.getListaBienes().get(0).getProveeedor().getCuenta(),montoTotal)){
            for (Bien cantidadBien : listaBienesAComprar.getListaBienes()){
                setMontoTotal();
                registrarCompra();
            }
        }
    }
}
