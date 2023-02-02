package juegocartas;

import java.util.HashSet;
import java.util.Set;

/**
 * Clase que construye la baraja con las cartas
 * @author m.corchero.blazquez
 *
 */
public class Baraja {
	
	int maximoCartas = 52;
	int maxNumCartaPorPalo = 13;
	private Set<Carta> baraja = new HashSet<Carta>(maximoCartas);
	
	private String[] palos = {"pica", "corazon", "trebol", "diamante"};


	public void cargarBarajaPoker() {
		for(int i = 0; i<palos.length; i++) {
			for(int j = 1; j<=maxNumCartaPorPalo; j++) {
				Carta carta = new Carta();
				carta.setNumero(j);
				carta.setTipo(palos[i]);
				baraja.add(carta);
			}
		}
	}
	
	public Set<Carta> getBaraja(){
		return baraja;
	}	
	
	public void mostrarBaraja() {
		for(Carta c : baraja) {
			System.out.println(c.mostrarCarta());
		}
	}
	
	public String[] getPalos() {
		return palos;
	}

	public void setPalos(String[] palos) {
		this.palos = palos;
	}
	
	public Baraja() {
		cargarBarajaPoker();
	}

}
