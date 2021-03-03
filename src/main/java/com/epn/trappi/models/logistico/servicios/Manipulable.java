/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.logistico.servicios;

import java.sql.SQLException;

/**
 *
 * @author Alexander
 * @param <Tipo>
 */
public interface Manipulable <Tipo>{
    public void insertar(Tipo elemento) throws SQLException;
    public void actualizar(Tipo elemento) throws SQLException;
    //public void eliminar(Tipo elemento) throws SQLException;
}
