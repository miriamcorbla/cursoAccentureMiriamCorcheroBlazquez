package herencia03.dibujos;

/**
 * Especialización de Figura para el tipo Triángulo
 * @author m.corchero.blazquez
 * @version 1.0
 *
 */
public class Triangulo extends Figura{
	/**
	 * Método que imprime por pantalla la figura que está dibujando
	 * En este caso triángulo
	 */
	public void dibujar() {
		System.out.println("Dibujando triangulo");
	}
	
	/**
	 * Método que imprime por pantalla el area del rectángulo
	 */
	public void calcularArea() {
		float result = (getBase()*getAltura())/2;
		System.out.println("El area del triangulo es: " + result);
	}
}
