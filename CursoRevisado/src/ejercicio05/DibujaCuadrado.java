package ejercicio05;

/**
 * Clase que imprime un cuadrado dado el tamaño del lado
 * @author m.corchero.blazquez
 * @version 1.0
 */
public class DibujaCuadrado {

	public static void main(String[] args) {
		int tamLado = 8; //tamaño del lado
		for(int i = 0; i<=tamLado; i++) {
			for(int j = 0; j<tamLado; j++) {
				System.out.print("* "); //OJO antes puse println y esto salta de linea, para que no ocurra: print
			}
			System.out.println(" ");
		}
	}
}
