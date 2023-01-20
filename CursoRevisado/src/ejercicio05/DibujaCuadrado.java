package ejercicio05;

public class DibujaCuadrado {

	public static void main(String[] args) {
		int tamLado = 8; //tamaño del lado
		for(int i = 0; i<=tamLado; i++) {
			for(int j = 0; j<tamLado; j++) {
				System.out.print("* "); //OJO antes puse println y esto salta de linea, para que no ocurra: print
			}
			System.out.println(" ");
		}
	}
}
