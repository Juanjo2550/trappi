/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.logistico.servicios;

import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.models.logistico.Mantenimiento;
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
public class ServicioDbMantenimiento implements Consultable<Mantenimiento>,Manipulable<Mantenimiento>{
    //Atributos
    DataBaseConnection connection;
    public static String ID_MANTENIMIENTO="IDMANTENIMIENTO";
    public static String MATRICULA="MATRICULA";
    public static String DETALLE="DETALLEMANTENIMIENTO";
    public static String GASTO="VALORGASTO";
    //Metodos
    public ServicioDbMantenimiento(){
        connection = DataBaseConnection.getInstance();
    }
    @Override
    public ArrayList<Mantenimiento> obtenerElementos() throws SQLException {
        Statement sentencia = connection.getConnection().createStatement();
        ResultSet resultados = sentencia.executeQuery("SELECT * FROM MANTENIMIENTO");
        ArrayList<Mantenimiento> elementos = new ArrayList<>();
        while(resultados.next()){
            Mantenimiento elemento = new Mantenimiento();
            elemento.setIdMantenimiento(resultados.getInt(1));
            elemento.setMatricula(resultados.getString(2));
            elemento.setDetalleMantenimiento(resultados.getString(3));
            elemento.setValorGasto(resultados.getDouble(4));
            //add all data
            elementos.add(elemento);
        }
        return elementos;
    }

    @Override
    public Mantenimiento obtenerElemento(int llave_primaria) throws SQLException {
        Statement sentencia = connection.getConnection().createStatement();
        ResultSet resultados = sentencia.executeQuery("SELECT * FROM MANTENIMIENTO WHERE IDMANTENIMIENTO="+llave_primaria);
        resultados.next();
            Mantenimiento elemento = new Mantenimiento();
            elemento.setIdMantenimiento(resultados.getInt(1));
            elemento.setMatricula(resultados.getString(2));
            elemento.setDetalleMantenimiento(resultados.getString(3));
            elemento.setValorGasto(resultados.getDouble(4));
        return elemento;
    }

    @Override
    public void insertar(Mantenimiento elemento) throws SQLException {
        CallableStatement statement = connection.getConnection().prepareCall("{call Ingresar_Mantenimiento(?,?,?,?) }");
        statement.setInt(1,elemento.getIdMantenimiento());
        statement.setString(2,elemento.getMatricula());
        statement.setString(3,elemento.getDetalleMantenimiento());
        statement.setDouble(4,elemento.getValorGasto());
        statement.execute();
    }

    @Override
    public void actualizar(Mantenimiento elemento) throws SQLException {
        CallableStatement statement = connection.getConnection().prepareCall("{call Actualizar_Mantenimiento(?,?) }");
        statement.setInt(1,elemento.getIdMantenimiento());
        statement.setDouble(2,elemento.getValorGasto());
        statement.execute();
    }

    @Override
    public ArrayList<Mantenimiento> obtenerElementosPorFiltro(String COLUMN_NAME_CONSTANT, String VALOR) throws SQLException, Exception {
        Set<String> TABLAS = Set.of(ID_MANTENIMIENTO,MATRICULA,DETALLE,GASTO);
        if(TABLAS.contains(COLUMN_NAME_CONSTANT)==false){
            throw new Exception("No existe esa columna en el sistema");
        }
        Statement sentencia = connection.getConnection().createStatement();
        ResultSet resultados;
        resultados=sentencia.executeQuery("SELECT * FROM MANTENIMIENTO WHERE "+COLUMN_NAME_CONSTANT+"='"+VALOR+"'");
         ArrayList<Mantenimiento> elementos = new ArrayList<>();
        while(resultados.next()){
            Mantenimiento elemento = new Mantenimiento();
            elemento.setIdMantenimiento(resultados.getInt(1));
            elemento.setMatricula(resultados.getString(2));
            elemento.setDetalleMantenimiento(resultados.getString(3));
            elemento.setValorGasto(resultados.getDouble(4));
            //add all data
            elementos.add(elemento);
        }
        return elementos;
    }

}
