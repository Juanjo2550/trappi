package com.epn.trappi.models.rrhh.listas;

public interface Lista <T> {
    public void agregar(T newObject);
    public Boolean eliminar(String parametro);
    public T buscarUno(String parametro);
    public T[] obtenerTodos();
}
