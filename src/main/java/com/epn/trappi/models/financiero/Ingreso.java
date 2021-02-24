
package com.epn.trappi.models.financiero;

import java.util.Calendar;


public class Ingreso {
    Fecha fechaIngreso;
    String idFactura;
    double total;
    private LibroDiario libroDiario;
    public Ingreso(){
        
    }

    public Ingreso(String idFactura, double total,LibroDiario libroDiario) {
        this.idFactura = idFactura;
        this.total = total;
        this.libroDiario=libroDiario;
    }
    
    public void registrarIngreso(Ingreso ingreso){
        
        fechaIngreso = new Fecha();
        this.libroDiario.ingresosRegistrados.add(ingreso);
    }
    

    @Override
    public String toString() {
        return "Ingreso: " + "Fecha de Ingreso: "+this.fechaIngreso+", idFactura=" + idFactura + ", total=" + total + '\n';
    }
    
}
