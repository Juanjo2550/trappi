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
    private List<String[]> proveedores;
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

    public List<String[]> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<String[]> proveedores) {
        this.proveedores = proveedores;
    }

    private void seleccionarProductos() {
        try {
            List<String[]> prod = p.leerArchivoCSV(this.prodFilename);
            List<Producto> pp = new ArrayList<Producto>();
            prod.forEach(pr -> {
                pp.add(reformarProducto(pr));
                //setProductos(reformarProducto(pr));
            });
            this.productos = pp;

            /*for (String[] pr : prod) {
                setProductos(reformarProducto(pr));
            }*/
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String transformarProducto(Producto p) {
        return p.getNombre() + ";" + p.getPrecio() + ";" + p.getProveeedor().getRuc();
    }

    private Producto reformarProducto(String[] str) {
        Producto np = new Producto(str[0], Double.parseDouble(str[1]), obtenerProveedor(str[2]));
        //Producto np = new Producto("Mango",5.02, new Proveedor("1759864240001", "Pierre Dolce", "Quito"));
        return np;
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
}
