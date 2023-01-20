package ejercicio05;

import java.util.Scanner;
/**
 * Cargar dos variables int  con los valores 10 y 20, e indicar cual es mayor, si son iguales, 
 * o si uno es múltiplo de otro.
 * @author m.corchero.blazquez
 * @version 1.0
 */
public class Multiplo {
	/**
	 * Método que comprueba qué dato es mayor
	 * @param a
	 * @param b
	 * @return el número que es mayor
	 */
	public static int cualEsMayor (int a, int b) {
		if(a > b) {
			return a;
		}else {
			return b;
		}
	}
	/**
	 * Método que devuelve true o false  
	 * dependiendo de si son iguales o no
	 * @param a 
	 * @param b
	 * @return true o false 
	 */
	public static Boolean sonIguales(int a, int b) {
		return a==b;
	}
	/**
	 * Método que devuelve true o false  
	 * dependiendo de si el mayor es múltiplo
	 * del menor
	 * @param a
	 * @param b
	 * @return true o false
	 */
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
