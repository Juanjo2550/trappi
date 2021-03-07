
package com.epn.trappi.gui.ecommerce.Ecommerce;

import com.epn.trappi.gui.ecommerce.FormulariosCliente.FRegistroCliente;
import com.epn.trappi.gui.ecommerce.Interfaces.Login;
import com.epn.trappi.gui.ecommerce.FormulariosTarjetas.FRegistroTarjeta;
import com.epn.trappi.gui.ecommerce.Tarjetas.TarjetaCredito;
import com.epn.trappi.gui.ecommerce.Tarjetas.TarjetaDebito;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {
    
    public static Cliente cliente=new Cliente();

    public static  ArrayList<Cliente> listaclientes;
    public static TarjetaCredito tarcre=new TarjetaCredito();
    public static TarjetaDebito tardeb=new TarjetaDebito();
    public static String tip;
            
    public static void main(String[] args)
    {   
        
        Login login=new Login();
        login.setVisible(true);
    }
    
}
