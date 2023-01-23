package herencia04.equipos;

/**
 * Clase que hereda de profesion
 * @author m.corchero.blazquez
 *
 */
public class Masajista extends Profesion {
	
	private String titulacion;
	private int aniosExperiencia;
	
	/**
	 * Método observador
	 * @return
	 */
	public String getTitulacion() {
		return titulacion;
	}
	/**
	 * Método modificador
	 * @param titulacion
	 */
	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}
	/**
	 * Método observador
	 * @return
	 */
	public int getAniosExperiencia() {
		return aniosExperiencia;
	}
	/**
	 * Método modificador
	 * @param titulacion
	 */
	public void setAniosExperiencia(int aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}
	public Masajista(int id, String nombre, String apellidos, int edad, String titulacion, 
			int aniosExperiencia) {
		super(id, nombre, apellidos, edad);
		this.titulacion = titulacion;
		this.aniosExperiencia = aniosExperiencia;
	}
	/**
	 * Método que imprime por pantalla mensaje de concentracion
	 */
	@Override
	void concentrarse() {
		System.out.println("Masajista " + getNombre() + " con " + getAniosExperiencia() +" está concentrándose");
		
	}
	/**
	 * Método que imprime por pantalla que el Masajista está viajando
	 */
	@Override
	void viajar() {
		System.out.println("Masajista " + getNombre() + " está viajando");
	}
	
	public void darMasaje() {
		System.out.println("Masajista " + getNombre() + " está dando un masaje");
	}
	
	
	
	

}
