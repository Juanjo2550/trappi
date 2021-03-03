
package com.epn.trappi.models.rrhh.listas;
import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.gui.rrhh.Permisos.Calamidad_Domestica;
import com.epn.trappi.gui.rrhh.Permisos.Enfermedad;
import com.epn.trappi.gui.rrhh.Permisos.Otros_Permisos;
import com.epn.trappi.gui.rrhh.Permisos.Permiso;
import com.epn.trappi.models.rrhh.juanjo.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.JOptionPane;

/**
 *
 * @author stali
 */
public class ListaPermisos implements Lista<Permiso>{
    PreparedStatement pstm = null;
    ResultSet rs = null;
    DataBaseConnection dbInstance = DataBaseConnection.getInstance();
    Connection conn = dbInstance.getConnection();
    ArrayList<Permiso> listaPermiso;
    
    
    
    //metodo para agregar un nuevo permiso a la base de datos
    @Override
    public void agregar(Permiso newPermission) {
        try{
            if (newPermission instanceof Calamidad_Domestica){
            int ID = obtenerTodos().length +1;
                System.out.println("hola+");
            String consultaSQL = "INSERT INTO dbo.PERMISO(IDPERM, IDEMP, NUMDIASPERM, VALORPAGARPERM, COMENTPERM, FECHAINICIOPERM,"
           + " FECHAFINPERM, ESTADOPERM,TIPOPERM) values (?,?,?,?,?,?,?,?,?)";
            System.out.println("hola+1");
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setInt(1, ID);
            System.out.println("hola2");
                System.out.println(ID);
                System.out.println(newPermission.getESTADOPERM());
            pstm.setInt(2, newPermission.getEmpleado().getId());
            System.out.println("hola3");
                System.out.println(newPermission.getEmpleado().getId());
            pstm.setInt(3,newPermission.getNUMDIASPERM());
             System.out.println("hola4");
            pstm.setString(4,newPermission.getVALORPAGARPERM());
             System.out.println("hola5");
            pstm.setString(5,newPermission.getCOMENTPERM());
             System.out.println("hola6");
            pstm.setString(6,newPermission.getFECHAINICIOPERM());
             System.out.println("hola7");
            pstm.setString(7, newPermission.getFECHAFINPERM());
             System.out.println("hola8");
            pstm.setString(8, newPermission.getESTADOPERM());
             System.out.println("hola9");
            pstm.setString(9, "Calamidad Domestica");
             System.out.println("hola10");
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null,"El permiso se ha registrado con exito");
            }
            else if(newPermission instanceof Enfermedad){
                int ID = obtenerTodos().length +1;
            String consultaSQL = "INSERT INTO dbo.PERMISO(IDPERM, IDEMP, NUMDIASPERM, VALORPAGARPERM, COMENTPERM, FECHAINICIOPERM,"
           + " FECHAFINPERM,ESTADOPERM,TIPOPERM) values (?,?,?,?,?,?,?)";
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setInt(1, ID);
            pstm.setInt(2, newPermission.getEmpleado().getId());
            pstm.setInt(3,newPermission.getNUMDIASPERM());
            pstm.setString(4,newPermission.getVALORPAGARPERM());
            pstm.setString(5,newPermission.getCOMENTPERM());
            pstm.setString(6,newPermission.getFECHAINICIOPERM());
            pstm.setString(7, newPermission.getFECHAFINPERM());
            pstm.setString(8, newPermission.getESTADOPERM());
            pstm.setString(9, "Enfermedad");
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null,"El permiso se ha registrado con exito");
            }
            else{
                int ID = obtenerTodos().length +1;
            String consultaSQL = "INSERT INTO dbo.PERMISO(IDPERM, IDEMP, NUMDIASPERM, VALORPAGARPERM, COMENTPERM, FECHAINICIOPERM,"
           + " FECHAFINPERM,ESTADOPERM,TIPOPERM) values (?,?,?,?,?,?,?)";
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setInt(1, ID);
            pstm.setInt(2, newPermission.getEmpleado().getId());
            pstm.setInt(3,newPermission.getNUMDIASPERM());
            pstm.setString(4,newPermission.getVALORPAGARPERM());
            pstm.setString(5,newPermission.getCOMENTPERM());
            pstm.setString(6,newPermission.getFECHAINICIOPERM());
            pstm.setString(7, newPermission.getFECHAFINPERM());
            pstm.setString(8, newPermission.getESTADOPERM());
            pstm.setString(9, "Otro Permiso");
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null,"El permiso se ha registrado con exito");
            }   
        }
        catch (Exception e) {
            System.out.println("No se pudo registrar el Permiso: " + e);
        }
        finally{
            try {
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();
                
            } catch (Exception e) {
                System.out.println("Error al cerrar rs y pstm: " + e);
            }
        }
      
    }

    
  
//metodo creado para obtener todos los permisos almacenados en la base de datos
    public Permiso[] obtenerTodos(){
        listaPermiso = new ArrayList<>();
        ListaEmpleados l1 = new ListaEmpleados();
        Empleado[] empleados = l1.obtenerTodos();
 
        try {
            String sql = "SELECT * FROM dbo.PERMISO";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()) {
                 Empleado currentEmpleado = null;
                for (Empleado emp : empleados) {
                    if (emp.getId() == rs.getInt(2)){
                        currentEmpleado = emp;
                    }
                }
                if(rs.getString(9).equals("Calamidad Domestica")) {
                    listaPermiso.add(new Calamidad_Domestica(
                            
                            currentEmpleado,
                            rs.getInt(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8)
                            ));
                }
                else if (rs.getString(9).equals("Enfermedad")) {
                     listaPermiso.add(new Enfermedad(
                            
                            currentEmpleado,
                            rs.getInt(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8)
                            ));
                }
                     else {
                          listaPermiso.add(new Otros_Permisos(
                            
                            currentEmpleado,
                            rs.getInt(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8)
                            
                            ));
                 
                         }
                

            }
          System.out.println("Consulta se hizo con exito");
        } 
        catch (SQLException e){
            System.out.println(e.toString());
        }
        Permiso[] Lista_Permisos = new Permiso[listaPermiso.size()];
        Lista_Permisos = listaPermiso.toArray(Lista_Permisos);
        return Lista_Permisos;
    }   
    
      public Boolean eliminar(String parametro) {
        return null; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Permiso buscarUno(String parametro) {
        return null; //To change body of generated methods, choose Tools | Templates.
    }
}
