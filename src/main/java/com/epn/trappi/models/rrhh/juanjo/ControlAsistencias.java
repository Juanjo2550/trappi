package com.epn.trappi.models.rrhh.juanjo;

import com.epn.trappi.models.observer.publisher.EventManager;
import com.epn.trappi.models.rrhh.Fecha;
import com.epn.trappi.models.rrhh.Hora;
import com.epn.trappi.db.rrhh.AsistenciaDb;
import com.epn.trappi.db.rrhh.EmpleadoDb;

public class ControlAsistencias {
    public EventManager events;
    private final Fecha fecha;
    private final AsistenciaDb asistenciaDb = new AsistenciaDb();

    public ControlAsistencias() {
        this.events = new EventManager("nuevo_empleado", "salida_empleado");
        this.fecha = new Fecha();
    }

    public void registrarInicioDeJornada(String cedula) {
        Asistencia asistencia = new Asistencia(new EmpleadoDb().buscarUno(cedula), new Hora(), this.fecha, "N/A");
        this.asistenciaDb.agregar(asistencia);
        asistencia.comprobarAtraso();
        this.notificarEntradaConductor(asistencia.getEmpleado());
    }

    public void registrarFinDeJornada(String cedula) throws Exception {
        Asistencia asistencia = this.asistenciaDb.buscarUno(cedula, this.fecha);
        asistencia.setHoraFin(new Hora());
        this.asistenciaDb.registrarSalida(asistencia);
        asistencia.comprobarHoraExtra();
        this.notificarSalidaConductor(asistencia.getEmpleado());
    }

    public void notificarEntradaConductor(Empleado empleado) {
        events.notify("nuevo_empleado", empleado);
    }

    public void notificarSalidaConductor(Empleado empleado) { events.notify("salida_empleado", empleado);}
}
