package com.epn.trappi.models.observer.publisher;

import com.epn.trappi.models.observer.listeners.EventListener;
import com.epn.trappi.models.rrhh.juanjo.Empleado;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
    Map<String, List<EventListener>> listeners = new HashMap<>();

    public EventManager(String ... operations) {
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public void suscribe(String eventType, EventListener listener) {
        List<EventListener> empleados = listeners.get(eventType);
        empleados.add(listener);
    }

    public void unsubscribe(String eventType, EventListener listener) {
        List<EventListener> empleados = listeners.get(eventType);
        empleados.remove(listener);
    }

    public void notify(String eventType, Empleado empleado) {
        List<EventListener> empleados = listeners.get(eventType);
        for (EventListener listener : empleados) {
            listener.update(eventType, empleado);
        }
    }
}
