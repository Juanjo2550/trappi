/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.proveedores;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author franc
 */
public class EstadoCompraPendiente implements EstadoCompra{

    private Compra compra;
    private String estado;

    public EstadoCompraPendiente(Compra compra, String estado) {
        this.compra = compra;
        this.estado = estado;
    }
    
    
    @Override
    public boolean cambiarEstado() {
        try {
            this.compra.setEstadoCompra(new EstadoCompraEntregado(this.compra,"Entregado"));
            compra.inventario.aumentarStock(this.compra.getIdentificador(),this.compra.getEstadoCompra().getEstado());
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EstadoCompraPendiente.class.getName()).log(Level.SEVERE, null, ex);
        }
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
