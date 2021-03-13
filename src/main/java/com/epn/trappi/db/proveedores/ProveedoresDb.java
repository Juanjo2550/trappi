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
    private final String spBuscarProveedor = "BuscarProveedor";
    private final String spUpdateCompras = "updateCompras";

    private final String spInsertCompra = "insertCompra";
    private final String spInsertCompraBien = "insertCompraBien";
    private final String spUpdateStock = "updateStock";
    private final String spGetIdBien = "getIdBien";
    private final String spUpdateProveedor = "updateProveedor";
    private final String spBuscarProducto = "BuscarProducto";
        private final String spUpdateProducto = "updateBien";


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

    private CallableStatement crearStatement(String nombreSP, String[] parametros) throws SQLException {
        Connection connection = dbInstance.getConnection();
        CallableStatement cstmt = null;
        String numPara = "?,".repeat(parametros.length);
        numPara = numPara.substring(0, numPara.length() - 1); //replace(numPara.charAt(numPara.length()-1), '');
        System.out.println(numPara);
        cstmt = connection.prepareCall("{call " + nombreSP + "(" + numPara + ")}");

        for (String para : parametros) {
            String[] valores = para.split(":");
            System.out.println(Arrays.toString(valores));
            try {
                cstmt.setString(valores[0], valores[1]);
            } catch (Exception e) {

            }
        }
        return cstmt;
    }

    private ResultSet obtenerResultado(CallableStatement cstmt) throws SQLException {
        boolean resultSet = cstmt.execute();
        ResultSet rs = null;
        rs = cstmt.getResultSet();

        if (resultSet) {
            rs = cstmt.getResultSet();
        }
        return rs;
    }

    private ResultSet ejecutarSPParameters(String nombreSP, String[] parametros) throws SQLException {
        CallableStatement cstmt = crearStatement(nombreSP, parametros);

        return obtenerResultado(cstmt);
    }

    private int ejecutarSPRegistraCompras(String nombreSP, String[] parametros) throws SQLException {
        CallableStatement cstmt = crearStatement(nombreSP, parametros);
        cstmt.registerOutParameter("idcompra", java.sql.Types.INTEGER);

        boolean resultSet = cstmt.execute();
        int idCompra = cstmt.getInt("idcompra");
        ResultSet rs = null;
        rs = cstmt.getResultSet();

        if (resultSet) {
            rs = cstmt.getResultSet();
        }
        return idCompra;
    }

    private int ejecutarSPGetIdBien(String nombreSP, String[] parametros) throws SQLException {
        CallableStatement cstmt = crearStatement(nombreSP, parametros);
        cstmt.registerOutParameter("idBien", java.sql.Types.INTEGER);

        boolean resultSet = cstmt.execute();
        int idCompra = cstmt.getInt("idBien");
        ResultSet rs = null;
        rs = cstmt.getResultSet();

        if (resultSet) {
            rs = cstmt.getResultSet();
        }
        return idCompra;
    }

    public List<Producto> getProductos() {
        try {
            seleccionarProductos();
        } catch (Exception ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productos;
    }

    public List<Producto> buscarProductos(String nombre) {
        try {
            return seleccionarProductos(nombre);
        } catch (Exception ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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

    public List<Proveedor> buscarProveedores(String ruc) {
        try {
            return seleccionarProveedores(ruc);
        } catch (Exception ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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

    public ListaDeCompras getCompras() {
        try {
            seleccionarCompras();
        } catch (Exception ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return compras;
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
            String[] res = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6)};
            pp.add(reformarProducto(res));
        }
        this.productos = pp;
    }

    private ListaDeCompras seleccionarCompras() throws SQLException {
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
                    Double.parseDouble(rs.getString(3)), rs.getString(4), Integer.parseInt(rs.getString(1)));
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

    private List<Proveedor> seleccionarProveedores(String ruc) throws SQLException {
        String[] clave = {"ruc:" + ruc};
        ResultSet rs = ejecutarSPParameters(spBuscarProveedor, clave);
        List<Proveedor> pp = new ArrayList<>();
        while (rs.next()) {
            String[] res = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
            pp.add(reformarProveedor(res));
        }
        return pp;
    }

    private List<Producto> seleccionarProductos(String nombre) throws SQLException {
        String[] clave = {"nombre:" + nombre};
        ResultSet rs = ejecutarSPParameters(spBuscarProducto, clave);
        List<Producto> pp = new ArrayList<>();
        while (rs.next()) {
            String[] res = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)};
            pp.add(reformarProducto(res));
        }
        return pp;
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
            String[] res = {rs.getString(3), rs.getString(4), rs.getString(2),rs.getString(6)};
            ss.add(reformarServicio(res));
        }
        this.servicios = ss;
    }

    public int insertarCompra(String estado, String monto, String fecha) throws SQLException {
        String[] param = {"estadocompra:" + estado, "montototal:" + monto, "fechacompra:" + fecha, ""};
        int idCompra = ejecutarSPRegistraCompras(spInsertCompra, param);
        return idCompra;
    }

    public int getIdBien(String nombreBien) throws SQLException {
        String[] param = {"nombreBien:" + nombreBien, ""};
        int idCompra = ejecutarSPGetIdBien(spGetIdBien, param);
        return idCompra;
    }

    public void actualizarCompras(int idCompra, String estado) throws SQLException {
        String[] param = {"idcompra:" + idCompra, "estado:" + estado};
        ResultSet rs = ejecutarSPParameters(spUpdateCompras, param);
    }

    public void actualizarStock(int idBien, int cantidad) throws SQLException {
        String[] param = {"idbien:" + idBien, "cantidad:" + cantidad};
        ResultSet rs = ejecutarSPParameters(spUpdateStock, param);
    }

    public void actualizarProveedor(String ruc, String direccion, String cuenta) throws SQLException {
        String[] param = {"ruc:" + ruc, "direccion:" + direccion, "cuenta:" + cuenta};
        ResultSet rs = ejecutarSPParameters(spUpdateProveedor, param);
    }
    
    public void actualizarBien(int idBien, String nombreBien, double precio, String proveedor) throws SQLException {
        String[] param = {"idBien:" + idBien, "nombreBien:" + nombreBien, "precioBien:" + precio, "proveedor:"+proveedor};
        ResultSet rs = ejecutarSPParameters(spUpdateProducto, param);
    }

    public void disminuirStock(int idBien, int cantidad) throws SQLException {
        cantidad = -cantidad;
        String[] param = {"idbien:" + idBien, "cantidad:" + cantidad};
        ResultSet rs = ejecutarSPParameters(spUpdateStock, param);
    }

    public void insertDetalleCompra(int idCompra, int idBien, int cantidad) throws SQLException {
        String[] param = {"identificadorcomprabien:" + idCompra, "identificadorbien2:" + idBien, "cantidadbien:" + cantidad};
        ResultSet rs = ejecutarSPParameters(spInsertCompraBien, param);
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
            + p.getNombre(), "preciobien:" + p.getPrecio(), "tipobien:Producto", "cantidad:" + p.getCantidad(), "marca:" + p.getMarca(), "categoria:" + p.getCategoria()};
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
        Producto np = new Producto(str[0], Double.parseDouble(str[1]), obtenerProveedor(str[2]), Integer.parseInt(str[3]), str[4],str[5]);
        return np;
    }

    private Proveedor reformarProveedor(String[] str) {
        Proveedor nprov = new Proveedor(str[0], str[1], str[2], str[3]);
        return nprov;
    }

    private Servicio reformarServicio(String[] str) throws SQLException {
        Servicio serv = new Servicio(str[0], Double.parseDouble(str[1]), obtenerProveedor(str[2]));
        serv.setMarca(str[3]);
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
    
        public Proveedor obtenerProveedorRuc(String nombre) throws SQLException {
        seleccionarProveedores();
        Proveedor resultado = null;
        for (Proveedor proveedor : this.proveedores) {
            if (proveedor.getRazonSocial().equals(nombre)) {
                resultado = proveedor;
                break;
            }
        }
        return resultado;
    }

    private void agregarProducto(String[] nuevoProducto) throws SQLException {
        ejecutarSPParameters("insertBien", nuevoProducto);
    }

    public ListaDeBienes getInventarioDb() throws IOException {

        List<Producto> listaProductos = getProductos();
        ArrayList<Bien> auxiliar = new ArrayList<>();

        listaProductos.forEach(products -> {
            auxiliar.add(products);
        });
        return new ListaDeBienes(auxiliar);
    }

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
