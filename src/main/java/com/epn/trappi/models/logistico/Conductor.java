package com.epn.trappi.models.logistico;

public class Conductor {
    private String nombre;
    private boolean estado;
    private String cedula;

    public Conductor(String nombre, boolean estado) {
        this.nombre = nombre;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public String getCedula(){
        return this.cedula;
    }
}