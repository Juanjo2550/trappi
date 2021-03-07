/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.ecommerce.Ecommerce;

/**
 *
 * @author Grupo D
 */
public class Articulo {
        public String nombre;
        public Double precio;
        public int cantidad;
        public String marca;

    public Articulo(String id, String nombre, Double precio, int cantidad, String marca) {

        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.marca = marca;
    }

    public Articulo() {
    }
        
    public String mostrar() {
        return "nombre=" + nombre + ", precio=" + precio + ", cantidad=" + cantidad;
    }
        
        

    
}
