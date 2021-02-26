/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.ecommerce.Tarjetas;

import com.epn.trappi.gui.ecommerce.entidadBancaria.Cuenta;



/**
 *
 * @author Bryan
 */
public class TarjetaDebito implements Tarjeta{
    
    public String Tipo;
    public String NumeroTarjeta;
    public String CVV;
    public String Fechacaducidad;
    Cuenta cuenta= new Cuenta();
    
    @Override
    public void realizarPago(Double valor) {
       if(validarFondos(valor)==true)
       {
         cuenta.debitar(valor);  
       }
        
    }
    
    @Override
    public boolean validarFondos(Double valor) {
        boolean bandera=false;
        if(valor<=cuenta.fondo)
        {
            bandera=true;
        }
        return bandera;
    }


    @Override
    public String[] mostrar() {
     String[] datos=new String[4];
     datos[0]=NumeroTarjeta;
     datos[1]=CVV;
     datos[2]=Tipo;
     datos[3]=Fechacaducidad;
     return datos;
    }

    
  
    
}
