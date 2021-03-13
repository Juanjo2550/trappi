/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.ecommerce.Ecommerce;


import com.epn.trappi.models.proveedores.Producto;
import java.util.ArrayList;


/**
 *
 * @author Bryan
 */
public class Factura {
    
    //public Inventario
    public ArrayList<Producto> Detalle;
    //public ArrayList <Articulo> Detalle;
    
    public int nFactura;
    String RUC;
    public Pago pago;
    
    public Factura(ArrayList <Producto>  detalle){
        this.Detalle=detalle;
        this.pago=new Pago();
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

public Double calcularTotalConDescuento(String cedula){
    Double total = calcularTotal();
    Descuento descuento = new Descuento();
    Double valorDescuento=descuento.obtenerValor(cedula);
    
    Double resultado = total-(total*valorDescuento);
    return resultado; 
}

    public void setNumeroFactura(int numeroFactura) {
        this.nFactura = numeroFactura;
    }


    
    
   
}
