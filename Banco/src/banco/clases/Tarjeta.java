package banco.clases;

import java.time.LocalDate;

import banco.util.ErrorFiltro;
import banco.util.Filtros;

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
	private final int Y_MAX = 5;
	private final int Y_MIN = 3;
	private final int MAX_STRING = 30;
	private final int MIN_STRING = 15;
	
	/**
	 * Constructor parametrizado
	 * @param mFechaDeCaducidad
	 * @param mNumero
	 * @param mTitular
	 * @throws ErrorFiltro 
	 */
	protected Tarjeta(LocalDate mFechaDeCaducidad, String mNumero, String mTitular) throws ErrorFiltro {
		super();
		if(Filtros.filtroFechaAnio(mFechaDeCaducidad,Y_MAX,Y_MIN)) {
			this.mFechaDeCaducidad = mFechaDeCaducidad;
		}else {
			throw new ErrorFiltro("Fecha incorrecta");
		}
		
		this.mNumero = mNumero;
		if(Filtros.filtroTexto(mTitular, MAX_STRING, MIN_STRING)){
			this.mTitular = mTitular;
		}else {
			throw new ErrorFiltro("Tamaño titular incorrecto");
		}
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
	abstract public double getSaldo();
	/**
	 * Método abstracto ingresar a implementar en los hijos
	 * @param x cantidad a ingresar
	 * @throws Exception 
	 */
	abstract public void ingresar(double x) throws Exception;
	/**
	 * Método abstracto que permite pagar en establecimientos
	 * con una información y cantidad de dinero
	 * @param datos
	 * @param x
	 * @throws Exception 
	 */
	abstract public void pagoEnEstablecimiento(String datos, double x) throws Exception;
	/**
	 * Método abstracto a implementar en los hijos que 
	 * consiste en retirar dinero de la cuenta 
	 * @param x la cantidad de dinero a retirar
	 * @throws Exception 
	 */
	abstract public void retirar(double x) throws Exception;
}
