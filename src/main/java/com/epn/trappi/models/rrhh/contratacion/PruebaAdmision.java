package com.epn.trappi.models.rrhh.contratacion;

import com.epn.trappi.models.rrhh.listas.ListaAspirantes;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 *
 * @author Javier Erazo
 */
public class PruebaAdmision {
    private int puntaje;
    private String actitudes;
    private String aptitudes;
    private int puntajeBase;
    private String actitudesBase;
    private String aptitudesBase;
    private ListaAspirantes aspirantes;
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
    
        public ArrayList <Aspirante> obtenerAspirantesAptos(){
        ArrayList <Aspirante> asp = new ArrayList<>();
         asp = aspirantes.obtenerTodos();
        for (Aspirante a: asp){
//            if(validarPruebaAdmision(a.getPrueba()))
//                asp.add(a);
        }
        return asp;
    }
    public boolean validarPruebaAdmision(PruebaAdmision prueba){
        return (verificarActitudes(prueba) && verificarAptitudes(prueba)  && (prueba.getPuntaje() >= this.puntajeBase));
    }
    
    private boolean verificarAptitudes(PruebaAdmision prueba){
        String aptitudes = prueba.getAptitudes();
        Vector v = new Vector();
        StringTokenizer tokens = new StringTokenizer(aptitudes);
        while(tokens.hasMoreTokens()){
            v.add(tokens.nextToken());
        }
        for (int i = 0; i < v.size(); i++){
            if (this.aptitudesBase.contains(String.valueOf(v.elementAt(i))))
                return true;
        }
        return false;
        
    }
    private boolean verificarActitudes(PruebaAdmision prueba){
        String actitudes = prueba.getActitudes();
        Vector v = new Vector();
        StringTokenizer tokens = new StringTokenizer(actitudes);
        while(tokens.hasMoreTokens()){
            v.add(tokens.nextToken());
        }
        for (int i = 0; i < v.size(); i++){
            if (this.actitudesBase.contains(String.valueOf(v.elementAt(i))))
                return true;
        }
        return false;
        
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
