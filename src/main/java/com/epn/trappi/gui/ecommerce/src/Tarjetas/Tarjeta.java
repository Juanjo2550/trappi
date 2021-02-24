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
public interface Tarjeta {
    
    
    public boolean realizarPago();
    public boolean validarFondos();
    public void mostrar();
    public String[] mostrar1();
    
}
