/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.rrhh.Permisos;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author stali
 */
public class Lista_Permisos {
    ArrayList<Permiso> listaPermisos = new ArrayList<Permiso>();
    
     public void añadirRegistroAsistencia(Permiso n){
        listaPermisos.add(n);
    }
    private void editarRegistroAsistencia(int posicionList,Permiso nuevo){
        listaPermisos.set(posicionList,nuevo);
    }
    private void eliminarRegistroAsistencia(Permiso eliminado){
        listaPermisos.remove(eliminado);
    }
    public void mostrarRegistro(){
        Iterator it = listaPermisos.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
