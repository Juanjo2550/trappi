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
import java.sql.SQLException;

/**
 *
 * @author Erick
 */
public class ControlDisponibilidad {
    
    /*
    Al usar la base de datos ya no debemos recurrir a almacenamiento interno
    Al usarse hilos para cada asignacion de entrega consumiria muchos recursos traer todas las listas por cada uno
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Conductor> conductores;
    */
    
    //METODOS
    public ControlDisponibilidad(){
        
    }

    
    public void actualizarEstadoVehiculo(String estado){

        
    }
    public void actualizarEstadoConductor(String estado){

        
    }
    
    public void asignar(String factura) throws SQLException{
        // Se obtiene el conductor y el vehiculo que llevara el pedido
        storedProcedures agente = new storedProcedures();
        Vehiculo vehiculo = agente.obtenerVehiculoAsignado("VEHICULO","ESTADO","Habilitado");
        String ID_conductor = agente.obtenerConductorAsignado("EMPLEADO","ESTADOEMP","Activo");
        //Se debe actualizar el ESTADOEMP de la tabla EMPLEADO correspondiente al ID_conductor obtenido al valor "Ocupado"
        
        //Se debe actualizar el ESTADO de la tabla VEHICULO correspondiente al vehiculo.matricula al valor "En espera"
        //Se crea el registro de entrega nuevo
        Entrega entrega = new Entrega(factura);
        entrega.RegistrarEntrega(vehiculo, ID_conductor);
        //Mantener la entrega como En curso durante cierto tiempo.
        simularMovimiento(60);
        //Ahora se actualiza el estado de esa entrega a entregado
        //Se debe actualizar el ESTADOEMP de la tabla EMPLEADO correspondiente al ID_conductor al valor "Activo"
        //Se debe actualizar el ESTADO de la tabla VEHICULO correspondiente al vehiculo.matricula al valor "Habilitado"
        entrega.actualizarEstado();    
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
