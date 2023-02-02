package juegocartas;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Jugador {
	private static final int MAXNUMMANO = 5;
	private String nombre;
	private int edad;
	private Set<Carta> mano;
	
	public Jugador() {
		mano = new HashSet<>(MAXNUMMANO);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public Set<Carta> getMano() {
		return mano;
	}
	
	public void setMano(Set<Carta> mano) {
		this.mano = mano.stream().collect(Collectors.toSet());
	}
	
	public void aniadirCartaAMano(Carta c) {
		mano.add(c);
	}
	
	public String mostrarJugador() {
		return "Nombre: " + getNombre() + "\tEdad:" + getEdad();
	}

}
