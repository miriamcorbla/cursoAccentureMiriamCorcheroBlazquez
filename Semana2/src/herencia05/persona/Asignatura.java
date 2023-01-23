package herencia05.persona;

/**
 * Clase asignatura que contiene los atributos nombre y curso de la misma
 * @author m.corchero.blazquez
 *
 */
public class Asignatura {
	
	private String nombre;
	private int curso;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCurso() {
		return curso;
	}
	public void setCurso(int curso) {
		this.curso = curso;
	}
	public Asignatura(String nombre, int curso) {
		setNombre(nombre);
		setCurso(curso);
	}

}
