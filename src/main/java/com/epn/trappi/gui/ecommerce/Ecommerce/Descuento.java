/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.ecommerce.Ecommerce;

import com.epn.trappi.models.rrhh.Fecha;
import com.epn.trappi.models.rrhh.contratacion.Contrato;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Javier Erazo
 */
public class Descuento {
    private double valor;
    
    public Descuento(){
        this.valor = 0.10;
    }
    
    public boolean validarContrato(String cedula){
        Calendar fechaActual = new GregorianCalendar();
        int anoActual = fechaActual.get(Calendar.YEAR);
        int mesActual = fechaActual.get(Calendar.MONTH) + 1; 
        int diaActual = fechaActual.get(Calendar.DAY_OF_MONTH);
        Contrato contrato = new Contrato();
        Fecha fecha = new Fecha();
        fecha = contrato.obtenerFechaFin(cedula);
        if (fecha != null){
            int diaContrato = fecha.getDia();
            int mesContrato = fecha.getMes();
            int anoContrato = fecha.getAño();
            String tipo = contrato.obtenerTipo(cedula);
            return (tipo.equalsIgnoreCase("indefinido") || (anoActual <= anoContrato && mesActual <= mesContrato && diaActual <= diaContrato));
        } else
            return false;
        
        
        //System.out.println("Fecha Actual: " + diaActual + "/" + mesActual + "/" + anoActual);
        //System.out.println("Fecha Contrato: " + diaContrato + "/" + mesContrato + "/" + anoContrato);
        
        
    }
    
    public double obtenerValor(String cedulaCliente){
        if (validarContrato(cedulaCliente))
            return this.valor;
        return 0.0;
    }
    public static void main(String args[]){
        //TEST
        //Caso en que no existe
        double valor = new Descuento().obtenerValor("1258");
        System.out.println("El valor que se obtuvo fue = " + valor);
        //Terminado el contrato
        double valor1 = new Descuento().obtenerValor("1706496880");
        System.out.println("El valor que se obtuvo fue = " + valor1);
        //Casos de empleados vigentes
        double valor2 = new Descuento().obtenerValor("1755041589");
        System.out.println("El valor que se obtuvo fue = " + valor2);
        double valor3 = new Descuento().obtenerValor("175214895");
        System.out.println("El valor que se obtuvo fue = " + valor3);
        
    }
    
}


