/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epn.trappi.models.rrhh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.epn.trappi.db.rrhh.*;

/**
 * 
 * @author Juan Jaramillo <juanjodev02 at juan.jaramillo02@epn.edu.ec>
 */
public class ListaEmpleados {
    Map <Integer, Empleado> lista;
    
    public ListaEmpleados(){
        this.lista = new HashMap<>();
        ArrayList<Empleado> l1 = new EmpleadoDb().selectAll();
        for(Empleado e1 : l1) {
            this.lista.put(e1.getCedula(), e1);
        }
    }
    
    public ArrayList <Empleado> obtenerTodos() {
        ArrayList<Empleado> temp = new ArrayList<>();
        this.lista.forEach((u, v) -> temp.add(v));
        return temp;
    }

    /**
     * Este método se utiliza para agregar un empleado a la base de datos
     * Debe ser utilizado por el submódulo de contratación
     * @param nuevoEmpleado
     * @param sueldo
     * @return
     */
    public Empleado agregar (Empleado nuevoEmpleado, Sueldo sueldo) {
        this.lista.put(nuevoEmpleado.getCedula(), nuevoEmpleado);
        EmpleadoDb empleadoDb = new EmpleadoDb();
        empleadoDb.addOne(nuevoEmpleado, sueldo);
        return nuevoEmpleado;
    }

    /**
     * Este método no debe ser utilizado ya que no realiza cambios en la base de datos
     * Se utiliza solo como una estructura de datos
     * @param nuevoEmpleado
     * @return
     */
    public Empleado agregar (Empleado nuevoEmpleado) {
        this.lista.put(nuevoEmpleado.getCedula(), nuevoEmpleado);
        return nuevoEmpleado;
    }
    
    public Empleado buscarUno(int numero) {
        return this.lista.get(numero);
    }
    
    public Empleado eliminar(Empleado rolActualizado) {
        return this.lista.remove(rolActualizado.getCedula());
    }
}
