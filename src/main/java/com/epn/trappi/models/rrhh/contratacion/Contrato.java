package com.epn.trappi.models.rrhh.contratacion;

import com.epn.trappi.models.rrhh.Fecha;
import com.epn.trappi.models.rrhh.juanjo.Empleado;
import com.epn.trappi.db.rrhh.ContratosDB;
import com.epn.trappi.models.rrhh.listas.ListaEmpleados;
import javax.swing.JOptionPane;

/**
 *
 * @author Javier Erazo
 */
public class Contrato {
    private Fecha fechaInicio;
    private Fecha fechaFin;
    private String tipo;
    private String numero;
    private String sueldo;
    

    public Contrato(String numero, Fecha fechaInicio, Fecha fechaFin, String tipo,  String sueldo) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tipo = tipo;
        this.numero = numero;
        this.sueldo = sueldo;
        
    }
    
    public Contrato(){
        
    }
    
    public void registrarContrato(Fecha fechaInicio, Fecha fechaFin, String tipoContrato, String valorSueldo, String cedula) {
        
        ContratosDB listaContratos = new ContratosDB();
        int idContrato = listaContratos.obtenerTodos().length + 1;
        Contrato newContrato = new Contrato(String.valueOf(idContrato), fechaInicio, fechaFin, tipoContrato, valorSueldo  );
        listaContratos.agregar(newContrato, cedula);

    }
    
    public void registrarEmpleado(Empleado empleado){
        ListaEmpleados listEmp = new ListaEmpleados();
        listEmp.agregar(empleado);
    }

    public Fecha getFechaInicio() {
        return fechaInicio;
    }

    public Fecha getFechaFin() {
        return fechaFin;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNumero() {
        return numero;
    }

    public String getSueldo() {
        return sueldo;
    }
    
    
            
    
    
    
    
}
