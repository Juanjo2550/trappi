package com.epn.trappi.models.logistico;

import java.util.ArrayList;

public class ListaConductores {
    private ArrayList<Conductor> listaConductores;

    public ListaConductores() {
        this.listaConductores = new ArrayList<Conductor>();
        listaConductores.add(new Conductor("Kevin",true));
        listaConductores.add(new Conductor("Jose",true));
        listaConductores.add(new Conductor("Carlos",true));
        listaConductores.add(new Conductor("Andres",true));
    }
}
