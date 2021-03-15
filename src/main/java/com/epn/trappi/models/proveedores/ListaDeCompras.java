package com.epn.trappi.models.proveedores;

import com.epn.trappi.db.proveedores.ProveedoresDb;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    private ArrayList<Compra> compras;
    private final ProveedoresDb db = new ProveedoresDb();

    public ListaDeCompras(ArrayList<Compra> compras) {
        this.compras = compras;
    }

    public ListaDeCompras() {
        this.compras = new ArrayList<>();
    }

    public void añadirCompra(Compra compra) {
        compras.add(compra);
    }

    public void retirarCompra(int indice) {
        compras.remove(indice);
    }

    public Compra obtenerCompra(int indentificacion) {
        Compra resultado = null;
        for (Compra compra : compras) {
            if (compra.getIdentificador() == indentificacion) {
                resultado = compra;
                break;
            }
        }
        return resultado;
    }

    public boolean realizarCompraEnConjunto() {
        boolean flag = true;
        for (Compra compra : compras) {
            if (!compra.comprar()) {
                flag = false;
            }
        }
        return flag;
    }

    public void mostrarLista(JTable jTable1) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Producto");
        model.addColumn("Cantidad");
        for (Compra compra : compras) {
            for (Bien cantidadBien : compra.getListaCantidadDeBienes().getListaBienes()) {
                model.addRow(new Object[]{cantidadBien.getNombre(), cantidadBien.getCantidad()});
            }
        }
        jTable1.setModel(model);
    }

    /*public void mostrarListaConDescripcion(JTable jTable1){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Número de Compra");
        model.addColumn("Fecha");
        model.addColumn("Estado");
        model.addColumn("Monto");
        for ( Compra compra:compras) {
            model.addRow(new Object[]{compra.getIdentificador(), compra.getFecha(),compra.getEstadoCompra().getEstado(),compra.getMontoTotal()});
        }
        jTable1.setModel(model);
    }*/
    public void mostrarListaConDescripcion(JTable jTable1, ArrayList<String[]> listaCompras) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Número de Compra");
        model.addColumn("Fecha");
        model.addColumn("Estado");
        model.addColumn("Monto");
        listaCompras.forEach(compra -> {
            System.out.println(Arrays.toString(compra));
            model.addRow(compra);
        });
        jTable1.setModel(model);
    }

    public ArrayList<Compra> getCompras() {
        return compras;
    }

    public void setCompras(ArrayList<Compra> compras) {
        this.compras = compras;
    }

    public void getCompra(int identificador, String estado, String monto, String fecha) {
        try {
            this.setCompras(db.obtenerCompra(identificador, estado, monto, fecha));
        } catch (SQLException ex) {
            Logger.getLogger(ListaDeCompras.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ListaDeCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
