package com.epn.trappi.models.rrhh;

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
    private String resultados [];
    private PruebaAdmision prueba;

    public Aspirante(String nombre, String apellidos, String cedula, String telefono, String cargo, PruebaAdmision prueba) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.telefono = telefono;
        this.cargoAspirante = cargo;
        this.prueba = new PruebaAdmision(prueba.getPuntaje(), prueba.getActitudes(), prueba.getActitudes());
    }
    
    public void solicitarRegistroPrueba(String actitudes, String aptitudes, int puntaje ){
        //prueba.registrarResultadosPrueba();
    }
    
    
    public void obtenerDatos(){
        
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

    public String[] getResultados() {
        return resultados;
    }

    public PruebaAdmision getPrueba() {
        return prueba;
    }
    
    
}
