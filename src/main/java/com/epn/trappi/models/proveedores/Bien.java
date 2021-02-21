package com.epn.trappi.models.proveedores;
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
    private String nombre;
    private double precio;
    private Proveedor proveeedor;

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

    public void setProveeedor(Proveedor proveeedor) {
        this.proveeedor = proveeedor;
    }
    
    

    public Bien(String nombre, double precio, Proveedor proveeedor) {
        this.nombre = nombre;
        this.precio = precio;
        this.proveeedor = proveeedor;
    }
    
    
    
    public abstract void registrar();
    public abstract void actualizar();
}
