/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epn.trappi.gui.rrhh.Permisos;

import com.epn.trappi.models.rrhh.juanjo.Empleado;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Nacimiento_Hijo extends Permiso {

    public Nacimiento_Hijo(Empleado empleado, int NUMDIASPERM, String VALORPAGARPERM, String COMENTPERM, String FECHAINICIOPERM, String FECHAFINPERM, String ESTADOPERM) {
        super(empleado, NUMDIASPERM, VALORPAGARPERM, COMENTPERM, FECHAINICIOPERM, FECHAFINPERM, ESTADOPERM);
    }

    public Nacimiento_Hijo() {
    }

    public Nacimiento_Hijo(int NUMDIASPERM, String VALORPAGARPERM, String FECHAINICIOPERM, String FECHAFINPERM) {
        super(NUMDIASPERM, VALORPAGARPERM, FECHAINICIOPERM, FECHAFINPERM);
    }
    
    
    

    @Override
    public int calcularNumeroDias(String tipoPermiso, char sexo) {
                int numeroDias = NUMDIASPERM;
        //this.tipoPermiso = TipoPermiso;
        System.out.println(sexo);
         if("Nacimiento Hijo (Parto Normal)".equals(tipoPermiso) ){
             
             
             if ("M".equalsIgnoreCase(String.valueOf(sexo) )){
                 numeroDias = 10;
             }
             else if ("F".equalsIgnoreCase(String.valueOf(sexo) )){
                 numeroDias = 90;
             }
           
        }
         if("Nacimiento Multiple o Parto Cesarea".equals(tipoPermiso)){
           if ("M".equalsIgnoreCase(String.valueOf(sexo) )){
                 numeroDias = 15;
             }
           else if("F".equalsIgnoreCase(String.valueOf(sexo) )){
                 numeroDias = 90;
             }
        }
        if("Nacimiento Prematuro".equals(tipoPermiso)){
           numeroDias = 23;
        }
        if("Nacimiento con enfermedad degenerativa".equals(tipoPermiso)){
            numeroDias = 25;
        }
        
        return numeroDias;
    }

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
        return Double.toString(valorPagoPatrono);
    }
    
}
