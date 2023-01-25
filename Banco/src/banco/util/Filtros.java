package banco.util;

import java.time.LocalDate;

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
	
	public static boolean filtroFechaAnio(LocalDate fecha, int anioMax, int anioMin) {
		if( fecha != null) {
			return ((fecha.getYear()>=anioMin) && (fecha.getYear()<=anioMax));	
		}else {
			return false;
		}			
	}
}
