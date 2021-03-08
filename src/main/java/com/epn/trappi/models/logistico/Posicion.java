package com.epn.trappi.models.logistico;

public class Posicion {
    private String latitud;
    private String longitud;
    private String  fcids;
    private String direccion;


    public Posicion(String fcid) {
        fcids= fcid;
    }

    public String getFcids() {
        return fcids;
    }

    public void setFcids(String fcids) {
        this.fcids = fcids;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    
    
}