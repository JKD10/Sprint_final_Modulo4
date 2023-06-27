package sprintFinal2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Verificar {
	
	public static boolean verificarRut(int rut ) {


		String rutString = String.valueOf(rut); // Convertir el rut a una cadena
		String regex = "^[0-9]{1,8}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(rutString);

		return matcher.matches();
	}
	
	public static boolean verificarDia(String dia) {
		
		String regex = "^(lunes|martes|miércoles|jueves|viernes|sábado|domingo)$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(dia);
        return matcher.matches();
	}
	
	//verificamos y validamos que hora ingresada sea solo en hh:mm
	public static boolean verificarHora(String hora) {
		String regex = "^\\d{1,2}:\\d{2}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(hora);
		return matcher.matches();
		
	}
	
	//verificamos y validamos que sean solo numeros
	public static boolean verificarNumeros(int numero) {
		
		String numeroString = String.valueOf(numero);
		
		String regex = "^[0-9]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(numeroString);
		return matcher.matches();
		
		
	}
	
	public static boolean verificarNombre(String nombre) {
		return nombre.matches("^[a-zA-Z ]{10,50}$");
	}
	



}
