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
	 * Obtiene el total de los movimientos de la cuenta
	 */
	@Override
	public double getSaldo() {
		return getmCuentaAsociada().getSaldo();
	}

	@Override
	/**
	 * Ingresa dinero en la cuenta crédito
	 */
	void ingresar(double x) {
		Movimiento mov = new Movimiento(); //creo nuevo movimiento
		mov.setmImporte(x);
		mov.setmFecha(LocalDate.now());
		mov.setmConcepto("Ingreso en cuenta asociada (cajero automatico)");
		mMovimientos.add(mov); //guardo el movimiento en el array
		
	}

	@Override
	/**
	 * Paga con tarjeta crédito, si tiene
	 * dinero suficiente
	 */
	void pagoEnEstablecimiento(String datos, double x) {
		if(getCreditoDisponible() > x) { //si tengo crédito suficiente
			Movimiento m = new Movimiento();
			m.setmConcepto("Compra a crédito en: " + datos);
			m.setmImporte(-x);
			mMovimientos.add(m);
			mCredito -= x; //Actualiza el total de crédito
		}else {
			System.out.println("Crédito insuficiente");
		}
	}

	@Override
	/**
	 * Retira en la cuenta crédito asociada con una retención
	 */
	void retirar(double x) {
		Movimiento mov = new Movimiento();
		if(getCreditoDisponible()>=x) {
			mov.setmImporte(x);
			mov.setmConcepto("Retirada en cuenta asociada (cajero automatico)");
			double comision = (0.05 * mov.getmImporte());
			if(comision < 3d) {
				comision = 3d;
			}
			mCredito -= (comision + mov.getmImporte());
			mMovimientos.add(mov);
		}else {
			System.out.println("Crédito insuficiente");
		}
	}
	
	public void liquidar(int mes, int anio) throws Exception {
		double suma = 0d;
		for(Movimiento m : mMovimientos) {
			if((m.getmFecha().getMonthValue() == mes) && (m.getmFecha().getYear()==anio)) {
				suma += m.getmImporte();
				mMovimientos.remove(m); //eliminamos el movimiento del vector movivimientos de Crédito				
			}
		}
		//Añadimos el movimiento con la suma total al vector de movimientos de la cuenta asociada
		Movimiento m = new Movimiento();
		m.setmConcepto("liquidacion");
		m.setmImporte(suma);
		getmCuentaAsociada().addMovimiento(m);
		getmCuentaAsociada().retirar(suma); //Retiramos el dinero del movimiento en la cuenta asociada
	}
}
