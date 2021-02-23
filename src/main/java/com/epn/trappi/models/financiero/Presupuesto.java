
package com.epn.trappi.models.financiero;

public class Presupuesto {
    String estado="Sin solicitud";
    Analizador analizador;
    Pago pago;

    public Presupuesto(Pago pago) {
        this.pago = pago;
    }
    //El pago debe exisitir si aun no se autoriza?
    public String autorizarPago(Pago pago){
        String estado=this.estado;
        if(analizador.getPresupuesto()> pago.monto){
            estado="Aprobado";
            this.pago=pago;
            pago.registrarPago(pago);
        }
        if(analizador.getPresupuesto()< pago.monto){
            estado="Negado";
        }
        estado="Pendiente";
        return estado;
    }

}
