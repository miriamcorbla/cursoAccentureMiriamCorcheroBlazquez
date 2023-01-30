package entradasalida04.nombreapellidosscannerficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase que lee del fichero y devuelve la cadena con todo lo que contiene dicho fichero
 * @author m.corchero.blazquez
 *
 */
public class LecturaFicheroNombreApellido {

	public static void main(String[] args) {
		File ficheroALeer = null;
		FileReader leyendo = null;
		StringBuilder cadenaFinal = new StringBuilder();
		BufferedReader buffer = null;
		
		ficheroALeer = new File("C:\\Users\\m.corchero.blazquez\\OneDrive - Accenture\\cursoWorkspace\\Semana3\\src\\entradasalida04\\nombreapellidosscannerficheros\\FicheroGrabarNombreApellido.txt");
		try {
			leyendo = new FileReader(ficheroALeer);
			buffer = new BufferedReader(leyendo);
			
			String nombreapellidos;
			try {
				while ((nombreapellidos = buffer.readLine()) != null) {
					cadenaFinal.append(nombreapellidos + " ");
				}
				System.out.println(cadenaFinal);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				if(leyendo!=null) {
					leyendo.close();
				}				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
