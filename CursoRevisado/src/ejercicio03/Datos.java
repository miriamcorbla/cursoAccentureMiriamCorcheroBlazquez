package ejercicio03;

/**
 * Clase que a través de su método principal imprime por pantalla
 * los datos que se declaran, tal y como indica el enunciado del ejercicio
 * @author m.corchero.blazquez
 * @version 1.2
 */
public class Datos {
	public static void main(String[] args) {
		int dia = 10;
		int nDni = 57443222;
		double precio;
		final boolean ACTIVO = true;
		precio = 135.12;
		//imprime por pantalla todos los datos declarados anteriormente
		System.out.println("Dia\t"+dia+"\nDni\t"+nDni+
				"\nPrecio\t"+precio+"\nActivo?\t"+ACTIVO);
	}
}
