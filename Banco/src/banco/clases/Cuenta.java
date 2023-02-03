package banco.clases;

import java.util.ArrayList;

import banco.util.ErrorFiltro;
import banco.util.Filtros;

/**
 * Clase cuenta
 * @author m.corchero.blazquez
 * @version 1.0
 */
public class Cuenta {
	private ArrayList<Movimiento> mMovimientos = new ArrayList<Movimiento>(); // Create an ArrayList object
	private String mNumero;
	private String mTitular;
	private final int MAX_STRING = 30;
	private final int MIN_STRING = 15;
	private final int MAX_TEXTO = 100;
	private final int MIN_TEXTO = 10;
	
	
	/**
	 * Constructor parametrizado
	 * @param numero
	 * @param titular
	 * @throws Exception 
	 */
	public Cuenta(String numero, String titular) throws ErrorFiltro {
		mNumero = numero;
		if(Filtros.filtroTexto(titular, MAX_STRING, MIN_STRING)) {
			mTitular = titular;
		}else {
			throw new ErrorFiltro("Error tamaño nombre");
		}
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
	public void ingresar(double x) throws ErrorFiltro{
		Movimiento m = new Movimiento();
		if(Filtros.esSaldoPositivo(x)) { //si intentas ingresar saldo positivo
			m.setmImporte(x);
			addMovimiento(m);
		}else {
			throw new ErrorFiltro("El importe debe ser positivo");
		}
	}
	/**
	 * Ingresa saldo en cuenta con concepto
	 * @param concepto
	 * @param x si importe negativo
	 * @throws Exception
	 */
	public void ingresar(String concepto, double x) throws ErrorFiltro {
		Movimiento m = new Movimiento();
		if(Filtros.esSaldoPositivo(x)) { //Se puede ingresar si el valor es positivo
			m.setmImporte(x);
			if(Filtros.filtroTexto(concepto, MAX_TEXTO, MIN_TEXTO))
			{
				m.setmConcepto(concepto);
			}else {
				throw new ErrorFiltro("Tamaño concepto erroneo");
			}
			addMovimiento(m);
		}else {
			throw new ErrorFiltro("El importe debe ser positivo");
		}
	}
	/**
	 * Retira saldo de cuenta, si hay suficiente
	 * @param x 
	 * @throws Exception si saldo negativo
	 */
	public void retirar(double x) throws ErrorFiltro {
		Movimiento m = new Movimiento();
		if(Filtros.haySaldoSuficiente(x, getSaldo())) { //Si hay saldo suficiente para retirar la cantidad x
			m.setmImporte(-x);
			addMovimiento(m);
		}else {
			throw new ErrorFiltro("Saldo insuficiente para retirar");
		}
	}
	/**
	 * Retira saldo de cuenta con concepto
	 * @param concepto
	 * @param x
	 * @throws Exception si saldo negativo
	 */
	public void retirar(String concepto, double x) throws ErrorFiltro {
		Movimiento m = new Movimiento();
		if(Filtros.haySaldoSuficiente(x, getSaldo())) { //si el saldo es mayor que la cantidad a retirar
			m.setmImporte(-x); //retiramos
			if(Filtros.filtroTexto(concepto, MAX_TEXTO, MIN_TEXTO)){
				m.setmConcepto(concepto);
			}else {
				throw new ErrorFiltro("Tamaño de concepto erroneo");
			}
			addMovimiento(m); //guardamos el movmiento
		}else {
			throw new ErrorFiltro("Saldo Negativo");
		}
	}
	
	public void mostrar() {
		for(Movimiento m : mMovimientos) {
			System.out.println(m.mostrar());
		}
		System.out.println("Saldo total: " + getSaldo());
	}

}
