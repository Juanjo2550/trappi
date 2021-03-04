package com.epn.trappi.models.logistico;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ListaConductores {
    private ArrayList<Conductor> listaConductores;

    public ListaConductores() {
        this.listaConductores = new ArrayList<>();    
    }
    public ListaConductores(ArrayList<Conductor> lista){
        this.listaConductores=lista;
    }
    public void aniadirConductor(Conductor nuevo){
        this.listaConductores.add(nuevo);
    }
    public ArrayList<Conductor> getConductores(){
        return this.listaConductores;
    }

    public ArrayList<Conductor> getListaConductores() {
        return listaConductores;
    }

    public void setListaConductores(ArrayList<Conductor> listaConductores) {
        this.listaConductores = listaConductores;
    }
    public Boolean estaVacia(){
        if (this.listaConductores==null || this.listaConductores.size()==0){
            return true;
        }else{
            return false;
        }
    }
    public DefaultTableModel mostrarLista(){
        int num_columnas = 2;
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id Conductor");
        modelo.addColumn("Estado");
        for (int i=0;i<this.listaConductores.size();i++){
            Conductor elemento = this.listaConductores.get(i);
            String[] registro = new String[num_columnas];
            registro[0]=String.valueOf(elemento.getID());
            registro[1]=String.valueOf(elemento.getEstado());
            modelo.addRow(registro);
        }
        return modelo;
    }
    
}
