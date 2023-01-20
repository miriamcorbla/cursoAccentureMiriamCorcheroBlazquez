package herencia03.dibujos;

/**
 * Especialización de Figura para el tipo Rectángulo
 * @author m.corchero.blazquez
 * @version 1.0
 */
public class Rectangulo extends Figura{
	/**
	 * Método que imprime por pantalla la figura que está dibujando
	 * En este caso rectángulo
	 */
	public void dibujar() {
		System.out.println("Dibujando rectangulo");
	}
	/**
	 * Método que imprime por pantalla el area del rectángulo
	 */
	public void calcularArea() {
		float result = getBase() * getAltura();
		System.out.println("El area del rectangulo es: " + result);
	}
}
