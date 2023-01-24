package banco.clases;

import java.time.LocalDate;

/**
 * Clase débito
 * @author m.corchero.blazquez
 * @version 1.0
 */
public class Debito extends Tarjeta{

	/**
	 * Constructor parametrizado de la clase Débito
	 * @param mFechaDeCaducidad
	 * @param mNumero
	 * @param mTitular
	 */
	public Debito(LocalDate mFechaDeCaducidad, String mNumero, String mTitular) {
		super(mFechaDeCaducidad, mNumero, mTitular);
	}

	@Override
	public double getSaldo() {
		return getmCuentaAsociada().getSaldo();
	}

	@Override
	/**
	 * Método que recibe un double y se ingresa en cuenta asociada
	 */
	public void ingresar(double x) {
		try {
			getmCuentaAsociada().ingresar(x);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	/**
	 * Método que paga en establecimientos con el concepto
	 * Compras en + el nombre del comercio
	 */
	public void pagoEnEstablecimiento(String datos, double x) {
		try {
			getmCuentaAsociada().retirar("Compras en : " + datos, x);
		} catch (Exception e) {
			System.out.println("Saldo insuficiente para pagar en establecimiento");
		}
	}

	@Override
	public void retirar(double x) {
		try {
			getmCuentaAsociada().retirar("Retirada en cajero automático", x);
		} catch (Exception e) {
			System.out.println("No se puede retirar");
		}		
	}	
}
