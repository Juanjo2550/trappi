/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi;

import com.epn.trappi.gui.logistico.Logistico_GUI;
import com.epn.trappi.gui.logistico.TEST_ENTREGA;
import com.epn.trappi.gui.rrhh.PANTALLA_PRINCIPAL;
import com.epn.trappi.models.logistico.ControlDisponibilidad;
import com.epn.trappi.models.rrhh.juanjo.ControlAsistencias;
import java.sql.SQLException;
import javax.swing.JFrame;

/**
 *
 * @author Alexander
 */
public class Conexion_RRHH_Logistica {
    public static void main(String[] args) throws SQLException{
        ControlAsistencias control = new ControlAsistencias();
        //ControlDisponibilidad controlDisponibilidad = ControlDisponibilidad.getInstance();
        //control.events.suscribe("nuevo_empleado", controlDisponibilidad);
        //control.events.suscribe("salida_empleado", controlDisponibilidad);
        PANTALLA_PRINCIPAL pantalla_rrhh = new PANTALLA_PRINCIPAL(control, new JFrame());
        Logistico_GUI pantalla_logistico = new Logistico_GUI();
        pantalla_rrhh.setVisible(true);
        pantalla_logistico.setVisible(true);
        TEST_ENTREGA panel_ecommerce = new TEST_ENTREGA();
        panel_ecommerce.setVisible(true);
    }
}
