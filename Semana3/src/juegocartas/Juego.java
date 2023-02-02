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
	
	private static String[] palos = baraja.getPalos();
	
	/**
	 * Añade los jugadores al set de jugadores
	 */
	public static void aniadeJugadores() {
		jugadores = new HashSet<Jugador>();
		
		int NUMJUGADORES = 4;
		int[] edad = {28, 33, 21, 45};
		String[] nombre = {"Miriam", "Lucas", "Alfredo", "Sandra"}; 

		int i = 0;
		for(String s : nombre) {
			Jugador jugador = new Jugador();
			jugador.setNombre(s);
			jugador.setEdad(edad[i]);
			jugadores.add(jugador);
			i++;
		}
		
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
	 * Reparte un numero de cartas determinado a un jugador
	 * @param jugador
	 * @param numeroCartas
	 */
	public static void repartirCarta(Jugador jugador, int numeroCartas) {
		Iterator itMazo = mazo.iterator();
		
		while(numeroCartas > 0) {
			if(itMazo.hasNext()) {
				Carta c = (Carta) itMazo.next(); //obtengo mi carta del mazo
				jugador.aniadirCartaAMano(c);
				itMazo.remove(); //la elimino del mazo
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
		while(contadorNumCartas < NUMMAXCARTAS) { //mientras no haya repartido cinco cartas a cada jugador
			while(itJugadores.hasNext()){ //recorro el set de jugadores 
				Jugador j = (Jugador) itJugadores.next();
				repartirCarta(j, 1); //le reparto una carta
			}
			if(!itJugadores.hasNext()){ //si he finalizado de recorrer el set, empiezo de nuevo poniendo el it al incio
				itJugadores = jugadores.iterator();
			}
			contadorNumCartas++; //aumento el contador hasta llegar al total repartido = 5 por jugador
		}
		
	}
	
	/**
	 * Muestra la mano de los jugadores
	 */
	public static void mostrarManoJugadores() {
		for(Jugador j : jugadores) { //itero set jugadores
			System.out.println("Jugador: " + j.getNombre()); //muestro su nombre
			for(Carta c : j.getMano()) { //itero set de cartas del jugador
				System.out.println(c.mostrarCarta()); //muestro las cartas
			}
			System.out.println("----------------------");
		}
	}
	
	/**
	 * Baraja el mazo de cartas
	 * @return el mazo de cartas barajado
	 */
	public static Set<Carta> barajarMazo() {
	     List<Carta> listaCartas = new ArrayList<Carta>(mazo); //casteamos a list para poder usar shuffle
	 
	     for(int i = 0; i<3; i++) { //barajamos tres veces
	    	 Collections.shuffle(listaCartas, new Random());
	     }	     
	     Set<Carta> mazoBarajado = new HashSet<Carta>();
	     mazoBarajado.addAll(listaCartas); 
	     
	     
	     return mazoBarajado;
	}
	
	/**
	 * Descarta las cartas de cada jugador 
	 * de las que solo tenga una de un palo
	 */
	public static void descarteDeCartas() { //VERSION 1. VOY POR AQUÍ -- HACERLO SIN CONTADORES, CON BUCLES COMPARATIVOS
		
		//Me voy a descartar las cartas que tenga de un solo palo
		//tengo que comprobar carta por carta de mi mano si el palo
		//de esa carta coincide con algun palo de las otras 4 restantes
		
		for(Jugador j : jugadores) {
			int contadorDescarte = 0;
			
			Iterator itMano = j.getMano().iterator();

			int contPica = 0;
			int contTrebol = 0;
			int contCorazon = 0;
			int contDiamante = 0;
			
			//VEO SI TENGO ALGUNAS UNICAS
			while(itMano.hasNext()) {
				String tipo = ((Carta) itMano.next()).getTipo(); //carta a partir de 2
	
				if(tipo.equals("pica")) contPica++;
				if(tipo.equals("trebol")) contTrebol++;
				if(tipo.equals("corazon")) contCorazon++;
				if(tipo.equals("diamante")) contDiamante++;	
			}
			
			//Borro las que sean únicas == 1
			Iterator itManoBorrar = j.getMano().iterator();
			while(itManoBorrar.hasNext()) {
				Carta c = (Carta) itManoBorrar.next();
				String tipoCarta = c.getTipo();
				if(contPica == 1 && tipoCarta.equals("pica")) {
					itManoBorrar.remove();
					contPica = 0;
					contadorDescarte++;
				}
				if(contTrebol == 1 && tipoCarta.equals("trebol")) {
					itManoBorrar.remove();
					contTrebol = 0;
					contadorDescarte++;
				}
				if(contCorazon == 1 && tipoCarta.equals("corazon")) {
					itManoBorrar.remove();
					contCorazon = 0;
					contadorDescarte++;
				}
				if(contDiamante == 1 && tipoCarta.equals("diamante")) {
					itManoBorrar.remove();
					contDiamante = 0;
					contadorDescarte++;
				}			
			}
			
			repartirCarta(j, contadorDescarte);
			
			
			/*while(itMano.hasNext()) {
				String tipo = ((Carta) itMano.next()).getTipo(); //Cojo el tipo de la carta 1
				Iterator itManoComp = j.getMano().iterator();
				while(itManoComp.hasNext()) {
					String tipoSiguiente = ((Carta) itMano.next()).getTipo(); //carta a partir de 2
					itManoComp.next();
				}
				itMano.next();
			}*/
		}
		
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
			System.out.println(c.mostrarCarta());
		}	
		System.out.println("******************************");
		
		aniadeJugadores(); //añadimos al set los jugadores y los mostramos
		System.out.println("********* JUGADORES **********");
		for(Jugador j : jugadores) {
			System.out.println(j.mostrarJugador());
		}
		System.out.println("******************************");
		
		repartirCartasInicioJuego();
		System.out.println("*** MANOS DE LOS JUGADORES ***");
		mostrarManoJugadores();
		
		descarteDeCartas();
	}

}
