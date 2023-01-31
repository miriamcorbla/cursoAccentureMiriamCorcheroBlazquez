package concurrencia03.synchro;

/**
 * Clase que implementa un método
 * de exclusion mutua, en concreto 
 * utilizando synchronized
 * @author m.corchero.blazquez
 *
 */
public class Sincro implements Runnable{
	static Integer n = 1;
	private String mensaje;
	
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public void run() {
		for(int i = 0; i < 10; i++) {
			synchronized (n) {
				System.out.println(mensaje + " " + n);
				n++; //se espera entrelazado porque no se está aplicando ningún método de EM.
			}
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}			
	}		
}

