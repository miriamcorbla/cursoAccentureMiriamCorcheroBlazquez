package banco.clases;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MovimientoTest {
	Movimiento movimiento;
	final static double IMPORTE = 10000.0;
	final static String CONCEPTO = "CONCEPTO DE PRUEBA";
	final static LocalDate FECHA = LocalDate.now();
	
	@BeforeEach
	void creacion() {
		movimiento = new Movimiento();
	}
	@Test
	void testConcepto() {
		movimiento.setmConcepto(CONCEPTO);
		assertEquals(CONCEPTO, movimiento.getmConcepto());
	}

	@Test
	void testGetmFecha() {
		assertEquals(FECHA, movimiento.getmFecha());
	}

	@Test
	void testSetmFecha() {
		LocalDate actual = LocalDate.now();
		movimiento.setmFecha(actual);
	}

	@Test
	void testGetmImporte() {
		movimiento.setmImporte(IMPORTE);
		assertEquals(IMPORTE, movimiento.getmImporte());
	}

	@Test
	void testMovimiento() {
		Movimiento m = movimiento;
		assertEquals(m, movimiento);
	}

}
