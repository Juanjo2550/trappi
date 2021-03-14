/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.ecommerce.Ecommerce;

import com.epn.trappi.gui.ecommerce.FormulariosCliente.FEdicionCliente;
import com.epn.trappi.gui.ecommerce.FormulariosCliente.FRegistroCliente;
import com.epn.trappi.gui.ecommerce.FormulariosTarjetas.FEdicionTarjeta;
import com.epn.trappi.gui.ecommerce.FormulariosTarjetas.FRegistroTarjeta;
import com.epn.trappi.gui.ecommerce.Interfaces.Inicio;
import com.epn.trappi.gui.ecommerce.Interfaces.Login;
import com.epn.trappi.gui.ecommerce.Tarjetas.Tarjeta;
import com.epn.trappi.gui.ecommerce.Tarjetas.TarjetaCredito;
import com.epn.trappi.gui.ecommerce.Tarjetas.TarjetaDebito;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_OPTION;

/**
 *
 * @author GrupoD
 */
public class Cliente {
   public String Nombre;
   public String Correo;
   public String Fechadenacimiento;
   public String Celular;
   public String Direccion;
   public String Cedula;
   public String Contraseña;

    public String getDireccion() {
        return Direccion;
    }
    
    public void entrarAlSistema(){
        Inicio inicio=new Inicio();
        inicio.setVisible(true);
    }
    
    public void registrarse( FRegistroCliente registrar)
    {
       String[] datos = registrar.obtenerDatos();
       
       this.Nombre = datos[0];
       this.Correo = datos[1];
       this.Fechadenacimiento=datos[2];
       this.Celular = datos[3];
       this.Direccion= datos[4];
       this.Cedula=datos[5];
       this.Contraseña=datos[6];
       Inicio inicio=new Inicio();
       inicio.setVisible(true);
    }
    
    public void editarMisDato(FEdicionCliente editar){

       String[] datos = editar.obtenerDatos();
       
       this.Nombre = datos[0];
       this.Correo = datos[1];
       this.Fechadenacimiento=datos[2];
       this.Celular = datos[3];
       this.Direccion= datos[4];
       this.Cedula=datos[5];
       this.Contraseña=datos[6];
     
    }
    
    
    public void eliminarse()
    {
    this.Nombre =null;
       this.Correo =null;
       this.Fechadenacimiento=null;
       this.Celular =null;
       this.Direccion =null;
       this.Cedula =null;
       this.Contraseña =null;
    Login login=new Login();
    login.setVisible(true);
    }
    
    public void salirSistema()
    {
       if(JOptionPane.showConfirmDialog(null, "¿Está seguro que desea Cerrar Sesión?","Su sesión finalizará",JOptionPane.YES_NO_OPTION)==YES_OPTION){
       Login login=new Login();
       login.setVisible(true);
       }
    }
    
    
    ////////Agregaciòn con Tarjeta///////////
    public ArrayList<Tarjeta> tarjeta = new ArrayList<Tarjeta>();
    
    public void añadirTarjeta(FRegistroTarjeta registrar)
        {
            
         if(registrar.Tipo.equals("Credito"))
            {
                TarjetaCredito tarjet = new TarjetaCredito();
                
                String[] datos = registrar.obtenerDatos();

                tarjet.Tipo = datos[3];
                tarjet.NumeroTarjeta=datos[0];
                tarjet.CVV=datos[1];
                tarjet.Fechacaducidad=datos[2]; 
                
                tarjeta.add(tarjet);
            }
            else
            {
                TarjetaDebito tarjet = new TarjetaDebito();
                String[] datos = registrar.obtenerDatos();

                
                tarjet.Tipo = datos[3];
                tarjet.NumeroTarjeta=datos[0];
                tarjet.CVV=datos[1];
                tarjet.Fechacaducidad=datos[2]; 
                
                tarjeta.add(tarjet);
            }
            
        }
     
    public void editarTarjetaCredito(FEdicionTarjeta editar)
        {
         String[] datos = editar.obtenerDatos();
            
            if(datos[3].equals("Credito")){
            for (int i = 0; i <this.tarjeta.size(); i++) {
            if((this.tarjeta.get(i).mostrar()[0]).equals(editar.obtenerDatos())){
            this.tarjeta.get(i).CVV=datos[1];
            this.tarjeta.get(i).Fechacaducidad=datos[2];
            }
            }
            }
            else{
            for (int i = 0; i <this.tarjeta.size(); i++) {
            if((this.tarjeta.get(i).mostrar()[0]).equals(editar.obtenerDatos())){
            this.tarjeta.remove(i);
            }
            }
            TarjetaCredito tc=new TarjetaCredito();
            tc.NumeroTarjeta=datos[0];
            tc.CVV=datos[1];
            tc.Fechacaducidad=datos[2];
            tc.Tipo="Debito";
            this.tarjeta.add(tc);
            }
        }

    public void editarTarjetaDebito(FEdicionTarjeta editar)
        {
            String[] datos = editar.obtenerDatos();
            
            if(datos[3].equals("Debito")){
            for (int i = 0; i <this.tarjeta.size(); i++) {
            if((this.tarjeta.get(i).mostrar()[0]).equals(editar.obtenerDatos())){
            this.tarjeta.get(i).CVV=datos[1];
            this.tarjeta.get(i).Fechacaducidad=datos[2];
            }
            }
            }
            else{
            for (int i = 0; i <this.tarjeta.size(); i++) {
            if((this.tarjeta.get(i).mostrar()[0]).equals(editar.obtenerDatos())){
            this.tarjeta.remove(i);
            }
            }
            TarjetaCredito tc=new TarjetaCredito();
            tc.NumeroTarjeta=datos[0];
            tc.CVV=datos[1];
            tc.Fechacaducidad=datos[2];
            tc.Tipo="Credito";
            this.tarjeta.add(tc);
            }
            
            

        }
    
    public void eliminarTarjeta(String numerotar){
        for (int i = 0; i <this.tarjeta.size(); i++) {
            if((this.tarjeta.get(i).mostrar()[0]).equals(numerotar)){
            this.tarjeta.remove(i);
            }
            }

    
    }
    
}
    
   
