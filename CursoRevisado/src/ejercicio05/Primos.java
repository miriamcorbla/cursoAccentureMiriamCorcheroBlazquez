package ejercicio05;

/**
 * Cálculo de números de primos entre 1 y 100
 * @author m.corchero.blazquez
 * @version 1.2
 */
public class Primos {
	
	public static boolean primo (int num) {
		boolean primo = true;
		for(int i = 2; i < num; i++) { //compruebo si es divisible por todos los menores que el
			if((num % i) == 0) { //cambiar condición, esta no está bien
				primo = false;
			}
		}
		return primo;
	}
	
	/* Del profesor:
	 int j = 2;
	 boolean primo = true;
	 while( j<= Math.sqrt(num) && primo == true){
		 if(num % j == 0){
			 primo = false;
		 }
		 j++;
	 }
	 return primo;
	 */
	
	public static void main(String[] args) {
		int contadorPrimos = 0;
		int busqueda = 100;
		for(int i=1; i<=busqueda; i++) { //itero entre 1 y el maximo que tengo que buscar
			if(primo(i)) { //si es primo, sumo uno al contador
				contadorPrimos++;
			}
		}
		System.out.println("Entre 1 y " + busqueda + " hay un total de: " + contadorPrimos + " numeros primos.");

	}

}
