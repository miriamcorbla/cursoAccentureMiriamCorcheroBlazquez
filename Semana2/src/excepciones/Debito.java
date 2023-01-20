package excepciones;

import java.time.LocalDate;

/**
 * Clase débito
 * @author m.corchero.blazquez
 * @version 1.0
 */
public class Debito extends Tarjeta{

	public Debito(LocalDate mFechaDeCaducidad, String mNumero, String mTitular) {
		super(mFechaDeCaducidad, mNumero, mTitular);
	}

	@Override
	double getSaldo() {
		return getSaldo();
	}

	@Override
	void ingresar(double x) {
		try {
			getCuenta().ingresar(x);
		} catch (Exception e) {
			System.out.println("No se puede ingresar");
		}		
	}

	@Override
	void pagoEnEstablecimiento(String datos, double x) {
		System.out.println("Compras en: " + datos + " con valor de: " + x);		
	}

	@Override
	void retirar(double x) {
		try {
			getCuenta().retirar(x);
		} catch (Exception e) {
			System.out.println("No se puede retirar");
		}		
	}		
}
