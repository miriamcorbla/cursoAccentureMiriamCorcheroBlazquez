package ejercicio01;

import java.time.LocalTime;

/**
 * Clase Enlace - explicación en clase
 * @author m.corchero.blazquez
 *
 */
public class Enlace {
	public String url;
	public LocalTime hora;
	public int indice;
	static int contador = 0;
	
	Enlace(){
		indice = contador++;
	}
	public void modificaciones() {
		System.out.println(this);
	}
	
	public String toString() {
		return "Enlace: [url = " + url + " Hora: " + hora + 
				" Indice: " + indice + " Contador: " + contador + "]";
	}

}
