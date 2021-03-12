package com.epn.trappi.models.rrhh.contratacion;

import com.epn.trappi.models.rrhh.Fecha;
import com.epn.trappi.models.rrhh.juanjo.Empleado;
import com.epn.trappi.db.rrhh.ContratoDb;
import com.epn.trappi.db.rrhh.EmpleadoDb;


/**
 *
 * @author Javier Erazo
 */
public class Contrato {
    private Fecha fechaInicio;
    private Fecha fechaFin;
    private String tipo;
   //private String numero;
    private String sueldo;
    

    public Contrato(Fecha fechaInicio, Fecha fechaFin, String tipo,  String sueldo) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tipo = tipo;
        this.sueldo = sueldo;
        
    }
    
    public Contrato(String cedulaEmpleado){
        
    }
    
    public Contrato(){
        
    }
    
    public void registrar(String cedula) {
         new ContratoDb().agregar(this, cedula);

    }
    
    public void solicitarRegistroEmpleado(Empleado empleado){
        empleado.registrar();
    }
    
    public Fecha obtenerFechaFin(String cedula){
        ContratoDb db = new ContratoDb();
        Contrato contrato = null;
        contrato = db.buscarUno(cedula);
        if (contrato != null){
            return contrato.getFechaFin();
        } else {
            return null;
        }
        
        
    }
    
    public String obtenerTipo(String cedula){
        ContratoDb db = new ContratoDb();
        Contrato contrato = null;
        contrato = db.buscarUno(cedula);
        if (contrato != null){
            return contrato.getTipo();
        } else {
            return null;
        }
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

    public String getSueldo() {
        return sueldo;
    }
    
    
            
    
    
    
    
}
