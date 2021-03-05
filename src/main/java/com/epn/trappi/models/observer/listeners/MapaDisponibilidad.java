package com.epn.trappi.models.observer.listeners;

import com.epn.trappi.models.rrhh.juanjo.Empleado;

import java.util.ArrayList;

public class MapaDisponibilidad implements EventListener{
    public ArrayList<Empleado> empleadosDisponibles;

    public MapaDisponibilidad() {
        this.empleadosDisponibles = new ArrayList<>();
    }

    public void update (String eventType, Empleado empleado) {
        System.out.println("Un nuevo empleado esta disponible!");
        empleadosDisponibles.add(empleado);
    }
}
