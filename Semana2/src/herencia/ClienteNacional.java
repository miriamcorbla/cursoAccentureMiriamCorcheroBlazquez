package herencia;

/**
 * Cliente Nacional que hereda de la clase cliente
 * @author m.corchero.blazquez
 *
 */
public class ClienteNacional extends Cliente{
	private int nif;

	//Getters and Setters
	public int getNIF() {
		return nif;
	}

	public void setNIF(int nIF) {
		nif = nIF;
	}

	/**
	 * Constructor por defecto 
	 */
	public ClienteNacional() {
		super();
	}
	

}
