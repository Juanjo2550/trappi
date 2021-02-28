/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.rrhh.listas;
import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.gui.rrhh.Permisos.Permiso;
import java.sql.Connection;
import java.util.Objects;

/**
 *
 * @author stali
 */
public class ListaPermisos implements Lista<Permiso>{
    private final Connection connection = Objects.requireNonNull(DataBaseConnection.getInstance()).getConnection();
    @Override
    public void agregar(Permiso newPermission) {
        String querySQL;
        if (newPermission instanceOf )
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean eliminar(String parametro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Permiso buscarUno(String parametro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Permiso[] obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
