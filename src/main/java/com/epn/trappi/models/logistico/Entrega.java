package com.epn.trappi.models.logistico;

import com.epn.trappi.controladores.logistico.storedProcedures;
import java.sql.SQLException;

public class Entrega{
    private int ID_Entrega;
    private String matricula;
    private String estado;
    private int factura;
    private int ID_Empleado;
    private String fecha;
    private String direccion;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    public Entrega(){
        estado="En curso";
    }
    public Entrega(int factura) {
        this.factura=factura;
        estado="En curso";
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

    public int getID_Empleado() {
        return ID_Empleado;
    }

    public void setID_Empleado(int ID_Empleado) {
        this.ID_Empleado = ID_Empleado;
    }

    public int getFactura() {
        return factura;
    }

    public void setFactura(int factura) {
        this.factura = factura;
    }

 
    
    public void actualizarEstado() throws SQLException{
        storedProcedures agente = new storedProcedures();
        agente.actualizarEntrega(this);
    }
    
    
    public void confirmarEntrega() throws SQLException{
        ControlDisponibilidad control = new ControlDisponibilidad();
        //control.asignar(factura);
    }
    
    public void RegistrarEntrega(Vehiculo vehiculo,String ID_conductor) throws SQLException{
        this.setFecha("");
        //this.setID_Empleado(ID_conductor);
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