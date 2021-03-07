
package com.epn.trappi.models.financiero;

public class Presupuesto {

    LibroDiario libroDiario;

    public Presupuesto(LibroDiario libroDiario) {
        this.libroDiario = libroDiario;
    }

    
    public double calcularPresupuesto(){
        double ingresosTotal=libroDiario.calcularTotalIngresos();
        double pagoTotal=libroDiario.calcularTotalPagos();
        return ingresosTotal-pagoTotal;
    }
}
