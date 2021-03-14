/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.ecommerce.Ecommerce;

import com.epn.trappi.gui.ecommerce.Tarjetas.Tarjeta;
import com.epn.trappi.gui.ecommerce.Tarjetas.TarjetaCredito;
import com.epn.trappi.gui.ecommerce.Tarjetas.TarjetaDebito;
import com.epn.trappi.gui.ecommerce.entidadBancaria.Cuenta;


/**
 *
 * @author GrupoD
 */
public class Pago {
    

    public boolean validarPago(Tarjeta tar,Double valor,Cuenta cuenta){
        boolean bandera=false;
      
        if(tar.Tipo.equals("Credito"))
        {
           
            TarjetaCredito tc = new TarjetaCredito();
            tc=(TarjetaCredito) tar;
            
            tc.cuenta=cuenta;
            
            if(tc.validarFondos(valor))
            {
                
                tc.realizarPago(valor);
                bandera=true;
            }
        }
        else
        {    
            TarjetaDebito td = new TarjetaDebito();
            td=(TarjetaDebito) tar;
            td.cuenta=cuenta;
            if(td.validarFondos(valor))
            {
                
                td.realizarPago(valor);
                bandera=true;
            }
        }
        return bandera; 
    }
    
    
}



