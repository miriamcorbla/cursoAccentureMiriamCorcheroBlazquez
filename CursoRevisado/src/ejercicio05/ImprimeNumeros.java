package ejercicio05;

/**
 * Listar Numeros de 100 al 0 de 23 en 23: 100, 77 54 31 8
 * @author m.corchero.blazquez
 * @version 1.2
 */
public class ImprimeNumeros {
	public static void main(String[] args) {
		int numeros = 100; //numero inicial es 100
		while(numeros>0) { //mientras sea mayor que 0
			System.out.println(numeros);
			numeros -= 23;
		}
	}
}
