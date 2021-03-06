package com.epn.trappi.models.rrhh.juanjo;

import com.epn.trappi.models.observer.publisher.EventManager;
import com.epn.trappi.models.rrhh.Fecha;
import com.epn.trappi.models.rrhh.Hora;
import com.epn.trappi.models.rrhh.listas.ListaAsistencias;
import com.epn.trappi.models.rrhh.listas.ListaEmpleados;

public class ControlAsistencias {
    public EventManager events;
    private final Fecha fecha;
    private final ListaAsistencias listaAsistencias = new ListaAsistencias();

    public ControlAsistencias() {
        this.events = new EventManager("nuevo_empleado", "salida_empleado");
        this.fecha = new Fecha();
    }

    public void registrarInicioDeJornada(String cedula) {
        Asistencia asistencia = new Asistencia(new ListaEmpleados().buscarUno(cedula), new Hora(), this.fecha, "N/A");
        this.listaAsistencias.agregar(asistencia);
        asistencia.comprobarAtraso();
        this.notificarEntradaConductor(asistencia.getEmpleado());
    }

    public void registrarFinDeJornada(String cedula) throws Exception {
        Asistencia asistencia = this.listaAsistencias.buscarUno(cedula, this.fecha);
        asistencia.setHoraFin(new Hora());
        this.listaAsistencias.registrarSalida(asistencia);
        asistencia.comprobarHoraExtra();
    }

    public void notificarEntradaConductor(Empleado empleado) {
        events.notify("nuevo_empleado", empleado);
    }

    public void notificarSalidaConductor(Empleado empleado) { events.notify("salida_empleado", empleado);}
}
