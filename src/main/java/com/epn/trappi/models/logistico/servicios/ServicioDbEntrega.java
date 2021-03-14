/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.logistico.servicios;

import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.models.logistico.Conductor;
import com.epn.trappi.models.logistico.Entrega;
import com.epn.trappi.models.logistico.Vehiculo;
import java.awt.List;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author Alexander
 */
public class ServicioDbEntrega implements Unible<Entrega>,ServicioDb<Entrega> {
    //Atributos
    DataBaseConnection connection;
    public static String ID_ENTREGA="ID";
    public static String MATRICULA="MATRICULA";
    public static String FECHA="FECHA";
    public static String ESTADO="ESTADO";
    public static String FACTURA="FACTURA";
    public static String ID_EMPLEADO="EMPLEADO";
    
    //Metodos
    public ServicioDbEntrega(){
        connection = DataBaseConnection.getInstance();
    }
    @Override
    public Consultable obtenerElementos() throws SQLException {
        Statement sentencia = connection.getConnection().createStatement();
        String columnas = ID_ENTREGA+","+MATRICULA+","+FECHA+","+ESTADO+","+FACTURA+","+ID_EMPLEADO+","+"DIRECCION";
        ResultSet resultados = sentencia.executeQuery("SELECT "+columnas+" FROM ENTREGA JOIN FACTURAS  ON ENTREGA.FACTURA=FACTURAS.IDFACTURA");
        ArrayList<Entrega> entregas = new ArrayList<>();
        while(resultados.next()){
            Entrega entrega = new Entrega();
            entrega.setID_Entrega(resultados.getInt(1));
            entrega.setMatricula(resultados.getString(2));
            entrega.setFecha(resultados.getDate(3).toString());
            entrega.setEstado(resultados.getString(4));
            entrega.setFactura(resultados.getInt(5));
            entrega.setID_Empleado(resultados.getInt(6));
            entrega.setDireccion(resultados.getString(7));
            entregas.add(entrega);
        }
        return new Consultable(entregas);
    }

    @Override
    public Entrega obtenerElemento(int llave_primaria) throws SQLException {
        Statement sentencia = connection.getConnection().createStatement();
        String columnas = ID_ENTREGA+","+MATRICULA+","+FECHA+","+ESTADO+","+FACTURA+","+ID_EMPLEADO+","+"DIRECCION";
        ResultSet resultados
                = sentencia.executeQuery("SELECT "+columnas+" FROM ENTREGA JOIN FACTURAS  ON ENTREGA.FACTURA=FACTURAS.IDFACTURA WHERE IDENTREGA='"+String.valueOf(llave_primaria)+"'");
        resultados.next();
        Entrega entrega = new Entrega();
            entrega.setID_Entrega(resultados.getInt(1));
            entrega.setMatricula(resultados.getString(2));
            entrega.setFecha(resultados.getDate(3).toString());
            entrega.setEstado(resultados.getString(4));
            entrega.setFactura(resultados.getInt(5));
            entrega.setID_Empleado(resultados.getInt(6));
            entrega.setDireccion(resultados.getString(7));
        return entrega;
    }

    @Override
    public void insertar(Entrega elemento) throws SQLException {
        CallableStatement statement = connection.getConnection().prepareCall("{call Ingresar_Entrega(?,?,?,?) }");
        statement.setString(1,elemento.getMatricula());
        statement.setString(2,elemento.getEstado());
        statement.setInt(3,elemento.getFactura());
        statement.setInt(4,elemento.getID_Empleado());
        statement.execute();
    }

    @Override
    public void actualizar(Entrega elemento) throws SQLException {
        CallableStatement statement = connection.getConnection().prepareCall("{call Actualizar_Entrega(?,?) }");
        statement.setInt(1,elemento.getID_Entrega());
        statement.setString(2,elemento.getEstado());
        statement.execute();
    }

    @Override
    public Consultable obtenerElementosPorFiltro(String COLUMN_NAME_CONSTANT, String VALOR) throws SQLException {
        Statement sentencia = connection.getConnection().createStatement();
        String columnas = ID_ENTREGA+","+MATRICULA+","+FECHA+","+ESTADO+","+FACTURA+","+ID_EMPLEADO+","+"DIRECCION";
        ResultSet resultados;
        if(COLUMN_NAME_CONSTANT.equalsIgnoreCase(FECHA)){
            String date_parts[] = VALOR.split("-|/");
            int año = Integer.parseInt(date_parts[0]);
            int mes = Integer.parseInt(date_parts[1]);
            int dia = Integer.parseInt(date_parts[2]);
            String consulta = "SELECT "+columnas+" FROM ENTREGA JOIN FACTURAS ON ENTREGA.FACTURA=FACTURAS.IDFACTURA " +
            "WHERE  DATEPART(yy, FECHA) = "+año;
            if(mes<=12 & mes>=1){
                consulta = consulta + " AND DATEPART(mm, FECHA) = "+mes;
            }
            if (dia<=31 & dia>=1){
                consulta = consulta + " AND DATEPART(dd, FECHA) = "+dia;
            }
            resultados
                    =sentencia.executeQuery(consulta);
        }else{
            resultados
                =sentencia.executeQuery("SELECT "+columnas+" FROM ENTREGA JOIN FACTURAS  ON ENTREGA.FACTURA=FACTURAS.IDFACTURA WHERE "+COLUMN_NAME_CONSTANT+"='"+VALOR+"'");
        }
        ArrayList<Entrega> entregas = new ArrayList<>();
        while(resultados.next()){
            Entrega entrega = new Entrega();
            entrega.setID_Entrega(resultados.getInt(1));
            entrega.setMatricula(resultados.getString(2));
            entrega.setFecha(resultados.getDate(3).toString());
            entrega.setEstado(resultados.getString(4));
            entrega.setFactura(resultados.getInt(5));
            entrega.setID_Empleado(resultados.getInt(6));
            entrega.setDireccion(resultados.getString(7));
            entregas.add(entrega);
        }
        return new Consultable(entregas);
    }
    //Retorna un Object o = ArrayList<Vehiculo>();
    @Override
    public Object join(ArrayList<Entrega> entregas,Consultable consultable) throws SQLException{
        ArrayList<String> foreign_keys = new ArrayList<>();
        Object unibleArrayList = new Object();
        
        Consultable consultableTest = consultable;
        if("Vehiculo".equals(consultableTest.getType())){
            for (int i=0;i<entregas.size();i++){
                foreign_keys.add(entregas.get(i).getMatricula());
            }
            ArrayList<Vehiculo> vehiculos = (ArrayList<Vehiculo>) consultableTest.getDatos();
            int dynamic_size= vehiculos.size();
            for (int i=0;i<dynamic_size;i++){
                String matricula = vehiculos.get(i).getMatricula();
                if (foreign_keys.contains(matricula)==false){
                    vehiculos.remove(i);
                    i=i-1;
                    dynamic_size=vehiculos.size();
                }
            }
            unibleArrayList = vehiculos;
        }
        if("Conductor".equals(consultable.getType())){
            for (int i=0;i<entregas.size();i++){
                foreign_keys.add(String.valueOf(entregas.get(i).getID_Empleado()));
            }
            ArrayList<Conductor> conductores = (ArrayList<Conductor>) consultable.getDatos();
            int dynamic_size= conductores.size();
            for (int i=0;i<dynamic_size;i++){
                String matricula = String.valueOf(conductores.get(i).getID());
                if (foreign_keys.contains(matricula)==false){
                    conductores.remove(i);
                    i=i-1;
                    dynamic_size=conductores.size();
                }
            }
            unibleArrayList = conductores;
        }
        return unibleArrayList;
    }
    
}
