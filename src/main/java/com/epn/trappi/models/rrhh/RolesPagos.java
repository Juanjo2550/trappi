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
public class RolesPagos {
    Map <Integer, RolPagos> lista;
    
    public RolesPagos () {
        this.lista = new HashMap<>();
    }
    
    public ArrayList <RolPagos> obtenerTodos() {
        ArrayList<RolPagos> temp = new ArrayList<>();
        this.lista.forEach((u, v) -> temp.add(v));
        return temp;
    }
    
    public RolPagos agregar (RolPagos nuevoRol) {
        this.lista.put(nuevoRol.getNumero(), nuevoRol);
        return nuevoRol;
    }
    
    public RolPagos buscarUno(int numero) {
        return this.lista.get(numero);
    }
    
    public RolPagos eliminar(RolPagos rolActualizado) {
        return this.lista.remove(rolActualizado.getNumero());
    }
}
