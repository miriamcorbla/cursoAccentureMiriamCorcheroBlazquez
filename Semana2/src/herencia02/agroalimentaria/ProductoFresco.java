package herencia02.agroalimentaria;

/**
 * Especialización de Productos para producto fresco
 * @author m.corchero.blazquez
 *
 */
public class ProductoFresco extends Productos{
	private String fechaEnvasado;
	private String paisOrigen;
	
	public String getFechaEnvasado() {
		return fechaEnvasado;
	}
	public void setFechaEnvasado(String fechaEnvasado) {
		this.fechaEnvasado = fechaEnvasado;
	}
	public String getPaisOrigen() {
		return paisOrigen;
	}
	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}
	
	public ProductoFresco() {super();}
	
	@Override
	public void mostrar() {
		System.out.println("Fecha de caducidad: " + getFechaCaducidad() + " Numero de lote: " + getLote() + " Fecha envasado: " + getFechaEnvasado() + " Pais Origen: " + getPaisOrigen());
	}
}
