package ejercicio03;

/**
 * Clase que a través de su método principal imprime por pantalla
 * los datos que se declaran para que sean vistas por cualquier
 * método de clase, tal y como indica el enunciado del ejercicio
 * @author m.corchero.blazquez
 * @version 1.2
 */
public class Datos2 {
	static int dia = 10;
	static int nDni = 57443222;
	static double precio;
	static final boolean ACTIVO = true;
	
	public static void main(String[] args) {
		precio = 135.12;
		//imprimimos por pantalla los valores
		System.out.println("Dia\t"+dia+"\nDni\t"+nDni+
				"\nPrecio\t"+precio+"\nActivo?\t"+ACTIVO);
	}
}
