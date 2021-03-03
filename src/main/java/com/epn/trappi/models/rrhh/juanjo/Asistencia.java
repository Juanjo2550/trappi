package com.epn.trappi.models.rrhh.juanjo;

import com.epn.trappi.models.rrhh.Fecha;
import com.epn.trappi.models.rrhh.Hora;

public class Asistencia {
    private Empleado empleado;
    private Hora horaInicio;
    private Hora horaFin;
    private Fecha fecha;
    private String observaciones;

    public Asistencia(Empleado empleado, Hora horaInicio, Hora horaFin, Fecha fecha, String observaciones) {
        this.empleado = empleado;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.fecha = fecha;
        this.observaciones = observaciones;
    }

    public Asistencia(Empleado empleado, Hora horaInicio, Fecha fecha, String observaciones) {
        this.empleado = empleado;
        this.horaInicio = horaInicio;
        this.horaFin = null;
        this.fecha = fecha;
        this.observaciones = observaciones;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public Hora getHoraInicio() {
        return horaInicio;
    }

    public Hora getHoraFin() {
        return horaFin;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setHoraFin(Hora horaFin) {
        this.horaFin = horaFin;
    }
}
