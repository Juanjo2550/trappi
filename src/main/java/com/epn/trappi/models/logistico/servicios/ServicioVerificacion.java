/**
*** Clase para validar datos.
**/

package com.epn.trappi.models.logistico.servicios;


public class ServicioVerificacion 
{
	// TODO Auto-generated constructor stub


	public static String verificarCedula(String cedula)
	{
            // TODO Auto-generated method stub

            String strPatron = ("^[0-9]+$");
            int j, aux = 0, i;
            String error = "";
                
            if (cedula.equals(""))
		error = error + "Cédula: Campo vacío.\n";
            else
            {
		if (!(cedula.matches(strPatron)))
                    error += "Cédula: Caracteres no válidos.\n";
                
                if (cedula.length() != 10)
                    error += "Cêdula: Número de caracteres no válido.\n";
                else
                {
                    for (i = 0; i < 9; i = i + 2)
                    {
                        j = Integer.parseInt(String.valueOf(cedula.charAt(i)));
                        j = 2 * j;
                        if (j >= 10)
                            j = j - 9;
                        aux += j;
                    }
                    for (i = 1; i < 8; i = i + 2)
                    {
                        j = Integer.parseInt(String.valueOf(cedula.charAt(i)));
                        aux += j;
                    }
                    aux = -1 * aux;
                    while (aux < 0)
                        aux = aux + 10;

                    if (aux != Integer.parseInt(String.valueOf(cedula.charAt(9))))
                            error += "Cédula: Número de cédula no válida.\n";
                    }
                }
            return error;
        }
        
        public static String verificarRuc(String ruc)
        {
            String strPatron = ("^[0-9]+$");
            int j, aux = 0, i;
            String error = "";
                
            if (ruc.equals(""))
		error = error + "Ruc: Campo vacío.\n";
            else
            {
                if (!(ruc.matches(strPatron)))
                    error += "Ruc: Caracteres no válidos.\n";
                
                if (ruc.length() != 13)
                    error += "Ruc: Número de caracteres no válido.\n";
                else
                {
                    if (ruc.charAt(10)!='0')
                       error += "Ruc: Número de Ruc no válido.\n";
                    else if (ruc.charAt(11)!='0')
                        error += "Ruc: Número de Ruc no válido.\n";
                    else if (ruc.charAt(12)!='1')
                        error += "Ruc: Número de Ruc no válido.\n";
                }
            }
            return error;
        }

	public static String verificarNombre(String nombre)
	{
		// TODO Auto-generated method stub
		
		String error = "";
		String patron = ("^[a-zA-ZñÑÁÉÍÓÚáéíóú]*$");

		if (nombre.length() == 0)
			error += "Nombres: Campo vacío.\n";
		else
		{
			if (!nombre.matches(patron))
				error += "Nombres: Caracteres no válidos.\n";
			if (!(nombre.length() >= 3 && nombre.length() <= 80))
                            error = error + "Nombres: Número de caracteres fuera del rango.\n";
		}
		return error;
	}
        
        public static String verificarApellido(String nombre)
	{
		// TODO Auto-generated method stub
		
		String error = "";
		String patron = ("^[a-zA-ZñÑÁÉÍÓÚáéíóú ]*$");

		if (nombre.length() == 0)
			error += "Apellidos: Campo vacío.\n";
		else
		{
			if (!nombre.matches(patron))
				error += "Apellidos: Caracteres no válidos.\n";
			if (!(nombre.length() >= 3 && nombre.length() <= 80))
                            error = error + "Apellidos: Número de caracteres fuera del rango.\n";
		}
		return error;
	}
	
	public static String verificarTelefono(String telefono)
	{
		String error = "";
		String patron = ("^[0-9]+$");
                
		if (telefono.equals(""))
			error += "Teléfono: Campo vacio.\n";
		else
		{
			if (!(telefono.matches(patron)))
				error += "Teléfono: Caracteres no válidos\n";
			if (telefono.length()!= 7)
			{
                            if(telefono.length() != 9)
				error += "Teléfono: Número de caracteres no válido.\n";
			}
		}
		return error;
	}
        public static String verificarCelular(String telefono)
	{
		String error = "";
		String patron = ("^[0-9]+$");
                
		if (telefono.equals(""))
			error += "Celular: Campo vacio.\n";
		else
		{
			if (!(telefono.matches(patron)))
				error += "Celular: Caracteres no válidos\n";
                        if(!(telefono.length() == 10))
				error += "Celular: Número de caracteres no válido.\n";
		}
		return error;
	}
	
	public static String verificarDireccion(String direccion)
	{
		String error = "";
		String patron = ("^[a-zA-ZñÑÁÉÍÓÚáéíóú0-9 -.,]+$");

		if (direccion.equals(""))
                    error += "Dirección: Campo vacío.\n";
		else 
		{
			if (!(direccion.matches(patron)))
                            error += "Dirección: caracteres incorrectos.\n";
			if (!(direccion.length() >= 3 && direccion.length() <= 100))
                            error += "Dirección: Número de caracteres fuera del rango.\n";
		}
		return error;
	}
        
        public static String verificarCorreo(String correo)
	{
            String error = "";
            String patron = ("^(([^<>()\\[\\]\\\\.,;:\\s@”]+(\\.[^<>()\\[\\]\\\\.,;:\\s@”]+)*)|(“.+”))@((\\[[0–9]{1,3}\\.[0–9]{1,3}\\.[0–9]{1,3}\\.[0–9]{1,3}])|(([a-zA-Z\\-0–9]+\\.)+[a-zA-Z]{2,}))$");
            
            if(correo.equals(""))
                error += "Correo: Campo vacío.\n";
            else
                if (!(correo.matches(patron)))
                    error += "Correo: caracteres incorrectos.\n";
            return error;
        }
        public static String verificarRazonSocial(String direccion)
	{
		String error = "";
		String patron = ("^[a-zA-ZÁÉÍÓÚáéíóú0-9 -.,]+$");

		if (direccion.equals(""))
                    error += "Razón Social: Campo vacío.\n";
		else 
		{
			if (!(direccion.matches(patron)))
                            error += "Razón Social: Caracteres incorrectos.\n";
			if (!(direccion.length() >= 3 && direccion.length() <= 60))
                            error += "Razón Social: Número de caracteres fuera del rango.\n";
		}
		return error;
	}
        
        public static String verificarMatricula(String matricula)
	{
            boolean error1= true;
            String error = "";
            String patron = ("^[A-Z]{3}-[0-9]{3,4}$");
            
            if(matricula.equals(""))
                error += "Matricula: Campo vacío.\n";
            else
                if (!(matricula.matches(patron)))
                    error += "Matricula: caracteres incorrectos.\n";
            return error;
        }
        
        public static String verificarKilometraje(String telefono)
           {
                   String error = "";
                   String patron = ("^[0-9]{1,6}$");

                   if (telefono.equals(""))
                           error += "Kilometraje: Campo vacio.\n";
                   else
                   {
                           if (!(telefono.matches(patron))){
                                   error += "Kilometraje: Caracteres no válidos\n";
                                   error += "Hasta un kilometraje de 999999\n";
                           }
                   }
                   return error;
           }
        
}

