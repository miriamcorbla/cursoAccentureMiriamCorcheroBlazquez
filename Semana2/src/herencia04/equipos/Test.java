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
		integrantes.add( new Futbolista(1, "Lucia", "Gomez", 20, 123, "delantero"));
		integrantes.add(new Entrenador(2, "Carla", "Gonzalez", 34, 0231));
		integrantes.add(new Masajista(3, "Lucas", "Rodriguez", 40, "Grado en Fisioterapia", 18));
		
		for(Profesion p : integrantes) {
			p.concentrarse();
			p.viajar();
			if(p instanceof Futbolista) {
				((Futbolista) p).jugarPartido();
			}
			if(p instanceof Entrenador) {
				((Entrenador)p).dirigirEntrenamiento();
				((Entrenador)p).dirigirPartido();
			}
			if(p instanceof Masajista) {
				((Masajista) p).darMasaje();
			}
		}
	}

}
