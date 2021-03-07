
package com.epn.trappi.gui.ecommerce.Tarjetas;


public abstract class Tarjeta {
    
    
    public String Tipo;
    public String NumeroTarjeta;
    public String CVV;
    public String Fechacaducidad;
    
    abstract public void realizarPago(Double valor);
    abstract public boolean validarFondos(Double valor);
    abstract public String[] mostrar();
    
}
