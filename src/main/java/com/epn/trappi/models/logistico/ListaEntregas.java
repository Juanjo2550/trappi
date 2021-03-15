package com.epn.trappi.models.logistico;

import java.util.ArrayList;

import com.epn.trappi.models.logistico.Entrega;
import com.epn.trappi.models.logistico.servicios.Consultable;
import com.epn.trappi.models.logistico.servicios.ServicioDb;
import com.epn.trappi.models.logistico.servicios.ServicioDbConductor;
import com.epn.trappi.models.logistico.servicios.ServicioDbEntrega;
import com.epn.trappi.models.logistico.servicios.Unible;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class ListaEntregas {
    private ArrayList<Entrega> entregas;

    public ListaEntregas() {
        entregas= new ArrayList<>();
    }
    public ListaEntregas(ArrayList<Entrega> lista){
        this.entregas=lista;
    }
    public void aniadirEntrega(Entrega nuevo){
        entregas.add(nuevo);
    }
    public ArrayList<Entrega> getEntregas(){
        return this.entregas;
    }

    public void setEntregas(ArrayList<Entrega> entregas) {
        this.entregas = entregas;
    }
    public DefaultTableModel mostrarLista(){
        int num_columnas = 7;
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id Entrega");
        modelo.addColumn("Id Empleado");
        modelo.addColumn("Matrícula");
        modelo.addColumn("Factura");
        modelo.addColumn("Estado");
        modelo.addColumn("Fecha");
        modelo.addColumn("Direccion");
        for (int i=0;i<this.entregas.size();i++){
            Entrega elemento = this.entregas.get(i);
            String[] registro = new String[num_columnas];
            registro[0]=String.valueOf(elemento.getID_Entrega());
            registro[1]=String.valueOf(elemento.getID_Empleado());
            registro[2]=String.valueOf(elemento.getMatricula());
            registro[3]=String.valueOf(elemento.getFactura());
            registro[4]=String.valueOf(elemento.getEstado());
            registro[5]=String.valueOf(elemento.getFecha());
            registro[6]=String.valueOf(elemento.getDireccion());
            modelo.addRow(registro);
        }
        return modelo;
    }
    public Boolean estaVacia(){
        if (this.entregas==null || this.entregas.size()==0){
            return true;
        }else{
            return false;
        }
    }
       public static int numViajesPorConductor(int año,int mes,int id) throws SQLException{
	ServicioDb servicio = new ServicioDbConductor();
	Unible joiner = new ServicioDbConductor();
	String fecha = año+"-"+mes+"-"+"99";
	Consultable entregas = new ServicioDbEntrega().obtenerElementosPorFiltro(ServicioDbEntrega.FECHA,fecha);
	ArrayList<Conductor> conductor = servicio.obtenerElementosPorFiltro(ServicioDbConductor.ID_CONDUCTOR,String.valueOf(id)).getDatos();	
	ArrayList<Entrega> entregas_por_conductor = (ArrayList<Entrega>) joiner.join(conductor,entregas);
	return entregas_por_conductor.size();
    } 
}