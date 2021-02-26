/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ecommerce;

import Tarjetas.Tarjeta;
import Tarjetas.TarjetaCredito;
import Tarjetas.TarjetaDebito;


/**
 *
 * @author Bryan
 */
class Pago {
    TarjetaCredito tarjetacredito = new TarjetaCredito();
    TarjetaDebito tarjetadebito = new TarjetaDebito();
    


    public boolean validarPago(String tipo,Double valor){
        boolean bandera=false;
        if(tarjetacredito.Tipo.equals(tipo))
        {
            if(tarjetacredito.validarFondos(valor))
            {
                tarjetacredito.realizarPago(valor);
                bandera=true;
            }
        }
        else
        {
            if(tarjetadebito.validarFondos(valor))
            {
                tarjetadebito.realizarPago(valor);
                bandera=true;
            }
        }
        return bandera; 
    }
    
}
