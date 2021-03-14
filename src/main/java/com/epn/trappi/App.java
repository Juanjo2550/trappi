package com.epn.trappi;


import com.epn.trappi.gui.logistico.Logistico_GUI;
import com.epn.trappi.gui.rrhh.PANTALLA_PRINCIPAL;
import com.epn.trappi.models.logistico.ControlDisponibilidad;
import com.epn.trappi.models.rrhh.juanjo.ControlAsistencias;

import java.sql.SQLException;

public class App {
    /**
     * Inicia la ventana principal de la aplicación
     * @param args 
     */
    public static void main(String args[]){
//        MainGui mainWindow = new MainGui();
//        mainWindow.setVisible(true);
        try {
            ControlAsistencias controlAsistencias = new ControlAsistencias();
            ControlDisponibilidad controlDisponibilidad = ControlDisponibilidad.getInstance();
            controlAsistencias.events.suscribe("nuevo_empleado", controlDisponibilidad);
            controlAsistencias.events.suscribe("salida_empleado", controlDisponibilidad);
            PANTALLA_PRINCIPAL RRHH = new PANTALLA_PRINCIPAL(controlAsistencias);
            RRHH.setVisible(true);
            Logistico_GUI logistico_gui = new Logistico_GUI(controlDisponibilidad);
            logistico_gui.setVisible(true);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}
