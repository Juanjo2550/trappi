package com.epn.trappi.models.proveedores;

import java.sql.SQLException;
import java.util.ArrayList;
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
public class ListaDeCompras {
    private ArrayList <Compra> compras;

    public ListaDeCompras(ArrayList<Compra> compras) {
        this.compras = compras;
    }
    
    public ListaDeCompras() {
        this.compras = new ArrayList<>();
    }

    public void añadirCompra(Compra compra){
        compras.add(compra);
    }
    
    public void retirarCompra(int indice){
        compras.remove(indice);
    }
    
    public Compra obtenerCompra(int indentificacion) {
        Compra resultado = null;
        for (Compra compra : compras) {
            if (compra.getIdentificador()==indentificacion) {
                resultado = compra;
                break;
            }
        }
        return resultado;
    }
    
    public void realizarCompraEnConjunto(){
        for(Compra compra: compras){
            compra.comprar();
        }
    }
    
    public void mostrarLista(JTable jTable1){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Producto");
        model.addColumn("Cantidad");
        for ( Compra compra:compras) {
            for (Bien cantidadBien : compra.getListaCantidadDeBienes().getListaBienes()) {
                model.addRow(new Object[]{cantidadBien.getNombre(), cantidadBien.getCantidad()});
            }
        }
        jTable1.setModel(model);
    }
    
    public void mostrarListaConDescripcion(JTable jTable1){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Número de Compra");
        model.addColumn("Fecha");
        model.addColumn("Estado");
        model.addColumn("Monto");
        for ( Compra compra:compras) {
            model.addRow(new Object[]{compra.getIdentificador(), compra.getFecha(),compra.getEstadoCompra().getEstado(),compra.getMontoTotal()});
        }
        jTable1.setModel(model);
    }
    
    public ArrayList<Compra> getCompras() {
        return compras;
    }

    public void setCompras(ArrayList<Compra> compras) {
        this.compras = compras;
    }
    
}
