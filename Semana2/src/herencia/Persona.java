package herencia;

/**
 * Clase persona que se instancia con un nombre, direccion y correo electronico
 * @author m.corchero.blazquez
 *
 */
public abstract class Persona {
	private String nombre;
	private String direccion;
	private String correoElectronico;
	
	//métodos setters y getters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	
	/**
	 * Constructor parametrizado de la clase Persona
	 * @param nombre Nombre de la persona
	 * @param direccion Dirección de la persona
	 * @param correoElectronico Correo de la persona
	 */
	protected Persona(String nombre, String direccion, String correoElectronico) {
		setNombre(nombre);
		setDireccion(direccion);
		setCorreoElectronico(correoElectronico);
	}
	
	protected Persona() {}
	
	//Metodo abstracto indicado a incluir. Dicho en clase.
	abstract String aString();
	
	/**
	 * Crear una persona
	 */
	public void crear() {
		System.out.println("Persona creada");
	}
	
	/**
	 * Borrar una persona
	 */
	public void borrar() {
		System.out.println("Persona borrada");
	}
	
	/**
	 * Enviar un mensaje desde la clase persona
	 */
	public void enviarMensaje() {
		System.out.println("Mensaje enviado desde persona");
	}	

}
