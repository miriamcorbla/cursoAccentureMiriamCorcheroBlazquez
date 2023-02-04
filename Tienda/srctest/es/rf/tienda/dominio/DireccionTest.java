package es.rf.tienda.dominio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.rf.tienda.exception.DomainException;

/**
 * Clase que comprueba el dominio Direccion
 * @author m.corchero.blazquez
 *
 */
class DireccionTest {
	
	Direccion direccion;
	static final String NOMBRE_CORRECTO = "Miriam Corchero";
	static final String NOMBRE_INCORRECTO_SPECIALCHARS = "Mi*riam Corchero";
	static final String NOMBRE_INCORRECTO_LONGITUD_MINIMA = "Mi";
	
	static final String DIR_CORRECTO = "Calle Calle Calle 6";
	static final String DIR_INCORRECTO_SPECIALCHARS = "Calle *";
	
	static final String POBLACION_CORRECTA = "Poblacion";
	static final String POBLACION_INCORRECTA_SPECIALCHARS = "$pob";
	
	static final String CPOSTAL_CORRECTO = "11111";
	static final String CPOSTAL_INCORRECTA_SPECIALCHARS = "1*11";
	
	static final String PROVINCIA_CORRECTA = "Provincia";
	static final String PROVINCIA_INCORRECTA_SPECIALCHARS = "Prov&ncia";
	
	static final String PAIS_CORRECTO = "PAIS";
	static final String PAIS_INCORRECTO_SPECIALCHARS = "PAIS*";

	static final String EMAIL_CORRECTO = "mmm_@gmail.es";
	static final String EMAIL_ACABA_ERROR = "mmmmmm@gmail.c";
	static final String EMAIL_ERROR = "*mmm@gmail.com";
	static final String EMAIL_ERROR1 = "mmmmm@gmai*.com";
	
	static final String CADENA_NULA = null;
	static final String CADENA_VACIA = "";
	
	@BeforeEach
	void inicio() throws DomainException {
		creacion();
	}
	
	@Test
	void creacion() throws DomainException {
		direccion = new Direccion();
	}
	
	/**
	 * Test que comprueba que el método setDir_nombre
	 * se realiza correctamente al recibir un nombre correcto
	 * y lo muestra con get
	 * @throws DomainException
	 */
	@Test
	void testGetDir_nombre() throws DomainException {
		direccion.setDir_nombre(NOMBRE_CORRECTO);
		assertEquals(NOMBRE_CORRECTO, direccion.getDir_nombre());
	}
	
	/**
	 * Test que comprueba que el método setDir_nombre lanza la excepción
	 * cuando recibe un nombre que no cumple con los requisitos, en este caso 
	 * porque contiene caracteres especiales
	 * @throws DomainException
	 */
	@Test
	void testSetDir_nombreErrorSpecialChars() throws DomainException {
		 assertThrows(DomainException.class,
		            () -> { direccion.setDir_nombre(NOMBRE_INCORRECTO_SPECIALCHARS);});
	}
	
	/**
	 * Test que comprueba que el método setDir_nombre lanza la excepción
	 * cuando recibe un nombre que no cumple con los requisitos, en este caso 
	 * porque su longitud no supera la longitud mínima obligatoria
	 * @throws DomainException
	 */
	@Test
	void testSetDir_nombreErrorLongMin() throws DomainException {
		 assertThrows(DomainException.class,
		            () -> { direccion.setDir_nombre(NOMBRE_INCORRECTO_LONGITUD_MINIMA);});
	}

	/**
	 * Test que comprueba que el método setDir_direccion
	 * se realiza correctamente al recibir una dirección correcta y 
	 * lo muestra con get
	 * @throws DomainException
	 */
	@Test
	void testGetDir_direccion() throws DomainException {
		direccion.setDir_direccion(DIR_CORRECTO);
		assertEquals(DIR_CORRECTO, direccion.getDir_direccion());
	}
	
	/**
	 * Test que comprueba que el método setDir_direccion lanza la excepción
	 * cuando recibe un nombre que no cumple con los requisitos, en este caso 
	 * porque tiene caracteres especiales
	 * @throws DomainException
	 */
	@Test
	void testSetDir_direccionErrorSpecialChars() throws DomainException {
		 assertThrows(DomainException.class,
		            () -> { direccion.setDir_direccion(DIR_INCORRECTO_SPECIALCHARS);});
	}

	/**
	 * Test que comprueba que el método setDir_poblacion
	 * se realiza correctamente al recibir una población correcta y 
	 * lo muestra con get
	 * @throws DomainException
	 */
	@Test
	void testGetDir_poblacion() throws DomainException {
		direccion.setDir_poblacion(POBLACION_CORRECTA);
		assertEquals(POBLACION_CORRECTA, direccion.getDir_poblacion());
	}
	
	/**
	 * Test que comprueba que el método setDir_poblacion lanza la excepción
	 * cuando recibe una población que no cumple con los requisitos, en este caso 
	 * porque tiene caracteres especiales
	 * @throws DomainException
	 */
	@Test
	void testSetDir_poblacionErrorSpecialChars() throws DomainException {
		 assertThrows(DomainException.class,
		            () -> { direccion.setDir_poblacion(POBLACION_INCORRECTA_SPECIALCHARS);});
	}

	/**
	 * Test que comprueba que el método setDir_cPostal
	 * se realiza correctamente al recibir un cod. postal correcto y 
	 * lo muestra con get
	 * @throws DomainException
	 */
	@Test
	void testGetDir_cPostal() throws DomainException {
		direccion.setDir_cPostal(CPOSTAL_CORRECTO);
		assertEquals(CPOSTAL_CORRECTO, direccion.getDir_cPostal());
	}
	
	/**
	 * Test que comprueba que el método setDir_cPostal lanza la excepción
	 * cuando recibe un CPostal que no cumple con los requisitos, en este caso 
	 * porque tiene caracteres especiales
	 * @throws DomainException
	 */
	@Test
	void testSetDir_cPostalErrorSpecialChars() throws DomainException {
		 assertThrows(DomainException.class,
		            () -> { direccion.setDir_cPostal(CPOSTAL_INCORRECTA_SPECIALCHARS);});
	}

	/**
	 * Test que comprueba que el método setDir_provincia
	 * se realiza correctamente al recibir una provincia correcta y 
	 * lo muestra con get
	 * @throws DomainException
	 */
	@Test
	void testGetDir_provincia() throws DomainException {
		direccion.setDir_provincia(PROVINCIA_CORRECTA);
		assertEquals(PROVINCIA_CORRECTA, direccion.getDir_provincia());
	}
	
	/**
	 * Test que comprueba que el método setDir_provincia lanza la excepción
	 * cuando recibe una provincia que no cumple con los requisitos, en este caso 
	 * porque tiene caracteres especiales
	 * @throws DomainException
	 */
	@Test
	void testSetDir_provinciaErrorSpecialChars() throws DomainException {
		 assertThrows(DomainException.class,
		            () -> { direccion.setDir_cPostal(PROVINCIA_INCORRECTA_SPECIALCHARS);});
	}


	/**
	 * Test que comprueba que el método setDir_pais
	 * se realiza correctamente al recibir un país correcto y 
	 * lo muestra con get
	 * @throws DomainException
	 */
	@Test
	void testGetDir_pais() throws DomainException {
		direccion.setDir_pais(PAIS_CORRECTO);
		assertEquals(PAIS_CORRECTO, direccion.getDir_pais());
	}
	
	/**
	 * Test que comprueba que el método setDir_pais lanza la excepción
	 * cuando recibe un país que no cumple con los requisitos, en este caso 
	 * porque tiene caracteres especiales
	 * @throws DomainException
	 */
	@Test
	void testSetDir_paisErrorSpecialChars() throws DomainException {
		 assertThrows(DomainException.class,
		            () -> { direccion.setDir_pais(PAIS_INCORRECTO_SPECIALCHARS);});
	}

	/**
	 * Test que comprueba que el método setDir_correoE
	 * se realiza correctamente al recibir un mail correcto y 
	 * lo muestra con get
	 * @throws DomainException
	 */
	@Test
	void testGetDir_correoE() throws DomainException {
		direccion.setDir_correoE(EMAIL_CORRECTO);
		assertEquals(EMAIL_CORRECTO, direccion.getDir_correoE());
	}
	
	/**
	 * Test que comprueba que el método setDir_correoE lanza la excepción
	 * cuando recibe un mail que no cumple con los requisitos, en este caso 
	 * porque finaliza sin cumplir el patrón para el final del mail
	 * @throws DomainException
	 */
	@Test
	void testSetDir_correoEAcabaEnErrorChar() throws DomainException {
		 assertThrows(DomainException.class,
		            () -> { direccion.setDir_correoE(EMAIL_ACABA_ERROR);});
	}
	
	/**
	 * Test que comprueba que el método setDir_correoE lanza la excepción
	 * cuando recibe un mail que no cumple con los requisitos, en este caso 
	 * porque comienza con un caracter especial no permitido en la parte 1 
	 * antes del "@"
	 * @throws DomainException
	 */
	@Test
	void testSetDir_correoEAErrorSpecialCharsParte1() throws DomainException {
		 assertThrows(DomainException.class,
		            () -> { direccion.setDir_correoE(EMAIL_ERROR);});
	}
	
	/**
	 * Test que comprueba que el método setDir_correoE lanza la excepción
	 * cuando recibe un mail que no cumple con los requisitos, en este caso 
	 * porque contiene un caracter especial no permitido en la parte 2 
	 * después del "@"
	 * @throws DomainException
	 */
	@Test
	void testSetDir_correoEAErrorSpecialCharsParte2() throws DomainException {
		 assertThrows(DomainException.class,
		            () -> { direccion.setDir_correoE(EMAIL_ERROR1);});
	}

	/**
	 * Test que comprueba que los métodos set de la clase Direccion lazan
	 * una excepción si reciben una cadena nula o vacia.
	 * @throws DomainException
	 */
	@Test
	void testsetDir_nombreNulo() throws DomainException {
		 assertThrows(DomainException.class,
		            () -> { direccion.setDir_nombre(CADENA_NULA);});
	}
	
	@Test
	void testsetDir_nombreVacio() throws DomainException {
		 assertThrows(DomainException.class,
		            () -> { direccion.setDir_nombre(CADENA_VACIA);});
	}
	@Test
	void testsetDir_direccionNulo() throws DomainException {	 
		 assertThrows(DomainException.class,
		            () -> { direccion.setDir_direccion(CADENA_NULA);});
	}
	@Test
	void testsetDir_direccionVacio() throws DomainException {
		 assertThrows(DomainException.class,
		            () -> { direccion.setDir_direccion(CADENA_VACIA);});
	}
	@Test
	void testsetDir_cPostalNulo() throws DomainException {
		 assertThrows(DomainException.class,
		            () -> { direccion.setDir_cPostal(CADENA_NULA);});
	}
	@Test
	void testsetDir_cPostalVacio() throws DomainException {
		 assertThrows(DomainException.class,
		            () -> { direccion.setDir_cPostal(CADENA_VACIA);});
	}
	@Test
	void testsetDir_poblacionNulo() throws DomainException {		 
		 assertThrows(DomainException.class,
		            () -> { direccion.setDir_poblacion(CADENA_NULA);});
	}
	@Test
	void testsetDir_poblacionVacio() throws DomainException {
		 assertThrows(DomainException.class,
		            () -> { direccion.setDir_poblacion(CADENA_VACIA);});
	}
	@Test
	void testsetDir_provinciaNulo() throws DomainException {
		 
		 assertThrows(DomainException.class,
		            () -> { direccion.setDir_provincia(CADENA_NULA);});
	}
	@Test
	void testsetDir_provinciaVacio() throws DomainException {
		 assertThrows(DomainException.class,
		            () -> { direccion.setDir_provincia(CADENA_VACIA);});
	}
	@Test
	void testsetDir_paisNulo() throws DomainException {	 
		 assertThrows(DomainException.class,
		            () -> { direccion.setDir_pais(CADENA_NULA);});
	}
	@Test
	void testsetDir_paisVacio() throws DomainException {
		 assertThrows(DomainException.class,
		            () -> { direccion.setDir_pais(CADENA_VACIA);});
	}
	@Test
	void testsetDir_correoENulo() throws DomainException {	 
		 assertThrows(DomainException.class,
		            () -> { direccion.setDir_correoE(CADENA_NULA);});
	}
	@Test
	void testsetDir_correoEVacio() throws DomainException {
		 assertThrows(DomainException.class,
		            () -> { direccion.setDir_correoE(CADENA_VACIA);});
	}
}
