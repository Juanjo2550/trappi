package com.epn.trappi.models.rrhh;

/**
 *
 * @author Javier Erazo
 */
public class PruebaAdmision {
    private int puntaje;
    private String actitudes;
    private String aptitudes;
    

    public PruebaAdmision(int puntaje, String actitudes, String aptitudes) {
        this.puntaje = puntaje;
        this.actitudes = actitudes;
        this.aptitudes = aptitudes;
        
    }
    public PruebaAdmision(){
        
    }
    
    public void registrarResultadosPrueba( int puntaje, String actitudes, String aptitudes){
  
        this.puntaje = puntaje;
        this.actitudes = actitudes;
        this.aptitudes = aptitudes;
    }
    
    
    public int getPuntaje() {
        return puntaje;
    }

    public String getActitudes() {
        return actitudes;
    }

    public String getAptitudes() {
        return aptitudes;
    }

   
    
    
}
