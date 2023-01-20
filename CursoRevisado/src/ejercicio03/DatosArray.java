package ejercicio03;

/**
 * Clase en la que a través de su método principal se declaran dos vectores, 
 * tal y como indica el enunciado del ejercicio y posteriormente se asigna
 * manualmente los valores de los días en las posiciones adecuadas.
 * @author m.corchero.blazquez
 * @version 1.2
 */
public class DatosArray {
	public static void main(String[] args) {
		int[] diaMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int[][] dimensiones = new int[5][7];

		//vamos asignando manualmente los valores
		dimensiones[0][0] = 1;
		dimensiones[0][1] = 2;
		dimensiones[0][2] = 3;
		dimensiones[0][3] = 4;
		//...
		dimensiones[1][0] = 8;
		//...
		
	}

}
