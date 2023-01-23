package herencia04.equipos;

import java.util.ArrayList;

/**
 * Clase principal para realizar las pruebas
 * @author m.corchero.blazquez
 *
 */
public class Test {

	public static void main(String[] args) {
		ArrayList<Profesion> integrantes = new ArrayList<>();
		Futbolista integrante1 = new Futbolista(1, "Lucia", "Gomez", 20, 123, "delantero");
		integrantes.add(integrante1);
		Entrenador integrante2 = new Entrenador(2, "Carla", "Gonzalez", 34, 0231);
		integrantes.add(integrante2);
		Masajista integrante3 = new Masajista(3, "Lucas", "Rodriguez", 40, "Grado en Fisioterapia", 18);
		integrantes.add(integrante3);
		
		for(Profesion p : integrantes) {
			p.concentrarse();
			p.viajar();
		}
		
		integrante1.jugarPartido();
		integrante1.entrenar();
		integrante2.dirigirPartido();
		integrante2.dirigirEntrenamiento();
		integrante3.darMasaje();
		
	}

}
