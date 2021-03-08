/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.logistico;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;
import com.teamdev.jxbrowser.view.swing.BrowserView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexander
 */
public class MapaGeografico {
    //ATRIBUTOS
    private EngineOptions options;
    private Engine engine;
    private Browser browser;
    private BrowserView view; //componente con la representación visual del mapa
    //METODOS
    public MapaGeografico(){
        inicializar();
    }
    //Este método inicializa el motor de busquedas que será el contenedor de los mapas de rutas.
    private void inicializar(){
        System.setProperty("jxbrowser.license.key","1BNDHFSC1FYA7D64SFQJOK18Y1R6DP8HFT66SD4MDP3YKT2QSIAZESB9FLPV71B9WTUE3Z");
        options = EngineOptions.newBuilder(HARDWARE_ACCELERATED).build();
        engine = Engine.newInstance(options);
        browser = engine.newBrowser();
        view = BrowserView.newInstance(browser);
    }
    public void trazarRuta(Ruta ruta){
        String origen=ruta.origen.getFcids();
        String destino=ruta.destino.getFcids();
        String CLAVE = "AIzaSyCHuP7hcXW03RWo89ukuZEb3QNKSt_hwwQ";
        String IFrame = "<iframe width=\"965\" height=\"700\"  style=\"border:0\"  allowfullscreen src=\"https://www.google.com/maps/embed/v1/directions?origin=place_id:"+origen+"&destination=place_id:"+destino+"&key="+CLAVE+"\"></iframe>";
        try {
            PrintWriter out = new PrintWriter("ruta.html");
            out.println(IFrame);
            out.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Servicio de GPS no disponible");
        }
        //this.browser.navigation().loadUrl(new File("ruta.html").getAbsolutePath());
        actualizarMapa(new File("ruta.html").getAbsolutePath());
    }
    private void actualizarMapa(String Url){
        this.browser.navigation().loadUrl(Url);
    }
    public BrowserView grafico(){
        return this.view;
    }
}
