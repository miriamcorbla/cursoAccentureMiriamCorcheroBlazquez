package banco.clases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import banco.util.ErrorFiltro;

class CuentaTest {
	Cuenta cuenta;
	final double INGRESO = 20;
	final double INGRESO2 = 50;
	final double RETIRO = 30;
	final String NCUENTA = "1234";
	final String TITULAR = "prueba";
	final String TITULAR1 = "Miriam Corchero BLAZQ";
	final String CONCEPTO = "CONCEPTO CORRECTO";
	final double INGRESONEG = -20;

	@BeforeEach
	void inicio() throws ErrorFiltro {
		creacion();
	}
	
	@Test
	void creacion() throws ErrorFiltro {
		cuenta = new Cuenta(NCUENTA, TITULAR1);
	}
	
	@Test
	void testCuenta() {
		Assertions.assertThrows(ErrorFiltro.class, ()->{
			new Cuenta(NCUENTA, TITULAR);
		}); 
	}

	@Test
	void testAddMovimiento() {
		Movimiento m = new Movimiento();
		m.setmConcepto(CONCEPTO);
		m.setmImporte(INGRESO);
		cuenta.addMovimiento(m);
		assertEquals(INGRESO, cuenta.getSaldo());
	}

	@Test
	void testGetSaldo() {
		cuenta.setSaldo(INGRESO);
		assertEquals(INGRESO, cuenta.getSaldo());
	}

	@Test
	void testIngresarDouble() throws ErrorFiltro {
		cuenta.ingresar(INGRESO);
		assertEquals(INGRESO, cuenta.getSaldo());

	}
	
	@Test
	void testIngresarDoubleNegativo() throws ErrorFiltro {
		Assertions.assertThrows(ErrorFiltro.class, ()->{
			cuenta.ingresar(INGRESONEG);
		});
	}
	

	@Test
	void testIngresarStringDouble() throws ErrorFiltro {
		cuenta.ingresar(CONCEPTO, INGRESO);
		assertEquals(INGRESO, cuenta.getSaldo());
	}
	
	@Test
	void testIngresarDoubleStringNegativo() throws ErrorFiltro {
		Assertions.assertThrows(ErrorFiltro.class, ()->{
			cuenta.ingresar(CONCEPTO, INGRESONEG);
		});
	}

	@Test
	void testRetirarDouble() throws ErrorFiltro {
		cuenta.ingresar(INGRESO2);
		cuenta.retirar(RETIRO);
		assertEquals(INGRESO2 - RETIRO, cuenta.getSaldo());
	}

	@Test
	void testRetirarStringDouble() throws ErrorFiltro {
		cuenta.ingresar(INGRESO2);
		cuenta.retirar(CONCEPTO, RETIRO);
		assertEquals(INGRESO2 - RETIRO, cuenta.getSaldo());
	}
	
	/**
	 * Quiero retirar más de lo que hay en la cuenta
	 */
	@Test
	void testRetirarDoubleExceso() throws ErrorFiltro {
		cuenta.ingresar(INGRESO);
		Assertions.assertThrows(ErrorFiltro.class, ()->{
			cuenta.retirar(RETIRO);
		});
	}

	@Test
	void testRetirarStringDoubleExceso() throws ErrorFiltro {
		cuenta.ingresar(INGRESO);
		Assertions.assertThrows(ErrorFiltro.class, ()->{
			cuenta.retirar(CONCEPTO, RETIRO);
		});
	}

}
