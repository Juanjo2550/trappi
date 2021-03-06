package com.epn.trappi.models.observer;

import com.epn.trappi.models.observer.listeners.MapaDisponibilidad;
import com.epn.trappi.models.rrhh.juanjo.ControlAsistencias;

public class EjemploDeUso {
    public static void main(String[] args) {
        /*
        Esta clase no se utiliza en el ejemplo, solo es una ejemplo de todas las clases
        que se deben instanciar y métodos que se debe ejecutar para todo
         */
        //Esto hace RRHH
        ControlAsistencias controlAsistencias = new ControlAsistencias();


        //Esto hace Logístico para comenzar a escuchar empleados
        MapaDisponibilidad mapa = new MapaDisponibilidad();
        controlAsistencias.events.suscribe("nuevo_empleado", mapa);
        controlAsistencias.events.suscribe("salida_empleado", mapa);


        //Esto es en tiempo de ejecución
        controlAsistencias.registrarInicioDeJornada("1722951165");
    }
}
