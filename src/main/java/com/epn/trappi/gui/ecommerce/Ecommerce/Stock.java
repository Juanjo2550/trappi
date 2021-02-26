
package Ecommerce;

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
