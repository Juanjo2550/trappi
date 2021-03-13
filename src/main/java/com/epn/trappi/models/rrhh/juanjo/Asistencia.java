package com.epn.trappi.models.rrhh.juanjo;

import com.epn.trappi.db.rrhh.AsistenciaDb;
import com.epn.trappi.models.rrhh.Fecha;
import com.epn.trappi.models.rrhh.Hora;

public class Asistencia {
    private final Empleado empleado;
    private final Hora horaInicio;
    private Hora horaFin;
    private final Fecha fecha;
    private final String observaciones;
    private final Hora horaLimiteEntrada = new Hora(7, 0, 0);
    private final Hora horaLimiteSalida = new Hora(15, 0, 0);

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

    public void registrar() {
        new AsistenciaDb().agregar(this);
    }

    public void registrarSalida() {
        this.setHoraFin(new Hora());
        new AsistenciaDb().registrarSalida(this);
    }

    public void comprobarAtraso() {
        if(this.getHoraInicio().getHora() > this.horaLimiteEntrada.getHora()) {
            int diferencia = Math.abs(this.getHoraInicio().getHora() - this.horaLimiteEntrada.getHora());
            if (diferencia > 8) {
                this.registrarFalta(diferencia);
            } else {
                new Observacion(this.empleado, "atraso", "N/A", this.fecha, new Hora(diferencia, 0, 0))
                        .agregar();
            }
        }
    }

    private void registrarFalta(int diferencia) {
        new Observacion(this.empleado, "falta", "N/A", this.fecha, new Hora(diferencia, 0, 0))
                .agregar();
        this.registrarSalida();
    }

    public void comprobarHoraExtra() {
        if(this.getHoraFin() != null) {
            if (this.getHoraFin().getHora() > this.horaLimiteSalida.getHora()){
                int diferencia = Math.abs(this.getHoraFin().getHora() - this.horaLimiteSalida.getHora());
                new Observacion(this.empleado, "tiempoExtra", "N/A", this.fecha, new Hora(diferencia, 0, 0))
                        .agregar();
            }
        }
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
