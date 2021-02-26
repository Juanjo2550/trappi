package com.epn.trappi.models.logistico;

public class Entrega {
    private boolean estado;
    private Posicion destino;

    public Entrega(Posicion destino) {
        estado=true;
        setDestino(destino);
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getDestino() {
        return destino.getFcids();
    }

    public void setDestino(Posicion destino) {
        this.destino = destino;
    }
    
    public void actualizarEstado(Vehiculo vehiculo,Conductor conductor){
        /*
        En este método se actualiza el estado de la entrega ya creada, practicamente se 
        cambia a estado "finalizada". Adicionalmente, se cambia el estado del empleado conductor y 
        del vehiculo a disponible.
        */
    }
    
    public void confirmarEntrega(String datos){
        //Se deserializa el String para obtener la direccion de destino y el nombre del cliente.
        deserializar(datos);
        //Se llama al método asignar del control de disponibilidad
        ControlDisponibilidad control = null;
        control.asignar(this.destino);
    }
    
    public void RegistrarEntrega(Vehiculo vehiculo,Conductor conductor){
        /*
        En este bloque se registra la entrega en la base de datos, y luego se ejecuta el metodo simulacion movimiento.
        */
    }
    
    
    public void deserializar(String datos){
        
    }
    
    
}