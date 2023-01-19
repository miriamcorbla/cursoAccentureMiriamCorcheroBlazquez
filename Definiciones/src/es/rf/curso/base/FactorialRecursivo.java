package es.rf.curso.base;

public class FactorialRecursivo {
	
	public static int factorial (int num) {
		if(num == 0) { //caso base, si es 0 se multiplica por 1 porque si no el resultado sera 0s
			return 1;
		}else {
			return num * factorial(num-1); //vamos multiplicando el numero por el factorial de ese numero menos 1
		}
	}
	public static void main(String[] args) {
		int n = 8;
		System.out.println(factorial(n)); //mostramos el resultado
	}

}
