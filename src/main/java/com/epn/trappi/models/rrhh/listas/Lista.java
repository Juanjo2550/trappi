package com.epn.trappi.models.rrhh.listas;

public interface Lista {
    public Lista agregar();
    public Boolean eliminar();
    public Lista buscarUno();
    public Lista[] obtenerTodos();
}
