package composicion01.figuras;

/**
 * Clase abstracta padre Figura
 * @author m.corchero.blazquez
 * @version 1.0
 *
 */
public abstract class Figura {

	private float base;
	private float altura;
	private Coordenada coord;
	private Descripcion descripcion;
	/**
	 * Método observador de la coordenada X
	 * @return x
	 */
	public Coordenada getCoordenada() {
		return coord;
	}
	/**
	 * Método modificador de la coordenada X
	 * @param x
	 */
	public void setCoordenada(Coordenada coord) {
		this.coord = coord;
	}
	
	
	public Descripcion getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(Descripcion descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * Método observador del atributo base
	 * @return base
	 */
	public float getBase() {
		return base;
	}
	/**
	 * Método modificador del atributo base
	 * @param base
	 */
	public void setBase(float base) {
		this.base = base;
	}
	
	/**
	 * Método observador del atributo altura
	 * @return altura
	 */
	public float getAltura() {
		return altura;
	}
	
	/**
	 * Método modificador del atributo altura
	 * @param altura
	 */
	public void setAltura(float altura) {
		this.altura = altura;
	}
	
	
	/**
	 * Método abstracto para calcular area
	 */
	abstract void calcularArea();
	/**
	 * Método abstracto para dibujar
	 */
	abstract void dibujar();

}
