/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ecommerce;

import java.util.ArrayList;

/**
 *
 * @author Bryan
 */
public class EntidadBancaria {
    String Nombre;
    String Numeroautorizacion;
    public ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
    
    public void añadirCuenta( String NumeroCuenta,String CedulaPropietario)
    {
        Cuenta account = new Cuenta();
        account.NumeroCuenta=NumeroCuenta;
        account.CedulaPropietario=CedulaPropietario;
        
        cuentas.add(account);
    }
    
    public void borrarCuenta( String NumeroCuenta)
    {
        for(int i=0;i<cuentas.size();i++)
        {
          
            if(cuentas.get(i).NumeroCuenta.equals(NumeroCuenta))
            {
                cuentas.remove(i);
                break;
            }
        
        }
    }
    
}
