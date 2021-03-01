package com.epn.trappi.db.proveedores;

import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.models.proveedores.*;
import com.epn.trappi.models.proveedores.Compra;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProveedoresDb {

    DataBaseConnection dbInstance = DataBaseConnection.getInstance();
    private List<Producto> productos;
    private List<Proveedor> proveedores;
    private List<Servicio> servicios;
    private ListaDeCompras compras;
    //private ArrayList<CantidadDeBien> listaCantidadBienes;
    //private  ArrayList<CantidadDeBien> inventarioDb;
    private final String spSelectAllProductos = "selectAllInventarioProductos";
    private final String spSelectAllProveedor = "selectAllProveedor";
    private final String spSelectAllServicios = "selectAllServicios";
    private final String spSelectAllCompras = "selectAllCompra";
    private final String spSelectAllDetalleCompra = "selectAllDetalleCompra";
    private final String invFilename = "src/main/java/com/epn/trappi/db/proveedores/inventario.csv";
    private final Archivo p = new Archivo();

    private ResultSet ejecutarSP(String nombreSP) throws SQLException {
        Connection connection = dbInstance.getConnection();
        CallableStatement cstmt = null;
        ResultSet rs = null;
        cstmt = connection.prepareCall(
                "{call " + nombreSP + "}");
        boolean resultSet = cstmt.execute();

        if (resultSet) {
            rs = cstmt.getResultSet();
        }
        return rs;
    }

    private ResultSet ejecutarSPParameters(String nombreSP, String[] parametros) throws SQLException {

        Connection connection = dbInstance.getConnection();
        CallableStatement cstmt = null;
        String numPara = "?,".repeat(parametros.length);
        numPara = numPara.substring(0, numPara.length() - 1); //replace(numPara.charAt(numPara.length()-1), '');
        System.out.println(numPara);
        cstmt = connection.prepareCall(
                "{call " + nombreSP + "(" + numPara + ")}");

        for (String para : parametros) {
            String[] valores = para.split(":");
            System.out.println(Arrays.toString(valores));
            cstmt.setString(valores[0], valores[1]);
        }

        boolean resultSet = cstmt.execute();
        ResultSet rs = null;
        rs = cstmt.getResultSet();

        if (resultSet) {
            rs = cstmt.getResultSet();
        }
        return rs;
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
            try {
                agregarProducto(transformarProducto(npr));
            } catch (SQLException ex) {
                Logger.getLogger(ProveedoresDb.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    public void setProductos(Producto producto) throws SQLException {
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
            try {
                agregarProveedor(transformarProveedor(npr));
            } catch (SQLException ex) {
                Logger.getLogger(ProveedoresDb.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    public void setProveedores(Proveedor proveedor) throws SQLException {
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

    public List<Servicio> getCompras() {
        try {
            seleccionarServicios();
        } catch (Exception ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return servicios;
    }

    /*public ArrayList<CantidadDeBien> getListaCantidadBienes() {
        try {
            seleccionarCantidadDeBienes();
        } catch (Exception ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaCantidadBienes;
    }*/

 /*public ArrayList<CantidadDeBien> getListaCantidadBienesCompra() {
        try {
            seleccionarCantidadDeBienesCompra();
        } catch (Exception ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaCantidadBienes;
    }*/
    public void setServicios(List<Servicio> servicios) {
        servicios.forEach(ser -> {
            try {
                agregarServicio(transformarServicio(ser));
            } catch (SQLException ex) {
                Logger.getLogger(ProveedoresDb.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    public void setServicios(Servicio servicio) throws SQLException {
        agregarServicio(transformarServicio(servicio));
    }

    /*public List<Compra> getCompras() throws IOException {
        List<String[]> compra = p.leerArchivoCSV(this.compFilename);
        int auxiliar = -1;
        for (String[] pr : compra) {
            if (Integer.parseInt(pr[0]) != auxiliar) {
                String estado = pr[5];
                compras.add(new CompraDeProducto(new ListaDeBienes(getListaCantidadBienesCompra()), estado, pr[4], Double.parseDouble(pr[6])));
                auxiliar = Integer.parseInt(pr[0]);
            }
        }
        return compras;
    }*/
    public void setCompras(String nombreProducto, String Proveedor, int cantidad, String estado, double montoTotal, String fecha) {
        agregarCompra(transformarCompra(nombreProducto, Proveedor, cantidad, estado, montoTotal, fecha));
    }

    private void seleccionarProductos() throws SQLException {
        ResultSet rs = ejecutarSP(spSelectAllProductos);
        List<Producto> pp = new ArrayList<>();
        while (rs.next()) {
            String[] res = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)};
            pp.add(reformarProducto(res));
        }
        this.productos = pp;
    }

    public ListaDeCompras seleccionarCompras() throws SQLException {
        ResultSet rs = ejecutarSP(spSelectAllCompras);

        ArrayList<Compra> listaCompra = new ArrayList<>();
        while (rs.next()) {
            List<Producto> pp = seleccionarComprabien(Integer.parseInt(rs.getString(1)));
            ArrayList<Bien> listaBienes = new ArrayList<>();
            pp.forEach(bien -> {
                listaBienes.add(bien);
            });

            ListaDeBienes listaBienesCompra = new ListaDeBienes();
            listaBienesCompra.setListaBienes(listaBienes);
            CompraDeProducto comp = new CompraDeProducto(listaBienesCompra, rs.getString(2),
                    rs.getString(4), Double.parseDouble(rs.getString(3)));
            listaCompra.add(comp);
            /*String[] res = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)};
            pp.add(reformarProducto(res));*/
        }

        //compras.setCompras(listaCompra);
        compras = new ListaDeCompras(listaCompra);
        return compras;
    }

    public List<Producto> seleccionarComprabien(int idCompra) throws SQLException {
        String[] param = {"identificadorcompra:" + idCompra};
        ResultSet rs = ejecutarSPParameters(spSelectAllDetalleCompra, param);
        List<Producto> pp = new ArrayList<>();
        while (rs.next()) {
            //Producto(String nombre, double precio, Proveedor proveeedor, int cantidad, String marca)
            String[] res = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)};
            pp.add(reformarProducto(res));
        }
        return pp;
    }

    private void seleccionarProveedores() throws SQLException {
        ResultSet rs = ejecutarSP(spSelectAllProveedor);
        List<Proveedor> pp = new ArrayList<>();
        while (rs.next()) {
            String[] res = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
            pp.add(reformarProveedor(res));
        }
        this.proveedores = pp;
    }

    /*private void seleccionarCantidadDeBienesCompra() {
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
    }*/

 /*private void seleccionarCantidadDeBienes() {
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
    }*/
    private void seleccionarServicios() throws SQLException {
        ResultSet rs = ejecutarSP(spSelectAllServicios);
        List<Servicio> ss = new ArrayList<>();
        while (rs.next()) {
            String[] res = {rs.getString(3), rs.getString(4), rs.getString(2)};
            ss.add(reformarServicio(res));
        }
        this.servicios = ss;
    }

    /*public ArrayList<Integer> seleccionarIdentificadores() {
        try {
            List<String[]> serv = p.leerArchivoCSV(this.compFilename);
            ArrayList<Integer> retorno = new ArrayList<>();
            int auxiliar = -1;
            for (String[] i : serv) {
                retorno.add(Integer.parseInt(i[0]));
            }
            return retorno;
        } catch (IOException ex) {
            Logger.getLogger(ProveedoresDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }*/

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
    private String[] transformarProducto(Producto p) {
        String[] params = {"ruc:" + p.getProveeedor().getRuc(), "nombrebien:"
            + p.getNombre(), "preciobien:" + p.getPrecio(), "tipobien:Producto", "cantidad:" + p.getCantidad(), "marca:" + p.getMarca()};
        return params;
    }

    private String[] transformarProveedor(Proveedor p) {
        String[] params = {"ruc:" + p.getRuc(), "razon_social:" + p.getRazonSocial(), "direccionproveedor:" + p.getDireccion(), "numerodecuenta:" + p.getCuenta()};
        return params;
    }

    private String[] transformarServicio(Servicio s) {
        String[] params = {"ruc:" + s.getProveeedor().getRuc(), "nombrebien:"
            + s.getNombre(), "preciobien:" + s.getPrecio(), "tipobien:Servicio", "cantidad:" + s.getCantidad(), "marca:" + s.getMarca()};
        return params;
    }

    private String transformarCompra(String nombreProducto, String Proveedor, int cantidad, String estado, double montoTotal, String fecha) {
        //01;Fanta;16;1721561568001;21/2/2021;Entregado;45.0
        return "02;" + nombreProducto + ";" + cantidad + ";" + Proveedor + ";" + fecha + ";" + estado + ";" + montoTotal;
    }

    private Producto reformarProducto(String[] str) throws SQLException {
        Producto np = new Producto(str[0], Double.parseDouble(str[1]), obtenerProveedor(str[2]), Integer.parseInt(str[3]), str[4]);
        return np;
    }

    private Proveedor reformarProveedor(String[] str) {
        Proveedor nprov = new Proveedor(str[0], str[1], str[2], str[3]);
        return nprov;
    }

    private Servicio reformarServicio(String[] str) throws SQLException {
        Servicio serv = new Servicio(str[0], Double.parseDouble(str[1]), obtenerProveedor(str[2]));
        return serv;
    }

    /*private CantidadDeBien reformarCantidadDeBien(String[] str) {
        CantidadDeBien c = new CantidadDeBien(obtenerBien(str[0]), Integer.parseInt(str[1]));
        return c;
    }*/

 /*private CantidadDeBien reformarCantidadDeBienCompra(String[] str) {
        CantidadDeBien c = new CantidadDeBien(obtenerBien(str[1]), Integer.parseInt(str[2]));
        return c;
    }*/

 /*private Compra reformarCompra(String[] str) {
        return null;
    }*/
    private Producto obtenerBien(String nombre) throws SQLException {
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

    private Proveedor obtenerProveedor(String ruc) throws SQLException {
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

    private void agregarProducto(String[] nuevoProducto) throws SQLException {
        ejecutarSPParameters("insertBien", nuevoProducto);
    }

    /*public ArrayList<CantidadDeBien> getInventarioDb() throws IOException {
        List<String[]> serv = p.leerArchivoCSV(invFilename);
        ArrayList<CantidadDeBien> auxiliar = new ArrayList<>();
        for (int i = 0; i < serv.size(); i++) {
            auxiliar.add(new CantidadDeBien(new Producto(serv.get(i)[0]), Integer.parseInt(serv.get(i)[1])));
        }
        return auxiliar;
    }*/

 /* public void setInventarioDb(ArrayList<CantidadDeBien> inventarioDb) {
        String retorno = "";
        try {
            p.vaciarArchivoCSV(invFilename);
            for (CantidadDeBien cantidad : inventarioDb) {
                retorno += cantidad.getBien().getNombre() + ";" + cantidad.getCantidad() + "\n";
            }
            p.writeArchivoCSV(invFilename, retorno);
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    private String transformarProductoInventario(Producto p) {
        return p.getNombre() + ";0";
    }

    private void agregarProveedor(String[] nuevoProveedor) throws SQLException {
        ejecutarSPParameters("insertProveedor", nuevoProveedor);
    }

    private void agregarServicio(String nuevoServicio[]) throws SQLException {
        ejecutarSPParameters("insertBien", nuevoServicio);
    }

    private void agregarCompra(String nuevaCompra) {

    }
}
