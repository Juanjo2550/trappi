  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.rrhh.diego;


import com.epn.trappi.models.rrhh.Fecha;
import com.epn.trappi.models.rrhh.juanjo.Empleado;
import com.epn.trappi.models.rrhh.juanjo.RolDePagos;
import com.epn.trappi.db.rrhh.EmpleadoDb;
import com.epn.trappi.db.rrhh.RolDePagosDb;

/**
 *
 * @author diego
 */
public class RecursosHumanos {
    public EmpleadoDb empleados;
    public RolDePagos pendiente ;
    private final RolDePagosDb roles = new RolDePagosDb();
    
    //comentado para solucionar problemas
   /* public RolesPagos roles = new RolesPagos();
    private ArrayList<RolPagos> pendientes;*/


    public void generarRolesDePago() {
    }
    public RolDePagos iteracionRoles(Empleado e,Fecha f) throws Exception{
        RolDePagos rol = new RolDePagos(e,f);
        this.roles.agregar(rol);
        return rol;
    }
    public void obtenerRolesDePagoPendientes(){
        //comentado para solucionar problemas 
       this.roles.obtenerTodos();
    }
    
    public void iterarEmpleados(Fecha f) throws Exception{
        Empleado[] l1 = new EmpleadoDb().obtenerTodos();
            for(Empleado e1:l1){
                this.roles.agregar(iteracionRoles(e1,f));
        }
    }
}
