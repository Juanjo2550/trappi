package com.epn.trappi.models.rrhh.juanjo;

import com.epn.trappi.models.rrhh.Fecha;
import com.epn.trappi.models.rrhh.Hora;
import com.epn.trappi.models.rrhh.listas.ListaAsistencias;
import com.epn.trappi.models.rrhh.listas.ListaEmpleados;
import com.epn.trappi.models.rrhh.listas.ListaObservaciones;

public class ControlAsistencias {
    private final Fecha fecha;
    private final Hora horaLimiteEntrada = new Hora(7, 0, 0);
    private final Hora horaLimiteSalida = new Hora(15, 0, 0);
    private final ListaAsistencias listaAsistencias = new ListaAsistencias();

    public ControlAsistencias() {
        this.fecha = new Fecha();
    }

    public void registrarInicioDeJornada(String cedula) {
        Asistencia asistencia = new Asistencia(new ListaEmpleados().buscarUno(cedula), new Hora(), this.fecha, "N/A");
        this.listaAsistencias.agregar(asistencia);
        this.comprobarAtraso(asistencia);
    }

    public void registrarFinDeJornada(String cedula) throws Exception {
        Asistencia asistencia = this.listaAsistencias.buscarUno(cedula, this.fecha);
        this.listaAsistencias.registrarSalida(asistencia);
        this.comprobarHoraExtra(asistencia);
    }

    private void comprobarAtraso(Asistencia asistencia) {
        if(asistencia.getHoraInicio().getHora() > this.horaLimiteEntrada.getHora()) {
            int diferencia = Math.abs(asistencia.getHoraInicio().getHora() - this.horaLimiteEntrada.getHora());
            this.crearObservacion("atraso", asistencia.getEmpleado(), diferencia);
        }
    }

    private void comprobarHoraExtra(Asistencia asistencia) {
        if(asistencia.getHoraFin() != null) {
            if (asistencia.getHoraFin().getHora() > this.horaLimiteSalida.getHora()){
                int diferencia = Math.abs(asistencia.getHoraFin().getHora() - this.horaLimiteSalida.getHora());
                this.crearObservacion("tiempoExtra", asistencia.getEmpleado(), diferencia);
            }
        }
    }

    private void crearObservacion(String tipo, Empleado empleado, int horasDeDiferencia) {
        ListaObservaciones listaObservaciones = new ListaObservaciones();
        listaObservaciones.agregar(new Observacion(empleado, tipo, "N/A", this.fecha, new Hora(horasDeDiferencia, 0, 0)));
    }

    public void notificarEntradaConductor() {

    }
}