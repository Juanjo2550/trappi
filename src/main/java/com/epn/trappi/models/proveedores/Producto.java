package com.epn.trappi.models.proveedores;

import com.epn.trappi.db.proveedores.ProveedoresDb;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Producto extends Bien {

    private final ProveedoresDb db = new ProveedoresDb();

    public Producto(String nombre, double precio, Proveedor proveeedor, int cantidad, String marca, String categoria) {
        super(nombre, precio, proveeedor, cantidad, marca, categoria);
    }

    public Producto(String nombre, double precio, int cantidad, String marca) {
        super(nombre, precio, null, cantidad, marca, null);
    }

    public Producto(String nombre, double precio, Proveedor proveeedor) {
        super(nombre, precio, proveeedor);
    }

    public Producto(String nombre) {
        super(nombre);
    }

    @Override
    public void registrar() {
        Producto prod = new Producto(nombre, precio, proveeedor, cantidad, marca,categoria);
        try {
            if (validarNombre(nombre)) {
                if (validarPrecio(Double.toString(precio))) {
                    if (validarMarca(marca)) {
                        if (validarCantidad(Integer.toString(cantidad))) {
                            db.setProductos(prod);
                            JOptionPane.showMessageDialog(null, "Producto registrado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Debe ingresar una cantidad válida", "Error", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe ingresar un nombre de marca válida", "Error", JOptionPane.INFORMATION_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un precio válido", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Nombre de producto incorrecto.", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actualizar(int id, JTextField txtNombre, JTextField txtPrecio, JComboBox cmbProveedores) {
        ArrayList seleccionados = new ArrayList();
        String nombre = txtNombre.getText();
        String precio = txtPrecio.getText();
        String prov = cmbProveedores.getSelectedItem().toString();

        try {
            if (nombre.length() >= 1) {
                if ((Double.parseDouble(precio)) >= 0) {
                    Proveedor proveedor;
                    proveedor = db.obtenerProveedorRuc(prov);
                    db.actualizarBien(db.getIdBien(nombre), nombre, Double.parseDouble(precio), proveedor.getRuc());
                    JOptionPane.showMessageDialog(null, "Producto Actualizado", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                    seleccionados = (ArrayList) db.getProductos();

                    vaciarCampos(txtNombre, txtPrecio);
                } else {
                    JOptionPane.showMessageDialog(null, "Precio Incorrecto", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Nombre Incorrecto", "Error", JOptionPane.INFORMATION_MESSAGE);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error no se pudo Actualizar el Producto", "Error", JOptionPane.INFORMATION_MESSAGE);

        }
    }


    private boolean validarCantidad(String cantidad) {
        try {
            if (Integer.parseInt(cantidad) >= 0) {
                return true;
            }
            return false;
        } catch (Exception ex) {
            return false;
        }
    }

    private boolean validarNombre(String direccion) {
        if (direccion.length() > 50 || direccion.trim().equals("")) {
            return false;
        }
        return direccion.matches("[[0-9]*[ ]]*[A-Za-zñÑÁÉÍÓÚáéíóú]+[0-9]*[[ ][A-Za-zñÑÁÉÍÓÚáéíóú]+[0-9]*]*");
    }

    private boolean validarMarca(String marca) {
        if (marca.length() > 50 || marca.trim().equals("")) {
            return false;
        }
        return marca.matches("[[0-9]*[ ]]*[A-Za-zñÑÁÉÍÓÚáéíóú]+[0-9]*[[ ][A-Za-zñÑÁÉÍÓÚáéíóú]+[0-9]*]*");
    }

    private boolean validarPrecio(String precio) {
        try {
            if (Double.parseDouble(precio) >= 0) {
                return true;
            }
            return false;
        } catch (Exception ex) {
            return false;
        }
    }

    public void vaciarCampos(JTextField txtNombre, JTextField txtPrecio) {
        txtNombre.setText("");
        txtPrecio.setText("");

    }

}
