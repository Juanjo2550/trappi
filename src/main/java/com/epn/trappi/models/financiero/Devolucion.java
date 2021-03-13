
package com.epn.trappi.models.financiero;

import com.epn.trappi.db.financiero.FinancieroDb;
import com.epn.trappi.gui.ecommerce.entidadBancaria.Cuenta;

public class Devolucion {
    Fecha fechaDeDevolucion;
    //SolicitudDevolucion solicitudDevolucion;
    int nroFactura;
    double valorDevolucion;

    public Devolucion() {
    }

    public Devolucion(Fecha fechaDeDevolucion, int nroFactura, double valorDevolucion) {
        this.fechaDeDevolucion = fechaDeDevolucion;
        this.nroFactura = nroFactura;
        this.valorDevolucion = valorDevolucion;
    }
    
    public boolean procesarDevolucion(int idFactura){
        double valorDevolucion=0;
        valorDevolucion=this.calcularValorDevolucion(idFactura);
        FinancieroDb db = new FinancieroDb();
        if(valorDevolucion==0){
            System.out.println("Devolucion no realizada");
            return false;
        }
        if(valorDevolucion>0){
            db.acutalizarEstadoFactura(idFactura);
            Cuenta cuentaDevolucion = new Cuenta();
            //cuentaDevolucion.acreditar(valorDevolucion);
            LibroDiario libroDiario = new LibroDiario();
            this.fechaDeDevolucion=new Fecha();
            Devolucion devolucion = new Devolucion(fechaDeDevolucion, idFactura, valorDevolucion);
            libroDiario.agregarDevolucion(devolucion);
        }
        System.out.println("devolucion realizada con exito");
        return true;
    }
    private double calcularValorDevolucion(int nroFactura){
        FinancieroDb db = new FinancieroDb();
        this.valorDevolucion= 0.12 * db.consultarFacturaPorNroFactura(nroFactura);
        return valorDevolucion;
    }

    public double getValorDevolucion() {

        return valorDevolucion;
    }

    public Fecha getFechaDeDevolucion() {
        return fechaDeDevolucion;
    }

    public int getNroFactura() {
        return nroFactura;
    }
    
    
}
