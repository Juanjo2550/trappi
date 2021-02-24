/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.rrhh.Permisos;

import com.epn.trappi.models.rrhh.Empleado;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author stali
 */
public class Lista_Permisos {
     Map <Integer, Gestor_Permisos> lista;
     
     public Lista_Permisos(){
        this.lista = new HashMap<>();
    }
   public ArrayList <Gestor_Permisos> obtenerTodos() {
        ArrayList<Gestor_Permisos> temp = new ArrayList<>();
        this.lista.forEach((u, v) -> temp.add(v));
        return temp;
    }
    
    public Gestor_Permisos agregar (Gestor_Permisos nuevoPermiso) {
        this.lista.put(Integer.parseInt(nuevoPermiso.getCI()), nuevoPermiso);
        return nuevoPermiso;
    }
}
