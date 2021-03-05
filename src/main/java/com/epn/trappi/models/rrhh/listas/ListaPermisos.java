
package com.epn.trappi.models.rrhh.listas;
import com.epn.trappi.db.connection.DataBaseConnection;
import com.epn.trappi.gui.rrhh.Permisos.Calamidad_Domestica;
import com.epn.trappi.gui.rrhh.Permisos.Enfermedad;
import com.epn.trappi.gui.rrhh.Permisos.Nacimiento_Hijo;
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
    Calamidad_Domestica calamidad;
    Enfermedad enfermedad ;
    Nacimiento_Hijo nacimiento ;
    Otros_Permisos otro ; 
    
    
    
    
    //metodo para agregar un nuevo permiso a la base de datos
    @Override
    public void agregar(Permiso newPermission) {
        try{
            if (newPermission instanceof Calamidad_Domestica){
            int ID = obtenerTodos().length +1;
              
            String consultaSQL = "INSERT INTO dbo.PERMISO(IDPERM, IDEMP, NUMDIASPERM, VALORPAGARPERM, COMENTPERM, FECHAINICIOPERM,"
           + " FECHAFINPERM, ESTADOPERM,TIPOPERM) values (?,?,?,?,?,?,?,?,?)";
            
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setInt(1, ID); 
            pstm.setInt(2, newPermission.getEmpleado().getId());           
                System.out.println(newPermission.getEmpleado().getId());
            pstm.setInt(3,newPermission.getNUMDIASPERM());
            pstm.setString(4,newPermission.getVALORPAGARPERM()); 
            pstm.setString(5,newPermission.getCOMENTPERM());         
            pstm.setString(6,newPermission.getFECHAINICIOPERM());            
            pstm.setString(7, newPermission.getFECHAFINPERM());  
            pstm.setString(8, newPermission.getESTADOPERM());           
            pstm.setString(9, "Calamidad Domestica");
            
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null,"El permiso se ha registrado con exito");
            }
            if(newPermission instanceof Enfermedad){
                int ID = obtenerTodos().length +1;
            String consultaSQL = "INSERT INTO dbo.PERMISO(IDPERM, IDEMP, NUMDIASPERM, VALORPAGARPERM, COMENTPERM, FECHAINICIOPERM,"
           + " FECHAFINPERM,ESTADOPERM,TIPOPERM) values (?,?,?,?,?,?,?,?,?)";
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
            if(newPermission instanceof Nacimiento_Hijo){
                int ID = obtenerTodos().length +1;
            String consultaSQL = "INSERT INTO dbo.PERMISO(IDPERM, IDEMP, NUMDIASPERM, VALORPAGARPERM, COMENTPERM, FECHAINICIOPERM,"
           + " FECHAFINPERM,ESTADOPERM,TIPOPERM) values (?,?,?,?,?,?,?,?,?)";
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setInt(1, ID);
            pstm.setInt(2, newPermission.getEmpleado().getId());
            pstm.setInt(3,newPermission.getNUMDIASPERM());
            pstm.setString(4,newPermission.getVALORPAGARPERM());
            pstm.setString(5,newPermission.getCOMENTPERM());
            pstm.setString(6,newPermission.getFECHAINICIOPERM());
            pstm.setString(7, newPermission.getFECHAFINPERM());
            pstm.setString(8, newPermission.getESTADOPERM());
            pstm.setString(9, "Nacimiento_Hijo");
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null,"El permiso se ha registrado con exito");
            }
            else if (newPermission instanceof Otros_Permisos){
                int ID = obtenerTodos().length +1;
            String consultaSQL = "INSERT INTO dbo.PERMISO(IDPERM, IDEMP, NUMDIASPERM, VALORPAGARPERM, COMENTPERM, FECHAINICIOPERM,"
           + " FECHAFINPERM,ESTADOPERM,TIPOPERM) values (?,?,?,?,?,?,?,?,?)";
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
                switch (rs.getString(9)) {
                    case "Calamidad Domestica":
                        listaPermiso.add(new Calamidad_Domestica(

                                currentEmpleado,
                                rs.getInt(3),
                                rs.getString(4),
                                rs.getString(5),
                                rs.getString(6),
                                rs.getString(7),
                                rs.getString(8)
                        ));
                        break;
                    case "Enfermedad":
                        listaPermiso.add(new Enfermedad(

                                currentEmpleado,
                                rs.getInt(3),
                                rs.getString(4),
                                rs.getString(5),
                                rs.getString(6),
                                rs.getString(7),
                                rs.getString(8)
                        ));
                        break;
                    case "Nacimiento Hijos":
                        listaPermiso.add(new Nacimiento_Hijo(

                                currentEmpleado,
                                rs.getInt(3),
                                rs.getString(4),
                                rs.getString(5),
                                rs.getString(6),
                                rs.getString(7),
                                rs.getString(8)
                        ));
                        break;
                    default:
                        listaPermiso.add(new Otros_Permisos(

                                currentEmpleado,
                                rs.getInt(3),
                                rs.getString(4),
                                rs.getString(5),
                                rs.getString(6),
                                rs.getString(7),
                                rs.getString(8)

                        ));
                        break;
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
    public Permiso buscarUno(String cedulaEmpleado) {
        
         Permiso permiso_especifico = null;
        try {
            String query = "SELECT * FROM PERMISO JOIN EMPLEADO on PERMISO.IDEMP = EMPLEADO.ID_EMP WHERE CEDULAEMP ='"+cedulaEmpleado+"'";
           // System.out.println(query);
            pstm = conn.prepareStatement(query);
            //pstm.setString(0, cedulaAspirante);
            rs = pstm.executeQuery();
            rs.next();
            
            if (rs.getString(21).equals("Calamidad Domestica")){
               permiso_especifico =new Calamidad_Domestica(rs.getInt("NUMDIASPERM"), rs.getString("VALORPAGARPERM"),
            rs.getString("FECHAINICIOPERM"),rs.getString("FECHAFINPERM"));
             System.out.println("Consulta Buscar un permiso se hizo con exito"); 
            }
             if (rs.getString(21).equals("Enfermedad")){
               permiso_especifico =new Enfermedad(rs.getInt("NUMDIASPERM"), rs.getString("VALORPAGARPERM"),
            rs.getString("FECHAINICIOPERM"),rs.getString("FECHAFINPERM"));
             System.out.println("Consulta Buscar una permiso se hizo con exito"); 
            }
              if (rs.getString(21).equals("Nacimiento Hijos")){
               permiso_especifico =new Nacimiento_Hijo(rs.getInt("NUMDIASPERM"), rs.getString("VALORPAGARPERM"),
            rs.getString("FECHAINICIOPERM"),rs.getString("FECHAFINPERM"));
             System.out.println("Consulta Buscar una permiso se hizo con exito"); 
            }

               if (rs.getString(21).equals("Otros Permisos")){
               permiso_especifico =new Otros_Permisos(rs.getInt("NUMDIASPERM"), rs.getString("VALORPAGARPERM"),
            rs.getString("FECHAINICIOPERM"),rs.getString("FECHAFINPERM"));
             System.out.println("Consulta Buscar una permiso se hizo con exito"); 
            }
            
           
        } catch (Exception e) {
            System.out.println("Error en consulta de buscar un permiso (" + cedulaEmpleado+"): " + e);
        }
        finally{
            try {
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();
                
            } catch (Exception e) {
                System.out.println("Error al cerrar rs y pstm: " + e);
            }
        }
        return permiso_especifico;
    }
}
