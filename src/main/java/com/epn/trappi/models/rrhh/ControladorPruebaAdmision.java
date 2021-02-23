package com.epn.trappi.models.rrhh;

/**
 *
 * @author Javier Erazo
 */
public class ControladorPruebaAdmision {
    private int puntajeBase;
    private String[] actitudesBase;
    private String[] aptitudesBase;
    private boolean aprobacion;
    private PruebaAdmision prueba;
    
    public ControladorPruebaAdmision(int puntajeBase, String[] actitudesBase, String[] aptitudesBase){
        this.puntajeBase = puntajeBase;
        this.actitudesBase = actitudesBase;
        this.aptitudesBase = aptitudesBase;
        
    }
    public void validarPruebaAdmision(){
        
    }
    
    private void verificarAptitudes(){
        String aptitudes = prueba.getAptitudes();
        
    }
}
