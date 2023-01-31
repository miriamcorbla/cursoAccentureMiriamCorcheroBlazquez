package bucles01.adivina;

import java.util.Scanner;

/**
 * Juego para adivinar un numero entre el 1 y el 100.
 * 
 * @author m.corchero.blazquez
 *
 */
public class JuegoAdivinar {

	static int superior = 10;
	static int inferior = 0;
	static int numeroDeMaquina;
	static boolean adivinado, adivinadoMaquina;

	public static boolean miTurno(int numero, boolean adivinado, int numeroAdivinar) {
		if (numero > numeroAdivinar) { // si el numero que introduce es mayor que el aleatorio que tengo que adivinar
			System.out.println("El número que has introducido es mayor");
			System.out.println("***");
		} else {
			if (numero < numeroAdivinar) { // si es menor
				System.out.println("El número que has introducido es menor");
				System.out.println("***");
			} else { // si es el mismo
				adivinado = true;
				System.out.println("¡Correcto! Has adivinado el numero. \nNumero: " + numero);
			}
		}
		return adivinado;

	}

	public static boolean turnoMaquina(int opcion) {
		if (opcion == 1) { // Si el numero que has pensado tu es mayor que el que te ha dicho la máquina
			inferior = numeroDeMaquina + 1;
			numeroDeMaquina = (superior + inferior) / 2;
		} else {
			if (opcion == 2) { // Si el número que has pensado tu es menor que el que te ha dicho la máquina
				superior = numeroDeMaquina - 1;
				numeroDeMaquina = (superior + inferior) / 2;
			} else { // si es el mismo
				adivinadoMaquina = true;
				System.out.println("¡La máquina ha adivinado el número!");
			}
		}
		return adivinadoMaquina;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		adivinado = false; // variable de control
		int numero;

		adivinadoMaquina = false; // variable de control

		int opcion;
		numeroDeMaquina = (int) (Math.random() * (superior - inferior + 1) + inferior);
		int numeroAdivinar = (int) (Math.random() * (10 - 0 + 1) + 0);

		while (!adivinado && !adivinadoMaquina) {
			System.out.println("Turno máquina: Digo el numero: " + numeroDeMaquina
					+ "\nTu numero es: \n1. Mayor\n2. Menor\n3. Correcto");
			opcion = sc.nextInt();

			adivinadoMaquina = turnoMaquina(opcion);
			if (!adivinadoMaquina) {
				System.out.println("Tu turno: Introduce un numero entero entre 0 y 10");
				numero = sc.nextInt();

				adivinado = miTurno(numero, adivinado, numeroAdivinar);
			}

		}
		/***********************************************************************/
		/*
		 * VERSION FUNCIONAL INICIAL SIN METODOS COMENTADA PARA NO PERDERLA:
		 * while(!adivinado && !adivinadoMaquina){
		 * System.out.println("Tu turno: Introduce un numero entero entre 0 y 10");
		 * numero = sc.nextInt(); System.out.println("Turno máquina: Digo el numero: " +
		 * numeroDeMaquina + "\nTu numero es: \n1. Mayor\n2. Menor\n3. Correcto");
		 * opcion = sc.nextInt(); //yo juego if(numero > numeroAdivinar) { //si el
		 * numero que introduce es mayor que el aleatorio que tengo que adivinar
		 * System.out.println("El número que has introducido es mayor");
		 * System.out.println("***"); }else { if(numero < numeroAdivinar) { //si es
		 * menor System.out.println("El número que has introducido es menor");
		 * System.out.println("***"); }else { //si es el mismo adivinado = true;
		 * System.out.println("¡Correcto! Has adivinado el numero. \nNumero: " +
		 * numero); } } //la máquina juega if(opcion == 1) { //Si el numero que has
		 * pensado tu es mayor que el que te ha dicho la máquina inferior =
		 * numeroDeMaquina + 1; numeroDeMaquina = (int)
		 * (Math.random()*(superior-inferior+1)+inferior); }else { if(opcion == 2) {
		 * //Si el número que has pensado tu es menor que el que te ha dicho la máquina
		 * superior = numeroDeMaquina - 1; numeroDeMaquina = (int)
		 * (Math.random()*(superior-inferior+1)+inferior); }else { //si es el mismo
		 * adivinadoMaquina = true;
		 * System.out.println("¡La máquina ha adivinado el número!"); } } }
		 */
	}
}
