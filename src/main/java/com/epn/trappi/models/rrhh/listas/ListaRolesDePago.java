package com.epn.trappi.models.rrhh.listas;

import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.models.rrhh.Fecha;
import com.epn.trappi.models.rrhh.juanjo.Empleado;
import com.epn.trappi.models.rrhh.juanjo.RolDePagos;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class ListaRolesDePago implements Lista<RolDePagos> {
    private final Connection connection = Objects.requireNonNull(DataBaseConnection.getInstance()).getConnection();

    @Override
    public void agregar(RolDePagos newRolDePagos) {
        String sql = "INSERT INTO dbo.ROLPAGOS (ID_ROL, IDEMP, FECHAROL, TOTALROL, DESCUENTOSROL, ESTADOROL) VALUES ("
                + (this.obtenerTodos().length + 1) + ","
                + newRolDePagos.getEmpleado().getId() + ","
                + "'" + newRolDePagos.getFecha().toString() + "',"
                + "'" + newRolDePagos.getTotal() + "',"
                + "'" + newRolDePagos.getDescuentos() + "',"
                + "'" + newRolDePagos.getEstado() + "');";

        try {
            PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.execute();
        }catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public Boolean eliminar(String parametro) {
        return null;
    }

    /**
     * Este método trae el último rol registrado en la base de datos
     * @param cedula
     * @return
     */
    @Override
    public RolDePagos buscarUno(String cedula) {
        Empleado empleado = new ListaEmpleados().buscarUno(cedula);
        String sql = "SELECT * FROM ROLPAGOS WHERE IDEMP=" + empleado.getId() + ";";
        RolDePagos roles = null;
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                String unformattedDate = resultSet.getDate(3).toString();
                String[] formattedDate = unformattedDate.split("-");
                roles = new RolDePagos(
                        resultSet.getInt(1),
                        empleado,
                        new Fecha(Integer.parseInt(formattedDate[2]), Integer.parseInt(formattedDate[1]), Integer.parseInt(formattedDate[0])),
                        resultSet.getBigDecimal(4).doubleValue(),
                        resultSet.getBigDecimal(5).doubleValue(),
                        resultSet.getString(6)
                );
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return roles;
    }

    @Override
    public RolDePagos[] obtenerTodos() {
        String sql = "SELECT * FROM ROLPAGOS";
        ArrayList<RolDePagos> roles = new ArrayList<>();
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                String unformattedDate = resultSet.getDate(3).toString();
                String[] formattedDate = unformattedDate.split("-");
                roles.add(new RolDePagos(
                        resultSet.getInt(1),
                        new ListaEmpleados().buscarUno(resultSet.getInt(2)),
                        new Fecha(Integer.parseInt(formattedDate[2]), Integer.parseInt(formattedDate[1]), Integer.parseInt(formattedDate[0])),
                        resultSet.getBigDecimal(4).doubleValue(),
                        resultSet.getBigDecimal(5).doubleValue(),
                        resultSet.getString(6)
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        RolDePagos[] rolesArray = new RolDePagos[roles.size()];
        rolesArray = roles.toArray(rolesArray);
        return rolesArray;
    }

    public RolDePagos[] obtenerTodos(String cedula) {
        Empleado empleado = new ListaEmpleados().buscarUno(cedula);
        String sql = "SELECT * FROM ROLPAGOS WHERE IDEMP=" + empleado.getId() + ";";
        ArrayList<RolDePagos> roles = new ArrayList<>();
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                String unformattedDate = resultSet.getDate(3).toString();
                String[] formattedDate = unformattedDate.split("-");
                roles.add(new RolDePagos(
                        resultSet.getInt(1),
                        empleado,
                        new Fecha(Integer.parseInt(formattedDate[2]), Integer.parseInt(formattedDate[1]), Integer.parseInt(formattedDate[0])),
                        resultSet.getBigDecimal(4).doubleValue(),
                        resultSet.getBigDecimal(5).doubleValue(),
                        resultSet.getString(6)
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        RolDePagos[] rolesArray = new RolDePagos[roles.size()];
        rolesArray = roles.toArray(rolesArray);
        return rolesArray;
    }

    public static void main(String args[]) throws SQLException {
        ListaRolesDePago l1 = new ListaRolesDePago();
        try {
            System.out.println(Arrays.stream(l1.obtenerTodos()).count());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
