package com.epn.trappi.models.rrhh;

public class RRHH {

    private Contratacion contratacion;
    private RolesPagos pendientes[];
    private Fecha fechaActual;
    public RolesPagos roles = new RolesPagos();
   

    public void contratarPersonal() {

    }

    public void obtenerRoles() {
        roles.obtenerTodos();
    }

    public void iteracionRoles(Empleado e){
        RolPagos rol = new RolPagos(fechaActual,e,e.getSueldo().getValor(),Integer.parseInt(e.getCuentaBancaria()));
        for(int i=0; i<pendientes.length;i++){
            roles.agregar(rol);
            rol.mostrar();
        }
    }
}
