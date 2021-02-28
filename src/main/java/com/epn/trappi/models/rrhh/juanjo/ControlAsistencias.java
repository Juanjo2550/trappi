package com.epn.trappi.models.rrhh.juanjo;

import com.epn.trappi.models.rrhh.Fecha;
import com.epn.trappi.models.rrhh.Hora;

public class ControlAsistencias {
    private Fecha fecha;
    private Hora horaLimiteEntrada;
    private Hora horaLimiteSalida;

    public ControlAsistencias(Fecha fecha, Hora horaLimiteEntrada, Hora horaLimiteSalida) {
        this.fecha = fecha;
        this.horaLimiteEntrada = horaLimiteEntrada;
        this.horaLimiteSalida = horaLimiteSalida;
    }

    public void registrarInicioDeJornada(String cedula) {

    }

    public void registrarFinDeJornada(String cedula) {

    }

    private void comprobarAsistencia (Asistencia asistencia) {

    }

    private void crearObservacion() {

    }

    public void notificarEntradaConductor() {

    }
}
