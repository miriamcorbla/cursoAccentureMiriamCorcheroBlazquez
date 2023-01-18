package es.rf.curso.base;

public class areaCirculo {	
	public static void main(String[] args) {
		float radio, resultadoArea, resultadoLongitud;
		radio = 23f;
		resultadoLongitud = 2 * (float)Math.PI * radio;
		resultadoArea = (float) (Math.PI * Math.pow(radio, 2));
		
		System.out.println("La Longitud es: " + resultadoLongitud);
		System.out.println("El area es: " + resultadoArea);		
	}

}
