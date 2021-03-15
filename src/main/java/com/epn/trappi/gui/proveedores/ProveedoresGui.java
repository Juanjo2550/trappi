package com.epn.trappi.gui.proveedores;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class ProveedoresGui {

    public static void main(String args[]) {
        try {
            Principal d = new Principal();
            d.setExtendedState(d.getExtendedState() | JFrame.MAXIMIZED_BOTH);
            d.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(ProveedoresGui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
