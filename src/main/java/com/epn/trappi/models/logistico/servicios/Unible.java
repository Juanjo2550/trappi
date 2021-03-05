/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.logistico.servicios;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alexander
 * @param <Tipo>
 */
public interface Unible <Tipo>{
    /*
    OBJETIVO: Retornar un Object ArrayList<type> con los elementos en común que tiene el objeto Consultable con respecto al
    arreglo usado_para_join y una atributo foraneo fijo.
    
    Esta interfaz la debe implementar cualquier clase Tipo que desee proveer de join con otros. El funcionamiento consiste
    en recibir un arreglo usado_para_join que será el arreglo base respecto al cual se buscará los elementos en común "join",
    el objeto consultable posee un arreglo que sera el que se comparará con el arreglo usado_para_join. La clase consultable
    tiene el metodo getType() que sirve para distinguir el tipo genérico con el que trabaja. Se puede utilizar condicionales 
    para admitir diferentes consultables y ampliar las capacidades del método.
    Este método retorna un objeto Object, este Object debe ser del tipo ArrayList<consultable.getType()>, dado que la clase 
    ArrayList<> hereda de Object, es posible hacer Object objeto_arreglo = ArrayList<type> y posteriormente 
    castear según sea necesario. Esto es, ArrayList<Entrega> entregas = (ArrayList<Entrega>) objeto_arreglo.
    */
    public Object join(ArrayList<Tipo> usado_para_join,Consultable consultable) throws SQLException;
}
