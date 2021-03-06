package com.epn.trappi.models.rrhh.juanjo;

import com.epn.trappi.models.rrhh.Fecha;
import com.epn.trappi.models.rrhh.Hora;
import com.epn.trappi.models.rrhh.listas.ListaObservaciones;

public class Asistencia {
    private Empleado empleado;
    private Hora horaInicio;
    private Hora horaFin;
    private Fecha fecha;
    private String observaciones;
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

    public void comprobarAtraso() {
        if(this.getHoraInicio().getHora() > this.horaLimiteEntrada.getHora()) {
            int diferencia = Math.abs(this.getHoraInicio().getHora() - this.horaLimiteEntrada.getHora());
            this.crearObservacion("atraso", this.getEmpleado(), diferencia);
        }
    }

    public void comprobarHoraExtra() {
        if(this.getHoraFin() != null) {
            if (this.getHoraFin().getHora() > this.horaLimiteSalida.getHora()){
                int diferencia = Math.abs(this.getHoraFin().getHora() - this.horaLimiteSalida.getHora());
                this.crearObservacion("tiempoExtra", this.getEmpleado(), diferencia);
            }
        }
    }

    private void crearObservacion(String tipo, Empleado empleado, int horasDeDiferencia) {
        ListaObservaciones listaObservaciones = new ListaObservaciones();
        listaObservaciones.agregar(new Observacion(empleado, tipo, "N/A", this.fecha, new Hora(horasDeDiferencia, 0, 0)));
    }
}
