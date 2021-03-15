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
        if (comprobarSiPuedoRegistrarUnaAsistencia(empleado.getCedula())) {
            Asistencia asistencia = new Asistencia(empleado, new Hora(), this.fecha, "N/A");
            asistencia.registrar();
            asistencia.comprobarAtraso();
            if (empleado instanceof Conductores) {
                this.notificarEntradaConductor(empleado);
            }
        }
    }

    public void registrarFinDeJornada(String cedula) throws Exception {
        Asistencia asistencia = this.asistenciaDb.buscarUno(cedula, this.fecha);
        asistencia.registrarSalida();
        asistencia.comprobarHoraExtra();
        if (asistencia.getEmpleado() instanceof Conductores) {
            this.notificarSalidaConductor(asistencia.getEmpleado());
        }
    }

    public boolean comprobarSiPuedoRegistrarUnaAsistencia (String cedula) {
        boolean resultado = false; //No hay una asistencia registrada en la fecha del sistema
        try {
            new AsistenciaDb().buscarUno(cedula, new Fecha());
        } catch (Exception e) {
            System.out.println(e.toString());
            resultado = true;
        }
        return resultado;
    }

    public void notificarEntradaConductor(Empleado empleado) {
        events.notify("nuevo_empleado", empleado);
    }

    public void notificarSalidaConductor(Empleado empleado) { events.notify("salida_empleado", empleado);}
}
