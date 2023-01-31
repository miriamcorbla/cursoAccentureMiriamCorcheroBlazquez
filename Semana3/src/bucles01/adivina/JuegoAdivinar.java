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
		
		int numeroAdivinar = (int) (Math.random()*(10-0+1)+0); //aleatorio.nextInt(10-0+1); //instancio numero aleatorio a adivinar 
		//utilizando clase Random --> Del 1 al 10
		boolean adivinado = false; //variable de control
		int numero;
		
		boolean adivinadoMaquina = false; //variable de control
		int superior = 10;
		int inferior = 0;
		int numeroDeMaquina = aleatorio.nextInt(superior-inferior+1);
		int opcion;
		
		while(!adivinado && !adivinadoMaquina){
			System.out.println("Tu turno: Introduce un numero entero entre 0 y 10");
			numero = sc.nextInt();
			System.out.println("Turno máquina: Digo el numero: " + numeroDeMaquina + "\nTu numero es: \n1. Mayor\n2. Menor\n3. Correcto");
			opcion = sc.nextInt();
			//yo juego
			if(numero > numeroAdivinar) { //si el numero que introduce es mayor que el aleatorio que tengo que adivinar
				System.out.println("El número que has introducido es mayor");
				System.out.println("***");
			}else {
				if(numero < numeroAdivinar) { //si es menor
					System.out.println("El número que has introducido es menor");
					System.out.println("***");
				}else { //si es el mismo
					adivinado = true;
					System.out.println("¡Correcto! Has adivinado el numero. \nNumero: " + numero);
				}
			}
			//la máquina juega
			if(opcion == 1) { //Si el numero que has pensado tu es mayor que el que te ha dicho la máquina
				inferior = numeroDeMaquina + 1;
				numeroDeMaquina = (int) (Math.random()*(superior-inferior+1)+inferior);
			}else {
				if(opcion == 2) { //Si el número que has pensado tu es menor que el que te ha dicho la máquina
					superior = numeroDeMaquina - 1;
					numeroDeMaquina = (int) (Math.random()*(superior-inferior+1)+inferior);
				}else { //si es el mismo
					adivinadoMaquina = true;
					System.out.println("¡La máquina ha adivinado el número!");
				}
			}
		}
	}
}
