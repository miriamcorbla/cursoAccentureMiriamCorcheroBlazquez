package excepciones.gestion;

/**
 * Clase que define las variables a y b y calcula el cociente de b/a.
 * Controla las excepciones pasándolo al módulo
 * llamador y siempre muestra por pantalla un mensaje
 * al finalizar el programa
 * @author m.corchero.blazquez
 * @version 1.0
 */
public class DivisionPorCero02 {
	public static void main(String[] args) throws ArithmeticException{
		int a = 0;
		int b = 300;
		int result;
		try {
			result = b / a;
			System.out.println(result);
		}finally{
			System.out.println("Programa Finalizado");
		}
	}
}
