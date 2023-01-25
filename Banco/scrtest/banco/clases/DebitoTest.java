package banco.clases;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import banco.util.ErrorFiltro;

class DebitoTest {
	
	final LocalDate FECHACADUCIDAD = LocalDate.of(2025, 12, 25);
	final LocalDate FECHAACTUAL = LocalDate.now();
	final String NUMCUENTA = "12234";
	final String NOMBRECUENTA = "Cristian heiwownppwjw";
	final double INGRESO = 30d;
	final double INGRESONEG = -2d;
	final double INGRESO2 = 10d;
	final double RETIRAR = 20d;
	
	Cuenta cuenta;
	Tarjeta debito;
	
	@BeforeEach
	void inicio() throws ErrorFiltro {
		creacion();
	}
	
	@Test
	void creacion() throws ErrorFiltro {
		debito = new Debito(FECHACADUCIDAD, NUMCUENTA, NOMBRECUENTA);
		cuenta = new Cuenta(NUMCUENTA, NOMBRECUENTA);
		debito.setCuenta(cuenta);
	}

	@Test
	void testGetSaldo() throws Exception {
		debito.ingresar(INGRESO);
		assertEquals(INGRESO, debito.getSaldo());
	}

	@Test
	void testIngresar() throws Exception {
		debito.ingresar(INGRESO);
		assertEquals(INGRESO, debito.getSaldo());
	}
	@Test
	void testIngresaExc() {
		Assertions.assertThrows(ErrorFiltro.class, ()->{
			debito.ingresar(INGRESONEG);
		});
	}
	
	@Test
	void testIngresarNEG() {
		Assertions.assertThrows(ErrorFiltro.class, ()->{
			debito.ingresar(INGRESONEG);
		});
	}
	

	@Test
	void testPagoEnEstablecimiento() throws Exception {
		debito.ingresar(INGRESO2);
		Assertions.assertThrows(ErrorFiltro.class, ()->{
			debito.retirar(RETIRAR);
		});
	}
	
	@Test
	void testRetirar() throws ErrorFiltro {
		cuenta.ingresar(INGRESO);
		cuenta.retirar(RETIRAR);
		assertEquals(INGRESO - RETIRAR, cuenta.getSaldo());
	}


	@Test
	void testRetirarExceso() throws Exception {
		debito.ingresar(INGRESO2);
		Assertions.assertThrows(ErrorFiltro.class, ()->{
			debito.retirar(RETIRAR);
		});
	}

}
