
package com.epn.trappi.models.financiero;

import com.epn.trappi.db.connection.DataBaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class LibroDiario {
    ArrayList<Ingreso> ingresosRegistrados=new ArrayList<Ingreso>();
    ArrayList<Pago> pagosRegistrados = new ArrayList<Pago>();
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
    
    public ArrayList<Ingreso> obtenerIngresosRegistrados(){
        ArrayList<Ingreso> ingresosRegistrados = new ArrayList<Ingreso>();
        DataBaseConnection dbInstance = DataBaseConnection.getInstance();
        Connection connection = dbInstance.getConnection();
        try{
        Statement statement = connection.createStatement();
        String sql = "Select NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2 from dbo.INGRESO";
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            Fecha fecha = new Fecha(resultSet.getInt(3),resultSet.getInt(4),resultSet.getInt(5));
            Ingreso ingresotemporal = new Ingreso(resultSet.getString(1),resultSet.getDouble(2),fecha);
            ingresosRegistrados.add(ingresotemporal);           
        }
        }catch( Exception e){
            System.out.println(e);
        }
        return ingresosRegistrados;
    }

    public ArrayList<Pago> obtenerPagosRegistrados(){
        ArrayList<Pago> pagosRegistrados = new ArrayList<Pago>();
        DataBaseConnection dbInstance = DataBaseConnection.getInstance();
        Connection connection = dbInstance.getConnection();
        try{
        Statement statement = connection.createStatement();
        String sql = "Select NROCUENTA, MONTO, DIAPAGO, MESPAGO, ANIOPAGO from dbo.PAGO";
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            Fecha fecha = new Fecha(resultSet.getInt(3),resultSet.getInt(4),resultSet.getInt(5));
            Pago pagotemporal = new Pago(fecha,resultSet.getString(1),resultSet.getDouble(2));
            pagosRegistrados.add(pagotemporal);           
        }
        }catch( Exception e){
            System.out.println(e);
        }
        return pagosRegistrados;
    }
}
