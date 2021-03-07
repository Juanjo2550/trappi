
package com.epn.trappi.models.financiero;

import com.epn.trappi.db.connection.DataBaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;


public class Ingreso {
    Fecha fechaIngreso;
    String nroFactura;
    double total;
    private LibroDiario libroDiario;
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
    
    
    public void registrarIngreso(Ingreso ingreso){
        //La instanciacion de Fecha inicializa la fecha con la actual.
        fechaIngreso = new Fecha();
        this.libroDiario=new LibroDiario();
        DataBaseConnection dbInstance = DataBaseConnection.getInstance();
        Connection connection = dbInstance.getConnection();
        try{
        Statement statement = connection.createStatement();
        String sql = "insert into dbo.INGRESO values ("+(this.libroDiario.obtenerIngresosRegistrados().size()+1)+",1,'"+
                ingreso.nroFactura+"',"+ingreso.total+","+ingreso.fechaIngreso.devolverDia()+","+
                ingreso.fechaIngreso.devolverMes()+","+ingreso.fechaIngreso.devolverAnio()+"  );";
        statement.executeUpdate(sql);
        System.out.println("Se registró ingreso");
        this.libroDiario.ingresosRegistrados.add(ingreso);
        }catch( Exception e){
            System.out.println(e);
            
        }
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
