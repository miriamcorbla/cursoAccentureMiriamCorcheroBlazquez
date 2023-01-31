package concurrencia04.monitores;

/**
 * Clase principal para poner en marcha
 * @author m.corchero.blazquez
 *
 */
public class Main {
	static Buffer buf;
	
	public static void main(String[] args) {
		buf = new Buffer();
		buf.setDisponible(false);
		
		GeneraNumeros gn = new GeneraNumeros();
		PresentaNumero pn = new PresentaNumero();
		
		gn.setBuf(buf);
		pn.setBuf(buf);
		
		Thread tgn = new Thread(gn);
		Thread tpn = new Thread(pn);
		
		tgn.start();
		tpn.start();

	}

}
