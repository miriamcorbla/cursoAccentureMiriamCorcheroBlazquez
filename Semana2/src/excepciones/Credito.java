package excepciones;

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
	
	public Credito(LocalDate fechaCaducidad, String numero, String titular) {
		super(fechaCaducidad, numero, titular);
	}
	
	public double getCreditoDisponible() {
		return mCredito;
	}
	
	@Override
	double getSaldo() {
		return mCredito;
	}

	@Override
	void ingresar(double x) {
		Movimiento mov = new Movimiento();
		mov.setmImporte(20);
		mov.setmFecha(LocalDate.now());
		mov.setmConcepto("Ingreso en cuenta asociada (cajero automatico)");
		mMovimientos.add(mov);
		
	}

	@Override
	void pagoEnEstablecimiento(String datos, double x) {
		if(mCredito > x) {
			System.out.println("Compra a crédito en: " + datos);
		}else {
			System.out.println("Crédito insuficiente");
		}
	}

	@Override
	void retirar(double x) {
		Movimiento mov = new Movimiento();
		mov.setmImporte(5);
		if(mCredito>0) {
			mov.setmConcepto("Retirada en cuenta asociada (cajero automatico)");
			mCredito -= (mov.getmImporte()-0.5*mov.getmImporte())+mov.getmImporte();
			mMovimientos.add(mov);
		}else {
			System.out.println("Crédito insuficiente");
		}
	}
	
	public void liquidar(int mes, int año) {
		Date fecha = new Date();
		fecha.setYear(año);
		fecha.setMonth(mes);
		double suma = 0;
		for(Movimiento m : mMovimientos) {
			if(m.getmFecha().getMonth().equals(fecha.getMonth())) {
				suma += m.getmImporte();
			}
		}
		Movimiento m = new Movimiento();
		m.setmConcepto("liquidacion");
		m.setmImporte(suma);
		mMovimientos.add(m);
	}
}
