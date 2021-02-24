/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ecommerce;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_OPTION;

/**
 *
 * @author Bryan
 */
public class CarritoDeCompras {
    
    private ArrayList<Articulo> articulos = new ArrayList<Articulo>();
    public Factura factura;
    
      public void añadirProducto(String id, String nombre,Double precio,int cantidad,String marca)
    {
        Articulo articulo = new Articulo();
        articulo.id=id;
        articulo.nombre=nombre;
        articulo.precio=precio;
        articulo.cantidad=cantidad;
        articulo.marca=marca;

        articulos.add(articulo);
    }
      
    public void borrarProducto(String nombre){

        for(int i=0;i<articulos.size();i++)
        {
          
            if(articulos.get(i).nombre.equals(nombre))
            {
                articulos.remove(i);
                break;
            }
        
        }
    }
    
    public void vaciarCarrito(){
        for(int i=0;i<articulos.size();i++)
            {
                articulos.remove(i);
            }   
        articulos.removeAll(articulos);
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
           factura = new Factura(Main.cliente.Cedula,Main.cliente.Nombre,this.articulos);
           
          
       }
        return bandera;
    }
        

}
