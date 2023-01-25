package banco.clases;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import banco.util.ErrorFiltro;

class CreditoTest {
	final LocalDate FECHACADUCIDAD = LocalDate.of(2025, 12, 25);
	final LocalDate FECHAACTUAL = LocalDate.now();
	final String NUMCUENTA = "12234";
	final String NOMBRECUENTA = "Cristian heiwownppwjw";
	final double INGRESO = 30d;
	final double INGRESONEG = -2d;
	final double INGRESO2 = 10d;
	final double RETIRAR = 20d;
	final double RETIRAREXCEPCION = 2000d;
	final double SALDOINICIAL = 1000d;
	final String CONCEPTO = "jbflhlgs";
	final double COMISION = 3d;
	final double RETIRARCOMISION = 30d;
	 
	Tarjeta credito;
	Cuenta cuenta;
	Movimiento movimiento;

	@BeforeEach
	void inicio() throws ErrorFiltro {
		creacion();
	}
	
	@Test
	void creacion() throws ErrorFiltro {
		credito = new Credito(FECHACADUCIDAD, NUMCUENTA, NOMBRECUENTA, SALDOINICIAL);
		cuenta = new Cuenta(NUMCUENTA, NOMBRECUENTA);
		
		credito.setCuenta(cuenta);
	}
	
	@Test
	void testGetSaldo() throws Exception {
		credito.ingresar(INGRESO);
		credito.ingresar(INGRESO2);
		assertEquals(INGRESO + INGRESO2, credito.getSaldo());
	}

	@Test
	void testIngresar() throws Exception {
		credito.ingresar(INGRESO);
		assertEquals(INGRESO, credito.getSaldo());		
	}
	
	@Test
	void testPagoEnEstablecimientoExceso() throws Exception {
		credito.pagoEnEstablecimiento(CONCEPTO, RETIRAREXCEPCION);
		assertEquals(SALDOINICIAL, ((Credito) credito).getCreditoDisponible());
	}
	
	@Test
	void testPagoEnEstablecimiento() throws Exception {
		credito.pagoEnEstablecimiento(CONCEPTO, RETIRAR);
		assertEquals(RETIRAR, SALDOINICIAL - ((Credito) credito).getCreditoDisponible());
	}

	@Test
	void testRetirar() throws Exception {
		credito.retirar(RETIRARCOMISION);
		assertEquals(SALDOINICIAL - (RETIRARCOMISION + COMISION), ((Credito) credito).getCreditoDisponible());
	}


	@Test
	void testGetCreditoDisponible() {
		assertEquals(SALDOINICIAL, ((Credito) credito).getCreditoDisponible());
	}
	
	@Test
	void testLiquidar() throws Exception {
		credito.retirar(RETIRAR);
		credito.retirar(RETIRARCOMISION);
		((Credito) credito).liquidar(FECHAACTUAL.getMonthValue(), FECHAACTUAL.getYear());
		assertEquals(0d, credito.getSaldo());
	}

}
