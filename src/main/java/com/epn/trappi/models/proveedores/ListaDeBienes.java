package com.epn.trappi.models.proveedores;

import com.epn.trappi.db.proveedores.ProveedoresDb;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author franc
 */
public class ListaDeBienes {

    private ArrayList<Bien> listaBienes;
    private ProveedoresDb db = new ProveedoresDb();

    public ListaDeBienes(ArrayList<Bien> listaCantidadDeBienes) {
        this.listaBienes = listaCantidadDeBienes;
    }

    public ListaDeBienes() {
        listaBienes = new ArrayList<Bien>();
    }

    public ArrayList<Bien> getListaBienes() {
        return listaBienes;
    }

    
    public void setListaBienes(ArrayList<Bien> listaBienes) {
        this.listaBienes = listaBienes;
    }
    
    public void mostrarLista(JTable jTable1){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Producto");
        model.addColumn("Marca");
        model.addColumn("Precio Unitario");
        model.addColumn("Proveedor");
        for ( Bien bien:listaBienes) {
            model.addRow(new Object[]{bien.getNombre(),bien.getMarca(),bien.getPrecio()+"",bien.getProveeedor().getRazonSocial()});
        }
        jTable1.setModel(model);
    }

    //recibimos el bien y la cantidad y se hace el objeto CantidadDeBien
    public void añadirBien(Bien nuevoBien) {
        listaBienes.add(nuevoBien);
    }

    //tomo un objeto cantidad de bien, es decir debe ingresarse 
    public void quitarBien(Bien bienARetirar) {
        for (Bien aux : listaBienes) {
            if (aux == bienARetirar) {
                listaBienes.remove(aux);
            }
        }
    }

//    private void cargarProductos() {
//        String[] titulos = {"Nombre Producto", "Precio unitario", "Proveedor"};
//        String[] fila = new String[3];
//        modelo = new DefaultTableModel(null, titulos);
//        //Aquí cambie algo para que sirva, puse este iterador y luego castee la clase producto
//        for (Iterator it = seleccionados.iterator(); it.hasNext();) {
//            Producto producto = (Producto) it.next();
//            fila[0] = producto.getNombre();
//            fila[1] = "" + producto.getPrecio();
//            fila[2] = "" + producto.getProveeedor().getRazonSocial();
//            modelo.addRow(fila);
//        }
//        jtbProductos.setModel(modelo);
//    }

    @Override
    public String toString() {
        String retorno = "";
        for (Bien aux : listaBienes) {
            retorno += aux.toString() + aux.getCantidad();
        }
        return retorno;
    }

}
