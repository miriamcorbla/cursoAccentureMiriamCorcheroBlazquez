package herencia02.agroalimentaria;

/**
 * Especialización de productos para producto congelado
 * @author m.corchero.blazquez
 *
 */
public class ProductoCongelado extends Productos {
	private int temperaturaRecomendada;

	/**
	 * Método observador
	 * @return temperaturaRecomendada
	 */
	public int getTemperaturaRecomendada() {
		return temperaturaRecomendada;
	}

	/**
	 * Método modificador
	 * @param temperaturaRecomendada
	 */
	public void setTemperaturaRecomendada(int temperaturaRecomendada) {
		this.temperaturaRecomendada = temperaturaRecomendada;
	}
	
	public ProductoCongelado() {super();}
	
	@Override
	public void mostrar() {
		System.out.println("Fecha de caducidad: " + getFechaCaducidad() + " Numero de lote: " + getLote() + " Temperatura recomendada: " + getTemperaturaRecomendada());
	}
	
	
}
