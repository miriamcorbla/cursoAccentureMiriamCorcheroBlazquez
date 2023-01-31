package concurrencia04.monitores;

/**
 * Me guarda el dato que genera la clase generadora 
 * y la clase que recoge el dato lo toma de esta clase
 * @author m.corchero.blazquez
 *
 */
public class Buffer {
	
	private boolean disponible;
	private int numero;
	
	public boolean isDisponible() {
		return disponible;
	}
	
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
	public synchronized int getNumero() {
		while(!this.isDisponible()) {
			System.out.println("Esperando numero-");
			try {
				this.wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		setDisponible(false);
		this.notifyAll();
		return numero;
	}
	
	public synchronized void setNumero(int numero) {
		while(this.isDisponible()) {
			System.out.println("Esperando espacio...");
			try {
				this.wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.numero = numero;
		setDisponible(true);
		this.notifyAll();
	}

}
