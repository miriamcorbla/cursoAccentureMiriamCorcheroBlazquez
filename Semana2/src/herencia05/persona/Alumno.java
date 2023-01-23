package herencia05.persona;

import java.util.HashSet;
import java.util.Set;

public class Alumno extends Persona{

	private int curso;
	private Set<Asignatura> asignaturas = new HashSet<>();
	
	public int getCurso() {
		return curso;
	}
	public void setCurso(int curso) {
		this.curso = curso;
	}
	
	public Set<Asignatura> getAsignaturas() {
		return asignaturas;
	}
	public void setAsignaturas(Set<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
	protected Alumno(String codigo, String nombre, int edad, String telContacto, int curso, Set<Asignatura> asig) {
		super(codigo, nombre, edad, telContacto);
		setCurso(curso);
		setAsignaturas(asig);
	}
	@Override
	public String mostrar() {
		return super.mostrar() + " "+ getCurso() + " " + getAsignaturas().toString();
	}
	

}
