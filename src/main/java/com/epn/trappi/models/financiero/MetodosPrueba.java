
package com.epn.trappi.models.financiero;

import com.epn.trappi.db.connection.DataBaseConnection;
import java.sql.Connection;

public class MetodosPrueba {
    
    public static void main(String[] args){
        DataBaseConnection dbInstance = DataBaseConnection.getInstance();
        Connection connection = dbInstance.getConnection();
//        Ingreso ingreso = new Ingreso();
//        Devolucion devolucion = new Devolucion();
//        Pago pago = new Pago("89765466",1);
//        ingreso.registrarIngreso(200, 1);
//        pago.realizarPago(pago);
//        System.out.println(devolucion.procesarDevolucion(10));
        LibroDiario lb = new LibroDiario();
//        lb.quitarIngreso(200);
//        lb.quitarPago("89765466");
        lb.quitarDevolucion(10);
        
        
    }
            
}
