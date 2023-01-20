package ejercicio05;

public class CalculaCuadrado {

	public static void main(String[] args) {
		/*double[] numerosCuadrados = {}; //inicializo el vector resultado a vacio
		int longitud = args.length;
		for(int i = 0; i<longitud; i++) {
			numerosCuadrados[i] = Math.pow(Double.valueOf(args[i]), 2); //añadimos en cada posicion el cuadrado del valor 
			//que recibe realizando un cast a doble
			System.out.println("El cuadrado de " + args[i] + " es: " + numerosCuadrados[i]);
		}*/
		//PENDIENTE DE RESIVAR EL CODIGO COMENTADO
		int numero, potencia;
		for(String i : args) {
			numero = Integer.parseInt(i);
			potencia = numero * numero;
			System.out.println("El cuadrado de " + numero + " es: " + potencia);
			
		}
	}
}
