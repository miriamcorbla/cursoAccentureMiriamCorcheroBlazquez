package es.rf.tienda.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/********************************************************************************************
 * NOMBRE: Validator.java
 * 
 * DESCRIPCION: Clase auxiliar para validar los datos que sean introducidos en
 * la aplicación.
 * 
 * @version 30/01/2023
 * @author m.corchero.blazquez
 * 
 ******************************************************************************************/
public class Validator {

	private static final String ALFANUMERIC_PATTERN = "^[0-9a-zA-Z]+$";
	
	private static final String CODE_PATTERN = "[A-Z]{2}+\\d{3}";

	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
	/**
	 * Patrón para validar el email, evitando puntos finales antes de la @ y que
	 * solo contenga caracteres alfanuméricos
	 */
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	/**
	 * Permite verificar que un DNI cumple con el patr�n XX.XXX.XXX-L
	 */
	private static final String DNI_PATTERN = "\\d{2}\\.\\d{3}\\.\\d{3}-[a-zA-Z]";

	/**
	 * Permite validar un teléfono, el cual debe contener de 10 a 20 dígitos y donde
	 * los espacios están permitidos
	 */
	private static final String PHONE_PATTERN = "[\\d]{10,20}";

	/**
	 * Orden de las letras con las cuales se comprobará la validez del DNI
	 */
	private static final String LETRA_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";
	
	private static final String FECHA_PATTERN = "^([0-2][0-9])(\\/)(0[1-9]|1[0-2])\\2(\\d{4})$";

	/**
	 * Longitud que debe tener los DNI pasado a la aplicación.
	 */
	private static final int LONGITUD_DNI = 12;
	
	public static boolean isVacio(String prueba) {
		return prueba == null || prueba.isEmpty();
	}

	/**
	 * ***************************************************************************************
	 * NOMBRE: isAlfanumeric *
	 * 
	 * DESCRIPCIÓN:
	 * Permite verificar que el texto pasado solo contiene caracters alfanuméricos
	 * 
	 * @param texto String a verificar que solo tenga caracteres alfanuméricos
	 * 
	 * @return true, si cumple solo contiene caracteres alfanuméricos. <br>
	 *         false en caso contrario
	 * 
	 *         FECHA: Enero 2023
	 * 
	 * @author m.corchero.blazquez
	 * 
	 **************************************************************************************/
	public static boolean isAlfanumeric(String texto) {
		boolean esAlfanumerico = false;
		if (texto != null) { // si no recibo un texto vacio
			esAlfanumerico = texto.chars().allMatch(Character::isLetterOrDigit); // uso streams para calcularlo mas facilmente en lugar de con un for y un if
		}
		return esAlfanumerico; // devuelvo true si es alfanumerico, o false si no lo es
	}
	
	/**
	 * ***************************************************************************************
	 * NOMBRE: cumpleCodigoProducto *
	 * 
	 * DESCRIPCIÓN:
	 * Permite verificar que el texto pasado cumple con el código de producto
	 * 
	 * @param texto String a verificar que solo tenga 2letras+3numeros
	 * 
	 * @return true, si cumple solo que solo tiene 2letras+3numeros
	 *         false en caso contrario
	 * 
	 *         FECHA: Enero 2023
	 * 
	 * @author m.corchero.blazquez
	 * 
	 **************************************************************************************/
	
	public static boolean cumpleCodigoProducto(String texto) {
		return !isVacio(texto) && texto.matches(CODE_PATTERN);
	}

	/**
	 * ***************************************************************************************
	 * NOMBRE: cumplePhoneNumber *
	 * 
	 * DESCRIPCIÓN:
	 */
	/**
	 * El phone number debe tener un total de entre 10 y 20, contando dígitos y
	 * espacios. Mínimo aceptable son 10 dígitos.
	 * 
	 * @param phoneNumber String con el número de telefono de entre 10 y 20 dígitos.
	 *                    Puede tener espacios, pero siempre con 10 dígitos como
	 *                    mínimo.
	 * 
	 * @return true, si cumple todas las condiciones
	 *
	 *         FECHA: Enero 2023
	 * @author m.corchero.blazquez
	 * 
	 **************************************************************************************/
	public static boolean cumplePhoneNumber(String phoneNumber) {
		if(isVacio(phoneNumber)) {
			return false;
		}
		long numDigitos = phoneNumber.chars().filter(n -> Character.isDigit(n)).count();
		if(!cumpleRango(numDigitos, 10, 20)){
			return false;
		}
		if(cumpleLongitud(phoneNumber, 10, 20)) { //si cumple longitud
			for(int i = 0; i<phoneNumber.length(); i++) { //vemos si los caracteres no son espacios en blanco o digitos
				if(!(Character.isWhitespace(phoneNumber.charAt(i)) || Character.isDigit(phoneNumber.charAt(i)))) {
					return false;
				}
			}
		}else {
			return false;
		}
		return true;
	}

	/**
	 * ***************************************************************************************
	 * NOMBRE: isEmailValido *
	 * 
	 * DESCRIPCIÓN:
	 */
	/**
	 * Comprueba si el email tiene un formato que pueda ser válido. *Debe contener
	 * una y solo una "@" *debe tener la estructura: texto1@texto2.tld *texto1 y
	 * texto2 solo pueden tener numeros, letras y -_ *tener como minimo un caracter
	 * *texto2 acaba en un . y como minimo 2 letras
	 * 
	 * @param email String a comprobar
	 * 
	 * @return true, en caso que el formato sea válido FECHA: Enero 2023
	 * 
	 * @author m.corchero.blazquez
	 * 
	 **************************************************************************************/
	public static boolean isEmailValido(String email) {
		return !isVacio(email) && email.matches(EMAIL_PATTERN);
	}

	/**
	 * ***************************************************************************************
	 * NOMBRE: cumpleDNI *
	 * 
	 * DESCRIPCIÓN:
	 */
	/**
	 * Esta función verifica que el DNI cumple el siguiente formato: xx.xxx.xxx-L El
	 * DNI ha de tener longitud 12
	 * 
	 * @param dni String con DNI a ser validado
	 * 
	 * @return true, si el DNI cumple el estandar nacional. FECHA: Enero 2023
	 * @author m.corchero.blazquez
	 * 
	 **************************************************************************************/
	public static boolean cumpleDNI(String dni) {
		return !isVacio(dni) && dni.matches(DNI_PATTERN) && (dni.length() == LONGITUD_DNI) && cumpleLetraDNI(dni);
	}
	
	public static boolean cumpleLetraDNI (String dni) {
		char [] letras = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
		String[] dniDividido = dni.split("-");
		char letraDNI = dniDividido[1].charAt(0);	
		
		ArrayList<Character> listaNum = new ArrayList<>();
        for(int i = 0; i < dni.length(); i++){
            if(Character.isDigit(dni.charAt(i)))
                listaNum.add(dni.charAt(i));
        }
        
        StringBuilder cadenaNum = new StringBuilder();
        for(Character c : listaNum) {
        	cadenaNum.append(c);
        }
        
        int numFinal = Integer.parseInt(cadenaNum.toString());
        
        int resto = numFinal % 23;
        char letraCorrespondiente = letras[resto];
        return letraDNI == letraCorrespondiente;
	}

	/**
	 * ***************************************************************************************
	 * NOMBRE: cumpleRango *
	 * 
	 * DESCRIPCIÓN:
	 */
	/**
	 * Comprueba que un Número se necuentra entre 2 valores
	 * 
	 * @param valor       (int)/(double) Número a comprobar
	 * @param valorMinimo (int) Número valor aceptable
	 * @param valorMaximo (int) MINúmero valor aceptable
	 * 
	 * @return true si valorMinimo < valor < valorMaximo FECHA: Enero 2023
	 * @author m.corchero.blazquez
	 * 
	 **************************************************************************************/
	public static boolean cumpleRango(int valor, int valorMinimo, int valorMaximo) {

		return ((valor >= valorMinimo) && (valor <= valorMaximo)); // directamente el valor de la comprobacion
	}

	public static boolean cumpleRango(double valor, int valorMinimo, int valorMaximo) {

		return ((valor >= valorMinimo) && (valor <= valorMaximo));
	}

	/**
	 * ***************************************************************************************
	 * NOMBRE: cumpleLongitudMin *
	 * 
	 * DESCRIPCIÓN:
	 */
	/**
	 * Comprobar que el texto pasado tiene una longitud de al menos x caracteres,
	 * siendo x el entero pasado como parámetro
	 * 
	 * @param texto          String texto a comprobar
	 * @param longitudMinima int que indique longitud mínima.
	 * 
	 * @return cierto, si la longitud del texto es mayor o igual que longitudMinima
	 *         FECHA: Enero 2023
	 * @author m.corchero.blazquez
	 * 
	 **************************************************************************************/
	public static boolean cumpleLongitudMin(String texto, int longitudMinima) {
		return (texto.length() >= longitudMinima); // dev. directamente el resultado de la comprobación
	}

	/**
	 * ***************************************************************************************
	 * NOMBRE: cumpleLongitudMax *
	 * 
	 * DESCRIPCIÓN:
	 */
	/**
	 * Comprobar que el texto pasado tiene una longitud de, como mucho, x
	 * caracteres, siendo x el entero pasado como parámetro
	 * 
	 * @param texto          String con el texto a comprobar
	 * @param longitudMaxima int con la longitud máxima del texto
	 * 
	 * @return true, si el texto es menor o igual que la longitud máxima. FECHA:
	 *         Enero 2023
	 * @author m.corchero.blazquez
	 * 
	 **************************************************************************************/
	public static boolean cumpleLongitudMax(String texto, int longitudMaxima) {
		return (texto.length() <= longitudMaxima);
	}

	/**
	 * **************************************************************************************
	 * NOMBRE: cumpleLongitud *
	 * 
	 * DESCRIPCIÓN:
	 */
	/**
	 * Comprobar que la longitud de un texto se encuentra entre unos valores máximos
	 * y mínimos
	 * 
	 * @param texto          String con el texto que a validar
	 * @param longitudMinima (int) Mínima longitud del texto
	 * @param longitudMaxima (int) Máxima longitud válida para el texo
	 * 
	 * @return true, si la longitud del texto cumple: longitudMinima <=
	 *         longitudTexto <=longitudMaxima FECHA: Enero 2023
	 * @author m.corchero.blazquez
	 * 
	 **************************************************************************************/
	public static boolean cumpleLongitud(String texto, int longitudMinima, int longitudMaxima) {
		return cumpleLongitudMin(texto, longitudMinima) && cumpleLongitudMax(texto, longitudMaxima);
	}

	/**
	 * Valida una fecha calendar con mínimo min
	 * 
	 * @param fecha
	 * @param min
	 * @return
	 * @author m.corchero.blazquez
	 */

	public static boolean valDateMin(LocalDate fecha, LocalDate min) {
		return fecha.isAfter(min); // comprueba si la fecha después de la fecha minima
	}

	/**
	 * Valida una fecha calendar con máximo max
	 * 
	 * @param fecha
	 * @param max
	 * @return
	 * @author m.corchero.blazquez
	 */
	public static boolean valDateMax(LocalDate fecha, LocalDate max) {
		return fecha.isBefore(max); // si la fecha es antes de la fecha maxima

	}

	/**
	 * esFechaValida Recibe una string con formato fecha dd/mm/aaaa y comprueba que
	 * el formato es dd/mm/aaaa
	 * 
	 * @param fecha
	 * @return
	 * @author m.corchero.blazquez
	 */
	public static boolean esFechaValida(String fecha) {
		return !isVacio(fecha) && fecha.matches(FECHA_PATTERN);
	}

	/**
	 * Nombre esPasswordValida Descripcion Comprueba que la cadena recibida cumpla
	 * con lasnormas de contraseña
	 * 
	 * @param password string con la contraseña introducida
	 * @return true si cumple con las especificaciones
	 * @author m.corchero.blazquez
	 */
	public static boolean esPasswordValida(String password) {
		return !isVacio(password) && password.matches(PASSWORD_PATTERN);

	}
}
