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
 * @author m.corchero.blazquez
 *
 */
public class Juego {
	private static final int NUMMAXCARTAS = 5;
	
	private static Baraja baraja; 
	
	private static Set<Carta> mazo;
	
	private static Set<Jugador> jugadores;
	
	public static void aniadeJugadores() {
		jugadores = new HashSet<Jugador>();
		
		int NUMJUGADORES = 4;
		int[] edad = {28, 33, 21, 45};
		String[] nombre = {"Miriam", "Lucas", "Alfredo", "Sandra"}; 
		
		//HACERLO CON LOS VECTORES y BUCLES!
		
		Jugador jugador1 = new Jugador();
		jugador1.setEdad(edad[0]);
		jugador1.setNombre(nombre[0]);
		jugadores.add(jugador1);
		
		Jugador jugador2 = new Jugador();
		jugador2.setEdad(edad[1]);
		jugador2.setNombre(nombre[1]);
		jugadores.add(jugador2);
		
		Jugador jugador3 = new Jugador();
		jugador3.setEdad(edad[2]);
		jugador3.setNombre(nombre[2]);
		jugadores.add(jugador3);
		
		Jugador jugador4 = new Jugador();
		jugador4.setEdad(edad[3]);
		jugador4.setNombre(nombre[3]);
		jugadores.add(jugador4);
		
		/*
		 *  POR TERMINAR -- FUTURO 
		 
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca los jugadores");
		for(int i = 0; i<NUMJUGADORES; i++) {
			System.out.println("Jugador " + i);
			System.out.println("Introduzca su nombre: ");
			
		}*/
		
		
	}	
	/**
	 * REPARTE UNA CARTA A UN JUGADOR
	 * @param jugador
	 */
	public static void repartirCarta(Jugador jugador) {
		Iterator itMazo = mazo.iterator();
		
		if(itMazo.hasNext()) {
			Carta c = (Carta) itMazo.next(); //obtengo mi carta del mazo
			jugador.aniadirCartaAMano(c);
			itMazo.remove(); //la elimino del mazo
		}
	}
	
	public static void repartirCartasInicioJuego() { // VOY POR AQUI -- TERMINAR!!
		Iterator itJugadores = jugadores.iterator();
		int contadorNumCartas = 0;
		while(contadorNumCartas < NUMMAXCARTAS) {
			while(itJugadores.hasNext()) {
				Jugador j = (Jugador) itJugadores.next();
				repartirCarta(j);
			}
		}
	}
	
	public static void mostrarManoJugadores() {
		for(Jugador j : jugadores) {
			System.out.println("Jugador: " + j.getNombre());
			for(Carta c : j.getMano()) {
				System.out.println(c.mostrarCarta());
			}
			System.out.println("----------------------");
		}
	}
	
	public static Set<Carta> barajarMazo() {
	     List<Carta> listaCartas = new ArrayList<Carta>(mazo); //casteamos a list para poder usar shuffle
	 
	     for(int i = 0; i<3; i++) { //barajamos tres veces
	    	 Collections.shuffle(listaCartas, new Random());
	     }	     
	     Set<Carta> mazoBarajado = new HashSet<Carta>();
	     mazoBarajado.addAll(listaCartas); 
	     
	     
	     return mazoBarajado;
	}
	
	
	public static void main(String[] args) {
		//vamos a añadir nuestra baraja española al mazo con el que jugaremos
		baraja = new Baraja();
		mazo = baraja.getBaraja().stream().collect(Collectors.toSet()); //añado mi baraja española al mazo de juego
		System.out.println("************ MAZO *************");
		for(Carta c : mazo) {
			System.out.println(c.mostrarCarta());
		}
		System.out.println("******************************");
		
		//Vamos a barajar el mazo. El set es aleatorio, pero para darle más realismo, vamos a barajar 3 veces más
		//permutando los valores del set
		System.out.println("******* MAZO BARAJADO ********");
		mazo = barajarMazo();
		for(Carta c : mazo) {
			System.out.println(c.mostrarCarta()); //Seguir por aquí porque no ha permutado nada. probar con ctor y Random
		}	
		System.out.println("******************************");
		
		aniadeJugadores(); //añadimos al set los jugadores y los mostramos
		System.out.println("********* JUGADORES **********");
		for(Jugador j : jugadores) {
			System.out.println(j.mostrarJugador());
		}
		System.out.println("******************************");
		
		repartirCartasInicioJuego(); //TERMINAR!!!
		System.out.println("*** MANOS DE LOS JUGADORES ***");
		mostrarManoJugadores();
	}

}
