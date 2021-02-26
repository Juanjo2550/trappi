/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.ecommerce.Ecommerce;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Bryan
 */
public class Conexion {
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
       JOptionPane.showMessageDialog(null,"Envio satisfactorio a finanzas");
        
    }
    
    public void enviarAProovedores()
    {
        System.out.println("Envio satisfactorio a proveedores");
    }
    public void enviarALogistica(){
        System.out.println("Envio satisfactorio a Logistica");
    }
    
    
}
