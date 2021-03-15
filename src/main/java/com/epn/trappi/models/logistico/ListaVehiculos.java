
package com.epn.trappi.models.logistico;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ListaVehiculos {
    private ArrayList<Vehiculo> vehiculos;
    
    public ListaVehiculos(){
        this.vehiculos = new ArrayList<>();
    }
    public ListaVehiculos(ArrayList<Vehiculo> lista){
        this.vehiculos = lista;
    }
    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    
    public void agregarVehiculo(Vehiculo vehiculo){
        vehiculos.add(vehiculo);
    }
    public void eliminarVehiculo(Vehiculo vehiculo){
        
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    
    public DefaultTableModel mostrarLista(){
        int num_columnas = 5;
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id Vehiculo");
        modelo.addColumn("Matrícula");
        modelo.addColumn("Estado");
        modelo.addColumn("Tipo");
        modelo.addColumn("Kilometraje");
        for (int i=0;i<this.vehiculos.size();i++){
            Vehiculo elemento = this.vehiculos.get(i);
            String[] registro = new String[num_columnas];
            registro[0]=String.valueOf(elemento.getID());
            registro[1]=String.valueOf(elemento.getMatricula());
            registro[2]=String.valueOf(elemento.getEstado());
            registro[3]=String.valueOf(elemento.getTipo());
            registro[4]=String.valueOf(elemento.getKilometraje());
            modelo.addRow(registro);
        }
        return modelo;
    }
    
    public Boolean estaVacia(){
        if (this.vehiculos==null || this.vehiculos.size()==0){
            return true;
        }else{
            return false;
        }
    }
}
