package com.epn.trappi.db.connection;

import java.sql.*;

public class DataBaseConnection {
    private static DataBaseConnection instance;
    private Connection connection;
    private String url =
            "jdbc:sqlserver://eu-az-sql-serv1.database.windows.net:1433;"
                    + "database=trappiDb;"
                    + "user=admintrappiuser;"
                    + "password=VEU!SSz7$M%kcM;"
                    + "encrypt=true;"
                    + "trustServerCertificate=false;"
                    + "loginTimeout=30;";

    private DataBaseConnection() throws SQLException {
        this.connection = DriverManager.getConnection(url);
    }

    public Connection getConnection() {
        return this.connection;
    }

    public static DataBaseConnection getInstance() {
        try {
            if (instance == null) {
                instance = new DataBaseConnection();
            } else if (instance.getConnection().isClosed()) {
                instance = new DataBaseConnection();
            }

            return instance;
        } catch (SQLException e) {
            System.out.println("Database Connection Creation Failed : " + e.getMessage());
            return null;
        }
    }

    //EJEMPLO DE USO DE ESTA CLASE Y DE UN QUERY A LA BASE DE DATOS CENTRAL
//    public static void main(String args[]) throws SQLException {
//        DataBaseConnection dbInstance = DataBaseConnection.getInstance();
//        Connection connection = dbInstance.getConnection();
//        Statement statement = connection.createStatement();
//        String sql = "select * from sys.database_principals";
//        ResultSet resultSet = statement.executeQuery(sql);
//        System.out.println(resultSet);        
//        while (resultSet.next()) {
//            System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
//        }
//    }
}
