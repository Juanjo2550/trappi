
package com.epn.trappi.models.financiero;

import com.epn.trappi.db.financiero.FinancieroDb;
import java.util.ArrayList;


public class LibroDiario {
    ArrayList<Ingreso> ingresosRegistrados;
    ArrayList<Pago> pagosRegistrados;
    ArrayList<Devolucion> devolucionesRegistradas;
    public double calcularTotalIngresos(){
        double totalIngresos=0;
       for(Ingreso ingreso : this.obtenerIngresosRegistrados()){
           totalIngresos+=ingreso.total;
       }
        return totalIngresos;
    }
    public double calcularTotalPagos(){
        double totalPagos=0;
       for(Pago pago: this.obtenerPagosRegistrados()){
           totalPagos+=pago.monto;     
       }
        return totalPagos;
    }
    public double calcularTotalDevoluciones(){
        double devolucionTotal=0;
        for(Devolucion devolucion: this.obtenerDevolucionesRegistradas()){
            devolucionTotal+=devolucion.getValorDevolucion();
        }
        return devolucionTotal;
    }
    
    public void agregarIngreso(Ingreso ingreso){
        FinancieroDb ingresoBd =  new FinancieroDb();
        ingresoBd.insertarIngreso(ingreso);
    }
    public void agregarPago(Pago pago){
        FinancieroDb pagoDb = new FinancieroDb();
        pagoDb.insertarPago(pago);
    }
    public ArrayList<Ingreso> obtenerIngresosRegistrados(){
        FinancieroDb db = new FinancieroDb();
        this.ingresosRegistrados= new ArrayList<Ingreso>();
        this.ingresosRegistrados= db.consultarIngresosRegistrados();
        return ingresosRegistrados;
    }

    public ArrayList<Pago> obtenerPagosRegistrados(){
        FinancieroDb bd = new FinancieroDb();
        this.pagosRegistrados= new ArrayList<Pago>();
        this.pagosRegistrados=bd.consultarPagosRegistrados();
        return pagosRegistrados;
    }
    public ArrayList<Devolucion> obtenerDevolucionesRegistradas(){
        this.devolucionesRegistradas= new ArrayList<Devolucion>();
        FinancieroDb devoluciones = new FinancieroDb();
        this.devolucionesRegistradas=devoluciones.consultarDevolucionesRegistradas();
        return this.devolucionesRegistradas;
    }
}
