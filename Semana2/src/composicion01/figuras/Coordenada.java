package composicion01.figuras;

/**
 * Clase Coordenada utilizada para dibujar
 * @author m.corchero.blazquez
 * @version 1.0
 *
 */
public class Coordenada {
	private int x;
	private int y;
	/**
	 * Método observador de la coordenada X
	 * @return X
	 */
	public int getX() {
		return x;
	}
	/**
	 * Método modificador de coordenada x
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * Método observador de coordenada Y
	 * @return Y
	 */
	public int getY() {
		return y;
	}
	/**
	 * Método modificador de coordenada Y
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}	
	
	public void invertir() {
		int temporal =  x;
		x = y;
		y = temporal;
	}

}
