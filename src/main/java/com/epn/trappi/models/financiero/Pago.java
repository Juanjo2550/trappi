
package com.epn.trappi.models.financiero;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class  Pago {
    String fechadePago;
    LibroDiario libroDiario;
    String cuentaPagar;
    double monto;

    public Pago(String cuentaPagar, double monto, LibroDiario libroDiario) {
        this.libroDiario=libroDiario;
        this.cuentaPagar = cuentaPagar;
        this.monto = monto;
    }
    
    public void registrarPago(Pago pago){
        //Se obtiene la fecha del momento del pago
        Calendar fechaPagoObjeto = Calendar.getInstance(); 
        String dia = String.valueOf(fechaPagoObjeto.get(Calendar.DATE));
        String mes = String.valueOf(fechaPagoObjeto.get(Calendar.MONTH)+1);//se le suma uno debido a que enero es igual a cero
        String anio = String.valueOf(fechaPagoObjeto.get(Calendar.YEAR));
        fechadePago = dia+'/'+mes+'/'+anio;
        libroDiario.pagosRegistrados.add(pago);
    }
    
    @Override
    public String toString() {
        return "Pago: " + "fechadePago=" + fechadePago + ", cuentaPagar=" + cuentaPagar + ", monto=" + monto + '\n';
    }
    public void realizarPago(String numeroCuenta, double monto){
        
    }

    
}
