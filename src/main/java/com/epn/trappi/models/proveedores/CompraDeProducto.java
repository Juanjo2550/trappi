/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.proveedores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;

/**
 *
 * @author franc
 */
public class CompraDeProducto extends Compra {

    public CompraDeProducto() {
        super();
    }

    public CompraDeProducto(ListaDeBienes listaBienesAComprar, String estado, Double montoTotal, String fecha, int identificador) throws IOException {
        super(listaBienesAComprar, estado, montoTotal, fecha, identificador);
    }

    public CompraDeProducto(ListaDeBienes listaBienesAComprar, String estado) {
        super(listaBienesAComprar, estado);
    }

    public CompraDeProducto(ListaDeBienes listaBienesAComprar, String estado, String fecha, Double monto) {
        super(listaBienesAComprar, estado, fecha, monto);
    }

    public CompraDeProducto(Inventario inventario, ListaDeBienes listaBienesAComprar, String estado) {
        super(inventario, listaBienesAComprar, estado);
    }

    @Override
    public void comprar() {
        setMontoTotal();
        Map<String, List<Bien>> listAgrupado = listaBienesAComprar.getListaBienes()
                .stream()
                .collect(Collectors.groupingBy(prod -> prod.getProveeedor().getRuc()));
        listAgrupado.forEach((String ruc, List<Bien> p) -> {
            System.out.println(ruc);
            ListaDeBienes listaAux = new ListaDeBienes((ArrayList<Bien>) p);
            if (solicitarAutorizacion(listaBienesAComprar.getListaBienes().get(0).getProveeedor().getCuenta(), montoTotal)) {
                registrarCompraPorProveedor(listaAux, calcularMontoPorLista(listaAux).toString());
            }
        });

    }

    public Double calcularMontoPorLista(ListaDeBienes listaBienesA) {
        Double monto = 0.0;
        for (Bien bien : listaBienesA.getListaBienes()) {
            monto += bien.getPrecio() * bien.getCantidad();
        }
        return monto;
    }

    @Override
    public void comprarAnalizador() {
        /*setMontoTotal();
        if(solicitarAutorizacion(listaBienesAComprar.getListaBienes().get(0).getProveeedor(),montoTotal)){
            for (Bien cantidadBien : listaBienesAComprar.getListaBienes()){
                inventario.aumentarStock(cantidadBien.getCantidad(), cantidadBien);
                //asumimos que las compras se han entregado
                setEstado("Entregado");
                registrarCompra(cantidadBien.getNombre()
                        ,cantidadBien.getProveeedor().getRuc(),cantidadBien.getCantidad(),estado,montoTotal, this.fecha);
            }
        }*/
    }

}
