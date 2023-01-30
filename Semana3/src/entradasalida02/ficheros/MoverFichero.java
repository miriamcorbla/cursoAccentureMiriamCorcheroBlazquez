package entradasalida02.ficheros;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Mueve un fichero de una carpeta a otra
 * @author m.corchero.blazquez
 *
 */
public class MoverFichero {

	public static void main(String[] args) throws IOException {
		Path origen = Paths.get("C:\\Users\\m.corchero.blazquez\\OneDrive - Accenture\\cursoWorkspace\\Semana3\\src\\entradasalida03\\paths\\FicheroAMover.txt");
		Path destino = Paths.get("C:\\Users\\m.corchero.blazquez\\OneDrive - Accenture\\cursoWorkspace\\Semana3\\src\\entradasalida02\\ficheros\\FicheroMovido.txt");
		Files.move(origen, destino, StandardCopyOption.REPLACE_EXISTING);
	}
}
