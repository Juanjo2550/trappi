/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.logistico.servicios;

import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.models.logistico.Entrega;
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
public class ServicioDbEntrega implements Consultable<Entrega>,Manipulable<Entrega>{
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
    public ArrayList<Entrega> obtenerElementos() throws SQLException {
        Statement sentencia = connection.getConnection().createStatement();
        ResultSet resultados = sentencia.executeQuery("SELECT * FROM ENTREGA");
        ArrayList<Entrega> entregas = new ArrayList<>();
        while(resultados.next()){
            Entrega entrega = new Entrega();
            entrega.setID_Entrega(resultados.getInt(1));
            entrega.setMatricula(resultados.getString(2));
            entrega.setFecha(resultados.getDate(3).toString());
            entrega.setEstado(resultados.getString(4));
            entrega.setFactura(resultados.getInt(5));
            entrega.setID_Empleado(resultados.getInt(6));
            //add all data
            entregas.add(entrega);
        }
        return entregas;
    }

    @Override
    public Entrega obtenerElemento(int llave_primaria) throws SQLException {
        Statement sentencia = connection.getConnection().createStatement();
        ResultSet resultados = sentencia.executeQuery("SELECT * FROM ENTREGA WHERE IDENTREGA='"+String.valueOf(llave_primaria)+"'");
        resultados.next();
        Entrega entrega = new Entrega();
            entrega.setID_Entrega(resultados.getInt(1));
            entrega.setMatricula(resultados.getString(2));
            entrega.setFecha(resultados.getDate(3).toString());
            entrega.setEstado(resultados.getString(4));
            entrega.setFactura(resultados.getInt(5));
            entrega.setID_Empleado(resultados.getInt(6));
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
    public ArrayList<Entrega> obtenerElementosPorFiltro(String COLUMN_NAME_CONSTANT, String VALOR) throws SQLException, Exception {
        Set<String> TABLAS= Set.of(ID_ENTREGA,MATRICULA,FECHA,ESTADO,FACTURA,ID_EMPLEADO);
        if(TABLAS.contains(COLUMN_NAME_CONSTANT)==false){
            throw new Exception("No existe esa columna en el sistema");
        }
        Statement sentencia = connection.getConnection().createStatement();
        ResultSet resultados;
        resultados=sentencia.executeQuery("SELECT * FROM ENTREGA WHERE "+COLUMN_NAME_CONSTANT+"='"+VALOR+"'");
        ArrayList<Entrega> entregas = new ArrayList<>();
        while(resultados.next()){
            Entrega entrega = new Entrega();
            entrega.setID_Entrega(resultados.getInt(1));
            entrega.setMatricula(resultados.getString(2));
            entrega.setFecha(resultados.getDate(3).toString());
            entrega.setEstado(resultados.getString(4));
            entrega.setFactura(resultados.getInt(5));
            entrega.setID_Empleado(resultados.getInt(6));
            //add all data
            entregas.add(entrega);
        }
        return entregas;
    }
    //METODO TEMPORAL
    public ArrayList<Entrega> añadirDirecciones(ArrayList<Entrega> entregas) throws SQLException{
        String lista_facturas="(";
        for (int i=0;i<entregas.size()-1;i++){
            lista_facturas=lista_facturas+entregas.get(i).getFactura()+",";
        }
        lista_facturas = lista_facturas+entregas.get(entregas.size()).getFactura()+")";
        Statement sentencia = connection.getConnection().createStatement();
        ResultSet direcciones;
        direcciones = sentencia.executeQuery("SELECT DIRECCION FROM FACTURAS WHERE NUMEROFACTURA IN "+lista_facturas);
        int index=0;
        while(direcciones.next()){
           entregas.get(index).setDireccion(direcciones.getString(1));
        }
        return entregas;
    }
}
