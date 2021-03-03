package com.epn.trappi.models.logistico;

import java.util.ArrayList;

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
    
    
}
