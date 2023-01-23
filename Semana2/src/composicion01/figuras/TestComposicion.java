package composicion01.figuras;

/**
 * Clase principal utilizada para las pruebas
 * @author m.corchero.blazquez
 * @version 1.0
 *
 */
public class TestComposicion {

	public static void main(String[] args) {
		Figura rectangulo = new Rectangulo();
		Figura circulo = new Circulo();
		Figura triangulo = new Triangulo();
		
		Coordenada coord = new Coordenada();
		coord.setX(3);
		coord.setY(4);
		
		Descripcion descrip = new Descripcion ("Círculo", "Descripción");
		
		circulo.setCoordenada(coord);
		circulo.getCoordenada().invertir();
		
		circulo.getDescripcion();
		
		
		rectangulo.setAltura(3);
		rectangulo.setBase(3);
		
		circulo.setBase(3);
		circulo.setAltura(0);
		
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
