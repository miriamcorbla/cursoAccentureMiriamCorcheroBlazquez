package herencia02.agroalimentaria;

/**
 * Especialización de Productos para producto fresco
 * @author m.corchero.blazquez
 *
 */
public class ProductoFresco extends Productos{
	private String fechaEnvasado;
	private String paisOrigen;
	
	/**
	 * Método observador de fecha de envasado
	 * @return fecha envasado
	 */
	public String getFechaEnvasado() {
		return fechaEnvasado;
	}
	
	/**
	 * Método modificador de fecha de envasado
	 * @param fechaEnvasado
	 */
	public void setFechaEnvasado(String fechaEnvasado) {
		this.fechaEnvasado = fechaEnvasado;
	}
	/**
	 * Método observador de País origen
	 * @return país de origen
	 */
	public String getPaisOrigen() {
		return paisOrigen;
	}
	/**
	 * Método modificador de país de origen
	 * @param paisOrigen
	 */
	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}
	
	/**
	 * Constructor por defecto
	 */
	public ProductoFresco() {super();}
	
	@Override
	public void mostrar() {
		System.out.println("Fecha de caducidad: " + getFechaCaducidad() + " Numero de lote: " + getLote() + " Fecha envasado: " + getFechaEnvasado() + " Pais Origen: " + getPaisOrigen());
	}
}
