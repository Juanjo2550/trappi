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
import com.epn.trappi.models.observer.listeners.EventListener;
import com.epn.trappi.models.rrhh.juanjo.ControlAsistencias;
import com.epn.trappi.models.rrhh.juanjo.Empleado;
import com.epn.trappi.models.rrhh.listas.ListaEmpleados;
import com.epn.trappi.models.rrhh.juanjo.Conductor;
import java.sql.SQLException;

/**
 *
 * @author Erick
 */
public final class ControlDisponibilidad implements EventListener {
    //ATRIBUTOS
    ServicioDb servicioDB;
    ListaVehiculos lv;
    public ArrayList<Empleado> le;
    //ArrayList<Conductor> lc;
    private static ControlDisponibilidad instance;
    //METODOS
    public static ControlDisponibilidad getInstance() {
        if (instance == null) {
            instance = new ControlDisponibilidad();
        }
        return instance;
    }
    private ControlDisponibilidad(){  
        lv = new ListaVehiculos();
        le = new ArrayList<Empleado>();
        //lc = new ArrayList<>();
        //inicializarListas();
        /*
        ControlAsistencias controlAsistencias = new ControlAsistencias();
        ControlDisponibilidad control = ControlDisponibilidad.getInstance();
        controlAsistencias.events.suscribe("nuevo_empleado",control);
        controlAsistencias.events.suscribe("salida_empleado",control);
*/
    }

    public void inicializarListas() throws SQLException{
        servicioDB = new ServicioDbVehiculo();
        lv.setVehiculos(servicioDB.obtenerElementosPorFiltro(ServicioDbVehiculo.ESTADO,"Habilitado").getDatos());
        //lc.setListaConductores(AQUI DEBES METER ESA LISTA DE CONDUCTORES QUE ASISTIERON)
    }
    public void actualizarEstados(Vehiculo vehiculo,Conductor conductor) throws SQLException{
        servicioDB = new ServicioDbVehiculo();
        servicioDB.actualizar(vehiculo);
        servicioDB = new ServicioDbConductor();
        servicioDB.actualizar(conductor);
    }
    
    public void asignar(Entrega entrega) throws SQLException{
        
        if(lv.estaVacia() || le.isEmpty()){
            JOptionPane.showMessageDialog(null,"NO HAY CONDUCTORES Y VEHICULOS DISPONIBLES");
        }
        //Seleccionamos los vehiculos
        JOptionPane.showMessageDialog(null,lv.getVehiculos().get(0).getMatricula()+"  -   "+lv.getVehiculos().get(0).getEstado());
        //Como la lista sera añadida con vehiculos de estado ocupado momentaneamente, es necesario ignorarlos cuando lo requiera
        Vehiculo vehiculo = lv.getVehiculos().remove(0);
        Empleado empleado = le.remove(0);
        //Actualizamos los estados
        vehiculo.setEstado(new EnEspera());
        //empleado.setEstado("Ocupado");
        ////////////////////////////////actualizarEstados(vehiculo, conductor);
        //Creamos el registro de entrega
        entrega.setID_Empleado(empleado.getId());
        entrega.setMatricula(vehiculo.getMatricula());
        entrega.setEstado("En curso");
        entrega.RegistrarEntrega();
        //Simulamos movimiento
        simularMovimiento(12);
        //Volvemos a actualizar los estados
        vehiculo.setEstado(new Habilitado());
        //conductor.setEstado("Activo");
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
    


    @Override
    public void update(String eventType, Empleado empleado) {
        if(eventType.equals("nuevo_empleado")){
            System.out.println("Un nuevo empleado disponible OMG!");
            le.add(empleado);
            //Conductor c = new Conductor()
            //c.setId(empleado.getId())
            //c.setEstado("Activo");
            //lc.add(c);
        }else{
            System.out.println("Un empleado se largo");
            le.remove(empleado.getCedula());
            ////Conductor c = new Conductor()
            //c.setId(empleado.getId())
            //lc.remove(c)
        }
    }
    
}
