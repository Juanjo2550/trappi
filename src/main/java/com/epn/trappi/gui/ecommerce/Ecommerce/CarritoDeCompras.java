/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.ecommerce.Ecommerce;

import com.epn.trappi.models.proveedores.Producto;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_OPTION;

/**
 *
 * @author Bryan
 */
public class CarritoDeCompras {
    
    

    //Asociacion con Inventario
    public ArrayList<Producto> Productos= new ArrayList<Producto>() ;
    //public ArrayList<Articulo> Productos = new ArrayList<Articulo>();
    public Factura factura;
    
      public void añadirProducto( String nombre,Double precio,int cantidad,String marca)
    {
        Producto producto= new Producto(nombre,precio,cantidad,marca);
        /*Articulo producto = new Articulo();
        producto.nombre=nombre;
        producto.precio=precio;
        producto.cantidad=cantidad;
        producto.marca=marca;*/
        
        Productos.add(producto);

    }
      
    public void borrarProducto(String nombre){

        for(int i=0;i<Productos.size();i++)
        {
          
            if(Productos.get(i).nombre.equals(nombre))
            {
                Productos.remove(i);
                break;
            }
        
        }
    }
    
    public void vaciarCarrito(){
        Productos.removeAll(Productos);
    }
      
        public int cantidadCompraProducto(){
         int cantidad =0;
         cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Cuantos desea?"));
         return cantidad;
     }
        
    public boolean confirmarContenido(){
       
        boolean bandera = false;
        if(JOptionPane.showConfirmDialog(null, "¿Está seguro que desea procesar su compra?","El proceso de pago empezará",JOptionPane.YES_NO_OPTION)==YES_OPTION){
           bandera=true;  
       }
        return bandera;
    }
        

}
