package com.epn.trappi.models.proveedores;

import com.epn.trappi.db.proveedores.ProveedoresDb;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Servicio extends Bien {

    private final ProveedoresDb db = new ProveedoresDb();

    public Servicio(String nombre, double precio, Proveedor proveeedor) {
        super(nombre, precio, proveeedor);
    }

    public Servicio(String nombre, double precio, Proveedor proveeedor, int cantidad, String marca) {
        super(nombre, precio, proveeedor, cantidad, marca);
    }

    @Override
    public void registrar() {
        Servicio serv = new Servicio(nombre, precio, proveeedor, cantidad, marca);
        try {
            db.setServicios(serv);
        } catch (SQLException ex) {
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
