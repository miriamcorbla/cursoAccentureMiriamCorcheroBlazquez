package herencia05.persona;

public class Persona {
	
	private String codPersona;
	private String nombre;
	private int edad;
	private String telContacto;
	public String getCodPersona() {
		return codPersona;
	}
	public void setCodPersona(String codPersona) {
		this.codPersona = codPersona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getTelContacto() {
		return telContacto;
	}
	public void setTelContacto(String telContacto) {
		this.telContacto = telContacto;
	}
	
	public Persona(String codigo, String nombre, int edad, String telContacto) {
		setCodPersona(codigo);
		setNombre(nombre);
		setEdad(edad);
		setTelContacto(telContacto);
	}
	
	public String mostrar() {
		return getCodPersona() + " " + getNombre() + " " + getEdad() + " " + getTelContacto();
	}

}
