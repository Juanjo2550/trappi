/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.controladores.logistico;

import com.epn.trappi.db.connection.DataBaseConnection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
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
        CallableStatement statement = connection.getConnection().prepareCall("{ call InsertData(?, ?,?) }",ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
        statement.setString(1,tabla);
        statement.setString(2,tabla);
        statement.setString(3,tabla);
        statement.execute();
        ResultSet resultados = statement.getResultSet();
        ResultSetMetaData informacion_tabla = resultados.getMetaData();
        int num_columnas = informacion_tabla.getColumnCount();
        DefaultTableModel modelo = new DefaultTableModel();
        for (int i=1;i<num_columnas;i++){
            modelo.addColumn(informacion_tabla.getColumnName(i));
        }
        String[] registro = new String[num_columnas];
        while(resultados.next()){
            for (int indice_columna=0;indice_columna<num_columnas;indice_columna++){
                Object valor_registro = resultados.getObject(indice_columna);
                String cadena = valor_registro.toString();
                registro[indice_columna]=cadena;
            }
            modelo.addRow(registro);
        }
        return modelo;
    }
}
