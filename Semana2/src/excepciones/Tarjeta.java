package excepciones;

import java.time.LocalDate;

/**
 * Clase abstracta tarjeta
 * @author m.corchero.blazquez
 *
 */
public abstract class Tarjeta {
	private Cuenta cuenta;
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
		cuenta = c;
	}
	/**
	 * Método observador de cuenta
	 * @return cuenta
	 */
	public Cuenta getCuenta() {
		return cuenta;
	}
	
	abstract double getSaldo();
	abstract void ingresar(double x);
	abstract void pagoEnEstablecimiento(String datos, double x);
	abstract void retirar(double x);
}
