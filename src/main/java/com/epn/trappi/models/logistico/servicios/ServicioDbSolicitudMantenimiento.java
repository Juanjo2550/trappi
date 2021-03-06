/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.logistico.servicios;

import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.models.logistico.Mantenimiento;
import com.epn.trappi.models.logistico.SolicitudMantenimiento;
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
public class ServicioDbSolicitudMantenimiento implements ServicioDb<SolicitudMantenimiento>, Unible<SolicitudMantenimiento>{
    //Atributos
    DataBaseConnection connection;
    public static String ID_SOLICITUD="NUMSOLICITUD";
    public static String ID_BIEN="IDENTIFICADORBIEN2";
    public static String ID_MANTENIMIENTO="IDMANTENIMIENTO";
    public static String FECHA="FECHASOLICITUD";
    public static String ESTADO="ESTADOSOLMANTENIMIENTO";
    //Metodos
    public ServicioDbSolicitudMantenimiento(){
        connection = DataBaseConnection.getInstance();
    }
    @Override
    public Consultable obtenerElementos() throws SQLException {
        Statement sentencia = connection.getConnection().createStatement();
        ResultSet resultados = sentencia.executeQuery("SELECT * FROM SOLICITUDPAGOMANTENIMIENTO");
        ArrayList<SolicitudMantenimiento> elementos = new ArrayList<>();
        while(resultados.next()){
            SolicitudMantenimiento elemento = new SolicitudMantenimiento();
            elemento.setId_Solicitud(resultados.getInt(1));
            elemento.setId_Bien(resultados.getInt(2));
            elemento.setId_Mantenimiento(resultados.getInt(3));
            elemento.setFecha(resultados.getString(4));
            elemento.setEstado(resultados.getString(5));
            //add all data
            elementos.add(elemento);
        }
        return new Consultable(elementos);
    }

    @Override
    public SolicitudMantenimiento obtenerElemento(int llave_primaria) throws SQLException {
        Statement sentencia = connection.getConnection().createStatement();
        ResultSet resultados = sentencia.executeQuery("SELECT * FROM SOLICITUDPAGOMANTENIMIENTO WHERE NUMSOLICITUD="+llave_primaria);
        resultados.next();
            SolicitudMantenimiento elemento = new SolicitudMantenimiento();
            elemento.setId_Solicitud(resultados.getInt(1));
            elemento.setId_Bien(resultados.getInt(2));
            elemento.setId_Mantenimiento(resultados.getInt(3));
            elemento.setFecha(resultados.getString(4));
            elemento.setEstado(resultados.getString(5));
        return elemento;
    }

    @Override
    public void insertar(SolicitudMantenimiento elemento) throws SQLException {
        CallableStatement statement = connection.getConnection().prepareCall("{call IngresarSolicitud_Mantenimiento(?,?,?,?,?) }");
        statement.setInt(1,elemento.getId_Solicitud());
        statement.setInt(2,elemento.getId_Bien());
        statement.setInt(3,elemento.getId_Mantenimiento());
        statement.setString(4,elemento.getFecha());
        statement.setString(5,elemento.getEstado());
        statement.execute();
    }

    @Override
    public void actualizar(SolicitudMantenimiento elemento) throws SQLException {
        CallableStatement statement = connection.getConnection().prepareCall("{call Actualizar_SolicitudPagoMantenimiento (?,?) }");
        statement.setInt(1,elemento.getId_Solicitud());
        statement.setString(2,elemento.getEstado());
        statement.execute();
    }

    @Override
    public Consultable obtenerElementosPorFiltro(String COLUMN_NAME_CONSTANT, String VALOR) throws SQLException{
        /*
        Set<String> TABLAS = Set.of(ID_SOLICITUD,ID_BIEN,ID_MANTENIMIENTO,FECHA,ESTADO);
        if(TABLAS.contains(COLUMN_NAME_CONSTANT)==false){
            throw new Exception("No existe esa columna en el sistema");
        }*/
        Statement sentencia = connection.getConnection().createStatement();
        ResultSet resultados;
        resultados=sentencia.executeQuery("SELECT * FROM SOLICITUDPAGOMANTENIMIENTO WHERE "+COLUMN_NAME_CONSTANT+"='"+VALOR+"'");
        ArrayList<SolicitudMantenimiento> elementos = new ArrayList<>();
        while(resultados.next()){
            SolicitudMantenimiento elemento = new SolicitudMantenimiento();
            elemento.setId_Solicitud(resultados.getInt(1));
            elemento.setId_Bien(resultados.getInt(2));
            elemento.setId_Mantenimiento(resultados.getInt(3));
            elemento.setFecha(resultados.getString(4));
            elemento.setEstado(resultados.getString(5));
            //add all data
            elementos.add(elemento);
        }
        return new Consultable(elementos);
        
    }

    @Override
    public Object join(ArrayList<SolicitudMantenimiento> usado_para_join, Consultable consultable) throws SQLException {
        ArrayList<String> foreign_keys = new ArrayList<>();
        Object unibleArrayList = new Object();
        if("Mantenimiento".equals(consultable.getType())){
            for (int i=0;i<usado_para_join.size();i++){
                foreign_keys.add(String.valueOf(usado_para_join.get(i).getId_Mantenimiento()));
            }
            ArrayList<Mantenimiento> mantenimientos = (ArrayList<Mantenimiento>) consultable.getDatos();
            int dynamic_size= mantenimientos.size();
            for (int i=0;i<dynamic_size;i++){
                String id_mantenimiento = String.valueOf(mantenimientos.get(i).getIdMantenimiento());
                if (foreign_keys.contains(id_mantenimiento)==false){
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
