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

    public Aspirante(String nombre, String apellidos, String cedula, String telefono, String cargo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.telefono = telefono;
        this.cargoAspirante = cargo;
    }
    
    public void solicitarRegistroPrueba(String actitudes, String aptitudes, int puntaje ){
        //prueba.registrarResultadosPrueba();
    }
    
    
    public void obtenerDatos(){
        
    }
    
}
