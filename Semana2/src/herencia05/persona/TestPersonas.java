package herencia05.persona;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase encargada de las pruebas.
 * Contiene el método principal.
 * @author m.corchero.blazquez
 *
 */
public class TestPersonas {

	public static void main(String[] args) {
		
		Asignatura matematicas = new Asignatura("Matematica", 1);
		Asignatura lengua = new Asignatura("Lengu", 1);
		Asignatura fisica = new Asignatura("Física", 2);
		
		Set<Asignatura> asignaturas = new HashSet<>();
		asignaturas.add(matematicas);
		asignaturas.add(lengua);
		asignaturas.add(fisica);
		
		ArrayList<Persona> personas = new ArrayList<>();
		personas.add( new Alumno("01AL", "Juan", 15, "67819232", 1, asignaturas));
		personas.add(new Profesor("01DOC", "Marta", 35, "65279299346", 18000, "28Dic21"));
		
		for(Persona p : personas) {
			System.out.println(p.mostrar());
		}
		
		
		
		

	}

}
