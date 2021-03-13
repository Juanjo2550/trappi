package com.epn.trappi.models.proveedores;

import javax.swing.JComboBox;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author franc
 */
abstract public class Bien {
    public String nombre;
    public double precio;
    protected Proveedor proveeedor;
    public int cantidad ;
    public String marca;
    public String categoria;
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Proveedor getProveeedor() {
        return proveeedor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setProveeedor(Proveedor proveeedor) {
        this.proveeedor = proveeedor;
    }
    
    public void aumentarCantidad(int cantidadAAumentar){
        cantidad-=cantidadAAumentar;
    }
    
    public void disminuirCantidad(int cantidadADisminuir){
        cantidad-=cantidadADisminuir;
    }

    public Bien(String nombre, double precio, Proveedor proveeedor, int cantidad, String marca, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.proveeedor = proveeedor;
        this.cantidad = cantidad;
        this.marca = marca;
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }
    

    public Bien(String nombre, double precio, Proveedor proveeedor) {
        this.nombre = nombre;
        this.precio = precio;
        this.proveeedor = proveeedor;
    }
    
    public Bien(String nombre) {
        this.nombre = nombre;
    }
    
    public abstract void registrar();
    public abstract void actualizar(int id, JTextField txtNombre, JTextField txtPrecio, JComboBox cmbProveedores);

    @Override
    public String toString() {
        return "Bien{" + "nombre=" + nombre + ", precio=" + precio + ", proveeedor=" + proveeedor.getRuc() + ", marca=" + getMarca() + '}';
    }
    
    
}
