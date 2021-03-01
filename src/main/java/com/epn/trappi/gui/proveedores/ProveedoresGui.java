package com.epn.trappi.gui.proveedores;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProveedoresGui {
    
    public static void main(String args[]){
        try {
            Principal d = new Principal();
            d.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(ProveedoresGui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
