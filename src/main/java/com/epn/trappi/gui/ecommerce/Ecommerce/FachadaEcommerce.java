/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.ecommerce.Ecommerce;

import java.util.ArrayList;

/**
 *
 * @author Bryan
 */
public class FachadaEcommerce {
    
    //Aqui es array, pero hay que ver que array
    ArrayList <Articulo> Detalle;

    /*
    //Financiero
    Ingreso ingreso = new Ingreso();
    
    
    
    //Proveedores
    
    Inventario inventario = new Inventario();
    
    
    
    //Logistica
    
    Entrega entrega = new Entrega();
    
    
    
    */
    
    public void enviarDatos()
    {
       enviarAfinanzas();
       enviarAProovedores();
       enviarALogistica();
       System.out.println("Los datos han sido enviados satisfactoriamente");
    }
    
    public void enviarAfinanzas(){
      
      //  **ingreso.registrarIngreso(numeroFactura,totalFactura)
    }
    
    public void enviarAProovedores()
    {
      //**inventario.disminuirStock(detalleFactura);
    }
    public void enviarALogistica(){
      //entrega.empezarEntrega(detalleFactura);
    }
    
    
}
