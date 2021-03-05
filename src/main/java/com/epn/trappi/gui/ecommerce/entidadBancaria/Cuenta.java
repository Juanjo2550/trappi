/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.ecommerce.entidadBancaria;

/**
 *
 * @author Bryan
 */
public class Cuenta {
    
    public String NumeroCuenta;
    public String CedulaPropietario;
    public Double fondo;
    
    
    public void acreditar(Double valor){
        this.fondo=this.fondo+valor;
    }
    
    public void debitar(Double valor){
        this.fondo=this.fondo-valor;
    }
    
}
