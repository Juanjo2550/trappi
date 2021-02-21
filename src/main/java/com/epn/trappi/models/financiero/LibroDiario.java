
package com.epn.trappi.models.financiero;

import java.util.ArrayList;


public class LibroDiario {
    ArrayList<Ingreso> ingresosRegistrados=new ArrayList<Ingreso>();
    ArrayList<Pago> pagosRegistrados = new ArrayList<Pago>();
    public double obtenerTotalIngresos(){
        double totalIngresos=0;
        for(Ingreso ingreso:ingresosRegistrados){
            totalIngresos+=ingreso.total;
        }
        return totalIngresos;
    }
    public double obtenerTotalPagos(){
        double totalPagos=0;
        for(Pago pago:pagosRegistrados){
            totalPagos+=pago.monto;
        }
        return totalPagos;
    }

}
