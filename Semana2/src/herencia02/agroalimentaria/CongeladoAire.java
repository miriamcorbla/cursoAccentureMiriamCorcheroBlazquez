package herencia02.agroalimentaria;

/**
 * Especialización de congelado para congelado por aire
 * @author m.corchero.blazquez
 *
 */
public class CongeladoAire extends ProductoCongelado{
	private int nitrogeno;
	private int oxigeno;
	private int dioxCarbono;
	private int vaporAgua;
	
	/**
	 * Método observador de Nitrógeno
	 * @return nitrógeno
	 */
	public int getNitrogeno() {
		return nitrogeno;
	}
	/**
	 * Método modificador de nitrógeno
	 * @param nitrogeno
	 */
	public void setNitrogeno(int nitrogeno) {
		this.nitrogeno = nitrogeno;
	}
	
	/**
	 * Método observador de oxígeno
	 * @return oxígeno
	 */
	public int getOxigeno() {
		return oxigeno;
	}
	/**
	 * Método modificador de oxígeno
	 * @param oxigeno
	 */
	public void setOxigeno(int oxigeno) {
		this.oxigeno = oxigeno;
	}
	/**
	 * Método observador de dióxido de carbono
	 * @return dioxido de carbono
	 */
	public int getDioxCarbono() {
		return dioxCarbono;
	}
	/**
	 * Método modificador de dióxido de carbono
	 * @param dioxCarbono
	 */
	public void setDioxCarbono(int dioxCarbono) {
		this.dioxCarbono = dioxCarbono;
	}
	/**
	 * Método observador de vapor de agua
	 * @return vapor de agua
	 */
	public int getVaporAgua() {
		return vaporAgua;
	}
	
	/**
	 * Método modificador de vapor de agua
	 * @param vaporAgua
	 */
	public void setVaporAgua(int vaporAgua) {
		this.vaporAgua = vaporAgua;
	}
	
	/**
	 * Constructor por defecto
	 */
	public CongeladoAire() {super();}
	
	@Override
	public void mostrar() {
		System.out.println("Fecha de caducidad: " + getFechaCaducidad() + " Numero de lote: " + getLote() + " Temperatura recomendada: " + getTemperaturaRecomendada() +
				" Nitrogeno: " + getNitrogeno() + " Oxigeno: " + getOxigeno() + 
				" Dioxido de carbono: " + getDioxCarbono() + " Vapor de agua: "+ getVaporAgua());
	}
}
