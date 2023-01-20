package herencia02.agroalimentaria;

/**
 * Especialización de productos para producto refrigerado
 * @author m.corchero.blazquez
 *
 */
public class ProductoRefrigerado extends Productos{
	private int codigoOrganismoSA;

	public int getCodigoOrganismoSA() {
		return codigoOrganismoSA;
	}

	public void setCodigoOrganismoSA(int codigoOrganismoSA) {
		this.codigoOrganismoSA = codigoOrganismoSA;
	}
	
	public ProductoRefrigerado() {super();}
	
	@Override
	public void mostrar() {
		System.out.println("Fecha de caducidad: " + getFechaCaducidad() + " Numero de lote: " + getLote() + " Codigo organismo SA: " + getCodigoOrganismoSA());
	}

}
