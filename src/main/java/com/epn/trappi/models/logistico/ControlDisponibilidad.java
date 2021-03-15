
package com.epn.trappi.models.logistico;

import javax.swing.JOptionPane;

import com.epn.trappi.models.logistico.servicios.ServicioDb;
import com.epn.trappi.models.logistico.servicios.ServicioDbConductor;
import com.epn.trappi.models.logistico.servicios.ServicioDbVehiculo;
import com.epn.trappi.models.observer.listeners.EventListener;
import com.epn.trappi.models.rrhh.juanjo.Empleado;

import java.sql.SQLException;

/**
 *
 * @author Erick
 */
public final class ControlDisponibilidad implements EventListener {
    //ATRIBUTOS
    ServicioDb servicioDB;
    public ListaVehiculos lv;
    public ListaConductores lc;
    private static ControlDisponibilidad instance;
    //METODOS
    public static ControlDisponibilidad getInstance() throws SQLException {
        if (instance == null) {
            instance = new ControlDisponibilidad();
        }
        return instance;
    }
    public ControlDisponibilidad() throws SQLException{
        lv = new ListaVehiculos();
        lc = new ListaConductores();
        inicializarListas();
    }

    public void inicializarListas() throws SQLException{
        servicioDB = new ServicioDbVehiculo();
        lv.setVehiculos(servicioDB.obtenerElementosPorFiltro(ServicioDbVehiculo.ESTADO,"Habilitado").getDatos());
        //servicioDB = new ServicioDbConductor();
        //lc.setListaConductores(servicioDB.obtenerElementosPorFiltro(ServicioDbConductor.ESTADO,"Activo").getDatos());
    }
    public void actualizarEstados(Vehiculo vehiculo,Conductor conductor) throws SQLException{
        servicioDB = new ServicioDbVehiculo();
        servicioDB.actualizar(vehiculo);
        servicioDB = new ServicioDbConductor();
        servicioDB.actualizar(conductor);
    }
    
    public void asignarVehiculoConductor(Entrega entrega) throws SQLException{
        
        if(lv.estaVacia() || lc.estaVacia()){
            JOptionPane.showMessageDialog(null,"No hay vehiculos o conductores disponibles ");
            return;
        }
        //Seleccionamos un vehiculo y conductor
        Vehiculo vehiculo = lv.getVehiculos().remove(0);
        Conductor conductor = lc.getConductores().remove(0);
        //Actualizamos los estados
        vehiculo.setEstado(new Inhabilitado());
        conductor.setEstado("Ocupado");
        actualizarEstados(vehiculo, conductor);   //PASO 2
        //Creamos el registro de entrega
        entrega.setID_Empleado(conductor.getID());
        entrega.setMatricula(vehiculo.getMatricula());
        entrega.setEstado("En curso");
        entrega.RegistrarEntrega();   //PASO 3
        //Simulamos movimiento
        simularMovimiento(22);   //PASO 4
        //Volvemos a actualizar los estados
        vehiculo.setEstado(new Habilitado());
        conductor.setEstado("Activo");
        actualizarEstados(vehiculo, conductor);    //PASO 5
        //Luego actualizamos el estado de la entrega
        entrega.setEstado("Finalizado");
        entrega.actualizarEstado();    //PASO 6
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
        Conductor con = new Conductor();
        con.setID(empleado.getId());
        con.setEstado("activo");
        if(eventType.equals("nuevo_empleado")) {
            System.out.println("Un nuevo empleado esta disponible!");
            lc.aniadirConductor(con);
        } else {
            System.out.println("Un empleado marco salida, no esta disponible!");
            lc.removerConductor(con);
        }
    }
}
