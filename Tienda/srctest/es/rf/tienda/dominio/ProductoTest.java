package es.rf.tienda.dominio;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.rf.tienda.exception.DomainException;

class ProductoTest {
	
	Producto producto;
	static final String ID_CORRECTO = "DS200";
	static final String ID_INCORRECTO = "12DS1";
	static final String ID_INCORRECTO_LETRAS = "DSDSD";
	static final String ID_INCORRECTO_LONGITUD = "DS1";
	static final String ID_INCORRECTO_WHITESPACE = " DS 3 1 3";
	static final String ID_INCORRECTO_ONLY_WHITESPACE = " ";
	
	static final String DESCR_CORRECTA = "Esto es una descripcion corta";
	static final String DESCR_INCORRECTA_LONGITUD = "Esto";
	static final String DESCR_SPECIALCHARS = "Esto es una descripcion corta *";
	
	static final double PRECIO_CORRECTO = 23.23;
	static final double PRECIO_INCORRECTO = 23.2323;
	
	static final int STOCK_CORRECTO = 3219;
	
	static final LocalDate FECHA_CORRECTA = LocalDate.of(2024, 2, 2);
	static final LocalDate FECHA_CORRECTA2 = LocalDate.of(2025, 2, 2);
	static final LocalDate FECHA_ACTUAL = LocalDate.now();
	static final LocalDate FECHA_ERROR = LocalDate.of(2022, 2, 2);
	
	static final String DESCR_UNIDAD_VENTA_CORRECTO = "Cadena10";
	static final String DESCR_UNIDAD_VENTA_INCORR_LONG_MIN = "Cad";
	static final String DESCR_UNIDAD_VENTA_INCORR_LONG_MIN2 = "";
	static final String DESCR_UNIDAD_VENTA_INCORR_LONG_MAX = "Cadenasuperiorentre1y10";
	
	static final double CANT_UNULT = 43.12;
	
	static final String DESCR_UNIDAD_ULT_CORRECTO = "Cadena 10";

	static final int ID_PAIS_CORRECTO = 3;
	
	static final String USO_RECOM_CORRECTO = "Esto es un uso recomendado";
	static final String USO_RECOM_CORRECTO_VACIO = "   ";
	
	static final int CATEGORIA_STOCK_CORRECTA = 5;
	
	static final char ESTADO_CORRECTO = 'A';
	static final char ESTADO_CORRECTO2 = 'B';
	static final char ESTADO_INCORRECTO = 'C';
	
	@BeforeEach
	void inicio() throws DomainException {
		creacion();
	}
	
	@Test
	void creacion() throws DomainException {
		producto = new Producto();
	}

	/**
	 * Comprueba que tanto el set como el get funcionan correctamente
	 * al añadir un id de producto correcto
	 * @throws DomainException
	 */
	@Test
	void testSetId_producto() throws DomainException {
		producto.setId_producto(ID_CORRECTO);
		assertEquals(ID_CORRECTO, producto.getId_producto());
	}
	
	/**
	 * Comprueban que se lanza una excepción al introducir un id
	 * incorrecto que no cumple con el pattern
	 * @throws DomainException
	 */
	@Test
	void testGetId_productoErrorPattern() throws DomainException {
		assertThrows(DomainException.class,
	            () -> { producto.setId_producto(ID_INCORRECTO_LETRAS);});
	}
	
	/**
	 * Comprueban que se lanza una excepción al introducir un id
	 * incorrecto que no cumple con la longitud
	 * @throws DomainException
	 */
	@Test
	void testGetId_productoErrorLongitud() throws DomainException {
		assertThrows(DomainException.class,
	            () -> { producto.setId_producto(ID_INCORRECTO_LONGITUD);});
	}
	
	/**
	 * Comprueban que se lanza una excepción al introducir un id
	 * incorrecto que contiene espacios en blanco
	 * @throws DomainException
	 */
	@Test
	void testGetId_productoErrorWhiteSpace() throws DomainException {
		assertThrows(DomainException.class,
	            () -> { producto.setId_producto(ID_INCORRECTO_WHITESPACE);});
	}
	
	/**
	 * Comprueban que se lanza una excepción al introducir un id
	 * incorrecto que contiene solo un espacio en blanco
	 * @throws DomainException
	 */
	@Test
	void testGetId_productoErrorOnlyWhiteSpace() throws DomainException {
		assertThrows(DomainException.class,
	            () -> { producto.setId_producto(ID_INCORRECTO_ONLY_WHITESPACE);});
	}

	/**
	 * Comprueba que tanto el set como el get funcionan correctamente
	 * al añadir una descripción correcta
	 * @throws DomainException
	 */
	@Test
	void testGetPro_descripcion() throws DomainException {
		producto.setPro_descripcion(ID_CORRECTO);
		assertEquals(ID_CORRECTO, producto.getPro_descripcion());
	}
	
	/**
	 * Comprueban que se lanza una excepción al introducir una descripción
	 * que no cumple con la longitud mínima
	 * @throws DomainException
	 */
	@Test
	void testGetPro_descripcionErrorLongitudMin() throws DomainException {
		assertThrows(DomainException.class,
	            () -> { producto.setPro_descripcion(DESCR_INCORRECTA_LONGITUD);});
	}
	
	/**
	 * Comprueban que se lanza una excepción al introducir una descripción
	 * que contiene caracteres especiales
	 * @throws DomainException
	 */
	@Test
	void testGetPro_descripcionErrorSpecialChars() throws DomainException {
		assertThrows(DomainException.class,
	            () -> { producto.setPro_descripcion(DESCR_SPECIALCHARS);});
	}

	/**
	 * Comprueba que tanto el set como el get funcionan correctamente
	 * al añadir una descripción correcta
	 * @throws DomainException
	 */
	@Test
	void testGetPro_desLarga() throws DomainException {
		producto.setPro_desLarga(DESCR_CORRECTA);
		assertEquals(DESCR_CORRECTA, producto.getPro_desLarga());
	}
	
	/**
	 * Comprueban que se lanza una excepción al introducir una descripción
	 * que no cumple con la longitud mínima
	 * @throws DomainException
	 */
	@Test
	void testGetPro_descripcionLargaErrorLongitudMin() throws DomainException {
		assertThrows(DomainException.class,
	            () -> { producto.setPro_desLarga(DESCR_INCORRECTA_LONGITUD);});
	}
	
	/**
	 * Comprueban que se lanza una excepción al introducir una descripción
	 * que contiene caracteres especiales
	 * @throws DomainException
	 */
	@Test
	void testGetPro_descripcionLArgaErrorSpecialChars() throws DomainException {
		assertThrows(DomainException.class,
	            () -> { producto.setPro_desLarga(DESCR_SPECIALCHARS);});
	}

	/**
	 * Comprueba que tanto el set como el get funcionan correctamente
	 * al añadir un precio correcto
	 * @throws DomainException
	 */
	@Test
	void testGetPro_precio() throws DomainException {
		producto.setPro_precio(PRECIO_CORRECTO);
		assertEquals(PRECIO_CORRECTO, producto.getPro_precio());
	}
	
	/**
	 * Comprueban que se lanza una excepción al introducir un precio que no cumple
	 * con la especificación decimal
	 * @throws DomainException
	 */
	@Test
	void testGetPro_precioErrorDecimales() throws DomainException {
		assertThrows(DomainException.class,
	            () -> { producto.setPro_precio(PRECIO_INCORRECTO);});
	}

	/**
	 * Comprueba que tanto el set como el get funcionan correctamente
	 * al añadir un stock correcto
	 */
	@Test
	void testGetPro_stock() {
		producto.setPro_stock(STOCK_CORRECTO);
		assertEquals(STOCK_CORRECTO, producto.getPro_stock());
	}

	/**
	 * Comprueba que tanto el set como el get funcionan correctamente
	 * al añadir una fecha correcta
	 * @throws DomainException 
	 */
	@Test
	void testGetPro_fecRepos() throws DomainException {
		producto.setPro_fecRepos(FECHA_CORRECTA);
		assertEquals(FECHA_CORRECTA, producto.getPro_fecRepos());
	}
	
	/**
	 * Comprueba que tanto el set como el get funcionan correctamente
	 * al añadir una fecha correcta
	 * @throws DomainException 
	 */
	@Test
	void testGetPro_fecReposActual() throws DomainException {
		producto.setPro_fecRepos(FECHA_ACTUAL);
		assertEquals(FECHA_ACTUAL, producto.getPro_fecRepos());
	}
	
	/**
	 * Comprueban que se lanza una excepción al introducir una fecha anterior
	 * al dia de hoy
	 * @throws DomainException
	 */
	@Test
	void testGetPro_fecReposActualErrorFecha() throws DomainException {
		assertThrows(DomainException.class,
	            () -> { producto.setPro_fecRepos(FECHA_ERROR);});
	}

	/**
	 * Comprueba que tanto el set como el get funcionan correctamente
	 * al añadir una fecha correcta
	 * @throws DomainException 
	 */
	@Test
	void testGetPro_fecActi() throws DomainException {
		producto.setPro_fecActi(FECHA_ACTUAL);
		assertEquals(FECHA_ACTUAL, producto.getPro_fecActi());
	}
	
	/**
	 * Comprueba que tanto el set como el get funcionan correctamente
	 * al añadir una fecha correcta
	 * @throws DomainException 
	 */
	@Test
	void testGetPro_fecActiActual() throws DomainException {
		producto.setPro_fecActi(FECHA_ACTUAL);
		assertEquals(FECHA_ACTUAL, producto.getPro_fecActi());
	}
	
	/**
	 * Comprueban que se lanza una excepción al introducir una fecha anterior
	 * al dia de hoy
	 * @throws DomainException
	 */
	@Test
	void testGetPro_fecActiActualErrorFecha() throws DomainException {
		assertThrows(DomainException.class,
	            () -> { producto.setPro_fecActi(FECHA_ERROR);});
	}

	/**
	 * Comprueba que tanto el set como el get funcionan correctamente
	 * al añadir una fecha correcta
	 * @throws DomainException 
	 */
	@Test
	void testGetPro_fecDesacti() throws DomainException {
		producto.setPro_fecDesacti(FECHA_CORRECTA);
		assertEquals(FECHA_CORRECTA, producto.getPro_fecDesacti());
	}
	
	/**
	 * Comprueba que tanto el set como el get funcionan correctamente
	 * al añadir una fecha correcta
	 * @throws DomainException 
	 */
	@Test
	void testGetPro_fecDesactiActual() throws DomainException {
		producto.setPro_fecDesacti(FECHA_ACTUAL);
		assertEquals(FECHA_ACTUAL, producto.getPro_fecDesacti());
	}
	
	/**
	 * Comprueba que tanto el set como el get funcionan correctamente
	 * al añadir una fecha correcta
	 * @throws DomainException 
	 */
	@BeforeAll
	static void testGetPro_fecDesactiConActivacionPrevia() throws DomainException {
		Producto producto = new Producto();
		producto.setPro_fecActi(FECHA_CORRECTA);
		producto.setPro_fecDesacti(FECHA_CORRECTA2);
		assertEquals(FECHA_CORRECTA2, producto.getPro_fecDesacti());
	}
	
	/**
	 * Comprueban que se lanza una excepción al introducir una fecha anterior
	 * al dia de hoy
	 * @throws DomainException
	 */
	@Test
	void testGetPro_fecDesactiActualErrorFecha() throws DomainException {
		assertThrows(DomainException.class,
	            () -> { producto.setPro_fecDesacti(FECHA_ERROR);});
	}

	/**
	 * Comprueba que tanto el set como el get funcionan correctamente
	 * al añadir una unidad de venta correcta
	 * @throws DomainException 
	 */
	@Test
	void testGetPro_uniVenta() throws DomainException {
		producto.setPro_uniVenta(DESCR_UNIDAD_VENTA_CORRECTO);
		assertEquals(DESCR_UNIDAD_VENTA_CORRECTO, producto.getPro_uniVenta());
	}
	
	/**
	 * Comprueban que se lanza una excepción al introducir una cadena
	 * que no cumple con la longitud mínima
	 * @throws DomainException
	 */
	@Test
	void testGetPro_uniVentaErrorLongMin() throws DomainException {
		assertThrows(DomainException.class,
	            () -> { producto.setPro_uniVenta(DESCR_UNIDAD_VENTA_INCORR_LONG_MIN2);});
	}
	
	/**
	 * Comprueban que se lanza una excepción al introducir una cadena
	 * que no cumple con la longitud máxima
	 * @throws DomainException
	 */
	@Test
	void testGetPro_uniVentaErrorLongMax() throws DomainException {
		assertThrows(DomainException.class,
	            () -> { producto.setPro_uniVenta(DESCR_UNIDAD_VENTA_INCORR_LONG_MAX);});
	}

	/**
	 * Comprueba que tanto el set como el get funcionan correctamente
	 * al añadir un doble correcto
	 * @throws DomainException
	 */
	@Test
	void testGetPro_cantXUniVenta() throws DomainException {
		producto.setPro_cantXUniVenta(CANT_UNULT);
		assertEquals(CANT_UNULT, producto.getPro_cantXUniVenta());
	}
	
	/**
	 * Comprueba que tanto el set como el get funcionan correctamente
	 * al añadir una ult unidad correcta
	 * @throws DomainException
	 */
	@Test
	void testGetPro_uniUltNivel() throws DomainException {
		producto.setPro_uniUltNivel(DESCR_UNIDAD_VENTA_CORRECTO);
		assertEquals(DESCR_UNIDAD_VENTA_CORRECTO, producto.getPro_uniUltNivel());
	}

	/**
	 * Comprueba que tanto el set como el get funcionan correctamente
	 * al añadir el id del pais
	 * @throws DomainException
	 */
	@Test
	void testGetId_pais() {
		producto.setId_pais(ID_PAIS_CORRECTO);
		assertEquals(ID_PAIS_CORRECTO, producto.getId_pais());
	}

	/**
	 * Comprueba que tanto el set como el get funcionan correctamente
	 * al añadir el uso recomendado
	 * @throws DomainException
	 */
	@Test
	void testGetPro_usoRecomendado() throws DomainException {
		producto.setPro_usoRecomendado(USO_RECOM_CORRECTO);
		assertEquals(USO_RECOM_CORRECTO, producto.getPro_usoRecomendado());
	}
	
	/**
	 * Comprueba que tanto el set como el get funcionan correctamente
	 * al añadir la categoría correcta
	 * @throws DomainException
	 */
	@Test
	void testGetId_categoria() throws DomainException {
		producto.setId_categoria(CATEGORIA_STOCK_CORRECTA);
		assertEquals(CATEGORIA_STOCK_CORRECTA, producto.getId_categoria());
	}
	
	/**
	 * Comprueba que tanto el set como el get funcionan correctamente
	 * al añadir el stock reservado correcto
	 * @throws DomainException
	 */
	@Test
	void testGetPro_stkReservado() throws DomainException {
		producto.setPro_stkReservado(CATEGORIA_STOCK_CORRECTA);
		assertEquals(CATEGORIA_STOCK_CORRECTA, producto.getPro_stkReservado());
	}
	
	/**
	 * Comprueba que tanto el set como el get funcionan correctamente
	 * al añadir el stock para nivel aalto correcto
	 * @throws DomainException
	 */
	@Test
	void testGetPro_nStkAlto() throws DomainException {
		producto.setPro_nStkAlto(CATEGORIA_STOCK_CORRECTA);
		assertEquals(CATEGORIA_STOCK_CORRECTA, producto.getPro_nStkAlto());
	}

	/**
	 * Comprueba que tanto el set como el get funcionan correctamente
	 * al añadir el stock para nivel aalto correcto
	 * @throws DomainException
	 */
	@Test
	void testGetPro_nStkBajo() {
		producto.setPro_nStkBajo(CATEGORIA_STOCK_CORRECTA);
		assertEquals(CATEGORIA_STOCK_CORRECTA, producto.getPro_nStkBajo());
	}

	/**
	 * Comprueba que tanto el set como el get funcionan correctamente
	 * al añadir el estado correcto
	 * @throws DomainException
	 */
	@Test
	void testGetPro_stat() throws DomainException {
		producto.setPro_stat(ESTADO_CORRECTO);
		assertEquals(ESTADO_CORRECTO, producto.getPro_stat());
	}
	
	/**
	 * Comprueba que tanto el set como el get funcionan correctamente
	 * al añadir el estado correcto
	 * @throws DomainException
	 */
	@Test
	void testGetPro_stat2() throws DomainException {
		producto.setPro_stat(ESTADO_CORRECTO2);
		assertEquals(ESTADO_CORRECTO2, producto.getPro_stat());
	}
	
	/**
	 * Comprueban que se lanza una excepción al introducir un estado
	 * incorrecto
	 * @throws DomainException
	 */
	@Test
	void testGetPro_statError() throws DomainException {
		assertThrows(DomainException.class,
	            () -> { producto.setPro_stat(ESTADO_INCORRECTO);});
	}

}
