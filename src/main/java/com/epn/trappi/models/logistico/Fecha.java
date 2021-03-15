package com.epn.trappi.models.logistico;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Fecha {
    private int dia,mes,anio;
    
    public Fecha(String fecha){
        setFecha(fecha);
    }

    public int getAnio() {
        return anio;
    }

    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }
    
    public void setFecha(String fecha){
        StringTokenizer tk=new StringTokenizer(fecha,"/");
        this.dia=Integer.parseInt(tk.nextToken());
        this.mes=Integer.parseInt(tk.nextToken());
        this.anio=Integer.parseInt(tk.nextToken());
    }
    
    public boolean validarFecha(String fecha){
        Pattern pat = Pattern.compile("^(?:(?:(?:0?[1-9]|1\\d|2[0-8])[/](?:0?[1-9]|1[0-2])|(?:29|30)[/](?:0?[13-9]|1[0-2])|31[/](?:0?[13578]|1[02]))[/](?:0{2,3}[1-9]|0{1,2}[1-9]\\d|0?[1-9]\\d{2}|[1-9]\\d{3})|29[/]0?2[/](?:\\d{1,2}(?:0[48]|[2468][048]|[13579][26])|(?:0?[48]|[13579][26]|[2468][048])00))$");
        Matcher mat = pat.matcher(fecha);
        return mat.matches();
    }

    @Override
    public String toString() {
        return dia+"/"+mes+"/"+anio;
    }
}