
package com.epn.trappi.models.logistico;

public class Vehiculo {
    private int ID;
    private String matricula;
    private Estado estado;
    private String tipo;
    private int kilometraje;
    private FichaTecnica fichaTecnica;
    private Gps gps;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    public Vehiculo(){
        
    }

    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula){
        this.matricula=matricula;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Gps getGps() {
        return gps;
    }

    public void setGps(Gps gps) {
        this.gps = gps;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    public FichaTecnica getFichaTecnica() {
        return fichaTecnica;
    }

    public void setFichaTecnica(FichaTecnica fichaTecnica) {
        this.fichaTecnica = fichaTecnica;
    }
    
    
    
    public void actualizarEstado(Estado estado){
        this.estado = estado;
    }
    public void actualizarFicha(){
        
    }
    public Posicion notificarPosicion(){
        return this.gps.posicion;
    }
    
    public boolean entregando(){
        return true;
    }
    
}
