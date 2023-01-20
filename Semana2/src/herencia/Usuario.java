package herencia;

/**
 * Clase usuario que hereda de Persona
 * @author m.corchero.blazquez
 *
 */
public class Usuario extends Persona{

	private int codigoUsuario;
	
	//Getters y setters
	public int getCodigoUsuario() {
		return codigoUsuario;
	}
	
	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	
	/**
	 * Constructor de clase parametrizado
	 * @param nombre Nombre de la persona
	 * @param direccion Dirección de la persona
	 * @param correoElectronico Correo electrónico de la persona
	 * @param codigoUsuario Código de usuario de la persona
	 */
	public Usuario(String nombre, String direccion, String correoElectronico, int codigoUsuario) {
		super(nombre, direccion, correoElectronico);
		setCodigoUsuario(codigoUsuario);
	}
	
	/**
	 * Muestra usuario autorizado
	 */
	public void autorizar() {
		System.out.println("Usuario autorizado");
	}
	
	/**
	 * Muestra usuario creado
	 */
	public void crearUsuario() {
		System.out.println("Usuario creado");
	}
	
	/**
	 * Devuelve una cadena con el codigo de usuario
	 */
	@Override
	public String aString() {
		return "El codigo de usuario es: " + getCodigoUsuario();
	}
	
}
