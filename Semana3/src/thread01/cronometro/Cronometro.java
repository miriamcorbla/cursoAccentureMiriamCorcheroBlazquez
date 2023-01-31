package thread01.cronometro;

/**
 * Clase que, utilizando el método sleep,
 * realiza un cronómetro
 * @author m.corchero.blazquez
 *
 */
public class Cronometro {
	public static void main(String[] args) throws InterruptedException {	
		int tiempo = 1000; // 1 segundo
		
		for(int i = 0; i<24; i++) {
			for(int j = 0; j < 60; j++) {
				for(int k = 0; k < 60; k++) {
					Thread.sleep(tiempo);//dormimos el hilo principal durante un segundo
					System.out.println(String.format("%02d:%02d:%02d", i, j, k)); //imprimimos con el formato indicado
				}
			}
		}
	}
}
