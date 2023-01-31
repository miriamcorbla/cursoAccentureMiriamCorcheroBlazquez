package entradasalida04.nombreapellidosscannerficheros;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Clase que lee de teclado el nombre y el apellido y lo graba en
 * un fichero
 * @author m.corchero.blazquez
 *
 */
public class EscrituraNombreApellido {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String nombre; //almacenaremos el nombre
			String apellido; //almacenaremos el apellido
			FileWriter fichero = null; //usaremos fichero y escribir para poder escribir en el fichero
			PrintWriter escribir = null;
			
			System.out.println("Introduzca el nombre");
			nombre = sc.next(); //guardamos el nombre introducido
			System.out.println("Introduzca el apellido");
			apellido = sc.next();
			
			try {
				//ruta del fichero donde escribir
				fichero = new FileWriter("C:\\Users\\m.corchero.blazquez\\OneDrive - Accenture\\cursoWorkspace\\Semana3\\src\\entradasalida04\\nombreapellidosscannerficheros\\FicheroGrabarNombreApellido.txt");
				escribir = new PrintWriter(fichero);
				escribir.println("NOMBRE="+nombre); //escribimos
				escribir.println("APELLIDO="+apellido);
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					if(fichero!=null) {
						fichero.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
