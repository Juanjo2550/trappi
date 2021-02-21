package com.epn.trappi.db.proveedores;

import com.epn.trappi.models.proveedores.Producto;
import com.epn.trappi.models.proveedores.Proveedor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProveedoresDb {

    private List<Producto> productos;
    private List<Proveedor> proveedores;
    String prodFilename = "src/main/java/com/epn/trappi/db/proveedores/productos.csv";
    String provFilename = "src/main/java/com/epn/trappi/db/proveedores/proveedores.csv";
    Archivo p = new Archivo();

    public ProveedoresDb() {

    }

    public List<Producto> getProductos() {
        try {
            seleccionarProductos();
        } catch (Exception ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        productos.forEach(npr -> {
            agregarProductos(transformarProducto(npr));
        });
    }

    public void setProductos(Producto producto) {
        agregarProductos(transformarProducto(producto));
    }

    public List<Proveedor> getProveedores() {
        try {
            seleccionarProveedores();
        } catch (Exception ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedor) {
        proveedor.forEach(npr -> {
            agregarProveedor(transformarProveedor(npr));
        });
    }

    public void setProveedores(Proveedor proveedor) {
        agregarProveedor(transformarProveedor(proveedor));
    }

    private void seleccionarProductos() {
        try {
            List<String[]> prod = p.leerArchivoCSV(this.prodFilename);
            List<Producto> pp = new ArrayList<Producto>();
            prod.forEach(pr -> {
                pp.add(reformarProducto(pr));
            });
            this.productos = pp;
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void seleccionarProveedores() {
        try {
            List<String[]> prod = p.leerArchivoCSV(this.provFilename);
            List<Proveedor> pp = new ArrayList<Proveedor>();
            prod.forEach(pr -> {
                pp.add(reformarProveedor(pr));
            });
            this.proveedores = pp;
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String transformarProducto(Producto p) {
        return p.getNombre() + ";" + p.getPrecio() + ";" + p.getProveeedor().getRuc();
    }

    private String transformarProveedor(Proveedor p) {
        return p.getRuc() + ";" + p.getRazonSocial() + ";" + p.getDireccion();
    }

    private Producto reformarProducto(String[] str) {
        Producto np = new Producto(str[0], Double.parseDouble(str[1]), obtenerProveedor(str[2]));
        return np;
    }

    private Proveedor reformarProveedor(String[] str) {
        Proveedor nprov = new Proveedor(str[0], str[1], str[2]);
        return nprov;
    }

    private Proveedor obtenerProveedor(String ruc) {
        Proveedor prov = new Proveedor(ruc, ruc, ruc);
        return prov;
    }

    private void agregarProductos(String nuevoProducto) {
        try {
            p.writeArchivoCSV(prodFilename, nuevoProducto);
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void agregarProveedor(String nuevoProveedor) {
        try {
            p.writeArchivoCSV(provFilename, nuevoProveedor);
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
