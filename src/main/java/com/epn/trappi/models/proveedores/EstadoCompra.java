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
public interface EstadoCompra {
    public abstract boolean cambiarEstado();
    
    public abstract String getEstado();
    
}
