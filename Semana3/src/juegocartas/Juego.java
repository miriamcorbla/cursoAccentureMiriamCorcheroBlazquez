package juegocartas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Clase juego
 * @author m.corchero.blazquez
 *
 */
public class Juego {
	
	private static Baraja baraja; 
	
	private static Set<Carta> mazo;
	
	private static Set<Jugador> jugadores;
	
	public static void aniadeJugadores() {
		
		int NUMJUGADORES = 4;
		int[] edad = {28, 33, 21, 45};
		String[] nombre = {"Miriam", "Lucas", "Alfredo", "Sandra"}; 
		
		Jugador jugador1 = new Jugador();
		jugador1.setEdad(edad[0]);
		jugador1.setNombre(nombre[0]);
		
		Jugador jugador2 = new Jugador();
		jugador1.setEdad(edad[1]);
		jugador1.setNombre(nombre[1]);
		
		Jugador jugador3 = new Jugador();
		jugador1.setEdad(edad[2]);
		jugador1.setNombre(nombre[2]);
		
		Jugador jugador4 = new Jugador();
		jugador1.setEdad(edad[3]);
		jugador1.setNombre(nombre[3]);
		
		//Añadimos los jugadores al set de jugadores
		jugadores.add(jugador1);
		jugadores.add(jugador2);
		jugadores.add(jugador3);
		jugadores.add(jugador4);		
	}	
	
	public void repartirCarta(int cantidadCartas, Jugador jugador) {
		//este metodo tiene que repartir las cartas del mazo que se
		//indiquen al jugador indicado
	}
	
	
	public static void main(String[] args) {
		baraja = new Baraja();
		mazo = baraja.getBaraja().stream().collect(Collectors.toSet()); //añado mi baraja española al mazo de juego
		System.out.println(mazo.size());
		mazo.forEach(System.out::println);
		
	}

}
