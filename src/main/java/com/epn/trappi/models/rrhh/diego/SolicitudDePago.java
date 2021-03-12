/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.rrhh.diego;

import com.epn.trappi.models.rrhh.Fecha;
import com.epn.trappi.models.rrhh.juanjo.Empleado;
import com.epn.trappi.models.rrhh.juanjo.RolDePagos;
import com.epn.trappi.db.rrhh.RolDePagosDb;
import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class SolicitudDePago {
    
    int numero;
    Fecha fechaSolicitud;
    String estado;
    Empleado empleadoAPagar;
    RolDePagos rol;
    double montoTotal;
    String cuentaBancaria;
    RecursosHumanos recursos_humanos;

    public SolicitudDePago(int numero,RolDePagos rol,Empleado empleadoAPagar, Fecha fechaSolicitud, String estado) {
        this.numero = numero;
        this.fechaSolicitud = fechaSolicitud;
        this.estado = estado;
        this.empleadoAPagar = empleadoAPagar;
        this.rol = rol;
    }

    public SolicitudDePago(int numero, Fecha fechaSolicitud, String estado) {
        this.numero = numero;
        this.fechaSolicitud = fechaSolicitud;
        this.estado = estado;
        
    }

    public SolicitudDePago(Fecha fechaSolicitud, String estado) {
        this.fechaSolicitud = fechaSolicitud;
        this.estado = estado;
    }


    public SolicitudDePago(String estado, double montoTotal, String cuentaBancaria) {
        this.estado = estado;
        this.montoTotal = montoTotal;
        this.cuentaBancaria = cuentaBancaria;
    }

    
    public SolicitudDePago() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Fecha getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Fecha fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    

    public Empleado getEmpleadoAPagar() {
        return empleadoAPagar;
    }

    public void setEmpleadoAPagar(Empleado empleadoAPagar) {
        this.empleadoAPagar = empleadoAPagar;
    }

    public RolDePagos getRol() {
        return rol;
    }

    public void setRol(RolDePagos rol) {
        this.rol = rol;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(String cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public RecursosHumanos getRecursos_humanos() {
        return recursos_humanos;
    }

    public void setRecursos_humanos(RecursosHumanos recursos_humanos) {
        this.recursos_humanos = recursos_humanos;
    }
    

 
    
    
    
    public SolicitudDePago(String cuentaBancaria,double montoTotal ) {
        this.montoTotal = montoTotal;
        this.cuentaBancaria = cuentaBancaria;
    }

   /* public SolicitudDePago() {
    }
  */  
    
    public SolicitudDePago[] SolicitarPago() throws Exception{
        
        RolDePagosDb r1  = new RolDePagosDb();
        r1.obtenerTodos();
         
        ArrayList<SolicitudDePago> roles = new ArrayList<>();
        for (RolDePagos r: r1.obtenerTodos() ){
            if("pendiente".equals(r.getEstado())){
                roles.add(new SolicitudDePago(r.getEmpleado().getCuentaBancaria(),r.getTotal())) ;
            }       
        }
        SolicitudDePago[] solicitudesArray = new SolicitudDePago[roles.size()];
        solicitudesArray = roles.toArray(solicitudesArray);
        return solicitudesArray;
    }

    


    // public void EnvioSolicitudPago (Empleado empleado , ){
    /* public boolean autorizarSolicitud(SolicitudDePago a, boolean autoriza) {
    if(autoriza == true){
    this.estado = "Autorizado";
    System.out.print("Psgo autorizado");
    return true;
    }
    else{
    this.estado = "Rechazado";
    System.out.print("No se autorizo el pago");
    return false;
    }
    }*/
    //esto es comentado para solucionar los errores 
    /*public void solicitarPago(Pago nuevoPago, SolicitudDePago p, boolean autoriza) {
    if(autorizarSolicitud(p,autoriza)){
    nuevoPago=new Pago(this.empleadoAPagar.getCuentaBancaria(),this.rol.getTotal());
    nuevoPago.realizarPago();
    }
    }*/


}
