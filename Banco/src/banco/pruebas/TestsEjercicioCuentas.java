package banco.pruebas;
import banco.clases.*;

import java.time.LocalDate;

public class TestsEjercicioCuentas {

	public static void main(String[] args) throws Exception {
		Cuenta cuenta = new Cuenta("0029371", "Miriam sasarhyaryaryardt");
		LocalDate fechaCaducidad = LocalDate.of(2027, 11, 25);
		Tarjeta credito = new Credito(fechaCaducidad, "0422892", "Miriam sgtaraeryearyry", 1000);
		Tarjeta debito = new Debito(fechaCaducidad, "0422895", "Miriam atstsatstaetwe");
		
		credito.setCuenta(cuenta);
		debito.setCuenta(cuenta);
		
		System.out.println("********** Saldo inicial establecido ************");
		cuenta.setSaldo(20000);	
		cuenta.mostrar();
		
		System.out.println("********** Débito ************");
		debito.ingresar(30);		
		debito.retirar(30);
		debito.ingresar(60);
		debito.pagoEnEstablecimiento("Compras Mercadona", 20);
		cuenta.mostrar();
		
		
		System.out.println("********** Crédito ************");
		System.out.println("Credito disponible: " + ((Credito) credito).getCreditoDisponible());
		credito.ingresar(100);
		credito.retirar(50);
		credito.retirar(40);
		credito.pagoEnEstablecimiento("Compras Carrefour", 10);		
		((Credito) credito).mostrar();
		System.out.println("********** ******* ************");
		System.out.println("\tPost liquidación");
		System.out.println("********** Crédito ************");
		((Credito) credito).liquidarStream(1, 2023);
		cuenta.mostrar();

	}

}
