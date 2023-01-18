package es.rf.curso.base;

public class Notas {
	
	public static void main(String[] args) {
		int nota = 6;
		switch(nota) {
		case 1: case 2: case 3: case 4:
			System.out.println("Insuficiente");
			break;
		case 5:
			System.out.println("Suficiente");
			break;
		case 6: 
			System.out.println("Bien");
			break;
		case 7: case 8:
			System.out.println("Notable");
			break;
		case 9: case 10:
			System.out.println("Sobresaliente");
		}
	}
}
