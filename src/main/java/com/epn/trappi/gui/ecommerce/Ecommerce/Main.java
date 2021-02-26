
package com.epn.trappi.gui.ecommerce.Ecommerce;

import com.epn.trappi.gui.ecommerce.Ecommerce.Articulo;
import com.epn.trappi.gui.ecommerce.Ecommerce.Cliente;
import com.epn.trappi.gui.ecommerce.Ecommerce.Stock;
import FormulariosCliente.FRegistroCliente;
import com.epn.trappi.gui.ecommerce.Interfaces.Login;
import FormulariosTarjetas.FRegistroTarjeta;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {
    
    public static Cliente cliente=new Cliente();
    public static Stock stock;
    public static  ArrayList<Cliente> listaclientes;
            
    public static void main(String[] args)
    {   
        Cliente cliente1, cliente2;
        listaclientes=new ArrayList<>();
        FRegistroCliente frc=new FRegistroCliente("Luis Suarez","elpistolero@fcb.com","23/10/1999","0992772076","Quito","1721791661","contrasena1");
        FRegistroCliente frc1=new FRegistroCliente("Jose ","jose@fcb.com","23/10/1999","0992772076","Quito","1721791661","contrasena2");
        cliente1=new Cliente();
        cliente2=new Cliente();
        cliente1.registrarse(frc);
        cliente2.registrarse(frc1);
        listaclientes.add(cliente1);
        listaclientes.add(cliente2);
        FRegistroTarjeta frt=new FRegistroTarjeta("5100707610539502","456","12/2023","Credito");
        FRegistroTarjeta frt1=new FRegistroTarjeta("5274708540061716","123","08/2026","Debito");
        Articulo art1=new Articulo("123","Leche Toni",0.78,50,"Nestle");
        Articulo art2=new Articulo("724","Manicho",0.32,79,"La Universal");
        stock=new Stock();
        stock.listaarticulos.add(art1);
        stock.listaarticulos.add(art2);
        cliente1.añadirTarjeta(frt);
        cliente2.añadirTarjeta(frt1);
        Login login=new Login();
        login.setVisible(true);
    }
    
}
