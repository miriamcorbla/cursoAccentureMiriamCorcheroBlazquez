package herencia02.agroalimentaria;

/**
 * Especialización de productos para producto refrigerado
 * @author m.corchero.blazquez
 *
 */
public class ProductoRefrigerado extends Productos{
	private int codigoOrganismoSA;

	/**
	 * Método observador que indica el código de organismo
	 * @return código de organismo
	 */
	public int getCodigoOrganismoSA() {
		return codigoOrganismoSA;
	}

	/**
	 * Método modificador de código de organismo
	 * @param codigoOrganismoSA
	 */
	public void setCodigoOrganismoSA(int codigoOrganismoSA) {
		this.codigoOrganismoSA = codigoOrganismoSA;
	}
	
	/**
	 * Constructor por defecto
	 */
	public ProductoRefrigerado() {super();}
	
	@Override
	public void mostrar() {
		System.out.println("Fecha de caducidad: " + getFechaCaducidad() + " Numero de lote: " + getLote() + " Codigo organismo SA: " + getCodigoOrganismoSA());
	}

}
