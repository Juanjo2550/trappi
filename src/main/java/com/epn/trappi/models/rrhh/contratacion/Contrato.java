package com.epn.trappi.models.rrhh.contratacion;

import com.epn.trappi.models.rrhh.Fecha;
import com.epn.trappi.models.rrhh.listas.ListaContratos;
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
    
    public void registrar(Fecha fechaInicio, Fecha fechaFin, String tipoContrato, String valorSueldo, String cedula) {
        
        ListaContratos listaContratos = new ListaContratos();
        int idContrato = listaContratos.obtenerTodos().length + 1;
        Contrato newContrato = new Contrato(String.valueOf(idContrato), fechaInicio, fechaFin, tipoContrato, valorSueldo  );
        listaContratos.agregar(newContrato, cedula);

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
