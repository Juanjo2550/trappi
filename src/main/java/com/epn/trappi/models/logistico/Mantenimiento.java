
package com.epn.trappi.models.logistico;


public class Mantenimiento {
    private int idMantenimiento;
    private String matricula;
    private String detalleMantenimiento;
    private double valorGasto;
    
    public Mantenimiento(){
        
    }
    public Mantenimiento(int idMantenimiento, String matricula, String detalleMantenimiento) {
        this.idMantenimiento = idMantenimiento;
        this.matricula = matricula;
        this.detalleMantenimiento = detalleMantenimiento;
        this.valorGasto = 0.0;
    }

    public int getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(int idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getDetalleMantenimiento() {
        return detalleMantenimiento;
    }

    public void setDetalleMantenimiento(String detalleMantenimiento) {
        this.detalleMantenimiento = detalleMantenimiento;
    }

    public double getValorGasto() {
        return valorGasto;
    }

    public void setValorGasto(double valorGasto) {
        this.valorGasto = valorGasto;
    }
    
    
        
}
