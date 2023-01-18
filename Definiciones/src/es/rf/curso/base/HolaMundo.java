package es.rf.curso.base;

public class HolaMundo {

	public static void main(String[] args) {
		System.out.println("Hola Mundo"); //imprime hola mundo
		System.out.println("Prueba de tipos"); //imprime prueba de tipos
		char c = 'A';
		double precio = 23.4;
		double iva = 0.16;
		double importeTotal;
		importeTotal = precio*iva+precio;
		System.out.println("Caracter: " + c); //devolverá A
		System.out.println("Equivalencia Unicode: " + (int)c); //Devolvera el equivalente a entero de C es un casteo
		System.out.println("Importe Total =: " + importeTotal); //Devolvera 23.4 * 0.16 y se lo suma a 23.4
		System.out.println("Primavera\nVerano\nOtono\nInvierno"); //Cada estación en una linea dif. Salto de linea
		System.out.println("Lun\tMar\tMier\tJue\tVie"); //Cada dia con tabulacion
		System.out.println("Lun\\Mar\\Mier\\Jue\\Vie"); //Cada dia con una barra invertida
		System.out.println("\"Cocodrilo\""); //cocodrilo entre comillas doble
		
		byte a = 100;
		short ss = a;
		a = (byte)ss; //CASTEO pasando de short a su precedente byte
		System.out.println(a);
		String valor = importeTotal + "";
	}

}
