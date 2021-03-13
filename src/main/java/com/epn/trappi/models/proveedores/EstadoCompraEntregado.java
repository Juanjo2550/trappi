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
public class EstadoCompraEntregado implements EstadoCompra{

    private Compra compra;
    private String estado;
    
    public EstadoCompraEntregado(Compra compra, String estado) {
        this.compra = compra;
        this.estado = estado;
    }
    
    @Override
    public boolean cambiarEstado() {
        return false;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
