package com.epn.trappi;

import com.epn.trappi.db.rrhh.Connect;

public class App {
    /**
     * Inicia la ventana principal de la aplicación
     * @param args 
     */
    public static void main(String args[]){
        MainGui mainWindow = new MainGui();
        mainWindow.setVisible(true);
        Connect.connect();
    }
}
