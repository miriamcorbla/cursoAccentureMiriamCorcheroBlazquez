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
	 * @throws Exception 
	 */
	public void ingresar(double x) throws Exception {
		getmCuentaAsociada().ingresar(x);		
	}

	@Override
	/**
	 * Método que paga en establecimientos con el concepto
	 * Compras en + el nombre del comercio
	 * @throws Exception 
	 */
	public void pagoEnEstablecimiento(String datos, double x) throws Exception {
		getmCuentaAsociada().retirar("Compras en : " + datos, x);
	}

	@Override
	public void retirar(double x) throws Exception {
		getmCuentaAsociada().retirar("Retirada en cajero automático", x);
			
	}	
}
