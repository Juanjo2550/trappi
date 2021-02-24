
package com.epn.trappi.models.financiero;

import java.util.ArrayList;
import java.util.Calendar;

public class Analizador {

    
    LibroDiario librodiario;
    Fecha fechaDesde;
    Fecha fechaHasta;
    public Analizador(LibroDiario librodiario) {
        this.librodiario = librodiario;
    }
    
    public double calcularIngresoMaximo(ArrayList<Ingreso> ingresosRegistrados){
        ingresosRegistrados=librodiario.ingresosRegistrados;
        double maximoIngreso=0;
        for(Ingreso ingreso: ingresosRegistrados){
            //
            if(ingreso.total>maximoIngreso&&ingreso.fechaIngreso.devolverMes()==fechaHasta.devolverMes()){
                maximoIngreso=ingreso.total;
            }
        }
        return maximoIngreso;
    }
    public double calcularIngresoMinimo(ArrayList<Ingreso> ingresosRegistrados){
        ingresosRegistrados=librodiario.ingresosRegistrados;
        double minimoIngreso=0;
        for(Ingreso ingreso: ingresosRegistrados){
            if(ingreso.total<minimoIngreso&&ingreso.fechaIngreso.devolverMes()==fechaHasta.devolverMes()){
                minimoIngreso=ingreso.total;
            }
        }
        return minimoIngreso;
    }
    public double calcularGastoMaximo(ArrayList<Pago> pagosRegistrados){
        pagosRegistrados=librodiario.pagosRegistrados;
        double maximoGasto=0;
        for(Pago pago: pagosRegistrados){
            if(pago.monto>maximoGasto&&pago.fechadePago.devolverMes()==fechaHasta.devolverMes()){
                maximoGasto=pago.monto;
            }
        }
        return maximoGasto;
    }
    public double calcularGastoMinimo(ArrayList<Pago> pagosRegistrados){
        pagosRegistrados=librodiario.pagosRegistrados;
        double minimoGasto=0;
        for(Pago pago: pagosRegistrados){
            if(pago.monto<minimoGasto&&pago.fechadePago.devolverMes()==fechaHasta.devolverMes()){
                minimoGasto=pago.monto;
            }
        }
        return minimoGasto;
    }
    public void calcularIntervaloMensual(){
        
        this.fechaHasta=new Fecha();
        if(fechaHasta.devolverMes()>=6){
        this.fechaDesde=new Fecha(1,fechaHasta.devolverMes()-5,fechaHasta.devolverAnio());
        }
        if(fechaHasta.devolverMes()<6){
            int[] mesesresiduos={0,-1,-2,-3,-4};
            for(int i=0; i<5;i++){
                if(mesesresiduos[i]==fechaHasta.devolverMes()-5){
                   this.fechaDesde=new Fecha(1,12-mesesresiduos[i],fechaHasta.devolverAnio()-1); 
                }
            }
            
        }
        
    }

    
}