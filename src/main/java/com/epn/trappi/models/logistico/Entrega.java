package com.epn.trappi.models.logistico;

import com.epn.trappi.controladores.logistico.storedProcedures;
import java.sql.SQLException;

public class Entrega{
    private int ID_Entrega;
    private String matricula;
    private String fecha;
    private String ID_Empleado;
    private boolean estado;
    private String factura;
    

    public Entrega(String factura) {
        this.factura=factura;
        estado=true;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getID_Entrega() {
        return ID_Entrega;
    }

    public void setID_Entrega(int ID_Entrega) {
        this.ID_Entrega = ID_Entrega;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getID_Empleado() {
        return ID_Empleado;
    }

    public void setID_Empleado(String ID_Empleado) {
        this.ID_Empleado = ID_Empleado;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

 
    
    public void actualizarEstado() throws SQLException{
        storedProcedures agente = new storedProcedures();
        agente.actualizarEntrega(this);
    }
    
    public void confirmarEntrega() throws SQLException{
        ControlDisponibilidad control = new ControlDisponibilidad();
        control.asignar(factura);
    }
    
    public void RegistrarEntrega(Vehiculo vehiculo,String ID_conductor) throws SQLException{
        this.setFecha("");
        this.setID_Empleado(ID_conductor);
        this.setID_Entrega(generarID());
        this.setMatricula(vehiculo.getMatricula());
        storedProcedures agente = new storedProcedures();
        agente.ingresarEntrega(this);
        
    }
    public int generarID(){
        //Se debe consultar la Tabla de Entregas y obtener el ultimo o primer ID de entrega y sumarle 1
        int a=0;
        return a;
    }
    
   
    
    
}