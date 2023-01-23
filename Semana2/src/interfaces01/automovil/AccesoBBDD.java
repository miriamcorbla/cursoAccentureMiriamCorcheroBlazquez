package interfaces01.automovil;

/**
 * Herramienta para utilizar el acceso de la BBDD. 
 * Estos métodos reciben una interfaz para leer los métodos de la misma
 * que son los que graban y leen en la BBD
 * @author m.corchero.blazquez
 *
 */
public class AccesoBBDD {

	//recibe una interfaz. Necesito que me llegue 
	//algo que contenga el metodo leer o grabar de 
	//objeto que le paso
	public void leer(ABaseDatos obj) {
		//abre bbdd
		//Prepara sql
		//Exe sql
		obj.leer();
		System.out.println("Leído desde BBDD");
	}
	public void grabar(ABaseDatos obj) {
		obj.grabar();
		System.out.println("Grabado en la BBDD");
	}
}
