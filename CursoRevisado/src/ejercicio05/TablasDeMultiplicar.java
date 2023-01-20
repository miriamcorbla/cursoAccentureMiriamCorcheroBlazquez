package ejercicio05;

/**
 * Mostrar por pantalla las tablas de multiplicar del 1 al 10
 * @author m.corchero.blazquez
 * @version 1.0
 */
public class TablasDeMultiplicar {

	public static void main(String[] args) {
		int result; //almacena la multiplicacion
		int numTablas = 10; //max tablas a mostrar
		for(int i = 1; i<=numTablas ; i++) {
			System.out.println("Tabla del " + i);
			System.out.println("--------------");
			for(int j = 1; j<=numTablas; j++) {
				result = i * j; //realiza la multiplicacion del valor i por j
				System.out.println(i + " x " + j + " = " + result); //muestra el resultado
			}
			System.out.println("");
		}
	}
}
