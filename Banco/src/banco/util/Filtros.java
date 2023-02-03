package banco.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Conjunto de métodos para filtrar datos
 * de la aplicación
 * @author m.corchero.blazquez
 *
 */
public class Filtros {

	/**
	 * Nombres menor que veinte y mayor que 40
	 * Fecha enttre 3 y 5
	 * Texto entre 10 y 100
	 */
	
	public static boolean filtroTexto(String texto, int tamMax, int tamMin) {
		int tamTexto = texto.length();
		return ((tamTexto>=tamMin) && (tamTexto<=tamMax));
	}
	
	public static boolean filtroFechaAnio(LocalDate fecha, int max, int min) {
		if(fecha != null) {
			LocalDate fechaComprobacion = LocalDate.now();
			LocalDate fechaMin = fechaComprobacion.minusYears(min);
			LocalDate fechaMax = fechaComprobacion.plusYears(max);
			return ((fecha.isAfter(fechaMin)) && (fecha.isBefore(fechaMax)));	
		}else {
			return false;
		}			
	}
	
	/**
	 * Filtro de formato de fecha. Recibe una fecha y el formato, y pasa
	 * la fecha al formato indicado
	 */
	
	public static LocalDate fechaFormatoCorrecto(String fecha, String formato) {
		DateTimeFormatter miFormato = DateTimeFormatter.ofPattern(formato); //Creo un Formatter con el formato que me pasan
		LocalDate miFecha = null;
		try {
			miFecha = LocalDate.parse(fecha, miFormato); //miFecha tiene el resultado de la fecha que me pasan con el formato
			return miFecha; //devuelvo la fecha. Si no puedo realizar este bloque devolverá nulo
		}catch(DateTimeParseException dte) {}
		return miFecha;
	}
	
	
	public static LocalDate fechaFormatoCorrecto(String fecha) {
		return fechaFormatoCorrecto(fecha, "dd-MM-yyyy");
	}
	
	
	
	/**
	 * Comprueba si el saldo es positivo
	 * @param saldo
	 * @return verdadero o falso
	 */
	public static boolean esSaldoPositivo(double saldo) {
		return saldo > 0;
	}
	
	/**
	 * Comprueba dado el saldo de la cuenta y el que se desesa retirar
	 * si es posible realizar dicha operación
	 * @param retiro
	 * @param saldoActual
	 * @return verdadero si el saldo de la cuenta es mayor que el que se desea retirar
	 */
	public static boolean haySaldoSuficiente(double retiro, double saldoActual) {
		return saldoActual >= retiro;
	}
	

}
