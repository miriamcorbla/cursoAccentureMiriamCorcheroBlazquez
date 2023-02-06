package bbdd.ficheros.util;

public class MontadorSQL {

	/**
	 * Completa SQL añadiendo el nombre del campo y su valor (si se le pasa)
	 * Pensado para inserts y updates
	 * @param salida
	 * @param nombreCampo
	 * @param valor
	 * @param separador
	 * @return devuelve string con valores añadidos
	 */
	
	public static String addSalida(String salida, String nombreCampo, int valor, String separador) {
		return addSalidaSencilla(salida, nombreCampo, "" + valor, separador);
	}
	
	public static String addSalida(String salida, String nombreCampo, double valor, String separador) {
		return addSalidaSencilla(salida, nombreCampo, "" + valor, separador);
	}
	
	public static String addSalida(String salida, String nombreCampo, long valor, String separador) {
		return addSalidaSencilla(salida, nombreCampo, "" + valor, separador);	
	}
	
	public static String addSalida(String salida, String nombreCampo, String valor, String separador) {
		return addSalidaSencilla(salida, nombreCampo, "'" + valor + "'", separador);	
	}
	
	/**
	 * Recibe string parcialmente construida y que tiene que completar.
	 * El nombre se añade si no es nulo.
	 * El = solo si se ha añadido el campo
	 * luego, se añade el valor 
	 * @param salida
	 * @param nombreCampo
	 * @param valor
	 * @param separador
	 * @return
	 */
	public static String addSalidaSencilla(String salida, String nombreCampo, String valor, String separador) {
		/*
		 * salida, "", "BR", "," -> country_id = 'BR',
		 * salida, "country_name", "Brasil", "," -> country_name = 'Brasil'
		 */
		StringBuilder sentenciaSQL = new StringBuilder();
		if(salida != null && !salida.isEmpty() ) {
			sentenciaSQL.append(salida + " ");
			if(nombreCampo != null && !nombreCampo.isEmpty()) {
				sentenciaSQL.append(nombreCampo + " = " + valor + separador);
			}else {
				sentenciaSQL.append(valor + separador);
			}
		}else {
			if(nombreCampo != null && !nombreCampo.isEmpty()) {
				sentenciaSQL.append(nombreCampo + " = " + valor + separador);
			}else {
				sentenciaSQL.append(valor + separador);
			}
		}
		return sentenciaSQL.toString();
	}
}
