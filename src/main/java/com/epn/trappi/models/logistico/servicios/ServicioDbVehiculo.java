/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.logistico.servicios;

import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.models.logistico.EnEspera;
import com.epn.trappi.models.logistico.Entrega;
import com.epn.trappi.models.logistico.Estado;
import com.epn.trappi.models.logistico.Habilitado;
import com.epn.trappi.models.logistico.Inhabilitado;
import com.epn.trappi.models.logistico.Mantenimiento;
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
public class ServicioDbVehiculo implements ServicioDb<Vehiculo>, Unible<Vehiculo>{
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
    public Consultable obtenerElementos() throws SQLException {
        Statement sentencia = connection.getConnection().createStatement();
        ResultSet resultados = sentencia.executeQuery("SELECT * FROM VEHICULO");
        ArrayList<Vehiculo> elementos = new ArrayList<>();
        while(resultados.next()){
            Vehiculo elemento = new Vehiculo();
            elemento.setMatricula(resultados.getString(1));
            String estado = resultados.getString(2);
            Estado estado_vehiculo=null;
            if(estado=="Habilitado"){
                estado_vehiculo = new Habilitado();
            }
            if(estado=="Inhabilitado"){
                estado_vehiculo = new Inhabilitado();
            }
            if(estado=="En Espera"){
                estado_vehiculo = new EnEspera();
            }
            elemento.setEstado(estado_vehiculo);
            elemento.setTipo(resultados.getString(3));
            elemento.setKilometraje(resultados.getInt(4));
            elemento.setID(resultados.getInt(5));
            //add all data
            elementos.add(elemento);
        }
        return new Consultable(elementos);
    }

    @Override
    public Vehiculo obtenerElemento(int llave_primaria) throws SQLException {
        Statement sentencia = connection.getConnection().createStatement();
        ResultSet resultados = sentencia.executeQuery("SELECT * FROM VEHICULO WHERE ID='"+String.valueOf(llave_primaria)+"'");
        resultados.next();
            Vehiculo elemento = new Vehiculo();
            elemento.setMatricula(resultados.getString(1));
            String estado = resultados.getString(2);
            Estado estado_vehiculo=null;
            if(estado=="Habilitado"){
                estado_vehiculo = new Habilitado();
            }
            if(estado=="Inhabilitado"){
                estado_vehiculo = new Inhabilitado();
            }
            if(estado=="En Espera"){
                estado_vehiculo = new EnEspera();
            }
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
        CallableStatement statement;
        if(elemento.getEstado()!=null && String.valueOf(elemento.getKilometraje()).length()!=0){
            statement = connection.getConnection().prepareCall("{call Actualizar_Vehiculo(?,?,?) }");
            statement.setInt(1,elemento.getID());
            statement.setString(2,elemento.getEstado().toString());
            statement.setInt(3,elemento.getKilometraje());
            statement.execute();
        }
        if(String.valueOf(elemento.getKilometraje()).length()==0){
            statement = connection.getConnection().prepareCall("{call Actualizar_VehiculoEstado(?,?) }");
            statement.setInt(1,elemento.getID());
            statement.setString(2,elemento.getEstado().toString());
            statement.execute();
        }
        if(elemento.getEstado()==null){
            statement = connection.getConnection().prepareCall("{call Actualizar_VehiculoKilometraje(?,?) }");
            statement.setInt(1,elemento.getID());
            statement.setInt(3,elemento.getKilometraje());
            statement.execute();
        }
    }

    @Override
    public Consultable obtenerElementosPorFiltro(String COLUMN_NAME_CONSTANT, String VALOR) throws SQLException{
        /*
        Set<String> TABLAS = Set.of(ID_VEHICULO,MATRICULA,ESTADO,TIPO,KILOMETRAJE);
        if(TABLAS.contains(COLUMN_NAME_CONSTANT)==false){
            throw new Exception("No existe esa columna en el sistema");
        }*/
        Statement sentencia = connection.getConnection().createStatement();
        ResultSet resultados;
        resultados=sentencia.executeQuery("SELECT * FROM VEHICULO WHERE "+COLUMN_NAME_CONSTANT+"='"+VALOR+"'");
         ArrayList<Vehiculo> elementos = new ArrayList<>();
        while(resultados.next()){
            Vehiculo elemento = new Vehiculo();
            elemento.setMatricula(resultados.getString(1));
            String estado = resultados.getString(2);
            Estado estado_vehiculo=null;
            if(estado=="Habilitado"){
                estado_vehiculo = new Habilitado();
            }
            if(estado=="Inhabilitado"){
                estado_vehiculo = new Inhabilitado();
            }
            if(estado=="En Espera"){
                estado_vehiculo = new EnEspera();
            }
            elemento.setEstado(estado_vehiculo);
            elemento.setTipo(resultados.getString(3));
            elemento.setKilometraje(resultados.getInt(4));
            elemento.setID(resultados.getInt(5));
            //add all data
            elementos.add(elemento);
        }
        return new Consultable(elementos);
    }

    @Override
    public Object join(ArrayList<Vehiculo> usado_para_join, Consultable consultable) throws SQLException {
        ArrayList<String> foreign_keys = new ArrayList<>();
        Object unibleArrayList = new Object();
        if("Entrega".equals(consultable.getType())){
            for (int i=0;i<usado_para_join.size();i++){
                foreign_keys.add(usado_para_join.get(i).getMatricula());
            }
            ArrayList<Entrega> entregas = (ArrayList<Entrega>) consultable.getDatos();
            int dynamic_size= entregas.size();
            for (int i=0;i<dynamic_size;i++){
                String matricula = entregas.get(i).getMatricula();
                if (foreign_keys.contains(matricula)==false){
                    entregas.remove(i);
                    i=i-1;
                    dynamic_size=entregas.size();
                }
            }
            unibleArrayList = entregas;
        }
        if("Mantenimiento".equals(consultable.getType())){
            for (int i=0;i<usado_para_join.size();i++){
                foreign_keys.add(String.valueOf(usado_para_join.get(i).getMatricula()));
            }
            ArrayList<Mantenimiento> mantenimientos = (ArrayList<Mantenimiento>) consultable.getDatos();
            int dynamic_size= mantenimientos.size();
            for (int i=0;i<dynamic_size;i++){
                String matricula = String.valueOf(mantenimientos.get(i).getMatricula());
                if (foreign_keys.contains(matricula)==false){
                    mantenimientos.remove(i);
                    i=i-1;
                    dynamic_size=mantenimientos.size();
                }
            }
            unibleArrayList = mantenimientos;
        }
        return unibleArrayList;
    }

}
