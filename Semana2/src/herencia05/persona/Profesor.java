package herencia05.persona;

public class Profesor extends Persona{

	private float salario;
	private String fecContratacion;
	
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public String getFecContratacion() {
		return fecContratacion;
	}
	public void setFecContratacion(String fecContratacion) {
		this.fecContratacion = fecContratacion;
	}
	
	public Profesor(String codigo, String nombre, int edad, String telContacto, float salario, 
			String fecha) {
		super(codigo, nombre, edad, telContacto);
		setSalario(salario);
		setFecContratacion(fecha);
	}
	
	@Override
	public String mostrar() {
		return super.mostrar() + " "+ getSalario() + " " + getFecContratacion();
	}
	
	
}
