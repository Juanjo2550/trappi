
package com.epn.trappi.models.financiero;

import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.db.financiero.FinancieroDb;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;


public class Ingreso {
    Fecha fechaIngreso;
    String nroFactura;
    double total;
    LibroDiario libroDiario;
    public Ingreso(){
        
    }

    public Ingreso(String idFactura, double total, Fecha fecha) {
        this.fechaIngreso = fecha;
        this.nroFactura = idFactura;
        this.total = total;
    }

    public Ingreso(String nroFactura, double total) {
        this.nroFactura = nroFactura;
        this.total = total;
    }
    
    
    public void registrarIngreso(String nrofactura,double monto){
        //La instanciacion de Fecha inicializa la fecha con la actual.
        fechaIngreso = new Fecha();
        Ingreso ingreso = new Ingreso(nrofactura,monto,fechaIngreso);
        this.libroDiario=new LibroDiario();
        libroDiario.agregarIngreso(ingreso);
    }

    public Fecha getFechaIngreso() {
        return fechaIngreso;
    }

    public String getNroFactura() {
        return nroFactura;
    }

    public double getTotal() {
        return total;
    }
    
    
    @Override
    public String toString() {
        return "Ingreso: " + "Fecha de Ingreso: "+this.fechaIngreso+", idFactura=" + nroFactura + ", total=" + total + '\n';
    }
    
}
