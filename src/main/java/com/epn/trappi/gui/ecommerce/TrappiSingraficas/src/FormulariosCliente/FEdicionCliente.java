/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormulariosCliente;



/**
 *
 * @author Bryan
 */
public class FEdicionCliente implements FormularioCliente {

    String Nombre;
    String Correo;
    String Fechadenacimiento;
    String Celular;
    String Direccion;
    String cedula;
    String contraseña;
    
    
    public FEdicionCliente(String Nombre, String Correo, String Fechadenacimiento, String Celular, String Direccion,   String cedula, String contraseña) {
        this.Nombre = Nombre;
        this.Correo = Correo;
        this.Fechadenacimiento = Fechadenacimiento;
        this.Celular = Celular;
        this.Direccion = Direccion;
        this.cedula=cedula;
        this.contraseña=contraseña;
 
    }

 

        @Override
        public String[] obtenerDatos() {

           String[] datos = new String[7];
           
           datos[0]=this.Nombre;
           datos[1]=this.Correo;
           datos[2]=this.Fechadenacimiento;;
           datos[3]=this.Celular;
           datos[4]=this.Direccion;
           datos[5]=this.cedula;
           datos[6]=this.contraseña;
           return datos;
        }
    
}
