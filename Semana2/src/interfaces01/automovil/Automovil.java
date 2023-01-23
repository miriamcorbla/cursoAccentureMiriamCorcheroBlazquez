package interfaces01.automovil;

/**
 * Clase padre Automovil
 * @author m.corchero.blazquez
 *
 */
public abstract class Automovil implements ABaseDatos {
	private int numMarchas;
	private int velocidadMax;
	private int numChasis;
	private int numRuedas;
	/**
	 * Método observador del num de marchas
	 * @return numMarchas
	 */
	public int getNumMarchas() {
		return numMarchas;
	}
	/**
	 * Método modificador de num Marchas
	 * @param numMarchas
	 */
	public void setNumMarchas(int numMarchas) {
		this.numMarchas = numMarchas;
	}
	/**
	 * Método observador de velocidad máxima
	 * @return velocidad max
	 */
	public int getVelocidadMax() {
		return velocidadMax;
	}
	/**
	 * Método modificador de velocidad máxima
	 * @param velocidadMax
	 */
	public void setVelocidadMax(int velocidadMax) {
		this.velocidadMax = velocidadMax;
	}
	
	/**
	 * Método observador de num chasis
	 * @return num chasis
	 */
	public int getNumChasis() {
		return numChasis;
	}
	/**
	 * Método modificador de num chasis
	 * @param numChasis
	 */
	public void setNumChasis(int numChasis) {
		this.numChasis = numChasis;
	}
	
	/**
	 * Método observador de num ruedas 
	 * @return num ruedas
	 */
	public int getNumRuedas() {
		return numRuedas;
	}
	/**
	 * Método modificador de num ruedas. Protected por ser clase abstracta
	 * @param numRuedas
	 */
	public void setNumRuedas(int numRuedas) {
		this.numRuedas = numRuedas;
	}
	protected Automovil(int numMarchas, int velocidadMax, int numChasis, int numRuedas) {
		setNumMarchas(numMarchas);
		setVelocidadMax(velocidadMax);
		setNumChasis(numChasis);
		setNumRuedas(numRuedas);
		AccesoBBDD dao = new AccesoBBDD();
		dao.leer(this);
	}
	
	public abstract String anuncio();
	
	public void leer() {
		//convierte sql a dominio
	}
	
	public void grabar () {
		//Convierte dominio a sql
	}
	

}
