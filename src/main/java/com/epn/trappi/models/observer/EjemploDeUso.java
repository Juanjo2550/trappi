package com.epn.trappi.models.observer;

import com.epn.trappi.models.observer.listeners.MapaDisponibilidad;
import com.epn.trappi.models.rrhh.juanjo.ControlAsistencias;

public class EjemploDeUso {
    public static void main(String[] args) {
        //Esto hace RRHH
        ControlAsistencias controlAsistencias = new ControlAsistencias();


        //Esto hace Logístico para comenzar a escuchar empleados
        MapaDisponibilidad mapa = new MapaDisponibilidad();
        controlAsistencias.events.suscribe("nuevo_empleado", mapa);


        //Esto es en tiempo de ejecución
        controlAsistencias.registrarInicioDeJornada("1722951165");
    }
}
