/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.ecommerce.FormulariosTarjetas;






/**
 *
 * @author Bryan
 */
public class FRegistroTarjeta implements FormularioTarjeta{
    public String Tipo;
    String Numero;
    String CVV;
    String FechaCaducidad;

    
    
    public FRegistroTarjeta(String Numero, String CVV, String FechaCaducidad,String tipo) {
       
        this.Numero = Numero;
        this.CVV = CVV;
        this.FechaCaducidad = FechaCaducidad;
        this.Tipo = tipo;
 
    }

 

        @Override
        public String[] obtenerDatos() {

           String[] datos = new String[4];
           
           datos[0]=this.Numero;
           datos[1]=this.CVV;
           datos[2]=this.FechaCaducidad;
           datos[3]=this.Tipo;
           
           return datos;
        }

 
    
}
