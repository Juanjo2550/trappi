
package com.epn.trappi.models.financiero;

import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class Analizador {

    
    LibroDiario librodiario;
    Fecha fechaDesde=new Fecha();
    Fecha fechaHasta=new Fecha();

    public Analizador() {
    }
    
    public Analizador(LibroDiario librodiario) {
        this.librodiario = librodiario;
    }
    
    public double[] calcularIngresosporIntervalodeMeses(){
        this.librodiario=new LibroDiario();
        double[] ingresosporIntervalo = new double[5];
        
        for(int i=0;i<5;i++){
            int acumulador=0;
            int variableaux = 1; 
            for(Ingreso ingreso: this.librodiario.obtenerIngresosRegistrados()){
                if(this.calcularIntervaloMensualInt()[i]>calcularIntervaloMensualInt()[variableaux]){
                    if(ingreso.fechaIngreso.devolverMes()==this.calcularIntervaloMensualInt()[i]&&ingreso.fechaIngreso.devolverAnio()==this.fechaHasta.devolverAnio()-1){
                        acumulador+=ingreso.total;
                    }
                }
                if(variableaux==4){
                    if(ingreso.fechaIngreso.devolverMes()==this.calcularIntervaloMensualInt()[i]&&ingreso.fechaIngreso.devolverAnio()==this.fechaHasta.devolverAnio()-1){
                        acumulador+=ingreso.total;
                    }
                }
                if(this.calcularIntervaloMensualInt()[i]<this.calcularIntervaloMensualInt()[variableaux]){
                    if(ingreso.fechaIngreso.devolverMes()==this.calcularIntervaloMensualInt()[i]&&ingreso.fechaIngreso.devolverAnio()==this.fechaHasta.devolverAnio()){
                        acumulador+=ingreso.total;
                    }
                }
                
            }
            if(variableaux!=4){
                variableaux++;
            }
            ingresosporIntervalo[i]=acumulador;
        }
        for(int i=0;i<5;i++){
            System.out.println("Ingreso:"+ingresosporIntervalo[i]+" Mes:"+this.calcularIntervaloMensualString()[i]);
        }
        return ingresosporIntervalo;
    }
    public double[] calcularPagosporIntervalodeMeses(){
        this.librodiario=new LibroDiario();
        double[] pagosporIntervalo = new double[5];
        
        for(int i=0;i<5;i++){
            int acumulador=0;
            int variableaux = 1; 
            for(Pago pago: this.librodiario.obtenerPagosRegistrados()){
                if(this.calcularIntervaloMensualInt()[i]>calcularIntervaloMensualInt()[variableaux]){
                    if(pago.fechadePago.devolverMes()==this.calcularIntervaloMensualInt()[i]&&pago.fechadePago.devolverAnio()==this.fechaHasta.devolverAnio()-1){
                        acumulador+=pago.monto;
                    }
                }
                if(variableaux==4){
                    if(pago.fechadePago.devolverMes()==this.calcularIntervaloMensualInt()[i]&&pago.fechadePago.devolverAnio()==this.fechaHasta.devolverAnio()-1){
                        acumulador+=pago.monto;
                    }
                }
                if(this.calcularIntervaloMensualInt()[i]<this.calcularIntervaloMensualInt()[variableaux]){
                    if(pago.fechadePago.devolverMes()==this.calcularIntervaloMensualInt()[i]&&pago.fechadePago.devolverAnio()==this.fechaHasta.devolverAnio()){
                        acumulador+=pago.monto;
                    }
                }
                
            }
            if(variableaux!=4){
                variableaux++;
            }
            pagosporIntervalo[i]=acumulador;
        }
        for(int i=0;i<5;i++){
            System.out.println("Ingreso:"+pagosporIntervalo[i]+" Mes:"+this.calcularIntervaloMensualString()[i]);
        }
        return pagosporIntervalo;
    }
    public double[] calcularDevolucionesPorIntervaloDeMeses(){
        this.librodiario=new LibroDiario();
        double[] devoluciones = new double[5];
        
        for(int i=0;i<5;i++){
            int acumulador=0;
            int variableaux = 1; 
            for(Devolucion devolucion: this.librodiario.obtenerDevolucionesRegistradas()){
                if(this.calcularIntervaloMensualInt()[i]>calcularIntervaloMensualInt()[variableaux]){
                    if(devolucion.fechaDeDevolucion.devolverMes()==this.calcularIntervaloMensualInt()[i]&&devolucion.fechaDeDevolucion.devolverAnio()==this.fechaHasta.devolverAnio()-1){
                        acumulador+=devolucion.valorDevolucion;
                    }
                }
                if(variableaux==4){
                    if(devolucion.fechaDeDevolucion.devolverMes()==this.calcularIntervaloMensualInt()[i]&&devolucion.fechaDeDevolucion.devolverAnio()==this.fechaHasta.devolverAnio()-1){
                        acumulador+=devolucion.valorDevolucion;
                    }
                }
                if(this.calcularIntervaloMensualInt()[i]<this.calcularIntervaloMensualInt()[variableaux]){
                    if(devolucion.fechaDeDevolucion.devolverMes()==this.calcularIntervaloMensualInt()[i]&&devolucion.fechaDeDevolucion.devolverAnio()==this.fechaHasta.devolverAnio()){
                        acumulador+=devolucion.valorDevolucion;
                    }
                }
                
            }
            if(variableaux!=4){
                variableaux++;
            }
            devoluciones[i]=acumulador;
        }
        for(int i=0;i<5;i++){
            System.out.println("Ingreso:"+devoluciones[i]+" Mes:"+this.calcularIntervaloMensualString()[i]);
        }
        return devoluciones;
    }
    public int[] calcularIntervaloMensualInt(){
        int[] mesesdeIntervalo= new int[5];
        int[] mesedelAnio={1, 2, 3,4,5,6,7,8,9,10,11,12};
        this.fechaHasta=new Fecha(1,3,2021);
        if(fechaHasta.devolverMes()>=7){
        this.fechaDesde=new Fecha(1,fechaHasta.devolverMes()-6,fechaHasta.devolverAnio());
        for(int i=0;i<5;i++){
            mesesdeIntervalo[i]=mesedelAnio[i+fechaDesde.devolverMes()];
            System.out.println("Mes:"+mesesdeIntervalo[i]);
        }
        }
        if(fechaHasta.devolverMes()<7){
            int[] mesesresiduos={-1,-2,-3,-4,-5};
            if(fechaHasta.devolverMes()==6){
                fechaDesde=new Fecha(1,fechaHasta.devolverMes()-6,fechaHasta.devolverAnio());
                for(int i=fechaDesde.devolverMes();i<fechaHasta.devolverMes()-1;i++){
                    mesesdeIntervalo[i]=mesedelAnio[i];
                    System.out.println("Mes:"+mesesdeIntervalo[i]);
                }
                return mesesdeIntervalo;
            }
            switch(fechaHasta.devolverMes()){
                case 1:
                    mesesdeIntervalo[0]=8;
                    mesesdeIntervalo[1]=9;
                    mesesdeIntervalo[2]=10;
                    mesesdeIntervalo[3]=11;
                    mesesdeIntervalo[4]=12;
                    break;
                case 2:
                    mesesdeIntervalo[0]=9;
                    mesesdeIntervalo[1]=10;
                    mesesdeIntervalo[2]=11;
                    mesesdeIntervalo[3]=12;
                    mesesdeIntervalo[4]=1;
                    break;
                case 3:
                    mesesdeIntervalo[0]=10;
                    mesesdeIntervalo[1]=11;
                    mesesdeIntervalo[2]=12;
                    mesesdeIntervalo[3]=1;
                    mesesdeIntervalo[4]=2;
                    break;
                case 4:
                    mesesdeIntervalo[0]=11;
                    mesesdeIntervalo[1]=12;
                    mesesdeIntervalo[2]=1;
                    mesesdeIntervalo[3]=2;
                    mesesdeIntervalo[4]=3;
                    break;
                case 5:
                    mesesdeIntervalo[0]=12;
                    mesesdeIntervalo[1]=1;
                    mesesdeIntervalo[2]=2;
                    mesesdeIntervalo[3]=3;
                    mesesdeIntervalo[4]=4;
                    break;
                default:
                    break;
            }
            for(int i=0;i<5;i++){
                System.out.println("Mes:"+mesesdeIntervalo[i]);
            }
            return mesesdeIntervalo;
        }
        return mesesdeIntervalo;
    }
    public String[] calcularIntervaloMensualString(){
        String[] mesesdeIntervalo= new String[5];
        String[] mesedelAnio={"Enero", "Febrero", "Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        this.fechaHasta=new Fecha(1,3,2021);
        if(fechaHasta.devolverMes()>=7){
        this.fechaDesde=new Fecha(1,fechaHasta.devolverMes()-6,fechaHasta.devolverAnio());
        for(int i=0;i<5;i++){
            mesesdeIntervalo[i]=mesedelAnio[i+fechaDesde.devolverMes()];
            System.out.println("Mes:"+mesesdeIntervalo[i]);
        }
        }
        if(fechaHasta.devolverMes()<7){
            int[] mesesresiduos={-1,-2,-3,-4,-5};
            String[] mesesCorrespondientes={"Diciembre","Noviembre","Octubre","Septiembre","Agosto"};
            if(fechaHasta.devolverMes()==6){
                fechaDesde=new Fecha(1,fechaHasta.devolverMes()-6,fechaHasta.devolverAnio());
                for(int i=fechaDesde.devolverMes();i<fechaHasta.devolverMes()-1;i++){
                    mesesdeIntervalo[i]=mesedelAnio[i];
                    System.out.println("Mes:"+mesesdeIntervalo[i]);
                }
                return mesesdeIntervalo;
            }
            switch(fechaHasta.devolverMes()){
                case 1:
                    mesesdeIntervalo[0]="Agosto";
                    mesesdeIntervalo[1]="Septiembre";
                    mesesdeIntervalo[2]="Octubre";
                    mesesdeIntervalo[3]="Noviembre";
                    mesesdeIntervalo[4]="Diciembre";
                    break;
                case 2:
                    mesesdeIntervalo[0]="Septiembre";
                    mesesdeIntervalo[1]="Octubre";
                    mesesdeIntervalo[2]="Noviembre";
                    mesesdeIntervalo[3]="Diciembre";
                    mesesdeIntervalo[4]="Enero";
                    break;
                case 3:
                    mesesdeIntervalo[0]="Octubre";
                    mesesdeIntervalo[1]="Noviembre";
                    mesesdeIntervalo[2]="Diciembre";
                    mesesdeIntervalo[3]="Enero";
                    mesesdeIntervalo[4]="Febrero";
                    break;
                case 4:
                    mesesdeIntervalo[0]="Noviembre";
                    mesesdeIntervalo[1]="Diciembre";
                    mesesdeIntervalo[2]="Enero";
                    mesesdeIntervalo[3]="Febrero";
                    mesesdeIntervalo[4]="Marzo";
                    break;
                case 5:
                    mesesdeIntervalo[0]="Diciembre";
                    mesesdeIntervalo[1]="Enero";
                    mesesdeIntervalo[2]="Febrero";
                    mesesdeIntervalo[3]="Marzo";
                    mesesdeIntervalo[4]="Abril";
                    break;
                default:
                    break;
            }
            for(int i=0;i<5;i++){
                System.out.println("Mes:"+mesesdeIntervalo[i]);
            }
            return mesesdeIntervalo;
        }
        return mesesdeIntervalo;
    }
    
    public ArrayList<Ingreso> buscarIngresosPorFecha(int dia, int mes, int anio){
        ArrayList<Ingreso> ingresosPorFecha = new ArrayList<Ingreso>();
        this.librodiario=new LibroDiario();
        this.librodiario.ingresosRegistrados = this.librodiario.obtenerIngresosRegistrados();
        for(Ingreso ingreso : this.librodiario.ingresosRegistrados){
            if(ingreso.fechaIngreso.devolverDia()==dia && ingreso.fechaIngreso.devolverMes()==mes && ingreso.fechaIngreso.devolverAnio()==anio){
                ingresosPorFecha.add(ingreso);
            }
        }
        if(ingresosPorFecha.isEmpty()){
            ingresosPorFecha=this.librodiario.ingresosRegistrados;
            JOptionPane.showMessageDialog(null, "No se encontraron ingresos en la fecha determinada.","Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
      return ingresosPorFecha;
    }
    public ArrayList<Pago> buscarPagosPorFecha(int dia, int mes, int anio){
        ArrayList<Pago> pagosPorFecha = new ArrayList<Pago>();
        this.librodiario=new LibroDiario();
        this.librodiario.pagosRegistrados = this.librodiario.obtenerPagosRegistrados();
        for(Pago pago : this.librodiario.pagosRegistrados){
            if(pago.fechadePago.devolverDia()==dia && pago.fechadePago.devolverMes()==mes && pago.fechadePago.devolverAnio()==anio){
                pagosPorFecha.add(pago);
            }
        }
        if(pagosPorFecha.isEmpty()){
            pagosPorFecha=this.librodiario.pagosRegistrados;
            JOptionPane.showMessageDialog(null, "No se encotraron pagos en la fecha determinada.","Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
      return pagosPorFecha;
    }
    public ArrayList<Devolucion> buscarDevolucionesPorFecha(int dia, int mes, int anio){
        ArrayList<Devolucion> devolucionesPorFecha = new ArrayList<Devolucion>();
        this.librodiario=new LibroDiario();
        this.librodiario.devolucionesRegistradas = this.librodiario.obtenerDevolucionesRegistradas();
        for(Devolucion devolucion : this.librodiario.obtenerDevolucionesRegistradas()){
            if(devolucion.fechaDeDevolucion.devolverDia()==dia && devolucion.fechaDeDevolucion.devolverMes()==mes && devolucion.fechaDeDevolucion.devolverAnio()==anio){
                devolucionesPorFecha.add(devolucion);
            }
        }
        if(devolucionesPorFecha.isEmpty()){
            devolucionesPorFecha=this.librodiario.devolucionesRegistradas;
            JOptionPane.showMessageDialog(null, "No se encotraron pagos en la fecha determinada.","Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
      return devolucionesPorFecha;
    }
    public LibroDiario getLibrodiario() {
        return librodiario;
    }
    

    
}