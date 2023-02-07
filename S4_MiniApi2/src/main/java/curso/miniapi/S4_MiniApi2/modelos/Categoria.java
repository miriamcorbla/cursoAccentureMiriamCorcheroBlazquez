package curso.miniapi.S4_MiniApi2.modelos;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//@Table(name = "CATEGORIA")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id_categoria;
	@Column
	private String cat_nombre;
	@Column
	private String cat_descripcion;
	
	

	public Categoria() {
		super();
		
	}

	public Categoria(long id_categoria, String cat_nombre, String cat_descripcion) {
		super();
		this.id_categoria = id_categoria;
		this.cat_nombre = cat_nombre;
		this.cat_descripcion = cat_descripcion;
	}

	public long getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(long id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getCat_nombre() {
		return cat_nombre;
	}

	public void setCat_nombre(String cat_nombre) {
		this.cat_nombre = cat_nombre;
	}

	public String getCat_descripcion() {
		return cat_descripcion;
	}

	public void setCat_descripcion(String cat_descripcion) {
		this.cat_descripcion = cat_descripcion;
	}

	public void setFregistro(Date date) {

	}

	public void setFactualizar(Date date) {

	}

	@Override
	public String toString() {
		return "Categoria [id_categoria=" + id_categoria + ", cat_nombre=" + cat_nombre + ", cat_descripcion="
				+ cat_descripcion + "]";
	}

}
