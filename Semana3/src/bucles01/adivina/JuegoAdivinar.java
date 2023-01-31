package bucles01.adivina;

import java.util.Random;
import java.util.Scanner;

/**
 * Juego para adivinar un numero entre el 1 y el 100.
 * @author m.corchero.blazquez
 *
 */
public class JuegoAdivinar {

	public static void main(String[] args) {
		Random aleatorio = new Random();
		Scanner sc = new Scanner(System.in);
		
		int numeroAdivinar = aleatorio.nextInt(100)+1; //instancio numero aleatorio a adivinar 
		//utilizando clase Random --> Del 1 al 100
		
		boolean adivinado = false; //variable de control
		int numero;
		
		while(!adivinado){
			System.out.println("Introduce un numero entero entre 1 y 100");
			numero = sc.nextInt();
			if(numero > numeroAdivinar) { //si el numero que introduce es mayor que el aleatorio que tengo que adivinar
				System.out.println("El numero que has introducido es mayor");
			}else {
				if(numero < numeroAdivinar) { //si es menor
					System.out.println("El numero que has introducido es menor");
				}else { //si es el mismo
					adivinado = true;
					System.out.println("¡Correcto! Has adivinado el numero. \nNumero: " + numero);
				}
			}
		}

	}
}
