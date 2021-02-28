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
    private String resultados [];
    private PruebaAdmision prueba;

    public Aspirante(String nombre, String apellidos, String cedula, String telefono, String cargo, int puntaje, String actitudes, String aptitudes) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.telefono = telefono;
        this.cargoAspirante = cargo;
        this. prueba = new PruebaAdmision();
        solicitarRegistroPrueba(actitudes, aptitudes, puntaje);
        
    }
    
    public void solicitarRegistroPrueba(String actitudes, String aptitudes, int puntaje ){
        this.prueba.registrarResultadosPrueba(puntaje, actitudes, aptitudes);
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

    

    public PruebaAdmision getPrueba() {
        return prueba;
    }
    
    
}
