
package com.epn.trappi.models.financiero;

import com.epn.trappi.db.connection.DataBaseConnection;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import com.epn.trappi.models.rrhh.diego.SolicitudDePago;

public class  Pago {
    Fecha fechadePago;
    LibroDiario libroDiario;
    String nroCuenta;
    double monto;
    Presupuesto presupuesto;
    SolicitudDePago solicitudPago;
    public Pago(Fecha fechadePago, String nroCuenta, double monto) {
        this.fechadePago = fechadePago;
        this.nroCuenta = nroCuenta;
        this.monto = monto;
    }

    public Pago(String nroCuenta, double monto) {
        this.fechadePago=new Fecha();
        this.nroCuenta = nroCuenta;
        this.monto = monto;
    }
    
    


    private void verificarSolicitudesdePago() throws Exception{
        this.solicitudPago=new SolicitudDePago();
        for(SolicitudDePago solicitud: this.solicitudPago.SolicitarPago()){
            Pago pago = new Pago(solicitud.getCuentaBancaria(), solicitud.getMontoTotal() );
            solicitud.setEstado(pago.realizarPago(pago));
        }
    }
    private void registrarPago(Pago pago){

    DataBaseConnection dbInstance = DataBaseConnection.getInstance();
        Connection connection = dbInstance.getConnection();
        try{
        Statement statement = connection.createStatement();
        String sql = "INSERT INTO dbo.PAGO VALUES("+(this.libroDiario.obtenerPagosRegistrados().size()+1)+
                ",1,'"+pago.nroCuenta+"',"+pago.monto+","+pago.fechadePago.devolverDia()+
                ","+pago.fechadePago.devolverMes()+","+pago.fechadePago.devolverAnio()+")";
        statement.executeUpdate(sql);
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    public String realizarPago(Pago pago){
        this.libroDiario=new LibroDiario();
        this.presupuesto=new Presupuesto(this.libroDiario);
        String estadoSolicitud="No realizado";
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

    public Fecha getFechadePago() {
        return fechadePago;
    }

    public String getNroCuenta() {
        return nroCuenta;
    }

    public double getMonto() {
        return monto;
    }

    
}
