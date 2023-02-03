package banco.util;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class FiltrosTest {
	
	static final String TITULAR = "";
	static final String TITULAR1 = "Este titular es de 21";
	static final String TITULAR2 = "Este";
	static final String TITULAR3 = "Este es un";
	static final int ANIOMAX = 5;
	static final int ANIOMIN = 3;
	static final LocalDate FECHA = LocalDate.now();
	static final LocalDate FECHA1 = LocalDate.of(2000, 12, 21);
	static final LocalDate FECHA2 = LocalDate.of(2029, 12, 12);
	static final LocalDate FECHA3 = LocalDate.of(2026, 10, 5);
	static final LocalDate FECHA4 = LocalDate.of(2025, 8, 7);
	static final LocalDate FECHA5 = null;
	static final String FECHA_CORRECTA_DEFECTO = "30-01-2022";
	static final LocalDate FECHA_CORRECTA_DEFECTO_LD = LocalDate.of(2022, 01, 30);
	static final String FECHA_CORRECTA_BARRAS = "30/01/2022";
	static final String FECHA_INCORRECTA =  "30.01.2022";
	static final String FORMATO_CORRECTO2 = "dd/MM/yyyy";
	static final int SALDO_POSITIVO = 30;
	static final int SALDO_NEGATIVO = -20;
	static final int SALDO_ACTUAL = 50;
	static final int SALDO_ACTUAL_ERROR = 10;
	
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
	 * Test para formato.
	 */
	@Test
	void testFiltroFormatoFechaPorDefecto() {
		LocalDate fecha = Filtros.fechaFormatoCorrecto(FECHA_CORRECTA_DEFECTO); 
		assertEquals(FECHA_CORRECTA_DEFECTO_LD, fecha);
	}
	
	/**
	 * Test para fecha con formato barras
	 */
	@Test
	void testFiltroFormatoFechaBarras() {
		LocalDate fecha = Filtros.fechaFormatoCorrecto(FECHA_CORRECTA_BARRAS, FORMATO_CORRECTO2);
		assertEquals(FECHA_CORRECTA_DEFECTO_LD, fecha);
	}
	
	/**
	 * Test para fecha con formato incorrecto.
	 */
	@Test
	void testFiltroFormatoFechaError() {
		LocalDate fecha = Filtros.fechaFormatoCorrecto(FECHA_INCORRECTA);
		assertNotEquals(FECHA_CORRECTA_DEFECTO_LD, fecha);
	}
	
	
	/**
	 * Test para saldo positivo
	 */
	@Test
	void testSaldoPositivo() {
		assertTrue(Filtros.esSaldoPositivo(SALDO_POSITIVO));
	}
	
	/**
	 * Tes para comprobar que si introduce un saldo negativo 
	 * el resultado que arroja es false
	 */
	@Test
	void testSaldoPositivoError() {
		assertFalse(Filtros.esSaldoPositivo(SALDO_NEGATIVO));
	}
	
	/**
	 * Tes para comprobar que hay saldo suficiente
	 * para retirar dicha cantidad de dinero
	 */
	@Test
	void testSaldoSuficiente() {
		assertTrue(Filtros.haySaldoSuficiente(SALDO_POSITIVO, SALDO_ACTUAL));
	}
	
	/**
	 * Tes para comprobar que arroja resultado falso dado una
	 * cantidad a retirar mayor que el saldo disponible en la cuenta
	 */
	@Test
	void testSaldoSuficienteError() {
		assertFalse(Filtros.haySaldoSuficiente(SALDO_POSITIVO, SALDO_ACTUAL_ERROR));
	}

}
