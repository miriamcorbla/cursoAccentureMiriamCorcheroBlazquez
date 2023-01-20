package ejercicio04;

/**
 * Clase operadores que realiza operaciones con variables
 * declaradas en el método principal. Posteriormente imprime
 * por pantalla los resultados en el mismo formato
 * que indica el enunciado del ejercicio
 * @author m.corchero.blazquez
 * @version 1.2
 */
public class Operadores {

	public static void main(String[] args) {
		int cantidad;
		int unidades;
		double precio;
		double importe;
		int total;
		double iva = 0.21;
		
		cantidad = 3;
		unidades = 12;
		precio = 5.4;
		importe = cantidad * unidades * precio;
		iva = iva * importe;
		total = (int)(importe * 1.21);
		
		System.out.println("cantidad\t="+cantidad+"\nunidades\t=" +
				unidades+"\nprecio\t="+precio+"\nImporte\t=" + importe +
				"\nIVA\t="+iva+"\nTotal\t="+total+" y deberia ser:\t "+importe * 1.21);

	}

}
