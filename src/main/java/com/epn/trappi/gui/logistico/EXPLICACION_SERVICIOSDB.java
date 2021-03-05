/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.logistico;

import com.epn.trappi.models.logistico.Entrega;
import com.epn.trappi.models.logistico.ListaEntregas;
import com.epn.trappi.models.logistico.ListaVehiculos;
import com.epn.trappi.models.logistico.Mantenimiento;
import com.epn.trappi.models.logistico.Vehiculo;
import com.epn.trappi.models.logistico.servicios.Consultable;
import com.epn.trappi.models.logistico.servicios.ServicioDb;
import com.epn.trappi.models.logistico.servicios.ServicioDbEntrega;
import com.epn.trappi.models.logistico.servicios.ServicioDbMantenimiento;
import com.epn.trappi.models.logistico.servicios.ServicioDbVehiculo;
import com.epn.trappi.models.logistico.servicios.Unible;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alexander
 */
public class EXPLICACION_SERVICIOSDB {
    
    /*EJEMPLOS DE CONSULTAS
    SUGERENCIA: Reusa los objetos Consultable y ServicioDb usando polimorfismo.
    */
    
    
    public void consultarEntregas() throws SQLException{
        ServicioDb servicio = new ServicioDbEntrega();
        Consultable consultable = servicio.obtenerElementos();
        ArrayList<Entrega> entregas = consultable.getDatos();
    }
    public void consultarEntregasFinalizadas() throws SQLException{
        ServicioDb servicio = new ServicioDbEntrega();
        //Cada servicio tiene sus constantes para especificar la columna por la que se filtrará
        Consultable consultable = servicio.obtenerElementosPorFiltro(ServicioDbEntrega.ESTADO,"Finalizado");
        ArrayList<Entrega> entregas = consultable.getDatos();
    }
    //Si se desea obtener los datos en formato de tabla para visualizar
    public DefaultTableModel obtenerModeloEntregas() throws SQLException{
        ServicioDb servicio = new ServicioDbEntrega();
        Consultable consultable = servicio.obtenerElementos();
        ArrayList<Entrega> entregas = consultable.getDatos();
        //Cada modelo tiene una Lista de datos
        ListaEntregas lista = new ListaEntregas(entregas);
        DefaultTableModel modelo = lista.mostrarLista();
        return modelo;
    }
    public DefaultTableModel obtenerModeloVehiculosTipoMoto() throws SQLException{
        ServicioDb servicio = new ServicioDbVehiculo();
        Consultable consultable = servicio.obtenerElementosPorFiltro(ServicioDbVehiculo.TIPO,"Motocicleta");
        ArrayList<Vehiculo> vehiculos = consultable.getDatos();
        //Cada modelo tiene una Lista de datos
        ListaVehiculos lista = new ListaVehiculos(vehiculos);
        DefaultTableModel modelo = lista.mostrarLista();
        return modelo;
    }
    //Se puede utilizar la interfaz Unible para realizar uniones de tablas es decir SELECT * FROM A JOIN B
    public void joinEntregasConductores() throws SQLException{
        ServicioDb servicio = new ServicioDbEntrega();
        Consultable consultable = servicio.obtenerElementos();
        ArrayList<Entrega> entregas = consultable.getDatos();
        //AHORA SE VA A HACER JOIN CON LA TABLA DE VEHICULOS
        //ES DECIR QUE SE OBTENDRA LOS ELEMENTOS QUE VEHICULO TIENE EN COMUN CON NUESTRO ARREGLO
        //IMPORTANTE: LOS ELEMENTOS DE ENTREGAS NO SE ELIMINAN, SOLO SE OBTIENE LOS ELEMENTOS EN COMUN
        Unible unible = new ServicioDbEntrega();
        consultable = new ServicioDbVehiculo().obtenerElementos(); //A estos datos se aplicara el filtrado
        Object o =  unible.join(entregas,consultable);
        ArrayList<Vehiculo> vehiculos = (ArrayList<Vehiculo>) o;
    }
    public void joinEntregasFinalizadasYVehiculosTipoAutomovil() throws SQLException{
        ServicioDb servicio = new ServicioDbEntrega();
        Consultable consultable = servicio.obtenerElementosPorFiltro(ServicioDbEntrega.ESTADO,"Finalizado");
        ArrayList<Entrega> entregas = consultable.getDatos();
        Unible unible = new ServicioDbEntrega();
        consultable = new ServicioDbVehiculo().obtenerElementosPorFiltro(ServicioDbVehiculo.TIPO,"Automovil");
        Object o =  unible.join(entregas,consultable);
        ArrayList<Vehiculo> vehiculos = (ArrayList<Vehiculo>) o;
    }
    public void tripleJoinEntregasEnCursoYVehiculosYMantenimientos() throws SQLException{
        //Este metodo primero filtra las entregas por aquellas que esten activas
        //Luego obtiene la lista de vehiculos que correspondan a esos registros ("vehiculos activos")
        //Luego de esos vehiculos activos obtiene la lista de todos los mantenimientos de esos vehiculos
        ServicioDb servicio = new ServicioDbEntrega();
        ArrayList<Entrega> entregas_activas = servicio.obtenerElementosPorFiltro(ServicioDbEntrega.ESTADO,"En curso").getDatos();
        Unible unible = new ServicioDbEntrega();
        Consultable consultable =  new ServicioDbVehiculo().obtenerElementos();
        ArrayList<Vehiculo> vehiculos_activos = (ArrayList<Vehiculo>) unible.join(entregas_activas, consultable);
        unible = new ServicioDbVehiculo();
        consultable = new ServicioDbMantenimiento().obtenerElementos();
        ArrayList<Mantenimiento> historial_mantenimientos = (ArrayList<Mantenimiento>) unible.join(vehiculos_activos, consultable);
    }
    /*IMPORTANTE: Los tamaños de los arraylist resultado de un join no son los mismos ya que como es el caso de los mantenimientos,
    puede haber muchos mantenimientos en fechas diferentes para los mismos vehiculos.
    NOTA: Se puede volver a hacer joins ilimitadamente, pero al ser un sistema pequeño lo mas probable es que no lo utilicen,
    también se puede aplicar filtros adicionales a cada Tabla que va a ser unible, es decir que tambien podiamos haber hecho esto
    Filtrar entregas activas con vehiculos tipo moto y mantenimientos de hace 1 mes.
    */
    
    /*INSERCIONES Y ACTUALIZACIONES DE DATOS*
    NOTA: No hay eliminación de datos porque nuestro modulo no deberia poder eliminar datos
    */
    
    public void insertarMantenimiento() throws SQLException{
        Mantenimiento m = new Mantenimiento();
        m.setIdMantenimiento(1);
        m.setMatricula("PBC-232");
        m.setDetalleMantenimiento("Cambio de aceite");
        m.setValorGasto(500.0);
        ServicioDb servicio = new ServicioDbMantenimiento();
        servicio.insertar(m);
    }
    
    public void actualizarMantenimiento() throws SQLException{
        Mantenimiento m = new Mantenimiento();
        m.setIdMantenimiento(1);
        m.setValorGasto(25.5);
        ServicioDb servicio = new ServicioDbMantenimiento();
        servicio.actualizar(servicio);
        //Solo se puede actualizar el gasto, no puedes cambiar matricula, detalles, id para asegurar la integridad de datos
    }
    
    /*
    Se puede usar los objetos consultable en conjunto con servicios para actualizar de manera mas extensa
    */
    
    public void enviarAMantenimientoAVehiculosInhabilitados() throws SQLException{
        Consultable consultable = new ServicioDbVehiculo().obtenerElementosPorFiltro(ServicioDbVehiculo.ESTADO,"Inhabilitado");
        ArrayList<Vehiculo> vehiculos = consultable.getDatos();
        ServicioDb servicio = new ServicioDbMantenimiento();
        for (int i=0;i<vehiculos.size();i++){
            Mantenimiento m = new Mantenimiento();
            m.setIdMantenimiento(i);
            m.setValorGasto(0.0);
            m.setDetalleMantenimiento("Mantenimiento de rutina");
            m.setMatricula(vehiculos.get(0).getMatricula());
            servicio.insertar(m);
        }
    }
    
}
