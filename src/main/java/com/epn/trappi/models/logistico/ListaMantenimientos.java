/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.logistico;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alexander
 */
public class ListaMantenimientos {
    private ArrayList<Mantenimiento> mantenimientos;

    public ListaMantenimientos() {
        this.mantenimientos = new ArrayList<>();    
    }
    public ListaMantenimientos(ArrayList<Mantenimiento> lista){
        this.mantenimientos=lista;
    }
    public void aniadirMantenimiento(Mantenimiento nuevo){
        this.mantenimientos.add(nuevo);
    }
    public ArrayList<Mantenimiento> getMantenimientos(){
        return this.mantenimientos;
    }

    public void setMantenimientos(ArrayList<Mantenimiento> lista) {
        this.mantenimientos = lista;
    }
    
    public DefaultTableModel mostrarLista(){
        int num_columnas = 4;
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id Mantenimiento");
        modelo.addColumn("Matrícula");
        modelo.addColumn("Detalle");
        for (int i=0;i<this.mantenimientos.size();i++){
            Mantenimiento elemento = this.mantenimientos.get(i);
            String[] registro = new String[num_columnas];
            registro[0]=String.valueOf(elemento.getIdMantenimiento());
            registro[1]=String.valueOf(elemento.getMatricula());
            registro[2]=String.valueOf(elemento.getDetalleMantenimiento());
            modelo.addRow(registro);
        }
        return modelo;
    }
    public Boolean estaVacia(){
        if (this.mantenimientos==null || this.mantenimientos.size()==0){
            return true;
        }else{
            return false;
        }
    }
}
