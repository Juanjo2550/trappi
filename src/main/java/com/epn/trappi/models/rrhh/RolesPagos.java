/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epn.trappi.models.rrhh;

import com.epn.trappi.db.rrhh.RolPagosDb;
import java.util.ArrayList;

/**
 * 
 * @author Juan Jaramillo <juanjodev02 at juan.jaramillo02@epn.edu.ec>
 */
public class RolesPagos {
    ArrayList <RolPagos> lista;
    
    public RolesPagos () {
        this.lista = new RolPagosDb().selectAll();
    }
    
    public ArrayList <RolPagos> obtenerTodos() {
        return new RolPagosDb().selectAll();
    }
    
    public ArrayList <RolPagos> obtenerTodos(String cedula) {
            return new RolPagosDb().getByCedula(cedula);
    }
    
    public RolPagos agregar (RolPagos nuevoRol) {
        new RolPagosDb().addOne(nuevoRol);
        this.lista = new RolPagosDb().selectAll();
        return nuevoRol;
    }
    
    public RolPagos buscarUno(int cedula) {
        return new RolPagosDb().getOne(cedula + "");
    }
}
