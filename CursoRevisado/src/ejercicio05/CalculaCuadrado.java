package ejercicio05;

/**
 * Clase que recibe una colección de números desde la linea de comandos, 
 * calcula su cuadrado y lo presenta en salida
 * @author m.corchero.blazquez
 * @version 1.0
 */
public class CalculaCuadrado {

	public static void main(String[] args) {
		int longitud = args.length;
		double[] numerosCuadrados = new double[longitud];//inicializo el vector resultado a vacio
		for(int i = 0; i<longitud; i++) {
			numerosCuadrados[i] = Math.pow(Double.valueOf(args[i]), 2); //añadimos en cada posicion el cuadrado del valor 
			//que recibe realizando un cast a doble
			System.out.println("El cuadrado de " + args[i] + " es: " + numerosCuadrados[i]);
		}
		//DEL PROFESOR:
		/*int numero, potencia;
		for(String i : args) {
			numero = Integer.parseInt(i);
			potencia = numero * numero;
			System.out.println("El cuadrado de " + numero + " es: " + potencia);
			
		}*/
	}
}
