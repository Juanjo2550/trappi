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
public class Proveedor {

    private String ruc;
    private String razonSocial;
    private String direccion;

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Proveedor(String ruc, String razonSocial, String direccion) {
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
    }

    private void registrarProveedor() {

    }
}
