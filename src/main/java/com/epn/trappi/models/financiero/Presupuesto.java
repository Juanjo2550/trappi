
package com.epn.trappi.models.financiero;

public class Presupuesto {

    LibroDiario libroDiario;

    public Presupuesto(LibroDiario libroDiario) {
        this.libroDiario = libroDiario;
    }

    
    public double calcularPresupuesto(){
        double ingresosTotal=libroDiario.obtenerTotalIngresos();
        double pagoTotal=libroDiario.obtenerTotalPagos();
        return ingresosTotal-pagoTotal;
    }
}
