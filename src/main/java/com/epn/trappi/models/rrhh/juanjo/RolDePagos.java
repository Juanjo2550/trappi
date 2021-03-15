/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epn.trappi.models.rrhh.juanjo;
import com.epn.trappi.db.rrhh.RolDePagosDb;
import com.epn.trappi.gui.rrhh.Permisos.*;
import com.epn.trappi.models.logistico.ListaEntregas;
import com.epn.trappi.models.rrhh.Fecha;
import com.epn.trappi.db.rrhh.ObservacionDb;
import com.epn.trappi.db.rrhh.Permiso_EmpleadoDb;
import com.epn.trappi.models.rrhh.Hora;
import com.teamdev.jxbrowser.deps.org.checkerframework.checker.units.qual.A;


import java.sql.SQLException;
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
    private double bonos;

    /**
     * Este constructor no debe ser utilizado
     * @param numero
     * @param empleado
     * @param fecha
     * @param total
     * @param descuentos
     * @param estado
     */
    public RolDePagos(int numero, Empleado empleado, Fecha fecha, double total, double descuentos, String estado, double bonos) {
        this.numero = numero;
        this.empleado = empleado;
        this.fecha = fecha;
        this.total = total;
        this.descuentos = descuentos;
        this.estado = estado;
        this.bonos = bonos;
    }

    /**
     * Constructor usado para crear un nuevo Rol De Pagos
     * @param empleado
     * @param fecha
     * @param total
     * @param descuentos
     * @param estado
     */
    public RolDePagos(Empleado empleado, Fecha fecha) {
        this.empleado = empleado;
        this.fecha = fecha;
        this.calcularTotal();
    }

    public void registrar() {
        new RolDePagosDb().agregar(this);
    }

    private void calcularTotal() {
        Observacion[] observaciones = new ObservacionDb().obtenerTodos(this.empleado.getCedula(), this.fecha.getMes());
        if(observaciones.length == 0) {
            //No hay novedades relacionadas con este empleado
            System.out.println("No hay observaciones, descuentos = 0");
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
                    case "tiempoExtra":
                        observacionesPorHorasExtra.add(obs);
                    default:
                        observacionesPorAtraso.add(obs);
                        System.out.println("El tipo dentro de la observación tiene un error de sintaxis, clasificándola como atraso");
                }
            }
            double descuentosPorAtrasos = this.calcularAfectacionDeAtrasos(observacionesPorAtraso);
            double bonoPorFaltas = this.calcularAfectacionDeFaltas(observacionesPorFaltas);
            double bonoPorHorasExtra = this.calcularAfectacionDeHorasExtra(observacionesPorHorasExtra);
            double bonoPorEntregas = this.calcularBonoPorEntregas();
            this.descuentos = descuentosPorAtrasos;
            this.bonos = bonoPorFaltas + bonoPorHorasExtra + bonoPorEntregas;
            this.total = Double.parseDouble(this.empleado.getSueldo()) + this.bonos - this.descuentos;
        }
        this.estado = "pendiente";
    }

    private double calcularAfectacionDeAtrasos(ArrayList<Observacion> observaciones) {
        double descuentos = 0;
        for (Observacion obs : observaciones) {
            //El descuento es del 1% del sueldo por cada atraso, en caso de que el atraso sea menor de 3 horas
            if (obs.getHorasImplicadas().getHora() <= 3) {
                descuentos = descuentos + Double.parseDouble(this.empleado.getSueldo()) * 0.01;
            }
            //El descuento es del 2% del sueldo por cada atraso, en caso de que el atraso sea mayor de 3 horas
            if (obs.getHorasImplicadas().getHora() > 3) {
                descuentos = descuentos + Double.parseDouble(this.empleado.getSueldo()) * 0.02;
            }
        }
        return descuentos;
    }

    /**
     * Devuelve las recompensaciones por permisos solicitados
     * @param observaciones
     * @return
     */
    private double calcularAfectacionDeFaltas(ArrayList<Observacion> observaciones) {
        double descuentos = 0;
        double recompensacionPorFaltasJustificadas = 0;
        ArrayList<Permiso> permisosAConsiderar = new ArrayList<>();
        for (Observacion obs : observaciones) {
            try {
                Permiso permiso = new Permiso_EmpleadoDb().Permisos_para_ROL(obs.getEmpleado().getId(), obs.getFecha());
                if(permiso != null) {
                    if (!permisosAConsiderar.contains(permiso)) {
                        permisosAConsiderar.add(permiso);
                    }
                }
                descuentos += Double.parseDouble(obs.getEmpleado().getSueldo()) * 0.01;
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }

        for (Permiso per : permisosAConsiderar) {
            recompensacionPorFaltasJustificadas += Double.parseDouble(per.getVALORPAGARPERM());
        }

        return recompensacionPorFaltasJustificadas - descuentos;
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

    private double calcularBonoPorEntregas() {
        int bono = 0;
        try {
            int viajesPorConductor = ListaEntregas.numViajesPorConductor(this.fecha.getAño(), this.fecha.getMes(), this.getEmpleado().getId());
            if (viajesPorConductor >= 20) {
                bono = 50;
                new Observacion(this.empleado, "bono", "Bono por más de 20 entregas", this.fecha, new Hora()).agregar();
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return  bono;
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

    public int getNumero() {
        return numero;
    }

    public double getBonos() {
        return bonos;
    }
}
