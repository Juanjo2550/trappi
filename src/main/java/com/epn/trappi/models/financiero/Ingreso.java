
package com.epn.trappi.models.financiero;

import com.epn.trappi.db.connection.DataBaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;


public class Ingreso {
    Fecha fechaIngreso;
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

    public Ingreso(String idFactura, double total, Fecha fecha) {
        this.fechaIngreso = fecha;
        this.idFactura = idFactura;
        this.total = total;
    }
    
    
    public void registrarIngreso(Ingreso ingreso){
        //La instanciacion de Fecha inicializa la fecha con la actual.
        fechaIngreso = new Fecha();
        this.libroDiario.ingresosRegistrados.add(ingreso);
        DataBaseConnection dbInstance = DataBaseConnection.getInstance();
        Connection connection = dbInstance.getConnection();
        try{
        Statement statement = connection.createStatement();
        String sql = "insert into dbo.INGRESO values (idIngreso,'"+ingreso.idFactura+"',"+ingreso.total+","+ingreso.fechaIngreso.devolverDia()+","+ingreso.fechaIngreso.devolverMes()+","+ingreso.fechaIngreso.devolverAnio()+"  );";
        statement.executeUpdate(sql);
        System.out.println("Se registró ingreso");
        }catch( Exception e){
            System.out.println(e);
            
        }
    }

    public Fecha getFechaIngreso() {
        return fechaIngreso;
    }

    public String getIdFactura() {
        return idFactura;
    }

    public double getTotal() {
        return total;
    }
    
    
    @Override
    public String toString() {
        return "Ingreso: " + "Fecha de Ingreso: "+this.fechaIngreso+", idFactura=" + idFactura + ", total=" + total + '\n';
    }
    
}
