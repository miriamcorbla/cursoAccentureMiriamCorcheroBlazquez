package ejercicio05;

/**
 * Clase que recibe una nota y muestra por pantalla
 * su equivalente calificación. 
 * @author m.corchero.blazquez
 * @version 1.2
 */
public class Notas {
	
	public static void main(String[] args) {
		int nota = 6;
		switch(nota) {
		case 1, 2, 3, 4:
			System.out.println("Insuficiente");
			break;
		case 5:
			System.out.println("Suficiente");
			break;
		case 6: 
			System.out.println("Bien");
			break;
		case 7, 8:
			System.out.println("Notable");
			break;
		case 9, 10:
			System.out.println("Sobresaliente");
			break;
		default:
			System.out.println("ERROR");
		}
	}
}
