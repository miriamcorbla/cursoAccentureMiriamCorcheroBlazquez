package banco.clases;

import java.time.LocalDate;

/**
 * POJO Movimiento
 * @author m.corchero.blazquez
 *
 */
public class Movimiento {
	
	private String mConcepto;
	private LocalDate mFecha;
	private double mImporte;
	
	/**
	 * Método observador que devuelve el concepto
	 * @return mConcepto
	 */
	public String getmConcepto() {
		return mConcepto;
	}
	/**
	 * Método modificador para el atributo mConcepto
	 * @param mConcepto
	 */
	public void setmConcepto(String mConcepto) {
		this.mConcepto = mConcepto;
	}
	/**
	 * Método observador para el atributo fecha
	 * @return mFecha
	 */
	public LocalDate getmFecha() {
		return mFecha;
	}
	/**
	 * Método modificador para el atributo fecha
	 * @param mFecha
	 */
	public void setmFecha(LocalDate mFecha) {
		this.mFecha = mFecha;
	}
	/**
	 * Método observador para el atributo importe
	 * @return
	 */
	public double getmImporte() {
		return mImporte;
	}
	/**
	 * Método modificador del atributo importe
	 * @param mImporte
	 */
	public void setmImporte(double mImporte) {
		this.mImporte = mImporte;
	}
	
	/**
	 * Constructor de clase
	 */
	public Movimiento() {
		setmFecha(LocalDate.now());
	}
	
	public String mostrar() {
		return "Fecha: " + getmFecha() + " Concepto: " + getmConcepto() + " Importe: " + getmImporte();
	}

}
