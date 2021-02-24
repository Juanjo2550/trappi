package com.epn.trappi.models.proveedores;

import com.epn.trappi.db.proveedores.ProveedoresDb;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
    protected ListaCantidadDeBienes listaBienesAComprar;
    protected String estado;
    protected Double montoTotal;
    protected String fecha=null;
    
    private ProveedoresDb db=new ProveedoresDb();
    
    public Compra(Inventario inventario, ListaCantidadDeBienes listaBienesAComprar, String estado) {
        this.inventario = inventario;
        this.listaBienesAComprar = listaBienesAComprar;
        this.estado = estado;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
        LocalDateTime now = LocalDateTime.now();  
        this.fecha=dtf.format(now);  
    }
    public Compra(ListaCantidadDeBienes listaBienesAComprar, String estado) {
        this.listaBienesAComprar = listaBienesAComprar;
        this.estado = estado;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
        LocalDateTime now = LocalDateTime.now();  
        this.fecha=dtf.format(now);  
    }
    public Compra(Inventario inventario, ListaCantidadDeBienes listaBienesAComprar, String estado, String fecha) {
        this.inventario = inventario;
        this.listaBienesAComprar = listaBienesAComprar;
        this.estado = estado;
        this.fecha=fecha;
    }
    public Compra(ListaCantidadDeBienes listaBienesAComprar, String estado, String fecha, Double monto) {
        this.listaBienesAComprar = listaBienesAComprar;
        this.estado = estado;
        this.fecha=fecha;
        this.montoTotal=monto;
    }
    
    public void comprar() {
    }
    
    public void comprarAnalizador() {
    }
    
    public void registrarCompra(String nombreProducto, String Proveedor, int cantidad, String estado, double montoTotal, String fecha) {
        db.setCompras(nombreProducto, Proveedor, cantidad, estado, montoTotal, fecha);
    }
    
    public Double calcularMontoTotal() {
        Double monto = 0.0;
        for (CantidadDeBien cantidadBien : listaBienesAComprar.getListaCantidadDeBienes()) {
            monto += cantidadBien.getBien().getPrecio() * cantidadBien.getCantidad();
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
    
    public ListaCantidadDeBienes getListaCantidadDeBienes() {
        return listaBienesAComprar;
    }
    
    public void setListaCantidadDeBienes(ListaCantidadDeBienes listaCantidadDeBienes) {
        this.listaBienesAComprar = listaCantidadDeBienes;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Compra{listaBienesAComprar=" + listaBienesAComprar.toString() + ", estado=" + estado + ", montoTotal=" + montoTotal + ", fecha=" + fecha ;
    }
    
    
    
}
