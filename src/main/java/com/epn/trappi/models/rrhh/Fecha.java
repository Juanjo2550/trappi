/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.models.rrhh;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class Fecha {

    private int dia;
    private int mes;
    private int año;

    //constructor por defecto, se crea una fecha con la fecha del sistema
    public Fecha() {
        LocalDate unformatedDate = java.time.LocalDate.now();
        String[] splitedDate = unformatedDate.toString().split("-");
        try {
            this.año = Integer.parseInt(splitedDate[0]);
            this.mes = Integer.parseInt(splitedDate[1]);
            this.dia = Integer.parseInt(splitedDate[2]);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    //Constructor con parametros
    public Fecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    public Fecha(String formattedDate) {
        String[] formattedDateString = formattedDate.split("-");
        this.dia = Integer.parseInt(formattedDateString[0]);
        this.mes = Integer.parseInt(formattedDateString[1]);
        this.año = Integer.parseInt(formattedDateString[2]);
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    //Método para comprobar si la fecha es correcta
    public boolean fechaCorrecta() {
        boolean diaCorrecto, mesCorrecto, añoCorrecto;
        añoCorrecto = año > 0;
        mesCorrecto = mes >= 1 && mes <= 12;
        switch (mes) {
            case 2:
                if (esBisiesto()) {
                    diaCorrecto = dia >= 1 && dia <= 29;
                } else {
                    diaCorrecto = dia >= 1 && dia <= 28;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                diaCorrecto = dia >= 1 && dia <= 30;
                break;
            default:
                diaCorrecto = dia >= 1 && dia <= 31;
        }
        
        return diaCorrecto && mesCorrecto && añoCorrecto;
    }

    public String compararFechaActual() {
        Calendar c1 = Calendar.getInstance();

        String dia = null;
        String mes = null;
        String año = null;
        if (c1.get(Calendar.DATE) <= 9) {
            dia = "0" + Integer.toString(c1.get(Calendar.DATE));
        } else {
            dia = Integer.toString(c1.get(Calendar.DATE));
        }

        if ((c1.get(Calendar.MONTH) + 1) <= 9) {
            mes = "0" + Integer.toString(c1.get(Calendar.MONTH) + 1);
        } else {
            mes = Integer.toString(c1.get(Calendar.MONTH) + 1);
        }

        año = Integer.toString(c1.get(Calendar.YEAR));

        //SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
        String date = dia + "-" + mes + "-" + año;
        return date;

    }

    public boolean esValidaFecha(String fechax) throws ParseException {
        String fechActual = compararFechaActual();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        try {
            formatoFecha.setLenient(false);
            formatoFecha.parse(fechax);
            if (formatoFecha.parse(fechax).equals(formatoFecha.parse(fechActual)) || formatoFecha.parse(fechax).before(formatoFecha.parse(fechActual))) {
                if (formatoFecha.parse(fechax).after(formatoFecha.parse("2000-01-01"))) {
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "El formato es AAAA-MM-DD");
                    return false;
                }

            } else {
                JOptionPane.showMessageDialog(null, "Formato de fecha no válido");
                return false;
            }
        } catch (ParseException e) {
            return false;

        }

    }

    //Método privado para comprobar si el año es bisiesto
    //Este método lo utiliza el método fechaCorrecta
    private boolean esBisiesto() {
        return (año % 4 == 0 && año % 100 != 0 || año % 400 == 0);
    }
    //Método que modifica la fecha cambiándola por la del día siguiente                                           

    public void diaSiguiente() {
        dia++;
        if (!fechaCorrecta()) {
            dia = 1;
            mes++;
            if (!fechaCorrecta()) {
                mes = 1;
                año++;
            }

        }
    }

    public String sumarDiasAFecha(String fecha, int dias) {
        if (dias == 0) {
            return fecha;
        }

        String[] f = fecha.split("-");
        Calendar calendar = Calendar.getInstance();
        //calendar.setTime(new Date(Integer.parseInt(f[0]), Integer.parseInt(f[1]), Integer.parseInt(f[2])));
        calendar.set(Integer.parseInt(f[0]), Integer.parseInt(f[1]) - 1, Integer.parseInt(f[2]));

        calendar.add(Calendar.DAY_OF_MONTH, dias);
        SimpleDateFormat fe = new SimpleDateFormat("YYYY-MM-dd");
        return fe.format(calendar.getTime());

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(año);
        sb.append("-");
        if (mes < 10) {
            sb.append("0");
        }
        sb.append(mes);
        sb.append("-");
        if (dia < 10) {
            sb.append("0");
        }
        sb.append(dia);
        return sb.toString();
    }

}
