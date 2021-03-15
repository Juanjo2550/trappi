package com.epn.trappi.models.proveedores;

import com.epn.trappi.db.proveedores.ProveedoresDb;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Servicio extends Bien {

    private final ProveedoresDb db = new ProveedoresDb();

    public Servicio(String nombre, double precio, Proveedor proveeedor) {
        super(nombre, precio, proveeedor);
    }
     public Servicio(String nombre, double precio, Proveedor proveeedor, String categoria) {
        super(nombre, precio, proveeedor, 1, null, categoria);
    }

    /*public Servicio(String nombre, double precio, Proveedor proveeedor, int cantidad, String marca) {
        super(nombre, precio, proveeedor, cantidad, marca);
    }*/

    @Override
    public void registrar() {
        Servicio serv = new Servicio(nombre, precio, proveeedor, categoria);
        try {
            if (validarNombre(nombre)) {
                if (validarPrecio(Double.toString(precio))) {
                    db.setServicios(serv);
                    JOptionPane.showMessageDialog(null, "Servicio registrado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Debes ingresar un precio válido", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Nombre de servicio incorrecto.", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean validarNombre(String direccion) {
        if (direccion.length() > 50 || direccion.trim().equals("")) {
            return false;
        }
        return direccion.matches("[[0-9]*[ ]]*[A-Za-zñÑÁÉÍÓÚáéíóú]+[0-9]*[[ ][A-Za-zñÑÁÉÍÓÚáéíóú]+[0-9]*]*");
    }

    private boolean validarPrecio(String precio) {
        try {
            Double.parseDouble(precio);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public void actualizar(String nombre,Double precio,String prov, String categoria) {
        try {
            if (nombre.length() >= 1) {
                if (precio >= 0) {
                    Proveedor proveedor;
                    proveedor = db.obtenerProveedorRuc(prov);
                    db.actualizarBien(db.getIdBien(nombre), nombre, precio, proveedor.getRuc(),categoria);
                    JOptionPane.showMessageDialog(null, "Servicio actualizado", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                    
                } else {
                    JOptionPane.showMessageDialog(null, "Precio Incorrecto", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Nombre Incorrecto", "Error", JOptionPane.INFORMATION_MESSAGE);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error no se pudo actualizar el Servicio", "Error", JOptionPane.INFORMATION_MESSAGE);

        }
    }

}
