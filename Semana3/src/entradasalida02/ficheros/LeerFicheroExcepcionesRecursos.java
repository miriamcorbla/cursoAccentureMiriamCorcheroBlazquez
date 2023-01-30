package entradasalida02.ficheros;

import java.io.File;
import java.util.Scanner;

/**
 * Clase para leer por teclado un archivo utilizando excepciones con recursos
 * @author m.corchero.blazquez
 *
 */
public class LeerFicheroExcepcionesRecursos {
	public static void main(String[] args) {
		File fichero = new File("C:\\Users\\m.corchero.blazquez\\OneDrive - Accenture\\cursoWorkspace\\Semana3\\src\\entradasalida01\\scanner\\FicheroALeer.java");
		try(Scanner leerFichero = new Scanner(fichero)) {
			leerFichero.useDelimiter("\n");
			while(leerFichero.hasNext()) {
				String cadena = leerFichero.next();
				System.out.println(cadena + " ");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
