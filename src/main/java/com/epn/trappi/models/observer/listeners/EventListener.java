package com.epn.trappi.models.observer.listeners;

import com.epn.trappi.models.rrhh.juanjo.Empleado;

public interface EventListener {
    void update(String eventType, Empleado empleado);
}
