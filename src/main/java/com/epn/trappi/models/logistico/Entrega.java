package com.epn.trappi.models.logistico;

import com.epn.trappi.models.logistico.servicios.ServicioDb;
import com.epn.trappi.models.logistico.servicios.ServicioDbEntrega;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Entrega extends Thread{
    private int ID_Entrega;
    private String matricula;
    private String estado;
    private int factura;
    private int ID_Empleado;
    private String fecha;
    private String direccion;
    
    //METODOS

    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
        try {
            confirmarEntrega();
        } catch (Exception ex) {
            Logger.getLogger(Entrega.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
        ServicioDb manipulable = new ServicioDbEntrega();
        manipulable.actualizar(this);
    }
    
    
    public void confirmarEntrega() throws SQLException{
        ControlDisponibilidad control = ControlDisponibilidad.getInstance();
        control.asignarVehiculoConductor(this); //PASO 1
    }
    
    public void RegistrarEntrega() throws SQLException{
        ServicioDb servicioDB;
        servicioDB = new ServicioDbEntrega();
        servicioDB.insertar(this);
        servicioDB = new ServicioDbEntrega();
        ArrayList<Entrega> entregas =  servicioDB.obtenerElementosPorFiltro(ServicioDbEntrega.FACTURA,String.valueOf(factura)).getDatos();
        this.setID_Entrega(entregas.get(0).getID_Entrega());
    }
    
    public static void crearEntrega(int factura1){
        Entrega e=new Entrega();
        e.setFactura(factura1);
        e.start();
    }
}