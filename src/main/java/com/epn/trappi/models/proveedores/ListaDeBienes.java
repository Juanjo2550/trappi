package com.epn.trappi.models.proveedores;

import com.epn.trappi.db.proveedores.ProveedoresDb;
import java.util.ArrayList;
import java.util.Iterator;
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
public class ListaDeBienes {

    private ArrayList<Bien> listaBienes;
    private final ProveedoresDb db = new ProveedoresDb();

    public ListaDeBienes(ArrayList<Bien> listaDeBienes) {
        this.listaBienes = listaDeBienes;
    }

    public ListaDeBienes() {
        listaBienes = new ArrayList<>();
    }

    public ArrayList<Bien> getListaBienes() {
        return listaBienes;
    }

    public void cargarProductos() {
        listaBienes = (ArrayList) db.getProductos();
    }

    public void cargarServicios() {
        listaBienes = (ArrayList) db.getServicios();
    }

    public void setListaBienes(ArrayList<Bien> listaBienes) {
        this.listaBienes = listaBienes;
    }

    public void mostrarLista(JTable jTable1) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Producto");
        model.addColumn("Marca");
        model.addColumn("Precio Unitario");
        model.addColumn("Cantidad");
        model.addColumn("Proveedor");
        for (Bien bien : listaBienes) {
            model.addRow(new Object[]{bien.getNombre(), bien.getMarca(), bien.getPrecio() + "", bien.getCantidad(), bien.getProveeedor().getRazonSocial()});
        }
        jTable1.setModel(model);
    }

    //recibimos el bien y la cantidad y se hace el objeto CantidadDeBien
    public void añadirBien(Bien nuevoBien) {
        listaBienes.add(nuevoBien);
    }

    //tomo un objeto cantidad de bien, es decir debe ingresarse 
    public void quitarBien(Bien bienARetirar) {
        for (Bien aux : listaBienes) {
            if (aux == bienARetirar) {
                listaBienes.remove(aux);
            }
        }
    }

    public void cargarServiciosTabla(JTable jtbBien) {
        DefaultTableModel modelo = new DefaultTableModel();
        String[] titulos = {"Nombre Servicio", "Precio unitario", "Proveedor", "Categoría"};
        String[] fila = new String[4];
        modelo = new DefaultTableModel(null, titulos);
        //Aquí cambie algo para que sirva, puse este iterador y luego castee la clase producto
        for (Iterator it = listaBienes.iterator(); it.hasNext();) {
            Servicio servicio = (Servicio) it.next();
            fila[0] = servicio.getNombre();
            fila[1] = "" + servicio.getPrecio();
            fila[2] = "" + servicio.getProveeedor().getRazonSocial();
            fila[3] = "" + servicio.getCategoria();
            modelo.addRow(fila);
        }
        jtbBien.setModel(modelo);
    }

    public void cargarProductosTabla(JTable jtbBien) {
        DefaultTableModel modelo = new DefaultTableModel();
        String[] titulos = {"Nombre Producto", "Precio unitario", "Proveedor", "Categoría"};
        String[] fila = new String[4];
        modelo = new DefaultTableModel(null, titulos);
        //Aquí cambie algo para que sirva, puse este iterador y luego castee la clase producto
        for (Bien bien : listaBienes) {
            Producto producto = (Producto) bien;
            fila[0] = producto.getNombre();
            fila[1] = "" + producto.getPrecio();
            fila[2] = "" + producto.getProveeedor().getRazonSocial();
            fila[3] = "" + producto.getCategoria();
            modelo.addRow(fila);
        }
        jtbBien.setModel(modelo);
    }

    public void buscarProductos(JTextField txtNombreProducto, JTable jtbProductos) {
        String producto = txtNombreProducto.getText();

        try {
            if (producto.length() >= 1) {
                this.listaBienes = (ArrayList) db.buscarProductos(producto);
                cargarProductosTabla(jtbProductos);
            } else {
                cargarProductos();
                cargarProductosTabla(jtbProductos);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Producto no encontrado", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void buscarServicios(JTextField txtNombreServicio, JTable jtbServicios) {
        String servicio = txtNombreServicio.getText();
        try {
            if (servicio.length() >= 1) {
                this.listaBienes = (ArrayList) db.buscarServicios(servicio);
                cargarServiciosTabla(jtbServicios);
            } else {
                cargarServicios();
                cargarServiciosTabla(jtbServicios);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Servicio no encontrado", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void actualizarProducto(JTable jtbProductos, JTextField txtNombre, JTextField txtPrecio, JComboBox cmbProveedores, JComboBox cmbCategoria) {
        ((Producto) listaBienes.get(jtbProductos.getSelectedRow())).actualizar(txtNombre.getText(), Double.parseDouble(txtPrecio.getText()), cmbProveedores.getSelectedItem().toString(), cmbCategoria.getSelectedItem().toString());
        cargarProductos();
        cargarProductosTabla(jtbProductos);
        vaciarCampos(txtNombre, txtPrecio);
    }

    public void actualizarServicio(JTable jtbProductos, JTextField txtNombre, JTextField txtPrecio, JComboBox cmbProveedores, JComboBox cmbCategoria) {
        ((Servicio) listaBienes.get(jtbProductos.getSelectedRow())).actualizar(txtNombre.getText(), Double.parseDouble(txtPrecio.getText()), cmbProveedores.getSelectedItem().toString(), cmbCategoria.getSelectedItem().toString());
        vaciarCampos(txtNombre, txtPrecio);
        cargarServicios();
        cargarProductosTabla(jtbProductos);
        vaciarCampos(txtNombre, txtPrecio);
    }

    private void vaciarCampos(JTextField txtNombre, JTextField txtPrecio) {
        txtNombre.setText("");
        txtPrecio.setText("");
    }

    @Override
    public String toString() {
        String retorno = "";
        for (Bien aux : listaBienes) {
            retorno += aux.toString() + aux.getCantidad();
        }
        return retorno;
    }

    public void mostrarBien(java.awt.event.MouseEvent evt, JTable jtbProductos, DefaultTableModel modelo, JTextField txtNombre, JTextField txtPrecio, JComboBox cmbProveedores, JComboBox cmbCategoria) {
        int row = jtbProductos.rowAtPoint(evt.getPoint());
        int col = jtbProductos.columnAtPoint(evt.getPoint());
        if (row >= 0 && col >= 0) {
            String nombre = modelo.getValueAt(row, 0).toString();
            String precio = modelo.getValueAt(row, 1).toString();
            String proveedor = modelo.getValueAt(row, 2).toString();
            String categoria = modelo.getValueAt(row, 3).toString();
            txtNombre.setText(nombre);
            txtPrecio.setText(precio);
            cmbProveedores.setSelectedItem(proveedor);
            cmbCategoria.setSelectedItem(categoria);
        }
    }
}
