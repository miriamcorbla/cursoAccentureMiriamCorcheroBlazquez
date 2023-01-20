package herencia03.dibujos;

/**
 * Clase principal utilizada para las pruebas
 * @author m.corchero.blazquez
 * @version 1.0
 *
 */
public class TestHerencia3 {

	public static void main(String[] args) {
		Figura rectangulo = new Rectangulo();
		Figura circulo = new Circulo();
		Figura triangulo = new Triangulo();
		
		rectangulo.setAltura(3);
		rectangulo.setBase(3);
		
		circulo.setBase(5);
		
		triangulo.setAltura(3);
		triangulo.setBase(4);
		
		rectangulo.dibujar();
		rectangulo.calcularArea();
		circulo.dibujar();
		circulo.calcularArea();
		triangulo.dibujar();
		triangulo.calcularArea();

	}

}
