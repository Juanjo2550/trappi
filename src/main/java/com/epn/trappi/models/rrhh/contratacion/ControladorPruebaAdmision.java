package com.epn.trappi.models.rrhh.contratacion;

import com.epn.trappi.models.rrhh.listas.ListaAspirantes;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 *
 * @author Javier Erazo
 */
public class ControladorPruebaAdmision {
    private int puntajeBase;
    private String actitudesBase;
    private String aptitudesBase;
    private boolean aprobacion;
    private ListaAspirantes aspirantes;
    
    public ControladorPruebaAdmision(int puntajeBase, String actitudesBase, String aptitudesBase){
        this.puntajeBase = puntajeBase;
        this.actitudesBase = actitudesBase;
        this.aptitudesBase = aptitudesBase;
        aspirantes = new ListaAspirantes();
        
    }
    public ArrayList <Aspirante> obtenerAspirantesAptos(){
        ArrayList <Aspirante> asp = new ArrayList<>();
         asp = aspirantes.selectAll();
        for (Aspirante a: asp){
            if(validarPruebaAdmision(a.getPrueba()))
                asp.add(a);
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
}
