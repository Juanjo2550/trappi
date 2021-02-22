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
public class Proveedor {

    private final ProveedoresDb db = new ProveedoresDb();
    private String ruc;
    private String razonSocial;
    private String direccion;
    private String cuenta;

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

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public Proveedor(String ruc, String razonSocial, String direccion, String cuenta) {
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.cuenta = cuenta;
    }

    private void registrarProveedor() {
        Proveedor prov = new Proveedor(getRuc(), getRazonSocial(), getDireccion(), getCuenta());
        db.setProveedores(prov);
    }
    
    private void actualizarProveedor() {
        //Proveedor prov = new Proveedor(getRuc(), getRazonSocial(), getDireccion(), getCuenta());
        //db.setProveedores(prov);
    }
}
