/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.logistico.servicios;

import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.models.logistico.Mantenimiento;
import com.epn.trappi.models.logistico.Vehiculo;
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
public class ServicioDbMantenimiento implements ServicioDb<Mantenimiento>, Unible<Mantenimiento>{
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
    public Consultable obtenerElementos() throws SQLException {
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
        return new Consultable(elementos);
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
    public Consultable obtenerElementosPorFiltro(String COLUMN_NAME_CONSTANT, String VALOR) throws SQLException{
        /*
        Set<String> TABLAS = Set.of(ID_MANTENIMIENTO,MATRICULA,DETALLE,GASTO);
        if(TABLAS.contains(COLUMN_NAME_CONSTANT)==false){
            throw new Exception("No existe esa columna en el sistema");
        }*/
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
        return new Consultable(elementos);
    }

    @Override
    public Object join(ArrayList<Mantenimiento> usado_para_join, Consultable consultable) throws SQLException {
        ArrayList<String> foreign_keys = new ArrayList<>();
        Object unibleArrayList = new Object();
        if("Vehiculo".equals(consultable.getType())){
            for (int i=0;i<usado_para_join.size();i++){
                foreign_keys.add(usado_para_join.get(i).getMatricula());
            }
            ArrayList<Vehiculo> vehiculos = (ArrayList<Vehiculo>) consultable.getDatos();
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
        return unibleArrayList;
    }

}
