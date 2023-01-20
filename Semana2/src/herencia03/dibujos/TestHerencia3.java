package herencia03.dibujos;

/**
 * Clase principal utilizada para las pruebas
 * @author m.corchero.blazquez
 * @version 1.0
 *
 */
public class TestHerencia3 {

	public static void main(String[] args) {
		Rectangulo rectangulo = new Rectangulo();
		Circulo circulo = new Circulo();
		Triangulo triangulo = new Triangulo();
		
		rectangulo.setAltura(3);
		rectangulo.setBase(2);
		
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
