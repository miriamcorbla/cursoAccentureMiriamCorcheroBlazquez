package curso.maven.main;

import java.util.List;

import bbdd.ficheros.controller.CountryController;
import bbdd.ficheros.modelos.Country;


/**
 * Clase principal que contiene el método main
 * @author m.corchero.blazquez
 *
 */
public class App {
	
	private static final String ID_NETHERLANDS = "NL";
	
    /**
     * Lista los paises
     * @param countries
     */
	public static void listar(List<Country> countries) {
		countries.stream().forEach(System.out::println);
	}

	
	
    public static void main( String[] args ) throws Exception {
    	CountryController cCtr = new CountryController();
    	listar(cCtr.leerTodos());
    	
    	System.out.println("**************************");
    	
    	System.out.println(cCtr.leerUno(ID_NETHERLANDS));
    	
    	System.out.println("**************************");
    	
    	Country datos = cCtr.leerUno(ID_NETHERLANDS);
    	datos.setCountry_name("Modificado");    	
    	System.out.println("Rows afectadas: " + cCtr.actualizar(datos));   	
    	
    	System.out.println("**************************");
    	System.out.println(cCtr.leerUno(ID_NETHERLANDS));
    	
    	System.out.println("**************************");
    	
    	Country countryElim = cCtr.leerUno(ID_NETHERLANDS);
    	System.out.println("Rows afectadas: " + cCtr.eliminar(countryElim)); 
    	
    	System.out.println("**************************");
    	Country counInsert = new Country();
    	counInsert.setCountry_id("PR");
    	counInsert.setCountry_name("PRUEBA");
    	counInsert.setRegion_id(""+3);
    	System.out.println("Country: " + cCtr.insertar(counInsert)); 
    	
    	
    	
    }

}
