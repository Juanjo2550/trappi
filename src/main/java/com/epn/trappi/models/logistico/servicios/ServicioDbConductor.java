/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.logistico.servicios;

import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.models.logistico.Conductor;
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
public class ServicioDbConductor implements ServicioDb<Conductor>, Unible<Conductor>{
    //Atributos
    DataBaseConnection connection;
    public static String ID_CONDUCTOR="IDEMP";
    public static String ESTADO="ESTADOEMP";
    //Metodos
    public ServicioDbConductor(){
        connection = DataBaseConnection.getInstance();
    }
    @Override
    public Consultable obtenerElementos() throws SQLException {
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
        return new Consultable(elementos);
    }

    @Override
    public Conductor obtenerElemento(int llave_primaria) throws SQLException {
        Statement sentencia = connection.getConnection().createStatement();
        ResultSet resultados = sentencia.executeQuery("SELECT IDEMP,ESTADOEMP FROM EMPLEADO WHERE TIPOEMP='Conductor' and IDEMP="+llave_primaria);
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
    public Consultable obtenerElementosPorFiltro(String COLUMN_NAME_CONSTANT, String VALOR) throws SQLException {
        /*Set<String> TABLAS = Set.of(ID_CONDUCTOR,ESTADO);
        if(TABLAS.contains(COLUMN_NAME_CONSTANT)==false){
            throw new Exception("No existe esa columna en el sistema");
        }*/
        Statement sentencia = connection.getConnection().createStatement();
        ResultSet resultados;
        resultados=sentencia.executeQuery("SELECT IDEMP,ESTADOEMP FROM EMPLEADO WHERE TIPOEMP='Conductor' AND "+COLUMN_NAME_CONSTANT+"='"+VALOR+"'");
         ArrayList<Conductor> elementos = new ArrayList<>();
        while(resultados.next()){
            Conductor elemento = new Conductor();
            elemento.setID(resultados.getInt(1));
            elemento.setEstado(resultados.getString(2));
            //add all data
            elementos.add(elemento);
        }
        return new Consultable(elementos);
    }

    @Override
    public void insertar(Conductor elemento) throws SQLException {
        //
    }

    @Override
    public Object join(ArrayList<Conductor> usado_para_join, Consultable consultable) throws SQLException {
        ArrayList<String> foreign_keys = new ArrayList<>();
        Object unibleArrayList = new Object();
        if("Entrega".equals(consultable.getType())){
            for (int i=0;i<usado_para_join.size();i++){
                foreign_keys.add(String.valueOf(usado_para_join.get(i).getID()));
            }
            ArrayList<Entrega> entregas = (ArrayList<Entrega>) consultable.getDatos();
            int dynamic_size= entregas.size();
            for (int i=0;i<dynamic_size;i++){
                String id = String.valueOf(entregas.get(i).getID_Empleado());
                if (foreign_keys.contains(id)==false){
                    entregas.remove(i);
                    i=i-1;
                    dynamic_size=entregas.size();
                }
            }
            unibleArrayList = entregas;
        }
        return unibleArrayList;
    }
  
}
