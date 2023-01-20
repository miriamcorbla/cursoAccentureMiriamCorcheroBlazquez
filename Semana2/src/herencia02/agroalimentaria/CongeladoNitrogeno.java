package herencia02.agroalimentaria;
/**
 * Especialización de Producto Congelado para congelado por nitrógeno
 * @author m.corchero.blazquez
 *
 */
public class CongeladoNitrogeno extends ProductoCongelado{
	private String metodo;
	private int segundosExposicion;
	
	public String getMetodo() {
		return metodo;
	}
	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}
	public int getSegundosExposicion() {
		return segundosExposicion;
	}
	public void setSegundosExposicion(int segundosExposicion) {
		this.segundosExposicion = segundosExposicion;
	}
	
	public CongeladoNitrogeno() {super();}
	
	@Override
	public void mostrar() {
		System.out.println("Fecha de caducidad: " + getFechaCaducidad() + " Numero de lote: " + getLote() + " Temperatura recomendada: " + getTemperaturaRecomendada() +
				" Metodo: " + getMetodo() + " Segundos de Exposicion: " + getSegundosExposicion());
	}
	

}
