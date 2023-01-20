package herencia;

/**
 * Clase cliente que hereda de Persona
 * @author m.corchero.blazquez
 *
 */
public class Cliente extends Persona {
	private int numeroCliente;
	private String fecha;
	
	//Getters y setters de los atr. privados
	public int getNumeroCliente() {
		return numeroCliente;
	}
	public void setNumeroCliente(int numeroCliente) {
		this.numeroCliente = numeroCliente;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	/**
	 * Constructor de clase parametrizado
	 * @param nombre Nombre de la persona
	 * @param dirección Direccion de la persona
	 * @param correoElectronico Correo de la persona
	 * @param numeroCliente Número de cliente del cliente
	 * @param fecha Fecha de alta de cliente
	 */
	public Cliente(String nombre, String direccion, String correoElectronico) {
		super(nombre, direccion, correoElectronico);
	}
	
	public Cliente() {}
	
	/**
	 * Muestra la fecha de alta
	 */
	public void verFechaAlta() {
		System.out.println("La fecha es: " + getFecha());
	}
	
	@Override
	/**
	 * Devuelve una cadena con el num. cliente y el nombre
	 */
	public String aString() {
		return "Cliente: " + getNumeroCliente() + " de " + getNombre();
	}
	
	
}
