/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.trappi.gui.rrhh.Permisos;

import com.epn.trappi.models.rrhh.Fecha;
import com.epn.trappi.models.rrhh.juanjo.Empleado;


/**
 *
 * @author stali
 */
public class Enfermedad extends Permiso {

    public Enfermedad(Empleado empleado, int NUMDIASPERM, String VALORPAGARPERM, String COMENTPERM, String FECHAINICIOPERM, String FECHAFINPERM, String ESTADOPERM) {
        super(empleado, NUMDIASPERM, VALORPAGARPERM, COMENTPERM, FECHAINICIOPERM, FECHAFINPERM, ESTADOPERM);
    }

    public Enfermedad() {
    }

    public Enfermedad(int NUMDIASPERM, String VALORPAGARPERM, String FECHAINICIOPERM, String FECHAFINPERM) {
        super(NUMDIASPERM, VALORPAGARPERM, FECHAINICIOPERM, FECHAFINPERM);
    }







 /*   @Override
    public int Calcular_Numero_Dias_Permiso(String tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/



    @Override
    public int calcularNumeroDias(String tipoPermiso, char sexo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
// valor a pagar por los dias de permiso de enfermedad de un empleado 
    @Override
    public String calcularProporcionalPagar(double sueldo, int numeroDias) {
        
        
        
        double diasSubsidiados = numeroDias-3;
         double contanteDistribucion= sueldo/30;
         double valorPagoPatrono=0;
         double valorSubsidiar1_3;
         double valorSubsidiar4_70;
         double valorSubsidiar71_182;
     // si los dias de permiso son menores que tres , el patrono paga el 50% 
        if (numeroDias>0 && numeroDias<=3){
           
           valorSubsidiar1_3  = contanteDistribucion * numeroDias;
            
             valorPagoPatrono = valorSubsidiar1_3 * 0.50;
  
        }
        
        
       //si los dias de permiso son entre 1 y 70 el patrono paga el 25 % 
        if (numeroDias>3 && numeroDias<=70 ){
              valorSubsidiar4_70 = (contanteDistribucion*diasSubsidiados)*0.25;
               valorSubsidiar1_3 = (contanteDistribucion*3)* 0.50;
             valorPagoPatrono = valorSubsidiar4_70 + valorSubsidiar1_3;
             
        }
        System.out.println();
  // si los dias de permiso son mas de 71 dias , se paga los tres primeros dias el 34%      
        if (numeroDias>70 && numeroDias<=182 ){
            int dias_3etapa = numeroDias - 70;
            int dias_2etapa = 67;

            valorSubsidiar71_182 = (contanteDistribucion*dias_3etapa)*0.34;
            System.out.println(valorSubsidiar71_182);
              valorSubsidiar4_70 = (contanteDistribucion*dias_2etapa)*0.25;
              System.out.println(valorSubsidiar4_70);
               valorSubsidiar1_3 = (contanteDistribucion * 3)*0.50;
               System.out.println(valorSubsidiar1_3);
              valorPagoPatrono = valorSubsidiar4_70 + valorSubsidiar1_3 + valorSubsidiar71_182;
              
        }
        System.out.println(valorPagoPatrono + "hola");
        return Double.toString(valorPagoPatrono)  ;
    }

}

