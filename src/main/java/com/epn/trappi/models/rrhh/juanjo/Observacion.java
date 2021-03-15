package com.epn.trappi.models.rrhh.juanjo;

import com.epn.trappi.db.rrhh.ObservacionDb;
import com.epn.trappi.models.rrhh.Fecha;
import com.epn.trappi.models.rrhh.Hora;

public class Observacion {
    private final Empleado empleado;
    private final String tipo;
    private final String descripcion;
    private final Fecha fecha;
    private final Hora horasImplicadas;

    public Observacion(Empleado empleado, String tipo, String descripcion, Fecha fecha, Hora horasImplicadas) {
        this.empleado = empleado;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.horasImplicadas = horasImplicadas;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void agregar() {
        new ObservacionDb().agregar(this);
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Hora getHorasImplicadas() {
        return horasImplicadas;
    }
}
