package com.epn.trappi.models.proveedores;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author franc
 */
public class AnalizadorDeInventario {

    Inventario inventario;

    public ListaDeCompras analizarStockNormal() {
        try {
            boolean proveedor = false;
            inventario = new Inventario();
            ListaDeCompras solicitud = new ListaDeCompras(new ArrayList<Compra>());

            for (Bien cantidadBien : inventario.getListaDeBienesNormales().getListaBienes()) {
                if (cantidadBien.getCantidad() <= 10) {
                    proveedor = false;
                    for (Compra compra : solicitud.getCompras()) {
                        if (compra.getListaCantidadDeBienes().getListaBienes().get(0).getProveeedor().getRazonSocial().equalsIgnoreCase(
                                cantidadBien.getProveeedor().getRazonSocial())) {
                            proveedor = true;
                            compra.getListaCantidadDeBienes().añadirBien(new Producto(
                                    cantidadBien.getNombre(), cantidadBien.getPrecio(), cantidadBien.getProveeedor(), 100, cantidadBien.getMarca(),cantidadBien.getCategoria()));
                        }
                    }
                    if (proveedor == false) {
                        ListaDeBienes lista = new ListaDeBienes();
                        lista.añadirBien(new Producto(
                                cantidadBien.getNombre(), cantidadBien.getPrecio(), cantidadBien.getProveeedor(), 100, cantidadBien.getMarca(),cantidadBien.getCategoria()));
                        solicitud.añadirCompra(new CompraDeProducto(inventario, lista, "Pendiente"));
                    }
                }
            }

            return solicitud;
        } catch (IOException ex) {
            Logger.getLogger(AnalizadorDeInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void mostrarGraficaNormal(JPanel jPanel1) {
        try {
            inventario = new Inventario();
            ArrayList<Bien> lista = inventario.getListaDeBienesNormales().getListaBienes();
            lista.forEach(bien -> {
                System.out.println(bien.getNombre() + ";" + bien.getCantidad() + ";" + bien.getProveeedor().getRazonSocial());
            });
            DefaultCategoryDataset datos = new DefaultCategoryDataset();

            lista.forEach(bien -> {
                datos.setValue(bien.getCantidad(), bien.getNombre(), bien.getNombre());
            });
            JFreeChart ch = ChartFactory.createBarChart("Análisis del stock normal", "Producto", "Cantidad", datos, PlotOrientation.VERTICAL, true, true, false);
            BarRenderer renderer = (BarRenderer) ch.getCategoryPlot().getRenderer();
            renderer.setMaximumBarWidth(100.0);
            renderer.setItemMargin(-2.00);
            CategoryPlot plot = ch.getCategoryPlot();
            plot.setBackgroundPaint(Color.WHITE);
            plot.setDomainGridlinePaint(Color.WHITE);
            plot.setRangeGridlinePaint(Color.white);
            plot.setOutlineVisible(false);
            ChartPanel cp = new ChartPanel(ch);
            jPanel1.add(cp);
            cp.setBounds(0, 0, 500, 450);
        } catch (IOException ex) {
            Logger.getLogger(AnalizadorDeInventario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public ListaDeCompras analizarStockVIP() {
        try {
            boolean proveedor = false;
            inventario = new Inventario();
            ListaDeCompras solicitud = new ListaDeCompras(new ArrayList<Compra>());

            for (Bien cantidadBien : inventario.getListaDeBienesVIP().getListaBienes()) {
                if (cantidadBien.getCantidad() <= 10) {
                    proveedor = false;
                    for (Compra compra : solicitud.getCompras()) {
                        if (compra.getListaCantidadDeBienes().getListaBienes().get(0).getProveeedor().getRazonSocial().equalsIgnoreCase(
                                cantidadBien.getProveeedor().getRazonSocial())) {
                            proveedor = true;
                            compra.getListaCantidadDeBienes().añadirBien(new Producto(
                                    cantidadBien.getNombre(), cantidadBien.getPrecio(), cantidadBien.getProveeedor(), 100, cantidadBien.getMarca(),cantidadBien.getCategoria()));
                        }
                    }
                    if (proveedor == false) {
                        ListaDeBienes lista = new ListaDeBienes();
                        lista.añadirBien(new Producto(
                                cantidadBien.getNombre(), cantidadBien.getPrecio(), cantidadBien.getProveeedor(), 100, cantidadBien.getMarca(),cantidadBien.getCategoria()));
                        solicitud.añadirCompra(new CompraDeProducto(inventario, lista, "Pendiente"));
                    }
                }
            }

            return solicitud;
        } catch (IOException ex) {
            Logger.getLogger(AnalizadorDeInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void mostrarGraficaVIP(JPanel jPanel1) {
        try {
            inventario = new Inventario();
            ArrayList<Bien> lista = inventario.getListaDeBienesVIP().getListaBienes();
            lista.forEach(bien -> {
                System.out.println(bien.getNombre() + ";" + bien.getCantidad() + ";" + bien.getProveeedor().getRazonSocial());
            });
            DefaultCategoryDataset datos = new DefaultCategoryDataset();

            lista.forEach(bien -> {
                datos.setValue(bien.getCantidad(), bien.getNombre(), bien.getNombre());
            });
            JFreeChart ch = ChartFactory.createBarChart("Análisis del stock VIP", "Producto", "Cantidad", datos, PlotOrientation.VERTICAL, true, true, false);
            ChartPanel cp = new ChartPanel(ch);
            jPanel1.add(cp);
            cp.setBounds(0, 0, 500, 450);
        } catch (IOException ex) {
            Logger.getLogger(AnalizadorDeInventario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
