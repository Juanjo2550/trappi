package com.epn.trappi.models.rrhh.contratacion;

import com.epn.trappi.models.rrhh.listas.Lista;
import com.epn.trappi.db.rrhh.AspirantesDB;
import com.epn.trappi.db.rrhh.PruebasAdmisionDB;
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
    private String aprobacion;
    private AspirantesDB aspirantes;
    private Lista pruebas;
    public PruebaAdmision(int puntaje, String actitudes, String aptitudes) {
        this.puntaje = puntaje;
        this.actitudes = actitudes;
        this.aptitudes = aptitudes;
        this.aprobacion = "Pendiente";
        
    }
    public PruebaAdmision(){
        pruebas = (Lista) new PruebasAdmisionDB();
        aspirantes = new AspirantesDB();
    }
    
    public void registrarResultados( int puntaje, String actitudes, String aptitudes){
  
        this.puntaje = puntaje;
        this.actitudes = actitudes;
        this.aptitudes = aptitudes;
    }
    
    public ArrayList <Aspirante> obtenerAspirantesAptos(String actitudes, String aptitudes, int puntaje){
       ArrayList <Aspirante> aspirantesAptos = new ArrayList<>();
        Aspirante[] aspirantesOb = aspirantes.obtenerTodos();
        for (Aspirante asp: aspirantesOb){
            if(validarPrueba(asp.getCedula(), actitudes, aptitudes, puntaje))
               aspirantesAptos.add(asp);
        }
        return aspirantesAptos;
    }
    public boolean validarPrueba(String cedulaAsp, String actitudes, String aptitudes, int puntaje){
        PruebaAdmision prueba = (PruebaAdmision)pruebas.buscarUno(cedulaAsp);
        return (verificarActitudes(prueba, actitudes) && verificarAptitudes(prueba, aptitudes)  && (prueba.getPuntaje() >= puntaje));
    }
    
    private boolean verificarAptitudes(PruebaAdmision prueba, String aptitudesBase){
        String aptitudesPrueba = prueba.getAptitudes();
        Vector v = new Vector();
        StringTokenizer tokens = new StringTokenizer(aptitudesPrueba);
        while(tokens.hasMoreTokens()){
            v.add(tokens.nextToken());
        }
        for (int i = 0; i < v.size(); i++){
            if (aptitudesBase.contains(String.valueOf(v.elementAt(i))))
                return true;
        }
        return false;
        
    }
    private boolean verificarActitudes(PruebaAdmision prueba, String actitudesBase){
        String actitudesPrueba = prueba.getActitudes();
        Vector v = new Vector();
        StringTokenizer tokens = new StringTokenizer(actitudesPrueba);
        while(tokens.hasMoreTokens()){
            v.add(tokens.nextToken());
        }
        for (int i = 0; i < v.size(); i++){
            if (actitudesBase.contains(String.valueOf(v.elementAt(i))))
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
    
    public String getAprobacion() {
        return aprobacion;
    }
    
   
    
    
}
