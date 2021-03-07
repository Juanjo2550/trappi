/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.ecommerce.Ecommerce;

//package com.epn.trappi.models.logistico;

import com.epn.trappi.models.logistico.Entrega;
import com.epn.trappi.models.proveedores.Bien;
import com.epn.trappi.models.proveedores.Producto;
import com.epn.trappi.models.proveedores.Inventario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bryan
 */
public class FachadaEcommerce {
    
    


    
    //Financiero
   // Ingreso ingreso = new Ingreso();
    
    
    
    //Proveedores
    
  
    
    
    
    //Logistica
    
    
    
    
    
    
    
    public void enviarDatos(int numeroFactura,Double totalFactura, ArrayList<Producto> detalle)
    {
       //enviarAfinanzas();
        ArrayList<Bien> bien = new ArrayList<Bien>() ;
        //
        detalle.forEach(producto->{
        System.out.println(detalle.get(0).nombre);
        bien.add((Bien)producto);
        
        });
       enviarAProovedores(bien);
       Entrega entrega = new Entrega(numeroFactura);
       System.out.println("Los datos han sido enviados satisfactoriamente");
    }
    
    public void enviarAfinanzas(int numeroFactura,Double totalFactura){
      
      //**Ingreso ingreso = new Ingreso(numerofactura,totalFactura);//String //Double
      //ingreso.registrarIngreso(ingreso);
    }
    
    public void enviarAProovedores(ArrayList<Bien> detalle)
    {
     Inventario inventario;
        try {
            inventario = new Inventario();
            inventario.disminuirStock(detalle);
        } catch (IOException ex) {
            Logger.getLogger(FachadaEcommerce.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
   
    
    
}
