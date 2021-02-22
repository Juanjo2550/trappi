package com.epn.trappi.models.proveedores;

import com.epn.trappi.db.proveedores.ProveedoresDb;

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
    private ProveedoresDb db;
    
    public Compra(Inventario inventario, ListaCantidadDeBienes listaBienesAComprar, String estado) {
        this.inventario = inventario;
        this.listaBienesAComprar = listaBienesAComprar;
        this.estado = estado;
    }
    
    public void comprar() {
    }
    
    public void registrarCompra(String nombreProducto, String Proveedor, int cantidad, String estado, double montoTotal) {
        db.setCompras(nombreProducto, Proveedor, cantidad, estado, montoTotal);
    }
    
    public Double calcularMontoTotal() {
        Double montoTotal = 0.0;
        for (CantidadDeBien cantidadBien : listaBienesAComprar.getListaCantidadDeBienes()) {
            montoTotal += cantidadBien.getBien().getPrecio() * cantidadBien.getCantidad();
        }
        return montoTotal;
    }
    
    public boolean solicitarAutorizacion(Proveedor proveedor, double montoTotal) {
        return true;
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
    
}
