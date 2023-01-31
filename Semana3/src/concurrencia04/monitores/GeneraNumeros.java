package concurrencia04.monitores;

import java.util.Random;

/**
 * Clase que genera numeros aleatorios y se lo manda al buffer
 * @author m.corchero.blazquez
 *
 */
public class GeneraNumeros implements Runnable{
	Buffer buf;
	
	public void setBuf(Buffer buf) {
		this.buf = buf;
	}
	
	public void run() {
		Random num = new Random();
		while(true) {
			buf.setNumero(num.nextInt());
		}
	}

}
