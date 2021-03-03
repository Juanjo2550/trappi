/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.logistico.servicios;

import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.models.logistico.Conductor;
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
public class ServicioDbConductor implements Consultable<Conductor>,ManipulableConductor<Conductor>{
    //Atributos
    DataBaseConnection connection;
    public static String ID_CONDUCTOR="IDEMP";
    public static String ESTADO="ESTADOEMP";
    //Metodos
    public ServicioDbConductor(){
        connection = DataBaseConnection.getInstance();
    }
    @Override
    public ArrayList<Conductor> obtenerElementos() throws SQLException {
        Statement sentencia = connection.getConnection().createStatement();
        ResultSet resultados = sentencia.executeQuery("SELECT IDEMP,ESTADOEMP FROM EMPLEADO");
        ArrayList<Conductor> elementos = new ArrayList<>();
        while(resultados.next()){
            Conductor elemento = new Conductor();
            elemento.setID(resultados.getInt(1));
            elemento.setEstado(resultados.getString(2));
            //add all data
            elementos.add(elemento);
        }
        return elementos;
    }

    @Override
    public Conductor obtenerElemento(int llave_primaria) throws SQLException {
        Statement sentencia = connection.getConnection().createStatement();
        ResultSet resultados = sentencia.executeQuery("SELECT IDEMP,ESTADOEMP FROM EMPLEADO WHERE IDEMP="+llave_primaria);
        resultados.next();
            Conductor elemento = new Conductor();
            elemento.setID(resultados.getInt(1));
            elemento.setEstado(resultados.getString(2));
        return elemento;
    }

    @Override
    public void actualizar(Conductor elemento) throws SQLException {
        CallableStatement statement = connection.getConnection().prepareCall("{call Actualizar_Conductor  (?,?) }");
        statement.setInt(1,elemento.getID());
        statement.setString(2,elemento.getEstado());
        statement.execute();
    }

    @Override
    public ArrayList<Conductor> obtenerElementosPorFiltro(String COLUMN_NAME_CONSTANT, String VALOR) throws SQLException, Exception {
        Set<String> TABLAS = Set.of(ID_CONDUCTOR,ESTADO);
        if(TABLAS.contains(COLUMN_NAME_CONSTANT)==false){
            throw new Exception("No existe esa columna en el sistema");
        }
        Statement sentencia = connection.getConnection().createStatement();
        ResultSet resultados;
        resultados=sentencia.executeQuery("SELECT * FROM EMPLEADO WHERE "+COLUMN_NAME_CONSTANT+"='"+VALOR+"'");
         ArrayList<Conductor> elementos = new ArrayList<>();
        while(resultados.next()){
            Conductor elemento = new Conductor();
            elemento.setID(resultados.getInt(1));
            elemento.setEstado(resultados.getString(2));
            //add all data
            elementos.add(elemento);
        }
        return elementos;
    }
  
}
