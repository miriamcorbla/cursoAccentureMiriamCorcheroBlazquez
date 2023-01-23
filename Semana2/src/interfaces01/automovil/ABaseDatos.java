package interfaces01.automovil;

public interface ABaseDatos {
	
	/**
	 * Recibe un objeto sql y lo transforma en el correcto
	 */
	void leer();
	/**
	 * Coge la estructura y la transforma en SQL
	 */
	void grabar();

}
