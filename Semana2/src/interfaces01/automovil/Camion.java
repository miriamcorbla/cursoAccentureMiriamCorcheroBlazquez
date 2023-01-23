package interfaces01.automovil;

/**
 * Clase hija que hereda de Automovil
 * @author m.corchero.blazquez
 *
 */
public class Camion extends Automovil{
	
	private int pesoMax;
	private int precio;
	
	/**
	 * Método observador del peso máximo
	 * @return peso máximo
	 */
	public int getPesoMax() {
		return pesoMax;
	}

	/**
	 * Método observador de peso máximo
	 * @param pesoMax
	 */
	public void setPesoMax(int pesoMax) {
		this.pesoMax = pesoMax;
	}


	/**
	 * Método observador de precio
	 * @return precio
	 */
	public int getPrecio() {
		return precio;
	}

	/**
	 * Método modificador de precio
	 * @param precio
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	/**
	 * Constructor parametrizado de la clase camión
	 * @param numMarchas
	 * @param velocidadMax
	 * @param numChasis
	 * @param numRuedas
	 * @param pesoMax
	 * @param precio
	 */
	public Camion(int numMarchas, int velocidadMax, int numChasis, int numRuedas, int pesoMax, int precio) {
		super(numMarchas, velocidadMax, numChasis, numRuedas);
		setPesoMax(pesoMax);
		setPrecio(precio);
	}

	@Override
	public String anuncio() {
		return "Camion con precio y peso máximo:  " + "\t" +  getNumMarchas() + "\t" + getNumChasis() + "\t" +
	getPrecio() + "\t" + getPesoMax() ;
	}
	

}
