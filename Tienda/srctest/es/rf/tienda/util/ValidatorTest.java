package es.rf.tienda.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidatorTest {
	
	static final String TEXTO_ALFANUMERICO = "ESTOES1TEXTO";
	static final String TEXTO_ALFANUMERICO_ESPECIAL = "*23Es-%%";
	static final String TEXTO_VACIO = "";
	static final String TEXTO_NULO = null;
	
	static final String TELEFONO = "11 111 11 1111";
	static final String TELEFONO_ERROR_MINCARACTERES = "11    ";
	static final String TELEFONO_ERROR_MINDIGITOS = "11         ";
	static final String TELEFONO_VACIO = "";
	static final String TELEFONO_NULO = null;

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
	 * Comrpueba validacion de método isVacio con texto
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
	void testIsEmailValido() {
		fail("Not yet implemented");
	}

	@Test
	void testCumpleDNI() {
		fail("Not yet implemented");
	}

	@Test
	void testCumpleRangoIntIntInt() {
		fail("Not yet implemented");
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
