/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epn.trappi.models.rrhh;

import com.epn.trappi.db.rrhh.RolPagosDb;
import com.epn.trappi.models.rrhh.juanjo.RolDePagos;

import java.util.ArrayList;

/**
 * 
 * @author Juan Jaramillo <juanjodev02 at juan.jaramillo02@epn.edu.ec>
 */
public class RolesPagos {
    ArrayList <RolDePagos> lista;
    
    public RolesPagos () {
        this.lista = new RolPagosDb().selectAll();
    }
    
    public ArrayList <RolDePagos> obtenerTodos() {
        return new RolPagosDb().selectAll();
    }
    
    public ArrayList <RolDePagos> obtenerTodos(String cedula) {
            return new RolPagosDb().getByCedula(cedula);
    }
    
    public RolDePagos agregar (RolDePagos nuevoRol) {
        new RolPagosDb().addOne(nuevoRol);
        this.lista = new RolPagosDb().selectAll();
        return nuevoRol;
    }
    
    public RolDePagos buscarUno(int cedula) {
        return new RolPagosDb().getOne(cedula + "");
    }
}
