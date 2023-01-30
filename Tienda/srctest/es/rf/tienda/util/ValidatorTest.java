package es.rf.tienda.util;

import static org.junit.jupiter.api.Assertions.*;

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
	void testcumpleCodigoProducto() {
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
		fail("Not yet implemented");
	}

	@Test
	void testCumpleLongitudMin() {
		fail("Not yet implemented");
	}

	@Test
	void testCumpleLongitudMax() {
		fail("Not yet implemented");
	}

	@Test
	void testCumpleLongitud() {
		fail("Not yet implemented");
	}

	@Test
	void testValDateMin() {
		fail("Not yet implemented");
	}

	@Test
	void testValDateMax() {
		fail("Not yet implemented");
	}

	@Test
	void testEsFechaValida() {
		fail("Not yet implemented");
	}

	@Test
	void testEsPasswordValida() {
		fail("Not yet implemented");
	}

}
