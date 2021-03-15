
package com.epn.trappi.models.financiero;

import java.util.Calendar;


public class Fecha {
    private int dia;
    private int mes;
    private int anio;

    public Fecha() {
        Calendar fechaPagoObjeto = Calendar.getInstance();
        this.dia = fechaPagoObjeto.get(Calendar.DATE);
        this.mes = fechaPagoObjeto.get(Calendar.MONTH)+1;
        this.anio = fechaPagoObjeto.get(Calendar.YEAR);
    }

    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }
    
    
    public int devolverDia(){
        return dia;
    }
    public int devolverMes(){
        return mes;
    }
    public int devolverAnio(){
        return anio;
    }
}
