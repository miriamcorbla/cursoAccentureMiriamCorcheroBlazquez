package es.rf.curso.base;

import java.time.LocalTime;

/**
 * Prueba de cómo definir los campos
 * @author m.corchero.blazquez
 *
 */
public class Definiciones {
	/* De una explicacion:
	private boolean seguro; // definición variable booleana privada
	private boolean esSeguro = false; //Inicialización variable booleana privada
	private int importe = 0; //Uso literales para definirlas, 0 es un literal
	private double cantidad = 0d;
	static String descripcion;
	public String nombre;
	public String valor = "";
	*/

	/**
	 * Lanzamiento por consola
	 * @param args
	 */
	public static void main(String[] args) {
		Enlace ss1 = new Enlace();
		ss1.url = "hhhhhshda";
		ss1.hora = LocalTime.now();
		ss1.modificaciones();
		
		Enlace ss2 = new Enlace();
		ss2.url = "hsdfddhda";
		ss2.hora = LocalTime.now();
		ss2.modificaciones();
		
		Enlace ss3 = new Enlace();
		ss3.url = "hsdfddhda";
		ss3.hora = LocalTime.now();
		ss3.modificaciones();
		
		Enlace.contador = 100;
		ss1.modificaciones();
		ss2.modificaciones();
		ss3.modificaciones();

	}

}
