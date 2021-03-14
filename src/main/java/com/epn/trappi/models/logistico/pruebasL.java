/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.logistico;

import com.epn.trappi.models.logistico.servicios.Consultable;
import com.epn.trappi.models.logistico.servicios.ServicioDb;
import com.epn.trappi.models.logistico.servicios.ServicioDbConductor;
import com.epn.trappi.models.logistico.servicios.ServicioDbEntrega;
import com.epn.trappi.models.logistico.servicios.Unible;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alexander
 */
public class pruebasL {
    public static void main(String[] args) throws SQLException{
        System.out.println(numViajesPorConductor(2021,3,"9"));
    }
   public static int numViajesPorConductor(int año,int mes,String id) throws SQLException{
	ServicioDb servicio = new ServicioDbConductor();
	Unible joiner = new ServicioDbConductor();
	String fecha = año+"-"+mes+"-"+"99";
	Consultable entregas = new ServicioDbEntrega().obtenerElementosPorFiltro(ServicioDbEntrega.FECHA,fecha);
	ArrayList<Conductor> conductor = servicio.obtenerElementosPorFiltro(ServicioDbConductor.ID_CONDUCTOR,id).getDatos();	
	ArrayList<Entrega> entregas_por_conductor = (ArrayList<Entrega>) joiner.join(conductor,entregas);
	return entregas_por_conductor.size();
    } 
}
