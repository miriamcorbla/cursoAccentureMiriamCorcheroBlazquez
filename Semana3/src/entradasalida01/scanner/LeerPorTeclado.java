package entradasalida01.scanner;

import java.util.Scanner;


/**
 * Clase para leer por teclado dos números
 * @author m.corchero.blazquez
 *
 */
public class LeerPorTeclado {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int n1;
		int n2;		
		
		System.out.println("Introduce un número: ");
		n1 = teclado.nextInt();
		System.out.println("Introduce un número: ");
		n2 = teclado.nextInt();
		
		System.out.println(n1 + ", " + n2);

	}

}
