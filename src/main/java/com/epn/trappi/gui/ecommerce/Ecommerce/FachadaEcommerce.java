/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.ecommerce.Ecommerce;

//package com.epn.trappi.models.logistico;

import com.epn.trappi.models.financiero.Ingreso;
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
 * @author GrupoD
 */
public class FachadaEcommerce {
    
    

    public void enviarDatos(int numeroFactura,double totalFactura, ArrayList<Producto> detalle, String direccion)
    {
       
        ArrayList<Bien> bien = new ArrayList<Bien>() ;
        
        detalle.forEach(producto->{
        System.out.println(detalle.get(0).nombre);
        bien.add((Bien)producto);
        
        });
        
        //enviarAProveedores();
       enviarAProovedores(bien);
       
       //enviarALogistico
      enviarALogistico(numeroFactura,direccion);
       
       
       //enviar a Financiero
       enviarAfinanzas(numeroFactura,totalFactura);
       
       System.out.println("Los datos han sido enviados satisfactoriamente");
    }
    
    public void enviarAfinanzas(int numeroFactura,double totalFactura){
      
      Ingreso ingreso = new Ingreso();//String //Double
      ingreso.registrarIngreso(numeroFactura,totalFactura);
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
    
    public void enviarALogistico(int numeroFactura,String direccion)
    {
       Entrega entrega = new Entrega();
       entrega.crearEntrega(numeroFactura);
       
    }
   
    
}
