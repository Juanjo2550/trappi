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
import javax.swing.JOptionPane;


/**
 *
 * @author Bryan
 */
public class Pago {
    


    public boolean validarPago(TarjetaCredito tc, TarjetaDebito td, String tipo,Double valor,Cuenta cuenta){
        boolean bandera=false;
        JOptionPane.showMessageDialog(null, "Entra al metodo");
        if(tipo.equals("Credito"))
        {
            JOptionPane.showMessageDialog(null, "Entra a credito");
            tc = new TarjetaCredito();
            
            tc.cuenta=cuenta;
            
            if(tc.validarFondos(valor))
            {
                JOptionPane.showMessageDialog(null, "Entra a validar fondo");
                tc.realizarPago(valor);
                bandera=true;
            }
        }
        else
        {    
            td = new TarjetaDebito();
            JOptionPane.showMessageDialog(null, "Entra a debito");
            td.cuenta=cuenta;
            if(td.validarFondos(valor))
            {
                JOptionPane.showMessageDialog(null, "Entra a validar fondo");
                td.realizarPago(valor);
                bandera=true;
            }
        }
        return bandera; 
    }
    
    
}



