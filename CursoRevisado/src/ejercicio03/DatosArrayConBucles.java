package ejercicio03;

/**
 * Clase que a través de su método principal se declaran dos vectores, 
 * tal y como indica el enunciado del ejercicio y posteriormente se asigna
 * de manera automatica a traves del for los valores de 
 * los días en las posiciones adecuadas.
 * @author m.corchero.blazquez
 * @version 1.2
 */
public class DatosArrayConBucles {
	public static void main(String[] args) {
		int[] diaMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int[][] dimensiones = new int[5][7];
		int valor = 1; //dia 1 del mes
		
		//como es un vector bidimensional(matriz), tenemos que recorrerlo con dos bucles for anidados
		for(int i = 0; i<dimensiones.length; i++) {
			for(int j = 0; j<dimensiones[i].length; j++) {
				if(valor <= 31) { //si el valor es menor que 31, un mes no tendrá mas de 31 días
					dimensiones[i][j] = valor; //le asigno el valor
					valor++;
				}
				System.out.print("|\t" + dimensiones[i][j] + "\t|"); //imprimo por pantalla la matriz
			}
			System.out.println("");
		}
	}
}
