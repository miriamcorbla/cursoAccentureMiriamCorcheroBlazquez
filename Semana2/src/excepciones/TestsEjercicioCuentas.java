package excepciones;

import java.time.LocalDate;

public class TestsEjercicioCuentas {

	public static void main(String[] args) throws Exception {
		Cuenta cuenta = new Cuenta("1234", "Lucia");
		LocalDate fechaCaducidad = LocalDate.now();
		Tarjeta credito = new Credito(fechaCaducidad, "Marcos", "123");
		Tarjeta debito = new Debito(fechaCaducidad, "Marcos", "123");
		
		cuenta.setSaldo(0);
		
		cuenta.ingresar(30);
		cuenta.ingresar(10);
		cuenta.retirar(20);
		cuenta.retirar(50);
		
		credito.ingresar(30);
		credito.retirar(40);
		
		debito.ingresar(10);
		debito.retirar(10);

	}

}
