
package com.epn.trappi.models.financiero;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class  Pago {
    String fechadePago;
    LibroDiario libroDiario;
    String nroCuenta;
    double monto;
    Presupuesto presupuesto;

    public Pago(LibroDiario libroDiario, String nroCuenta, double monto) {
        //Se calcula la fecha del pago
        Calendar fechaPagoObjeto = Calendar.getInstance(); 
        String dia = String.valueOf(fechaPagoObjeto.get(Calendar.DATE));
        String mes = String.valueOf(fechaPagoObjeto.get(Calendar.MONTH)+1);//se le suma uno debido a que enero es igual a cero
        String anio = String.valueOf(fechaPagoObjeto.get(Calendar.YEAR));
        this.fechadePago = dia+'/'+mes+'/'+anio;
        this.libroDiario = libroDiario;
        this.nroCuenta = nroCuenta;
        this.monto = monto;
    }


    
    public void registrarPago(Pago pago){

        libroDiario.pagosRegistrados.add(pago);
    }
    public String realizarPago(Pago pago){
        this.presupuesto=new Presupuesto(this.libroDiario);
        String estadoSolicitud="Pendiente";
        if(pago.monto<this.presupuesto.calcularPresupuesto()){
            System.out.println("El presupuesto de TRAPPI es: "+this.presupuesto.calcularPresupuesto());
            estadoSolicitud="Realizado";
            this.registrarPago(pago);
            System.out.println("El nuevo presupuesto: "+this.presupuesto.calcularPresupuesto());
        }
        System.out.println("Funcion Realizar Pago returns : "+estadoSolicitud);
        return estadoSolicitud; 
    }
    @Override
    public String toString() {
        return "Pago: " + "fechadePago=" + fechadePago + ", cuentaPagar=" + nroCuenta + ", monto=" + monto + '\n';
    }
    public void realizarPago(String numeroCuenta, double monto){
        
    }

    
}
