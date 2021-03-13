package com.epn.trappi.db.financiero;

import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.models.financiero.Devolucion;
import com.epn.trappi.models.financiero.Fecha;
import com.epn.trappi.models.financiero.Ingreso;
import com.epn.trappi.models.financiero.LibroDiario;
import com.epn.trappi.models.financiero.Pago;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class FinancieroDb {
    DataBaseConnection dbInstance = DataBaseConnection.getInstance();
    Connection connection = dbInstance.getConnection();
    LibroDiario libroDiario = new LibroDiario();
    
    
    public ArrayList<Ingreso> consultarIngresosRegistrados(){
        ArrayList<Ingreso> ingresosRegistrados = new ArrayList<Ingreso>();
        try{
        Statement statement = connection.createStatement();
        String sql = "Select NROFACTURA2, TOTAL3, DIAINGRESO2, MESINGRESO2, ANIOINGRESO2 from dbo.INGRESO";
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            Fecha fecha = new Fecha(resultSet.getInt(3),resultSet.getInt(4),resultSet.getInt(5));
            Ingreso ingresotemporal = new Ingreso(resultSet.getInt(1),resultSet.getDouble(2),fecha);
            ingresosRegistrados.add(ingresotemporal);           
        }
        }catch( Exception e){
            System.out.println(e);
        }
        return ingresosRegistrados;
    }
    public void insertarIngreso(Ingreso ingreso){
        try{
            Statement statement = this.connection.createStatement();
            String sql = "insert into dbo.INGRESO values ("+(this.consultarIngresosRegistrados().size()+1)+",1,'"+
                ingreso.getNroFactura()+"',"+ingreso.getTotal()+","+ingreso.getFechaIngreso().devolverDia()+","+
                ingreso.getFechaIngreso().devolverMes()+","+ingreso.getFechaIngreso().devolverAnio()+"  );";
            statement.executeUpdate(sql);
            System.out.println("Se registró ingreso");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void insertarPago(Pago pago){
        try{
        Statement statement = connection.createStatement();
        String sql = "INSERT INTO dbo.PAGO VALUES("+(this.consultarPagosRegistrados().size()+1)+
                ",1,'"+pago.getNroCuenta()+"',"+pago.getMonto()+","+pago.getFechadePago().devolverDia()+
                ","+pago.getFechadePago().devolverMes()+","+pago.getFechadePago().devolverAnio()+")";
        statement.executeUpdate(sql);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void insertarDevolucion(Devolucion devolucion){
        try{
        Statement statement = connection.createStatement();
        String sql = "INSERT INTO dbo.DEVOLUCION VALUES("+(this.consultarDevolucionesRegistradas().size()+1)+
                ","+devolucion.getNroFactura()+","+devolucion.getValorDevolucion()+","+devolucion.getFechaDeDevolucion().devolverDia()+
                ","+devolucion.getFechaDeDevolucion().devolverMes()+","+devolucion.getFechaDeDevolucion().devolverAnio()+")";
        statement.executeUpdate(sql);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void removerIngreso(Ingreso ingreso){
        try{
            Statement statement = this.connection.createStatement();
            String sql = "delete from dbo.INGRESO where NROFACTURA2 like '"+ingreso.getNroFactura()+"';";
            statement.executeUpdate(sql);
            System.out.println("Se eliminó ingreso");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void removerPago(Pago pago){
        try{
            Statement statement = this.connection.createStatement();
            String sql = "delete from dbo.PAGO where NROCUENTA like '"+pago.getNroCuenta()+"';";
            statement.executeUpdate(sql);
            System.out.println("Se eliminó PAGO");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void removerDevolucion(Devolucion devolucion){
        try{
            Statement statement = this.connection.createStatement();
            String sql = "delete from dbo.DEVOLUCION where nroFactura="+devolucion.getNroFactura()+";";
            statement.executeUpdate(sql);
            System.out.println("Se eliminó DEVOLUCION");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public ArrayList<Pago> consultarPagosRegistrados(){
        ArrayList<Pago> pagosRegistrados = new ArrayList<Pago>();
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
    public ArrayList<Devolucion> consultarDevolucionesRegistradas(){
        ArrayList<Devolucion> deovolucionesRegistradas = new ArrayList<Devolucion>();
        try{
        Statement statement = connection.createStatement();
        String sql = "Select nroFactura, valorDevolucion, diaDevolucion, mesDevolucion, anioDevolucion from dbo.DEVOLUCION";
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            Fecha fecha = new Fecha(resultSet.getInt(3),resultSet.getInt(4),resultSet.getInt(5));
            Devolucion devoluciontemporal = new Devolucion(fecha,resultSet.getInt(1),resultSet.getDouble(2));
            deovolucionesRegistradas.add(devoluciontemporal);           
        }
        }catch( Exception e){
            System.out.println(e);
        }
        return deovolucionesRegistradas;
    }
    public double consultarFacturaPorNroFactura(int nroFactura){
        double valorADevolver=0;
        try{
        Statement statement = connection.createStatement();
        String sql = "select TOTAL from dbo.FACTURAS WHERE NUMEROFACTURA="+nroFactura;
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            valorADevolver=resultSet.getInt(1);
            System.out.println("El valor a devolver es:"+String.valueOf(valorADevolver));
        }
        }catch( Exception e){
            System.out.println(e);
        }
        return valorADevolver;
    }
    public void acutalizarEstadoFactura(int idFactura){
        try{
        Statement statement = connection.createStatement();
        String sql = "update dbo.FACTURAS set ESTADODEVOLUCION='DEVOLUCION REALIZADA' WHERE NUMEROFACTURA="+idFactura;
        statement.executeUpdate(sql);
            System.out.println("Estado devolucion cambiado con éxito");
        }catch( Exception e){
            System.out.println(e);
        }
    }
}
