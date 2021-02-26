/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.ecommerce.Tarjetas;

/**
 *
 * @author Bryan
 */
public interface Tarjeta {
    
    
    public void realizarPago(Double valor);
    public boolean validarFondos(Double valor);

    public String[] mostrar();
    
}
