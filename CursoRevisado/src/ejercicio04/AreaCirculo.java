package ejercicio04;

/**
 * Dado el radio, (23), calcular el área del circulo y 
 * la longitud de la circunferencia.
 * @author m.corchero.blazquez
 * @version 1.2
 */
public class AreaCirculo {	
	public static void main(String[] args) {
		float radio; //declaro variables
		float resultadoArea;
		float resultadoLongitud;
		radio = 23f; //inicializo variable radio con el dato indicado
		resultadoLongitud = 2 * (float)Math.PI * radio; //cálculo de longitud
		resultadoArea = (float) (Math.PI * Math.pow(radio, 2)); //cálculo de área
		//muestro los resultados por pantalla
		System.out.println("La Longitud es: " + resultadoLongitud);
		System.out.println("El area es: " + resultadoArea);		
	}

}
