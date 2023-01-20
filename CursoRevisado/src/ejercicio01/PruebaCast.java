package ejercicio01;

/**
 * Clase para el ejercicio de cast. En comentarios
 * está indicado donde pienso que se perderán datos. 
 * Posteriormente se imprime por pantalla cada dato.
 * @author m.corchero.blazquez
 *
 */
public class PruebaCast {

	public static void main(String[] args) {
		//Definir una var int e ir copiándola a char float double short y byte
		//cuáles son implícitos o explícitos?
		//Se van a perder datos?
		
		int pruebaDeCasteo = 407689023;
		char enChar = (char)pruebaDeCasteo; //se perderan datos
		float enFloat = pruebaDeCasteo;
		double enDouble = pruebaDeCasteo;
		short enShort = (short)pruebaDeCasteo; //Se perderan datos
		byte enByte = (byte)pruebaDeCasteo; //Se perderan datos
		
		System.out.println("Los resultados:\n Entero: " + pruebaDeCasteo + "\nChar: " + enChar +
				"\nFloat: " + enFloat + "\nDouble: " + enDouble + "\nShort: " + enShort + "\nByte: " + enByte);
		int dato = 23;
		++dato;
		System.out.println("dato: " + dato);

	}
}
