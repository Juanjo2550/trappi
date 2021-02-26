
package com.epn.trappi.gui.ecommerce.Ecommerce;

import java.util.ArrayList;


public class Stock {
 
    public ArrayList<Articulo> listaarticulos;

    public Stock() {
        listaarticulos=new ArrayList<>();
    }
    
    
    public ArrayList obtenerStock(){
     
       return listaarticulos;
    }
   
}
