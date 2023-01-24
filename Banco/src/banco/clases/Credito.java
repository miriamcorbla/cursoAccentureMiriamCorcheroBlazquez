package banco.clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 * Clase crédito
 * @author m.corchero.blazquez
 * @version 1.0
 */
public class Credito extends Tarjeta{
	private ArrayList<Movimiento> mMovimientos = new ArrayList<Movimiento>();
	private double mCredito;
	
	/**
	 * Constructor parametrizado de la clase crédito
	 * @param fechaCaducidad
	 * @param numero
	 * @param titular
	 */
	public Credito(LocalDate fechaCaducidad, String numero, String titular) {
		super(fechaCaducidad, numero, titular);
	}
	
	public void setCreditoInicial(double valor) {
		if(mMovimientos.isEmpty())
			mCredito = valor;
	}
	
	/**
	 * Obtiene el resultado del crédito disponible que 
	 * hay en la tarjeta. 
	 * @return
	 */
	public double getCreditoDisponible() {
		double cont = 0d;
		for(Movimiento m : mMovimientos) {
			cont += m.getmImporte();
		}
		return mCredito-cont;
	}
	
	/**
	 * Obtiene el total de los movimientos del crédito
	 */
	@Override
	public double getSaldo() {
		double cont = 0d;
		for(Movimiento m : mMovimientos) {
			cont += m.getmImporte();
		}
		return cont;
	}

	@Override
	/**
	 * Ingresa dinero en la cuenta crédito
	 */
	public void ingresar(double x) {
		Movimiento mov = new Movimiento(); //creo nuevo movimiento
		mov.setmImporte(x);
		mov.setmFecha(LocalDate.now());
		mov.setmConcepto("Ingreso en cuenta asociada (cajero automatico)");
		mMovimientos.add(mov); //guardo el movimiento en el array
		mCredito = mCredito + x;
	}

	@Override
	/**
	 * Paga con tarjeta crédito, si tiene
	 * dinero suficiente
	 */
	public void pagoEnEstablecimiento(String datos, double x) {
		if(getSaldo() >= x) { //si tengo crédito suficiente
			Movimiento m = new Movimiento();
			m.setmConcepto("Compra a crédito en: " + datos);
			m.setmImporte(-x);
			this.mMovimientos.add(m);
			this.mCredito -= x; //Actualiza el total de crédito
		}
	}

	@Override
	/**
	 * Retira en la cuenta crédito asociada con una retención
	 */
	public void retirar(double x) {
		Movimiento mov = new Movimiento();
		if(getSaldo()>=x) {
			mov.setmImporte(-x);
			mov.setmConcepto("Retirada en cuenta asociada (cajero automatico)");
			double comision = (0.05 * mov.getmImporte());
			if(comision < 3d) {
				comision = 3d;
			}
			this.mCredito = this.mCredito - (comision + mov.getmImporte());
			this.mMovimientos.add(mov);
		}
	}
	
	public void liquidar(int mes, int anio){
		double total = 0d;
		for(int i = 0; i<mMovimientos.size(); i++) {
			Movimiento m = mMovimientos.get(i);
			if((m.getmFecha().getMonthValue() == mes) && (m.getmFecha().getYear()==anio)) {
				total += m.getmImporte();
				this.mMovimientos.remove(i); //eliminamos el movimiento del vector movivimientos de Crédito				
			}
		}
		//Añadimos el movimiento con la suma total al vector de movimientos de la cuenta asociada
		Movimiento m = new Movimiento();
		m.setmConcepto("Liquidacion de crédito");
		m.setmImporte(-total);
		getmCuentaAsociada().addMovimiento(m);
		//getmCuentaAsociada().retirar(total); //Retiramos el dinero del movimiento en la cuenta asociada
	}
	
	public void mostrar() {
		for(Movimiento m : mMovimientos) {
			System.out.println(m.mostrar()); 
		}
		System.out.println("Saldo Crédito disponible: " + getSaldo());
	}
}
