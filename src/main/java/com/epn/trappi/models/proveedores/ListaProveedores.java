package com.epn.trappi.models.proveedores;

import com.epn.trappi.db.proveedores.ProveedoresDb;
import com.epn.trappi.gui.proveedores.guiProveedores;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
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
public class ListaProveedores {

    private final ProveedoresDb db = new ProveedoresDb();
    private ArrayList<Proveedor> listaDeProveedores = new ArrayList<Proveedor>();

    public ListaProveedores() {
        listaDeProveedores = (ArrayList) db.getProveedores();
    }

    public ArrayList<Proveedor> getListaDeProveedores() {

        return listaDeProveedores;
    }

    public void setListaDeProveedores(ArrayList<Proveedor> listaDeProveedores) {
        this.listaDeProveedores = listaDeProveedores;
    }

    public void añadirProveedor(Proveedor prov) throws SQLException {
        db.setProveedores(prov);
    }

    public void quitarProveedor(Proveedor prov) {
        this.listaDeProveedores.remove(prov);
    }

    public void cargarProveedorCombobox(JComboBox cmbProvedor) {
        this.getListaDeProveedores().forEach(prov -> {
            cmbProvedor.addItem(prov.getRazonSocial());
        });
    }

    public void cargarProveedorTabla(JTable jtbProveedores) {
        String[] titulos = {"Ruc", "Razón Social", "Dirección", "Número de Cuenta"};
        String[] fila = new String[4];
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        for (Proveedor proveedor : this.getListaDeProveedores()) {
            fila[0] = proveedor.getRuc();
            fila[1] = "" + proveedor.getRazonSocial();
            fila[2] = "" + proveedor.getDireccion();
            fila[3] = "" + proveedor.getCuenta();
            modelo.addRow(fila);
        }
        jtbProveedores.setModel(modelo);
    }

    public void buscarProveedor(JTextField txtBuscarRUC, JTable jtbProveedores) {
        String ruc = txtBuscarRUC.getText();
        try {
            if (ruc.length() >= 1) {
                this.listaDeProveedores = (ArrayList<Proveedor>) db.buscarProveedores(ruc);
                cargarProveedorTabla(jtbProveedores);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Proveedor no encontrado", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void actualizarProveedor(JTextField txtBuscarRUC, JTextField txtDireccion, JTextField txtNCuenta, JTextField txtRazonSocial, JTable jtbProveedores) {
        // Atributos
        String ruc = txtBuscarRUC.getText();
        String direccion = txtDireccion.getText();
        String cuenta = txtNCuenta.getText();

        if (guiProveedores.validarDireccion(direccion)) {
            if (cuenta.length() == 10) {
                try {
                    db.actualizarProveedor(ruc, direccion, cuenta);
                    JOptionPane.showMessageDialog(null, "Proveedor Actualizado.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "No se pudo Actualizar el Proveedor", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
                this.listaDeProveedores = (ArrayList<Proveedor>) db.getProveedores();
                cargarProveedorTabla(jtbProveedores);

                vaciarCampos(txtBuscarRUC, txtDireccion, txtNCuenta, txtRazonSocial);

            } else {
                JOptionPane.showMessageDialog(null, "Número de Cuenta Incorrecta");
                this.vaciarCampos(txtBuscarRUC, txtDireccion, txtNCuenta, txtRazonSocial);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Dirección Incorrecta");
            this.vaciarCampos(txtBuscarRUC, txtDireccion, txtNCuenta, txtRazonSocial);
        }
    }

    public void vaciarCampos(JTextField txtBuscarRUC, JTextField txtDireccion, JTextField txtNCuenta, JTextField txtRazonSocial) {
        txtDireccion.setText("");
        txtNCuenta.setText("");
        txtRazonSocial.setText("");
        txtBuscarRUC.setText("");
    }
}
