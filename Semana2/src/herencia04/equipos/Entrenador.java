package herencia04.equipos;

/**
 * Clase que hereda de Profesion
 * @author m.corchero.blazquez
 *
 */
public class Entrenador extends Profesion{
	
	private int idFederacion;

	/**
	 * Método observador de id de Fed.
	 * @return id
	 */
	public int getIdFederacion() {
		return idFederacion;
	}

	/**
	 * Método modificador de id
	 * @param idFederacion
	 */
	public void setIdFederacion(int idFederacion) {
		this.idFederacion = idFederacion;
	}

	/**
	 * Ctor parametrizado
	 * @param id
	 * @param nombre
	 * @param apellidos
	 * @param edad
	 * @param idFederacion
	 */
	public Entrenador(int id, String nombre, String apellidos, int edad, int idFederacion) {
		super(id, nombre, apellidos, edad);
		this.idFederacion = idFederacion;
	}

	/**
	 * Método que imprime por pantalla mensaje de concentracion
	 */
	@Override
	void concentrarse() {
		System.out.println("Entrenador " + getNombre() + " con id federacion: " + getIdFederacion() + 
				" está concentrándose");
		
	}
	/**
	 * Método que imprime por pantalla que el Entrenador está viajando
	 */
	@Override
	void viajar() {
		System.out.println("Entrenador " + getNombre() + " está viajando");
	}
	
	public void dirigirPartido() {
		System.out.println("Entrenador " + getNombre() + " está dirigiendo el partido");
	}
	
	public void dirigirEntrenamiento() {
		System.out.println("Entrenador " + getNombre() + " está dirigiendo el entrenamiento");
	}

}
