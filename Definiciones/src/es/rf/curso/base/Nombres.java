package es.rf.curso.base;

public class Nombres {
	/**
	 * Clase que declara variables y le asigna valores. Finalmente, 
	 * imprime por pantalla el valor de la variable nombre y contador
	 * @param args
	 */
	public static void main(String[] args) {
		 int $nombre;
		 int PasaDo;
		 int alcance; //faltaba un punto y coma
		 
		 int _contador;
		 _contador=25;
		 
		 $nombre=_contador;
		 PasaDo=_contador; //Java es sensible a upperCase, luego tenemos que poner exactamente igual el nombre

		 System.out.println($nombre + " / " + _contador);
		 System.out.println("En \"Java\" puede\n que tengamos que utilizar\n caracteres especiales");
	}
}
