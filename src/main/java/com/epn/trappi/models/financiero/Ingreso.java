
package com.epn.trappi.models.financiero;

public class Ingreso {
    Fecha fechaIngreso;
    int nroFactura;
    double total;
    LibroDiario libroDiario;
    public Ingreso(){
        
    }

    public Ingreso(int idFactura, double total, Fecha fecha) {
        this.fechaIngreso = fecha;
        this.nroFactura = idFactura;
        this.total = total;
    }

    public Ingreso(int nroFactura, double total) {
        this.nroFactura = nroFactura;
        this.total = total;
    }
    
    
    public void registrarIngreso(int numfactura,double monto){
        //La instanciacion de Fecha inicializa la fecha con la actual.
        fechaIngreso = new Fecha();
        Ingreso ingreso = new Ingreso(numfactura,monto,fechaIngreso);
        this.libroDiario=new LibroDiario();
        libroDiario.agregarIngreso(ingreso);
    }

    public Fecha getFechaIngreso() {
        return fechaIngreso;
    }

    public int getNroFactura() {
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
