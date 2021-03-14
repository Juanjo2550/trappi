
package com.epn.trappi.gui.logistico;

import com.epn.trappi.models.logistico.SolicitudMantenimiento;
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
public class Solicitudes_ViewItem extends JPanel{
    //ATRIBUTOS
    String fecha="Fecha: ";
    String num_solicitud="No Solicitud: ";
    String bien="No Bien: ";
    String estado="Estado: ";
    //METODOS
    public Solicitudes_ViewItem(){
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(255,255,255));
    }
    public void llenarItem(Object o){
        SolicitudMantenimiento s = (SolicitudMantenimiento) o;
        JLabel labelFecha = new JLabel(this.fecha+s.getFecha());
        labelFecha.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
        labelFecha.setForeground(new Color(61,57,57));
        JLabel icono = new JLabel();
        icono.setIcon(new javax.swing.JLabel() {
            @Override
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("https://i.ibb.co/BtRLJgv/configuraciones.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        JLabel labelSolicitud = new JLabel(this.num_solicitud+s.getId_Solicitud());
        labelSolicitud.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
        labelSolicitud.setForeground(new Color(61,57,57));
        JLabel labelBien = new JLabel(this.bien+s.getId_Bien());
        labelBien.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
        labelBien.setForeground(new Color(61,57,57));
        JLabel labelEstado = new JLabel(this.estado+s.getEstado());
        labelEstado.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
        labelEstado.setForeground(new Color(61,57,57));
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
        panel1.add(labelSolicitud);
        panel1.add(labelBien);
        panel2.add(icono,c4_1);
        panel2.add(panel1,c4_2);
        this.add(labelFecha,c1);
        this.add(panel2,c2);
        this.add(labelEstado,c3);
    }
}
