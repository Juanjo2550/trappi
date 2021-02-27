
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
        for(Ingreso ingreso:ingresosRegistrados){
            totalIngresos+=ingreso.total;
        }
        return totalIngresos;
    }
    public double calcularTotalPagos(){
        double totalPagos=0;
        for(Pago pago:pagosRegistrados){
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
        String sql = "Select nroFactura, total, diaIngreso, mesIngreso, anioIngreso from Ingreso";
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            Fecha fecha = new Fecha(resultSet.getInt(2),resultSet.getInt(3),resultSet.getInt(4));
            Ingreso ingresotemporal = new Ingreso(resultSet.getString("nroFactura"),resultSet.getDouble("total"),fecha);
            ingresosRegistrados.add(ingresotemporal);           
        }
        System.out.println(resultSet);
        }catch( Exception e){

        }
        return ingresosRegistrados;
    }

}
