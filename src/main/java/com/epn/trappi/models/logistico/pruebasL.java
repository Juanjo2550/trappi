/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.logistico;

import com.epn.trappi.models.logistico.servicios.ServicioDb;
import com.epn.trappi.models.logistico.servicios.ServicioDbConductor;
import com.epn.trappi.models.logistico.servicios.ServicioDbEntrega;
import java.sql.SQLException;

/**
 *
 * @author Alexander
 */
public class pruebasL {
    public static void main(String[] args) throws SQLException{
        ServicioDb s = new ServicioDbConductor();
        Conductor c = (Conductor) s.obtenerElemento(5);
    }
}
