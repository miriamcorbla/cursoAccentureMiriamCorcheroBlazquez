package concurrencia03.synchro;

/**
 * Clase principal para probar la clase
 * Sincro
 * @author m.corchero.blazquez
 *
 */
public class MainSincro {

	public static void main(String[] args) {
		Sincro s1 = new Sincro();
		Sincro s2 = new Sincro();
		
		s1.setMensaje("Desde 1 ->");
		s2.setMensaje("Desde 2->");
		
		Thread thr1 = new Thread(s1);
		Thread thr2 = new Thread(s2);
		
		thr1.start();
		thr2.start();
	}

}