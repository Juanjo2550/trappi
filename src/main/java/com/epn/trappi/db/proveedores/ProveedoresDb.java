package com.epn.trappi.db.proveedores;

import com.epn.trappi.models.proveedores.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProveedoresDb {

    private List<Producto> productos;
    private List<Proveedor> proveedores;
    private List<Servicio> servicios;
    private List<Compra> compras;
    String prodFilename = "src/main/java/com/epn/trappi/db/proveedores/productos.csv";
    String provFilename = "src/main/java/com/epn/trappi/db/proveedores/proveedores.csv";
    String servFilename = "src/main/java/com/epn/trappi/db/proveedores/servicios.csv";
    String compFilename = "src/main/java/com/epn/trappi/db/proveedores/compras.csv";
    Archivo p = new Archivo();

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
            agregarProducto(transformarProducto(npr));
        });
    }

    public void setProductos(Producto producto) {
        agregarProducto(transformarProducto(producto));
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

    public List<Servicio> getServicios() {
        try {
            seleccionarServicios();
        } catch (Exception ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        servicios.forEach(ser -> {
            agregarServicio(transformarServicio(ser));
        });
    }

    public void setServicios(Servicio servicio) {
        agregarServicio(transformarServicio(servicio));
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(String nombreProducto, String Proveedor, int cantidad, String estado, double montoTotal) {
        agregarCompra(transformarCompra(nombreProducto, Proveedor, cantidad, estado, montoTotal));
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
            List<String[]> prov = p.leerArchivoCSV(this.provFilename);
            List<Proveedor> pp = new ArrayList<Proveedor>();
            prov.forEach(pr -> {
                pp.add(reformarProveedor(pr));
            });
            this.proveedores = pp;
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void seleccionarServicios() {
        try {
            List<String[]> serv = p.leerArchivoCSV(this.servFilename);
            List<Servicio> ss = new ArrayList<Servicio>();
            serv.forEach(pr -> {
                ss.add(reformarServicio(pr));
            });
            this.servicios = ss;
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*private void seleccionarCompras() {
        try {
            List<String[]> prov = p.leerArchivoCSV(this.provFilename);
            List<Compra> cc = new ArrayList<Compra>();
            prov.forEach(pr -> {
                cc.add(reformarCompra(pr));
            });
            this.compras = cc;
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    private String transformarProducto(Producto p) {
        return p.getNombre() + ";" + p.getPrecio() + ";" + p.getProveeedor().getRuc();
    }

    private String transformarProveedor(Proveedor p) {
        return p.getRuc() + ";" + p.getRazonSocial() + ";" + p.getDireccion() + ";" + p.getCuenta();
    }

    private String transformarServicio(Servicio s) {
        return s.getNombre() + ";" + s.getPrecio() + ";" + s.getProveeedor().getRuc();
    }

    private String transformarCompra(String nombreProducto, String Proveedor, int cantidad, String estado, double montoTotal) {
        return nombreProducto + ";" + Proveedor + ";" + cantidad + ";" + estado+";"+montoTotal;
    }

    private Producto reformarProducto(String[] str) {
        Producto np = new Producto(str[0], Double.parseDouble(str[1]), obtenerProveedor(str[2]));
        return np;
    }

    private Proveedor reformarProveedor(String[] str) {
        Proveedor nprov = new Proveedor(str[0], str[1], str[2], str[3]);
        return nprov;
    }

    private Servicio reformarServicio(String[] str) {
        Servicio nprov = new Servicio(str[0], Double.parseDouble(str[1]), obtenerProveedor(str[2]));
        return nprov;
    }

    /*private Compra reformarCompra(String[] str) {
        return null;
    }*/
    private Proveedor obtenerProveedor(String ruc) {
        seleccionarProveedores();
        Proveedor resultado = null;
        for (Proveedor proveedor : this.proveedores) {
            if (proveedor.getRuc().equals(ruc)) {
                resultado = proveedor;
                break;
            }
        }
        return resultado;
    }

    private void agregarProducto(String nuevoProducto) {
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

    private void agregarServicio(String nuevoServicio) {
        try {
            p.writeArchivoCSV(servFilename, nuevoServicio);
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void agregarCompra(String nuevaCompra) {
        try {
            p.writeArchivoCSV(compFilename, nuevaCompra);
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
