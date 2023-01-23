package interfaces01.automovil;

/**
 * Clase hija que hereda de automovil
 * @author m.corchero.blazquez
 *
 */
public class Coche extends Automovil implements CuatroPorCuatro{
	
	private int numPuertas;
	private String color;
	private String marca;

	/**
	 * Método observador num. de puertas
	 * @return num de puertas
	 */
	public int getNumPuertas() {
		return numPuertas;
	}

	/**
	 * Método modificador de num de puertas
	 * @param numPuertas
	 */
	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}
	
	/**
	 * Método observador del color del coche
	 * @return el color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Método modificador de color de coche
	 * @param color
	 */
	public void setColor(String color) {
		this.color = color;
	}
	
	

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Constructor parametrizado de la clase Coche
	 * @param numMarchas
	 * @param velocidadMax
	 * @param numChasis
	 * @param numRuedas
	 * @param color
	 * @param numPuertas
	 */
	public Coche(int numMarchas, int velocidadMax, int numChasis, int numRuedas, String color, int numPuertas,
			String marca) {
		super(numMarchas, velocidadMax, numChasis, numRuedas);
		setNumPuertas(numPuertas);
		setColor(color);
		setMarca(marca);
	}
	
	@Override
	public void activarReductora(boolean activar) {
		if(activar) {
			System.out.println("Activando reductora");
		}else {
			System.out.println("Reductora desactivada");
		}		
	}
	
	@Override
	public String anuncio() {
		return "Coche de color y marca: " + getColor() + "\t" + getMarca();
	}
}
