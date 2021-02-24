package com.epn.trappi.models.rrhh;

import java.util.ArrayList;

public class RRHH {

    private Contratacion contratacion;
    private ArrayList<RolPagos> pendientes;
    private Fecha fechaActual;
    public RolesPagos roles = new RolesPagos();
   

    public void contratarPersonal() {
           
    }
    public RRHH(){
        this.pendientes = new ArrayList<>();
    }
    public void obtenerRoles() {
        roles.obtenerTodos();
    }

    public RolPagos iteracionRoles(Empleado e){
        RolPagos rol = new RolPagos(fechaActual,e,e.getSueldo().getValor(),Integer.parseInt(e.getCuentaBancaria()));
        new RolesPagos().agregar(rol);
        return rol;
    }
    public void iterarEmpleados(){
        ArrayList<Empleado>l1 = new ListaEmpleados().obtenerTodos();
        for(Empleado e1:l1){
            this.pendientes.add(iteracionRoles(e1));
        }
    }
}
