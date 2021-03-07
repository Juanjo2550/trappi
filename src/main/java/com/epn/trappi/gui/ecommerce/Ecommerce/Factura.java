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
    
    //public Inventario
    //public ArrayList<Bien> Detalle;
    public ArrayList <Articulo> Detalle;
    
    public int nFactura;
    String RUC;
    public Pago pago;
    
    public Factura(ArrayList <Articulo>  detalle){
        this.Detalle=detalle;
    }

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

//public ArrayList<Bien> mostrar(){
public ArrayList<Articulo> mostrar(){
    ArrayList mostrarDetalle = this.Detalle; 
    return mostrarDetalle;
}

    public void setNumeroFactura(int numeroFactura) {
        this.nFactura = numeroFactura;
    }


   
}
