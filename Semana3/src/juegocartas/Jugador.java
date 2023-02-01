package juegocartas;

import java.util.HashSet;
import java.util.Set;

public class Jugador {
	
	private String nombre;
	private int edad;
	private Set<Carta> mano;
	
	public Jugador() {
		mano = new HashSet<Carta>();
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
		this.mano = mano;
	}
	
	public String jugador() {
		return getNombre() + " " + getEdad() + " ";
	}

}
