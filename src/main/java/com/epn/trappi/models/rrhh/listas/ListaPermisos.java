/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.rrhh.listas;
import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.gui.rrhh.Permisos.Calamidad_Domestica;
import com.epn.trappi.gui.rrhh.Permisos.Enfermedad;
import com.epn.trappi.gui.rrhh.Permisos.Otros_Permisos;
import com.epn.trappi.gui.rrhh.Permisos.Permiso;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author stali
 */
public class ListaPermisos implements Lista<Permiso>{
    private final Connection connection = Objects.requireNonNull(DataBaseConnection.getInstance()).getConnection();
    @Override
  /*  public void agregar(Permiso newPermission) {
        String querySQL;
        if (newPermission instanceof Permiso){

        querySQL = "INSERT INTO dbo.PERMISO(IDPERM, IDEMP, NUMDIASPERM, VALORPAGARPERM, COMENTPERM, FECHAINICIOPERM,"
           + " FECHAFINPERM, ESTADOPERM, TIPOPERM) " +
                    "VALUES (" +
                    (this.obtenerTodos().length + 1) + "," +
                    "'" + nuevoEmpleado.getNombres() + "' ," +
                    "'" + nuevoEmpleado.getApellidos() + "' ," +
                    "'" + nuevoEmpleado.getCedula() + "' ," +
                    "'" + nuevoEmpleado.getCargo() + "' ," +
                    "'" + nuevoEmpleado.getDepartamento() + "' ," +
                    "'" + nuevoEmpleado.getCuentaBancaria() + "' ," +
                    "'" + nuevoEmpleado.getBanco() + "' ," +
                    "'" + nuevoEmpleado.getEstado() + "'," +
                    "'conductor',"+
                    "'" + nuevoEmpleado.getSueldo() + "'," +
                    "'" + nuevoEmpleado.getSexo() + "');";
        }   
    }*/

    
    public Boolean eliminar(String parametro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Permiso buscarUno(String parametro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Permiso[] obtenerTodos(){
        String sql = "SELECT * FROM dbo.PERMISO";
        ArrayList<Permiso> permisos = new ArrayList<>();
        try {
            Statement createdStatment = this.connection.createStatement();
            ResultSet resultSet = createdStatment.executeQuery(sql);
            while(resultSet.next()) {
                if(resultSet.getString(9).equals("Calamidad Domestica")) {
                    permisos.add(new Calamidad_Domestica(
                            resultSet.getInt(1),
                            resultSet.getInt(2),
                            resultSet.getInt(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getString(8),
                            resultSet.getString(9)
                ));
                } else if (resultSet.getString(9).equals("Enfermedad")) {
                     permisos.add(new Enfermedad(
                            resultSet.getInt(1),
                            resultSet.getInt(2),
                            resultSet.getInt(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getString(8),
                            resultSet.getString(9)
                ));
                }
                     else {
                          permisos.add(new Otros_Permisos(
                            resultSet.getInt(1),
                            resultSet.getInt(2),
                            resultSet.getInt(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getString(8),
                            resultSet.getString(9)
                ));  
                             }
                

            }
        } catch (SQLException e){
            System.out.println(e.toString());
        }
        Permiso[] Lista_Permisos = new Permiso[permisos.size()];
        Lista_Permisos = permisos.toArray(Lista_Permisos);
        return Lista_Permisos;
    }

    @Override
    public void agregar(Permiso newObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
