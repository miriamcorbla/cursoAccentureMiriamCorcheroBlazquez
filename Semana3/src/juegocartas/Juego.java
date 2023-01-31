package juegocartas;

import java.util.Set;

/**
 * Clase juego
 * @author m.corchero.blazquez
 *
 */
public class Juego {
	
	static Set<Carta> mazo;
	
	public static void main(String[] args) {
		Baraja baraja = new Baraja();
		baraja.cargarBaraja();
		mazo = baraja.getBaraja();
	}

}
