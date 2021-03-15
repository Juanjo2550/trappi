
package com.epn.trappi.models.financiero;

public class Presupuesto {

    LibroDiario libroDiario;
    
    public Presupuesto(LibroDiario libroDiario) {
        this.libroDiario = libroDiario;
    }

    
    public double calcularPresupuesto(){
        double presupuesto=0;
        double ingresosTotal=libroDiario.calcularTotalIngresos();
        double pagoTotal=libroDiario.calcularTotalPagos();
        double devolucionTotal=libroDiario.calcularTotalDevoluciones();
        presupuesto = ingresosTotal-pagoTotal-devolucionTotal;
        return presupuesto;
    }
}
