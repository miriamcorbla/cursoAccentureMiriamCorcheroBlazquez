package banco.util;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class FiltrosTest {
	
	final static String TITULAR = "";
	final static String TITULAR1 = "Este titular es de 21";
	final static String TITULAR2 = "Este";
	final static String TITULAR3 = "Este es un";
	final static int ANIOMAX = 2026;
	final static int ANIOMIN = 2023;
	final static LocalDate FECHA = LocalDate.now();
	final static LocalDate FECHA1 = LocalDate.of(2000, 12, 21);
	final static LocalDate FECHA2 = LocalDate.of(2027, 12, 12);
	final static LocalDate FECHA3 = LocalDate.of(2026, 10, 5);
	final static LocalDate FECHA4 = LocalDate.of(2025, 8, 7);
	final static LocalDate FECHA5 = null;
	final static String FECHACORRECTADEFECTO = "30-01-22";
	final static String FECHACORRECTABARRAS = "30/01/22";
	final static String FECHAINCORRECTA =  "30.01.22";
	final static String FECHAINCORRECTA2 = "estoNoEsUnFormato";
	
	/**
	 * Vamos a comprobar que el titular de 21 no es correcto
	 * si el tam max es 20. Si no es correcto, pasa el test
	 */
	@Test
	void testFiltroTextoPasa20() {
		assertFalse(Filtros.filtroTexto(TITULAR1, 20, 10)); //Si es falso pasa el test
	}
	
	@Test
	void testFiltroTextoPasa21() {
		assertTrue(Filtros.filtroTexto(TITULAR1, 21, 10)); //Si es verdadero pasa el test
	}
	
	@Test
	void testFiltroTextoPasa50() {
		assertTrue(Filtros.filtroTexto(TITULAR1, 50, 10));
	}
	
	/**
	 * Comprobamos ahora que no llegua al mínimo de caracteres permitido. Si no llega, pasa el test
	 */
	@Test
	void testFiltroTextoPasa5() {
		assertFalse(Filtros.filtroTexto(TITULAR2, 20, 10));
	}
	
	/**
	 * Comprobamos que es justo el mínimo
	 */
	@Test
	void testFiltroTextoPasa10() {
		assertTrue(Filtros.filtroTexto(TITULAR3, 20, 10));
	}

	/**
	 * Y si recibe un String vacio?
	 */
	@Test
	void testFiltroTextoPasaVacio() {
		assertFalse(Filtros.filtroTexto(TITULAR, 20, 10));
	}
	
	/**
	 * Fecha actual que coincide con año min
	 */
	@Test
	void testFiltroFechaActual() {
		assertTrue(Filtros.filtroFechaAnio(FECHA, ANIOMAX, ANIOMIN));
	}
	/**
	 * Fecha pasada
	 */
	@Test
	void testFiltroFechaPasada() {
		assertFalse(Filtros.filtroFechaAnio(FECHA1, ANIOMAX, ANIOMIN));
	}
	/**
	 * Fecha Futura
	 */
	@Test
	void testFiltroFechaFutura() {
		assertFalse(Filtros.filtroFechaAnio(FECHA2, ANIOMAX, ANIOMIN));
	}
	/**
	 * Fecha justo en año max
	 */
	@Test
	void testFiltroFechaJusta() {
		assertTrue(Filtros.filtroFechaAnio(FECHA3, ANIOMAX, ANIOMIN));
	}
	/**
	 * Fecha en medio de los años min y max
	 */
	@Test
	void testFiltroFechaMedia() {
		assertTrue(Filtros.filtroFechaAnio(FECHA4, ANIOMAX, ANIOMIN));
	}
	/**
	 * Fecha nula
	 */
	@Test
	void testFiltroFechaNula() {
		assertFalse(Filtros.filtroFechaAnio(FECHA5, ANIOMAX, ANIOMIN));
	}
	
	/**
	 * Test para formato. AUN POR TERMINAR!!!!
	 */
	@Test
	void testFiltroFormatoFechaPorDefecto() {
		assertEquals(FECHACORRECTADEFECTO, Filtros.fechaFormatoCorrecto(FECHACORRECTADEFECTO));
	}
	
	@Test
	void testFiltroFormatoFechaBarras() {
		assertEquals(FECHACORRECTABARRAS, Filtros.fechaFormatoCorrecto(FECHACORRECTABARRAS, "dd/mm/yyyy"));
	}
	

}
