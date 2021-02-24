
package Ecommerce;

import javax.swing.JOptionPane;
import Interfaces.LOGIN1;
import java.util.ArrayList;
import FormulariosTarjetas.FRegistroTarjeta;
import FormulariosCliente.FRegistroCliente;
public class Main {
    
    public static Cliente cliente;
    public static Stock stock;
    
    public static void main(String[] args)
    {   
        FRegistroCliente frc=new FRegistroCliente("usuario","c","03/12/1999","049498399302","quito","029384992","c");
        cliente.registrarse(frc);
        FRegistroTarjeta frt=new FRegistroTarjeta("dfvdvdfvdfv","dfvcdf","dfvd","Credito");
        FRegistroTarjeta frt1=new FRegistroTarjeta("dfvdvdfvdbfthbfdfv","dfrgdrtvcdf","dfvdsergdr","Credito");
        Articulo art1=new Articulo("123","leache",23.5,5,"nestle");
        Articulo art2=new Articulo("724","mani",23.5,5,"nestle");
        stock=new Stock();
        stock.listaarticulos.add(art1);
        stock.listaarticulos.add(art2);
        cliente = new Cliente();
        cliente.añadirTarjeta(frt);
        cliente.añadirTarjeta(frt1);
        LOGIN1 login=new LOGIN1();
        login.setVisible(true);
    }
    
}
