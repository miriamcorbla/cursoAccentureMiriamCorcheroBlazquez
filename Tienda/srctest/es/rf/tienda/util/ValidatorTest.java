package es.rf.tienda.util;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

/**
 * Clase que prueba los métodos de la clase Validator
 * @author m.corchero.blazquez
 */
class ValidatorTest {
	
	static final String CODIGO_OK = "PR332";
	static final String CODIGO_ERROR = "332PR";
	static final String CODIGO_ERROR_SOLONUMEROS = "32323";
	static final String CODIGO_ERROR_LONGITUD = "PR3332";
	static final String CODIGO_ERROR_MINUSCULA = "pr332";
	static final String CODIGO_VACIO = "";
	static final String CODIGO_NULO = null;
	
	static final String TEXTO_ALFANUMERICO = "ESTOES1TEXTO";
	static final String TEXTO_ALFANUMERICO_ESPECIAL = "*23Es-%%";
	static final String TEXTO_VACIO = "";
	static final String TEXTO_NULO = null;
	
	static final String TELEFONO = "11 111 111 111";
	static final String TELEFONO_ERROR_MINCARACTERES = "11    ";
	static final String TELEFONO_ERROR_MINDIGITOS = "11         ";
	static final String TELEFONO_MAX_CARACTERES = "11 11 11 11 11 11 1 1 1";
	static final String TELEFONO_VACIO = "";
	static final String TELEFONO_NULO = null;

	static final String EMAIL_ACABAEN2 = "mmm_@gmail.es";
	static final String EMAIL_ACABAEN3 = "mmm_mm@gmail.com";
	static final String EMAIL_ACABA_ERROR = "mmmmmm@gmail.c";
	static final String EMAIL_ERROR = "*mmm@gmail.com";
	static final String EMAIL_ERROR1 = "mmmmm@gmai*.com";
	static final String EMAIL_GUIONES = "mmm-m@gmail.com";
	static final String EMAIL_VACIO = "";
	static final String EMAIL_NULO = null;
	
	static final String DNI = "12.345.678-Z";
	static final String DNI_ERROR = "111.11.111-A";
	static final String DNI_ERROR_LONGITUD = "1111.111.1111-A";
	static final String DNI_ERROR_LETRA = "11.111.111-1";
	static final String DNI_ERROR_LETRA_MAL_CALCULADA = "11.111.111-B";
	static final String DNI_VACIO = "";
	static final String DNI_NULO = null;
	
	static final int VALOR = 3;
	static final int VALOR_MAX = 10;
	static final int VALOR_MIN = 1;
	static final int VALOR_ERRORMAX = 20;
	static final int VALOR_ERRORMIN = -8;
	
	static final double VALOR_DOUBLE = 3.4;
	static final double VALOR_DOUBLE_ERRORMAX = 20.01;
	static final double VALOR_DOUBLE_ERRORMIN = -8.8;
	
	static final String TEXTO_LONGITUD = "hola que tal";
	static final String TEXTO_LONGITUD_ERROR = "hola que";
	static final String TEXTO_LONGITUD_ERROR_MAX = "hola que tal tal tal tal tal tal";
	static final int LONGITUD_MIN = 10;
	static final int LONGITUD_MAX = 20;
	
	static final LocalDate FECHA_CORRECTA = LocalDate.now();
	static final LocalDate FECHA_ERROR_MIN = LocalDate.of(2019, 1, 22);
	static final LocalDate FECHA_ERROR_MAX = LocalDate.of(2033, 1, 22);
	static final LocalDate FECHA_MIN = LocalDate.of(2020, 1, 22);
	static final LocalDate FECHA_MAX = LocalDate.of(2030, 1, 22);
	
	static final String FECHA_STR_CORRECTA = "22/01/2022";
	static final String FECHA_STR_ERROR = "22-01-2022";
	static final String FECHA_STR_ERROR2 = "22.01.2022";
	static final String FECHA_STR_ERROR3 = "22.01.22";
	static final String FECHA_STR_ERROR4 = null;
	static final String FECHA_STR_ERROR5 = "22/01/22";
	static final String FECHA_STR_ERROR6 = "2/1/2022";
	
	static final String PSWD_CORRECTA = "hHhoLaA$3";
	static final String PSWD_ERROR = " ";
	static final String PSWD_ERROR2 = "holaHola";
	static final String PSWD_ERROR3 = "Holahola3";
	static final String PSWD_ERROR4 = "holahola3";
	static final String PSWD_ERROR5 = "holaHola!";
	static final String PSWD_ERROR6 = "hHa$3";
	/**
	 * Comprueba validación de codigo de producto siendo este
	 * solo de numeros y cumpliendo la longitud
	 */
	@Test
	void testcumpleCodigoProductoSoloNumeros() {
		assertFalse(Validator.cumpleCodigoProducto(CODIGO_ERROR_SOLONUMEROS));
	}
	
	/**
	 * Comprueba validación de codigo de producto
	 */
	@Test
	void testCumpleCodigoProducto() {
		assertTrue(Validator.cumpleCodigoProducto(CODIGO_OK));
	}
	
	/**
	 * Comprueba validación de codigo de producto con inicio en minusucla
	 */
	@Test
	void testcumpleCodigoProductoErrorMinuscula() {
		assertFalse(Validator.cumpleCodigoProducto(CODIGO_ERROR_MINUSCULA));
	}
	
	/**
	 * Comprueba validación de codigo de producto con longitud erronea
	 */
	@Test
	void testcumpleCodigoProductoErrorLongitud() {
		assertFalse(Validator.cumpleCodigoProducto(CODIGO_ERROR_LONGITUD));
	}
	
	/**
	 * Comprueba validación de codigo de producto pattern erroneo
	 */
	@Test
	void testcumpleCodigoProductoError() {
		assertFalse(Validator.cumpleCodigoProducto(CODIGO_ERROR));
	}
	
	/**
	 * Comprueba validación de codigo de producto siendo vacio
	 */
	@Test
	void testcumpleCodigoProductoVacio() {
		assertFalse(Validator.cumpleCodigoProducto(CODIGO_VACIO));
	}
	
	/**
	 * Comprueba validación de codigo de producto siendo nulo
	 */
	@Test
	void testcumpleCodigoProductoNulo() {
		assertFalse(Validator.cumpleCodigoProducto(CODIGO_NULO));
	}
	
	/**
	 * Comprueba validación de cadena correcta
	 */
	@Test
	void testIsAlfanumeric() {
		assertTrue(Validator.isAlfanumeric(TEXTO_ALFANUMERICO));
	}
	
	/**
	 * Comprueba validación de cadena con caracteres especiales
	 */
	@Test
	void testIsAlfanumericCaracteresEspeciales() {
		assertFalse(Validator.isAlfanumeric(TEXTO_ALFANUMERICO_ESPECIAL));
	}

	/**
	 * Comprueba validacion de método isVacio con texto
	 */
	@Test
	void testIsVacio() {
		assertFalse(Validator.isVacio(TEXTO_ALFANUMERICO));
	}
	
	/**
	 * Comprueba si el texto que recibe es vacio
	 */
	@Test
	void testIsVacioTextoVacio() {
		assertTrue(Validator.isVacio(TEXTO_VACIO));
	}
	
	/**
	 * Comprueba que el texto que recibe es nulo
	 */
	@Test
	void testIsVacioNULO() {
		assertTrue(Validator.isVacio(TEXTO_NULO));
	}

	/**
	 * Comprueba si el teléfono que le pasa cumple el patrón indicado,
	 * de 10 a 20 digitos y minimo 10 dígitos
	 */
	@Test
	void testCumplePhoneNumber() {
		assertTrue(Validator.cumplePhoneNumber(TELEFONO));
	}

	/**
	 * Comprueba que arroja falso si recibe un nulo
	 */
	@Test
	void testCumplePhoneNumberNulo() {
		assertFalse(Validator.cumplePhoneNumber(TELEFONO_NULO));
	}

	/**
	 * Comprueba que arroja falso si recibe un vacio
	 */
	@Test
	void testCumplePhoneNumberVacio() {
		assertFalse(Validator.cumplePhoneNumber(TELEFONO_VACIO));
	}
	
	/**
	 * Comprueba que arroja falso si no cumple con el min de dígitos
	 */
	@Test
	void testCumplePhoneNumberDigitosEspacios() {
		assertFalse(Validator.cumplePhoneNumber(TELEFONO_ERROR_MINDIGITOS));
	}

	/**
	 * Comprueba que arroja falso si no cumple con el minimo de caracteres
	 */
	@Test
	void testCumplePhoneNumberCaracteres() {
		assertFalse(Validator.cumplePhoneNumber(TELEFONO_ERROR_MINCARACTERES));
	}
	
	/**
	 * Comprueba que arroja falso si no cumple con el máximo de caracteres
	 */
	@Test
	void testCumplePhoneNumberMaxCaracteres() {
		assertFalse(Validator.cumplePhoneNumber(TELEFONO_MAX_CARACTERES));
	}
	
	/**
	 * Comprueba si dado un email acabado en dos letras es correcto
	 */
	@Test
	void testIsEmailValidoEn2() {
		assertTrue(Validator.isEmailValido(EMAIL_ACABAEN2));
	}
	
	/**
	 * Comprueba si dado un email acabado en tres letras es correcto
	 */
	@Test
	void testIsEmailValidoEn3() {
		assertTrue(Validator.isEmailValido(EMAIL_ACABAEN3));
	}
	
	/**
	 * Comprueba si dado un email acabado con guiones es correcto
	 */
	@Test
	void testIsEmailValidoGuiones() {
		assertTrue(Validator.isEmailValido(EMAIL_GUIONES));
	}
	
	/**
	 * Comprueba que arroja falso recibiendo un email que no cumple
	 * con el minimo de letras necesarias en la parte 1 del mail
	 */
	@Test
	void testIsEmailValidoError() {
		assertFalse(Validator.isEmailValido(EMAIL_ERROR));
	}
	
	/**
	 * Comprueba que arroja falso recibiendo un email que contiene
	 * caracteres especiales en la parte 2 del mail
	 */
	@Test
	void testIsEmailValidoError1() {
		assertFalse(Validator.isEmailValido(EMAIL_ERROR1));
	}
	
	/**
	 * Comprueba que arroja falso recibiendo un mail nulo
	 */
	@Test
	void testIsEmailValidoNulo() {
		assertFalse(Validator.isEmailValido(EMAIL_NULO));
	}
	
	/**
	 * Comprueba que arroja falso recibiendo un mail vacio
	 */
	@Test
	void testIsEmailValidoVacio() {
		assertFalse(Validator.isEmailValido(EMAIL_VACIO));
	}

	/**
	 * Comprueba que el DNI que recibe es correcto: la letra corresponde
	 * al número y el dni sigue el patrón indicado
	 */
	@Test
	void testCumpleDNI() {
		assertTrue(Validator.cumpleDNI(DNI));
	}
	
	/**
	 * Comprueba que arroja falso si no cumple con el patrón de puntos
	 */
	@Test
	void testCumpleDNIError() {
		assertFalse(Validator.cumpleDNI(DNI_ERROR));
	}
	
	/**
	 * Comprueba que arroja falso si en lugar de una letra hay un número
	 */
	@Test
	void testCumpleDNIErrorLetraFinal() {
		assertFalse(Validator.cumpleDNI(DNI_ERROR_LETRA));
	}
	
	/**
	 * Comprueba que arroja falso si no cumple con el máximo de dígitos
	 */
	@Test
	void testCumpleDNIErrorLongitud() {
		assertFalse(Validator.cumpleDNI(DNI_ERROR_LONGITUD));
	}
	
	/**
	 * Comprueba que arroja falso si recibe un dni vacio
	 */
	@Test
	void testCumpleDNIVacio() {
		assertFalse(Validator.cumpleDNI(DNI_VACIO));
	}
	
	/**
	 * Comprueba que arroja falso si recibe un nulo
	 */
	@Test
	void testCumpleDNINulo() {
		assertFalse(Validator.cumpleDNI(DNI_NULO));
	}
	
	/**
	 * Comprueba que arroja falso si la letra no corresponde con el número
	 */
	@Test
	void testCumpleDNILetraMalCalculada() {
		assertFalse(Validator.cumpleDNI(DNI_ERROR_LETRA_MAL_CALCULADA));
	}


	/**
	 * Comrpueba si el valor dado está entre el valor mínimo y máximo
	 */
	@Test
	void testCumpleRangoIntIntInt() {
		assertTrue(Validator.cumpleRango(VALOR, VALOR_MIN, VALOR_MAX));
	}
	
	/**
	 * Comprueba el límite de valor mínimo
	 */
	@Test
	void testCumpleRangoIntIntIntValorMin() {
		assertTrue(Validator.cumpleRango(VALOR_MIN, VALOR_MIN, VALOR_MAX));
	}
	
	/**
	 * Comprueba el límite de valor máximo
	 */
	@Test
	void testCumpleRangoIntIntIntValorMax() {
		assertTrue(Validator.cumpleRango(VALOR_MAX, VALOR_MIN, VALOR_MAX));
	}
	
	/**
	 * Comprueba que arroja falso si el valor que comprueba es menor que el valor mínimo
	 */
	@Test
	void testCumpleRangoIntIntIntValorErrorMin() {
		assertFalse(Validator.cumpleRango(VALOR_ERRORMIN, VALOR_MIN, VALOR_MAX));
	}
	
	/**
	 * Comprueba que arroja falso si el valor que comprueba es mayor que el valor máximo
	 */
	@Test
	void testCumpleRangoIntIntIntValorErrorMax() {
		assertFalse(Validator.cumpleRango(VALOR_ERRORMAX, VALOR_MIN, VALOR_MAX));
	}
	
	/**
	 * Comprueba el límite de valor mínimo
	 */
	@Test
	void testCumpleRangoDoubleIntInt() {
		assertTrue(Validator.cumpleRango(VALOR_DOUBLE, VALOR_MIN, VALOR_MAX));
	}
	
	/**
	 * Comprueba el límite de valor mínimo
	 */
	@Test
	void testCumpleRangoDoubleIntIntValorMin() {
		assertTrue(Validator.cumpleRango((double)VALOR_MIN, VALOR_MIN, VALOR_MAX));
	}
	
	/**
	 * Comprueba el límite de valor máximo
	 */
	@Test
	void testCumpleRangoDoubleIntIntValorMax() {
		assertTrue(Validator.cumpleRango((double)VALOR_MAX, VALOR_MIN, VALOR_MAX));
	}
	
	/**
	 * Comprueba que arroja falso si el valor que comprueba es menor que el valor mínimo
	 */
	@Test
	void testCumpleRangoDoubleIntIntValorErrorMin() {
		assertFalse(Validator.cumpleRango(VALOR_DOUBLE_ERRORMIN, VALOR_MIN, VALOR_MAX));
	}
	
	/**
	 * Comprueba que arroja falso si el valor que comprueba es mayor que el valor máximo
	 */
	@Test
	void testCumpleRangoDoubleIntIntValorErrorMax() {
		assertFalse(Validator.cumpleRango(VALOR_DOUBLE_ERRORMAX, VALOR_MIN, VALOR_MAX));
	}

	/**
	 * Comprueba que la longitud del texto que recibe es mayor que la longitud mínima permitida
	 */
	@Test
	void testCumpleLongitudMin() {
		assertTrue(Validator.cumpleLongitudMin(TEXTO_LONGITUD, LONGITUD_MIN));
	}
	
	/**
	 * Comprueba que arroja falso si no llega la longitud del texto que recibe a la mínima permitida
	 */
	@Test
	void testCumpleLongitudMinError() {
		assertFalse(Validator.cumpleLongitudMin(TEXTO_LONGITUD_ERROR, LONGITUD_MIN));
	}

	/**
	 * Comprueba que la longitud del texto que recibe es menor que la longitud máxima permitida
	 */
	@Test
	void testCumpleLongitudMax() {
		assertTrue(Validator.cumpleLongitudMax(TEXTO_LONGITUD, LONGITUD_MAX));
	}
	
	/**
	 * Comprueba que arroja falso si sobrepasa la longitud del texto que recibe a la máxima permitida
	 */
	@Test
	void testCumpleLongitudMaxError() {
		assertFalse(Validator.cumpleLongitudMax(TEXTO_LONGITUD_ERROR_MAX, LONGITUD_MAX));
	}

	/**
	 * Comprueba que la longitud de un texto se encuentra entre los valores permitidos
	 */
	@Test
	void testCumpleLongitud() {
		assertTrue(Validator.cumpleLongitud(TEXTO_LONGITUD, LONGITUD_MIN, LONGITUD_MAX));
	}
	
	/**
	 * Comprueba que arroja falso si la longitud de un texto no
	 * se encuentra entre los valores permitidos
	 */
	@Test
	void testCumpleLongitudError() {
		assertFalse(Validator.cumpleLongitud(TEXTO_LONGITUD_ERROR, LONGITUD_MIN, LONGITUD_MAX));
	}

	/**
	 * Comprueba que la fecha sobrepasa a la fecha mínima permitida
	 */
	@Test
	void testValDateMin() {
		assertTrue(Validator.valDateMin(FECHA_CORRECTA, FECHA_MIN));
	}
	
	/**
	 * Comprueba que arroja falso si la fecha no llega a la mínima permitida
	 */
	@Test
	void testValDateMinError() {
		assertFalse(Validator.valDateMin(FECHA_ERROR_MIN, FECHA_MIN));
	}

	/**
	 * Comprueba que la fecha no sobrepasa a la máxima permitida
	 */
	@Test
	void testValDateMax() {
		assertTrue(Validator.valDateMax(FECHA_CORRECTA, FECHA_MAX));
	}
	
	/**
	 * Comprueba que arroja falso si la fecha sobrepasa a la fecha máxima permitida
	 */
	@Test
	void testValDateMaxError() {
		assertFalse(Validator.valDateMax(FECHA_ERROR_MAX, FECHA_MAX));
	}
	
	/**
	 * Comprueba que la fecha que recibe tiene el patrón correcto
	 */
	@Test
	void testEsFechaValida() {
		assertTrue(Validator.esFechaValida(FECHA_STR_CORRECTA));
	}
	
	/**
	 * Comprueba que arroja falso si no cumple con el patrón porque usa guiones
	 */
	@Test
	void testEsFechaValidaError() {
		assertFalse(Validator.esFechaValida(FECHA_STR_ERROR));
	}
	
	/**
	 * Comprueba que arroja falso si no cumple con el patrón porque usa puntos
	 */
	@Test
	void testEsFechaValidaError2() {
		assertFalse(Validator.esFechaValida(FECHA_STR_ERROR2));
	}
	
	/**
	 * Comprueba que arroja falso si no cumple con el patrón porque el
	 * año solo tiene dos dígitos y no cuatro y usa puntos
	 */
	@Test
	void testEsFechaValidaError3() {
		assertFalse(Validator.esFechaValida(FECHA_STR_ERROR3));
	}
	
	/**
	 * Comprueba que arroja falso porque recibe un nulo
	 */
	@Test
	void testEsFechaValidaError4() {
		assertFalse(Validator.esFechaValida(FECHA_STR_ERROR4));
	}
	
	/**
	 * Comprueba que arroja falso si no cumple con el patrón porque el
	 * año solo tiene dos dígitos y no cuatro, usando barras
	 */
	@Test
	void testEsFechaValidaError5() {
		assertFalse(Validator.esFechaValida(FECHA_STR_ERROR5));
	}
	
	/**
	 * Comprueba que arroja falso si no cumple con el patrón porque el dia
	 * o el mes tiene un dígito en lugar de dos
	 */
	@Test
	void testEsFechaValidaError6() {
		assertFalse(Validator.esFechaValida(FECHA_STR_ERROR6));
	}
	
	/**
	 * Comprueba que la contraseña es acorde al patrón
	 */
	@Test
	void testEsPasswordValida() {
		assertTrue(Validator.esPasswordValida(PSWD_CORRECTA));
	}
	
	/**
	 * Comprueba que arroja falso porque la contraseña es vacia
	 */
	@Test
	void testEsPasswordValidaError() {
		assertFalse(Validator.esPasswordValida(PSWD_ERROR));
	}
	
	/**
	 * Comprueba que arroja falso porque la contraseña
	 * no contiene caracteres especiales ni dígitos
	 */
	@Test
	void testEsPasswordValidaError2() {
		assertFalse(Validator.esPasswordValida(PSWD_ERROR2));
	}
	
	/**
	 * Comprueba que arroja falso porque la contraseña
	 * no contiene caracteres especiales aunque empiece
	 * en mayúscula
	 */
	@Test
	void testEsPasswordValidaError3() {
		assertFalse(Validator.esPasswordValida(PSWD_ERROR3));
	}
	
	/**
	 * Comprueba que arroja falso porque la contraseña
	 * no contiene caracteres especiales aunque empiece
	 * en minúscula
	 */
	@Test
	void testEsPasswordValidaError4() {
		assertFalse(Validator.esPasswordValida(PSWD_ERROR4));
	}
	
	/**
	 * Comprueba que arroja falso porque la contraseña
	 * contiene caracteres especiales no permitidos, como "!"
	 */
	@Test
	void testEsPasswordValidaError5() {
		assertFalse(Validator.esPasswordValida(PSWD_ERROR5));
	}
	
	/**
	 * Comprueba que arroja falso porque la contraseña
	 * no es de la longitud adecuada aunque contenga todos los 
	 * requisitos de caracteres
	 */
	@Test
	void testEsPasswordValidaError6() {
		assertFalse(Validator.esPasswordValida(PSWD_ERROR6));
	}	

}
