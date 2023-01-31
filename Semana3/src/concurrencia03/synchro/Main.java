package concurrencia03.synchro;

/**
 * Clase principal para probar la clase
 * NoSincro
 * @author m.corchero.blazquez
 *
 */
public class Main {

	public static void main(String[] args) {
		NoSincro s1 = new NoSincro();
		NoSincro s2 = new NoSincro();
		
		s1.setMensaje("Desde 1 ->");
		s2.setMensaje("Desde 2->");
		
		Thread thr1 = new Thread(s1);
		Thread thr2 = new Thread(s2);
		
		thr1.start();
		thr2.start();
	}

}
