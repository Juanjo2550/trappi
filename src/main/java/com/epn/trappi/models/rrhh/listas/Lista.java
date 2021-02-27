package com.epn.trappi.models.rrhh.listas;

public interface Lista <T> {
    public void agregar(T newObject);
    public Boolean eliminar();
    public T buscarUno();
    public T[] obtenerTodos();
}
