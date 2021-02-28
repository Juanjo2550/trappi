
package com.epn.trappi.models.financiero;

import com.epn.trappi.db.connection.DataBaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class Main {
    public static void main(String[] args){
//        LibroDiario libroDiario = new LibroDiario();
//        Ingreso ingreso1 = new Ingreso("1001354", 500, libroDiario);
//        Ingreso ingreso2 = new Ingreso("1001354", 30, libroDiario);
//        Ingreso ingreso3 = new Ingreso("1001354", 52, libroDiario);
//        Ingreso ingreso4 = new Ingreso("1001354", 65, libroDiario);
//        Ingreso ingreso5 = new Ingreso("1001354", 160, libroDiario);
//        Ingreso ingreso6 = new Ingreso("1001354", 350, libroDiario);
//        Pago pago1 = new Pago(libroDiario,"102345", 480);
//        Pago pago2 = new Pago(libroDiario,"102345", 126);
//        Pago pago3 = new Pago(libroDiario,"102345", 1500);
//        Pago pago4 = new Pago(libroDiario,"102345", 60);
//        Pago pago5 = new Pago(libroDiario,"102345", 88);
//        Pago pago6 = new Pago(libroDiario,"102345", 100);
//        ingreso1.registrarIngreso(ingreso1);
//        ingreso2.registrarIngreso(ingreso2);
//        ingreso3.registrarIngreso(ingreso3);
//        ingreso4.registrarIngreso(ingreso4);
//        ingreso5.registrarIngreso(ingreso5);
//        ingreso6.registrarIngreso(ingreso6);
//        pago1.registrarPago(pago1);
//        pago2.registrarPago(pago2);
//        pago3.registrarPago(pago3);
//        pago4.registrarPago(pago4);
//        pago5.registrarPago(pago5);
//        pago6.registrarPago(pago6);
//        pago1.realizarPago(pago1);
//        for(Pago pago: libroDiario.pagosRegistrados){
//            System.out.println(pago.toString());
//        }
//        for(Ingreso ingreso: libroDiario.ingresosRegistrados){
//            System.out.println(ingreso.toString());
//        }
//        Analizador analizador = new Analizador(libroDiario);
//        System.out.println("Gasto Maximo Mensual: "+analizador.calcularGastoMaximo(libroDiario.pagosRegistrados));
//        System.out.println("Gasto Minimo Mensual: "+analizador.calcularGastoMinimo(libroDiario.pagosRegistrados));
//        System.out.println("Ingreso Maximo Mensual: "+analizador.calcularIngresoMaximo(libroDiario.ingresosRegistrados));
//        System.out.println("Ingreso Minimo Mensual: "+analizador.calcularIngresoMinimo(libroDiario.ingresosRegistrados));
   
    
      DataBaseConnection dbInstance = DataBaseConnection.getInstance();
        Connection connection = dbInstance.getConnection();
        try{
        Statement statement = connection.createStatement();
        //String sql = "INSERT INTO dbo.INGRESO VALUES(1,1,'12345',400,28,02,2021)";
       // String sql = "INSERT INTO dbo.LIBRODIARIO VALUES(1)";
//       String sql = "SELECT * FROM dbo.INGRESO";
//        ResultSet resultSet = statement.executeQuery(sql);
//            System.out.println(resultSet.next());
//        while(resultSet.next()){
//            System.out.println("Está entrando");
//            String dato = String.valueOf(resultSet.getInt(1));
//             String dato1 = String.valueOf(resultSet.getInt(2));
//              String dato2 = resultSet.getString(3);
//               String dato3 = String.valueOf(resultSet.getDouble(4));
//                String dato4 = String.valueOf(resultSet.getInt(5));
//                 String dato5 = String.valueOf(resultSet.getInt(6));
//                  String dato6 = String.valueOf(resultSet.getInt(7));
//            System.out.println("Consulta = "+dato+dato1+dato2+dato3+dato4+dato5+dato6);
//        }
        
        //String sql = "INSERT INTO dbo.PAGO VALUES(1,1,'12345',150,28,02,2021)";
        //statement.executeUpdate(sql);
        String sql = "SELECT * FROM dbo.PAGO";
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            System.out.println("Está entrando");
            String dato = String.valueOf(resultSet.getInt(1));
             String dato1 = String.valueOf(resultSet.getInt(2));
              String dato2 = resultSet.getString(3);
               String dato3 = String.valueOf(resultSet.getDouble(4));
                String dato4 = String.valueOf(resultSet.getInt(5));
                 String dato5 = String.valueOf(resultSet.getInt(6));
                  String dato6 = String.valueOf(resultSet.getInt(7));
            System.out.println("Consulta = "+dato+dato1+dato2+dato3+dato4+dato5+dato6);
        }
        }catch( Exception e){
            System.out.println(e);
            
        }
    
    
    }
}
