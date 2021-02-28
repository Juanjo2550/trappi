package com.epn.trappi.models.rrhh;

import com.epn.trappi.models.rrhh.juanjo.Empleado;
import com.epn.trappi.models.rrhh.juanjo.RolDePagos;

import java.util.ArrayList;

public class RRHH {

    private Contratacion contratacion;
    private ArrayList<RolDePagos> pendientes;
    private Fecha fechaActual;
    public RolesPagos roles = new RolesPagos();
   

    public void contratarPersonal(String nombre, String apellido, String cedula, String cargo, String depto, String numCuenta, String banco, String valorSueldo, char sexo) {
         Contratacion contratacion = new Contratacion();
         contratacion.registrarEmpleado(nombre, apellido, cedula, cargo, depto, numCuenta, banco, valorSueldo, sexo);
    }
    public RRHH(){
        this.pendientes = new ArrayList<>();
    }
    public void obtenerRoles() {
        roles.obtenerTodos();
    }

    public RolDePagos iteracionRoles(Empleado e){
        RolDePagos rol = new RolDePagos(fechaActual,e,e.getSueldo().getValor(),Integer.parseInt(e.getCuentaBancaria()));
        new RolesPagos().agregar(rol);
        return rol;
    }
    public void iterarEmpleados(){
        ArrayList<Empleado>l1 = new ListaEmpleados().obtenerTodos();
        for(Empleado e1:l1){
            this.pendientes.add(iteracionRoles(e1));
        }
    }
    //REVISAR Clase Abstracta  
//    public RolPagos iteracionRoles(Empleado e){
//        RolPagos rol = new RolPagos(fechaActual,e,e.getSueldo().getValor(),Integer.parseInt(e.getCuentaBancaria()));
//        new RolesPagos().agregar(rol);
//        return rol;
//    }
//    public void iterarEmpleados(){
//        ArrayList<Empleado>l1 = new ListaEmpleados().obtenerTodos();
//        for(Empleado e1:l1){
//            this.pendientes.add(iteracionRoles(e1));
//        }
//    }
}
