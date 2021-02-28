package com.epn.trappi.models.rrhh.juanjo;

import com.epn.trappi.models.rrhh.Fecha;
import com.epn.trappi.models.rrhh.Hora;

public class Observacion {
    private String tipo;
    private String descripcion;
    private Fecha fecha;
    private Hora horasImplicadas;

    public Observacion(String tipo, String descripcion, Fecha fecha, Hora horasImplicadas) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.horasImplicadas = horasImplicadas;
    }
}
