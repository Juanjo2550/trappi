package com.epn.trappi.models.observer.listeners;

import com.epn.trappi.models.observer.LogInterface;
import com.epn.trappi.models.rrhh.juanjo.Empleado;

import java.util.ArrayList;

public class MapaDisponibilidad implements EventListener{
    public ArrayList<Empleado> empleadosDisponibles;
    private LogInterface logInterface;

    public MapaDisponibilidad(LogInterface logInterface) {
        this.empleadosDisponibles = new ArrayList<>();
        this.logInterface = logInterface;
    }

    public MapaDisponibilidad() {
        this.empleadosDisponibles = new ArrayList<>();
    }

    public void update (String eventType, Empleado empleado) {
        if(eventType.equals("nuevo_empleado")) {
            System.out.println("Un nuevo empleado esta disponible!");
            empleadosDisponibles.add(empleado);
            logInterface.updateEmpleados();
        } else {
            System.out.println("Un empleado marco salida, no esta disponible!");
            empleadosDisponibles.remove(empleado);
        }

    }
}
