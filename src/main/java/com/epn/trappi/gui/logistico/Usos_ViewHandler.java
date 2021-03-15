/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.logistico;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Rommel Alexander
 * @param <Tipo>
 */
public class Usos_ViewHandler <Tipo> {
    //ATRIBUTOS
    JPanel viewList;
    //METODOS
    public Usos_ViewHandler(){
        viewList = new JPanel(new GridBagLayout());  
        this.viewList.setBackground(new Color(255,255,255));
    }
    private void addView(JPanel vista,int fila){
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
    public void llenar(ArrayList<Tipo> registros,JPanel vista){
        for (int instancia=0;instancia<registros.size();instancia++){
            Tipo o = registros.get(instancia);
            if(vista.getClass().getSimpleName().equalsIgnoreCase("Usos_ViewItem")){
                Usos_ViewItem item = new Usos_ViewItem();
                item.llenarItem(o);
                addView(item,instancia);
            }
            if(vista.getClass().getSimpleName().equalsIgnoreCase("Solicitudes_ViewItem")){
                Solicitudes_ViewItem item = new Solicitudes_ViewItem();
                item.llenarItem(o);
                addView(item,instancia);
            }    
        }
    }
    public JPanel obtenerListView(){
        return this.viewList;
    }
}
