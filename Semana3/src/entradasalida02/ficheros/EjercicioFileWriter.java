package entradasalida02.ficheros;

import java.io.FileWriter;
import java.io.PrintWriter;

public class EjercicioFileWriter {

	public static void main(String[] args) {
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter("C:\\Users\\m.corchero.blazquez\\OneDrive - Accenture\\cursoWorkspace\\Semana3\\src\\entradasalida01\\scanner\\FicheroPrueba.txt");
			pw = new PrintWriter(fichero);
			for(int i = 0; i<10; i++) {
				pw.println("Linea" + i);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(null!=fichero) {
					fichero.close();
				}
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
