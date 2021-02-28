/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.controladores.logistico;

import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.models.logistico.Mantenimiento;
import java.sql.CallableStatement;
import java.sql.Date;
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
        CallableStatement statement = connection.getConnection().prepareCall("{ call InsertData(?,?,?) }");
        statement.setString(1,tabla);
        statement.setString(2,columna);
        statement.setString(3,valor);
        ResultSet resultados = statement.executeQuery();
        ResultSetMetaData informacion_tabla = resultados.getMetaData();
        int num_columnas = informacion_tabla.getColumnCount();
        System.out.println(num_columnas);
        DefaultTableModel modelo = new DefaultTableModel();
        for (int i=1;i<=num_columnas;i++){
            modelo.addColumn(informacion_tabla.getColumnName(i));
        }
        String[] registro = new String[num_columnas];
        while(resultados.next()){
            for (int indice_columna=1;indice_columna<=num_columnas;indice_columna++){
                Object valor_registro = resultados.getObject(indice_columna);
                String cadena = valor_registro.toString();
                System.out.println(cadena);
                registro[indice_columna-1]=cadena;
            }
            modelo.addRow(registro);
        }
        return modelo;
    }
    
    public void ingresarMantenimiento(Mantenimiento mantenimiento) throws SQLException{
        CallableStatement statement = connection.getConnection().prepareCall("{call Ingresar_Mantenimiento(?,?,?,?) }");
        statement.setInt(1,mantenimiento.getIdMantenimiento());
        statement.setString(2,mantenimiento.getMatricula());
        statement.setString(3,mantenimiento.getDetalleMantenimiento());
        statement.setDouble(4,mantenimiento.getValorGasto());
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
}
