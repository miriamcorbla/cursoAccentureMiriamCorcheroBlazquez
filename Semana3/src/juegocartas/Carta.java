package juegocartas;

/**
 * POJO Carta 
 * @author m.corchero.blazquez
 *
 */
public class Carta {
	
	private int numero;
	private String tipo;
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getCarta() {
		return numero + tipo;
	}

}
