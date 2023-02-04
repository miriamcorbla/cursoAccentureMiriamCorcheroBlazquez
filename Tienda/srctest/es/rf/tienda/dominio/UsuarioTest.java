package es.rf.tienda.dominio;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.rf.tienda.exception.DomainException;

class UsuarioTest {
	
	Usuario usuario;
	static final int ID_USUARIO = 1;
	static final int ID_SET_USUARIO = 20;
	
	static final String NOMBRE_CORRECTO = "Miriam";
	static final String NOMBRE_CORRECTO_ALFANUMERICO = "Miriam 8";
	static final String NOMBRE_INCORRECTO_LONGITUD_MIN = "Mir";
	static final String NOMBRE_INCORRECTO_SPECIALCHARS = "Mir*am";
	static final String NOMBRE_NULO = null;
	static final String NOMBRE_VACIO = "";
	static final String NOMBRE_WHITESPACE = " ";
	
	static final String EMAIL_CORRECTO = "mmm_@gmail.es";
	static final String EMAIL_ACABA_ERROR = "mmmmmm@gmail.c";
	static final String EMAIL_ERROR = "*mmm@gmail.com";
	static final String EMAIL_ERROR1 = "mmmmm@gmai*.com";
	static final String EMAIL_ERROR_WHITESPACE = "     @gmail.es";
	static final String EMAIL_NULO = null;
	static final String EMAIL_VACIO = "";
	
	static final String PSWD_CORRECTA = "hHhoLaA$3";
	static final String PSWD_ERROR_WITESPACE = "         ";
	static final String PSWD_ERROR2 = "holaHola!";
	static final String PSWD_ERROR_MIN = "hHa$3";
	static final String PSWD_ERROR_MAX = "hHa$3hHa$3hHa$3hHa$3hHa$3hHa$3";
	static final String PSWD_ERROR_NULO = null;
	static final String PSWD_ERROR_VACIO = "";
	
	static final int TIPO_CORRECTO = 2;
	
	static final String DNI_CORRECTO = "12.345.678-Z";
	static final String DNI_ERROR = "111.11.111-A";
	static final String DNI_ERROR_LONGITUD = "1111.111.1111-A";
	static final String DNI_ERROR_LETRA = "11.111.111-1";
	static final String DNI_ERROR_LETRA_MAL_CALCULADA = "11.111.111-B";
	static final String DNI_VACIO = "";
	static final String DNI_NULO = null;
	
	static final LocalDate FECHA = LocalDate.now();
	static final LocalDate FECHA_MODIFICACION = LocalDate.of(2023, 4, 30);
	
	@BeforeEach
	void inicio() throws DomainException {
		creacion();
	}
	
	@Test
	void creacion() throws DomainException {
		usuario = new Usuario();
	}
	
	/**
	 * Test que comprueba que el id del usuario es autoincremental
	 */
	@Test
	void testGetId_usuario() {
		assertEquals(ID_USUARIO, usuario.getId_usuario());
	}
	
	/**
	 * Test que comprueba los métodos get y set de id_usuario
	 * arrojan los resultados correctos
	 */
	@Test
	void testSetId_usuario() {
		usuario.setId_usuario(ID_SET_USUARIO);
		assertEquals(ID_SET_USUARIO, usuario.getId_usuario());
	}

	
	/**
	 * Test que comprueba la validez del método getUser_nombre
	 * cuando se realiza un set con el nombre correcto
	 * @throws DomainException 
	 */
	@Test
	void testGetUser_nombre() throws DomainException {
		usuario.setUser_nombre(NOMBRE_CORRECTO);
		assertEquals(NOMBRE_CORRECTO, usuario.getUser_nombre());
	}
	
	/**
	 * Test que comprueba la validez del método getUser_nombre
	 * cuando se realiza un set con el nombre correcto con números
	 * @throws DomainException 
	 */
	@Test
	void testGetUser_nombreCorrecto2() throws DomainException {
		usuario.setUser_nombre(NOMBRE_CORRECTO_ALFANUMERICO);
		assertEquals(NOMBRE_CORRECTO_ALFANUMERICO, usuario.getUser_nombre());
	}
	
	/**
	 * Test que comprueba que lanza excepción el método setUser_nombre
	 *  con nombre que contiene caracteres especiales
	 * @throws DomainException 
	 */
	@Test
	void testGetUser_nombreIncorrectoSpecialChars() throws DomainException {
		assertThrows(DomainException.class,
	            () -> { usuario.setUser_nombre(NOMBRE_INCORRECTO_SPECIALCHARS);});
	}
	
	/**
	 * Test que comprueba que lanza excepción el método setUser_nombre
	 *  con nombre que no cumple longitud minima
	 * @throws DomainException 
	 */
	@Test
	void testGetUser_nombreIncorrectoLongMin() throws DomainException {
		assertThrows(DomainException.class,
	            () -> { usuario.setUser_nombre(NOMBRE_INCORRECTO_LONGITUD_MIN);});
	}

	/**
	 * Test que comprueba que lanza excepción el método setUser_nombre
	 *  con nombre nulo
	 * @throws DomainException 
	 */
	@Test
	void testGetUser_nombreIncorrectoNulo() throws DomainException {
		assertThrows(DomainException.class,
	            () -> { usuario.setUser_nombre(NOMBRE_NULO);});
	}

	/**
	 * Test que comprueba que lanza excepción el método setUser_nombre
	 *  con nombre vacio
	 * @throws DomainException 
	 */
	@Test
	void testGetUser_nombreIncorrectoVacio() throws DomainException {
		assertThrows(DomainException.class,
	            () -> { usuario.setUser_nombre(NOMBRE_VACIO);});
	}

	/**
	 * Test que comprueba que lanza excepción el método setUser_nombre
	 *  con nombre espacio en blanco
	 * @throws DomainException 
	 */
	@Test
	void testGetUser_nombreIncorrectoWhiteSpace() throws DomainException {
		assertThrows(DomainException.class,
	            () -> { usuario.setUser_nombre(NOMBRE_WHITESPACE);});
	}


	/**
	 * Test que comprueba que se lanza excepción si se intenta
	 * modificar el atributo email con una cadena con espacios en blanco
	 */
	@Test
	void testGetUser_emailErrorWhiteSpaces() {
		assertThrows(DomainException.class,
	            () -> { usuario.setUser_email(EMAIL_ERROR_WHITESPACE);});
	}
	
	/**
	 * Test que comprueba que se lanza excepción si se intenta
	 * modificar el atributo email con un nulo
	 */
	@Test
	void testGetUser_emailErrorNulo() {
		assertThrows(DomainException.class,
	            () -> { usuario.setUser_email(EMAIL_NULO);});
	}

	/**
	 * Test que comprueba que se lanza excepción si se intenta
	 * modificar el atributo email con un vacio
	 */
	@Test
	void testGetUser_emailErrorVacio() {
		assertThrows(DomainException.class,
	            () -> { usuario.setUser_email(EMAIL_VACIO);});
	}
	
	/**
	 * Test que comprueba que se lanza excepción si se intenta
	 * modificar el atributo email con un email que no cumple
	 * el pattern en la primera parte del mail (antes del @)
	 */
	@Test
	void testGetUser_emailErrorPattern1() {
		assertThrows(DomainException.class,
	            () -> { usuario.setUser_email(EMAIL_ERROR);});
	}
	
	/**
	 * Test que comprueba que se lanza excepción si se intenta
	 * modificar el atributo email con un email que no cumple
	 * el pattern en la segunda parte del mail (después del @)
	 */
	@Test
	void testGetUser_emailErrorPattern2() {
		assertThrows(DomainException.class,
	            () -> { usuario.setUser_email(EMAIL_ERROR1);});
	}
	
	/**
	 * Test que comprueba que se lanza excepción si se intenta
	 * modificar el atributo email con un email que no cumple
	 * el pattern en el final del mail, después del punto
	 */
	@Test
	void testGetUser_emailErrorFinal() {
		assertThrows(DomainException.class,
	            () -> { usuario.setUser_email(EMAIL_ACABA_ERROR);});
	}
	
	/**
	 * Test que comprueba que realiza bien la modificación
	 * del email si se introduce un mail válido que cumple el patrón
	 * @throws DomainException 
	 */
	@Test
	void testSetUser_email() throws DomainException {
		usuario.setUser_email(EMAIL_CORRECTO);
		assertEquals(EMAIL_CORRECTO, usuario.getUser_email());
	}
	
	/**
	 * Test que comprueba que realiza bien la modificación
	 * de la contraseña si se introduce una válida que cumple el patrón
	 * @throws DomainException  
	 */
	@Test
	void testGetUser_pass() throws DomainException {
		usuario.setUser_pass(PSWD_CORRECTA);
		assertEquals(PSWD_CORRECTA, usuario.getUser_pass());
	}
	
	/**
	 * Test que comprueba que se lanza excepción si se intenta
	 * modificar el atributo pswd con espacio en blanco
	 */
	@Test
	void testSetUser_passErrorWhiteSpace() {
		assertThrows(DomainException.class,
	            () -> { usuario.setUser_pass(PSWD_ERROR_WITESPACE);});
	}
	
	/**
	 * Test que comprueba que se lanza excepción si se intenta
	 * modificar el atributo pswd con nulo
	 */
	@Test
	void testSetUser_passErrorNulo() {
		assertThrows(DomainException.class,
	            () -> { usuario.setUser_pass(PSWD_ERROR_NULO);});
	}
	
	/**
	 * Test que comprueba que se lanza excepción si se intenta
	 * modificar el atributo pswd con vacio
	 */
	@Test
	void testSetUser_passErrorVacio() {
		assertThrows(DomainException.class,
	            () -> { usuario.setUser_pass(PSWD_ERROR_VACIO);});
	}
	
	/**
	 * Test que comprueba que se lanza excepción si se intenta
	 * modificar el atributo pswd con una que no cumpla
	 * la longitud minima
	 */
	@Test
	void testSetUser_passErrorLongMin() {
		assertThrows(DomainException.class,
	            () -> { usuario.setUser_pass(PSWD_ERROR_MIN);});
	}
	
	/**
	 * Test que comprueba que se lanza excepción si se intenta
	 * modificar el atributo pswd con una que sobrepasa
	 * la longitud máxima
	 */
	@Test
	void testSetUser_passErrorLongMax() {
		assertThrows(DomainException.class,
	            () -> { usuario.setUser_pass(PSWD_ERROR_MAX);});
	}
	
	/**
	 * Test que comprueba que se lanza excepción si se intenta
	 * modificar el atributo pswd con una que no cumple el pattern
	 */
	@Test
	void testSetUser_passError2() {
		assertThrows(DomainException.class,
	            () -> { usuario.setUser_pass(PSWD_ERROR2);});
	}

	/**
	 * Test que comprueba que el método get devuelve el valor correcto
	 * para el método set
	 */
	@Test
	void testGetUser_tipo() {
		usuario.setUser_tipo(TIPO_CORRECTO);
		assertEquals(TIPO_CORRECTO, usuario.getUser_tipo());
	}

	/**
	 * Test que comprueba que el método modifcador del dni
	 * devuelve con el get el valor indicado
	 * @throws DomainException 
	 */
	@Test
	void testGetUser_dni() throws DomainException {
		usuario.setUser_dni(DNI_CORRECTO);
		assertEquals(DNI_CORRECTO, usuario.getUser_dni());
	}

	/**
	 * Test que comprueba que se lanza excepción si se intenta
	 * modificar el atributo email con una que no cumple el pattern
	 */
	@Test
	void testSetUser_dniErrorPattern() {
		assertThrows(DomainException.class,
	            () -> { usuario.setUser_dni(DNI_ERROR);});
	}
	
	/**
	 * Test que comprueba que se lanza excepción si se intenta
	 * modificar el atributo email con una que no cumple el pattern
	 * porque utiliza al final un número en lugar de una letra
	 */
	@Test
	void testSetUser_dniErrorLetraNum() {
		assertThrows(DomainException.class,
	            () -> { usuario.setUser_dni(DNI_ERROR_LETRA);});
	}
	
	/**
	 * Test que comprueba que se lanza excepción si se intenta
	 * modificar el atributo email con una que no cumple el pattern
	 * porque utiliza una letra que no corresponde al número
	 */
	@Test
	void testSetUser_dniErrorLetra() {
		assertThrows(DomainException.class,
	            () -> { usuario.setUser_dni(DNI_ERROR_LETRA_MAL_CALCULADA);});
	}
	
	/**
	 * Test que comprueba que se lanza excepción si se intenta
	 * modificar el atributo email con una que no cumple el pattern
	 * porque tiene una longitud no permitida
	 */
	@Test
	void testSetUser_dniErrorLongitud() {
		assertThrows(DomainException.class,
	            () -> { usuario.setUser_dni(DNI_ERROR_LONGITUD);});
	}
	
	/**
	 * Test que comprueba que se lanza excepción si se intenta
	 * modificar el atributo email con uno nulo
	 */
	@Test
	void testSetUser_dniErrorNulo() {
		assertThrows(DomainException.class,
	            () -> { usuario.setUser_dni(DNI_NULO);});
	}
	
	/**
	 * Test que comprueba que se lanza excepción si se intenta
	 * modificar el atributo email con uno vacio
	 */
	@Test
	void testSetUser_dniErrorVacio() {
		assertThrows(DomainException.class,
	            () -> { usuario.setUser_dni(DNI_VACIO);});
	}
	
	/**
	 * Test que comprueba que la fecha de alta es correcta, 
	 * que el metodo get arroja el mismo resultado que el set
	 */
	@Test
	void testGetUser_fecAlta() {
		usuario.setUser_fecAlta(FECHA);
		assertEquals(FECHA, usuario.getUser_fecAlta());
	}

	/**
	 * Test que comprueba que la fecha de modificación es correcta, 
	 * que el metodo get arroja el mismo resultado que el set
	 */
	@Test
	void testGetUser_fecConfirmacion() {
		usuario.setUser_fecConfirmacion(FECHA_MODIFICACION);
		assertEquals(FECHA_MODIFICACION, usuario.getUser_fecConfirmacion());
	}

}
