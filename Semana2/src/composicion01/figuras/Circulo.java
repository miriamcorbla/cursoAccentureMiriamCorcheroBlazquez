package composicion01.figuras;

/**
 * Especialización de Figura para el tipo círculo
 * @author m.corchero.blazquez
 * @version 1.0
 *
 */
public class Circulo extends Figura {
	/**
	 * Método que imprime por pantalla la figura que está dibujando
	 * En este caso círculo
	 */
	public void dibujar() {
		System.out.println("Dibujando circulo");
	}
	/**
	 * Método que imprime por pantalla el area del rectángulo
	 */
	public void calcularArea() {
		float result;
		if(getBase() == 0) {
			result = (float) (Math.PI * Math.pow((getAltura()/2), 2));
		}else {
			result = (float) (Math.PI * Math.pow((getBase()/2), 2));
		}
		
		System.out.println("El area del circulo es: " + result);
	}
}
