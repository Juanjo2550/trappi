/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.rrhh;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author diego
 */
public class ListaRegistrosAsistencias {
    ArrayList <RegistroAsistencia> listaDeRegistros = new ArrayList <RegistroAsistencia>();
    
    public void añadirRegistroAsistencia(RegistroAsistencia n){
        listaDeRegistros.add(n);
    }
    private void editarRegistroAsistencia(int posicionList,RegistroAsistencia nuevo){
        listaDeRegistros.set(posicionList,nuevo);
    }
    private void eliminarRegistroAsistencia(RegistroAsistencia eliminado){
        listaDeRegistros.remove(eliminado);
    }
    public void mostrarRegistro(){
        Iterator it = listaDeRegistros.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
