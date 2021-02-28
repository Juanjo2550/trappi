package com.epn.trappi.db.proveedores;

import com.epn.trappi.models.proveedores.*;
import com.epn.trappi.models.proveedores.Compra;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProveedoresDb {

    private List<Producto> productos;
    private List<Proveedor> proveedores;
    private List<Servicio> servicios;
    private List<Compra> compras=new ArrayList<Compra>();
    private ArrayList<CantidadDeBien> listaCantidadBienes;
    private  ArrayList<CantidadDeBien> inventarioDb;
    private final String prodFilename = "src/main/java/com/epn/trappi/db/proveedores/productos.csv";
    private final String provFilename = "src/main/java/com/epn/trappi/db/proveedores/proveedores.csv";
    private final String servFilename = "src/main/java/com/epn/trappi/db/proveedores/servicios.csv";
    private final String compFilename = "src/main/java/com/epn/trappi/db/proveedores/compras.csv";
    private final String invFilename = "src/main/java/com/epn/trappi/db/proveedores/inventario.csv";
    private final Archivo p = new Archivo();

     
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
            agregarProducto(transformarProducto(npr),transformarProductoInventario(npr));
        });
    }

    public void setProductos(Producto producto) {
        agregarProducto(transformarProducto(producto),transformarProductoInventario(producto));
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

    public ArrayList<CantidadDeBien> getListaCantidadBienes() {
        try {
            seleccionarCantidadDeBienes();
        } catch (Exception ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaCantidadBienes;
    }
    
    public ArrayList<CantidadDeBien> getListaCantidadBienesCompra(){
        try {
            seleccionarCantidadDeBienesCompra();
        } catch (Exception ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaCantidadBienes;
    }

    public void setServicios(List<Servicio> servicios) {
        servicios.forEach(ser -> {
            agregarServicio(transformarServicio(ser));
        });
    }

    public void setServicios(Servicio servicio) {
        agregarServicio(transformarServicio(servicio));
    }

    public List<Compra> getCompras() throws IOException {
        List<String[]> compra = p.leerArchivoCSV(this.compFilename);
        int auxiliar=-1;
        for (String[] pr : compra) {
            if(Integer.parseInt(pr[0])!=auxiliar){
                String estado=pr[5];
                compras.add(new CompraDeProducto(new ListaDeBienes(getListaCantidadBienesCompra()),estado,pr[4],Double.parseDouble(pr[6])));
                auxiliar=Integer.parseInt(pr[0]);
            }
        }
        return compras;
    }

    public void setCompras(String nombreProducto, String Proveedor, int cantidad, String estado, double montoTotal, String fecha) {
        agregarCompra(transformarCompra(nombreProducto, Proveedor, cantidad, estado, montoTotal,fecha));
    }

    private void seleccionarProductos() {
        try {
            List<String[]> prod = p.leerArchivoCSV(this.prodFilename);
            List<Producto> pp = new ArrayList<>();
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
            List<Proveedor> pp = new ArrayList<>();
            prov.forEach(pr -> {
                pp.add(reformarProveedor(pr));
            });
            this.proveedores = pp;
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void seleccionarCantidadDeBienesCompra(){
        try {
            List<String[]> cbienes = p.leerArchivoCSV(this.compFilename);
            ArrayList<CantidadDeBien> cb = new ArrayList<>();
            cbienes.forEach(b -> {
                cb.add(reformarCantidadDeBienCompra(b));
            });

            this.listaCantidadBienes = cb;
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void seleccionarCantidadDeBienes() {
        try {
            List<String[]> cbienes = p.leerArchivoCSV(this.invFilename);
            ArrayList<CantidadDeBien> cb = new ArrayList<>();
            cbienes.forEach(b -> {
                cb.add(reformarCantidadDeBien(b));
            });

            this.listaCantidadBienes = cb;
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void seleccionarServicios() {
        try {
            List<String[]> serv = p.leerArchivoCSV(this.servFilename);
            List<Servicio> ss = new ArrayList<>();
            serv.forEach(pr -> {
                ss.add(reformarServicio(pr));
            });
            this.servicios = ss;
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Integer> seleccionarIdentificadores(){
        try {
            List<String[]> serv = p.leerArchivoCSV(this.compFilename);
            ArrayList<Integer> retorno = new ArrayList<>();
            int auxiliar=-1;
            for (String[] i : serv)
                retorno.add(Integer.parseInt(i[0]));
            return retorno;
        } catch (IOException ex) {
            Logger.getLogger(ProveedoresDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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

    private String transformarCompra(String nombreProducto, String Proveedor, int cantidad, String estado, double montoTotal, String fecha) {
        //01;Fanta;16;1721561568001;21/2/2021;Entregado;45.0
        return "02;"+nombreProducto + ";" + cantidad + ";" + Proveedor + ";" +fecha+";" +estado + ";" + montoTotal;
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
        Servicio serv = new Servicio(str[0], Double.parseDouble(str[1]), obtenerProveedor(str[2]));
        return serv;
    }

    private CantidadDeBien reformarCantidadDeBien(String[] str) {
        CantidadDeBien c = new CantidadDeBien(obtenerBien(str[0]), Integer.parseInt(str[1]));
        return c;
    }
    
    private CantidadDeBien reformarCantidadDeBienCompra(String[] str) {
        CantidadDeBien c = new CantidadDeBien(obtenerBien(str[1]), Integer.parseInt(str[2]));
        return c;
    }

    /*private Compra reformarCompra(String[] str) {
        return null;
    }*/
    private Producto obtenerBien(String nombre) {
        seleccionarProductos();
        Producto resultado = null;
        for (Producto producto : this.productos) {
            if (producto.getNombre().equals(nombre)) {
                resultado = producto;
                break;
            }
        }
        return resultado;
    }

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

    private void agregarProducto(String nuevoProducto, String nuevoProductoInv) {
        try {
            p.writeArchivoCSV(prodFilename, nuevoProducto);
            p.writeArchivoCSV(invFilename, nuevoProductoInv);
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<CantidadDeBien> getInventarioDb() throws IOException {
        List<String[]> serv = p.leerArchivoCSV(invFilename);
        ArrayList<CantidadDeBien> auxiliar = new ArrayList<>();
        for(int i=0;i<serv.size();i++){
            auxiliar.add(new CantidadDeBien(new Producto(serv.get(i)[0]), Integer.parseInt(serv.get(i)[1])));
        }
        return auxiliar;
    }

    public void setInventarioDb(ArrayList<CantidadDeBien> inventarioDb) {
        String retorno = "";
        try {
            p.vaciarArchivoCSV(invFilename);
            for (CantidadDeBien cantidad : inventarioDb) {
                retorno+=cantidad.getBien().getNombre()+";"+cantidad.getCantidad()+"\n";
            }
            p.writeArchivoCSV(invFilename, retorno);
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    private String transformarProductoInventario(Producto p) {
        return p.getNombre() + ";0";
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
