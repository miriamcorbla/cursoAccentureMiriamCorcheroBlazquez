package juegocartas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Clase juego
 * 
 * @author m.corchero.blazquez
 *
 */
public class Juego {
	private static final int NUMMAXCARTAS = 5;

	private static Baraja baraja;

	private static Set<Carta> mazo;

	private static Set<Jugador> jugadores;

	/**
	 * Añade los jugadores al set de jugadores
	 */
	public static void aniadeJugadores() {
		jugadores = new HashSet<Jugador>();

		int NUMJUGADORES = 4;
		int[] edad = { 28, 33, 21, 45 };
		String[] nombre = { "Miriam", "Lucas", "Alfredo", "Sandra" };

		int i = 0;
		for (String s : nombre) {
			Jugador jugador = new Jugador();
			jugador.setNombre(s);
			jugador.setEdad(edad[i]);
			jugadores.add(jugador);
			i++;
		}

		/*
		 * POR TERMINAR -- FUTURO
		 * 
		 * Scanner sc = new Scanner(System.in);
		 * System.out.println("Introduzca los jugadores"); for(int i = 0;
		 * i<NUMJUGADORES; i++) { System.out.println("Jugador " + i);
		 * System.out.println("Introduzca su nombre: ");
		 * 
		 * }
		 */

	}

	/**
	 * Reparte un numero de cartas determinado a un jugador
	 * 
	 * @param jugador
	 * @param numeroCartas
	 */
	public static void repartirCarta(Jugador jugador, int numeroCartas) {
		Iterator itMazo = mazo.iterator();

		while (numeroCartas > 0) {
			if (itMazo.hasNext()) {
				Carta c = (Carta) itMazo.next(); // obtengo mi carta del mazo
				jugador.aniadirCartaAMano(c);
				itMazo.remove(); // la elimino del mazo
			}
			numeroCartas--;
		}
	}

	/**
	 * Reparte 5 cartas a cada jugador en el inicio del juego
	 */
	public static void repartirCartasInicioJuego() {
		Iterator itJugadores = jugadores.iterator();
		int contadorNumCartas = 0;
		while (contadorNumCartas < NUMMAXCARTAS) { // mientras no haya repartido cinco cartas a cada jugador
			while (itJugadores.hasNext()) { // recorro el set de jugadores
				Jugador j = (Jugador) itJugadores.next();
				repartirCarta(j, 1); // le reparto una carta
			}
			if (!itJugadores.hasNext()) { // si he finalizado de recorrer el set, empiezo de nuevo poniendo el it al
											// incio
				itJugadores = jugadores.iterator();
			}
			contadorNumCartas++; // aumento el contador hasta llegar al total repartido = 5 por jugador
		}

	}

	/**
	 * Muestra la mano de los jugadores
	 */
	public static void mostrarManoJugadores() {
		for (Jugador j : jugadores) { // itero set jugadores
			System.out.println("Jugador: " + j.getNombre()); // muestro su nombre
			for (Carta c : j.getMano()) { // itero set de cartas del jugador
				System.out.println(c.mostrarCarta()); // muestro las cartas
			}
			System.out.println("----------------------");
		}
	}

	/**
	 * Baraja el mazo de cartas
	 * 
	 * @return el mazo de cartas barajado
	 */
	public static Set<Carta> barajarMazo() {
		List<Carta> listaCartas = new ArrayList<Carta>(mazo); // casteamos a list para poder usar shuffle

		for (int i = 0; i < 3; i++) { // barajamos tres veces
			Collections.shuffle(listaCartas, new Random());
		}
		Set<Carta> mazoBarajado = new HashSet<Carta>();
		mazoBarajado.addAll(listaCartas);

		return mazoBarajado;
	}

	/**
	 * Comprueba si una carta es la única de su palo en la mano del jugador
	 * 
	 * @param jugador
	 * @param carta
	 * @return verdadero o falso
	 */
	public static boolean esUnica(Jugador jugador, Carta carta) {
		String tipo = carta.getTipo();
		for (Carta c : jugador.getMano()) {
			String tipoCartaMano = c.getTipo();
			if (tipo.equals(tipoCartaMano) && !carta.equals(c)) { // aqui hay un problema
				return false;
			}
		}
		return true;
	}

	/**
	 * Método que elimina las cartas de palos unicos que 
	 * tiene el jugador en su mano, y recoge tantas cartas
	 * como se haya eliminado
	 */
	public static void descarteDeCartas() {
		for (Jugador j : jugadores) {
			int contadorDescarte = 0;
			Iterator<Carta> itMano = j.getMano().iterator();
			while(itMano.hasNext()) {
				boolean unica = esUnica(j, itMano.next());
				if(unica) {
					itMano.remove();
					contadorDescarte++;
				}
			}
			repartirCarta(j, contadorDescarte);
		}
	}

	public static void main(String[] args) {
		// vamos a añadir nuestra baraja española al mazo con el que jugaremos
		baraja = new Baraja();
		mazo = baraja.getBaraja().stream().collect(Collectors.toSet()); // añado mi baraja española al mazo de juego
		System.out.println("************ MAZO *************");
		for (Carta c : mazo) {
			System.out.println(c.mostrarCarta());
		}
		System.out.println("******************************");

		// Vamos a barajar el mazo. El set es aleatorio, pero para darle más realismo,
		// vamos a barajar 3 veces más
		// permutando los valores del set
		System.out.println("******* MAZO BARAJADO ********");
		mazo = barajarMazo();
		for (Carta c : mazo) {
			System.out.println(c.mostrarCarta());
		}
		System.out.println("******************************");

		aniadeJugadores(); // añadimos al set los jugadores y los mostramos
		System.out.println("********* JUGADORES **********");
		for (Jugador j : jugadores) {
			System.out.println(j.mostrarJugador());
		}
		System.out.println("******************************");

		repartirCartasInicioJuego();
		System.out.println("*** MANOS DE LOS JUGADORES ***");
		mostrarManoJugadores();

		descarteDeCartas();
		System.out.println("*** MANOS DE LOS JUGADORES POST DESCARTE ***");
		mostrarManoJugadores();
	}

}
