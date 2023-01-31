package concurrencia04.monitores;

/**
 * Clase que recoge numeros aleatorios de buffer
 * @author m.corchero.blazquez
 *
 */
public class PresentaNumero implements Runnable{
	
	Buffer buf;
	
	public void setBuf(Buffer buf) {
		this.buf = buf;
	}
	
	public void run() {
		while(true) {
			System.out.println(buf.getNumero());
		}
	}

}
