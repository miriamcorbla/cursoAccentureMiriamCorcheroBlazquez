package ejercicio05;

public class Vuelta {

	public static void main(String[] args) {
		String salida = "";
		
		for(String ele:args){
			salida = salida + ele + " ";
		}
		
		System.out.println("fase-1-------------");	
		System.out.println(salida);
		
		String[] palabras = salida.split(" ");
		int fin = palabras.length;
		String salida2 = "";
		for(int i = fin - 1; i>=0; i--) {
			salida2 = salida2 + palabras[i] + " ";
		}
		
		System.out.println("fase-2-------------");	
		System.out.println(salida2);
		
		int numLongitud = salida.length();
		String salida3 = "";
		for(int a = numLongitud-1; a>=0; a--) {
			salida3 += salida.charAt(a);
		}
		System.out.println("fase-3-------------");
		System.out.println(salida3);
		

		String salida4 = "";
		for(int a = numLongitud-1; a>=0; a--) {
			char caracter = salida.charAt(a);
			switch(caracter) {
			case 'a': case 'A': salida4+=4;
				break;
			case 'e': case 'E': salida4+=3;
			break;
			case 'i': case 'I': salida4+=1;
			break;
			case 'o': case 'O': salida4+=0;
			break;
			case 'u': case 'U': salida4+=9;
			break;
			default:
				salida4+=caracter;
			}
		}
		System.out.println("fase-4-------------");
		System.out.println(salida4);
		
		char delimitador = salida.charAt(0);
		int longitudCadena = 0;

		for (int a = 1; (salida+delimitador).charAt(a) != delimitador; a++) {
			longitudCadena++;
		}
		String salida5 = "";
		String salida6 = "";

		for(int a = longitudCadena; a>=1; a--) {
			salida5 += salida.charAt(a);
		}
		
		for(String ele:args){
			salida6 = salida6 + ele + " ";
		}
		
		System.out.println("fase-5-------------");
		System.out.println(salida6);
		System.out.println(salida5);

		
		salida += (char)0;
		int pos = 0;
		String salida7 = "";
		while(salida.charAt(pos) != (char)0) {
			salida7 = salida.charAt(pos++) + salida7;
		}		
		System.out.println("fase-6-------------");
		System.out.println(salida7);
		
	}
}
