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
		File ficheroALeer = null; //fichero que leeremos
		FileReader leyendo = null;
		StringBuilder cadenaFinal = new StringBuilder(); //String donde guardar lo que contiene el fichero y mostrarlo por pantalla
		BufferedReader buffer = null;
		
		//Ubicación del fichero a leer
		ficheroALeer = new File("C:\\Users\\m.corchero.blazquez\\OneDrive - Accenture\\cursoWorkspace\\Semana3\\src\\entradasalida04\\nombreapellidosscannerficheros\\FicheroGrabarNombreApellido.txt");
		try {
			leyendo = new FileReader(ficheroALeer);
			buffer = new BufferedReader(leyendo);
			
			String nombreapellidos;
			try {
				while ((nombreapellidos = buffer.readLine()) != null) { //iteramos liena a linea sobre el fichero a leer
					String[] texto = nombreapellidos.split("=");
					if(texto[0].equals("NOMBRE")) {
						cadenaFinal.append(texto[1]);
					}
					if(texto[0].equals("APELLIDO")) {
						cadenaFinal.append(" " + texto[1]);
					}
					//cadenaFinal.append(nombreapellidos + " "); //lo añadimos a la cadena que devolveremos al final
				}
				System.out.println(cadenaFinal); //mostramos resultado
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
