package com.epn.trappi.models.rrhh.contratacion;

/**
 *
 * @author Javier Erazo
 */
public class Aspirante {
    private String nombre;
    private String apellidos;
    private String cedula;
    private String telefono;
    private String cargoAspirante;

    public Aspirante(String nombre, String apellidos, String cedula, String telefono, String cargo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.telefono = telefono;
        this.cargoAspirante = cargo;
        
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCargoAspirante() {
        return cargoAspirante;
    }

    
    
}
