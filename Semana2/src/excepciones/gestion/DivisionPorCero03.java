package excepciones.gestion;

/**
 * Clase que define las variables a y b y calcula el cociente de b/a.
 * Controla las excepciones capturándola la clase llamadora
 * y siempre muestra por pantalla un mensaje
 * al finalizar el programa
 * @author m.corchero.blazquez
 * @version 1.0
 */
public class DivisionPorCero03 {
	public static void main(String[] args) throws Exception {
		int a = 0;
		int b = 300;
		int result;
		try {
			result = b / a;
			System.out.println(result);
		}catch(Exception e) {
			throw new Exception("SE HA PRODUCIDO UN ERROR");
		}finally{
			System.out.println("Programa Finalizado");
		}
	}

}
