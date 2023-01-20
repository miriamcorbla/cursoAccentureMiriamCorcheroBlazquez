package herencia02.agroalimentaria;

/**
 * Especialización de Congelado para Congelado por agua
 * @author m.corchero.blazquez
 *
 */
public class CongeladoAgua extends ProductoCongelado {
	private double salinidad;

	/**
	 * Método observador
	 * @return salinidad
	 */
	public double getSalinidad() {
		return salinidad;
	}

	/**
	 * Método modificador
	 * @param salinidad
	 */
	public void setSalinidad(double salinidad) {
		this.salinidad = salinidad;
	}
	
	public CongeladoAgua() {super();}
	
	@Override
	public void mostrar() {
		System.out.println("Fecha de caducidad: " + getFechaCaducidad() + " Numero de lote: " + getLote() + " Temperatura recomendada: " + getTemperaturaRecomendada() +
				" Salinidad: " + getSalinidad());
	}

}
