/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.controladores.logistico;

import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.models.logistico.Conductor;
import com.epn.trappi.models.logistico.Entrega;
import com.epn.trappi.models.logistico.Estado;
import com.epn.trappi.models.logistico.Habilitado;
import com.epn.trappi.models.logistico.Mantenimiento;
import com.epn.trappi.models.logistico.Vehiculo;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alexander
 */
public class storedProcedures {
    //ATRIBUTOS
    DataBaseConnection connection = DataBaseConnection.getInstance();
    //METODOS
    public DefaultTableModel consultarTablaColumna(String tabla,String columna,String valor) throws SQLException{
        CallableStatement statement = connection.getConnection().prepareCall("{ call InsertData(?,?,?) }");
        statement.setString(1,tabla);
        statement.setString(2,columna);
        statement.setString(3,valor);
        ResultSet resultados = statement.executeQuery();
        ResultSetMetaData informacion_tabla = resultados.getMetaData();
        int num_columnas = informacion_tabla.getColumnCount();
        DefaultTableModel modelo = new DefaultTableModel();
        for (int i=1;i<=num_columnas;i++){
            modelo.addColumn(informacion_tabla.getColumnName(i));
        }
        String[] registro = new String[num_columnas];
        while(resultados.next()){
            for (int indice_columna=1;indice_columna<=num_columnas;indice_columna++){
                Object valor_registro = resultados.getObject(indice_columna);
                String cadena = valor_registro.toString();
                registro[indice_columna-1]=cadena;
            }
            modelo.addRow(registro);
        }
        return modelo;
    }
    public Vehiculo obtenerVehiculoAsignado(String tabla,String columna,String valor) throws SQLException{
        CallableStatement statement = connection.getConnection().prepareCall("{ call InsertData(?,?,?) }");
        statement.setString(1,tabla);
        statement.setString(2,columna);
        statement.setString(3,valor);
        ResultSet resultados = statement.executeQuery();
        ResultSetMetaData informacion_tabla = resultados.getMetaData();
        int num_columnas = informacion_tabla.getColumnCount();
        String[] registro_vehiculo = new String[num_columnas];
        resultados.next();
        for (int indice_columna=1;indice_columna<=num_columnas;indice_columna++){
                Object valor_registro = resultados.getObject(indice_columna);
                String cadena = valor_registro.toString();
                registro_vehiculo[indice_columna-1]=cadena;
        }
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setMatricula(registro_vehiculo[0]);
        vehiculo.setTipo(registro_vehiculo[2]);
        vehiculo.setKilometraje(Integer.parseInt(registro_vehiculo[3]));
        return vehiculo;
    }
    public String obtenerConductorAsignado(String tabla,String columna,String valor) throws SQLException{
        CallableStatement statement = connection.getConnection().prepareCall("{ call InsertData(?,?,?) }");
        statement.setString(1,tabla);
        statement.setString(2,columna);
        statement.setString(3,valor);
        ResultSet resultados = statement.executeQuery();
        ResultSetMetaData informacion_tabla = resultados.getMetaData();
        int num_columnas = informacion_tabla.getColumnCount();
        String ID_Conductor; 
        resultados.next();
        Object valor_registro = resultados.getObject(1);
        ID_Conductor = valor_registro.toString();
        return ID_Conductor;
        //SELECT * FROM EMPLEADO WHERE Estado=Disponible
    }
    public DefaultTableModel selectColumnasEnUnionPorValor(String TABLA1,String TABLA2,String COLUMNA1,String COLUMNA2,String WHERE_COLUMNA,
            String WHERE_VALOR,String[] COLUMNAS_SELECT) throws SQLException{
        CallableStatement statement = connection.getConnection().prepareCall("{ call selectColumnsJoinOnValue(?,?,?,?,?,?,?) }");
        String column_names="";
        int indice;
        for (indice=0;(indice<COLUMNAS_SELECT.length-1);indice++){
            column_names=column_names+COLUMNAS_SELECT[indice]+",";
        }
        column_names=column_names+COLUMNAS_SELECT[indice];
        statement.setString(1,TABLA1);
        statement.setString(2,TABLA2);
        statement.setString(3,COLUMNA1);
        statement.setString(4,COLUMNA2);
        statement.setString(5,WHERE_COLUMNA);
        statement.setString(6,WHERE_VALOR);
        statement.setString(7,column_names);
        //Generación del modelo de tabla
        ResultSet resultados = statement.executeQuery();
        ResultSetMetaData informacion_tabla = resultados.getMetaData();
        int num_columnas = informacion_tabla.getColumnCount();
        DefaultTableModel modelo = new DefaultTableModel();
        for (int i=1;i<=num_columnas;i++){
            modelo.addColumn(informacion_tabla.getColumnName(i));
        }
        String[] registro = new String[num_columnas];
        while(resultados.next()){
            for (int indice_columna=1;indice_columna<=num_columnas;indice_columna++){
                Object valor_registro = resultados.getObject(indice_columna);
                String cadena = valor_registro.toString();
                registro[indice_columna-1]=cadena;
            }
            modelo.addRow(registro);
        }
        return modelo;
    }
    
    public ArrayList<String[]> consultarUsosPorVehiculo(String matricula) throws SQLException{
        CallableStatement statement = connection.getConnection().prepareCall("{ call usosVehiculo(?) }");
        statement.setString(1,matricula);
        ResultSet resultados = statement.executeQuery();
        //
        ResultSetMetaData informacion_tabla = resultados.getMetaData();
        int num_columnas = informacion_tabla.getColumnCount();
        ArrayList<String[]> registros = new ArrayList<>();
        String[] registro = new String[num_columnas];
        while(resultados.next()){
            for (int indice_columna=1;indice_columna<=num_columnas;indice_columna++){
                Object valor_registro = resultados.getObject(indice_columna);
                String cadena = valor_registro.toString();
                registro[indice_columna-1]=cadena;
            }
            registros.add(registro);
        }
        return registros;}
    
    public void ingresarMantenimiento(Mantenimiento mantenimiento) throws SQLException{
        CallableStatement statement = connection.getConnection().prepareCall("{call Ingresar_Mantenimiento(?,?,?,?) }");
        statement.setInt(1,mantenimiento.getIdMantenimiento());
        statement.setString(2,mantenimiento.getMatricula());
        statement.setString(3,mantenimiento.getDetalleMantenimiento());
        statement.setDouble(4,mantenimiento.getValorGasto());
        statement.execute();
    }
    public void ingresarEntrega(Entrega entrega) throws SQLException{
        CallableStatement statement = connection.getConnection().prepareCall("{call Ingresar_Entrega(?,?,?,?) }");
        statement.setString(1,entrega.getMatricula());
        statement.setString(2,entrega.getEstado());
        statement.setInt(3,entrega.getFactura());
        statement.setInt(4,entrega.getID_Empleado());
        statement.execute();
    }
    
    public void ingresarSolicitudMantenimiento(int numSolicitud, int identificadorBien, int idMantenimiento,String fechaSol, String estadoMantenimiento ) throws SQLException{
        CallableStatement statement = connection.getConnection().prepareCall("{call IngresarSolicitud_Mantenimiento(?,?,?,?,?) }");
        statement.setInt(1,numSolicitud);
        statement.setInt(2,identificadorBien);
        statement.setInt(3,idMantenimiento);
        statement.setDate(4,Date.valueOf(fechaSol));
        statement.setString(5,estadoMantenimiento);
        statement.execute();
    }
    
    public void actualizarEntrega(Entrega entrega) throws SQLException{
        CallableStatement statement = connection.getConnection().prepareCall("{call Actualizar_Entrega(?,?) }");
        statement.setString(1,String.valueOf(entrega.getID_Entrega()));
        statement.setString(2,"Finalizado");
        statement.execute();
    }
}
