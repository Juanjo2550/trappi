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
public class Factura {
    public ArrayList <Articulo> Detalle;
    
   public String cedulaCliente;
    String nombreCliente;
    
    public Factura(String cedula,String nombre,ArrayList <Articulo>  detalle){
        this.cedulaCliente=cedula;
        this.nombreCliente=nombre;
        this.Detalle=detalle;
    }

    String RUC;
    String nFactura;
    Pago pago;
    Conexion conexion;
    

public Double calcularSubTotal(){
   

    Double total =0.0;

    for(int i=0;i<this.Detalle.size();i++)
    {
       total = total+this.Detalle.get(i).precio;
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

public ArrayList mostrar(){
    
    ArrayList mostrarDetalle = this.Detalle;
    Double valor = calcularTotal();
    //Metodo de validacion de tarjeta da true, continuo con arrancar
    pago = new Pago(valor);
    return mostrarDetalle;
}

public void arrancar()
{
    Double valor = calcularTotal();
    conexion=new Conexion(this.nombreCliente,valor,this.nFactura,this.Detalle);
}

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }


    
}
