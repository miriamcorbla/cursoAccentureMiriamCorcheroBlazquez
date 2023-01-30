package entradasalida01.scanner;

import java.io.IOException;
import java.util.Scanner;

/**
 * Clase para leer por teclado y utilizar excepciones
 * @author m.corchero.blazquez
 *
 */
public class LeerPorTecladoExcepciones {
	static Scanner teclado;
	public static void main(String[] args) throws IOException {
		try {
			teclado = new Scanner(System.in);
			int n1;
			int n2;

			System.out.println("Introduce un número: ");
			n1 = teclado.nextInt();
			System.out.println("Introduce un número: ");
			n2 = teclado.nextInt();
			
			System.out.println(n1 + ", " + n2);
		}finally {
			teclado.close();
		}

	}

}
