
package com.epn.trappi.models.financiero;

import java.util.ArrayList;

public class Analizador {

    
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

    
}