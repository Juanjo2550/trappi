/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.proveedores;

import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.db.proveedores.ProveedoresDb;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Peterca
 */
public class MainProveedores {

    public static void main(String args[]) throws SQLException, IOException {
        ProveedoresDb db = new ProveedoresDb();
        /*DataBaseConnection dbInstance = DataBaseConnection.getInstance();
        Connection connection = dbInstance.getConnection();
        Statement statement = connection.createStatement();
        CallableStatement cstmt = null;
        cstmt = connection.prepareCall(
                "{call selectAllProveedor}");
        boolean resultSet = cstmt.execute();
        System.out.println(resultSet);
         */
 /*while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
        }*/

        //db.getProveedores();
        //ListaProveedores prov = new ListaProveedores();
        /*int id = db.getIdBien("Jugo");
        System.out.println(id);*/
        /*List<Producto> prod = db.seleccionarComprabien(1);
        prod.forEach(p -> {
            System.out.println(p.getNombre() + ";" + p.getPrecio() + ";" + p.getProveeedor().getRuc());
        });*/
 /*db.getInventarioDb();
        
        ListaDeBienes prod = db.getInventarioDb();
        prod.getListaBienes().forEach(p -> {
            System.out.println(p.getNombre() + ";" + p.getPrecio() + ";" + p.getProveeedor().getRuc());
        });*/

        db.actualizarProveedor("7043728305001","Guayaquil","1547935481");
        /*ListaDeCompras comp = db.seleccionarCompras();

        List<Servicio> serv = db.getServicios();
        comp.getCompras().forEach(pr -> {
            System.out.println(pr.getEstado() + ";" + pr.getFecha()+ ";" + pr.getListaCantidadDeBienes());
        });*/

 /*String [] params = {"ruc:7043728305001","nombrebien:Papel higienico","preciobien:2.8","tipobien:Producto","cantidad:50","marca:Familia"};
        
        db.ejecutarSPParameters("insertBien", params);*/
    }
}
