package herencia03.dibujos;

/**
 * Clase abstracta padre Figura
 * @author m.corchero.blazquez
 * @version 1.0
 *
 */
public abstract class Figura {
	private float base;
	private float altura;
	private Coordenada x; //para dibujar
	private Coordenada y; //para dibujar
	/**
	 * Método observador de la coordenada X
	 * @return x
	 */
	public Coordenada getX() {
		return x;
	}
	/**
	 * Método modificador de la coordenada X
	 * @param x
	 */
	public void setX(Coordenada x) {
		this.x = x;
	}
	
	/**
	 * Método observador de la coordenada Y
	 * @return Y
	 */
	public Coordenada getY() {
		return y;
	}
	
	/**
	 * Método modificador de la coordenada Y
	 * @param y
	 */
	public void setY(Coordenada y) {
		this.y = y;
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
