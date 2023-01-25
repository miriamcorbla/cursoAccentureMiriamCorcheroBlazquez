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
	private final double COMISION = 3.0; 
	
	/**
	 * Constructor parametrizado de la clase crédito
	 * @param fechaCaducidad
	 * @param numero
	 * @param titular
	 */
	public Credito(LocalDate fechaCaducidad, String numero, String titular, double mCredito) {
		super(fechaCaducidad, numero, titular);
		this.mCredito = mCredito;
	}
	
	
	/**
	 * Obtiene el total de los movimientos del crédito
	 */
	@Override
	public double getSaldo() {
		double suma = 0d;
		for(Movimiento m : mMovimientos) {
			suma += m.getmImporte();
		}
		return suma;
	}
	
	/**
	 * Obtiene el resultado del crédito disponible que 
	 * hay en la tarjeta. 
	 * @return
	 */
	public double getCreditoDisponible() {
		return mCredito;
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
		this.mMovimientos.add(mov); //guardo el movimiento en el array
		mCredito += x;
	}

	@Override
	/**
	 * Paga con tarjeta crédito, si tiene
	 * dinero suficiente
	 */
	public void pagoEnEstablecimiento(String datos, double x) {
		if(getCreditoDisponible() >= x) { //si tengo crédito suficiente
			Movimiento m = new Movimiento();
			m.setmConcepto("Compra a crédito en: " + datos);
			m.setmImporte(-x);
			this.mMovimientos.add(m);
			mCredito -= x; //Actualiza el total de crédito
		}
	}

	@Override
	/**
	 * Retira en la cuenta crédito asociada con una retención
	 */
	public void retirar(double x) {
		Movimiento mov = new Movimiento();
		if(getCreditoDisponible() >= x) {
			double comisionActual = (0.05 * x);
			if(comisionActual < COMISION) {
				comisionActual = COMISION;
			}
			mCredito = mCredito - (comisionActual + x);
			mov.setmImporte(-x-comisionActual);
			mov.setmConcepto("Retirada en cuenta asociada (cajero automatico)");
			this.mMovimientos.add(mov);
		}
	}
	
	/**
	 * Summa todos los importes del mes indicado, los elimina
	 * de movimientos de tarjeta y añade el mov a cuenta asociada
	 * @param mes
	 * @param anio
	 */
	public void liquidar(int mes, int anio){
		double total = 0d;
		for(int i = 0; i<mMovimientos.size(); i++) {
			Movimiento m = mMovimientos.get(i);
			if((m.getmFecha().getMonthValue() == mes) && (m.getmFecha().getYear()==anio)) {
				total += m.getmImporte();
				this.mMovimientos.remove(i);//eliminamos el movimiento del vector movivimientos de Crédito				
				i--; //restauramos el indice ya que eliminamos un movimiento
			}
			
		}
		//Añadimos el movimiento con la suma total al vector de movimientos de la cuenta asociada
		Movimiento m = new Movimiento();
		m.setmConcepto("Liquidacion de crédito");
		m.setmImporte(-total);
		getmCuentaAsociada().addMovimiento(m);
	}
	
	public void mostrar() {
		for(Movimiento m : mMovimientos) {
			System.out.println(m.mostrar()); 
		}
		System.out.println("Saldo Crédito disponible: " + getCreditoDisponible());
	}
}
