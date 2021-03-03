/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.ecommerce.Ecommerce;

import java.util.ArrayList;


/**
 *
 * @author Bryan
 */
public class Articulo {
        String id;
        public String nombre;
        public Double precio;
        public int cantidad;
        public String marca;

    public Articulo(String id, String nombre, Double precio, int cantidad, String marca) {
        this.id = id;
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
