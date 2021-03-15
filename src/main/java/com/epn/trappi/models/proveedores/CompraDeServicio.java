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
public class CompraDeServicio extends Compra {

    public CompraDeServicio(Inventario inventario, ListaDeBienes listaBienesAComprar, String estado) {
        super(inventario, listaBienesAComprar, estado);
        //comprar();
    }

    public CompraDeServicio(ListaDeBienes listaBienesAComprar, String estado, Double montoTotal, String fecha, int identificador) throws IOException {
        super(listaBienesAComprar, estado, montoTotal, fecha, identificador);
    }

    public CompraDeServicio(ListaDeBienes listaBienesAComprar, String estado) {
        super(listaBienesAComprar, estado);
    }

    @Override
    public boolean comprar() {
        boolean flag = true;
        setMontoTotal();
        Map<String, List<Bien>> listAgrupado = listaBienesAComprar.getListaBienes()
                .stream()
                .collect(Collectors.groupingBy(p -> p.getProveeedor().getRuc()));
        
        for (Map.Entry<String, List<Bien>> m : listAgrupado.entrySet()) {
            System.out.println(m.getKey());
            ListaDeBienes listaAux = new ListaDeBienes((ArrayList<Bien>) m.getValue());
            if (solicitarAutorizacion(listaBienesAComprar.getListaBienes().get(0).getProveeedor().getCuenta(), montoTotal)) {
                registrarCompraPorProveedor(listaAux, calcularMontoPorLista(listaAux).toString());
            }
            else{
                flag=false;
            }
        }
        return flag;

    }
    @Override
    public Double calcularMontoPorLista(ListaDeBienes listaBienesA) {
        Double monto = 0.0;
        for (Bien bien : listaBienesA.getListaBienes()) {
            monto += bien.getPrecio() * bien.getCantidad();
        }
        return monto;
    }
}
