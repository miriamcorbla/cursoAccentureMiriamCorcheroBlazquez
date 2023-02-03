package es.rf.tienda.util;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

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
	
	static final String TELEFONO = "11 111 11 1111";
	static final String TELEFONO_ERROR_MINCARACTERES = "11    ";
	static final String TELEFONO_ERROR_MINDIGITOS = "11         ";
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
	
	static final String DNI = "11.111.111-A";
	static final String DNI_ERROR = "111.11.111-A";
	static final String DNI_ERROR_LONGITUD = "1111.111.1111-A";
	static final String DNI_ERROR_LETRA = "11.111.111-1";
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
	
	@Test
	void testIsVacioTextoVacio() {
		assertTrue(Validator.isVacio(TEXTO_VACIO));
	}
	
	@Test
	void testIsVacioNULO() {
		assertTrue(Validator.isVacio(TEXTO_NULO));
	}

	@Test
	void testCumplePhoneNumber() {
		assertTrue(Validator.cumplePhoneNumber(TELEFONO));
	}

	@Test
	void testCumplePhoneNumberNulo() {
		assertFalse(Validator.cumplePhoneNumber(TELEFONO_NULO));
	}

	@Test
	void testCumplePhoneNumberVacio() {
		assertFalse(Validator.cumplePhoneNumber(TELEFONO_VACIO));
	}
	
	@Test
	void testCumplePhoneNumberDigitos() {
		assertFalse(Validator.cumplePhoneNumber(TELEFONO_ERROR_MINDIGITOS));
	}

	@Test
	void testCumplePhoneNumberCaracteres() {
		assertFalse(Validator.cumplePhoneNumber(TELEFONO_ERROR_MINCARACTERES));
	}

	@Test
	void testIsEmailValidoEn2() {
		assertTrue(Validator.isEmailValido(EMAIL_ACABAEN2));
	}
	
	@Test
	void testIsEmailValidoEn3() {
		assertTrue(Validator.isEmailValido(EMAIL_ACABAEN3));
	}
	
	@Test
	void testIsEmailValidoGuiones() {
		assertTrue(Validator.isEmailValido(EMAIL_GUIONES));
	}
	
	@Test
	void testIsEmailValidoError() {
		assertFalse(Validator.isEmailValido(EMAIL_ERROR));
	}
	@Test
	void testIsEmailValidoError1() {
		assertFalse(Validator.isEmailValido(EMAIL_ERROR1));
	}
	@Test
	void testIsEmailValidoNulo() {
		assertFalse(Validator.isEmailValido(EMAIL_NULO));
	}
	@Test
	void testIsEmailValidoVacio() {
		assertFalse(Validator.isEmailValido(EMAIL_VACIO));
	}

	@Test
	void testCumpleDNI() {
		assertTrue(Validator.cumpleDNI(DNI));
	}
	
	@Test
	void testCumpleDNIError() {
		assertFalse(Validator.cumpleDNI(DNI_ERROR));
	}
	
	@Test
	void testCumpleDNIErrorLetraFinal() {
		assertFalse(Validator.cumpleDNI(DNI_ERROR_LETRA));
	}
	
	@Test
	void testCumpleDNIErrorLongitud() {
		assertFalse(Validator.cumpleDNI(DNI_ERROR_LONGITUD));
	}
	
	@Test
	void testCumpleDNIVacio() {
		assertFalse(Validator.cumpleDNI(DNI_VACIO));
	}
	
	@Test
	void testCumpleDNINulo() {
		assertFalse(Validator.cumpleDNI(DNI_NULO));
	}


	@Test
	void testCumpleRangoIntIntInt() {
		assertTrue(Validator.cumpleRango(VALOR, VALOR_MIN, VALOR_MAX));
	}
	
	@Test
	void testCumpleRangoIntIntIntValorMin() {
		assertTrue(Validator.cumpleRango(VALOR_MIN, VALOR_MIN, VALOR_MAX));
	}
	
	@Test
	void testCumpleRangoIntIntIntValorMax() {
		assertTrue(Validator.cumpleRango(VALOR_MAX, VALOR_MIN, VALOR_MAX));
	}
	
	@Test
	void testCumpleRangoIntIntIntValorErrorMin() {
		assertFalse(Validator.cumpleRango(VALOR_ERRORMIN, VALOR_MIN, VALOR_MAX));
	}
	
	@Test
	void testCumpleRangoIntIntIntValorErrorMax() {
		assertFalse(Validator.cumpleRango(VALOR_ERRORMAX, VALOR_MIN, VALOR_MAX));
	}

	@Test
	void testCumpleRangoDoubleIntInt() {
		assertTrue(Validator.cumpleRango(VALOR_DOUBLE, VALOR_MIN, VALOR_MAX));
	}
	
	@Test
	void testCumpleRangoDoubleIntIntValorMin() {
		assertTrue(Validator.cumpleRango((double)VALOR_MIN, VALOR_MIN, VALOR_MAX));
	}
	
	@Test
	void testCumpleRangoDoubleIntIntValorMax() {
		assertTrue(Validator.cumpleRango((double)VALOR_MAX, VALOR_MIN, VALOR_MAX));
	}
	
	@Test
	void testCumpleRangoDoubleIntIntValorErrorMin() {
		assertFalse(Validator.cumpleRango(VALOR_DOUBLE_ERRORMIN, VALOR_MIN, VALOR_MAX));
	}
	
	@Test
	void testCumpleRangoDoubleIntIntValorErrorMax() {
		assertFalse(Validator.cumpleRango(VALOR_DOUBLE_ERRORMAX, VALOR_MIN, VALOR_MAX));
	}

	@Test
	void testCumpleLongitudMin() {
		assertTrue(Validator.cumpleLongitudMin(TEXTO_LONGITUD, LONGITUD_MIN));
	}
	
	@Test
	void testCumpleLongitudMinError() {
		assertFalse(Validator.cumpleLongitudMin(TEXTO_LONGITUD_ERROR, LONGITUD_MIN));
	}

	@Test
	void testCumpleLongitudMax() {
		assertTrue(Validator.cumpleLongitudMax(TEXTO_LONGITUD, LONGITUD_MAX));
	}
	
	@Test
	void testCumpleLongitudMaxError() {
		assertFalse(Validator.cumpleLongitudMax(TEXTO_LONGITUD_ERROR_MAX, LONGITUD_MAX));
	}

	@Test
	void testCumpleLongitud() {
		assertTrue(Validator.cumpleLongitud(TEXTO_LONGITUD, LONGITUD_MIN, LONGITUD_MAX));
	}
	
	@Test
	void testCumpleLongitudError() {
		assertFalse(Validator.cumpleLongitud(TEXTO_LONGITUD_ERROR, LONGITUD_MIN, LONGITUD_MAX));
	}

	@Test
	void testValDateMin() {
		assertTrue(Validator.valDateMin(FECHA_CORRECTA, FECHA_MIN));
	}
	
	@Test
	void testValDateMinError() {
		assertFalse(Validator.valDateMin(FECHA_ERROR_MIN, FECHA_MIN));
	}

	@Test
	void testValDateMax() {
		assertTrue(Validator.valDateMax(FECHA_CORRECTA, FECHA_MAX));
	}
	
	@Test
	void testValDateMaxError() {
		assertFalse(Validator.valDateMax(FECHA_ERROR_MAX, FECHA_MAX));
	}
	

	@Test
	void testEsFechaValida() {
		assertTrue(Validator.esFechaValida(FECHA_STR_CORRECTA));
	}
	/* TERMINARRRR
	@Test
	void testEsFechaValidaError() {
		assertFalse(Validator.esFechaValida(FECHA_STR_ERROR));
	}
	
	@Test
	void testEsFechaValidaError2() {
		assertFalse(Validator.esFechaValida(FECHA_STR_ERROR2));
	}
*/
	@Test
	void testEsPasswordValida() {
		fail("Not yet implemented");
	}

}
