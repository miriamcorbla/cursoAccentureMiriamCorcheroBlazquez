package es.rf.curso.base;

import java.util.Scanner;

public class Multiplo {
	public static int cualEsMayor (int a, int b) {
		if(a > b) {
			return a;
		}else {
			return b;
		}
	}
	public static Boolean sonIguales(int a, int b) {
		return a==b;
	}
	public static Boolean esMultiplo(int a, int b) {
		//si el mayor es multiplo del menor
		int elMayor = cualEsMayor(a, b);
		if(elMayor == a) {
			return((a % b) == 0);
		}else {
			return ((b % a) == 0);
		}
	}

	public static void main(String[] args) {
		System.out.println("Introduce el primer valor: ");
		Scanner s = new Scanner(System.in);
		int num1 = s.nextInt();
		System.out.println("Introduce el segundo valor: ");
		int num2 = s.nextInt();
		
		int elMayor = cualEsMayor(num1, num2);
		System.out.println("El mayor: " + elMayor);
		System.out.println("¿Son iguales?: " + sonIguales(num1, num2));
		System.out.println("¿Es multiplo el mayor (" +elMayor+") del menor?: "  + esMultiplo(num1, num2));
	}

}
