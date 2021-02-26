/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarjetas;



/**
 *
 * @author Bryan
 */
public class TarjetaDebito implements Tarjeta{
    
    public String Tipo;
    public String NumeroTarjeta;
    public String CVV;
    public String Fechacaducidad;
    
    @Override
    public boolean realizarPago() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validarFondos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mostrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String[] mostrar1() {
     String[] datos=new String[4];
     datos[0]=NumeroTarjeta;
     datos[1]=CVV;
     datos[2]=Tipo;
     datos[3]=Fechacaducidad;
     return datos;
    }
    
}
