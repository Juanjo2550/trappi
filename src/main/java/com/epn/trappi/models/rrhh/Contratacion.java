package com.epn.trappi.models.rrhh;

/**
 *
 * @author Javier Erazo
 */
public class Contratacion {
    private int numero;
    private Fecha fecha;
    private String estado;
    
    public void registrarEmpleado(String nombre, String apellido, String cedula, String cargo, String depto, String numCuenta, String banco, String valorSueldo, char sexo){
        String estado = "activo";
        Sueldo sueldo = new Sueldo(Double.parseDouble(valorSueldo), 0.0);
        ListaEmpleados emps = new ListaEmpleados();
        Empleado nuevoEmpleado = new Empleado(nombre, apellido, cedula, cargo, depto, numCuenta, banco, sueldo, estado, sexo);
        emps.agregar(nuevoEmpleado, sueldo);
        
    }
    
    public void validarRequisitos(){
        
    }
    
    public void registrarContrato(){
        
    }
}


