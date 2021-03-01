/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.logistico;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Erick
 */
public class ControlDisponibilidad {
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Conductor> conductores;
    
    //METODOS
    public ControlDisponibilidad(){
        
    }
    public ControlDisponibilidad(ArrayList<Vehiculo> vehiculos, ArrayList<Conductor> conductores) {
        this.vehiculos = vehiculos;
        this.conductores = conductores;
    }
    
    public Vehiculo actualizarEstado(Vehiculo vehiculo,Conductor conductor){
        int matricula = vehiculo.getMatricula();
        String identificador = conductor.getNombre(); //Debemos usar una cedula
        /*
        Se utiliza la matricula y el identificador para cambiar el estado de disponibilidad
        en la base de datos que contenga la lista de conductores y vehiculos.
        */
        //Se cambia el estado de la instancia del vehiculo
        vehiculo.actualizarEstado(new Inhabilitado(vehiculo));
        return vehiculo;
    }
    
    public void asignar(Posicion destino){
        /*
        Se asume que aquí se realiza el proceso de selección de un conductor y un vehiculo
        esto da como resultado una instancia de vehiculo y conductor.
        */
        Vehiculo vehiculo=null;
        Conductor conductor=null;
        vehiculo = actualizarEstado(vehiculo,conductor);
        /*
        Luego de actualizar los estados de disponibildad, debemos crear un registro en la tabla
        de entregas activas para poder ver las rutas que sigue cada vehiculo con una entrega en proceso.
        */
        Entrega entrega = null;
        entrega.actualizarEstado(vehiculo,conductor);
        /*
        Después de haber añadido este registro, vamos a llamar a un método que correra en segundo plano
        simulando asi el tiempo que tarde en llegar el vehiculo a su destino. 
        */
        simularMovimiento(10);
        /*
        Finalmente, dado que ya se simuló el tiempo que tardó el conductor en llegar a su destino,
        se asume que el producto se entrego exitosamente y se procede a registrar esta entrega
        en la base de datos. Y también se retira el registro de entrega activa ya que 
        ahora esta finalizada. Para esto usamos el método registrarEntrega() de la clase Entrega.
        */
        entrega.RegistrarEntrega(vehiculo, conductor);
        
        
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
