package herencia02.agroalimentaria;


/**
 * Clase padre Productos
 * @author m.corchero.blazquez
 *
 */
public abstract class Productos {
	private String fechaCaducidad;
	private int lote;
	
	/**
	 * devuelve la fecha de caducidad
	 * @return fechaCaducidad
	 */
	public String getFechaCaducidad() {
		return fechaCaducidad;
	}
	/**
	 * Método modificador del atributo fechaCaducidad
	 * @param fechaCaducidad
	 */
	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	/**
	 * Método observador del atributo lote
	 * @return lote
	 */
	public int getLote() {
		return lote;
	}
	/**
	 * Método modificador del atributo lote
	 * @param lote
	 */
	public void setLote(int lote) {
		this.lote = lote;
	}
	
	/**
	 * Constructor predeterminado
	 */
	protected Productos() {}
	
	abstract void mostrar();
	

}
