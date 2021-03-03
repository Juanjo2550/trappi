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
public interface ManipulableConductor<Tipo> {
    public void actualizar(Tipo elemento) throws SQLException;
}
