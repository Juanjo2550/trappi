/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.logistico;

import java.sql.Date;

/**
 *
 * @author Alexander
 */
public class SolicitudMantenimiento {
    private int id_Solicitud;
    private int id_bien;
    private int id_Mantenimiento;
    private String estado;
    private Date fecha;

    public int getId_bien() {
        return id_bien;
    }


    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getId_Solicitud() {
        return id_Solicitud;
    }

    public void setId_Solicitud(int id_Solicitud) {
        this.id_Solicitud = id_Solicitud;
    }

    public int getId_Bien() {
        return id_bien;
    }

    public void setId_Bien(int id_bien) {
        this.id_bien = id_bien;
    }

    public int getId_Mantenimiento() {
        return id_Mantenimiento;
    }

    public void setId_Mantenimiento(int id_Mantenimiento) {
        this.id_Mantenimiento = id_Mantenimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
