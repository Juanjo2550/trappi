
package com.epn.trappi.models.financiero;

import java.util.ArrayList;

public class Analizador {
   /* public double ingresoMinimos;
    public double ingresoMaximos;
    pendiente estos dos atributos*/
    private double presupuesto;
    LibroDiario librodiario;

    public Analizador(LibroDiario librodiario) {
        this.librodiario = librodiario;
    }
    
    public double obtenerMaximoIngreso(ArrayList<Ingreso> ingresosRegistrados){
        ingresosRegistrados=librodiario.ingresosRegistrados;
        double maximoIngreso=0;
        for(Ingreso ingreso: ingresosRegistrados){
            if(ingreso.total>maximoIngreso){
                maximoIngreso=ingreso.total;
            }
        }
        return maximoIngreso;
    }
    public void calcularPresupuesto(){
        double totalIngresos=librodiario.obtenerTotalIngresos();
        double totalPagos=librodiario.obtenerTotalPagos();
        double presupuesto;
        presupuesto=totalIngresos-totalPagos;
        this.presupuesto=presupuesto;
    }

    public double getPresupuesto() {
        return presupuesto;
    }
    
}