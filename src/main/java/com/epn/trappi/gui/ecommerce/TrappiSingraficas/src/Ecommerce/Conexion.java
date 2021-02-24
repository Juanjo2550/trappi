/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ecommerce;

import java.util.ArrayList;

/**
 *
 * @author Bryan
 */
class Conexion {
    ArrayList <Articulo> Detalle;
    String nombreCliente;
    Double valorTotal;
    String numeroFactura;
   
    public Conexion(String nombre,Double total,String numeroFactura,ArrayList <Articulo> detalle){
        this.nombreCliente=nombre;
        this.valorTotal=total;
        this.numeroFactura=numeroFactura;
        this.Detalle=detalle;
    }
    
    public void enviarAfinanzas(){
        
        
    }
    
    public void enviarAProovedores()
    {
        
    }
    public void enviarALogistica(){
        
    }
    
    
}
