package excepciones;

import java.util.ArrayList;

/**
 * Clase cuenta
 * @author m.corchero.blazquez
 * @version 1.0
 */
public class Cuenta {
	private ArrayList<Movimiento> mMovimientos = new ArrayList<Movimiento>(); // Create an ArrayList object
	private String mNumero;
	private String mTitular;
	private double saldo;
	
	/**
	 * Constructor parametrizado
	 * @param numero
	 * @param titular
	 */
	public Cuenta(String numero, String titular) {
		mNumero = numero;
		mTitular = titular;
	}
	/**
	 * Añade un movimiento
	 * @param m
	 */
	public void addMovimiento(Movimiento m) {
		mMovimientos.add(m);
	}
	/**
	 * Devuelve el saldo de la cuenta
	 * @return
	 */
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double x) {
		saldo = x;
	}
	/**
	 * Ingresa saldo en cuenta
	 * @param x
	 * @throws Exception
	 */
	public void ingresar(double x) throws Exception {
		Movimiento m = new Movimiento();
		try {
			if(x > 0) //si intentas ingresar saldo positivo
				m.setmImporte(x);
		}catch(Exception e) {
			throw new Exception("El importe debe ser positivo");
		}
	}
	/**
	 * Ingresa saldo en cuenta con concepto
	 * @param concepto
	 * @param x
	 * @throws Exception
	 */
	public void ingresar(String concepto, double x) throws Exception {
		Movimiento m = new Movimiento();
		try {
			if(x > 0) {
				m.setmImporte(x);
				m.setmConcepto(concepto);
			}
		}catch(Exception e) {
			throw new Exception("El importe debe ser positivo");
		}
	}
	/**
	 * Retira saldo de cuenta
	 * @param x
	 * @throws Exception
	 */
	public void retirar(double x) throws Exception {
		Movimiento m = new Movimiento();
		try {
			if(getSaldo() > x) //Si hay saldo suficiente
				m.setmImporte(getSaldo()-x);
		}catch(Exception e) {
			throw new Exception("Saldo negativo");
		}
	}
	/**
	 * Retira saldo de cuenta con concepto
	 * @param concepto
	 * @param x
	 * @throws Exception
	 */
	public void retirar(String concepto, double x) throws Exception {
		Movimiento m = new Movimiento();
		try {
			if(getSaldo() > x) {
				m.setmImporte(getSaldo()-x);
				m.setmConcepto(concepto);
			}
		}catch(Exception e) {
			throw new Exception("Saldo negativo");
		}
	}
	

}
