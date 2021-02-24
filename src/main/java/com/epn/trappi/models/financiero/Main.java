
package com.epn.trappi.models.financiero;


public class Main {
    public static void main(String[] args){
        LibroDiario libroDiario = new LibroDiario();
        Ingreso ingreso1 = new Ingreso("1001354", 500, libroDiario);
        Ingreso ingreso2 = new Ingreso("1001354", 500, libroDiario);
        Ingreso ingreso3 = new Ingreso("1001354", 500, libroDiario);
        Ingreso ingreso4 = new Ingreso("1001354", 500, libroDiario);
        Ingreso ingreso5 = new Ingreso("1001354", 500, libroDiario);
        Ingreso ingreso6 = new Ingreso("1001354", 500, libroDiario);
        Pago pago1 = new Pago(libroDiario,"102345", 126);
        Pago pago2 = new Pago(libroDiario,"102345", 126);
        Pago pago3 = new Pago(libroDiario,"102345", 126);
        Pago pago4 = new Pago(libroDiario,"102345", 126);
        Pago pago5 = new Pago(libroDiario,"102345", 126);
        Pago pago6 = new Pago(libroDiario,"102345", 126);
        ingreso1.registrarIngreso(ingreso1);
        ingreso2.registrarIngreso(ingreso2);
        ingreso3.registrarIngreso(ingreso3);
        ingreso4.registrarIngreso(ingreso4);
        ingreso5.registrarIngreso(ingreso5);
        ingreso6.registrarIngreso(ingreso6);
        pago1.registrarPago(pago1);
        pago2.registrarPago(pago2);
        pago3.registrarPago(pago3);
        pago4.registrarPago(pago4);
        pago5.registrarPago(pago5);
        pago6.registrarPago(pago6);
        pago1.realizarPago(pago1);
        for(Pago pago: libroDiario.pagosRegistrados){
            System.out.println(pago.toString());
        }
        for(Ingreso ingreso: libroDiario.ingresosRegistrados){
            System.out.println(ingreso.toString());
        }
    }
}
