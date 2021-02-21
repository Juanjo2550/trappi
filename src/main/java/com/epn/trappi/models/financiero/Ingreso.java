
package com.epn.trappi.models.financiero;

import java.util.Calendar;


public class Ingreso {
    String fechaIngreso;
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
        Calendar fechaIngresoObjeto = Calendar.getInstance(); 
        String dia = String.valueOf(fechaIngresoObjeto.get(Calendar.DATE));
        String mes = String.valueOf(fechaIngresoObjeto.get(Calendar.MONTH)+1);//se le suma uno debido a que enero es igual a cero
        String anio = String.valueOf(fechaIngresoObjeto.get(Calendar.YEAR));
        fechaIngreso = dia+'/'+mes+'/'+anio;
        libroDiario.ingresosRegistrados.add(ingreso);
    }
    

    @Override
    public String toString() {
        return "Ingreso: " + "Fecha de Ingreso: "+this.fechaIngreso+", idFactura=" + idFactura + ", total=" + total + '\n';
    }
    
}
