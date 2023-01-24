package banco.pruebas;

import java.time.LocalDate;

public class TestsEjercicioCuentas {

	public static void main(String[] args) throws Exception {
		Cuenta cuenta = new Cuenta("0029371", "Miriam");
		LocalDate fechaCaducidad = LocalDate.of(2025, 11, 25);
		Tarjeta credito = new Credito(fechaCaducidad, "0422892", "Miriam");
		Tarjeta debito = new Debito(fechaCaducidad, "0422895", "Miriam");
		
		credito.setCuenta(cuenta);
		debito.setCuenta(cuenta);
		
		System.out.println("********** Saldo inicial establecido ************");
		cuenta.setSaldo(20000);	
		cuenta.mostrar();
		
		System.out.println("********** Débito ************");
		debito.ingresar(30);		
		debito.retirar(30);
		debito.ingresar(60);
		debito.pagoEnEstablecimiento("Mercadona", 20);
		cuenta.mostrar();
		
		
		System.out.println("********** Crédito ************");
		((Credito) credito).setCreditoInicial(30000); //Crédito inicial
		credito.ingresar(1000);
		credito.ingresar(1000);
		credito.retirar(500);
		credito.retirar(500);
		credito.pagoEnEstablecimiento("Carrefour", 300);		
		((Credito) credito).mostrar();
		System.out.println("\tPost liquidación");
		System.out.println("********** Crédito ************");
		((Credito) credito).liquidar(1, 2023);
		cuenta.mostrar();

	}

}
