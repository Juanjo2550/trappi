/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.logistico;

import com.epn.trappi.models.logistico.Entrega;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Alexander
 */
public class Usos_ViewHandler {
    //ATRIBUTOS
    JPanel viewList;
    //METODOS
    public Usos_ViewHandler(){
        viewList = new JPanel(new GridBagLayout());  
        this.viewList.setBackground(new Color(255,255,255));
    }
    private void addView(Usos_ViewItem vista,int fila){
        GridBagConstraints c = new GridBagConstraints();
        c.gridx=0;
        c.gridy=fila;
        c.ipadx=20;
        c.ipady=15;
        c.anchor=GridBagConstraints.LINE_START;
        viewList.add(vista,c);
    }
    public void reiniciarEstado(){
        viewList.removeAll();
    }
    public void llenar(ArrayList<Entrega> registros){
        //Recibe Fecha ID conductor Factura y Direccion.
        for (int instancia=0;instancia<registros.size();instancia++){
            Entrega entrega = registros.get(instancia);
            Usos_ViewItem item = new Usos_ViewItem();
            //Llenamos el panel con los datos
            item.llenarItem(entrega.getFecha(),String.valueOf(entrega.getID_Empleado()),String.valueOf(entrega.getFactura()),entrega.getDireccion());
            addView(item,instancia);
        }
    }
    public JPanel obtenerListView(){
        return this.viewList;
    }
}
