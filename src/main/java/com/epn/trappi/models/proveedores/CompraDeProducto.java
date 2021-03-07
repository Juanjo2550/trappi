/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.proveedores;

import com.epn.trappi.db.proveedores.ProveedoresDb;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author franc
 */
public class CompraDeProducto extends Compra {

    public CompraDeProducto() {
        super();
    }

    public CompraDeProducto(ListaDeBienes listaBienesAComprar, String estado, Double montoTotal, String fecha, int identificador) {
        super(listaBienesAComprar, estado, montoTotal, fecha, identificador);
    }

    
    public CompraDeProducto(ListaDeBienes listaBienesAComprar, String estado) {
        super(listaBienesAComprar,estado);
    }
    
    public CompraDeProducto(ListaDeBienes listaBienesAComprar, String estado, String fecha,Double monto) {
        super(listaBienesAComprar,estado, fecha,monto);
    }

    public CompraDeProducto(Inventario inventario, ListaDeBienes listaBienesAComprar, String estado) {
        super(inventario,listaBienesAComprar,estado);
    }
    
    @Override
    public void comprar(){
        setMontoTotal();
        if(solicitarAutorizacion(listaBienesAComprar.getListaBienes().get(0).getProveeedor().getCuenta(),montoTotal)){
            registrarCompra();
        }
    }
    
    @Override
    public void comprarAnalizador(){
        /*setMontoTotal();
        if(solicitarAutorizacion(listaBienesAComprar.getListaBienes().get(0).getProveeedor(),montoTotal)){
            for (Bien cantidadBien : listaBienesAComprar.getListaBienes()){
                inventario.aumentarStock(cantidadBien.getCantidad(), cantidadBien);
                //asumimos que las compras se han entregado
                setEstado("Entregado");
                registrarCompra(cantidadBien.getNombre()
                        ,cantidadBien.getProveeedor().getRuc(),cantidadBien.getCantidad(),estado,montoTotal, this.fecha);
            }
        }*/
    }
    
    
}
