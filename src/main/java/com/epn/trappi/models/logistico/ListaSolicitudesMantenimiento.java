/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.logistico;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alexander
 */
public class ListaSolicitudesMantenimiento {
    private ArrayList<SolicitudMantenimiento> listaSolicitudes;

    public ListaSolicitudesMantenimiento() {
        this.listaSolicitudes = new ArrayList<>();    
    }
    public ListaSolicitudesMantenimiento(ArrayList<SolicitudMantenimiento> lista){
        this.listaSolicitudes=lista;
    }
    public void aniadirSolicitudMantenimiento(SolicitudMantenimiento nuevo){
        this.listaSolicitudes.add(nuevo);
    }
    public ArrayList<SolicitudMantenimiento> getSolicitudes(){
        return this.listaSolicitudes;
    }

    public ArrayList<SolicitudMantenimiento> getListaSolicitudes() {
        return listaSolicitudes;
    }

    public void setListaSolicitudes(ArrayList<SolicitudMantenimiento> listaSolicitudes) {
        this.listaSolicitudes = listaSolicitudes;
    }
    
    public DefaultTableModel mostrarLista(){
        int num_columnas = 5;
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Número");
        modelo.addColumn("Id Bien");
        modelo.addColumn("Id mantenimiento");
        modelo.addColumn("Fecha");
        modelo.addColumn("Estado");
        for (int i=0;i<this.listaSolicitudes.size();i++){
            SolicitudMantenimiento elemento = this.listaSolicitudes.get(i);
            String[] registro = new String[num_columnas];
            registro[0]=String.valueOf(elemento.getId_Solicitud());
            registro[1]=String.valueOf(elemento.getId_Bien());
            registro[2]=String.valueOf(elemento.getId_Mantenimiento());
            registro[3]=String.valueOf(elemento.getFecha());
            registro[4]=String.valueOf(elemento.getEstado());
            modelo.addRow(registro);
        }
        return modelo;
    }
    public Boolean estaVacia(){
        if (this.listaSolicitudes==null || this.listaSolicitudes.size()==0){
            return true;
        }else{
            return false;
        }
    }
}
