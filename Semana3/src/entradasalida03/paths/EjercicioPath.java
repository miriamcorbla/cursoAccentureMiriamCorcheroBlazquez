package entradasalida03.paths;

import java.nio.file.Path;
import java.nio.file.Paths;

public class EjercicioPath {

	public static void main(String[] args) {
		
		Path direccion = Paths.get("C:\\Users\\m.corchero.blazquez\\OneDrive - Accenture\\cursoWorkspace\\Semana3\\src\\entradasalida03\\paths\\PruebaParaEjercicioPath.txt");
		System.out.println(direccion.toString());
		System.out.println("File Name: " + direccion.getFileName());
		System.out.println("Name ruta padre: " + direccion.getName(1)); //deberia dar la ruta padre
		System.out.println("Name ruta padre del padre: " + direccion.getName(0)); //deberia dar la ruta padre
		System.out.println("Name Count:" + direccion.getNameCount());
		System.out.println("SubPath: " + direccion.subpath(0, 1));
		System.out.println("Parent: " + direccion.getParent());
		System.out.println("Root: " + direccion.getRoot());
		System.out.println("Absolute Path: " + direccion.toAbsolutePath());
		//System.out.println("Real Path: " + direccion.toRealPath(direccion.normalize()));
		System.out.println("To File: " + direccion.toFile());
		System.out.println("Normalize: " + direccion.normalize());
		System.out.println("Compare To: " + direccion.compareTo(direccion));
		System.out.println("Ends with: " + direccion.endsWith("C:\\Users\\m.corchero.blazquez\\OneDrive - Accenture\\cursoWorkspace\\Semana3\\src\\entradasalida03\\paths\\EjercicioPath.java"));
		System.out.println("Ends with string: " + direccion.endsWith("PruebaParaEjercicioPath.txt"));

	}

}
