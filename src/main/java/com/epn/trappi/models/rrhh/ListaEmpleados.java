/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epn.trappi.models.rrhh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Juan Jaramillo <juanjodev02 at juan.jaramillo02@epn.edu.ec>
 */
public class ListaEmpleados {
    Map <Integer, Empleado> lista;
    
    public ListaEmpleados(){
        this.lista = new HashMap<>();
    }
    
    public ArrayList <Empleado> obtenerTodos() {
        ArrayList<Empleado> temp = new ArrayList<>();
        this.lista.forEach((u, v) -> temp.add(v));
        return temp;
    }
    
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
