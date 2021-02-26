/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ecommerce;

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
        
        

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getMarca() {
        return marca;
    }

    @Override
    public String toString() {
        return "nombre=" + nombre + ", precio=" + precio + ", cantidad=" + cantidad;
    }
        
        

    
}
