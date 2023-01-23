package herencia04.equipos;

/**
 * Clase futbolista que hereda de Profesion
 * @author m.corchero.blazquez
 *
 */
public class Futbolista extends Profesion {

	private int dorsal;
	private String demarcacion;
	
	/**
	 * Método observador de dorsal
	 * @return dorsal
	 */
	public int getDorsal() {
		return dorsal;
	}
	/**
	 * Método modificador de dorsal
	 * @param dorsal
	 */
	public void setDorsal(Integer dorsal) {
		this.dorsal = dorsal;
	}
	/**
	 * Método observador demarcacion
	 * @return posicion demarcacion
	 */
	public String getDemarcacion() {
		return demarcacion;
	}
	/**
	 * Método modificador demarcación
	 * @param demarcacion
	 */
	public void setDemarcacion(String demarcacion) {
		this.demarcacion = demarcacion;
	}
	/**
	 * Constructor parametrizado
	 * @param id
	 * @param nombre
	 * @param apellidos
	 * @param edad
	 * @param dorsal
	 * @param demarcacion
	 */
	public Futbolista(int id, String nombre, String apellidos, int edad, 
			int dorsal, String demarcacion) {
		super(id, nombre, apellidos, edad);
		this.dorsal = dorsal;
		this.demarcacion = demarcacion;
	}
	/**
	 * Método que imprime por pantalla mensaje de concentracion
	 */
	@Override
	void concentrarse() {
		System.out.println("Futbolista " + getNombre() + " está concentrándose");
		
	}
	/**
	 * Método que imprime por pantalla que el futbolista está viajando
	 */
	@Override
	void viajar() {
		System.out.println("Futbolista " + getNombre() + " viajando");
	}
	
	/**
	 * Método que imprime por pantalla que está jugando un partido
	 */
	public void jugarPartido() {
		System.out.println("Futbolista " + getNombre() + " está jugando con el dorsal: " + getDorsal() + 
				" en posicion: " + getDemarcacion());
	}
	
	/**
	 * Futbolista está entrenando
	 */
	public void entrenar() {
		System.out.println("Futbolista " + getNombre() +" entrenando ");
	}
	
	
	
	
}
