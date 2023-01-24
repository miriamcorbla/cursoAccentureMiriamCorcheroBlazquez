package banco.clases;

import java.time.LocalDate;

/**
 * Clase abstracta tarjeta
 * @author m.corchero.blazquez
 *
 */
public abstract class Tarjeta {
	private Cuenta mCuentaAsociada;
	private LocalDate mFechaDeCaducidad;
	private String mNumero;
	private String mTitular;
	
	/**
	 * Constructor parametrizado
	 * @param mFechaDeCaducidad
	 * @param mNumero
	 * @param mTitular
	 */
	protected Tarjeta(LocalDate mFechaDeCaducidad, String mNumero, String mTitular) {
		super();
		this.mFechaDeCaducidad = mFechaDeCaducidad;
		this.mNumero = mNumero;
		this.mTitular = mTitular;
	}
	/**
	 * Método modificador de cuenta
	 * @param c
	 */
	public void setCuenta(Cuenta c) {
		mCuentaAsociada = c;
	}
	/**
	 * Método observador que devuelve la cuenta asociada
	 * @return cuenta
	 */
	public Cuenta getmCuentaAsociada() {
		return mCuentaAsociada;
	}

	/**
	 * Método abstracto que devuelve el saldo asociado a la cuenta
	 * @return el saldo
	 */
	abstract double getSaldo();
	/**
	 * Método abstracto ingresar a implementar en los hijos
	 * @param x cantidad a ingresar
	 */
	abstract void ingresar(double x);
	/**
	 * Método abstracto que permite pagar en establecimientos
	 * con una información y cantidad de dinero
	 * @param datos
	 * @param x
	 */
	abstract void pagoEnEstablecimiento(String datos, double x);
	/**
	 * Método abstracto a implementar en los hijos que 
	 * consiste en retirar dinero de la cuenta 
	 * @param x la cantidad de dinero a retirar
	 */
	abstract void retirar(double x);
}
