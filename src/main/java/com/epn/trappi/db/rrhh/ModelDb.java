package com.epn.trappi.db.rrhh;

public interface ModelDb <T> {
    public void agregar(T newObject);
    public T buscarUno(String parametro);
    public T[] obtenerTodos();
}
