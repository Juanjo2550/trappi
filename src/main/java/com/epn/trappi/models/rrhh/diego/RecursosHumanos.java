/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.rrhh.diego;

import com.epn.trappi.models.rrhh.ListaEmpleados;
import com.epn.trappi.models.rrhh.RolPagos;
import com.epn.trappi.models.rrhh.RolesPagos;
import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class RecursosHumanos {
    ListaEmpleados empleados;
    public RolesPagos roles = new RolesPagos();
    private ArrayList<RolPagos> pendientes;
    
    public void generarRolesDePago(){
        
    }
    public void obtenerRolesDePagoPendientes(){
        
        this.roles.obtenerTodos();
    }
    public void generarSolicitudDePago(){
        
    }
}
