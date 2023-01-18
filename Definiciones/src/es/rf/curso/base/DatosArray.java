package es.rf.curso.base;

public class DatosArray {

	public static void main(String[] args) {
		int[] diaMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int[][] dimensiones = new int[5][7];
		int valor = 1;
		/*
		dimensiones[0][0] = 1;
		dimensiones[0][1] = 2;
		dimensiones[0][2] = 3;
		dimensiones[0][3] = 4;
		//...
		dimensiones[1][0] = 8;
		//...*/
		
		for(int i = 0; i<dimensiones.length; i++) {
			for(int j = 0; j<dimensiones[i].length; j++) {
				if(valor <= 31) {
					dimensiones[i][j] = valor;
					valor++;
				}
				System.out.print("|\t" + dimensiones[i][j] + "\t|");
			}
			System.out.println("");
		}

	}

}
