package banco.clases;

import java.time.LocalDate;

public class TestsEjercicioCuentas {

	public static void main(String[] args) throws Exception {
		Cuenta cuenta = new Cuenta("0029371", "Miriam");
		LocalDate fechaCaducidad = LocalDate.of(2025, 11, 25);
		Tarjeta credito = new Credito(fechaCaducidad, "0422892", "Miriam");
		Tarjeta debito = new Debito(fechaCaducidad, "0422895", "Miriam");
		
		cuenta.setSaldo(20000);
		System.out.println("Saldo en cuenta: " + cuenta.getSaldo());
		
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
