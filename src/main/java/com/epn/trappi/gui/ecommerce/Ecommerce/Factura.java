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
public class Factura {
    public ArrayList <Articulo> Detalle;
    
   public String cedulaCliente;
   public String nombreCliente;
   public int id;
    
    public Factura(String cedula,String nombre,ArrayList <Articulo>  detalle){
        this.cedulaCliente=cedula;
        this.nombreCliente=nombre;
        this.Detalle=detalle;
    }

    String RUC;
    String nFactura;
    public Pago pago;
    public FachadaEcommerce conexion;
    

public Double calcularSubTotal(){
   

    Double total =0.0;

    for(int i=0;i<this.Detalle.size();i++)
    {
       total = total+this.Detalle.get(i).precio*this.Detalle.get(i).cantidad;
    }
    
    return total;
}

public Double calcularImpuestos(){
    Double subtotal=calcularSubTotal();
    Double impuestos=subtotal*0.12;
return impuestos;    
}

public Double calcularTotal(){
    Double subtotal=calcularSubTotal();
    Double impuestos=calcularImpuestos();
    Double total = subtotal+impuestos;
    
    return total;
}

public ArrayList<Articulo> mostrar(){
    
    ArrayList mostrarDetalle = this.Detalle;
    Double valor = calcularTotal();
    //Metodo de validacion de tarjeta da true, continuo con arrancar


    return mostrarDetalle;
}

    public void setId(int id) {
        this.id = id;
    }


   
}
