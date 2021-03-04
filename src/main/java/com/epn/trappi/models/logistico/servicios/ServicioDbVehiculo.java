/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.logistico.servicios;

import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.models.logistico.EnEspera;
import com.epn.trappi.models.logistico.Estado;
import com.epn.trappi.models.logistico.Habilitado;
import com.epn.trappi.models.logistico.Vehiculo;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.lang.Exception;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Set;
/**
 *
 * @author Alexander
 */
public class ServicioDbVehiculo implements Consultable<Vehiculo>,Manipulable<Vehiculo>{
    //Atributos
    DataBaseConnection connection;
    public static String ID_VEHICULO="ID";
    public static String MATRICULA="MATRICULA";
    public static String ESTADO="ESTADO";
    public static String TIPO="TIPOVEHICULO";
    public static String KILOMETRAJE="KILOMETRAJE";
    //Metodos
    public ServicioDbVehiculo(){
        connection = DataBaseConnection.getInstance();
    }
    @Override
    public ArrayList<Vehiculo> obtenerElementos() throws SQLException {
        Statement sentencia = connection.getConnection().createStatement();
        ResultSet resultados = sentencia.executeQuery("SELECT * FROM VEHICULO");
        ArrayList<Vehiculo> elementos = new ArrayList<>();
        while(resultados.next()){
            Vehiculo elemento = new Vehiculo();
            elemento.setMatricula(resultados.getString(1));
            String estado = resultados.getString(2);
            Estado estado_vehiculo;
            if(estado.equals("Ocupado")){
                estado_vehiculo = new EnEspera();
            }else{
                estado_vehiculo = new Habilitado();
            }
            elemento.setEstado(estado_vehiculo);
            elemento.setTipo(resultados.getString(3));
            elemento.setKilometraje(resultados.getInt(4));
            elemento.setID(resultados.getInt(5));
            //add all data
            elementos.add(elemento);
        }
        return elementos;
    }

    @Override
    public Vehiculo obtenerElemento(int llave_primaria) throws SQLException {
        Statement sentencia = connection.getConnection().createStatement();
        ResultSet resultados = sentencia.executeQuery("SELECT * FROM VEHICULO WHERE ID='"+String.valueOf(llave_primaria)+"'");
        resultados.next();
            Vehiculo elemento = new Vehiculo();
            elemento.setMatricula(resultados.getString(1));
            Estado estado_vehiculo = new EnEspera(resultados.getString(2));
            elemento.setEstado(estado_vehiculo);
            elemento.setTipo(resultados.getString(3));
            elemento.setKilometraje(resultados.getInt(4));
            elemento.setID(resultados.getInt(5));
        return elemento;
    }

    @Override
    public void insertar(Vehiculo elemento) throws SQLException {
        CallableStatement statement = connection.getConnection().prepareCall("{call Ingresar_Vehiculo(?,?,?,?) }");
        statement.setString(1,elemento.getMatricula());
        statement.setString(2,elemento.getEstado().toString());
        statement.setString(3,elemento.getTipo());
        statement.setInt(4,elemento.getKilometraje());
        statement.execute();
    }

    @Override
    public void actualizar(Vehiculo elemento) throws SQLException {
        CallableStatement statement = connection.getConnection().prepareCall("{call Actualizar_Vehiculo(?,?,?) }");
        statement.setInt(1,elemento.getID());
        statement.setString(2,elemento.getEstado().toString());
        statement.setInt(3,elemento.getKilometraje());
        statement.execute();
    }

    @Override
    public ArrayList<Vehiculo> obtenerElementosPorFiltro(String COLUMN_NAME_CONSTANT, String VALOR) throws SQLException, Exception {
        Set<String> TABLAS = Set.of(ID_VEHICULO,MATRICULA,ESTADO,TIPO,KILOMETRAJE);
        if(TABLAS.contains(COLUMN_NAME_CONSTANT)==false){
            throw new Exception("No existe esa columna en el sistema");
        }
        Statement sentencia = connection.getConnection().createStatement();
        ResultSet resultados;
        resultados=sentencia.executeQuery("SELECT * FROM VEHICULO WHERE "+COLUMN_NAME_CONSTANT+"='"+VALOR+"'");
         ArrayList<Vehiculo> elementos = new ArrayList<>();
        while(resultados.next()){
            Vehiculo elemento = new Vehiculo();
            elemento.setMatricula(resultados.getString(1));
            Estado estado_vehiculo = new EnEspera(resultados.getString(2));
            elemento.setEstado(estado_vehiculo);
            elemento.setTipo(resultados.getString(3));
            elemento.setKilometraje(resultados.getInt(4));
            elemento.setID(resultados.getInt(5));
            //add all data
            elementos.add(elemento);
        }
        return elementos;
    }

}
