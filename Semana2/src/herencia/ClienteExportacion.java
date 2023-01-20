package herencia;

/**
 * Clase Cliente exportacion que hereda de la clase cliente. 
 * @author m.corchero.blazquez
 *
 */
public class ClienteExportacion extends Cliente{
	private int vat;
	
	//Getters and setter
	public int getVAT() {
		return vat;
	}

	public void setVAT(int vat) {
		this.vat = vat;
	}

	/**
	 * Constructor parametrizado
	 * @param nombre
	 * @param direccion
	 * @param correoElectronico
	 * @param vat
	 */
	public ClienteExportacion(String nombre, String direccion, String correoElectronico, int vat) {
		super(nombre, direccion, correoElectronico);
		setVAT(vat);
	}	
}
