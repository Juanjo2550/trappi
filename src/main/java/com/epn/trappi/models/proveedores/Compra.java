package com.epn.trappi.models.proveedores;

import com.epn.trappi.db.proveedores.ProveedoresDb;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author franc
 */
abstract public class Compra {

    protected Inventario inventario;
    protected ListaDeBienes listaBienesAComprar;
    protected Bien bien;
    protected String estado;
    protected Double montoTotal;
    protected String fecha;
    protected int identificador;
    
    private ProveedoresDb db=new ProveedoresDb();

    public Compra(ListaDeBienes listaBienesAComprar, String estado, Double montoTotal, String fecha, int identificador) {
        this.listaBienesAComprar = listaBienesAComprar;
        this.estado = estado;
        this.montoTotal = montoTotal;
        this.fecha = fecha;
        this.identificador = identificador;
    }

    
    
    public Compra(Inventario inventario, ListaDeBienes listaBienesAComprar, Bien bien, String estado, Double montoTotal, int identificador) {
        this.inventario = inventario;
        this.listaBienesAComprar = listaBienesAComprar;
        this.bien = bien;
        this.estado = estado;
        this.montoTotal = montoTotal;
        this.identificador = identificador;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
        LocalDateTime now = LocalDateTime.now();  
        this.fecha=dtf.format(now);  
    }
    
    public Compra(Inventario inventario, ListaDeBienes listaBienesAComprar, String estado) {
        this.inventario = inventario;
        this.listaBienesAComprar = listaBienesAComprar;
        this.estado = estado;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
        LocalDateTime now = LocalDateTime.now();  
        this.fecha=dtf.format(now);  
    }
    public Compra(ListaDeBienes listaBienesAComprar, String estado) {
        this.listaBienesAComprar = listaBienesAComprar;
        this.estado = estado;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
        LocalDateTime now = LocalDateTime.now();  
        this.fecha=dtf.format(now);  
    }
    public Compra(Inventario inventario, ListaDeBienes listaBienesAComprar, String estado, String fecha) {
        this.inventario = inventario;
        this.listaBienesAComprar = listaBienesAComprar;
        this.estado = estado;
        this.fecha=fecha;
    }
    public Compra(ListaDeBienes listaBienesAComprar, String estado, String fecha, Double monto) {
        this.listaBienesAComprar = listaBienesAComprar;
        this.estado = estado;
        this.fecha=fecha;
        this.montoTotal=monto;
    }
    
    
    public Compra() {
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
        LocalDateTime now = LocalDateTime.now();  
        this.fecha=dtf.format(now);  
    }
    
    public void comprar() {
    }
    
    public void comprarAnalizador() {
    }
    
    public void registrarCompra() {
        int idcompra;
        try {
            if(solicitarAutorizacion(listaBienesAComprar.getListaBienes().get(0).getProveeedor(),montoTotal)){
                idcompra = db.insertarCompra("Pendiente", Double.toString(montoTotal), fecha);
                for (Bien cantidadBien : listaBienesAComprar.getListaBienes()){
                    db.insertDetalleCompra(idcompra, db.getIdBien(cantidadBien.getNombre()), 100);
                }
            }
            
        } catch (SQLException ex) {
             Logger.getLogger(CompraDeProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Double calcularMontoTotal() {
        Double monto = 0.0;
        for (Bien bien : listaBienesAComprar.getListaBienes()) {
            monto += bien.getPrecio() * bien.getCantidad();
        }
        return monto;
    }
    
    public boolean solicitarAutorizacion(Proveedor proveedor, double montoTotal) {
        return true;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal() {
        this.montoTotal = calcularMontoTotal();
    }
    
    public Inventario getInventario() {
        return inventario;
    }
    
    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }
    
    public ListaDeBienes getListaCantidadDeBienes() {
        return listaBienesAComprar;
    }
    
    public void setListaCantidadDeBienes(ListaDeBienes listaCantidadDeBienes) {
        this.listaBienesAComprar = listaCantidadDeBienes;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdentificador() {
        return identificador;
    }

    @Override
    public String toString() {
        return "Compra{listaBienesAComprar=" + listaBienesAComprar.toString() + ", estado=" + estado + ", montoTotal=" + montoTotal + ", fecha=" + fecha ;
    }
    
    
    
}
