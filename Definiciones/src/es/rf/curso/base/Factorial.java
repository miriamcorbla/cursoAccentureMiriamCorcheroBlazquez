package es.rf.curso.base;

public class Factorial {

	public static void main(String[] args) {
		int num = 8, result = 1;
		for(int i = 1; i<=num; i++) { //realmente se puede hacer desde 1 hasta 8 o desde 8 hasta 1
			result *= i; //voy multiplicando todos hasta llegar a 8
		}
		System.out.println(result);
	}
}
