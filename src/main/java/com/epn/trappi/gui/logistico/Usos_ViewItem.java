/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.logistico;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Alexander
 */
public class Usos_ViewItem extends JPanel{
    //ATRIBUTOS
    String fecha="Fecha: ";
    String hora ="Hora: ";
    String conductor="ID Conductor: ";
    String factura="Factura: ";
    String direccion="Direccion: ";
    //METODOS
    public Usos_ViewItem(){
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(255,255,255));
    }
    public void llenarItem(String fecha,String conductor,String factura,String direccion){
        JLabel labelFecha = new JLabel(this.fecha+fecha);
        labelFecha.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
        labelFecha.setForeground(new Color(61,57,57));
        JLabel icono = new JLabel();
        icono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/epn/trappi/images/logistico/user (2).png")));
        JLabel labelConductor = new JLabel(this.conductor+conductor);
        labelConductor.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
        labelConductor.setForeground(new Color(61,57,57));
        JLabel labelFactura = new JLabel(this.factura+factura);
        labelFactura.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
        labelFactura.setForeground(new Color(61,57,57));
        JLabel labelDireccion = new JLabel(this.direccion+direccion);
        labelDireccion.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
        labelDireccion.setForeground(new Color(61,57,57));
        //Restricciones
        GridBagConstraints c1 = new GridBagConstraints();
        c1.gridx=0;
        c1.gridy=0;
        c1.ipady=10;
        c1.anchor=GridBagConstraints.LINE_START;
        GridBagConstraints c2 = new GridBagConstraints();
        c2.gridx=0;
        c2.gridy=1;
        c2.ipady=10;
        c2.anchor=GridBagConstraints.LINE_START;
        GridBagConstraints c3 = new GridBagConstraints();
        c3.gridx=0;
        c3.gridy=2;
        c3.ipady=10;
        c3.anchor=GridBagConstraints.LINE_START;
        GridBagConstraints c4_1 = new GridBagConstraints();
        c4_1.gridx=0;
        c4_1.gridy=0;
        c4_1.ipadx=15;
        c4_1.anchor=GridBagConstraints.LINE_START;
        GridBagConstraints c4_2 = new GridBagConstraints();
        c4_2.gridx=1;
        c4_2.gridy=0;
        JPanel panel1 = new JPanel(new GridLayout(2,1));
        JPanel panel2 = new JPanel(new GridBagLayout());
        panel1.setBackground(new Color(255,255,255));
        panel2.setBackground(new Color(255,255,255));
        panel1.add(labelConductor);
        panel1.add(labelFactura);
        panel2.add(icono,c4_1);
        panel2.add(panel1,c4_2);
        this.add(labelFecha,c1);
        this.add(panel2,c2);
        this.add(labelDireccion,c3);
    }
}
