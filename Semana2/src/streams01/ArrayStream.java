package streams01;

import java.util.Arrays;

public class ArrayStream {

	public static void main(String[] args) {
		int[] numeros = new int[10];
		for(int i = 0; i<numeros.length; i++) {
			numeros[i] = i;
		}
		//vamos a sacar los pares
		int[] solucion = Arrays.stream(numeros)
				.filter(num -> (num % 2 == 0))
				.toArray();
		
		Arrays.stream(solucion).forEach(System.out::println);
	}

}
