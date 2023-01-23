package interfaces01.automovil;

public class Moto extends Automovil {

	private int capacidadDeposito;
	
	/**
	 * Método observador de capacidad de depósito
	 * @return capaicdad de depósito
	 */
	public int getCapacidadDeposito() {
		return capacidadDeposito;
	}

	/**
	 * Método modificador de capacidad de deposito
	 * @param capacidadDeposito
	 */
	public void setCapacidadDeposito(int capacidadDeposito) {
		this.capacidadDeposito = capacidadDeposito;
	}
	
	
	/**
	 * Constructor parametrizado de la clase moto
	 * @param numMarchas
	 * @param velocidadMax
	 * @param numChasis
	 * @param numRuedas
	 * @param capacidad
	 */
	public Moto(int numMarchas, int velocidadMax, int numChasis, int numRuedas, int capacidad) {
		super(numMarchas, velocidadMax, numChasis, numRuedas);
		setCapacidadDeposito(capacidad);
	}
	
	@Override
	public String anuncio() {
		return "Moto con capacidad: " + getCapacidadDeposito();
	}
	
}
