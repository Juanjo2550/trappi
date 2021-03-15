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
public interface ServicioDb <Tipo>{
    /*Se utilizan consultables dado que se espera que esas listas de elementos puedan ser procesadas de distintos modos,
    como limitar el número de registros, groupBy, etc. Y se espera que estos objetos consultable puedan servir como parámetro
    para otros métodos que hagan uso de ellos y los relacionen con otros consultables, tal como lo hace la interfaz Unible.
    IMPORTANTE: Un consultable siempre tiene un arreglo de datos, de modo que si se desea obtener los datos que sirvieron para
    crear este consultable es suficiente con llamar a su método getDatos() el cual retorna un arreglo tipo ArrayList<Tipo>.
    */
    public Consultable obtenerElementos() throws SQLException;
    public Tipo obtenerElemento(int llave_primaria) throws SQLException;
    public Consultable obtenerElementosPorFiltro(String COLUMN_NAME_CONSTANT,String VALOR) throws SQLException;
    public void insertar(Tipo elemento) throws SQLException;
    public void actualizar(Tipo elemento) throws SQLException;
}
