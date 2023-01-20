package herencia02.agroalimentaria;

public class CongeladoAire extends ProductoCongelado{
	private int nitrogeno;
	private int oxigeno;
	private int dioxCarbono;
	private int vaporAgua;
	
	public int getNitrogeno() {
		return nitrogeno;
	}
	public void setNitrogeno(int nitrogeno) {
		this.nitrogeno = nitrogeno;
	}
	public int getOxigeno() {
		return oxigeno;
	}
	public void setOxigeno(int oxigeno) {
		this.oxigeno = oxigeno;
	}
	public int getDioxCarbono() {
		return dioxCarbono;
	}
	public void setDioxCarbono(int dioxCarbono) {
		this.dioxCarbono = dioxCarbono;
	}
	public int getVaporAgua() {
		return vaporAgua;
	}
	public void setVaporAgua(int vaporAgua) {
		this.vaporAgua = vaporAgua;
	}
	
	public CongeladoAire() {super();}
	
	@Override
	public void mostrar() {
		System.out.println("Fecha de caducidad: " + getFechaCaducidad() + " Numero de lote: " + getLote() + " Temperatura recomendada: " + getTemperaturaRecomendada() +
				" Nitrogeno: " + getNitrogeno() + " Oxigeno: " + getOxigeno() + 
				" Dioxido de carbono: " + getDioxCarbono() + " Vapor de agua: "+ getVaporAgua());
	}
}
