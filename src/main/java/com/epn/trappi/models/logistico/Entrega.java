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
    
    public void actualizarEstado(Vehiculo vehiculo,Conductor conductor,Posicion destino){
        /*
        utiliza los datos de parametros para crear un registro de entrega activa tal y como ya lo hemos
        hecho en el panel de rutas, con la diferencia de que ahora se añade a una tabla en la base de datos
        que contiene las entregas activas.
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
        En este bloque se asume que se utiliza los datos recibidos y junto a los atributos de esta clase
        como lo es la direccion de destino. Para crear un registro en la base de datos con la entrega
        que se realizó.
        */
        /*
        En este bloque se elimina el registro de entrega activa de la base de datos.
        */
        /*
        En este bloque se cambia el estado del conductor y el vehiculo a disponible otra vez.
        */
    }
    
    
    public void deserializar(String datos){
        
    }
    
    
}