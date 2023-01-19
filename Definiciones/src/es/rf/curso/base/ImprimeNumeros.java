package es.rf.curso.base;

//Listar Numeros de 100 al 0 de 23 en 23: 100, 77 54 31 8
public class ImprimeNumeros {
	public static void main(String[] args) {
		int numeros = 100; //numero inicial es 100
		System.out.println(numeros); //lo muestro por pantalla
		while(numeros>0) { //mientras sea mayor que 0
			numeros -= 23; //vamos restando 23
			if(numeros > 0) { //controlamos que no se muestren numeros negativos, porque el ultimo
				//que es el 8 entra n el bucle y realiza una iteración más
				System.out.println(numeros);
			}
		}
	}
}
