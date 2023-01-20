package ejercicio05;

/**
 * Clase que recibe una fecha e indica si esta es correcta.
 * @author m.corchero.blazquez
 * @version 1.2
 */
public class FiltroFecha {
	/**
	 * Método primera versión que asume meses de 30 días y comprueba si la fecha
	 * que recibe es correcta.
	 * @param dia
	 * @param mes
	 * @param anio
	 * @return true o false
	 */
	public static Boolean esCorrectoV1(int dia, int mes, int anio) {
		return ((dia>=1 && dia<=30) && (mes>=1 && mes<=12) && (anio>=0 && anio<=2023));
	}
	
	/**
	 * Método versión 2, que utiliza los días reales de cada mes.
	 * Devuelve true o false dependiendo de la fecha indicada
	 * @param dia
	 * @param mes
	 * @param anio
	 * @return true o false
	 */
	public static Boolean esCorrectoV2(int dia, int mes, int anio) {
		int dias = 0;
		switch(mes) {
		case 1, 3, 5, 7, 8, 10, 12:
			dias = 31;
			break;
		case 2: 
			dias = 28;
			break;
		case 4, 6, 9:
			dias = 30;
			break;
		default:
			System.out.println("ERROR");
		}
		return ((dia>=1 && dia<=dias) && (mes>=1 && mes<=12) && (anio>=0 && anio<=2023));
	}
	
	/**
	 * Método versión 3 que comprueba si una fecha es correcta
	 * utilizando arrays
	 * @param dia
	 * @param mes
	 * @param anio
	 * @return true o false
	 */
	public static Boolean esCorrectoV3(int dia, int mes, int anio) {
		int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int dias = diasMes[mes-1];
		return ((dia>=1 && dia<=dias) && (mes>=1 && mes<=12) && (anio>=0 && anio<=2023));	
	}
	
	/**
	 * Método versión 4 que comprueba si una fecha es correcta 
	 * teniendo en cuenta los años bisiestos
	 * @param dia
	 * @param mes
	 * @param anio
	 * @return true o false
	 */
	public static Boolean esCorrectoV4(int dia, int mes, int anio) {
		//Cualquier año divisible por 4 es un año bisiesto: 29 días
		int diasBisiesto = 28;
		if(mes == 2) {
			if(((anio % 4) == 0) && ((anio%100)!= 0)) {
				System.out.println("Es bisiesto");
				diasBisiesto = 29;
			}else {
				System.out.println("No es bisiesto");
			}
		}
		int[] diasMes = {31, diasBisiesto, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int dias = diasMes[mes-1];	
		return ((dia>=1 && dia<=dias) && (mes>=1 && mes<=12) && (anio>=0 && anio<=2023));	
	}
	
	/**
	 * Método principal que a partir de una fecha muestra en las diferentes
	 * versiones declaradas anteriormente, si es correcta o no 
	 * @param args
	 */
	public static void main(String[] args) {
		int dia = 31;
		int mes = 8;
		int anio = 2015;
		String separador = "**********";
		System.out.println("¿Es la fecha correcta?");
		
		//PRIMERA VERSION - ASMIENDO MESES DE 30 DIAS
		System.out.println(separador);
		System.out.println("Version 1");
		System.out.println(esCorrectoV1(dia, mes, anio));
		
		//SEGUNDA VERSION - DIAS REALES SIN ARRAYS
		System.out.println(separador);
		System.out.println("Version 2");
		System.out.println(esCorrectoV2(dia, mes, anio));
		
		//TERCERA VERSION - DIAS REALES CON ARRAYS
		System.out.println(separador);
		System.out.println("Version 3");
		System.out.println(esCorrectoV3(dia, mes, anio));
		
		//CUARTA VERSION - DIAS REALES CON BISIESTOS
		System.out.println(separador);
		System.out.println("Version 4");
		System.out.println(esCorrectoV4(dia, mes, anio));
	}

}
