/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.logistico.servicios;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alexander
 * @param <Tipo>
 */
public interface Consultable <Tipo>{
    public ArrayList<Tipo> obtenerElementos() throws SQLException;
    public Tipo obtenerElemento(int llave_primaria) throws SQLException;
    public ArrayList<Tipo> obtenerElementosPorFiltro(String COLUMN_NAME_CONSTANT,String VALOR) throws SQLException,Exception;
}
