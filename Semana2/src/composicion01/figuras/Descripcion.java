package composicion01.figuras;

public class Descripcion {
	
	private String titulo;
	private String descripcion;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Descripcion(String titulo, String descripcion) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
	}
	
	public void mostrarTexto() {
		System.out.println(getTitulo());
		System.out.println(getDescripcion());
	}
	
	
	

}
