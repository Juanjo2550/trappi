/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.ecommerce.Ecommerce;

import com.epn.trappi.gui.ecommerce.Tarjetas.Tarjeta;
import com.epn.trappi.gui.ecommerce.Tarjetas.TarjetaCredito;
import com.epn.trappi.gui.ecommerce.Tarjetas.TarjetaDebito;


/**
 *
 * @author Bryan
 */
public class Pago {
    


    public boolean validarPago(TarjetaCredito tc, TarjetaDebito td, String tipo,Double valor){
        boolean bandera=false;
        if(tipo.equals("Credito"))
        {
            
            if(td.validarFondos(valor))
            {
                td.realizarPago(valor);
                bandera=true;
            }
        }
        else
        {    
            if(td.validarFondos(valor))
            {
                td.realizarPago(valor);
                bandera=true;
            }
        }
        return bandera; 
    }
    
}
