package banco.clases;

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
	 * Devuelve el saldo de la cuenta recorriendo el
	 * vector de movimientos
	 * @return
	 */
	public double getSaldo() {
		double cont = 0d;
		for(Movimiento m : mMovimientos) {
			cont += m.getmImporte();
		}
		return cont;
	}
	
	public void setSaldo(double saldo) {
		Movimiento inicial = new Movimiento();
		inicial.setmConcepto("Añadido saldo");
		inicial.setmImporte(saldo);
		mMovimientos.add(inicial);
	}
	
	/**
	 * Ingresa saldo en cuenta
	 * @param x
	 * @throws Exception si importe negativo
	 */
	public void ingresar(double x){
		Movimiento m = new Movimiento();
		try {
			if(x > 0) { //si intentas ingresar saldo positivo
				m.setmImporte(x);
				addMovimiento(m);
			}
		}catch(Exception e) {
			System.out.println("El importe debe ser positivo");
		}
	}
	/**
	 * Ingresa saldo en cuenta con concepto
	 * @param concepto
	 * @param x si importe negativo
	 * @throws Exception
	 */
	public void ingresar(String concepto, double x) throws Exception {
		Movimiento m = new Movimiento();
		try {
			if(x > 0) { //Se puede ingresar si el valor es positivo
				m.setmImporte(x);
				m.setmConcepto(concepto);
				addMovimiento(m);
			}
		}catch(Exception e) {
			throw new Exception("El importe debe ser positivo");
		}
	}
	/**
	 * Retira saldo de cuenta, si hay suficiente
	 * @param x 
	 * @throws Exception si saldo negativo
	 */
	public void retirar(double x) throws Exception {
		Movimiento m = new Movimiento();
		try {
			if(getSaldo() >= x) { //Si hay saldo suficiente para retirar la cantidad x
				m.setmImporte(-x);
				addMovimiento(m);
			}
		}catch(Exception e) {
			throw new Exception("Saldo insuficiente para retirar");
		}
	}
	/**
	 * Retira saldo de cuenta con concepto
	 * @param concepto
	 * @param x
	 * @throws Exception si saldo negativo
	 */
	public void retirar(String concepto, double x) throws Exception {
		Movimiento m = new Movimiento();
		try {
			if(getSaldo() >= x) { //si el saldo es mayor que la cantidad a retirar
				m.setmImporte(-x); //retiramos
				m.setmConcepto(concepto);
				addMovimiento(m); //guardamos el movmiento
			}
		}catch(Exception e) {
			throw new Exception("Saldo negativo");
		}
	}
	
	public void mostrar() {
		for(Movimiento m : mMovimientos) {
			System.out.println(m.mostrar());
		}
		System.out.println("Saldo total: " + getSaldo());
	}

}
