/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.logistico.servicios;

import java.util.ArrayList;

/**
 * 
 * @author Alexander
 * @param <Tipo>
 * Esta clase sirve para poder aplicar operaciones adicionales a los datos resultado de una consulta a la base de datos.
 * Si no es necesario ninguna operación, basta con llamar al método getDatos para obtener los resultados de la consulta.
 * Se puede hacer relaciones de herencia si se desea añadir funcionalidades más especializadas.
 */
public class Consultable <Tipo>{
    ArrayList<Tipo> registros; 
    public Consultable(ArrayList<Tipo> registros){
        this.registros=registros;
    }
    public ArrayList<Tipo> getDatos(){
        return this.registros;
    }
    public void limitarRegistros(int num_registros){
        
    }
    public String getType(){
        return registros.get(0).getClass().getSimpleName();
    }
}
