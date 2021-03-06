/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.logistico;

import com.epn.trappi.controladores.logistico.storedProcedures;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.epn.trappi.models.logistico.Vehiculo;
import com.epn.trappi.models.logistico.servicios.ServicioDb;
import com.epn.trappi.models.logistico.servicios.ServicioDbConductor;
import com.epn.trappi.models.logistico.servicios.ServicioDbVehiculo;
import java.sql.SQLException;

/**
 *
 * @author Erick
 */
public final class ControlDisponibilidad {
    //ATRIBUTOS
    ServicioDb servicioDB;
    ListaVehiculos lv;
    ListaConductores lc;
    private static ControlDisponibilidad instance;
    //METODOS
    public static ControlDisponibilidad getInstance() throws SQLException {
        if (instance == null) {
            instance = new ControlDisponibilidad();
        }
        return instance;
    }
    private ControlDisponibilidad() throws SQLException{  
        lv = new ListaVehiculos();
        lc = new ListaConductores();
        inicializarListas();
    }

    public void inicializarListas() throws SQLException{
        servicioDB = new ServicioDbVehiculo();
        lv.setVehiculos(servicioDB.obtenerElementosPorFiltro(ServicioDbVehiculo.ESTADO,"Habilitado").getDatos());
        servicioDB = new ServicioDbConductor();
        lc.setListaConductores(servicioDB.obtenerElementosPorFiltro(ServicioDbConductor.ESTADO,"Activo").getDatos());
    }
    public void actualizarEstados(Vehiculo vehiculo,Conductor conductor) throws SQLException{
        servicioDB = new ServicioDbVehiculo();
        servicioDB.actualizar(vehiculo);
        servicioDB = new ServicioDbConductor();
        servicioDB.actualizar(conductor);
    }
    
    public void asignar(Entrega entrega) throws SQLException{
        
        if(lv.estaVacia() || lc.estaVacia()){
            JOptionPane.showMessageDialog(null,"NO HAY CONDUCTORES Y VEHICULOS DISPONIBLES");
        }
        //Seleccionamos los vehiculos
        JOptionPane.showMessageDialog(null,lv.getVehiculos().get(0).getMatricula()+"  -   "+lv.getVehiculos().get(0).getEstado());
        //Como la lista sera añadida con vehiculos de estado ocupado momentaneamente, es necesario ignorarlos cuando lo requiera
        Vehiculo vehiculo = lv.getVehiculos().remove(0);
        Conductor conductor = lc.getConductores().remove(0);
        //Actualizamos los estados
        vehiculo.setEstado(new EnEspera());
        conductor.setEstado("Ocupado");
        ////////////////////////////////actualizarEstados(vehiculo, conductor);
        //Creamos el registro de entrega
        entrega.setID_Empleado(conductor.getID());
        entrega.setMatricula(vehiculo.getMatricula());
        entrega.setEstado("En curso");
        entrega.RegistrarEntrega();
        //Simulamos movimiento
        simularMovimiento(12);
        //Volvemos a actualizar los estados
        vehiculo.setEstado(new Habilitado());
        conductor.setEstado("Activo");
        /////////////////////////////////actualizarEstados(vehiculo, conductor);
        //Luego actualizamos el estado de la entrega
        entrega.setEstado("Finalizado");
        entrega.actualizarEstado();
        //Se vuelve a añadir al vehiculo y conductor a la lista
        //lv.agregarVehiculo(vehiculo);
        //lc.aniadirConductor(conductor);
    }
    public void simularMovimiento(int segundos){
        try{
            Thread.sleep(segundos*1000);//ms
            
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
            JOptionPane.showMessageDialog(null,"Error de concurrencia");
        }
    }

}
