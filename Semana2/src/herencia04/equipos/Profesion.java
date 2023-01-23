package herencia04.equipos;

/**
 * Clase padre Profesion
 * @author m.corchero.blazquez
 *
 */
public abstract class Profesion {
	
	private int id;
	private String nombre;
	private String apellidos;
	private int edad;
	
	/**
	 * Método observador del ID
	 * @return ID
	 */
	public int getId() {
		return id;
	}
	/**
	 * Método modificador de ID
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Método observador de nombre
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Método modificador de nombre
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Método observador de apellidos
	 * @return apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}
	/**
	 * Método modificador de apellidos
	 * @param apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	/**
	 * Método observador de edad
	 * @return edad
	 */
	public int getEdad() {
		return edad;
	}
	/**
	 * Método modificador de edad
	 * @param edad
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	/**
	 * Constructor parametrizado. Es protected porque estamos en una clase abstracta, de la que
	 * no se pueden instanciar objetos directamente. Sonar también indica que debe ser protected
	 * @param id
	 * @param nombre
	 * @param apellidos
	 * @param edad
	 */
	protected Profesion(int id, String nombre, String apellidos, int edad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
	}
	
	abstract void concentrarse();
	abstract void viajar();

}
