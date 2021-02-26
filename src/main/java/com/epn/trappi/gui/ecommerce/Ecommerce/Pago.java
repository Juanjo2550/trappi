/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.ecommerce.Ecommerce;

import Tarjetas.Tarjeta;


/**
 *
 * @author Bryan
 */
class Pago {
    Double valorAPagar;
    String fecha;
    
    public Pago(Double valorPorPagar){
        this.valorAPagar=valorPorPagar;
    }

    public boolean validarPago(Tarjeta tarjeta){
        Double saldo=500000.00;
        boolean bandera=false;
        if(this.valorAPagar<=saldo)
        {
            bandera=true;
            
        }
       return bandera;
    }
    
}
