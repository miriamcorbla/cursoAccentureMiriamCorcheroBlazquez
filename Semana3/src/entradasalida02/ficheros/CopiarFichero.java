package entradasalida02.ficheros;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Clase que copia un fichero en otro fichero existente
 * @author m.corchero.blazquez
 *
 */
public class CopiarFichero {

	public static void main(String[] args) throws IOException {
		Path pathSource1 = Paths.get("C:\\Users\\m.corchero.blazquez\\OneDrive - Accenture\\cursoWorkspace\\Semana3\\src\\entradasalida02\\ficheros\\FicheroALeer.java");
		Path destPath2 = Paths.get("C:\\Users\\m.corchero.blazquez\\OneDrive - Accenture\\cursoWorkspace\\Semana3\\src\\entradasalida02\\ficheros\\PruebaCopia.txt");
		Path target = Files.copy(pathSource1, destPath2, StandardCopyOption.REPLACE_EXISTING);
		System.out.println(target.getFileName());
	}
}
