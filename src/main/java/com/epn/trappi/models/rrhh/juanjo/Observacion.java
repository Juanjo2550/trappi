package com.epn.trappi.models.rrhh.juanjo;

import com.epn.trappi.models.rrhh.Fecha;
import com.epn.trappi.models.rrhh.Hora;

public class Observacion {
    private Empleado empleado;
    private String tipo;
    private String descripcion;
    private Fecha fecha;
    private Hora horasImplicadas;

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
