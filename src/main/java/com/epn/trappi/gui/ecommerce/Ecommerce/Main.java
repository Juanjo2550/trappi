
package com.epn.trappi.gui.ecommerce.Ecommerce;

import com.epn.trappi.gui.ecommerce.FormulariosCliente.FRegistroCliente;
import com.epn.trappi.gui.ecommerce.Interfaces.Login;
import com.epn.trappi.gui.ecommerce.FormulariosTarjetas.FRegistroTarjeta;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {
    
    public static Cliente cliente=new Cliente();
    public static Stock stock;
    public static  ArrayList<Cliente> listaclientes;
            
    public static void main(String[] args)
    {   
        
        Login login=new Login();
        login.setVisible(true);
    }
    
}
