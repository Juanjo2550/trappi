package com.epn.trappi.models.rrhh.juanjo;

import com.epn.trappi.models.observer.publisher.EventManager;
import com.epn.trappi.models.rrhh.Fecha;
import com.epn.trappi.models.rrhh.Hora;
import com.epn.trappi.db.rrhh.AsistenciaDb;

public class ControlAsistencias {
    public EventManager events;
    private final Fecha fecha;
    private final AsistenciaDb asistenciaDb = new AsistenciaDb();

    public ControlAsistencias() {
        this.events = new EventManager("nuevo_empleado", "salida_empleado");
        this.fecha = new Fecha();
    }

    public void registrarInicioDeJornada(Empleado empleado) {
        Asistencia asistencia = new Asistencia(empleado, new Hora(), this.fecha, "N/A");
        asistencia.registrar();
        asistencia.comprobarAtraso();
        if (empleado instanceof Conductor) {
            this.notificarEntradaConductor(empleado);
        }
    }

    public void registrarFinDeJornada(String cedula) throws Exception {
        Asistencia asistencia = this.asistenciaDb.buscarUno(cedula, this.fecha);
        asistencia.registrarSalida();
        asistencia.comprobarHoraExtra();
        this.notificarSalidaConductor(asistencia.getEmpleado());
    }

    public void notificarEntradaConductor(Empleado empleado) {
        events.notify("ingreso", empleado);
    }

    public void notificarSalidaConductor(Empleado empleado) { events.notify("salida", empleado);}
}
