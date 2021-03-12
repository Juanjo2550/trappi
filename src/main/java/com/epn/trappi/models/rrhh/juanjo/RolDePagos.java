/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epn.trappi.models.rrhh.juanjo;
import com.epn.trappi.gui.rrhh.Permisos.Permiso;
import com.epn.trappi.models.rrhh.Fecha;
import com.epn.trappi.db.rrhh.ObservacionDb;
import com.epn.trappi.db.rrhh.Permiso_EmpleadoDb;


import java.util.ArrayList;

/**
 * 
 * @author Juan Jaramillo <juanjodev02 at juan.jaramillo02@epn.edu.ec>
 */
public class RolDePagos {
    private int numero;
    private Empleado empleado;
    private Fecha fecha;
    private double total;
    private double descuentos;
    private String estado;

    /**
     * Este constructor no debe ser utilizado
     * @param numero
     * @param empleado
     * @param fecha
     * @param total
     * @param descuentos
     * @param estado
     */
    public RolDePagos(int numero, Empleado empleado, Fecha fecha, double total, double descuentos, String estado) {
        this.numero = numero;
        this.empleado = empleado;
        this.fecha = fecha;
        this.total = total;
        this.descuentos = descuentos;
        this.estado = estado;
    }

    /**
     * Constructor usado para crear un nuevo Rol De Pagos
     * @param empleado
     * @param fecha
     * @param total
     * @param descuentos
     * @param estado
     */
    public RolDePagos(Empleado empleado, Fecha fecha) throws Exception {
        this.empleado = empleado;
        this.fecha = fecha;
        this.calcularTotal();
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public double getTotal() {
        return total;
    }

    public double getDescuentos() {
        return descuentos;
    }

    public String getEstado() {
        return estado;
    }

    private void calcularTotal() throws Exception {
        Observacion[] observaciones = this.obtenerObservaciones();
        if(observaciones.length == 0) {
            //No hay novedades relacionadas con este empleado
            this.total = Double.parseDouble(this.empleado.getSueldo());
            this.descuentos = 0;
        }
        else {
            //Hay novedades relacionadas con este empleado
            ArrayList<Observacion> observacionesPorAtraso = new ArrayList<>();
            ArrayList<Observacion> observacionesPorFaltas = new ArrayList<>();
            ArrayList<Observacion> observacionesPorHorasExtra= new ArrayList<>();

            for (Observacion obs : observaciones) {
                switch (obs.getTipo()) {
                    case "atraso":
                        observacionesPorAtraso.add(obs);
                    case "falta":
                        observacionesPorFaltas.add(obs);
                    case "horasExtra":
                        observacionesPorHorasExtra.add(obs);
                    default:
                        observacionesPorAtraso.add(obs);
                        System.out.println("El tipo dentro de la observacion tiene un error de sintaxis");
                }
            }
            double descuentosPorAtrasos = this.calcularAfectacionDeAtrasos(observacionesPorAtraso);
            double descuentosPorFaltas = this.calcularAfectacionDeFaltas(observacionesPorFaltas);
            double bonoPorHorasExtra = this.calcularAfectacionDeHorasExtra(observacionesPorHorasExtra);
//            double bonoPorPermisos = this.calcularBonoPorPermisos(this.empleado.getCedula());

            this.descuentos = descuentosPorAtrasos + descuentosPorFaltas;
            this.total = Double.parseDouble(this.empleado.getSueldo()) + bonoPorHorasExtra - descuentosPorAtrasos; //+ bonoPorPermisos;
        }
        this.estado = "pendiente";
    }

    private double calcularAfectacionDeAtrasos(ArrayList<Observacion> observaciones) {
        double descuentos = 0;
        for (Observacion obs : observaciones) {
            if (obs.getHorasImplicadas().getHora() <= 3) {
                descuentos = descuentos + Double.parseDouble(this.empleado.getSueldo()) * 0.01;
            }

            if (obs.getHorasImplicadas().getHora() > 3) {
                descuentos = descuentos + Double.parseDouble(this.empleado.getSueldo()) * 0.02;
            }
        }
        return descuentos;
    }

    private double calcularAfectacionDeFaltas(ArrayList<Observacion> observaciones) {
        double descuentos = 0;
        for (Observacion obs : observaciones) {
            descuentos = descuentos + Double.parseDouble(this.empleado.getSueldo()) * 0.03;
        }
        return descuentos;
    }

    private double calcularAfectacionDeHorasExtra(ArrayList<Observacion> observaciones) {
        double descuentos = 0;
        for (Observacion obs : observaciones) {
            if (obs.getHorasImplicadas().getHora() <= 3) {
                descuentos = descuentos + Double.parseDouble(this.empleado.getSueldo()) * 0.02;
            }

            if (obs.getHorasImplicadas().getHora() > 3) {
                descuentos = descuentos + Double.parseDouble(this.empleado.getSueldo()) * 0.03;
            }
        }
        return descuentos;
    }

    private double calcularReposicionPorPermisos(String cedula) {
        Permiso_EmpleadoDb listaPermisos = new Permiso_EmpleadoDb();
        
        Permiso[] permisos = listaPermisos.obtenerTodos();
        double total = 0;
        for(Permiso per : permisos) {
            if(per.getEmpleado().getCedula().equals(cedula)){
                int initialUnformattedDate = Integer.parseInt(per.getFECHAINICIOPERM().split("-")[1]);
                int finalUnformattedDate = Integer.parseInt(per.getFECHAFINPERM().split("-")[1]);
                if (initialUnformattedDate <= this.fecha.getMes() && this.fecha.getMes() <= finalUnformattedDate) {
                    total = total +  Integer.parseInt(per.getVALORPAGARPERM());
                }
            }
        }
        return total;
    }

    private Observacion[] obtenerObservaciones () throws Exception {
        return new ObservacionDb().obtenerTodos(this.empleado.getCedula(), this.fecha.getMes());
    }


    public int getNumero() {
        return numero;
    }

}
