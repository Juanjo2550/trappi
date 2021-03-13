package com.epn.trappi.models.proveedores;

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


    public void añadirCompra(Compra compra){
        compras.add(compra);
    }
    
    public void retirarCompra(Compra compra){
        compras.remove(compra);
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
    
    public ArrayList<Compra> getCompras() {
        return compras;
    }

    public void setCompras(ArrayList<Compra> compras) {
        this.compras = compras;
    }
    
}
