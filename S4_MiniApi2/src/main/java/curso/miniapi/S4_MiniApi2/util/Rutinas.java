package curso.miniapi.S4_MiniApi2.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Rutinas {
	
	public static String mensajes(String mensaje, String[] datos){
		String salida="";
		int contador=0;
		for (int a = 0; a < mensaje.length();a++){
			if (mensaje.charAt(a)=='?'){
				if (contador<=datos.length)
					salida +=datos[contador++];
				else
					salida +="?" + contador++ + "?";
			}
			else
				salida += mensaje.charAt(a);
		}
		
		return salida;
	}
	public static Calendar convierteACalendar(String fecha){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(sdf.parse(fecha));
		} catch (ParseException e) {
			return null;
		}
		return calendar;
	}
	public static String convierteAString(Calendar fecha){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");		
		return sdf.format(fecha.getTime());
	}
	
	public static String addCampo(String salida, String nombreCampo, double valor, String separador){
		if (valor>0){
			salida= Rutinas.addSalidaSencilla(salida, nombreCampo, "" + (int)valor, separador);
		}
		return salida;
	}
	public static String addCampo(String salida, String nombreCampo, String valor, String separador){
		if ( valor !=null &&  valor.compareTo("")!=0 ){
			salida= Rutinas.addSalidaSencilla(salida,nombreCampo,"'" + valor + "'", separador);
		}
		return salida;
	}
	
	/**
	 * Completa SQL A�adiendo el nombre del campo y su valor (sis e pasa)
	 * Pensado para INSERT y UPDATES
	 * @param salida
	 * @param nombreCampo
	 * @param valor
	 * @param separador
	 * @return Devuelve una string con los valores a�adidos
	 */
	public static String addSalida(String salida,String nombreCampo, int valor, String separador){
		return addSalidaSencilla( salida, nombreCampo,  ""+valor,  separador);
	}
	public static String addSalida(String salida,String nombreCampo, double valor, String separador){
		return addSalidaSencilla( salida, nombreCampo,  ""+valor,  separador);
	}
	public static String addSalida(String salida,String nombreCampo, long valor, String separador){
		return addSalidaSencilla( salida, nombreCampo,  ""+valor,  separador);
	}
	public static String addSalida(String salida,String nombreCampo, String valor, String separador){
		return addSalidaSencilla( salida, nombreCampo, "'"+ valor + "'",  separador);
	}	
	/**
	 * Recibe una String parcialmente construida y que tiene que completar, 	
	 * El nombre del campo se a�ade solo si no es nulo
	 * A continuacion del nombre del campo, se a�ade un signo "=" solo si se ha a�adido nombre del campo
	 * a continuacion se a�ade el valor recibido
	 * 
	 * @param salida		: Parte de la string ya construida
	 * @param nombreCampo   : Nombre del campo que se va a a�adir
	 * @param valor         : Valor del campo
	 * @param separador		: Separador que se tiene que a�adir entre campos
	 * @return				: String que recibimos parcialmente construida a la que le hemos a�adido el nuevo campo
	 */
	public static String addSalidaSencilla(String salida,String nombreCampo, String valor, String separador){	
		if (salida.length()>0)
				salida += " " + separador + " ";
		if (nombreCampo!=null && nombreCampo.compareTo("")>0)
			salida +=nombreCampo + " = " ;
		salida += valor;
		return salida;
	}
	
	
	
	
	
	
}
