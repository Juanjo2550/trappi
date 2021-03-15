/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.ecommerce.Ecommerce;

import com.epn.trappi.models.rrhh.Fecha;
import com.epn.trappi.models.rrhh.contratacion.Contrato;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author GrupoD
 */
public class Descuento {
    private double valor;
    
    public Descuento(){
        this.valor = 0.10;
    }
    
    public boolean validarContrato(String cedula) {
        try {
            Contrato contrato = new Contrato();
            Fecha fecha = new Fecha();
            fecha = contrato.obtenerFechaFin(cedula);
        
         if (fecha != null){
            String diaContrato = String.valueOf(fecha.getDia());
            String mesContrato = String.valueOf(fecha.getMes());
            String anoContrato = String.valueOf(fecha.getAño());
            String tipo = contrato.obtenerTipo(cedula);
            //System.out.println("Fecha Actual: " + diaActual + "/" + mesActual + "/" + anoActual);
            System.out.println("Fecha Contrato: " + diaContrato + "/" + mesContrato + "/" + anoContrato);
            
            Date fechaActual = new Date(System.currentTimeMillis());
            String fechaContrato = anoContrato + "-" + mesContrato + "-" + diaContrato;
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaContratoDate = date.parse(fechaContrato);
            return fechaContratoDate.after(fechaActual);
            } else
            return false;
            
        } catch (Exception e) {
        }
        return false;
    }
    
    public double obtenerValor(String cedulaCliente) throws ParseException{
        if (validarContrato(cedulaCliente))
            return this.valor;
        return 0.0;
        }
            
        
    
//       public static void main(String args[]){
//        //TEST
//        //Caso en que no existe
//        try {
//            double valor = new Descuento().obtenerValor("1258");
//        System.out.println("El valor que se obtuvo fue = " + valor);
//        //Terminado el contrato
//        double valor1 = new Descuento().obtenerValor("1706496880");
//        System.out.println("El valor que se obtuvo fue = " + valor1);
//        //Casos de empleados vigentes
//        double valor2 = new Descuento().obtenerValor("1755041589");
//        System.out.println("El valor que se obtuvo fue = " + valor2);
//        double valor3 = new Descuento().obtenerValor("175214895");
//        System.out.println("El valor que se obtuvo fue = " + valor3);
//            
//        } catch (Exception e) {
//            System.out.println("Error en parseo de fecha" + e);
//        }
//        
//        
//    }
    
    
}


